package com.rockstargames.gtacr.gui.fractions;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import blackrussia.online.databinding.FractionMainMenuLayoutBinding;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsMainViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

//@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UIFractionMainLayout$setupProgressAdapter$1$1$1 extends Lambda implements Function0 {
    final UIFractionMainLayout this$0;

    public UIFractionMainLayout$setupProgressAdapter$1$1$1(UIFractionMainLayout uIFractionMainLayout) {
        super(0);
        this.this$0 = uIFractionMainLayout;
    }

    @Override
    public Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    public final void invoke2() {
        FractionMainMenuLayoutBinding binding;
        Animation animation;
        boolean z;
        binding = this.this$0.getBinding();
        View rootView = binding.recyclerView.getRootView();
        Handler handler = new Handler();
        final UIFractionMainLayout uIFractionMainLayout = this.this$0;
        handler.postDelayed(new Runnable() {
            @Override
            public final void run() {
            }
        }, 250L);
    }

    public static final void m265invoke$lambda0(UIFractionMainLayout this$0) {
        FractionsMainViewModel fractionsMainViewModel;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
    }
}
