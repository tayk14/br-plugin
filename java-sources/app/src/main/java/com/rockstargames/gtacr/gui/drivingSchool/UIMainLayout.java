package com.rockstargames.gtacr.gui.drivingSchool;

import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.DrivingSchoolMainLayoutBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.DrivingSchoolMainTypeAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.DrivingMainType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\"\u001a\u00020\u001eJ\b\u0010#\u001a\u00020\u001cH\u0016J\u001a\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\b\u0010*\u001a\u00020\u001eH\u0016J\u0006\u0010+\u001a\u00020\u001eJ\b\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020\u001eH\u0002J\u0006\u00100\u001a\u00020\u001eJ\"\u00101\u001a\u00020\u001e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R[\u0010\u0016\u001aO\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0017j\u0004\u0018\u0001`\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/rockstargames/gtacr/gui/drivingSchool/UIMainLayout;", "Lcom/rockstargames/gtacr/common/UILayout;", "mainRoot", "Lcom/rockstargames/gtacr/gui/drivingSchool/GUIDrivingSchool;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Lcom/rockstargames/gtacr/gui/drivingSchool/GUIDrivingSchool;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/DrivingSchoolMainLayoutBinding;", "classA", "Lcom/rockstargames/gtacr/data/DrivingMainType;", "classB", "classC", "classD", "classShip", "counter", "", "", "currentCategory", "listWithTypeSchools", "onMainTypeSchoolClickListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "position", "Landroid/view/View;", "view", "", "Lcom/rockstargames/gtacr/gui/drivingSchool/OnMainTypeSchoolClickListener;", "typeSchoolsAdapter", "Lcom/rockstargames/gtacr/adapters/DrivingSchoolMainTypeAdapter;", "clearCounter", "getView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "openInfoAboutType", "setBackground", "setDataInListWithType", "setDataWithTypeSchools", "setLogicForItemsClick", "setNullableParameters", "setStartParameters", "actualStatus", "actualPrice", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIMainLayout extends UILayout {
    private Animation anim;
    private DrivingSchoolMainLayoutBinding binding;
    private final DrivingMainType classA;
    private final DrivingMainType classB;
    private final DrivingMainType classC;
    private final DrivingMainType classD;
    private final DrivingMainType classShip;
    private final NvEventQueueActivity context;
    private List<Integer> counter;
    private DrivingMainType currentCategory;
    private List<DrivingMainType> listWithTypeSchools;
    private final GUIDrivingSchool mainRoot;
    private Function3<? super DrivingMainType, ? super Integer, ? super View, Unit> onMainTypeSchoolClickListener;
    private DrivingSchoolMainTypeAdapter typeSchoolsAdapter;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIMainLayout(GUIDrivingSchool mainRoot, NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainRoot = mainRoot;
        this.context = context;
        this.listWithTypeSchools = new ArrayList();
        this.counter = CollectionsKt.mutableListOf(-1, 0);
        this.classA = new DrivingMainType(0, "Категория А", "driving_school_icon_moto_res", 0, 0, false);
        this.classB = new DrivingMainType(1, "Категория B", "driving_school_icon_car_res", 0, 0, false);
        this.classC = new DrivingMainType(2, "Категория C", "driving_school_icon_cargo_trunk_res", 0, 0, false);
        this.classD = new DrivingMainType(3, "Категория D", "driving_school_icon_bus_res", 0, 0, false);
        this.classShip = new DrivingMainType(4, "Водный транспорт", "driving_school_icon_ship_res", 0, 0, false);
    }

    @Override
    public View getView() {
        DrivingSchoolMainLayoutBinding drivingSchoolMainLayoutBinding = this.binding;
        if (drivingSchoolMainLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolMainLayoutBinding = null;
        }
        ConstraintLayout root = drivingSchoolMainLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void clearCounter() {
        this.counter.set(0, -1);
        this.counter.set(1, 0);
        this.currentCategory = null;
        DrivingSchoolMainTypeAdapter drivingSchoolMainTypeAdapter = this.typeSchoolsAdapter;
        if (drivingSchoolMainTypeAdapter == null) {
            return;
        }
        drivingSchoolMainTypeAdapter.setOnlyItemCheck(-1);
    }

    public final void setStartParameters(List<Integer> actualStatus, List<Integer> actualPrice) {
        Intrinsics.checkNotNullParameter(actualStatus, "actualStatus");
        Intrinsics.checkNotNullParameter(actualPrice, "actualPrice");
        if ((actualStatus.size() & actualPrice.size()) == 5) {
            DrivingMainType drivingMainType = this.classA;
            drivingMainType.setPrice(actualPrice.get(0).intValue());
            drivingMainType.setUnBlock(actualStatus.get(0).intValue());
            DrivingMainType drivingMainType2 = this.classB;
            drivingMainType2.setPrice(actualPrice.get(1).intValue());
            drivingMainType2.setUnBlock(actualStatus.get(1).intValue());
            DrivingMainType drivingMainType3 = this.classC;
            drivingMainType3.setPrice(actualPrice.get(2).intValue());
            drivingMainType3.setUnBlock(actualStatus.get(2).intValue());
            DrivingMainType drivingMainType4 = this.classD;
            drivingMainType4.setPrice(actualPrice.get(3).intValue());
            drivingMainType4.setUnBlock(actualStatus.get(3).intValue());
            DrivingMainType drivingMainType5 = this.classShip;
            drivingMainType5.setPrice(actualPrice.get(4).intValue());
            drivingMainType5.setUnBlock(actualStatus.get(4).intValue());
        }
        setLogicForItemsClick();
        setDataInListWithType();
        setDataWithTypeSchools();
    }

    private final void setLogicForItemsClick() {
        this.onMainTypeSchoolClickListener = new Function3<DrivingMainType, Integer, View, Unit>() {
            @Override
            public Unit invoke(DrivingMainType drivingMainType, Integer num, View view) {
                invoke(drivingMainType, num.intValue(), view);
                return Unit.INSTANCE;
            }

            public void invoke(DrivingMainType item, int i, View view) {
                List list;
                DrivingSchoolMainTypeAdapter drivingSchoolMainTypeAdapter;
                List list2;
                List list3;
                DrivingSchoolMainTypeAdapter drivingSchoolMainTypeAdapter2;
                List list4;
                List list5;
                List list6;
                List list7;
                GUIDrivingSchool gUIDrivingSchool;
                List list8;
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(view, "view");
                list = UIMainLayout.this.counter;
                if (((Number) list.get(1)).intValue() != 2) {
                    item.setCheck(item.isUnBlock() == 1);
                    drivingSchoolMainTypeAdapter = UIMainLayout.this.typeSchoolsAdapter;
                    if (drivingSchoolMainTypeAdapter != null) {
                        drivingSchoolMainTypeAdapter.setOnlyItemCheck(i);
                    }
                    if (item.isCheck()) {
                        drivingSchoolMainTypeAdapter2 = UIMainLayout.this.typeSchoolsAdapter;
                        if (drivingSchoolMainTypeAdapter2 != null) {
                            drivingSchoolMainTypeAdapter2.notifyItemChanged(i);
                        }
                        int id = item.getId();
                        list4 = UIMainLayout.this.counter;
                        if (id == ((Number) list4.get(0)).intValue()) {
                            list7 = UIMainLayout.this.counter;
                            if (((Number) list7.get(1)).intValue() == 1) {
                                gUIDrivingSchool = UIMainLayout.this.mainRoot;
                                gUIDrivingSchool.sendForServerCheckType(item.getId());
                                list8 = UIMainLayout.this.counter;
                                list8.set(1, 2);
                                return;
                            }
                        }
                        list5 = UIMainLayout.this.counter;
                        list5.set(0, Integer.valueOf(item.getId()));
                        list6 = UIMainLayout.this.counter;
                        list6.set(1, 1);
                        UIMainLayout.this.currentCategory = item;
                        return;
                    }
                    list2 = UIMainLayout.this.counter;
                    list2.set(0, -1);
                    list3 = UIMainLayout.this.counter;
                    list3.set(1, 0);
                    UIMainLayout.this.currentCategory = null;
                }
            }
        };
    }

    public final void openInfoAboutType() {
        this.mainRoot.listenerForLayout(this.currentCategory);
    }

    private final void setDataWithTypeSchools() {
        this.typeSchoolsAdapter = new DrivingSchoolMainTypeAdapter(this.context, this.listWithTypeSchools, this.onMainTypeSchoolClickListener);
        DrivingSchoolMainLayoutBinding drivingSchoolMainLayoutBinding = this.binding;
        DrivingSchoolMainLayoutBinding drivingSchoolMainLayoutBinding2 = null;
        if (drivingSchoolMainLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolMainLayoutBinding = null;
        }
        RecyclerView recyclerView = drivingSchoolMainLayoutBinding.blockWitchTypeSchools;
        DrivingSchoolMainLayoutBinding drivingSchoolMainLayoutBinding3 = this.binding;
        if (drivingSchoolMainLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            drivingSchoolMainLayoutBinding2 = drivingSchoolMainLayoutBinding3;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(drivingSchoolMainLayoutBinding2.getRoot().getContext(), 2, 1, false));
        recyclerView.setAdapter(this.typeSchoolsAdapter);
    }

    private final void setDataInListWithType() {
        this.listWithTypeSchools.add(this.classA);
        this.listWithTypeSchools.add(this.classB);
        this.listWithTypeSchools.add(this.classC);
        this.listWithTypeSchools.add(this.classD);
        this.listWithTypeSchools.add(this.classShip);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DrivingSchoolMainLayoutBinding inflate = DrivingSchoolMainLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        DrivingSchoolMainLayoutBinding drivingSchoolMainLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        this.anim = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        setBackground();
        DrivingSchoolMainLayoutBinding drivingSchoolMainLayoutBinding2 = this.binding;
        if (drivingSchoolMainLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolMainLayoutBinding2 = null;
        }
        drivingSchoolMainLayoutBinding2.buttonStartCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMainLayout.m136onCreateView$lambda8(UIMainLayout.this, view);
            }
        });
        DrivingSchoolMainLayoutBinding drivingSchoolMainLayoutBinding3 = this.binding;
        if (drivingSchoolMainLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            drivingSchoolMainLayoutBinding = drivingSchoolMainLayoutBinding3;
        }
        ConstraintLayout root = drivingSchoolMainLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public static final void m136onCreateView$lambda8(UIMainLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.startAnimation(this$0.anim);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                //UIMainLayout.m137onCreateView$lambda8$lambda7(UIMainLayout.this);
            }
        }, 250L);
    }

    public static final void m137onCreateView$lambda8$lambda7(UIMainLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.counter.get(0).intValue() == -1 || this$0.counter.get(1).intValue() == 2) {
            return;
        }
        DrivingMainType drivingMainType = this$0.currentCategory;
        if (drivingMainType == null) {
            this$0.mainRoot.sendForServerCheckType(this$0.counter.get(0).intValue());
        } else if (drivingMainType != null) {
            this$0.mainRoot.sendForServerCheckType(drivingMainType.getId());
        }
        this$0.counter.set(1, 2);
    }

    private final void setBackground() {
        SpannableString spannableString = new SpannableString("Помните, обучение в автошколе платное. Деньги будут списаны после начала теоретического экзамена.");
        spannableString.setSpan(new BackgroundColorSpan(ContextCompat.getColor(getContext(), R.color.diving_school_yellow_text_background)), 52, 59, 33);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.black)), 52, 59, 33);
        SpannableString spannableString2 = new SpannableString("В случае неудачи, деньги возвращены не будут.");
        spannableString2.setSpan(new BackgroundColorSpan(ContextCompat.getColor(getContext(), R.color.diving_school_yellow_text_background)), 36, 44, 33);
        spannableString2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.black)), 36, 44, 33);
        DrivingSchoolMainLayoutBinding drivingSchoolMainLayoutBinding = this.binding;
        DrivingSchoolMainLayoutBinding drivingSchoolMainLayoutBinding2 = null;
        if (drivingSchoolMainLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolMainLayoutBinding = null;
        }
        drivingSchoolMainLayoutBinding.text2.setText(spannableString);
        DrivingSchoolMainLayoutBinding drivingSchoolMainLayoutBinding3 = this.binding;
        if (drivingSchoolMainLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            drivingSchoolMainLayoutBinding2 = drivingSchoolMainLayoutBinding3;
        }
        drivingSchoolMainLayoutBinding2.text3.setText(spannableString2);
    }

    public final void setNullableParameters() {
        this.anim = null;
        this.onMainTypeSchoolClickListener = null;
        this.typeSchoolsAdapter = null;
        this.currentCategory = null;
    }
}
