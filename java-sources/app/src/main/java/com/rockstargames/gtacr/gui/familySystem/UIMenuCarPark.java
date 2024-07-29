package com.rockstargames.gtacr.gui.familySystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesMenuCarParkLayoutBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyMenuMainAdapter;
import com.rockstargames.gtacr.adapters.FamilyPlayersActionAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.FamilyMainItemData;
import com.rockstargames.gtacr.data.FamilyPlayersAction;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u0019H\u0002J\u0018\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u0019H\u0002J\b\u00100\u001a\u00020(H\u0016J\u001a\u00101\u001a\u00020(2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u00020\u001bH\u0016J\b\u00107\u001a\u00020\u001bH\u0016J\u0010\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u0019H\u0003J\b\u0010:\u001a\u00020\u001bH\u0003J$\u0010;\u001a\u00020\u001b2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00190\b2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\bH\u0007J\u0016\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u0019J\b\u0010B\u001a\u00020\u001bH\u0002J\b\u0010C\u001a\u00020\u001bH\u0002J\u000e\u0010D\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u0019J\b\u0010E\u001a\u00020\u001bH\u0002J\b\u0010F\u001a\u00020\u001bH\u0002J\u0006\u0010G\u001a\u00020\u001bJ\u000e\u0010H\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020JJ\u0010\u0010K\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020\u0019H\u0002J\u0006\u0010M\u001a\u00020\u001bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000RF\u0010\u0014\u001a:\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0015j\u0004\u0018\u0001`\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R[\u0010$\u001aO\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b('\u0012\u0013\u0012\u00110(¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u001b\u0018\u00010%j\u0004\u0018\u0001`*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/UIMenuCarPark;", "Lcom/rockstargames/gtacr/common/UILayout;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;)V", "actionsList", "", "Lcom/rockstargames/gtacr/data/FamilyPlayersAction;", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesMenuCarParkLayoutBinding;", "carList", "Lcom/rockstargames/gtacr/data/FamilyMainItemData;", "carsActionAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyPlayersActionAdapter;", "carsAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyMenuMainAdapter;", "clickActionsButton", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisAction", "", "action", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickActionsButton;", "currentAction", "currentCarsId", "garage", "oldActionsId", "oldTimerForClick", "", "savedRank", "setClickCar", "Lkotlin/Function3;", "item", "position", "Landroid/view/View;", "mView", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickMenuMainList;", "deleteCar", "carId", "getCarsInfo", "currentCar", "currentPosition", "getView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "setActionsIfDownload", "garageStatus", "setActionsIfUnload", "setCarsList", "carsId", "carsName", "", "setCurrentRankAndStatus", "carsRank", "carsStatus", "setDataWithActionsInView", "setDataWithCarsListInView", "setGarage", "setLogicForActionClick", "setLogicForCarClick", "setStartData", "setVisibleButtonBackToMenu", "ifFromMainMenu", "", "setVisibleForCarInfo", "isVisible", "updateStatusAfterAction", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIMenuCarPark extends UILayout {
    private final List<FamilyPlayersAction> actionsList;
    private final ActionsWithJSON actionsWithJSON;
    private Animation anim;
    private FamiliesMenuCarParkLayoutBinding binding;
    private final List<FamilyMainItemData> carList;
    private FamilyPlayersActionAdapter carsActionAdapter;
    private FamilyMenuMainAdapter carsAdapter;
    private Function2<? super FamilyPlayersAction, ? super Integer, Unit> clickActionsButton;
    private final NvEventQueueActivity context;
    private int currentAction;
    private int currentCarsId;
    private int garage;
    private int oldActionsId;
    private long oldTimerForClick;
    private int savedRank;
    private Function3<? super FamilyMainItemData, ? super Integer, ? super View, Unit> setClickCar;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIMenuCarPark(NvEventQueueActivity context, ActionsWithJSON actionsWithJSON) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.context = context;
        this.actionsWithJSON = actionsWithJSON;
        this.carList = new ArrayList();
        this.actionsList = new ArrayList();
        this.currentCarsId = -1;
        this.currentAction = -1;
        this.oldActionsId = -1;
        this.garage = -1;
    }

    public final void setVisibleButtonBackToMenu(boolean z) {
        FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding = this.binding;
        if (familiesMenuCarParkLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuCarParkLayoutBinding = null;
        }
        familiesMenuCarParkLayoutBinding.buttonBackToMenu.setVisibility(z ? 4 : 0);
    }

    public final void setStartData() {
        this.currentCarsId = -1;
        this.currentAction = -1;
        this.oldActionsId = -1;
        this.savedRank = 0;
        if (this.carList.size() != 0) {
            getCarsInfo(this.carList.get(0), 0);
            setVisibleForCarInfo(0);
            return;
        }
        setVisibleForCarInfo(4);
    }

    public final void setVisibleForCarInfo(int i) {
        FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding = this.binding;
        if (familiesMenuCarParkLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuCarParkLayoutBinding = null;
        }
        familiesMenuCarParkLayoutBinding.actionWithCar.setVisibility(i);
    }

    @Override
    public View getView() {
        FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding = this.binding;
        if (familiesMenuCarParkLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuCarParkLayoutBinding = null;
        }
        ConstraintLayout root = familiesMenuCarParkLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FamiliesMenuCarParkLayoutBinding inflate = FamiliesMenuCarParkLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        setLogicForCarClick();
        setDataWithCarsListInView();
        setLogicForActionClick();
        setDataWithActionsInView();
        FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding2 = this.binding;
        if (familiesMenuCarParkLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuCarParkLayoutBinding2 = null;
        }
        familiesMenuCarParkLayoutBinding2.buttonBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMenuCarPark.m214onCreateView$lambda3$lambda2(UIMenuCarPark.this, view);
            }
        });
        FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding3 = this.binding;
        if (familiesMenuCarParkLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesMenuCarParkLayoutBinding = familiesMenuCarParkLayoutBinding3;
        }
        ConstraintLayout root = familiesMenuCarParkLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public static final void m214onCreateView$lambda3$lambda2(UIMenuCarPark this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actionsWithJSON.sendGetLayout(5);
    }

    private final void setLogicForCarClick() {
        this.setClickCar = new Function3<FamilyMainItemData, Integer, View, Unit>() {
            @Override
            public Unit invoke(FamilyMainItemData familyMainItemData, Integer num, View view) {
                invoke(familyMainItemData, num.intValue(), view);
                return Unit.INSTANCE;
            }

            public void invoke(FamilyMainItemData item, int i, View mView) {
                long j;
                Animation animation;
                FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding;
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(mView, "mView");
                long currentTimeMillis = System.currentTimeMillis();
                j = UIMenuCarPark.this.oldTimerForClick;
                if (currentTimeMillis - j > 700) {
                    UIMenuCarPark.this.oldTimerForClick = System.currentTimeMillis();
                    animation = UIMenuCarPark.this.anim;
                    FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding2 = null;
                    if (animation == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("anim");
                        animation = null;
                    }
                    mView.startAnimation(animation);
                    UIMenuCarPark.this.getCarsInfo(item, i);
                    familiesMenuCarParkLayoutBinding = UIMenuCarPark.this.binding;
                    if (familiesMenuCarParkLayoutBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        familiesMenuCarParkLayoutBinding2 = familiesMenuCarParkLayoutBinding;
                    }
                    if (familiesMenuCarParkLayoutBinding2.actionWithCar.getVisibility() == 4) {
                        UIMenuCarPark.this.setVisibleForCarInfo(0);
                    }
                }
            }
        };
    }

    private final void setDataWithCarsListInView() {
        this.carsAdapter = new FamilyMenuMainAdapter(this.carList, this.setClickCar, this.context);
        FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding = this.binding;
        FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding2 = null;
        if (familiesMenuCarParkLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuCarParkLayoutBinding = null;
        }
        RecyclerView recyclerView = familiesMenuCarParkLayoutBinding.carList;
        FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding3 = this.binding;
        if (familiesMenuCarParkLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesMenuCarParkLayoutBinding2 = familiesMenuCarParkLayoutBinding3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesMenuCarParkLayoutBinding2.getRoot().getContext(), 1, false));
        recyclerView.setAdapter(this.carsAdapter);
    }

    public final void getCarsInfo(FamilyMainItemData familyMainItemData, int i) {
        this.currentCarsId = familyMainItemData.getItemsId();
        familyMainItemData.setClicked(true);
        FamilyMenuMainAdapter familyMenuMainAdapter = this.carsAdapter;
        if (familyMenuMainAdapter != null) {
            familyMenuMainAdapter.notifyItemChanged(i);
            familyMenuMainAdapter.setCheckOnlyElement(i);
        }
        this.actionsWithJSON.clickOnCar(familyMainItemData.getItemsId());
    }

    private final void setLogicForActionClick() {
        this.clickActionsButton = new Function2<FamilyPlayersAction, Integer, Unit>() {
            @Override
            public Unit invoke(FamilyPlayersAction familyPlayersAction, Integer num) {
                invoke(familyPlayersAction, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(FamilyPlayersAction thisAction, int i) {
                long j;
                int i2;
                ActionsWithJSON actionsWithJSON;
                int i3;
                ActionsWithJSON actionsWithJSON2;
                int i4;
                ActionsWithJSON actionsWithJSON3;
                int i5;
                Intrinsics.checkNotNullParameter(thisAction, "thisAction");
                long currentTimeMillis = System.currentTimeMillis();
                j = UIMenuCarPark.this.oldTimerForClick;
                if (currentTimeMillis - j > 700) {
                    UIMenuCarPark.this.oldTimerForClick = System.currentTimeMillis();
                    UIMenuCarPark.this.oldActionsId = thisAction.getActionsId();
                    i2 = UIMenuCarPark.this.currentCarsId;
                    if (i2 != -1) {
                        if (i == 0) {
                            actionsWithJSON = UIMenuCarPark.this.actionsWithJSON;
                            i3 = UIMenuCarPark.this.currentCarsId;
                            actionsWithJSON.setActionWithCar(i3, thisAction.getActionsId(), 0);
                            UIMenuCarPark.this.currentAction = 0;
                        } else if (i == 1) {
                            actionsWithJSON2 = UIMenuCarPark.this.actionsWithJSON;
                            i4 = UIMenuCarPark.this.currentCarsId;
                            actionsWithJSON2.setActionWithCar(i4, thisAction.getActionsId(), 1);
                            UIMenuCarPark.this.currentAction = 1;
                        } else if (i != 3) {
                        } else {
                            actionsWithJSON3 = UIMenuCarPark.this.actionsWithJSON;
                            i5 = UIMenuCarPark.this.currentCarsId;
                            actionsWithJSON3.setActionWithCar(i5, thisAction.getActionsId(), -1);
                        }
                    }
                }
            }
        };
    }

    private final void setDataWithActionsInView() {
        this.carsActionAdapter = new FamilyPlayersActionAdapter(this.actionsList, this.clickActionsButton);
        FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding = this.binding;
        FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding2 = null;
        if (familiesMenuCarParkLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuCarParkLayoutBinding = null;
        }
        RecyclerView recyclerView = familiesMenuCarParkLayoutBinding.actionWithCar;
        FamiliesMenuCarParkLayoutBinding familiesMenuCarParkLayoutBinding3 = this.binding;
        if (familiesMenuCarParkLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesMenuCarParkLayoutBinding2 = familiesMenuCarParkLayoutBinding3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesMenuCarParkLayoutBinding2.getRoot().getContext(), 1, false));
        recyclerView.setAdapter(this.carsActionAdapter);
    }

    public final void setCarsList(List<Integer> carsId, List<String> carsName) {
        Intrinsics.checkNotNullParameter(carsId, "carsId");
        Intrinsics.checkNotNullParameter(carsName, "carsName");
        if (carsId.size() == carsName.size()) {
            this.carList.clear();
            int size = carsId.size();
            for (int i = 0; i < size; i++) {
                this.carList.add(new FamilyMainItemData(carsId.get(i).intValue(), carsName.get(i), false, 4, null));
            }
            FamilyMenuMainAdapter familyMenuMainAdapter = this.carsAdapter;
            if (familyMenuMainAdapter == null) {
                return;
            }
            familyMenuMainAdapter.notifyDataSetChanged();
        }
    }

    public final void setGarage(int i) {
        this.garage = i;
    }

    private final void setActionsIfDownload(int i) {
        List<FamilyPlayersAction> list = this.actionsList;
        list.clear();
        list.add(new FamilyPlayersAction(0, "Отметить на GPS", 0, 2));
        list.add(new FamilyPlayersAction(1, "Загрузить транспорт на парковке", 0, 2));
        list.add(new FamilyPlayersAction(6, "Загрузить транспорт на месте выгрузки", 0, 2));
        if (i == 1) {
            list.add(new FamilyPlayersAction(5, "Загрузить транспорт в гараж", 0, 2));
        }
        list.add(new FamilyPlayersAction(2, "Вернуть из семьи", 0, 2));
        list.add(new FamilyPlayersAction(3, "Выдать доступ", this.savedRank, 0));
        list.add(new FamilyPlayersAction(7, "Сбросить парковку", 0, 2));
        FamilyPlayersActionAdapter familyPlayersActionAdapter = this.carsActionAdapter;
        if (familyPlayersActionAdapter == null) {
            return;
        }
        familyPlayersActionAdapter.notifyDataSetChanged();
    }

    private final void setActionsIfUnload() {
        List<FamilyPlayersAction> list = this.actionsList;
        list.clear();
        list.add(new FamilyPlayersAction(0, "Отметить на GPS", 0, 2));
        list.add(new FamilyPlayersAction(4, "Выгрузить транспорт", 0, 2));
        list.add(new FamilyPlayersAction(2, "Вернуть из семьи", 0, 2));
        list.add(new FamilyPlayersAction(3, "Выдать доступ", this.savedRank, 0));
        list.add(new FamilyPlayersAction(7, "Сбросить парковку", 0, 2));
        FamilyPlayersActionAdapter familyPlayersActionAdapter = this.carsActionAdapter;
        if (familyPlayersActionAdapter == null) {
            return;
        }
        familyPlayersActionAdapter.notifyDataSetChanged();
    }

    public final void setCurrentRankAndStatus(int i, int i2) {
        if (i2 == 0) {
            setActionsIfDownload(this.garage);
        } else if (i2 == 1) {
            setActionsIfUnload();
        }
        List<FamilyPlayersAction> list = this.actionsList;
        if (list.size() > 0) {
            int i3 = 0;
            int size = list.size();
            while (i3 < size) {
                int i4 = i3 + 1;
                if (list.get(i3).getActionsId() == 3) {
                    list.get(i3).setActionsValue(i);
                    this.savedRank = i;
                    FamilyPlayersActionAdapter familyPlayersActionAdapter = this.carsActionAdapter;
                    if (familyPlayersActionAdapter == null) {
                        return;
                    }
                    familyPlayersActionAdapter.notifyItemChanged(i3);
                    return;
                }
                i3 = i4;
            }
        }
    }

    public final void updateStatusAfterAction() {
        List<FamilyPlayersAction> list = this.actionsList;
        if (list.size() > 0) {
            switch (this.oldActionsId) {
                case 1:
                case 5:
                case 6:
                    setActionsIfUnload();
                    break;
                case 2:
                    deleteCar(this.currentCarsId);
                    break;
                case 3:
                    int i = 0;
                    int size = list.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else {
                            int i2 = i + 1;
                            if (list.get(i).getActionsId() == 3) {
                                int i3 = this.currentAction;
                                if (i3 == 0) {
                                    FamilyPlayersAction familyPlayersAction = list.get(i);
                                    familyPlayersAction.setActionsValue(familyPlayersAction.getActionsValue() - 1);
                                    this.savedRank = list.get(i).getActionsValue();
                                } else if (i3 == 1) {
                                    FamilyPlayersAction familyPlayersAction2 = list.get(i);
                                    familyPlayersAction2.setActionsValue(familyPlayersAction2.getActionsValue() + 1);
                                    this.savedRank = list.get(i).getActionsValue();
                                }
                                FamilyPlayersActionAdapter familyPlayersActionAdapter = this.carsActionAdapter;
                                if (familyPlayersActionAdapter != null) {
                                    familyPlayersActionAdapter.notifyItemChanged(i);
                                    break;
                                }
                            } else {
                                i = i2;
                            }
                        }
                    }
                    break;
                case 4:
                    setActionsIfDownload(this.garage);
                    break;
            }
            this.currentAction = -1;
            this.oldActionsId = -1;
        }
    }

    private final void deleteCar(int i) {
        if (this.carList.size() > 0) {
            int i2 = 0;
            int size = this.carList.size();
            while (true) {
                if (i2 >= size) {
                    break;
                }
                int i3 = i2 + 1;
                if (this.carList.get(i2).getItemsId() == i) {
                    this.carList.remove(i2);
                    FamilyMenuMainAdapter familyMenuMainAdapter = this.carsAdapter;
                    if (familyMenuMainAdapter != null) {
                        familyMenuMainAdapter.notifyItemRemoved(i2);
                    }
                } else {
                    i2 = i3;
                }
            }
            this.currentCarsId = -1;
            this.currentAction = -1;
            this.oldActionsId = -1;
            setVisibleForCarInfo(4);
        }
    }
}
