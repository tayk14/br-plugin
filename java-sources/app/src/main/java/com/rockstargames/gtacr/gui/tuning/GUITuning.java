package com.rockstargames.gtacr.gui.tuning;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.network.CarColorItem;
import blackrussia.online.network.Tune;
import blackrussia.online.network.TuneGuiNode;
import blackrussia.online.network.TuneGuiScreen;
import blackrussia.online.network.TuneVinyls;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.adapters.TuningBoxAdapter;
import com.rockstargames.gtacr.adapters.TuningSubmenuItemsAdapter;
import com.rockstargames.gtacr.common.UIContainer;
import com.rockstargames.gtacr.data.TuningBoxItem;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class GUITuning implements ISAMPGUI, TuningSubmenuItemsAdapter.OnClickSubmenuItem {
    private static final int COLLAPSE = 4;
    private static final int COLORS_LIST = 1;
    private static final int DETAIL_LIST = 2;
    private static final int DIAGNOSTICS = 3;
    private static final String EMPTY_VALUE = "";
    private static final String LOG = "LOG_VIEW";
    private static final int NEW_SUBMENU = 0;
    private static final int SET_DETAIL_WITHOUT_LIST_DETAILS = 5;
    private AddDataForBox addDataForBox;
    private Button backToMainMenu;
    private Button closeSubmenu;
    private UIContainer container;
    private Button exitButton;
    private Handler handler;
    private RelativeLayout headerLayout;
    private TextView headerNameCar;
    private TextView headerValueMoney;
    private LayoutInflater inflater;
    private TuningOpeningBox openingBox;
    private PopupWindow popupWindowResetDetails;
    private ConstraintLayout progressDiagnostic;
    private TuningLogicPopupWindowApply tuningLogicPopupWindowApply;
    private View viewResetDetails;
    private int thisSubmenu = -1;
    private NvEventQueueActivity context = null;
    private View rootView = null;
    private PopupWindow popupWindow = null;
    private GUIManager guiManager = null;
    private Animation anim = null;
    private TuneGuiScreen mActiveScreen = null;
    private TuneGuiNode mActiveNode = null;
    private int mActiveSelectorId = -1;
    private View submenuView = null;
    private PopupWindow popupWindowSubmenu = null;
    private RecyclerView submenuRecycler = null;
    private TuningSubmenuItemsAdapter submenuItemsAdapter = null;
    private List<TuneGuiNode> submenuTunings = new ArrayList();
    private View applyRepeatView = null;
    private PopupWindow popupWindowApplyRepeat = null;
    private int progressStatus = 0;
    private String textPreView = "";
    private View boxView = null;
    private RecyclerView recVListItemsBox = null;
    private PopupWindow popupWindowBox = null;
    private TuningBoxAdapter boxAdapter = null;
    private List<Tune> boxItems = new ArrayList();
    private List<TuningBoxItem> boxNames = new ArrayList();
    private UILayoutTuningMain layoutTuningMain = new UILayoutTuningMain(this);
    private UILayoutTuningViewCar layoutTuningViewCar = new UILayoutTuningViewCar(this);
    private UILayoutTuningDetailsList layoutTuningDetailsList = new UILayoutTuningDetailsList(this);
    private UILayoutTuningColorsList layoutTuningColorsList = new UILayoutTuningColorsList(this);
    private UILayoutTuningCollapse layoutTuningCollapse = new UILayoutTuningCollapse(this);
    private UILayoutTuningViewInfoParameters layoutTuningViewInfoParameters = new UILayoutTuningViewInfoParameters(this);
    private UILayoutTuningDiagnostics layoutTuningDiagnostics = new UILayoutTuningDiagnostics(this);
    private UILayoutTuningRGBColor layoutTuningRGBColor = new UILayoutTuningRGBColor(this);
    private List<Integer> listCorrectDetailsWithIDAndStatus = new ArrayList();
    private List<Integer> listDetailsWithPercent = new ArrayList();
    private List<String> listAllColors = new ArrayList();
    private List<Bitmap> saveVinyls = new ArrayList();
    private List<Integer> listAllCollapse = new ArrayList();
    private int playersMoneyValue = 0;
    private String nameCar = "";
    private int startColor = -1;
    private int layout = -1;
    private String nameThisCheckSubmenu = "";
    private int gosCost = 0;
    private int detailId = -1;
    private int detailStatus = -1;
    private int statusDiagnostic = -1;
    private String getVinyl = "";
    private int idOldInstallDetail = -1;
    private int carID = 0;
    private int typeLayout = -1;

    @Override
    public int getGuiId() {
        return 28;
    }

    public static ISAMPGUI newInstance() {
        return new GUITuning();
    }

    public void saveVinyls(Bitmap bitmap) {
        this.saveVinyls.add(bitmap);
    }

    public Bitmap getThisVinyl(int position) {
        return this.saveVinyls.get(position);
    }

    public int getSizeBitmapVinyls() {
        return this.saveVinyls.size();
    }

    @Override
    public void onPacketIncoming(JSONObject json) {
        int optInt = json.optInt("t");
        int optInt2 = json.optInt("s");
        Log.v(LOG, "key " + optInt + ", value s: " + optInt2);
        if (optInt == 1 || optInt == 2) {
            if (optInt2 != 1) {
                return;
            }
            updateValueMoney(json);
            putPlayersActionToServer(19);
            putPlayersActionToServer(20);
        } else if (optInt == 3) {
            if (optInt2 != 1) {
                return;
            }
            updateValueMoney(json);
            getDetailIDFromServer(json);
            putPlayersActionToServer(19);
            this.layoutTuningDetailsList.updateStatusVinylsAfterEstablished(this.detailId);
            this.getVinyl = getTuneVinyls().getNameVinyl();
        } else if (optInt == 20) {
            getAllColors(json);
            this.layoutTuningColorsList.setStartColor(this.listAllColors);
            this.layoutTuningRGBColor.setStartColor(this.listAllColors);
        } else if (optInt == 26) {
            getStartVinyl(json);
        } else if (optInt == 28) {
            getAllCollapse(json);
            this.layoutTuningCollapse.setStartCollapse(this.listAllCollapse);
        } else {
            String str = "";
            switch (optInt) {
                case 5:
                    if (optInt2 != 1) {
                        return;
                    }
                    int i = this.typeLayout;
                    if (i == 1 || i == 2) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public final void run() {
                                GUITuning.this.lambda$onPacketIncoming$1$GUITuning();
                            }
                        }, 500L);
                        return;
                    } else if (i == 3) {
                        getOldInstallDetailIDFromServer(json);
                        updateStatusDetailsAfterReset(this.idOldInstallDetail);
                        this.layoutTuningDetailsList.updateStatusDetailAfterReset(this.idOldInstallDetail);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public final void run() {
                                GUITuning.this.lambda$onPacketIncoming$2$GUITuning();
                            }
                        }, 500L);
                        return;
                    } else if (i == 4) {
                        this.getVinyl = "";
                        this.layoutTuningDetailsList.resetVinyls();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public final void run() {
                                GUITuning.this.lambda$onPacketIncoming$3$GUITuning();
                            }
                        }, 500L);
                        return;
                    } else {
                        if (i != 5) {
                            return;
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public final void run() {
                                GUITuning.this.lambda$onPacketIncoming$4$GUITuning();
                            }
                        }, 500L);
                        return;
                    }
                case 6:
                    if (optInt2 != 1) {
                        return;
                    }
                    listenerClickApplyDiagnostic();
                    this.statusDiagnostic = 1;
                    getStatusDetailsFromServer(json);
                    updateValueMoney(json);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public final void run() {
                            GUITuning.this.lambda$onPacketIncoming$0$GUITuning();
                        }
                    }, 2100L);
                    return;
                case 7:
                    if (optInt2 != 1) {
                        return;
                    }
                    updateValueMoney(json);
                    getDetailIDFromServer(json);
                    getOldInstallDetailIDFromServer(json);
                    this.layoutTuningDetailsList.updateStatusDetailAfterEstablished(this.detailId, this.idOldInstallDetail);
                    putPlayersActionToServer(19);
                    updateStatusDetailsAfterInstall(this.detailId, this.idOldInstallDetail);
                    return;
                case 8:
                    if (optInt2 != 1) {
                        return;
                    }
                    updateValueMoney(json);
                    getDetailIDFromServer(json);
                    this.layoutTuningDiagnostics.updateStatusDetail(this.detailId);
                    return;
                case 9:
                    if (optInt2 != 1) {
                        return;
                    }
                    this.layoutTuningDiagnostics.getPopupApplyRepair();
                    return;
                case 10:
                    if (optInt2 != 1) {
                        return;
                    }
                    getDetailIDFromServer(json);
                    getOldInstallDetailIDFromServer(json);
                    this.layoutTuningDetailsList.updateStatusDetailAfterEstablished(this.detailId, this.idOldInstallDetail);
                    putPlayersActionToServer(19);
                    updateStatusDetailsAfterInstall(this.detailId, this.idOldInstallDetail);
                    return;
                case 11:
                    if (optInt2 == 0) {
                        this.openingBox.setStatusOpeningBox(0);
                        return;
                    } else if (optInt2 != 1) {
                        return;
                    } else {
                        this.openingBox.setStatusOpeningBox(1);
                        this.openingBox.isTrueOpeningBox();
                        updateValueMoney(json);
                        getDetailIDFromServer(json);
                        this.layoutTuningDetailsList.updateStatusDetailAfterPurchase(this.detailId);
                        String str2 = "";
                        for (int i2 = 0; i2 < this.addDataForBox.getAllNameInBox().size(); i2++) {
                            if (this.addDataForBox.getAllNameInBox().get(i2).getId() == this.detailId) {
                                String[] split = new Scanner(this.addDataForBox.getAllNameInBox().get(i2).getName()).nextLine().split(" ");
                                String str3 = split[0];
                                str2 = split[1];
                                str = str3;
                            }
                        }
                        this.openingBox.setDataOpeningBox(str, str2);
                        updateStatusDetailsAfterBought(this.detailId, 1);
                        return;
                    }
                case 12:
                    if (optInt2 != 1) {
                        return;
                    }
                    updateValueMoney(json);
                    putPlayersActionToServer(19);
                    putPlayersActionToServer(28);
                    return;
                default:
                    return;
            }
        }
    }

    public void lambda$onPacketIncoming$0$GUITuning() {
        this.layoutTuningDiagnostics.setStatusDiagnosticAndChangeParameters(1);
        this.layoutTuningDiagnostics.setStartParameters(this.listDetailsWithPercent);
    }

    public void lambda$onPacketIncoming$1$GUITuning() {
        putPlayersActionToServer(19);
        putPlayersActionToServer(20);
        this.layoutTuningColorsList.resetColorParameters();
    }

    public void lambda$onPacketIncoming$2$GUITuning() {
        putPlayersActionToServer(19);
    }

    public void lambda$onPacketIncoming$3$GUITuning() {
        putPlayersActionToServer(19);
    }

    public void lambda$onPacketIncoming$4$GUITuning() {
        putPlayersActionToServer(19);
        putPlayersActionToServer(28);
    }

    private void updateValueMoney(JSONObject json) {
        setMoneyInTitle(GUIManager.getPriceWithSpaces(json.optInt("m")));
    }

    private void updateStatusDetailsAfterBought(int idDetail, int location) {
        int i = 0;
        boolean z = false;
        int i2 = 1;
        while (i < this.listCorrectDetailsWithIDAndStatus.size()) {
            if (this.listCorrectDetailsWithIDAndStatus.get(i).intValue() == idDetail) {
                this.listCorrectDetailsWithIDAndStatus.set(i2, Integer.valueOf(location));
                z = true;
            }
            i += 2;
            i2 += 2;
        }
        if (z) {
            return;
        }
        this.listCorrectDetailsWithIDAndStatus.add(Integer.valueOf(idDetail));
        this.listCorrectDetailsWithIDAndStatus.add(Integer.valueOf(location));
    }

    private void updateStatusDetailsAfterInstall(int idNewDetail, int idOldDetail) {
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 1;
        while (i2 < this.listCorrectDetailsWithIDAndStatus.size()) {
            if (this.listCorrectDetailsWithIDAndStatus.get(i2).intValue() == idNewDetail) {
                this.listCorrectDetailsWithIDAndStatus.set(i3, 2);
                z = true;
            }
            i2 += 2;
            i3 += 2;
        }
        if (z) {
            int i4 = 1;
            while (i < this.listCorrectDetailsWithIDAndStatus.size()) {
                if (this.listCorrectDetailsWithIDAndStatus.get(i).intValue() == idOldDetail) {
                    this.listCorrectDetailsWithIDAndStatus.set(i4, 1);
                }
                i += 2;
                i4 += 2;
            }
        }
    }

    private void updateStatusDetailsAfterReset(int idOldDetail) {
        int i = 0;
        int i2 = 1;
        while (i < this.listCorrectDetailsWithIDAndStatus.size()) {
            if (this.listCorrectDetailsWithIDAndStatus.get(i).intValue() == idOldDetail) {
                this.listCorrectDetailsWithIDAndStatus.set(i2, 1);
            }
            i += 2;
            i2 += 2;
        }
    }

    public List<Integer> getCorrectSelectorsOld(List<Integer> selectorsFromDef1) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i = 0; i < this.listCorrectDetailsWithIDAndStatus.size(); i += 2) {
            for (int i2 = 0; i2 < App.getInstance().getTuneItems().size(); i2++) {
                if (this.listCorrectDetailsWithIDAndStatus.get(i).intValue() == App.getInstance().getTuneItems().get(i2).getId()) {
                    linkedHashSet.add(Integer.valueOf(App.getInstance().getTuneItems().get(i2).getSelector()));
                }
            }
        }
        linkedHashSet.addAll(selectorsFromDef1);
        return new ArrayList(linkedHashSet);
    }

    public List<Integer> getCorrectSelectors() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList<Tune> tuneItems = App.getInstance().getTuneItems();
        for (int i = 0; i < tuneItems.size(); i++) {
            if (tuneItems.get(i).getDef() == 1) {
                linkedHashSet.add(Integer.valueOf(tuneItems.get(i).getSelector()));
            }
        }
        return new ArrayList(linkedHashSet);
    }

    public List<Tune> getTuneItemsForSelector(int selector) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < App.getInstance().getTuneItems().size(); i++) {
            if (App.getInstance().getTuneItems().get(i).getSelector() == selector) {
                arrayList.add(App.getInstance().getTuneItems().get(i));
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((Tune) arrayList.get(i2)).setCost(new AddCostForAllDetails(this).getDetailPrice(((Tune) arrayList.get(i2)).getType(), getGosCost(), ((Tune) arrayList.get(i2)).getTuneId()));
        }
        return arrayList;
    }

    public List<Tune> setCorrectDetailsListFormatTune(List<Integer> listCorrectDetailsWithCostAndStatus, List<Tune> detailsItems) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < detailsItems.size(); i++) {
            int id = detailsItems.get(i).getId();
            int i2 = 1;
            if (detailsItems.get(i).getDef() == 1) {
                int i3 = 0;
                while (i3 < listCorrectDetailsWithCostAndStatus.size()) {
                    if (id == listCorrectDetailsWithCostAndStatus.get(i3).intValue()) {
                        detailsItems.get(i).setThisLocation(listCorrectDetailsWithCostAndStatus.get(i2).intValue());
                    }
                    i3 += 2;
                    i2 += 2;
                }
                arrayList.add(detailsItems.get(i));
            } else {
                int i4 = 0;
                while (i4 < listCorrectDetailsWithCostAndStatus.size()) {
                    int intValue = listCorrectDetailsWithCostAndStatus.get(i4).intValue();
                    int intValue2 = listCorrectDetailsWithCostAndStatus.get(i2).intValue();
                    if (id == intValue) {
                        detailsItems.get(i).setThisLocation(intValue2);
                        arrayList.add(detailsItems.get(i));
                    }
                    i4 += 2;
                    i2 += 2;
                }
            }
        }
        Log.v(LOG, "correctDetailsList size = " + arrayList.size());
        return arrayList;
    }

    private TuneGuiNode getParentGuiNodeForChild(TuneGuiNode root, TuneGuiNode child) {
        if (root.getNames() == null) {
            return null;
        }
        if (root.getNames().contains(child)) {
            return root;
        }
        for (int i = 0; i < root.getNames().size(); i++) {
            TuneGuiNode parentGuiNodeForChild = getParentGuiNodeForChild(root.getNames().get(i), child);
            if (parentGuiNodeForChild != null) {
                return parentGuiNodeForChild;
            }
        }
        return null;
    }

    private TuneGuiNode getParentGuiNodeForChild(TuneGuiScreen root, TuneGuiNode child) {
        if (root.getFooter() == null) {
            return null;
        }
        for (int i = 0; i < root.getFooter().size(); i++) {
            TuneGuiNode parentGuiNodeForChild = getParentGuiNodeForChild(root.getFooter().get(i), child);
            if (parentGuiNodeForChild != null) {
                return parentGuiNodeForChild;
            }
        }
        return null;
    }

    public Drawable getDrawableByName(String name) {
        int identifier = this.context.getResources().getIdentifier(name, "drawable", this.context.getPackageName());
        if (identifier == 0) {
            return ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.back2, null);
        }
        return ResourcesCompat.getDrawable(this.context.getResources(), identifier, null);
    }

    public NvEventQueueActivity getNvContext() {
        return this.context;
    }

    public void closeAndroidsInterface() {
        this.context.getParentLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    GUIManager.hideSystemUI(GUITuning.this.popupWindow.getContentView());
                } catch (Exception unused) {
                    GUITuning.this.context.getParentLayout().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            GUIManager.hideSystemUI(GUITuning.this.popupWindow.getContentView());
                        }
                    }, 1000L);
                }
            }
        }, 300L);
    }

    @Override
    public void show(JSONObject json, GUIManager manager, final NvEventQueueActivity activity) {
        this.context = activity;
        this.guiManager = manager;
        closeAndroidsInterface();
        this.mActiveScreen = App.getInstance().getTuneGuiScreens().get(json.optInt("w"));
        if (this.popupWindow == null) {
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
            this.inflater = layoutInflater;
            View inflate = layoutInflater.inflate(R.layout.tuning_dialog, (ViewGroup) this.context.getParentLayout(), false);
            this.rootView = inflate;
            this.headerValueMoney = (TextView) inflate.findViewById(R.id.value_players_money);
            this.headerNameCar = (TextView) this.rootView.findViewById(R.id.title_this_car);
            this.exitButton = (Button) this.rootView.findViewById(R.id.header_exit);
            this.backToMainMenu = (Button) this.rootView.findViewById(R.id.header_back_to_main_menu);
            View inflate2 = this.inflater.inflate(R.layout.tuning_submenu_view, (ViewGroup) this.context.getParentLayout(), false);
            this.submenuView = inflate2;
            this.submenuRecycler = (RecyclerView) inflate2.findViewById(R.id.recv_submenu_items);
            this.closeSubmenu = (Button) this.submenuView.findViewById(R.id.tuning_submenu_close);
            this.popupWindowSubmenu = new PopupWindow(this.submenuView, -1, -1, true);
            this.applyRepeatView = this.inflater.inflate(R.layout.tuning_submenu_apply, (ViewGroup) null, false);
            this.popupWindowApplyRepeat = new PopupWindow(this.applyRepeatView, -1, -1, true);
            this.popupWindow = new PopupWindow(this.rootView, -1, -1, true);
            this.headerLayout = (RelativeLayout) this.rootView.findViewById(R.id.header_tuning);
            this.progressDiagnostic = (ConstraintLayout) this.rootView.findViewById(R.id.process_diagnostic);
            this.viewResetDetails = this.inflater.inflate(R.layout.tuning_reset_apply, (ViewGroup) null, false);
            this.popupWindowResetDetails = new PopupWindow(this.viewResetDetails, -1, -1, true);
            createNewBoxesView(this.inflater);
            this.anim = AnimationUtils.loadAnimation(this.context, R.anim.button_click);
            UIContainer uIContainer = (UIContainer) this.rootView.findViewById(R.id.my_container);
            this.container = uIContainer;
            uIContainer.addLayout(0, this.layoutTuningMain);
            this.container.addLayout(1, this.layoutTuningViewCar);
            this.container.addLayout(4, this.layoutTuningDetailsList);
            this.container.addLayout(5, this.layoutTuningColorsList);
            this.container.addLayout(8, this.layoutTuningRGBColor);
            this.container.addLayout(9, this.layoutTuningCollapse);
            this.container.addLayout(10, this.layoutTuningViewInfoParameters);
            this.container.addLayout(12, this.layoutTuningDiagnostics);
            this.container.setCurrentLayout(0);
            putPlayersActionToServer(19);
            for (int i = 0; i < App.getInstance().getTuneItems().size(); i++) {
                App.getInstance().getTuneItems().get(i).setThisLocation(0);
            }
            getNameCar(json);
            setNameCarInTitle(this.nameCar);
            getValueMoneyFromServer(json);
            setMoneyInTitle(GUIManager.getPriceWithSpaces(this.playersMoneyValue));
            getStatusDetailsFromServer(json);
            getStatusDiagnosticFromServer(json);
            getDetailsListAndInfoFromServer(json);
            getGosCostFromServer(json);
            getCarID(json);
            this.exitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUITuning.this.lambda$show$6$GUITuning(view);
                }
            });
            this.backToMainMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUITuning.this.lambda$show$8$GUITuning(view);
                }
            });
            this.closeSubmenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUITuning.this.lambda$show$10$GUITuning(view);
                }
            });
            this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public final void onDismiss() {
                    GUITuning.this.lambda$show$11$GUITuning();
                }
            });
            //this.context.toggleDrawing2dStuff(true);
        }
        activity.getParentLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    GUIManager.hideSystemUI(GUITuning.this.popupWindow.getContentView());
                } catch (Exception unused) {
                    activity.getParentLayout().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            GUIManager.hideSystemUI(GUITuning.this.popupWindow.getContentView());
                        }
                    }, 1000L);
                }
            }
        }, 300L);
        this.popupWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                GUITuning.this.lambda$show$12$GUITuning();
            }
        }, 500L);
    }

    public void lambda$show$6$GUITuning(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                GUITuning.this.lambda$null$5$GUITuning();
            }
        }, 250L);
    }

    public void lambda$null$5$GUITuning() {
        this.popupWindow.dismiss();
    }

    public void lambda$show$8$GUITuning(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                GUITuning.this.lambda$null$7$GUITuning();
            }
        }, 250L);
    }

    public void lambda$null$7$GUITuning() {
        listenerLayout(0);
        putPlayersActionToServer(17);
        clearStatusForAllMenu();
    }

    public void lambda$show$10$GUITuning(View submenuView) {
        submenuView.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                GUITuning.this.lambda$null$9$GUITuning();
            }
        }, 250L);
    }

    public void lambda$null$9$GUITuning() {
        this.popupWindowSubmenu.dismiss();
        this.layoutTuningMain.setVisibleMainView(true);
    }

    public void lambda$show$11$GUITuning() {
        clearStatusForAllMenu();
        putPlayersActionToServer(0);
        //this.context.toggleDrawing2dStuff(false);
        this.guiManager.closeGUI(null, 28);
    }

    public void lambda$show$12$GUITuning() {
        putPlayersActionToServer(20);
        putPlayersActionToServer(26);
        putPlayersActionToServer(28);
    }

    private void clearStatusForAllMenu() {
        putPlayersActionToServer(18);
        this.layoutTuningDetailsList.setEmptyObjectForDetail();
        this.layoutTuningColorsList.setEmptyObject();
        this.layoutTuningCollapse.setEmptyValueCorner();
        this.layoutTuningColorsList.setEmptyTransparency();
        this.layoutTuningRGBColor.setEmptyRGBColor();
        this.layoutTuningDetailsList.setEmptyObjectForVinyl();
    }

    public void backToSubmenu() {
        if (this.thisSubmenu != -1) {
            this.mActiveNode = getParentGuiNodeForChild(this.mActiveScreen, this.mActiveNode);
            showSubmenu();
        } else {
            listenerLayout(0);
        }
        clearStatusForAllMenu();
    }

    public TuneGuiScreen getActiveScreen() {
        return this.mActiveScreen;
    }

    public List<Integer> getCorrectList() {
        return this.listCorrectDetailsWithIDAndStatus;
    }

    public void listenerLayout(int idLayout) {
        switch (idLayout) {
            case 0:
                this.container.setCurrentLayout(0);
                this.layoutTuningMain.setVisibleMainView(true);
                this.backToMainMenu.setVisibility(4);
                closeAndroidsInterface();
                return;
            case 1:
                this.container.setCurrentLayout(1);
                putPlayersActionToServer(27);
                this.backToMainMenu.setVisibility(0);
                closeAndroidsInterface();
                return;
            case 2:
                if (this.submenuTunings.size() == 0) {
                    putPlayersActionToServer(4);
                    return;
                }
                showSubmenu();
                this.submenuItemsAdapter = new TuningSubmenuItemsAdapter(this, this.context, this.submenuTunings, this);
                setDataSubmenuInVIew();
                return;
            case 3:
                this.container.setCurrentLayout(4);
                this.layoutTuningDetailsList.setNameThisWindow(getThisNameWindow());
                this.layoutTuningDetailsList.setActiveSelectorId(this.mActiveSelectorId);
                int i = this.mActiveSelectorId;
                if (i == 2) {
                    this.layoutTuningDetailsList.setNewParametersWithVinyls();
                    this.layoutTuningDetailsList.setStartVinyl(this.getVinyl);
                } else {
                    List<Tune> correctDetailsListFormatTune = setCorrectDetailsListFormatTune(this.listCorrectDetailsWithIDAndStatus, getTuneItemsForSelector(i));
                    for (int i2 = 0; i2 < correctDetailsListFormatTune.size(); i2++) {
                        Log.v(LOG, "newDetailsList [" + i2 + "] name: " + correctDetailsListFormatTune.get(i2).getName() + ", id: " + correctDetailsListFormatTune.get(i2).getId());
                    }
                    this.layoutTuningDetailsList.setNewParametersInDetailList(correctDetailsListFormatTune);
                }
                this.backToMainMenu.setVisibility(0);
                closeAndroidsInterface();
                return;
            case 4:
                this.container.setCurrentLayout(4);
                this.layoutTuningDetailsList.setNameThisWindow(getThisNameWindow());
                this.backToMainMenu.setVisibility(0);
                closeAndroidsInterface();
                return;
            case 5:
                this.container.setCurrentLayout(5);
                this.backToMainMenu.setVisibility(0);
                this.layoutTuningRGBColor.setStartParameters(this.mActiveSelectorId);
                this.layoutTuningColorsList.setStartParameters(this.mActiveSelectorId);
                this.layoutTuningColorsList.setStartColor(this.listAllColors);
                this.layoutTuningRGBColor.setStartColor(this.listAllColors);
                closeAndroidsInterface();
                return;
            case 6:
                this.container.setCurrentLayout(5);
                this.backToMainMenu.setVisibility(0);
                this.layoutTuningRGBColor.isNotThisLayout();
                closeAndroidsInterface();
                return;
            case 7:
            case 13:
            default:
                return;
            case 8:
                this.container.setCurrentLayout(8);
                this.backToMainMenu.setVisibility(0);
                this.layoutTuningRGBColor.isThisLayout();
                closeAndroidsInterface();
                return;
            case 9:
                this.container.setCurrentLayout(9);
                this.layoutTuningCollapse.setActiveSelectorId(this.mActiveSelectorId);
                this.layoutTuningCollapse.setNameChangeParameter(getThisNameWindow());
                this.layoutTuningCollapse.setStartParameters(this.listAllCollapse);
                this.backToMainMenu.setVisibility(0);
                closeAndroidsInterface();
                return;
            case 10:
                this.container.setCurrentLayout(10);
                this.backToMainMenu.setVisibility(0);
                closeAndroidsInterface();
                return;
            case 11:
                setViewOpeningBox();
                return;
            case 12:
                this.container.setCurrentLayout(12);
                this.layoutTuningDiagnostics.setStatusDiagnosticAndChangeParameters(this.statusDiagnostic);
                this.layoutTuningDiagnostics.setStartParameters(this.listDetailsWithPercent);
                closeAndroidsInterface();
                return;
            case 14:
                this.container.setCurrentLayout(9);
                this.backToMainMenu.setVisibility(0);
                closeAndroidsInterface();
                return;
        }
    }

    public void applyBuyNewItem(int action, int cost, String currency, int selectorId, int typeMenu) {
        this.tuningLogicPopupWindowApply = new TuningLogicPopupWindowApply(this, this.applyRepeatView, this.context, typeMenu);
        this.popupWindowApplyRepeat.showAtLocation(this.context.getParentLayout(), 17, 0, 0);
        GUIManager.hideSystemUI(this.applyRepeatView);
        this.tuningLogicPopupWindowApply.setSelectorId(selectorId);
        this.tuningLogicPopupWindowApply.setDataInPopupWindow(action, cost, currency);
        this.tuningLogicPopupWindowApply.startWindow();
    }

    public int getRepairDetail() {
        return this.layoutTuningDiagnostics.getThisRepairDetail();
    }

    public String getHexValueColorTransparency() {
        return this.layoutTuningColorsList.getHexValueColorTransparency();
    }

    public String getColor() {
        return this.layoutTuningRGBColor.getColor();
    }

    public boolean isRGBColor() {
        return this.layoutTuningRGBColor.isRBGColor();
    }

    public void closeApplyWindow() {
        this.popupWindowApplyRepeat.dismiss();
        closeAndroidsInterface();
    }

    public void listenerClickApplyDiagnostic() {
        this.layoutTuningDiagnostics.startDiagnostic();
    }

    public Tune getDetailItem() {
        return this.layoutTuningDetailsList.getBuyThisDetail();
    }

    public CarColorItem getColorItem() {
        return this.layoutTuningColorsList.getBuyThisColor();
    }

    public String getColorWithTransparency() {
        return this.layoutTuningColorsList.getColorItem();
    }

    public int getCollapse() {
        return this.layoutTuningCollapse.getCollapse();
    }

    public TuneVinyls getTuneVinyls() {
        return this.layoutTuningDetailsList.getTuneVinyl();
    }

    public void setEmptyThisSubmenu() {
        this.thisSubmenu = -1;
    }

    public void saveLayoutForViewCar(int layout) {
        this.layout = layout;
    }

    private void setNamesForBox(List<TuningBoxItem> fullList) {
        this.boxNames.clear();
        this.boxNames.addAll(fullList);
    }

    public List<TuningBoxItem> getNamesForBox() {
        return this.boxNames;
    }

    public void listenerButtonBackFromViewCar() {
        if (this.thisSubmenu != -1) {
            int i = this.layout;
            if (i == 4) {
                listenerLayout(4);
                return;
            } else if (i == 5) {
                listenerLayout(6);
                return;
            } else if (i == 8) {
                listenerLayout(8);
                return;
            } else if (i != 14) {
                return;
            } else {
                listenerLayout(14);
                return;
            }
        }
        listenerLayout(0);
    }

    private RecyclerView.LayoutManager setVerticalGridLayout() {
        return new GridLayoutManager(this.rootView.getContext(), 3);
    }

    public void setDataInNewSubmenu(List<TuneGuiNode> selectedNodesList) {
        this.submenuTunings.clear();
        this.submenuTunings.addAll(selectedNodesList);
    }

    private void showSubmenu() {
        listenerLayout(0);
        this.layoutTuningMain.setVisibleMainView(false);
        this.popupWindowSubmenu.showAtLocation(this.context.getParentLayout(), 17, 0, 0);
        GUIManager.hideSystemUI(this.submenuView);
    }

    private void setDataSubmenuInVIew() {
        this.submenuRecycler.setLayoutManager(setVerticalGridLayout());
        this.submenuRecycler.setAdapter(this.submenuItemsAdapter);
    }

    @Override
    public void click(TuneGuiNode submenuTuning, int getPosition, View view) {
        view.startAnimation(this.anim);
        TuneGuiNode tuneGuiNode = this.layoutTuningMain.getSelectedNodesList().get(getPosition);
        this.mActiveSelectorId = tuneGuiNode.getSelectorId();
        this.thisSubmenu = tuneGuiNode.getOpensType();
        this.nameThisCheckSubmenu = tuneGuiNode.getName();
        putSelectorToClient(21, this.mActiveSelectorId);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                GUITuning.this.lambda$click$13$GUITuning();
            }
        }, 250L);
    }

    public void lambda$click$13$GUITuning() {
        setClickSubmenu(this.thisSubmenu);
    }

    private String getThisNameWindow() {
        return this.nameThisCheckSubmenu;
    }

    public void setClickSubmenu(int typeList) {
        if (typeList == 1) {
            listenerLayout(5);
        } else if (typeList == 2) {
            listenerLayout(3);
        } else if (typeList == 4) {
            listenerLayout(9);
        }
        this.popupWindowSubmenu.dismiss();
    }

    public void setClickMainMenu(int typeList) {
        if (typeList != 3) {
            return;
        }
        setEmptyThisSubmenu();
        listenerLayout(12);
    }

    public void startDiagnostic() {
        this.progressDiagnostic.setVisibility(0);
        final ProgressBar progressBar = (ProgressBar) this.rootView.findViewById(R.id.tuning_progress_bar);
        final TextView textView = (TextView) this.rootView.findViewById(R.id.progress_value_percent);
        this.handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public final void run() {
                GUITuning.this.lambda$startDiagnostic$16$GUITuning(progressBar, textView);
            }
        }).start();
    }

    public void lambda$startDiagnostic$16$GUITuning(final ProgressBar progressBar, final TextView viewValueProgress) {
        while (true) {
            int i = this.progressStatus;
            if (i < 100) {
                this.progressStatus = i + 1;
                SystemClock.sleep(20L);
                this.handler.post(new Runnable() {
                    @Override
                    public final void run() {
                        GUITuning.this.lambda$null$14$GUITuning(progressBar, viewValueProgress);
                    }
                });
            } else {
                this.handler.post(new Runnable() {
                    @Override
                    public final void run() {
                        GUITuning.this.lambda$null$15$GUITuning();
                    }
                });
                return;
            }
        }
    }

    public void lambda$null$14$GUITuning(final ProgressBar progressBar, final TextView viewValueProgress) {
        progressBar.setProgress(this.progressStatus);
        String str = this.progressStatus + "%";
        this.textPreView = str;
        viewValueProgress.setText(str);
    }

    public void lambda$null$15$GUITuning() {
        SystemClock.sleep(200L);
        this.progressDiagnostic.setVisibility(4);
        this.progressStatus = 0;
    }

    private void createNewBoxesView(LayoutInflater inflater) {
        this.boxView = inflater.inflate(R.layout.tuning_submenu_box, (ViewGroup) null, false);
    }

    private void setViewOpeningBox() {
        AddDataForBox addDataForBox = new AddDataForBox(this);
        this.addDataForBox = addDataForBox;
        addDataForBox.startAddDataForBoxOperations();
        setNamesForBox(this.addDataForBox.getAllNameInBox());
        if (this.openingBox == null || getStatusBox() == 0) {
            createNewBoxesView(this.inflater);
        }
        int i = -1;
        this.popupWindowBox = new PopupWindow(this.boxView, -1, -1, true);
        int i2 = 0;
        if (getDetailItem() != null) {
            i2 = getDetailItem().getCost();
            i = getDetailItem().getCurrency();
        }
        TuningOpeningBox tuningOpeningBox = new TuningOpeningBox(this, this.boxView, this.context);
        this.openingBox = tuningOpeningBox;
        tuningOpeningBox.startOpeningBox(i2, i);
        this.headerLayout.setVisibility(4);
        showPopupWindowBox();
    }

    public int getStatusBox() {
        return this.openingBox.getStatusOpeningBox();
    }

    public void closeBoxCardView() {
        this.popupWindowBox.dismiss();
        this.headerLayout.setVisibility(0);
        this.layoutTuningViewInfoParameters.setVisibleThisWindow(true);
        this.layoutTuningDetailsList.setVisibleBody(true);
        closeAndroidsInterface();
    }

    public void showPopupWindowBox() {
        this.popupWindowBox.showAtLocation(this.context.getParentLayout(), 17, 0, 0);
        GUIManager.hideSystemUI(this.boxView);
    }

    public int setCost(int mActiveSelectorId) {
        double d = 0;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7 = 0.01d;
        if (mActiveSelectorId != 0 && mActiveSelectorId != 1) {
            if (mActiveSelectorId != 2) {
                if (mActiveSelectorId != 3 && mActiveSelectorId != 4) {
                    if (mActiveSelectorId != 32) {
                        switch (mActiveSelectorId) {
                            case 10:
                                double d8 = this.gosCost;
                                Double.isNaN(d8);
                                d = (d8 * 0.02d) + 20000.0d;
                                break;
                            case 11:
                            case 12:
                            case 13:
                                break;
                            default:
                                d7 = 0.05d;
                                switch (mActiveSelectorId) {
                                    case 22:
                                        d3 = this.gosCost;
                                        d4 = 0.1d;
                                        Double.isNaN(d3);
                                        d = (d3 * d4) + 40000.0d;
                                        break;
                                    case 23:
                                        double d9 = this.gosCost;
                                        Double.isNaN(d9);
                                        d5 = d9 * 0.07d;
                                        d6 = 30000.0d;
                                        d = d5 + d6;
                                        break;
                                    case 24:
                                    case 25:
                                        d3 = this.gosCost;
                                        d4 = 0.03d;
                                        Double.isNaN(d3);
                                        d = (d3 * d4) + 40000.0d;
                                        break;
                                    case 26:
                                    case 27:
                                        double d10 = this.gosCost;
                                        Double.isNaN(d10);
                                        d = (d10 * 0.05d) + 40000.0d;
                                        break;
                                    case 28:
                                    case 29:
                                        d2 = this.gosCost;
                                        Double.isNaN(d2);
                                        d = (d2 * d7) + 50000.0d;
                                        break;
                                    case 30:
                                        double d11 = this.gosCost;
                                        Double.isNaN(d11);
                                        d5 = d11 * 0.07d;
                                        d6 = 100000.0d;
                                        d = d5 + d6;
                                        break;
                                    default:
                                        d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                                        break;
                                }
                        }
                    }
                } else {
                    double d12 = this.gosCost;
                    Double.isNaN(d12);
                    d = (d12 * 0.01d) + 20000.0d;
                }
                return (int) Math.round(d);
            }
            d2 = this.gosCost;
            Double.isNaN(d2);
            d = (d2 * d7) + 50000.0d;
            return (int) Math.round(d);
        }
        double d13 = this.gosCost;
        Double.isNaN(d13);
        d = 10000.0d + (d13 * 0.01d);
        return (int) Math.round(d);
    }

    public void applyResetDetails(int mActiveSelectorId, int typeLayout, int established) {
        new TuningLogicPopupWindowResetDetails(this, this.viewResetDetails, mActiveSelectorId, typeLayout, this.context, established).startLogicReset();
        this.popupWindowResetDetails.showAtLocation(this.context.getParentLayout(), 17, 0, 0);
        GUIManager.hideSystemUI(this.viewResetDetails);
    }

    public void dismissPopupWindowResetDetails() {
        this.popupWindowResetDetails.dismiss();
        closeAndroidsInterface();
    }

    public void setTypeLayout(int typeLayout) {
        this.typeLayout = typeLayout;
    }

    private void getValueMoneyFromServer(JSONObject jsonObject) {
        this.playersMoneyValue = jsonObject.optInt("m");
    }

    private void setMoneyInTitle(String getMoney) {
        this.headerValueMoney.setText(getMoney);
    }

    private void getNameCar(JSONObject jsonObject) {
        this.nameCar = jsonObject.optString("n");
    }

    private void setNameCarInTitle(String getNameCar) {
        this.headerNameCar.setText(getNameCar);
    }

    private void getDetailsListAndInfoFromServer(final JSONObject jsonObject) {
        Single.create(new SingleOnSubscribe() {
            @Override
            public final void subscribe(SingleEmitter singleEmitter) {
                try {
                    GUITuning.this.lambda$getDetailsListAndInfoFromServer$17$GUITuning(jsonObject, singleEmitter);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    public void lambda$getDetailsListAndInfoFromServer$17$GUITuning(final JSONObject jsonObject, SingleEmitter subscribe) throws Throwable {
        JSONArray optJSONArray = jsonObject.optJSONArray(TuningConstants.KEY_GET_DETAILS_LIST_WITH_COST_AND_STATUS);
        if (optJSONArray != null) {
            this.listCorrectDetailsWithIDAndStatus.clear();
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.listCorrectDetailsWithIDAndStatus.add((Integer) optJSONArray.get(i));
                Log.v(LOG, "CorrectDetailsWithStatus from server [" + i + "]: " + this.listCorrectDetailsWithIDAndStatus.get(i));
            }
        }
        subscribe.onSuccess(this.listCorrectDetailsWithIDAndStatus);
    }

    private void getGosCostFromServer(JSONObject jsonObject) {
        this.gosCost = jsonObject.optInt(TuningConstants.KEY_GET_GOS_COST);
        Log.v(LOG, "gos cost from server = " + this.gosCost);
    }

    public int getGosCost() {
        return this.gosCost;
    }

    private void getCarID(JSONObject jsonObject) {
        this.carID = jsonObject.optInt("s");
        Log.v(LOG, "car id = " + this.carID);
    }

    public int getCarID() {
        return this.carID;
    }

    private void getDetailIDFromServer(JSONObject jsonObject) {
        this.detailId = jsonObject.optInt(TuningConstants.KEY_GET_ID_DETAIL);
        Log.v(LOG, "get detail id from server = " + this.detailId);
    }

    private void getOldInstallDetailIDFromServer(JSONObject jsonObject) {
        this.idOldInstallDetail = jsonObject.optInt(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL);
        Log.v(LOG, "get old install detail id from server = " + this.idOldInstallDetail);
    }

    private void getStatusDetailsFromServer(final JSONObject jsonObject) {
        Single.create(new SingleOnSubscribe() {
            @Override
            public final void subscribe(SingleEmitter singleEmitter) {
                try {
                    GUITuning.this.lambda$getStatusDetailsFromServer$18$GUITuning(jsonObject, singleEmitter);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    public void lambda$getStatusDetailsFromServer$18$GUITuning(final JSONObject jsonObject, SingleEmitter subscribe) throws Throwable {
        JSONArray optJSONArray = jsonObject.optJSONArray("d");
        if (optJSONArray != null) {
            this.listDetailsWithPercent.clear();
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.listDetailsWithPercent.add((Integer) optJSONArray.get(i));
                Log.v(LOG, "listDetailsWithPercent from server [" + i + "]: " + this.listDetailsWithPercent.get(i));
            }
        }
        subscribe.onSuccess(this.listDetailsWithPercent);
    }

    private void getStatusDiagnosticFromServer(final JSONObject jsonObject) {
        Single.create(new SingleOnSubscribe() {
            @Override
            public final void subscribe(SingleEmitter singleEmitter) {
                try {
                    GUITuning.this.lambda$getStatusDiagnosticFromServer$19$GUITuning(jsonObject, singleEmitter);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    public void lambda$getStatusDiagnosticFromServer$19$GUITuning(final JSONObject jsonObject, SingleEmitter subscribe) throws Throwable {
        this.statusDiagnostic = jsonObject.optInt("a");
        Log.v(LOG, "status diagnostic from server = " + this.statusDiagnostic);
        subscribe.onSuccess(Integer.valueOf(this.statusDiagnostic));
    }

    private void getAllColors(final JSONObject jsonObject) {
        Single.create(new SingleOnSubscribe() {
            @Override
            public final void subscribe(SingleEmitter singleEmitter) {
                try {
                    GUITuning.this.lambda$getAllColors$20$GUITuning(jsonObject, singleEmitter);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }).subscribe();
    }

    public void lambda$getAllColors$20$GUITuning(final JSONObject jsonObject, SingleEmitter subscribe) throws Throwable {
        JSONArray optJSONArray = jsonObject.optJSONArray("a");
        if (optJSONArray != null) {
            this.listAllColors.clear();
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.listAllColors.add((String) optJSONArray.get(i));
                Log.v(LOG, "listAllColors from client [" + i + "]: " + this.listAllColors.get(i));
            }
        }
        subscribe.onSuccess(this.listAllColors);
    }

    private void getStartVinyl(final JSONObject jsonObject) {
        Single.create(new SingleOnSubscribe() {
            @Override
            public final void subscribe(SingleEmitter singleEmitter) {
                try {
                    GUITuning.this.lambda$getStartVinyl$21$GUITuning(jsonObject, singleEmitter);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    public void lambda$getStartVinyl$21$GUITuning(final JSONObject jsonObject, SingleEmitter subscribe) throws Throwable {
        this.getVinyl = jsonObject.optString("v");
        Log.v(LOG, "getVinyl from client = " + this.getVinyl);
        subscribe.onSuccess(this.getVinyl);
    }

    private void getAllCollapse(final JSONObject jsonObject) {
        Single.create(new SingleOnSubscribe() {
            @Override
            public final void subscribe(SingleEmitter singleEmitter) {
                try {
                    GUITuning.this.lambda$getAllCollapse$22$GUITuning(jsonObject, singleEmitter);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }).subscribe();
    }

    public void lambda$getAllCollapse$22$GUITuning(final JSONObject jsonObject, SingleEmitter subscribe) throws Throwable {
        JSONArray optJSONArray = jsonObject.optJSONArray(TuningConstants.KEY_GET_ALL_COLLAPSE);
        if (optJSONArray != null) {
            this.listAllCollapse.clear();
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.listAllCollapse.add((Integer) optJSONArray.get(i));
                Log.v(LOG, "listAllCollapse from client [" + i + "]: " + this.listAllCollapse.get(i));
            }
        }
        subscribe.onSuccess(this.listAllCollapse);
    }

    public void putIntegerDataToServer(int typeKey, int data) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", typeKey);
            jSONObject.put("d", data);
            this.guiManager.sendJsonData(28, jSONObject);
            Log.v(LOG, "key: " + typeKey + ", int data: " + data);
        } catch (Exception e) {
            Log.v(LOG, Log.getStackTraceString(e));
        }
    }

    public void putActionResetDetailsToServer(int typeKey, int selectorId, int established) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", typeKey);
            jSONObject.put("m", selectorId);
            jSONObject.put(TuningConstants.KEY_SEND_DETAILS_TYPE, established);
            this.guiManager.sendJsonData(28, jSONObject);
            Log.v(LOG, "key: " + typeKey + ", int selectorId: " + selectorId + ", established: " + established);
        } catch (Exception e) {
            Log.v(LOG, Log.getStackTraceString(e));
        }
    }

    public void putPlayersActionToServer(int typeKey) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", typeKey);
            this.guiManager.sendJsonData(28, jSONObject);
            Log.v(LOG, "only key: " + typeKey);
        } catch (Exception e) {
            Log.v(LOG, Log.getStackTraceString(e));
        }
    }

    public void putIntegerDataWithSelectorIDToServer(int typeKey, int id, int selector) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", typeKey);
            jSONObject.put("d", id);
            jSONObject.put("m", selector);
            this.guiManager.sendJsonData(28, jSONObject);
            Log.v(LOG, "key: " + typeKey + ", int data: " + id + ", selector: " + selector);
        } catch (Exception e) {
            Log.v(LOG, Log.getStackTraceString(e));
        }
    }

    public void putColorDataWithSelectorIDToServer(int typeKey, String color, int selector) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", typeKey);
            jSONObject.put("d", color);
            jSONObject.put("m", selector);
            this.guiManager.sendJsonData(28, jSONObject);
            Log.v(LOG, "key: " + typeKey + ", String data: " + color + ", selector: " + selector);
        } catch (Exception e) {
            Log.v(LOG, Log.getStackTraceString(e));
        }
    }

    public void putSelectorToClient(int typeKey, int selector) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", typeKey);
            jSONObject.put("s", selector);
            this.guiManager.sendJsonData(28, jSONObject);
            Log.v(LOG, "key: " + typeKey + ", selector: " + selector);
        } catch (Exception e) {
            Log.v(LOG, Log.getStackTraceString(e));
        }
    }

    public void putDetailOrCollapseToClient(int typeKey, int idDetailOrValueCollapse) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", typeKey);
            jSONObject.put("d", idDetailOrValueCollapse);
            this.guiManager.sendJsonData(28, jSONObject);
            Log.v(LOG, "key: " + typeKey + ", idDetailOrValueCollapse: " + idDetailOrValueCollapse);
        } catch (Exception e) {
            Log.v(LOG, Log.getStackTraceString(e));
        }
    }

    public void putColorToClient(int typeKey, String color) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", typeKey);
            jSONObject.put(TuningConstants.KEY_SEND_COLOR_FOR_PREVIEW, color);
            this.guiManager.sendJsonData(28, jSONObject);
            Log.v(LOG, "key to client: " + typeKey + ", color: " + color);
        } catch (Exception e) {
            Log.v(LOG, Log.getStackTraceString(e));
        }
    }

    public void putVinylToClient(int typeKey, String nameVinyl) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", typeKey);
            jSONObject.put("v", nameVinyl);
            this.guiManager.sendJsonData(28, jSONObject);
            Log.v(LOG, "key: " + typeKey + ", vinyl: " + nameVinyl);
        } catch (Exception e) {
            Log.v(LOG, Log.getStackTraceString(e));
        }
    }

    public void putSoundToClient(int typeKey, int idSound) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", typeKey);
            jSONObject.put("h", idSound);
            this.guiManager.sendJsonData(28, jSONObject);
            Log.v(LOG, "key: " + typeKey + ", idSound: " + idSound);
        } catch (Exception e) {
            Log.v(LOG, Log.getStackTraceString(e));
        }
    }

    @Override
    public void close(JSONObject json) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        PopupWindow popupWindow2 = this.popupWindowSubmenu;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
        }
        PopupWindow popupWindow3 = this.popupWindowApplyRepeat;
        if (popupWindow3 != null) {
            popupWindow3.dismiss();
        }
        PopupWindow popupWindow4 = this.popupWindowBox;
        if (popupWindow4 != null) {
            popupWindow4.dismiss();
        }
        PopupWindow popupWindow5 = this.popupWindowResetDetails;
        if (popupWindow5 != null) {
            popupWindow5.dismiss();
        }
    }

    @Override
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }
}
