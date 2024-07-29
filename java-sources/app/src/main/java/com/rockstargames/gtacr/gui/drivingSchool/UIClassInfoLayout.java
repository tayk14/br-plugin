package com.rockstargames.gtacr.gui.drivingSchool;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.DrivingSchoolClassInfoLayoutBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.DrivingSchoolInfoSignAdapter;
import com.rockstargames.gtacr.adapters.DrivingSchoolRadialMenuInfoAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.DrivingMainType;
import com.rockstargames.gtacr.gui.CustomTypefaceSpanTextStyleBold;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001a\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\u0006\u0010#\u001a\u00020\u0018J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010%\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010&R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/rockstargames/gtacr/gui/drivingSchool/UIClassInfoLayout;", "Lcom/rockstargames/gtacr/common/UILayout;", "mainRoot", "Lcom/rockstargames/gtacr/gui/drivingSchool/GUIDrivingSchool;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Lcom/rockstargames/gtacr/gui/drivingSchool/GUIDrivingSchool;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/DrivingSchoolClassInfoLayoutBinding;", "ifStartTest", "", "getIfStartTest", "()Z", "setIfStartTest", "(Z)V", "radialMenuAdapter", "Lcom/rockstargames/gtacr/adapters/DrivingSchoolRadialMenuInfoAdapter;", "signAdapter", "Lcom/rockstargames/gtacr/adapters/DrivingSchoolInfoSignAdapter;", "getView", "Landroid/view/View;", "initialRadialMenuRecyclerView", "", "currentCategory", "", "initialSignRecyclerView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "setNullableParameters", "setSpannable", "setStartView", "Lcom/rockstargames/gtacr/data/DrivingMainType;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIClassInfoLayout extends UILayout {
    private Animation anim;
    private DrivingSchoolClassInfoLayoutBinding binding;
    private final NvEventQueueActivity context;
    private boolean ifStartTest;
    private final GUIDrivingSchool mainRoot;
    private DrivingSchoolRadialMenuInfoAdapter radialMenuAdapter;
    private DrivingSchoolInfoSignAdapter signAdapter;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIClassInfoLayout(GUIDrivingSchool mainRoot, NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainRoot = mainRoot;
        this.context = context;
    }

    public final boolean getIfStartTest() {
        return this.ifStartTest;
    }

    public final void setIfStartTest(boolean z) {
        this.ifStartTest = z;
    }

    @Override
    public View getView() {
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding = this.binding;
        if (drivingSchoolClassInfoLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolClassInfoLayoutBinding = null;
        }
        ConstraintLayout root = drivingSchoolClassInfoLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void setStartView(DrivingMainType drivingMainType) {
        if (drivingMainType == null) {
            return;
        }
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding = this.binding;
        if (drivingSchoolClassInfoLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolClassInfoLayoutBinding = null;
        }
        drivingSchoolClassInfoLayoutBinding.typeTutorInfoTitle.setText(drivingMainType.getName());
        initialRadialMenuRecyclerView(drivingMainType.getId());
        initialSignRecyclerView(drivingMainType.getId());
        setSpannable(drivingMainType.getId());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DrivingSchoolClassInfoLayoutBinding inflate = DrivingSchoolClassInfoLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        this.anim = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding2 = this.binding;
        if (drivingSchoolClassInfoLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolClassInfoLayoutBinding2 = null;
        }
        drivingSchoolClassInfoLayoutBinding2.buttonStartPracticeOnSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                //UIClassInfoLayout.m131onCreateView$lambda2(UIClassInfoLayout.this, view);
            }
        });
        Display defaultDisplay = this.context.getWindowManager().getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "context.windowManager.defaultDisplay");
        final int height = defaultDisplay.getHeight() / 3;
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding3 = this.binding;
        if (drivingSchoolClassInfoLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolClassInfoLayoutBinding3 = null;
        }
        drivingSchoolClassInfoLayoutBinding3.rootNestedScroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                UIClassInfoLayout.m133onCreateView$lambda3(UIClassInfoLayout.this, height, nestedScrollView, i, i2, i3, i4);
            }
        });
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding4 = this.binding;
        if (drivingSchoolClassInfoLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            drivingSchoolClassInfoLayoutBinding = drivingSchoolClassInfoLayoutBinding4;
        }
        ConstraintLayout root = drivingSchoolClassInfoLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void m131onCreateView$lambda2(UIClassInfoLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.startAnimation(this$0.anim);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                UIClassInfoLayout.m132onCreateView$lambda2$lambda1(UIClassInfoLayout.this);
            }
        }, 250L);
    }

    public static final void m132onCreateView$lambda2$lambda1(UIClassInfoLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.ifStartTest) {
            return;
        }
        this$0.mainRoot.sendToServerClickButton(2);
        this$0.ifStartTest = true;
    }

    public static final void m133onCreateView$lambda3(UIClassInfoLayout this$0, int i, NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding = this$0.binding;
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding2 = null;
        if (drivingSchoolClassInfoLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolClassInfoLayoutBinding = null;
        }
        if (drivingSchoolClassInfoLayoutBinding.iconScroll.getVisibility() == 0 && i3 > i) {
            DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding3 = this$0.binding;
            if (drivingSchoolClassInfoLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                drivingSchoolClassInfoLayoutBinding2 = drivingSchoolClassInfoLayoutBinding3;
            }
            drivingSchoolClassInfoLayoutBinding2.iconScroll.setVisibility(4);
            return;
        }
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding4 = this$0.binding;
        if (drivingSchoolClassInfoLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolClassInfoLayoutBinding4 = null;
        }
        if (drivingSchoolClassInfoLayoutBinding4.iconScroll.getVisibility() != 4 || i3 >= i) {
            return;
        }
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding5 = this$0.binding;
        if (drivingSchoolClassInfoLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            drivingSchoolClassInfoLayoutBinding2 = drivingSchoolClassInfoLayoutBinding5;
        }
        drivingSchoolClassInfoLayoutBinding2.iconScroll.setVisibility(0);
    }

    private final void setSpannable(int i) {
        SpannableString spannableString;
        SpannableString spannableString2 = new SpannableString("Радиальное меню — способ взаимодействия с Вашим транспортным средством.");
        Typeface font = ResourcesCompat.getFont(this.context, R.font.montserrat_bold);
        Intrinsics.checkNotNull(font);
        Intrinsics.checkNotNullExpressionValue(font, "getFont(context, R.font.montserrat_bold)!!");
        spannableString2.setSpan(new CustomTypefaceSpanTextStyleBold("", font), 0, 15, 33);
        if (i == 4) {
            spannableString = new SpannableString("Знаки водного движения");
        } else {
            spannableString = new SpannableString("Знаки дорожного движения");
        }
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.diving_school_green_text_color)), 6, spannableString.length(), 33);
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding = this.binding;
        if (drivingSchoolClassInfoLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolClassInfoLayoutBinding = null;
        }
        drivingSchoolClassInfoLayoutBinding.radialTextInfo1.setText(spannableString2);
        drivingSchoolClassInfoLayoutBinding.titleTrafficSigns.setText(spannableString);
    }

    private final void initialRadialMenuRecyclerView(int i) {
        DrivingSchoolRadialMenuInfoAdapter drivingSchoolRadialMenuInfoAdapter;
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding = null;
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            drivingSchoolRadialMenuInfoAdapter = new DrivingSchoolRadialMenuInfoAdapter(Utils.INSTANCE.getRadialMenuInfoCategoriesABCD(), this);
        } else if (i == 4) {
            drivingSchoolRadialMenuInfoAdapter = new DrivingSchoolRadialMenuInfoAdapter(Utils.INSTANCE.getRadialMenuInfoCategoriesShip(), this);
        } else {
            drivingSchoolRadialMenuInfoAdapter = null;
        }
        this.radialMenuAdapter = drivingSchoolRadialMenuInfoAdapter;
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding2 = this.binding;
        if (drivingSchoolClassInfoLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolClassInfoLayoutBinding2 = null;
        }
        RecyclerView recyclerView = drivingSchoolClassInfoLayoutBinding2.radialMenuItems;
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding3 = this.binding;
        if (drivingSchoolClassInfoLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            drivingSchoolClassInfoLayoutBinding = drivingSchoolClassInfoLayoutBinding3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(drivingSchoolClassInfoLayoutBinding.getRoot().getContext(), 1, false));
        recyclerView.setAdapter(this.radialMenuAdapter);
    }

    private final void initialSignRecyclerView(int i) {
        DrivingSchoolInfoSignAdapter drivingSchoolInfoSignAdapter;
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding = null;
        if (i == 0 || i == 1) {
            drivingSchoolInfoSignAdapter = new DrivingSchoolInfoSignAdapter(Utils.INSTANCE.getRoadSignsCategoriesAB(), this);
        } else if (i == 2) {
            drivingSchoolInfoSignAdapter = new DrivingSchoolInfoSignAdapter(Utils.INSTANCE.getRoadSignsCategoriesC(), this);
        } else if (i == 3) {
            drivingSchoolInfoSignAdapter = new DrivingSchoolInfoSignAdapter(Utils.INSTANCE.getRoadSignsCategoriesD(), this);
        } else if (i == 4) {
            drivingSchoolInfoSignAdapter = new DrivingSchoolInfoSignAdapter(Utils.INSTANCE.getRoadSignsCategoriesShip(), this);
        } else {
            drivingSchoolInfoSignAdapter = null;
        }
        this.signAdapter = drivingSchoolInfoSignAdapter;
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding2 = this.binding;
        if (drivingSchoolClassInfoLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolClassInfoLayoutBinding2 = null;
        }
        RecyclerView recyclerView = drivingSchoolClassInfoLayoutBinding2.signItems;
        DrivingSchoolClassInfoLayoutBinding drivingSchoolClassInfoLayoutBinding3 = this.binding;
        if (drivingSchoolClassInfoLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            drivingSchoolClassInfoLayoutBinding = drivingSchoolClassInfoLayoutBinding3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(drivingSchoolClassInfoLayoutBinding.getRoot().getContext(), 1, false));
        recyclerView.setAdapter(this.signAdapter);
    }

    public final void setNullableParameters() {
        this.anim = null;
        this.signAdapter = null;
        this.radialMenuAdapter = null;
    }
}
