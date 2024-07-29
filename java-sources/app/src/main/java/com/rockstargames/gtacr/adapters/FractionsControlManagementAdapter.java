package com.rockstargames.gtacr.adapters;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionsControlManagementItemBinding;
import blackrussia.online.network.fraction.data.FractionControlPlayerInfo;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.rockstargames.gtacr.adapters.FractionsControlManagementAdapter;
import com.rockstargames.gtacr.gui.fractions.Const;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001%B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001d\u001a\u00020\tH\u0016J\u001c\u0010\u001e\u001a\u00020\f2\n\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\tH\u0016J\u001c\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010¨\u0006&"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FractionsControlManagementAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FractionsControlManagementAdapter$FractionsControlManagementViewHolder;", "item", "Lblackrussia/online/network/fraction/data/FractionControlPlayerInfo;", "(Lblackrussia/online/network/fraction/data/FractionControlPlayerInfo;)V", "getItem", "()Lblackrussia/online/network/fraction/data/FractionControlPlayerInfo;", "itemCount", "", "onDismissFromFractionClickListener", "Lkotlin/Function0;", "", "getOnDismissFromFractionClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnDismissFromFractionClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onMinusRankClickListener", "getOnMinusRankClickListener", "setOnMinusRankClickListener", "onMinusReprimandsClickListener", "getOnMinusReprimandsClickListener", "setOnMinusReprimandsClickListener", "onPlusRankClickListener", "getOnPlusRankClickListener", "setOnPlusRankClickListener", "onPlusReprimandsClickListener", "getOnPlusReprimandsClickListener", "setOnPlusReprimandsClickListener", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FractionsControlManagementViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsControlManagementAdapter extends RecyclerView.Adapter<FractionsControlManagementAdapter.FractionsControlManagementViewHolder> {
    private final FractionControlPlayerInfo item;
    private int itemCount;
    public Function0<Unit> onDismissFromFractionClickListener;
    public Function0<Unit> onMinusRankClickListener;
    public Function0<Unit> onMinusReprimandsClickListener;
    public Function0<Unit> onPlusRankClickListener;
    public Function0<Unit> onPlusReprimandsClickListener;

    public final FractionControlPlayerInfo getItem() {
        return this.item;
    }

    public FractionsControlManagementAdapter(FractionControlPlayerInfo item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.itemCount = 3;
    }

    public final Function0<Unit> getOnMinusRankClickListener() {
        Function0<Unit> function0 = this.onMinusRankClickListener;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onMinusRankClickListener");
        return null;
    }

    public final void setOnMinusRankClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onMinusRankClickListener = function0;
    }

    public final Function0<Unit> getOnPlusRankClickListener() {
        Function0<Unit> function0 = this.onPlusRankClickListener;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onPlusRankClickListener");
        return null;
    }

    public final void setOnPlusRankClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onPlusRankClickListener = function0;
    }

    public final Function0<Unit> getOnMinusReprimandsClickListener() {
        Function0<Unit> function0 = this.onMinusReprimandsClickListener;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onMinusReprimandsClickListener");
        return null;
    }

    public final void setOnMinusReprimandsClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onMinusReprimandsClickListener = function0;
    }

    public final Function0<Unit> getOnPlusReprimandsClickListener() {
        Function0<Unit> function0 = this.onPlusReprimandsClickListener;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onPlusReprimandsClickListener");
        return null;
    }

    public final void setOnPlusReprimandsClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onPlusReprimandsClickListener = function0;
    }

    public final Function0<Unit> getOnDismissFromFractionClickListener() {
        Function0<Unit> function0 = this.onDismissFromFractionClickListener;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onDismissFromFractionClickListener");
        return null;
    }

    public final void setOnDismissFromFractionClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onDismissFromFractionClickListener = function0;
    }

    //@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u001e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FractionsControlManagementAdapter$FractionsControlManagementViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FractionsControlManagementItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FractionsControlManagementAdapter;Lblackrussia/online/databinding/FractionsControlManagementItemBinding;)V", "anim", "Landroid/view/animation/Animation;", "getAnim", "()Landroid/view/animation/Animation;", "getBinding", "()Lblackrussia/online/databinding/FractionsControlManagementItemBinding;", "blockedSpam", "", "bind", "", "position", "", "makeButtonsPlusMinusInvisible", "setOnClickListener", Const.FRACTION_BUTTON_KEY, "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FractionsControlManagementViewHolder extends RecyclerView.ViewHolder {
        private final Animation anim;
        private final FractionsControlManagementItemBinding binding;
        private boolean blockedSpam;
        final FractionsControlManagementAdapter this$0;

        public FractionsControlManagementViewHolder(FractionsControlManagementAdapter this$0, FractionsControlManagementItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
            Animation loadAnimation = AnimationUtils.loadAnimation(binding.getRoot().getContext(), R.anim.button_click);
            Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
            this.anim = loadAnimation;
        }

        public final FractionsControlManagementItemBinding getBinding() {
            return this.binding;
        }

        public final Animation getAnim() {
            return this.anim;
        }

        public final void bind(int i) {
            FractionsControlManagementItemBinding fractionsControlManagementItemBinding = this.binding;
            final FractionsControlManagementAdapter fractionsControlManagementAdapter = this.this$0;
            if (i == 0) {
                fractionsControlManagementItemBinding.textViewChangingParameterTitle.setText(fractionsControlManagementItemBinding.getRoot().getContext().getString(R.string.fractions_change_rank));
                fractionsControlManagementItemBinding.textViewChangingParameter.setText(String.valueOf(fractionsControlManagementAdapter.getItem().getRank()));
                fractionsControlManagementItemBinding.imageButtonMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        FractionsControlManagementViewHolder.m82bind$lambda5$lambda0(FractionsControlManagementViewHolder.this, fractionsControlManagementAdapter, view);
                    }
                });
                fractionsControlManagementItemBinding.imageButtonPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        FractionsControlManagementViewHolder.m83bind$lambda5$lambda1(FractionsControlManagementViewHolder.this, fractionsControlManagementAdapter, view);
                    }
                });
            } else if (i == 1) {
                fractionsControlManagementItemBinding.textViewChangingParameterTitle.setText(fractionsControlManagementItemBinding.getRoot().getContext().getString(R.string.fractions_change_reprimands));
                fractionsControlManagementItemBinding.textViewChangingParameter.setText(String.valueOf(fractionsControlManagementAdapter.getItem().getReprimand()));
                fractionsControlManagementItemBinding.imageButtonMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        FractionsControlManagementViewHolder.m84bind$lambda5$lambda2(FractionsControlManagementViewHolder.this, fractionsControlManagementAdapter, view);
                    }
                });
                fractionsControlManagementItemBinding.imageButtonPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        FractionsControlManagementViewHolder.m85bind$lambda5$lambda3(FractionsControlManagementViewHolder.this, fractionsControlManagementAdapter, view);
                    }
                });
            } else if (i != 2) {
            } else {
                fractionsControlManagementItemBinding.textViewChangingParameterTitle.setText(fractionsControlManagementItemBinding.getRoot().getContext().getString(R.string.fractions_dismiss_from_fraction));
                makeButtonsPlusMinusInvisible();
                getBinding().getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        FractionsControlManagementViewHolder.m86bind$lambda5$lambda4(FractionsControlManagementViewHolder.this, fractionsControlManagementAdapter, view);
                    }
                });
            }
        }

        public static final void m82bind$lambda5$lambda0(FractionsControlManagementViewHolder this$0, FractionsControlManagementAdapter this$1, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.setOnClickListener(it, this$1.getOnMinusRankClickListener());
        }

        public static final void m83bind$lambda5$lambda1(FractionsControlManagementViewHolder this$0, FractionsControlManagementAdapter this$1, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.setOnClickListener(it, this$1.getOnPlusRankClickListener());
        }

        public static final void m84bind$lambda5$lambda2(FractionsControlManagementViewHolder this$0, FractionsControlManagementAdapter this$1, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.setOnClickListener(it, this$1.getOnMinusReprimandsClickListener());
        }

        public static final void m85bind$lambda5$lambda3(FractionsControlManagementViewHolder this$0, FractionsControlManagementAdapter this$1, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.setOnClickListener(it, this$1.getOnPlusReprimandsClickListener());
        }

        public static final void m86bind$lambda5$lambda4(FractionsControlManagementViewHolder this$0, FractionsControlManagementAdapter this$1, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.setOnClickListener(it, this$1.getOnDismissFromFractionClickListener());
        }

        private final void setOnClickListener(View view, final Function0<Unit> function0) {
            view.startAnimation(this.anim);
            if (this.blockedSpam) {
                return;
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    //FractionsControlManagementAdapter.FractionsControlManagementViewHolder.m88setOnClickListener$lambda6(Function0.this, this);
                }
            }, 300L);
            this.blockedSpam = true;
        }

        public static final void m88setOnClickListener$lambda6(Function0 listener, FractionsControlManagementViewHolder this$0) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            listener.invoke();
            this$0.blockedSpam = false;
        }

        private final void makeButtonsPlusMinusInvisible() {
            FractionsControlManagementItemBinding fractionsControlManagementItemBinding = this.binding;
            fractionsControlManagementItemBinding.imageButtonMinus.setVisibility(4);
            fractionsControlManagementItemBinding.imageButtonPlus.setVisibility(4);
            fractionsControlManagementItemBinding.textViewChangingParameter.setVisibility(4);
        }
    }

    @Override
    public FractionsControlManagementViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FractionsControlManagementItemBinding inflate = FractionsControlManagementItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…, parent, false\n        )");
        return new FractionsControlManagementViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(FractionsControlManagementViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(i);
    }

    @Override
    public int getItemCount() {
        return this.itemCount;
    }
}
