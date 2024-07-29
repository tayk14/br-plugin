package com.rockstargames.gtacr.gui;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.network.SmiInfo;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.adapters.SmiEditorAdapter;
import com.rockstargames.gtacr.adapters.SmiEditorCarsAndAccessoriesAdapter;
import com.rockstargames.gtacr.data.DataSmiInfoAll;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class GUISmiEditor implements ISAMPGUI, SmiEditorAdapter.OnUserClickListenerSmiEditor, SmiEditorCarsAndAccessoriesAdapter.OnUserClickCarsAndAccessories {
    private static final float ACTIVITY_BUTTON = 1.0f;
    private static final int EDIT_ADS = 1;
    private static final String KEY_ACTION_TYPE = "t";
    private static final String KEY_GET_START_TEXT_ADS = "d";
    private static final String KEY_GET_VALUE_COUNT_ADS = "a";
    private static final String KEY_PUT_DATA_TO_SERVER = "s";
    private static final int LENGTH_HAND_ADS = 14;
    private static final float NO_ACTIVITY_BUTTON = 0.5f;
    private static final int THIS_ADS = 0;
    private static final int VALUE_ACTION_GET_ADS_OR_CLEANING_DIALOG = 1;
    private static final int VALUE_ACTION_GET_ADS_OR_CLOSE_DIALOG = 0;
    private static final int VALUE_ACTION_REPLACE_COUNT = 2;
    private static final int VALUE_OPERATION_CANCEL = 0;
    private static final int VALUE_OPERATION_DISMISS = 3;
    private static final int VALUE_OPERATION_NEXT = 2;
    private static final int VALUE_OPERATION_SEND_DATA = 1;
    private static final String emptyValue = "";
    private SmiEditorCarsAndAccessoriesAdapter accessoriesAdapter;
    private ImageView btBackToMenuInThirdColumn;
    private ImageButton btChangeAds;
    private Button btCloseThisWindow;
    private ConstraintLayout btReplace;
    private Button btSendToServerData;
    private SmiEditorAdapter businessLocationAdapter;
    private SmiEditorAdapter businessTypeAdapter;
    private SmiEditorAdapter carClassAdapter;
    private SmiEditorCarsAndAccessoriesAdapter carHighClassAdapter;
    private SmiEditorCarsAndAccessoriesAdapter carLowClassAdapter;
    private SmiEditorCarsAndAccessoriesAdapter carMiddleClassAdapter;
    private SmiEditorCarsAndAccessoriesAdapter carUniqueClassAdapter;
    private SmiEditorAdapter emptyAdapter;
    private SmiEditorAdapter flatClassAdapter;
    private SmiEditorAdapter flatLocationAdapter;
    private LinearLayout fourthColumn;
    private SmiEditorAdapter garageClassAdapter;
    private SmiEditorAdapter garageLocationAdapter;
    private GUIManager guiManager;
    private TextView headerSecondColumn;
    private TextView headerStartAds;
    private TextView headerThirdColumn;
    private SmiEditorAdapter housesClassAdapter;
    private SmiEditorAdapter housesLocationAdapter;
    private SmiEditorCarsAndAccessoriesAdapter motoClassAdapter;
    private SmiEditorAdapter nameClubAdapter;
    private EditText personalAdsInfo;
    private EditText personalValuePrice;
    private SmiEditorAdapter placeInterviewAdapter;
    private View rootView;
    private RecyclerView rvSecondColumn;
    private RecyclerView rvThirdColumn;
    private RecyclerView rvTypeAds;
    private TextView textThisAds;
    private SmiEditorAdapter typeAdsAdapter;
    private SmiEditorAdapter typePropertyAdapter;
    private TextView viewValueQueue;
    private final List<DataSmiInfoAll> typeAds = new ArrayList();
    private final List<DataSmiInfoAll> typeProperty = new ArrayList();
    private final List<DataSmiInfoAll> housesClass = new ArrayList();
    private final List<DataSmiInfoAll> housesLocation = new ArrayList();
    private final List<DataSmiInfoAll> flatClass = new ArrayList();
    private final List<DataSmiInfoAll> flatLocation = new ArrayList();
    private final List<DataSmiInfoAll> garageClass = new ArrayList();
    private final List<DataSmiInfoAll> garageLocation = new ArrayList();
    private final List<DataSmiInfoAll> carClass = new ArrayList();
    private final List<DataSmiInfoAll> businessType = new ArrayList();
    private final List<DataSmiInfoAll> businessLocation = new ArrayList();
    private final List<DataSmiInfoAll> emptyList = new ArrayList();
    private final List<SmiInfo> accessoriesList = new ArrayList();
    private final List<SmiInfo> carLowClassList = new ArrayList();
    private final List<SmiInfo> carMiddleClassList = new ArrayList();
    private final List<SmiInfo> carHighClassList = new ArrayList();
    private final List<SmiInfo> carUniqueClassList = new ArrayList();
    private final List<SmiInfo> motoClassList = new ArrayList();
    private final List<DataSmiInfoAll> clubList = new ArrayList();
    private final List<DataSmiInfoAll> placeInterviewList = new ArrayList();
    private final String BUY = "Куплю";
    private final String SELL = "Продам";
    private final String INTERVIEW = "Собеседования";
    private final String HOUSE = "Дом";
    private final String FLAT = "Квартира";
    private final String GARAGE = "Гараж";
    private final String CAR = "Автомобиль";
    private final String BUSINESS = "Бизнес";
    private final String ACCESSORY = "Аксессуары";
    private final String LOG = "LOG_VIEW";
    private final String ARZAMAS = "Арзамас";
    private final String LYTKARINO = "Лыткарино";
    private final String BATYREVO = "Батырево";
    private final List<String> nameTypeAds = new ArrayList(Arrays.asList("Куплю", "Продам", "Собеседования"));
    private final List<String> nameTypeProperty = new ArrayList(Arrays.asList("Дом", "Квартира", "Гараж", "Автомобиль", "Бизнес", "Аксессуары"));
    private final List<String> nameClub = new ArrayList(Arrays.asList("Арзамас", "Лыткарино", "Батырево"));
    private final List<String> placeInterview = new ArrayList(Arrays.asList("База", "Стадион"));
    private final List<String> nameHousesClass = new ArrayList(Arrays.asList("Низкий класс", "Средний класс", "Высокий класс", "Деревенский дом"));
    private final List<String> nameHousesLocation = new ArrayList(Arrays.asList("г.Арзамас", "г.Южный", "пгт.Батырево", "г.Эдово", "г.Лыткарино", "д.Корякино", "д.Егоровка", "п.Рублевка", "п.Бусаево"));
    private final List<String> nameFlatClass = new ArrayList(Arrays.asList("Низкий класс", "Средний класс", "Высокий класс"));
    private final List<String> nameFlatLocation = new ArrayList(Arrays.asList("г.Арзамас", "г.Южный", "пгт.Батырево", "г.Эдово", "г.Лыткарино", "д.Корякино", "д.Егоровка", "п.Рублевка", "п.Бусаево"));
    private final List<String> nameGarageClass = new ArrayList(Arrays.asList("Низкий класс", "Высокий класс"));
    private final List<String> nameGarageLocation = new ArrayList(Arrays.asList("г.Арзамас", "г.Южный", "пгт.Батырево", "г.Эдово", "г.Лыткарино", "д.Корякино", "д.Егоровка", "п.Рублевка", "п.Бусаево"));
    private final List<String> nameCarClass = new ArrayList(Arrays.asList("Низкий класс", "Средний класс", "Высокий класс", "Уникальный класс", "Мотоциклы"));
    private final List<String> nameBusinessType = new ArrayList(Arrays.asList("АЗС", "Магазин 24/7", "Магазин оружия", "Магазин одежды", "Магазин аксессуаров", "Закусочная", "Казино", "СТО", "Тюнинг подвески", "ЧИП-тюнинг", "Тюнинг тонировки", "Автосалон НК", "Автосалон СК", "Автосалон ВК", "Грузовой автосалон", "Мотосалон 'Harley Davidson'", "Строительная компания", "Ларек"));
    private final List<String> nameBusinessLocation = new ArrayList(Arrays.asList("г.Арзамас", "г.Южный", "пгт.Батырево", "г.Эдово", "г.Лыткарино", "д.Корякино", "д.Егоровка", "п.Рублевка", "п.Бусаево"));
    private NvEventQueueActivity contextActivity = null;
    private PopupWindow popupWindow = null;
    private Animation anim = null;
    private String valuePrice = "";
    private int valueThisAds = 0;
    private String getStartTextAds = "";
    private String getEditTextAds = "";
    private String personalEditText = "";
    private int getValueCountAds = 0;
    private final String[] valueSentToJsonIfBuyOrSell = {"", "", "", ""};
    private String endSendText = "";
    private final String[] textValue = {"", "", "", "", "", "", ""};
    private final String[] textPrice = {"", ""};

    @Override
    public int getGuiId() {
        return 24;
    }

    public static ISAMPGUI newInstance() {
        return new GUISmiEditor();
    }

    @Override
    public void onPacketIncoming(JSONObject json) {
        int optInt = json.optInt("t");
        if (optInt == 0) {
            String optString = json.optString("d");
            this.getStartTextAds = optString;
            if (!optString.equals("")) {
                cleaningDataInThisDialog();
                setEmptyList();
                this.valueThisAds = 0;
                setValueStartAds(this.getStartTextAds);
                regularVarAndSetTextInHeader();
                return;
            }
            this.popupWindow.dismiss();
        } else if (optInt != 1) {
            if (optInt != 2) {
                return;
            }
            int optInt2 = json.optInt("a");
            this.getValueCountAds = optInt2;
            this.viewValueQueue.setText(String.valueOf(optInt2));
        } else {
            String optString2 = json.optString("d");
            this.getStartTextAds = optString2;
            if (optString2.equals("")) {
                return;
            }
            cleaningDataInThisDialog();
            setEmptyList();
            this.valueThisAds = 0;
            setValueStartAds(this.getStartTextAds);
            regularVarAndSetTextInHeader();
        }
    }

    @Override
    public void show(JSONObject json, GUIManager manager, final NvEventQueueActivity activity) {
        this.contextActivity = activity;
        this.guiManager = manager;
        if (this.popupWindow == null) {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.smi_dialog, (ViewGroup) null, false);
            this.rootView = inflate;
            this.btBackToMenuInThirdColumn = (ImageView) inflate.findViewById(R.id.button_back_to_menu_in_third_column);
            this.btCloseThisWindow = (Button) this.rootView.findViewById(R.id.button_delete_info_smi);
            this.btSendToServerData = (Button) this.rootView.findViewById(R.id.button_send_info_smi);
            this.headerSecondColumn = (TextView) this.rootView.findViewById(R.id.header_second_column);
            this.headerThirdColumn = (TextView) this.rootView.findViewById(R.id.header_thirds_column);
            this.personalValuePrice = (EditText) this.rootView.findViewById(R.id.value_price);
            this.personalAdsInfo = (EditText) this.rootView.findViewById(R.id.personal_smi_writer);
            this.viewValueQueue = (TextView) this.rootView.findViewById(R.id.value_queue);
            this.headerStartAds = (TextView) this.rootView.findViewById(R.id.header_start_text);
            this.textThisAds = (TextView) this.rootView.findViewById(R.id.text_in_header);
            this.btChangeAds = (ImageButton) this.rootView.findViewById(R.id.button_change_view_ads);
            this.btReplace = (ConstraintLayout) this.rootView.findViewById(R.id.button_replace_smi_info);
            this.fourthColumn = (LinearLayout) this.rootView.findViewById(R.id.fourth_column);
            this.personalAdsInfo.setHintTextColor(activity.getResources().getColor(R.color.bg_color_hint));
            this.personalValuePrice.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable editable) {
                }

                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    String charSequence2 = charSequence.toString();
                    if (charSequence2.length() <= 0) {
                        GUISmiEditor.this.valuePrice = "";
                    } else if (charSequence2.charAt(0) != '0') {
                        GUISmiEditor.this.valuePrice = charSequence2;
                    } else {
                        GUISmiEditor.this.valuePrice = "";
                    }
                    GUISmiEditor.this.regularVarAndSetTextInHeader();
                }
            });
            this.personalAdsInfo.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable editable) {
                }

                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    GUISmiEditor.this.personalEditText = charSequence.toString();
                    GUISmiEditor.this.regularVarAndSetTextInHeader();
                }
            });
            this.anim = AnimationUtils.loadAnimation(this.contextActivity, R.anim.button_click);
            PopupWindow popupWindow = new PopupWindow(this.rootView, -1, -1, true);
            this.popupWindow = popupWindow;
            popupWindow.setSoftInputMode(16);
            this.guiManager.setCustomTouchInterceptor(this.popupWindow);
            setDataInList(this.nameTypeAds, this.typeAds);
            setDataInList(this.nameTypeProperty, this.typeProperty);
            setDataInList(this.nameHousesClass, this.housesClass);
            setDataInList(this.nameHousesLocation, this.housesLocation);
            setDataInList(this.nameFlatClass, this.flatClass);
            setDataInList(this.nameFlatLocation, this.flatLocation);
            setDataInList(this.nameGarageClass, this.garageClass);
            setDataInList(this.nameGarageLocation, this.garageLocation);
            setDataInList(this.nameCarClass, this.carClass);
            setDataInList(this.nameBusinessType, this.businessType);
            setDataInList(this.nameBusinessLocation, this.businessLocation);
            setDataInList(this.nameClub, this.clubList);
            setDataInList(this.placeInterview, this.placeInterviewList);
            setDataForJsonInList(App.getInstance().getSmiListItems().getAccessoriesList(), this.accessoriesList);
            setDataForJsonInList(App.getInstance().getSmiListItems().getLowClass(), this.carLowClassList);
            setDataForJsonInList(App.getInstance().getSmiListItems().getCarMiddleClass(), this.carMiddleClassList);
            setDataForJsonInList(App.getInstance().getSmiListItems().getCarHighClass(), this.carHighClassList);
            setDataForJsonInList(App.getInstance().getSmiListItems().getCarUniqueClass(), this.carUniqueClassList);
            setDataForJsonInList(App.getInstance().getSmiListItems().getCarMotoClass(), this.motoClassList);
            this.rvTypeAds = (RecyclerView) this.rootView.findViewById(R.id.type_ads);
            this.rvSecondColumn = (RecyclerView) this.rootView.findViewById(R.id.rv_second_column);
            this.rvThirdColumn = (RecyclerView) this.rootView.findViewById(R.id.rv_third_column);
            this.rvTypeAds.setLayoutManager(setLayoutManager(this.rootView));
            this.rvSecondColumn.setLayoutManager(setLayoutManager(this.rootView));
            this.rvThirdColumn.setLayoutManager(setLayoutManager(this.rootView));
            this.emptyAdapter = new SmiEditorAdapter(this.emptyList, this, 0);
            this.typeAdsAdapter = new SmiEditorAdapter(this.typeAds, this, 1);
            this.typePropertyAdapter = new SmiEditorAdapter(this.typeProperty, this, 2);
            this.nameClubAdapter = new SmiEditorAdapter(this.clubList, this, 2);
            this.housesClassAdapter = new SmiEditorAdapter(this.housesClass, this, 3);
            this.flatClassAdapter = new SmiEditorAdapter(this.flatClass, this, 3);
            this.garageClassAdapter = new SmiEditorAdapter(this.garageClass, this, 3);
            this.carClassAdapter = new SmiEditorAdapter(this.carClass, this, 3);
            this.businessTypeAdapter = new SmiEditorAdapter(this.businessType, this, 3);
            this.placeInterviewAdapter = new SmiEditorAdapter(this.placeInterviewList, this, 3);
            this.accessoriesAdapter = new SmiEditorCarsAndAccessoriesAdapter(this.accessoriesList, this);
            this.housesLocationAdapter = new SmiEditorAdapter(this.housesLocation, this, 4);
            this.flatLocationAdapter = new SmiEditorAdapter(this.flatLocation, this, 4);
            this.garageLocationAdapter = new SmiEditorAdapter(this.garageLocation, this, 4);
            this.businessLocationAdapter = new SmiEditorAdapter(this.businessLocation, this, 4);
            this.carLowClassAdapter = new SmiEditorCarsAndAccessoriesAdapter(this.carLowClassList, this);
            this.carMiddleClassAdapter = new SmiEditorCarsAndAccessoriesAdapter(this.carMiddleClassList, this);
            this.carHighClassAdapter = new SmiEditorCarsAndAccessoriesAdapter(this.carHighClassList, this);
            this.carUniqueClassAdapter = new SmiEditorCarsAndAccessoriesAdapter(this.carUniqueClassList, this);
            this.motoClassAdapter = new SmiEditorCarsAndAccessoriesAdapter(this.motoClassList, this);
            invisibilityButtonBackToMenu(false);
            this.rvTypeAds.setAdapter(this.typeAdsAdapter);
            this.btBackToMenuInThirdColumn.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUISmiEditor.this.lambda$show$1$GUISmiEditor(view);
                }
            });
            this.btCloseThisWindow.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUISmiEditor.this.lambda$show$2$GUISmiEditor(view);
                }
            });
            this.btSendToServerData.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUISmiEditor.this.lambda$show$3$GUISmiEditor(view);
                }
            });
            this.btReplace.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUISmiEditor.this.lambda$show$4$GUISmiEditor(view);
                }
            });
            String optString = json.optString("d");
            this.getStartTextAds = optString;
            setValueStartAds(optString);
            this.viewValueQueue.setText(String.valueOf(json.optInt("a")));
            this.btChangeAds.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUISmiEditor.this.lambda$show$5$GUISmiEditor(view);
                }
            });
        }
        this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public final void onDismiss() {
                GUISmiEditor.this.lambda$show$6$GUISmiEditor();
            }
        });
        activity.getParentLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    GUIManager.hideSystemUI(GUISmiEditor.this.popupWindow.getContentView());
                } catch (Exception unused) {
                    activity.getParentLayout().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            GUIManager.hideSystemUI(GUISmiEditor.this.popupWindow.getContentView());
                        }
                    }, 1000L);
                }
            }
        }, 300L);
        this.popupWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
    }

    public void lambda$show$1$GUISmiEditor(View view) {
        view.startAnimation(this.anim);
        cleaningViewAds(2);
        regularVarAndSetTextInHeader();
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                GUISmiEditor.this.lambda$null$0$GUISmiEditor();
            }
        }, 300L);
    }

    public void lambda$null$0$GUISmiEditor() {
        char r0 = 2;
        cleaningSendArray(2);
        //java.lang.String r1 = r5.valueSentToJsonIfBuyOrSell[1];
    }

    public void lambda$show$2$GUISmiEditor(View view) {
        view.startAnimation(this.anim);
        putInfoForClickCancelOrNextOrDismiss(0);
    }

    public void lambda$show$3$GUISmiEditor(View view) {
        if (this.btSendToServerData.getAlpha() == 1.0f) {
            view.startAnimation(this.anim);
            if (!this.personalEditText.equals("") && this.personalEditText.length() > 14) {
                this.endSendText = this.personalEditText;
            } else {
                this.endSendText = this.getEditTextAds;
            }
            putDataToServer(this.endSendText);
            Log.v("LOG_VIEW", this.endSendText);
        }
    }

    public void lambda$show$4$GUISmiEditor(View view) {
        view.startAnimation(this.anim);
        putInfoForClickCancelOrNextOrDismiss(2);
    }

    public void lambda$show$5$GUISmiEditor(View view) {
        view.startAnimation(this.anim);
        int i = this.valueThisAds;
        if (i == 0) {
            this.valueThisAds = 1;
            regularVarAndSetTextInHeader();
            this.headerStartAds.setText(R.string.smi_dialog_header_edit_ad);
        } else if (i != 1) {
        } else {
            this.valueThisAds = 0;
            setValueStartAds(this.getStartTextAds);
        }
    }

    public void lambda$show$6$GUISmiEditor() {
        putInfoForClickCancelOrNextOrDismiss(3);
        this.guiManager.closeGUI(null, 24);
    }

    private void setDataInList(final List<String> thisData, final List<DataSmiInfoAll> thisFillList) {
        Single.create(new SingleOnSubscribe() {
            @Override
            public final void subscribe(SingleEmitter singleEmitter) {
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    public static void lambda$setDataInList$7(final List thisData, final List thisFillList, SingleEmitter subscriber) throws Throwable {
        for (int i = 0; i < thisData.size(); i++) {
            thisFillList.add(new DataSmiInfoAll(i, (String) thisData.get(i)));
        }
        subscriber.onSuccess(thisFillList);
    }

    private void setDataForJsonInList(final List<SmiInfo> jsonList, final List<SmiInfo> localList) {
        Single.create(new SingleOnSubscribe() {
            @Override
            public final void subscribe(SingleEmitter singleEmitter) {
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    public static void lambda$setDataForJsonInList$8(final List localList, final List jsonList, SingleEmitter subscriber) throws Throwable {
        localList.addAll(jsonList);
        subscriber.onSuccess(localList);
    }

    private void setValueStartAds(String textAds) {
        this.textThisAds.setText(textAds);
        this.headerStartAds.setText(R.string.smi_dialog_header_start_ad);
    }

    private RecyclerView.LayoutManager setLayoutManager(View view) {
        return new LinearLayoutManager(view.getContext(), 1, false);
    }

    private void setEmptySecondAndThirdAdapters() {
        this.rvSecondColumn.setAdapter(this.emptyAdapter);
        this.rvThirdColumn.setAdapter(this.emptyAdapter);
    }

    private void setEmptyList() {
        Arrays.fill(this.valueSentToJsonIfBuyOrSell, "");
    }

    private void setNotClickableForThirdAndFourthColumn() {
        setNotClickableForList(this.housesClass);
        setNotClickableForList(this.flatClass);
        setNotClickableForList(this.garageClass);
        setNotClickableForList(this.carClass);
        setNotClickableForList(this.businessType);
        setNotClickableForList(this.placeInterviewList);
        setNotClickableForFourthColumn();
    }

    private void setNotClickableForFourthColumn() {
        setNotClickableForList(this.housesLocation);
        setNotClickableForList(this.flatLocation);
        setNotClickableForList(this.garageLocation);
        setNotClickableForList(this.businessLocation);
    }

    private void setNotClickableForList(List<DataSmiInfoAll> thisFillList) {
        for (int i = 0; i < thisFillList.size(); i++) {
            thisFillList.get(i).setCheckedSwitchSmiElement(false);
        }
    }

    private void setNotClickableForCarsAndAccessories(final List<SmiInfo> thisFillList) {
        Single.create(new SingleOnSubscribe() {
            @Override
            public final void subscribe(SingleEmitter singleEmitter) {
                try {
                    GUISmiEditor.lambda$setNotClickableForCarsAndAccessories$9(thisFillList, singleEmitter);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    public static void lambda$setNotClickableForCarsAndAccessories$9(final List thisFillList, SingleEmitter subscribe) throws Throwable {
        for (int i = 0; i < thisFillList.size(); i++) {
            ((SmiInfo) thisFillList.get(i)).setChecked(false);
        }
        subscribe.onSuccess(thisFillList);
    }

    private void invisibilityButtonBackToMenu(boolean visibility) {
        if (!visibility) {
            this.btBackToMenuInThirdColumn.setVisibility(4);
        } else {
            this.btBackToMenuInThirdColumn.setVisibility(0);
        }
    }

    private void setAllElementToNotClickableInThisColumn(List<DataSmiInfoAll> dataSmiInfoAllList) {
        for (int i = 0; i < dataSmiInfoAllList.size(); i++) {
            dataSmiInfoAllList.get(i).setCheckedSwitchSmiElement(false);
        }
    }

    private void setDataAfterBackClick(SmiEditorAdapter adapter, int strIdRes) {
        this.rvThirdColumn.setAdapter(adapter);
        invisibilityButtonBackToMenu(false);
        this.headerThirdColumn.setText(strIdRes);
    }

    @Override
    public void clickable(final DataSmiInfoAll dataSmiInfoAll, final int getPosition, int column) {
        char c;
        char c2 = 65535;
        if (column == 1) {
            invisibilityButtonBackToMenu(false);
            cleaningSendArray(0);
            setNotClickableForList(this.typeProperty);
            setNotClickableForList(this.clubList);
            setNotClickableForThirdAndFourthColumn();
            setCleaningAdapterInRV(1);
            this.headerThirdColumn.setText("");
            cleaningViewAds(0);
            regularVarAndSetTextInHeader();
            String nameSmiElement = dataSmiInfoAll.getNameSmiElement();
            nameSmiElement.hashCode();
            switch (nameSmiElement.hashCode()) {
                case -913844169:
                    if (nameSmiElement.equals("Собеседования")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1003278313:
                    if (nameSmiElement.equals("Куплю")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1177195459:
                    if (nameSmiElement.equals("Продам")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    checkClickableAndCleaningRVInFirstColumn(dataSmiInfoAll, getPosition);
                    setOrRemoveData(dataSmiInfoAll, 0, "Проходит собеседование");
                    regularVarAndSetTextInHeader();
                    break;
                case 1:
                case 2:
                    checkClickableAndCleaningRVInFirstColumn(dataSmiInfoAll, getPosition);
                    setOrRemoveData(dataSmiInfoAll, 0, this.valueSentToJsonIfBuyOrSell[0]);
                    regularVarAndSetTextInHeader();
                    break;
            }
        }
        if (column != 2) {
            if (column == 3) {
                setNotClickableForFourthColumn();
                cleaningViewAds(2);
                regularVarAndSetTextInHeader();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public final void run() {
                        GUISmiEditor.this.lambda$clickable$10$GUISmiEditor(dataSmiInfoAll, getPosition);
                    }
                }, 200L);
                return;
            } else if (column != 4) {
                return;
            } else {
                cleaningViewAds(3);
                regularVarAndSetTextInHeader();
                String str = this.valueSentToJsonIfBuyOrSell[1];
                str.hashCode();
                switch (str.hashCode()) {
                    case 1038034:
                        if (str.equals("Дом")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 768799449:
                        if (str.equals("Бизнес")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 996248233:
                        if (str.equals("Гараж")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1655011854:
                        if (str.equals("Квартира")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        checkClickableLocationsColumn(dataSmiInfoAll, this.housesLocationAdapter, getPosition);
                        setOrRemoveData(dataSmiInfoAll, 3, "в " + this.valueSentToJsonIfBuyOrSell[3]);
                        break;
                    case 1:
                        checkClickableLocationsColumn(dataSmiInfoAll, this.businessLocationAdapter, getPosition);
                        setOrRemoveData(dataSmiInfoAll, 3, "в " + this.valueSentToJsonIfBuyOrSell[3]);
                        break;
                    case 2:
                        checkClickableLocationsColumn(dataSmiInfoAll, this.garageLocationAdapter, getPosition);
                        setOrRemoveData(dataSmiInfoAll, 3, "в " + this.valueSentToJsonIfBuyOrSell[3]);
                        break;
                    case 3:
                        checkClickableLocationsColumn(dataSmiInfoAll, this.flatLocationAdapter, getPosition);
                        setOrRemoveData(dataSmiInfoAll, 3, "в " + this.valueSentToJsonIfBuyOrSell[3]);
                        break;
                }
                regularVarAndSetTextInHeader();
                return;
            }
        }
        invisibilityButtonBackToMenu(false);
        setNotClickableForThirdAndFourthColumn();
        cleaningSendArray(1);
        cleaningViewAds(1);
        regularVarAndSetTextInHeader();
        String nameSmiElement2 = dataSmiInfoAll.getNameSmiElement();
        nameSmiElement2.hashCode();
        switch (nameSmiElement2.hashCode()) {
            case -1637170760:
                if (nameSmiElement2.equals("Автомобиль")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1038034:
                if (nameSmiElement2.equals("Дом")) {
                    c2 = 1;
                    break;
                }
                break;
            case 89098870:
                if (nameSmiElement2.equals("Аксессуары")) {
                    c2 = 2;
                    break;
                }
                break;
            case 768799449:
                if (nameSmiElement2.equals("Бизнес")) {
                    c2 = 3;
                    break;
                }
                break;
            case 996248233:
                if (nameSmiElement2.equals("Гараж")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1480889089:
                if (nameSmiElement2.equals("Лыткарино")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1655011854:
                if (nameSmiElement2.equals("Квартира")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1699095972:
                if (nameSmiElement2.equals("Арзамас")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1900001225:
                if (nameSmiElement2.equals("Батырево")) {
                    c2 = '\b';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                checkClickableAndCleaningRVInSecondColumn(dataSmiInfoAll, this.carClassAdapter, getPosition);
                visibilityTextIfChecked(dataSmiInfoAll, this.headerThirdColumn, R.string.smi_dialog_header_third_column_classes);
                setOrRemoveData(dataSmiInfoAll, 1, "автомобиль");
                break;
            case 1:
                checkClickableAndCleaningRVInSecondColumn(dataSmiInfoAll, this.housesClassAdapter, getPosition);
                visibilityTextIfChecked(dataSmiInfoAll, this.headerThirdColumn, R.string.smi_dialog_header_third_column_classes);
                setOrRemoveData(dataSmiInfoAll, 1, "дом");
                break;
            case 2:
                setNotClickableForCarsAndAccessories(this.accessoriesList);
                checkClickableAndCleaningRVInAccessoriesSecondColumn(dataSmiInfoAll, this.accessoriesAdapter, getPosition);
                visibilityTextIfChecked(dataSmiInfoAll, this.headerThirdColumn, R.string.smi_dialog_header_third_column_accessories);
                setOrRemoveData(dataSmiInfoAll, 1, "а/с");
                break;
            case 3:
                checkClickableAndCleaningRVInSecondColumn(dataSmiInfoAll, this.businessTypeAdapter, getPosition);
                visibilityTextIfChecked(dataSmiInfoAll, this.headerThirdColumn, R.string.smi_dialog_header_third_column_types);
                setOrRemoveData(dataSmiInfoAll, 1, "бизнес");
                break;
            case 4:
                checkClickableAndCleaningRVInSecondColumn(dataSmiInfoAll, this.garageClassAdapter, getPosition);
                visibilityTextIfChecked(dataSmiInfoAll, this.headerThirdColumn, R.string.smi_dialog_header_third_column_classes);
                setOrRemoveData(dataSmiInfoAll, 1, "гараж");
                break;
            case 5:
            case 7:
            case '\b':
                checkClickableAndCleaningRVInSecondColumnIfInterview(dataSmiInfoAll, this.placeInterviewAdapter, getPosition);
                visibilityTextIfChecked(dataSmiInfoAll, this.headerThirdColumn, R.string.smi_dialog_header_third_column_locations);
                String nameSmiElement3 = dataSmiInfoAll.getNameSmiElement();
                setOrRemoveData(dataSmiInfoAll, 1, " в ОПГ \"" + nameSmiElement3 + "\". ");
                break;
            case 6:
                checkClickableAndCleaningRVInSecondColumn(dataSmiInfoAll, this.flatClassAdapter, getPosition);
                visibilityTextIfChecked(dataSmiInfoAll, this.headerThirdColumn, R.string.smi_dialog_header_third_column_classes);
                setOrRemoveData(dataSmiInfoAll, 1, "квартиру");
                break;
        }
        regularVarAndSetTextInHeader();
    }

    public void lambda$clickable$10$GUISmiEditor(final DataSmiInfoAll r9, final int r10) {
        char r0;
    }

    @Override
    public void userClick(blackrussia.online.network.SmiInfo r6, int r7) {
        char r1 = 1;
    }

    private void visibilityTextIfChecked(DataSmiInfoAll dataSmiInfoAll, TextView textView, int resId) {
        if (dataSmiInfoAll.getCheckedSwitchSmiElement()) {
            textView.setText(resId);
        } else {
            textView.setText("");
        }
    }

    private void setOrRemoveData(DataSmiInfoAll dataSmiInfoAll, int position, String name) {
        if (dataSmiInfoAll.getCheckedSwitchSmiElement()) {
            this.textValue[position] = name;
        } else {
            this.textValue[position] = "";
        }
    }

    private void setOrRemoveDataNew(SmiInfo smiInfo, int position, String name) {
        if (smiInfo.isChecked()) {
            this.textValue[position] = name;
        } else {
            this.textValue[position] = "";
        }
    }

    private void checkClickableAndCleaningRVInFirstColumn(DataSmiInfoAll dataSmiInfoAll, int thisPosition) {
        if (dataSmiInfoAll.getCheckedSwitchSmiElement()) {
            this.valueSentToJsonIfBuyOrSell[0] = dataSmiInfoAll.getNameSmiElement();
            if (this.valueSentToJsonIfBuyOrSell[0].equals("Собеседования")) {
                this.rvSecondColumn.setAdapter(this.nameClubAdapter);
                this.headerSecondColumn.setText(R.string.smi_dialog_header_second_column_club);
            } else {
                this.rvSecondColumn.setAdapter(this.typePropertyAdapter);
                this.headerSecondColumn.setText(R.string.smi_dialog_header_second_column);
            }
            this.typeAdsAdapter.setOnlyCheckedElement(thisPosition);
            return;
        }
        cleaningSendArray(0);
        setCleaningAdapterInRV(0);
        setEmptyList();
        setEmptySecondAndThirdAdapters();
        invisibilityButtonBackToMenu(false);
        this.headerSecondColumn.setText("");
        this.headerThirdColumn.setText("");
    }

    private void checkClickableAndCleaningRVInSecondColumn(DataSmiInfoAll dataSmiInfoAll, SmiEditorAdapter setAdapter, int thisPosition) {
        if (dataSmiInfoAll.getCheckedSwitchSmiElement()) {
            this.valueSentToJsonIfBuyOrSell[1] = dataSmiInfoAll.getNameSmiElement();
            this.rvThirdColumn.setAdapter(setAdapter);
            this.typePropertyAdapter.setOnlyCheckedElement(thisPosition);
            return;
        }
        cleaningSendArray(1);
        setCleaningAdapterInRV(1);
        invisibilityButtonBackToMenu(false);
        this.headerThirdColumn.setText("");
    }

    private void checkClickableAndCleaningRVInSecondColumnIfInterview(DataSmiInfoAll dataSmiInfoAll, SmiEditorAdapter setAdapter, int thisPosition) {
        if (dataSmiInfoAll.getCheckedSwitchSmiElement()) {
            this.valueSentToJsonIfBuyOrSell[1] = dataSmiInfoAll.getNameSmiElement();
            this.rvThirdColumn.setAdapter(setAdapter);
            this.nameClubAdapter.setOnlyCheckedElement(thisPosition);
            return;
        }
        cleaningSendArray(1);
        setCleaningAdapterInRV(1);
        invisibilityButtonBackToMenu(false);
        this.headerThirdColumn.setText("");
    }

    private void checkClickableAndCleaningRVInAccessoriesSecondColumn(DataSmiInfoAll dataSmiInfoAll, SmiEditorCarsAndAccessoriesAdapter setAdapter, int thisPosition) {
        if (dataSmiInfoAll.getCheckedSwitchSmiElement()) {
            this.valueSentToJsonIfBuyOrSell[1] = dataSmiInfoAll.getNameSmiElement();
            this.rvThirdColumn.setAdapter(setAdapter);
            this.typePropertyAdapter.setOnlyCheckedElement(thisPosition);
            return;
        }
        cleaningSendArray(1);
        setCleaningAdapterInRV(1);
        invisibilityButtonBackToMenu(false);
        this.headerThirdColumn.setText("");
    }

    private void checkClickableAndCleaningRVInThirdColumn(DataSmiInfoAll dataSmiInfoAll, SmiEditorAdapter setAdapter, SmiEditorAdapter thisAdapter, int thisPosition) {
        if (dataSmiInfoAll.getCheckedSwitchSmiElement()) {
            this.valueSentToJsonIfBuyOrSell[2] = dataSmiInfoAll.getNameSmiElement();
            this.rvThirdColumn.setAdapter(setAdapter);
            thisAdapter.setOnlyCheckedElement(thisPosition);
            invisibilityButtonBackToMenu(true);
            return;
        }
        cleaningSendArray(2);
        invisibilityButtonBackToMenu(false);
    }

    private void checkClickableAndCleaningRVInThirdColumnIfInterview(DataSmiInfoAll dataSmiInfoAll, SmiEditorAdapter thisAdapter, int thisPosition) {
        if (dataSmiInfoAll.getCheckedSwitchSmiElement()) {
            this.valueSentToJsonIfBuyOrSell[2] = dataSmiInfoAll.getNameSmiElement();
            thisAdapter.setOnlyCheckedElement(thisPosition);
            return;
        }
        cleaningSendArray(2);
    }

    private void checkClickableAndCleaningRVInClassCarsColumn(DataSmiInfoAll dataSmiInfoAll, SmiEditorCarsAndAccessoriesAdapter setAdapter, SmiEditorAdapter thisAdapter, int thisPosition) {
        if (dataSmiInfoAll.getCheckedSwitchSmiElement()) {
            this.valueSentToJsonIfBuyOrSell[2] = dataSmiInfoAll.getNameSmiElement();
            this.rvThirdColumn.setAdapter(setAdapter);
            thisAdapter.setOnlyCheckedElement(thisPosition);
            invisibilityButtonBackToMenu(true);
            return;
        }
        cleaningSendArray(2);
        invisibilityButtonBackToMenu(false);
    }

    private void checkClickableLocationsColumn(DataSmiInfoAll dataSmiInfoAll, SmiEditorAdapter thisAdapter, int thisPosition) {
        if (dataSmiInfoAll.getCheckedSwitchSmiElement()) {
            this.valueSentToJsonIfBuyOrSell[3] = dataSmiInfoAll.getNameSmiElement();
            thisAdapter.setOnlyCheckedElement(thisPosition);
            return;
        }
        cleaningSendArray(3);
    }

    private void checkClickableCarsAndAccessoriesThirdColumn(SmiInfo dataSmiInfoAll, SmiEditorCarsAndAccessoriesAdapter thisAdapter, int thisPosition) {
        if (dataSmiInfoAll.isChecked()) {
            this.valueSentToJsonIfBuyOrSell[3] = dataSmiInfoAll.getName();
            thisAdapter.setOnlyCheckedElement(thisPosition);
            return;
        }
        cleaningSendArray(3);
    }

    private void cleaningSendArray(int startPosition) {
        while (true) {
            String[] strArr = this.valueSentToJsonIfBuyOrSell;
            if (startPosition >= strArr.length) {
                return;
            }
            strArr[startPosition] = "";
            startPosition++;
        }
    }

    private void setCleaningAdapterInRV(int endPosition) {
        if (endPosition < 2) {
            if (endPosition == 0) {
                this.rvSecondColumn.setAdapter(this.emptyAdapter);
            }
            this.rvThirdColumn.setAdapter(this.emptyAdapter);
        }
    }

    public void regularVarAndSetTextInHeader() {
        String priceWithSpacesForLong = !this.valuePrice.equals("") ? GUIManager.getPriceWithSpacesForLong(Long.parseLong(this.valuePrice)) : "";
        String str = this.valueSentToJsonIfBuyOrSell[0];
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -913844169:
                if (str.equals("Собеседования")) {
                    c = 0;
                    break;
                }
                break;
            case 1003278313:
                if (str.equals("Куплю")) {
                    c = 1;
                    break;
                }
                break;
            case 1177195459:
                if (str.equals("Продам")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                String[] strArr = this.textPrice;
                strArr[0] = "";
                strArr[1] = "";
                this.textValue[6] = "";
                break;
            case 1:
                if (!this.valuePrice.equals("")) {
                    this.textPrice[1] = priceWithSpacesForLong;
                    this.textValue[6] = "рублей";
                } else {
                    this.textPrice[1] = "свободный";
                    this.textValue[6] = "";
                }
                this.textPrice[0] = ". Бюджет:";
                break;
            case 2:
                if (!this.valuePrice.equals("")) {
                    this.textPrice[1] = priceWithSpacesForLong;
                    this.textValue[6] = "рублей";
                } else {
                    this.textPrice[1] = "договорная";
                    this.textValue[6] = "";
                }
                this.textPrice[0] = ". Цена:";
                break;
        }
        if (!this.textValue[1].equals("")) {
            String[] strArr2 = this.textValue;
            String[] strArr3 = this.textPrice;
            strArr2[4] = strArr3[0];
            strArr2[5] = strArr3[1];
        } else {
            String[] strArr4 = this.textValue;
            strArr4[4] = "";
            strArr4[5] = "";
            strArr4[6] = "";
        }
        String replaceAll = Arrays.toString(this.textValue).replaceAll("\\[|]|,|", "");
        this.getEditTextAds = replaceAll;
        String replaceAll2 = replaceAll.trim().replaceAll(" +", " ");
        this.getEditTextAds = replaceAll2;
        this.getEditTextAds = replaceAll2.replace(" .", ".");
        if (this.valueThisAds == 1) {
            if (!this.personalEditText.equals("")) {
                this.textThisAds.setText(this.personalEditText);
            } else {
                this.textThisAds.setText(this.getEditTextAds);
            }
        }
        if (!this.personalEditText.equals("")) {
            if (this.personalEditText.length() > 14) {
                this.btSendToServerData.setAlpha(1.0f);
            } else {
                this.btSendToServerData.setAlpha(0.5f);
            }
        } else if (!this.valueSentToJsonIfBuyOrSell[1].equals("")) {
            if (this.valueSentToJsonIfBuyOrSell[1].equals("Арзамас") || this.valueSentToJsonIfBuyOrSell[1].equals("Лыткарино") || this.valueSentToJsonIfBuyOrSell[1].equals("Батырево")) {
                this.fourthColumn.setVisibility(4);
                if (!this.valueSentToJsonIfBuyOrSell[2].equals("")) {
                    this.btSendToServerData.setAlpha(1.0f);
                    return;
                } else {
                    this.btSendToServerData.setAlpha(0.5f);
                    return;
                }
            }
            this.fourthColumn.setVisibility(0);
            this.btSendToServerData.setAlpha(1.0f);
        } else {
            this.btSendToServerData.setAlpha(0.5f);
            this.fourthColumn.setVisibility(4);
        }
    }

    private void getTextForClass(DataSmiInfoAll dataSmiInfoAll) {
        String str = this.valueSentToJsonIfBuyOrSell[2];
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 556211567:
                if (str.equals("Средний класс")) {
                    c = 0;
                    break;
                }
                break;
            case 664585582:
                if (str.equals("Низкий класс")) {
                    c = 1;
                    break;
                }
                break;
            case 1155880500:
                if (str.equals("Высокий класс")) {
                    c = 2;
                    break;
                }
                break;
            case 1729658608:
                if (str.equals("Деревенский дом")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setOrRemoveData(dataSmiInfoAll, 2, "среднего класса");
                return;
            case 1:
                setOrRemoveData(dataSmiInfoAll, 2, "низкого класса");
                return;
            case 2:
                setOrRemoveData(dataSmiInfoAll, 2, "высокого класса");
                return;
            case 3:
                setOrRemoveData(dataSmiInfoAll, 2, "деревенский");
                return;
            default:
                return;
        }
    }

    private void cleaningViewAds(int getPosition) {
        while (true) {
            String[] strArr = this.textValue;
            if (getPosition >= strArr.length) {
                return;
            }
            strArr[getPosition] = "";
            getPosition++;
        }
    }

    private void cleaningDataInThisDialog() {
        setNotClickableForList(this.typeAds);
        setNotClickableForList(this.typeProperty);
        setNotClickableForThirdAndFourthColumn();
        this.personalValuePrice.setText("");
        this.personalAdsInfo.setText("");
        this.personalAdsInfo.setHint(R.string.smi_dialog_bg_hand_ad);
        this.headerSecondColumn.setText("");
        this.headerThirdColumn.setText("");
        invisibilityButtonBackToMenu(false);
        cleaningViewAds(0);
        regularVarAndSetTextInHeader();
        setEmptySecondAndThirdAdapters();
        this.rvTypeAds.setAdapter(this.typeAdsAdapter);
        setEmptyList();
    }

    private void putInfoForClickCancelOrNextOrDismiss(int valueKey) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", valueKey);
            this.guiManager.sendJsonData(24, jSONObject);
        } catch (Exception unused) {
        }
    }

    private void putDataToServer(String data) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 1);
            jSONObject.put("s", data);
            this.guiManager.sendJsonData(24, jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override
    public void close(JSONObject json) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
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
