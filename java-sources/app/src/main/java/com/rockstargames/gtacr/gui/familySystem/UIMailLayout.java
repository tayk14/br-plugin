package com.rockstargames.gtacr.gui.familySystem;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.widget.NestedScrollView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesMainLayoutBinding;
import com.rockstargames.gtacr.common.UILayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/UIMailLayout;", "Lcom/rockstargames/gtacr/common/UILayout;", "mainRoot", "Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;", "(Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesMainLayoutBinding;", "isClickedMainItem", "", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "", "onLayoutShown", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIMailLayout extends UILayout {
    private final ActionsWithJSON actionsWithJSON;
    private Animation anim;
    private FamiliesMainLayoutBinding binding;
    private boolean isClickedMainItem;
    private final GUIFamilySystem mainRoot;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIMailLayout(GUIFamilySystem mainRoot, ActionsWithJSON actionsWithJSON) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.mainRoot = mainRoot;
        this.actionsWithJSON = actionsWithJSON;
    }

    @Override
    public View getView() {
        FamiliesMainLayoutBinding familiesMainLayoutBinding = this.binding;
        if (familiesMainLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMainLayoutBinding = null;
        }
        NestedScrollView root = familiesMainLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FamiliesMainLayoutBinding inflate = FamiliesMainLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        FamiliesMainLayoutBinding familiesMainLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        FamiliesMainLayoutBinding familiesMainLayoutBinding2 = this.binding;
        if (familiesMainLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMainLayoutBinding2 = null;
        }
        familiesMainLayoutBinding2.familyItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMailLayout.m204onCreateView$lambda10$lambda1(UIMailLayout.this, view);
            }
        });
        familiesMainLayoutBinding2.familyItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMailLayout.m206onCreateView$lambda10$lambda3(UIMailLayout.this, view);
            }
        });
        familiesMainLayoutBinding2.familyItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMailLayout.m208onCreateView$lambda10$lambda5(UIMailLayout.this, view);
            }
        });
        familiesMainLayoutBinding2.familyItem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMailLayout.m210onCreateView$lambda10$lambda7(UIMailLayout.this, view);
            }
        });
        familiesMainLayoutBinding2.familyItem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMailLayout.m212onCreateView$lambda10$lambda9(UIMailLayout.this, view);
            }
        });
        FamiliesMainLayoutBinding familiesMainLayoutBinding3 = this.binding;
        if (familiesMainLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesMainLayoutBinding = familiesMainLayoutBinding3;
        }
        NestedScrollView root = familiesMainLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public static final void m204onCreateView$lambda10$lambda1(UIMailLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        if (!this$0.isClickedMainItem) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    //UIMailLayout.m205onCreateView$lambda10$lambda1$lambda0(UIMailLayout.this);
                }
            }, 250L);
        }
        this$0.isClickedMainItem = true;
    }

    public static final void m205onCreateView$lambda10$lambda1$lambda0(UIMailLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isClickedMainItem = false;
        this$0.mainRoot.listenerLayout(4);
    }

    public static final void m206onCreateView$lambda10$lambda3(UIMailLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        if (!this$0.isClickedMainItem) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    //UIMailLayout.m207onCreateView$lambda10$lambda3$lambda2(UIMailLayout.this);
                }
            }, 250L);
        }
        this$0.isClickedMainItem = true;
    }

    public static final void m207onCreateView$lambda10$lambda3$lambda2(UIMailLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actionsWithJSON.sendGetLayout(2);
        this$0.mainRoot.setIfFromMainMenuForCarPark(true);
        this$0.isClickedMainItem = false;
    }

    public static final void m208onCreateView$lambda10$lambda5(UIMailLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        if (!this$0.isClickedMainItem) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    //UIMailLayout.m209onCreateView$lambda10$lambda5$lambda4(UIMailLayout.this);
                }
            }, 250L);
        }
        this$0.isClickedMainItem = true;
    }

    public static final void m209onCreateView$lambda10$lambda5$lambda4(UIMailLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isClickedMainItem = false;
        this$0.mainRoot.listenerLayout(3);
    }

    public static final void m210onCreateView$lambda10$lambda7(UIMailLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        if (!this$0.isClickedMainItem) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    //UIMailLayout.m211onCreateView$lambda10$lambda7$lambda6(UIMailLayout.this);
                }
            }, 250L);
        }
        this$0.isClickedMainItem = true;
    }

    public static final void m211onCreateView$lambda10$lambda7$lambda6(UIMailLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actionsWithJSON.sendGetLayout(4);
        this$0.mainRoot.setIfFromMainMenuForUpgrade(true);
        this$0.isClickedMainItem = false;
    }

    public static final void m212onCreateView$lambda10$lambda9(UIMailLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        if (!this$0.isClickedMainItem) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    //UIMailLayout.m213onCreateView$lambda10$lambda9$lambda8(UIMailLayout.this);
                }
            }, 250L);
        }
        this$0.isClickedMainItem = true;
    }

    public static final void m213onCreateView$lambda10$lambda9$lambda8(UIMailLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actionsWithJSON.sendGetLayout(7);
        this$0.isClickedMainItem = false;
    }
}
