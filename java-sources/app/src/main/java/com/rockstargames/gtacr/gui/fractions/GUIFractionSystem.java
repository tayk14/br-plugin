package com.rockstargames.gtacr.gui.fractions;

import android.content.res.Resources;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionMainContainerBinding;
import blackrussia.online.network.fraction.data.FractionControlListOfPlayers;
import blackrussia.online.network.fraction.data.FractionControlPlayerInfo;
import blackrussia.online.network.fraction.data.FractionsDocumentsItem;
import blackrussia.online.network.fraction.data.FractionsNewRankRewardItem;
import blackrussia.online.network.fraction.data.FractionsProgressStaffItem;
import com.bumptech.glide.Glide;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.common.UIContainer;
import com.rockstargames.gtacr.data.FractionsShopList;
import com.rockstargames.gtacr.data.FractionsTestingResult;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsControlViewModel;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsControlViewModelFactory;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsDocumentsViewModel;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsDocumentsViewModelFactory;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsMainViewModel;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsMainViewModelFactory;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsQuestsViewModel;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsQuestsViewModelFactory;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsShopViewModel;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsShopViewModelFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 U2\u00020\u0001:\u0001UB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0006\u00105\u001a\u000202J\u0010\u00106\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0010\u00107\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u00108\u001a\u00020\u0015H\u0016J\u0010\u00109\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00150;2\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00150;2\u0006\u0010=\u001a\u00020>H\u0002J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u001e2\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010@\u001a\u000202H\u0002J\b\u0010A\u001a\u000202H\u0002J\b\u0010B\u001a\u00020\u001cH\u0016J\u000e\u0010C\u001a\u0002022\u0006\u0010D\u001a\u00020\u0015J.\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u001e2\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u001e2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001eH\u0002J\u0012\u0010I\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0012\u0010J\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0002J\u0018\u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0015H\u0002J\b\u0010O\u001a\u000202H\u0002J\b\u0010P\u001a\u000202H\u0002J&\u0010Q\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/GUIFractionSystem;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "()V", "_binding", "Lblackrussia/online/databinding/FractionMainContainerBinding;", "anim", "Landroid/view/animation/Animation;", "binding", "getBinding", "()Lblackrussia/online/databinding/FractionMainContainerBinding;", "buyTokensDialog", "Lcom/rockstargames/gtacr/gui/fractions/UIBuyTokensDialog;", "container", "Lcom/rockstargames/gtacr/common/UIContainer;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "controlLayout", "Lcom/rockstargames/gtacr/gui/fractions/UIFractionsControlLayout;", "controlViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsControlViewModel;", "currentLayout", "", "documentsLayout", "Lcom/rockstargames/gtacr/gui/fractions/UIFractionsDocumentsLayout;", "documentsViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsDocumentsViewModel;", "fractionId", "isClickedMainItem", "", "listOfImages", "", "mainMenuLayout", "Lcom/rockstargames/gtacr/gui/fractions/UIFractionMainLayout;", "mainViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsMainViewModel;", "popupWindow", "Landroid/widget/PopupWindow;", "questsLayout", "Lcom/rockstargames/gtacr/gui/fractions/UIFractionQuestsLayout;", "questsViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsQuestsViewModel;", "shopLayout", "Lcom/rockstargames/gtacr/gui/fractions/UIFractionsShopLayout;", "shopViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsShopViewModel;", "testResultDialog", "Lcom/rockstargames/gtacr/gui/fractions/UIFractionsTestResultDialog;", "testingLayout", "Lcom/rockstargames/gtacr/gui/fractions/UIFractionsTestingLayout;", "close", "", "json", "Lorg/json/JSONObject;", "closeAndroidsButtons", "getFractionNameTitle", "getFractionTitleIcon", "getGuiId", "getImageForTasksBackground", "getListOfImagesForAdapter", "", "getListOfImagesFunction", "link", "", "getListOfPositionForAdapter", "initContainer", "initPopupWindow", "isShowingGui", "listenerLayout", "thisLayout", "makeListOfPlayersControlInterface", "Lblackrussia/online/network/fraction/data/FractionControlListOfPlayers;", "listOfNicknames", "listOfValues", "onPacketIncoming", "setDataFromJson", "setupButtonClickListener", Const.FRACTION_BUTTON_KEY, "Landroid/widget/ImageButton;", "layout", "setupButtonClickListeners", "setupMainLayoutObservers", "show", "manager", "Lcom/rockstargames/gtacr/GUIManager;", "activity", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GUIFractionSystem implements ISAMPGUI {
    public static final Companion Companion = new Companion(null);
    private FractionMainContainerBinding _binding;
    private Animation anim;
    private UIBuyTokensDialog buyTokensDialog;
    private UIContainer container;
    private NvEventQueueActivity context;
    private UIFractionsControlLayout controlLayout;
    private FractionsControlViewModel controlViewModel;
    private UIFractionsDocumentsLayout documentsLayout;
    private FractionsDocumentsViewModel documentsViewModel;
    private int fractionId;
    private boolean isClickedMainItem;
    private UIFractionMainLayout mainMenuLayout;
    private FractionsMainViewModel mainViewModel;
    private PopupWindow popupWindow;
    private UIFractionQuestsLayout questsLayout;
    private FractionsQuestsViewModel questsViewModel;
    private UIFractionsShopLayout shopLayout;
    private FractionsShopViewModel shopViewModel;
    private UIFractionsTestResultDialog testResultDialog;
    private UIFractionsTestingLayout testingLayout;
    private int currentLayout = -1;
    private final List<Integer> listOfImages = new ArrayList();

    private final int getFractionNameTitle(int i) {
        if (i != 11) {
            switch (i) {
                case 1:
                    return R.string.fractions_government_title;
                case 2:
                    return R.string.fractions_defense_department_title;
                case 3:
                    return R.string.fractions_hospital_title;
                case 4:
                    return R.string.fractions_mass_media_title;
                case 5:
                    return R.string.fractions_dps_title;
                case 6:
                    return R.string.fractions_mvd_title;
                case 7:
                    return R.string.fractions_fsb_title;
                default:
                    return -1;
            }
        }
        return R.string.fractions_fsin_title;
    }

    private final int getFractionTitleIcon(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 5 ? i != 6 ? i != 7 ? i != 11 ? R.drawable.fractions_title_mass_media_ic : R.drawable.fractions_title_fsin_ic : R.drawable.fractions_title_fsb_ic : R.drawable.fractions_title_mvd_ic : R.drawable.fractions_title_dps_ic : R.drawable.fractions_title_hospital_ic : R.drawable.fractions_title_army_ic : R.drawable.fractions_title_government_ic;
    }

    private final int getImageForTasksBackground(int i) {
        if (i != 11) {
            switch (i) {
                case 1:
                    return R.drawable.fractions_tasks_government_res;
                case 2:
                    return R.drawable.fractions_tasks_defense_department_res;
                case 3:
                    return R.drawable.fractions_tasks_hospital_res;
                case 4:
                    return R.drawable.fractions_tasks_mass_media_res;
                case 5:
                    return R.drawable.fractions_tasks_dps_res;
                case 6:
                    return R.drawable.fractions_tasks_mvd_res;
                case 7:
                    return R.drawable.fractions_tasks_fsb_res;
                default:
                    return -1;
            }
        }
        return R.drawable.fractions_tasks_fsin_res;
    }

    @JvmStatic
    public static final GUIFractionSystem newInstance() {
        return Companion.newInstance();
    }

    @Override
    public int getGuiId() {
        return 46;
    }

    private final FractionMainContainerBinding getBinding() {
        FractionMainContainerBinding fractionMainContainerBinding = this._binding;
        Intrinsics.checkNotNull(fractionMainContainerBinding);
        return fractionMainContainerBinding;
    }

    //@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/GUIFractionSystem$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/fractions/GUIFractionSystem;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GUIFractionSystem newInstance() {
            return new GUIFractionSystem();
        }
    }

    @Override
    public void onPacketIncoming(JSONObject jSONObject) {
        setDataFromJson(jSONObject);
    }

    @Override
    public void show(JSONObject jSONObject, GUIManager gUIManager, NvEventQueueActivity nvEventQueueActivity) {
        this.context = nvEventQueueActivity;
        if (nvEventQueueActivity != null) {
            ActionsWithJSON actionsWithJSON = new ActionsWithJSON(gUIManager);
            NvEventQueueActivity nvEventQueueActivity2 = nvEventQueueActivity;
            this.mainViewModel = (FractionsMainViewModel) new ViewModelProvider(nvEventQueueActivity2, new FractionsMainViewModelFactory(actionsWithJSON)).get(FractionsMainViewModel.class);
            this.questsViewModel = (FractionsQuestsViewModel) new ViewModelProvider(nvEventQueueActivity2, new FractionsQuestsViewModelFactory(actionsWithJSON)).get(FractionsQuestsViewModel.class);
            this.documentsViewModel = (FractionsDocumentsViewModel) new ViewModelProvider(nvEventQueueActivity2, new FractionsDocumentsViewModelFactory(actionsWithJSON)).get(FractionsDocumentsViewModel.class);
            this.controlViewModel = (FractionsControlViewModel) new ViewModelProvider(nvEventQueueActivity2, new FractionsControlViewModelFactory(actionsWithJSON)).get(FractionsControlViewModel.class);
            this.shopViewModel = (FractionsShopViewModel) new ViewModelProvider(nvEventQueueActivity2, new FractionsShopViewModelFactory(actionsWithJSON)).get(FractionsShopViewModel.class);
            FractionsMainViewModel fractionsMainViewModel = this.mainViewModel;
            this.buyTokensDialog = fractionsMainViewModel == null ? null : new UIBuyTokensDialog(nvEventQueueActivity, this, fractionsMainViewModel);
            FractionsDocumentsViewModel fractionsDocumentsViewModel = this.documentsViewModel;
            this.testResultDialog = fractionsDocumentsViewModel != null ? new UIFractionsTestResultDialog(nvEventQueueActivity, fractionsDocumentsViewModel) : null;
        }
        if (this.popupWindow == null) {
            initPopupWindow();
        }
        setupMainLayoutObservers();
        initContainer();
        setupButtonClickListeners();
        setDataFromJson(jSONObject);
        closeAndroidsButtons();
        FractionsDocumentsViewModel fractionsDocumentsViewModel2 = this.documentsViewModel;
        if (fractionsDocumentsViewModel2 != null) {
            fractionsDocumentsViewModel2.getDocumentsAndTestingLists();
        }
        FractionsShopViewModel fractionsShopViewModel = this.shopViewModel;
        if (fractionsShopViewModel != null) {
            fractionsShopViewModel.getShopList();
        }
        FractionsQuestsViewModel fractionsQuestsViewModel = this.questsViewModel;
        if (fractionsQuestsViewModel == null) {
            return;
        }
        fractionsQuestsViewModel.getQuestsObj();
    }

    private final void setDataFromJson(JSONObject jSONObject) {
        FractionsMainViewModel fractionsMainViewModel;
        LiveData<List<FractionsDocumentsItem>> documentsListLivedata;
        FractionsDocumentsViewModel fractionsDocumentsViewModel;
        FractionsMainViewModel fractionsMainViewModel2;
        LiveData<FractionsShopList> shopListLiveData;
        FractionsControlViewModel fractionsControlViewModel;
        FractionsMainViewModel fractionsMainViewModel3;
        if (jSONObject == null) {
            return;
        }
        Log.d(Const.LOG_FRACTION_S, jSONObject.toString());
        if (jSONObject.optInt(Const.FRACTION_CLOSE_KEY) == 1) {
            NvEventQueueActivity nvEventQueueActivity = this.context;
            if (nvEventQueueActivity != null) {
                //nvEventQueueActivity.toggleDrawing2dStuff(false);
            }
            close(jSONObject);
            return;
        }
        if (jSONObject.optInt(Const.FRACTION_TOKENS) == 1 && (fractionsMainViewModel3 = this.mainViewModel) != null) {
            fractionsMainViewModel3.setFractionTokens(jSONObject.optInt(Const.FRACTION_TOKENS_VALUE));
        }
        FractionsMainViewModel fractionsMainViewModel4 = this.mainViewModel;
        if (fractionsMainViewModel4 != null) {
            fractionsMainViewModel4.setAddTokensPrice(jSONObject.optInt(Const.FRACTION_ADD_TOKENS_PRICE));
        }
        FractionsShopList fractionsShopList = null;
        if (jSONObject.optInt("t") == 4) {
            JSONArray optJSONArray = jSONObject.optJSONArray(Const.FRACTION_CONTROL_T_LIST_OF_NICKNAMES);
            List<String> mutableStringList = optJSONArray == null ? null : FractionsUtilsKt.toMutableStringList(optJSONArray);
            JSONArray optJSONArray2 = jSONObject.optJSONArray(Const.FRACTION_CONTROL_T_LIST_OF_VALUES);
            List<Integer> mutableIntList = optJSONArray2 == null ? null : FractionsUtilsKt.toMutableIntList(optJSONArray2);
            FractionsControlViewModel fractionsControlViewModel2 = this.controlViewModel;
            if (fractionsControlViewModel2 != null) {
                fractionsControlViewModel2.setStaffListLiveData(makeListOfPlayersControlInterface(mutableStringList, mutableIntList));
            }
        }
        this.currentLayout = jSONObject.optInt(Const.PAGE_KEY);
        switch (jSONObject.optInt(Const.PAGE_KEY)) {
            case 1:
                this.fractionId = jSONObject.optInt(Const.FRACTION_ID);
                JSONArray optJSONArray3 = jSONObject.optJSONArray(Const.RANK_STATUS);
                List<Integer> mutableIntList2 = optJSONArray3 == null ? null : FractionsUtilsKt.toMutableIntList(optJSONArray3);
                JSONArray optJSONArray4 = jSONObject.optJSONArray(Const.RANK_PROGRESS);
                List<Integer> mutableIntList3 = optJSONArray4 != null ? FractionsUtilsKt.toMutableIntList(optJSONArray4) : null;
                FractionsMainViewModel fractionsMainViewModel5 = this.mainViewModel;
                if (fractionsMainViewModel5 != null) {
                    fractionsMainViewModel5.setFractionId(this.fractionId);
                }
                FractionsDocumentsViewModel fractionsDocumentsViewModel2 = this.documentsViewModel;
                if (fractionsDocumentsViewModel2 != null) {
                    fractionsDocumentsViewModel2.setFractionId(this.fractionId);
                }
                if (mutableIntList2 != null && mutableIntList3 != null && (fractionsMainViewModel = this.mainViewModel) != null) {
                    fractionsMainViewModel.setFractionsProgressStaffItem(new FractionsProgressStaffItem(this.fractionId, mutableIntList2, mutableIntList3));
                }
                listenerLayout(11);
                return;
            case 2:
                JSONArray optJSONArray5 = jSONObject.optJSONArray(Const.FRACTION_NEW_RANK_REWARD);
                List<Integer> mutableIntList4 = optJSONArray5 != null ? FractionsUtilsKt.toMutableIntList(optJSONArray5) : null;
                int optInt = jSONObject.optInt("new_rank");
                if (mutableIntList4 == null) {
                    return;
                }
                if (this.listOfImages.isEmpty()) {
                    this.listOfImages.addAll(getListOfImagesForAdapter(this.fractionId));
                }
                FractionsNewRankRewardItem fractionsNewRankRewardItem = new FractionsNewRankRewardItem(this.fractionId, mutableIntList4, optInt, this.listOfImages.isEmpty() ^ true ? this.listOfImages.get(optInt - 1).intValue() : 0);
                FractionsMainViewModel fractionsMainViewModel6 = this.mainViewModel;
                if (fractionsMainViewModel6 == null) {
                    return;
                }
                fractionsMainViewModel6.setFractionsNewRankRewardItem(fractionsNewRankRewardItem);
                return;
            case 3:
                int optInt2 = jSONObject.optInt(Const.FRACTION_TASK_RANK);
                Log.v(Const.LOG_FRACTION_S, Intrinsics.stringPlus("INTERFACE_QUESTS playersRank == ", Integer.valueOf(optInt2)));
                return;
            case 4:
                FractionsDocumentsViewModel fractionsDocumentsViewModel3 = this.documentsViewModel;
                if (((fractionsDocumentsViewModel3 == null || (documentsListLivedata = fractionsDocumentsViewModel3.getDocumentsListLivedata()) == null) ? null : documentsListLivedata.getValue()) == null) {
                    FractionsDocumentsViewModel fractionsDocumentsViewModel4 = this.documentsViewModel;
                    if (fractionsDocumentsViewModel4 != null) {
                        fractionsDocumentsViewModel4.getDocumentsAndTestingLists();
                    }
                    Log.d(Const.LOG_FRACTION_S, "documentsViewModel?.testingResultLiveData?.value NULL");
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray(Const.FRACTION_DOCUMENTS_BUTTON_ACQUAINTED);
                List<Integer> mutableIntList5 = optJSONArray6 != null ? FractionsUtilsKt.toMutableIntList(optJSONArray6) : null;
                if (mutableIntList5 != null && (fractionsDocumentsViewModel = this.documentsViewModel) != null) {
                    fractionsDocumentsViewModel.setDisplayButtonAcquainted(mutableIntList5);
                }
                listenerLayout(5);
                return;
            case 5:
                listenerLayout(9);
                return;
            case 6:
                int optInt3 = jSONObject.optInt(Const.FRACTION_TESTING_RESULT);
                int optInt4 = jSONObject.optInt(Const.FRACTION_TESTING_TOTAL);
                int optInt5 = jSONObject.optInt(Const.FRACTION_TESTING_QUESTIONS_TOTAL);
                FractionsDocumentsViewModel fractionsDocumentsViewModel5 = this.documentsViewModel;
                if (fractionsDocumentsViewModel5 != null) {
                    fractionsDocumentsViewModel5.setTestingResult(new FractionsTestingResult(optInt3, optInt4, optInt5));
                }
                UIFractionsTestResultDialog uIFractionsTestResultDialog = this.testResultDialog;
                if (uIFractionsTestResultDialog == null) {
                    return;
                }
                uIFractionsTestResultDialog.showDialog();
                return;
            case 7:
                if (jSONObject.optInt(Const.FRACTION_TYPE_KEY) == 2 && (fractionsMainViewModel2 = this.mainViewModel) != null) {
                    fractionsMainViewModel2.setBCValue(jSONObject.optInt(Const.FRACTION_ADD_TOKENS_BC_VALUE));
                }
                UIBuyTokensDialog uIBuyTokensDialog = this.buyTokensDialog;
                if (uIBuyTokensDialog == null) {
                    return;
                }
                uIBuyTokensDialog.showDialog();
                return;
            case 8:
                FractionsShopViewModel fractionsShopViewModel = this.shopViewModel;
                if (fractionsShopViewModel != null && (shopListLiveData = fractionsShopViewModel.getShopListLiveData()) != null) {
                    fractionsShopList = shopListLiveData.getValue();
                }
                if (fractionsShopList == null) {
                    FractionsShopViewModel fractionsShopViewModel2 = this.shopViewModel;
                    if (fractionsShopViewModel2 != null) {
                        fractionsShopViewModel2.getShopList();
                    }
                    Log.d(Const.LOG_FRACTION_S, "shopViewModel?.shopListLiveData?.value NULL");
                }
                listenerLayout(3);
                return;
            case 9:
                int optInt6 = jSONObject.optInt(Const.FRACTION_TYPE_KEY);
                if (optInt6 == 1) {
                    listenerLayout(4);
                    return;
                } else if (optInt6 == 2) {
                    FractionsControlViewModel fractionsControlViewModel3 = this.controlViewModel;
                    if (fractionsControlViewModel3 == null) {
                        return;
                    }
                    String optString = jSONObject.optString(Const.FRACTION_CONTROL_PLAYER_NICKNAME);
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(FRACTION_CONTROL_PLAYER_NICKNAME)");
                    int optInt7 = jSONObject.optInt(Const.FRACTION_CONTROL_PLAYER_SKIN_ID);
                    int optInt8 = jSONObject.optInt("level");
                    String optString2 = jSONObject.optString(Const.FRACTION_CONTROL_PLAYER_RANK_NAME);
                    Intrinsics.checkNotNullExpressionValue(optString2, "optString(FRACTION_CONTROL_PLAYER_RANK_NAME)");
                    int optInt9 = jSONObject.optInt(Const.FRACTION_CONTROL_PLAYER_RANK);
                    int optInt10 = jSONObject.optInt(Const.FRACTION_CONTROL_PLAYER_REPRIMAND);
                    String optString3 = jSONObject.optString("phone");
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(FRACTION_CONTROL_PLAYER_PHONE)");
                    fractionsControlViewModel3.setInfoAboutPlayer(new FractionControlPlayerInfo(optString, optInt7, optInt8, optString2, optInt9, optInt10, optString3));
                    return;
                } else if (optInt6 == 3) {
                    FractionsControlViewModel fractionsControlViewModel4 = this.controlViewModel;
                    if (fractionsControlViewModel4 != null) {
                        fractionsControlViewModel4.setNewPlayersRankLiveData(jSONObject.optInt("new_rank"));
                    }
                    FractionsControlViewModel fractionsControlViewModel5 = this.controlViewModel;
                    if (fractionsControlViewModel5 == null) {
                        return;
                    }
                    String optString4 = jSONObject.optString(Const.FRACTION_CONTROL_PLAYER_NEW_POSITION);
                    Intrinsics.checkNotNullExpressionValue(optString4, "optString(FRACTION_CONTROL_PLAYER_NEW_POSITION)");
                    fractionsControlViewModel5.setNewPlayersPosition(optString4);
                    return;
                } else if (optInt6 != 4) {
                    if (optInt6 == 5 && (fractionsControlViewModel = this.controlViewModel) != null) {
                        fractionsControlViewModel.dismissPlayerFromFraction(jSONObject.optInt(Const.FRACTION_CONTROL_DISMISSED_PLAYER_ID));
                        return;
                    }
                    return;
                } else {
                    FractionsControlViewModel fractionsControlViewModel6 = this.controlViewModel;
                    if (fractionsControlViewModel6 == null) {
                        return;
                    }
                    fractionsControlViewModel6.setNewPlayersReprimandLiveData(jSONObject.optInt(Const.FRACTION_CONTROL_PLAYER_NEW_REPRIMAND));
                    return;
                }
            default:
                return;
        }
    }

    private final void setupMainLayoutObservers() {
        LifecycleOwner lifecycleOwner;
        LiveData<FractionsNewRankRewardItem> newRankRewardItemLiveData;
        LiveData<FractionsProgressStaffItem> progressStaffItemLiveData;
        LiveData<Integer> fractionTokensLiveData;
        LiveData<Integer> fractionIdLiveData;
        final FractionMainContainerBinding binding = getBinding();
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (nvEventQueueActivity == null || (lifecycleOwner = FractionsUtilsKt.lifecycleOwner(nvEventQueueActivity)) == null) {
            return;
        }
        FractionsMainViewModel fractionsMainViewModel = this.mainViewModel;
        if (fractionsMainViewModel != null && (fractionIdLiveData = fractionsMainViewModel.getFractionIdLiveData()) != null) {
            fractionIdLiveData.observe(lifecycleOwner, new Observer() {
                @Override
                public final void onChanged(Object obj) {
                    GUIFractionSystem.m247setupMainLayoutObservers$lambda15$lambda14$lambda8(GUIFractionSystem.this, (Integer) obj);
                }
            });
        }
        FractionsMainViewModel fractionsMainViewModel2 = this.mainViewModel;
        if (fractionsMainViewModel2 != null && (fractionTokensLiveData = fractionsMainViewModel2.getFractionTokensLiveData()) != null) {
            fractionTokensLiveData.observe(lifecycleOwner, new Observer() {
                @Override
                public final void onChanged(Object obj) {
                    //GUIFractionSystem.m248setupMainLayoutObservers$lambda15$lambda14$lambda9(, (Integer) obj);
                }
            });
        }
        FractionsMainViewModel fractionsMainViewModel3 = this.mainViewModel;
        if (fractionsMainViewModel3 != null && (progressStaffItemLiveData = fractionsMainViewModel3.getProgressStaffItemLiveData()) != null) {
            progressStaffItemLiveData.observe(lifecycleOwner, new Observer() {
                @Override
                public final void onChanged(Object obj) {
                    GUIFractionSystem.m245setupMainLayoutObservers$lambda15$lambda14$lambda10(GUIFractionSystem.this, binding, (FractionsProgressStaffItem) obj);
                }
            });
        }
        FractionsMainViewModel fractionsMainViewModel4 = this.mainViewModel;
        if (fractionsMainViewModel4 == null || (newRankRewardItemLiveData = fractionsMainViewModel4.getNewRankRewardItemLiveData()) == null) {
            return;
        }
        newRankRewardItemLiveData.observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                GUIFractionSystem.m246setupMainLayoutObservers$lambda15$lambda14$lambda13(GUIFractionSystem.this, (FractionsNewRankRewardItem) obj);
            }
        });
    }

    public static final void m247setupMainLayoutObservers$lambda15$lambda14$lambda8(GUIFractionSystem this$0, Integer fractionId_) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIFractionsControlLayout uIFractionsControlLayout = this$0.controlLayout;
        if (uIFractionsControlLayout != null) {
            Intrinsics.checkNotNullExpressionValue(fractionId_, "fractionId_");
            uIFractionsControlLayout.setupListOfImagesForAdapter(fractionId_.intValue());
        }
        Intrinsics.checkNotNullExpressionValue(fractionId_, "fractionId_");
        this$0.fractionId = fractionId_.intValue();
    }

    public static final void m248setupMainLayoutObservers$lambda15$lambda14$lambda9(FractionMainContainerBinding this_with, Integer fractionTokens) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        TextView textView = this_with.moneyValue;
        Useful useful = new Useful();
        Intrinsics.checkNotNullExpressionValue(fractionTokens, "fractionTokens");
        textView.setText(useful.getPriceWithSpacesForInt(fractionTokens.intValue()));
    }

    public static final void m245setupMainLayoutObservers$lambda15$lambda14$lambda10(GUIFractionSystem this$0, FractionMainContainerBinding this_with, FractionsProgressStaffItem item) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this$0.fractionId = item.getFractionId();
        UIFractionMainLayout uIFractionMainLayout = this$0.mainMenuLayout;
        if (uIFractionMainLayout != null) {
            Intrinsics.checkNotNullExpressionValue(item, "item");
            uIFractionMainLayout.setUpData(item, this$0.getImageForTasksBackground(item.getFractionId()), this$0.getListOfImagesForAdapter(item.getFractionId()), this$0.getListOfPositionForAdapter(item.getFractionId()));
        }
        Glide.with(this$0.getBinding().getRoot().getContext()).load(Integer.valueOf(this$0.getFractionTitleIcon(item.getFractionId()))).placeholder(this$0.getFractionTitleIcon(item.getFractionId())).into(this_with.iconTitleFraction);
        this_with.textTitleFraction.setText(this$0.getFractionNameTitle(item.getFractionId()));
    }

    public static final void m246setupMainLayoutObservers$lambda15$lambda14$lambda13(GUIFractionSystem this$0, FractionsNewRankRewardItem fractionsNewRankRewardItem) {
        NvEventQueueActivity nvEventQueueActivity;
        FractionsMainViewModel fractionsMainViewModel;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (fractionsNewRankRewardItem == null || (nvEventQueueActivity = this$0.context) == null || (fractionsMainViewModel = this$0.mainViewModel) == null) {
            return;
        }
        new UIGetNewRankDialog(nvEventQueueActivity, fractionsNewRankRewardItem, fractionsMainViewModel).showDialog();
    }

    private final void setupButtonClickListener(ImageButton imageButton, final int i) {
        imageButton.startAnimation(this.anim);
        if (this.isClickedMainItem) {
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                GUIFractionSystem.m238setupButtonClickListener$lambda16(GUIFractionSystem.this, i);
            }
        }, 100L);
        this.isClickedMainItem = true;
    }

    public static final void m238setupButtonClickListener$lambda16(GUIFractionSystem this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FractionsMainViewModel fractionsMainViewModel = this$0.mainViewModel;
        if (fractionsMainViewModel != null) {
            fractionsMainViewModel.sendButtonPressed(this$0.currentLayout, i);
        }
        this$0.isClickedMainItem = false;
    }

    private final void setupButtonClickListeners() {
        FractionMainContainerBinding binding = getBinding();
        binding.buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUIFractionSystem.m239setupButtonClickListeners$lambda23$lambda17(GUIFractionSystem.this, view);
            }
        });
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUIFractionSystem.m240setupButtonClickListeners$lambda23$lambda18(GUIFractionSystem.this, view);
            }
        });
        binding.buttonFractionsSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUIFractionSystem.m241setupButtonClickListeners$lambda23$lambda19(GUIFractionSystem.this, view);
            }
        });
        binding.buttonFractionsDocuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUIFractionSystem.m242setupButtonClickListeners$lambda23$lambda20(GUIFractionSystem.this, view);
            }
        });
        binding.buttonMoneyShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUIFractionSystem.m243setupButtonClickListeners$lambda23$lambda21(GUIFractionSystem.this, view);
            }
        });
        binding.buttonAddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUIFractionSystem.m244setupButtonClickListeners$lambda23$lambda22(GUIFractionSystem.this, view);
            }
        });
    }

    public static final void m239setupButtonClickListeners$lambda23$lambda17(GUIFractionSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.close(null);
    }

    public static final void m240setupButtonClickListeners$lambda23$lambda18(GUIFractionSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.ImageButton");
        this$0.setupButtonClickListener((ImageButton) view, 11);
    }

    public static final void m241setupButtonClickListeners$lambda23$lambda19(GUIFractionSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.ImageButton");
        this$0.setupButtonClickListener((ImageButton) view, 4);
    }

    public static final void m242setupButtonClickListeners$lambda23$lambda20(GUIFractionSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.ImageButton");
        this$0.setupButtonClickListener((ImageButton) view, 5);
    }

    public static final void m243setupButtonClickListeners$lambda23$lambda21(GUIFractionSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.ImageButton");
        this$0.setupButtonClickListener((ImageButton) view, 3);
    }

    public static final void m244setupButtonClickListeners$lambda23$lambda22(GUIFractionSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.ImageButton");
        this$0.setupButtonClickListener((ImageButton) view, 2);
    }

    public final void listenerLayout(int i) {
        if (i != 11) {
            getBinding().buttonBack.setVisibility(0);
        } else {
            getBinding().buttonBack.setVisibility(4);
        }
        if (i == 5) {
            FractionMainContainerBinding binding = getBinding();
            binding.buttonFractionsDocuments.setVisibility(0);
            binding.buttonFractionsSetting.setVisibility(0);
            binding.buttonMoneyShop.setVisibility(0);
        } else if (i == 9) {
            FractionMainContainerBinding binding2 = getBinding();
            binding2.buttonFractionsDocuments.setVisibility(4);
            binding2.buttonFractionsSetting.setVisibility(4);
            binding2.buttonMoneyShop.setVisibility(4);
        } else if (i == 11) {
            FractionMainContainerBinding binding3 = getBinding();
            binding3.buttonFractionsDocuments.setVisibility(0);
            binding3.buttonFractionsSetting.setVisibility(0);
            binding3.buttonMoneyShop.setVisibility(0);
        }
        UIContainer uIContainer = this.container;
        if (uIContainer == null) {
            return;
        }
        uIContainer.setCurrentLayout(i);
    }

    private final void initContainer() {
        this.container = getBinding().mainContainer;
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (nvEventQueueActivity == null) {
            return;
        }
        FractionsMainViewModel fractionsMainViewModel = this.mainViewModel;
        if (fractionsMainViewModel != null) {
            this.mainMenuLayout = new UIFractionMainLayout(nvEventQueueActivity, fractionsMainViewModel);
        }
        FractionsShopViewModel fractionsShopViewModel = this.shopViewModel;
        if (fractionsShopViewModel != null) {
            this.shopLayout = new UIFractionsShopLayout(nvEventQueueActivity, fractionsShopViewModel);
        }
        FractionsQuestsViewModel fractionsQuestsViewModel = this.questsViewModel;
        if (fractionsQuestsViewModel != null) {
            this.questsLayout = new UIFractionQuestsLayout(fractionsQuestsViewModel);
        }
        FractionsDocumentsViewModel fractionsDocumentsViewModel = this.documentsViewModel;
        if (fractionsDocumentsViewModel != null) {
            this.documentsLayout = new UIFractionsDocumentsLayout(fractionsDocumentsViewModel);
            this.testingLayout = new UIFractionsTestingLayout(fractionsDocumentsViewModel);
        }
        FractionsControlViewModel fractionsControlViewModel = this.controlViewModel;
        if (fractionsControlViewModel != null) {
            this.controlLayout = new UIFractionsControlLayout(nvEventQueueActivity, fractionsControlViewModel);
        }
        UIContainer uIContainer = this.container;
        if (uIContainer == null) {
            return;
        }
        uIContainer.addLayout(3, this.shopLayout);
        uIContainer.addLayout(4, this.controlLayout);
        uIContainer.addLayout(5, this.documentsLayout);
        uIContainer.addLayout(6, this.questsLayout);
        uIContainer.addLayout(9, this.testingLayout);
        uIContainer.addLayout(11, this.mainMenuLayout);
    }

    private final void initPopupWindow() {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        Object systemService = nvEventQueueActivity == null ? null : nvEventQueueActivity.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this._binding = FractionMainContainerBinding.inflate((LayoutInflater) systemService);
        Glide.with(getBinding().getRoot().getContext()).load(Integer.valueOf((int) R.drawable.fractions_background_res)).placeholder((int) R.drawable.fractions_background_res).centerCrop().into(getBinding().viewBackgroundMainContainer);
        Glide.with(getBinding().getRoot().getContext()).load(Integer.valueOf((int) R.drawable.fractions_money_shop_ic)).into(getBinding().buttonMoneyShop);
        this.anim = AnimationUtils.loadAnimation(this.context, R.anim.button_click);
        PopupWindow popupWindow = new PopupWindow((View) getBinding().getRoot(), -1, -1, true);
        this.popupWindow = popupWindow;
        if (popupWindow != null) {
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public final void onDismiss() {
                    GUIFractionSystem.m235initPopupWindow$lambda35(GUIFractionSystem.this);
                }
            });
        }
        NvEventQueueActivity nvEventQueueActivity2 = this.context;
        if (nvEventQueueActivity2 != null) {
            nvEventQueueActivity2.toggleDrawing2dStuff(true);
        }
        closeAndroidsButtons();
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.setSoftInputMode(48);
        }
        PopupWindow popupWindow3 = this.popupWindow;
        if (popupWindow3 == null) {
            return;
        }
        NvEventQueueActivity nvEventQueueActivity3 = this.context;
        popupWindow3.showAtLocation(nvEventQueueActivity3 != null ? nvEventQueueActivity3.getParentLayout() : null, 17, 0, 0);
    }

    public static final void m235initPopupWindow$lambda35(GUIFractionSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FractionsMainViewModel fractionsMainViewModel = this$0.mainViewModel;
        if (fractionsMainViewModel == null) {
            return;
        }
        fractionsMainViewModel.sendButtonPressed(this$0.currentLayout, 1);
    }

    public final void closeAndroidsButtons() {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (nvEventQueueActivity == null) {
            return;
        }
        new Useful().closeAndroidsInterface(nvEventQueueActivity, this.popupWindow);
    }

    @Override
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return false;
        }
        Intrinsics.checkNotNull(popupWindow);
        return popupWindow.isShowing();
    }

    @Override
    public void close(JSONObject jSONObject) {
        GUIManager.hideSystemUI(getBinding().getRoot());
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (nvEventQueueActivity != null) {
            //nvEventQueueActivity.toggleDrawing2dStuff(false);
        }
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        Glide.with(getBinding().getRoot().getContext()).clear(getBinding().getRoot());
        this.context = null;
        this.container = null;
        this.mainMenuLayout = null;
        this.questsLayout = null;
        this.controlLayout = null;
        this.documentsLayout = null;
        this.testingLayout = null;
        this.shopLayout = null;
        this.mainViewModel = null;
        this.buyTokensDialog = null;
        this.testResultDialog = null;
        this.controlViewModel = null;
        this.documentsViewModel = null;
        this.shopViewModel = null;
        this.questsViewModel = null;
        this.anim = null;
        this.popupWindow = null;
    }

    private final List<FractionControlListOfPlayers> makeListOfPlayersControlInterface(List<String> list, List<Integer> list2) {
        ArrayList arrayList = new ArrayList();
        List<String> list3 = list;
        if (!(list3 == null || list3.isEmpty())) {
            List<Integer> list4 = list2;
            if (!(list4 == null || list4.isEmpty())) {
                int size = list.size();
                int i = 0;
                while (i < size) {
                    int i2 = i + 1;
                    int i3 = i2 * 3;
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = i3 - 3; i4 < i3; i4++) {
                        arrayList2.add(list2.get(i4));
                    }
                    arrayList.add(new FractionControlListOfPlayers(((Number) arrayList2.get(0)).intValue(), list.get(i), ((Number) arrayList2.get(1)).intValue(), ((Number) arrayList2.get(2)).intValue()));
                    i = i2;
                }
            }
        }
        return arrayList;
    }

    private final List<Integer> getListOfImagesFunction(String str) {
        Resources resources;
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (i < 11) {
            int i2 = i + 1;
            String stringPlus = Intrinsics.stringPlus(str, Integer.valueOf(i));
            NvEventQueueActivity nvEventQueueActivity = this.context;
            if (nvEventQueueActivity != null && (resources = nvEventQueueActivity.getResources()) != null) {
                arrayList.add(Integer.valueOf(resources.getIdentifier(stringPlus, "drawable", nvEventQueueActivity.getPackageName())));
            }
            i = i2;
        }
        return arrayList;
    }

    private final List<Integer> getListOfImagesForAdapter(int i) {
        if (i != 11) {
            switch (i) {
                case 1:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_GOVERNMENT);
                case 2:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_DEPARTMENT);
                case 3:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_HOSPITAL);
                case 4:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_MASS_MEDIA);
                case 5:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_MVD);
                case 6:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_MVD);
                case 7:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_MVD);
                default:
                    return new ArrayList();
            }
        }
        return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_MVD);
    }

    private final List<String> getListOfPositionForAdapter(int i) {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        Resources resources5;
        Resources resources6;
        Resources resources7;
        Resources resources8;
        ArrayList arrayList = new ArrayList();
        String[] strArr = null;
        if (i != 11) {
            switch (i) {
                case 1:
                    NvEventQueueActivity nvEventQueueActivity = this.context;
                    if (nvEventQueueActivity != null && (resources2 = nvEventQueueActivity.getResources()) != null) {
                        strArr = resources2.getStringArray(R.array.fractions_government_staff_array);
                    }
                    Intrinsics.checkNotNull(strArr);
                    Intrinsics.checkNotNullExpressionValue(strArr, "context?.resources?.getS…government_staff_array)!!");
                    CollectionsKt.addAll(arrayList, strArr);
                    break;
                case 2:
                    NvEventQueueActivity nvEventQueueActivity2 = this.context;
                    if (nvEventQueueActivity2 != null && (resources3 = nvEventQueueActivity2.getResources()) != null) {
                        strArr = resources3.getStringArray(R.array.fractions_army_staff_array);
                    }
                    Intrinsics.checkNotNull(strArr);
                    Intrinsics.checkNotNullExpressionValue(strArr, "context?.resources?.getS…tions_army_staff_array)!!");
                    CollectionsKt.addAll(arrayList, strArr);
                    break;
                case 3:
                    NvEventQueueActivity nvEventQueueActivity3 = this.context;
                    if (nvEventQueueActivity3 != null && (resources4 = nvEventQueueActivity3.getResources()) != null) {
                        strArr = resources4.getStringArray(R.array.fractions_hospital_staff_array);
                    }
                    Intrinsics.checkNotNull(strArr);
                    Intrinsics.checkNotNullExpressionValue(strArr, "context?.resources?.getS…s_hospital_staff_array)!!");
                    CollectionsKt.addAll(arrayList, strArr);
                    break;
                case 4:
                    NvEventQueueActivity nvEventQueueActivity4 = this.context;
                    if (nvEventQueueActivity4 != null && (resources5 = nvEventQueueActivity4.getResources()) != null) {
                        strArr = resources5.getStringArray(R.array.fractions_mass_media_staff_array);
                    }
                    Intrinsics.checkNotNull(strArr);
                    Intrinsics.checkNotNullExpressionValue(strArr, "context?.resources?.getS…mass_media_staff_array)!!");
                    CollectionsKt.addAll(arrayList, strArr);
                    break;
                case 5:
                    NvEventQueueActivity nvEventQueueActivity5 = this.context;
                    if (nvEventQueueActivity5 != null && (resources6 = nvEventQueueActivity5.getResources()) != null) {
                        strArr = resources6.getStringArray(R.array.fractions_army_staff_array);
                    }
                    Intrinsics.checkNotNull(strArr);
                    Intrinsics.checkNotNullExpressionValue(strArr, "context?.resources?.getS…tions_army_staff_array)!!");
                    CollectionsKt.addAll(arrayList, strArr);
                    break;
                case 6:
                    NvEventQueueActivity nvEventQueueActivity6 = this.context;
                    if (nvEventQueueActivity6 != null && (resources7 = nvEventQueueActivity6.getResources()) != null) {
                        strArr = resources7.getStringArray(R.array.fractions_army_staff_array);
                    }
                    Intrinsics.checkNotNull(strArr);
                    Intrinsics.checkNotNullExpressionValue(strArr, "context?.resources?.getS…tions_army_staff_array)!!");
                    CollectionsKt.addAll(arrayList, strArr);
                    break;
                case 7:
                    NvEventQueueActivity nvEventQueueActivity7 = this.context;
                    if (nvEventQueueActivity7 != null && (resources8 = nvEventQueueActivity7.getResources()) != null) {
                        strArr = resources8.getStringArray(R.array.fractions_army_staff_array);
                    }
                    Intrinsics.checkNotNull(strArr);
                    Intrinsics.checkNotNullExpressionValue(strArr, "context?.resources?.getS…tions_army_staff_array)!!");
                    CollectionsKt.addAll(arrayList, strArr);
                    break;
            }
        } else {
            NvEventQueueActivity nvEventQueueActivity8 = this.context;
            if (nvEventQueueActivity8 != null && (resources = nvEventQueueActivity8.getResources()) != null) {
                strArr = resources.getStringArray(R.array.fractions_army_staff_array);
            }
            Intrinsics.checkNotNull(strArr);
            Intrinsics.checkNotNullExpressionValue(strArr, "context?.resources?.getS…tions_army_staff_array)!!");
            CollectionsKt.addAll(arrayList, strArr);
        }
        return arrayList;
    }
}
