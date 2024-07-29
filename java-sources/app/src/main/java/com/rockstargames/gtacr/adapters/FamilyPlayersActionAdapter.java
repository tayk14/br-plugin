package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesPlayersActionItemBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.rockstargames.gtacr.adapters.FamilyPlayersActionAdapter;
import com.rockstargames.gtacr.data.FamilyPlayersAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cBS\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012>\u0010\u0006\u001a:\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u001c\u0010\u0015\u001a\u00020\r2\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000RF\u0010\u0006\u001a:\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyPlayersActionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FamilyPlayersActionAdapter$ViewHolder;", "playersAction", "", "Lcom/rockstargames/gtacr/data/FamilyPlayersAction;", "clickActionsButton", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisAction", "", "action", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickActionsButton;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesPlayersActionItemBinding;", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyPlayersActionAdapter extends RecyclerView.Adapter<FamilyPlayersActionAdapter.ViewHolder> {
    private Animation anim;
    private FamiliesPlayersActionItemBinding binding;
    private final Function2<FamilyPlayersAction, Integer, Unit> clickActionsButton;
    private final List<FamilyPlayersAction> playersAction;

    public FamilyPlayersActionAdapter(List<FamilyPlayersAction> playersAction, Function2<? super FamilyPlayersAction, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(playersAction, "playersAction");
        this.playersAction = playersAction;
        this.clickActionsButton = (Function2<FamilyPlayersAction, Integer, Unit>) function2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FamiliesPlayersActionItemBinding inflate = FamiliesPlayersActionItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        this.binding = inflate;
        FamiliesPlayersActionItemBinding familiesPlayersActionItemBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        FamiliesPlayersActionItemBinding familiesPlayersActionItemBinding2 = this.binding;
        if (familiesPlayersActionItemBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesPlayersActionItemBinding = familiesPlayersActionItemBinding2;
        }
        return new ViewHolder(this, familiesPlayersActionItemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.playersAction.get(i), this.clickActionsButton);
    }

    @Override
    public int getItemCount() {
        return this.playersAction.size();
    }

    //@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JN\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2>\u0010\t\u001a:\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\u0004\u0018\u0001`\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyPlayersActionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FamiliesPlayersActionItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FamilyPlayersActionAdapter;Lblackrussia/online/databinding/FamiliesPlayersActionItemBinding;)V", "bind", "", "action", "Lcom/rockstargames/gtacr/data/FamilyPlayersAction;", "clickActionsButton", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisAction", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickActionsButton;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final FamiliesPlayersActionItemBinding binding;
        final FamilyPlayersActionAdapter this$0;

        public ViewHolder(FamilyPlayersActionAdapter this$0, FamiliesPlayersActionItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final FamilyPlayersAction action, final Function2<? super FamilyPlayersAction, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(action, "action");
            FamiliesPlayersActionItemBinding familiesPlayersActionItemBinding = this.binding;
            final FamilyPlayersActionAdapter familyPlayersActionAdapter = this.this$0;
            familiesPlayersActionItemBinding.actionsTitle.setText(action.getActionsTitle());
            int type = action.getType();
            if (type == 0) {
                familiesPlayersActionItemBinding.buttonPlusAction.setVisibility(0);
                familiesPlayersActionItemBinding.actionsValue.setVisibility(0);
                familiesPlayersActionItemBinding.buttonMinusAction.setVisibility(0);
                if (action.getActionsId() == 2) {
                    familiesPlayersActionItemBinding.actionsValue.setText(String.valueOf(action.getActionsValue() / 60));
                } else {
                    familiesPlayersActionItemBinding.actionsValue.setText(String.valueOf(action.getActionsValue()));
                }
                familiesPlayersActionItemBinding.buttonKick.setVisibility(8);
            } else if (type == 1) {
                familiesPlayersActionItemBinding.buttonPlusAction.setVisibility(4);
                familiesPlayersActionItemBinding.actionsValue.setVisibility(4);
                familiesPlayersActionItemBinding.buttonMinusAction.setVisibility(4);
                familiesPlayersActionItemBinding.buttonKick.setVisibility(0);
            } else {
                familiesPlayersActionItemBinding.buttonPlusAction.setVisibility(4);
                familiesPlayersActionItemBinding.actionsValue.setVisibility(4);
                familiesPlayersActionItemBinding.buttonMinusAction.setVisibility(4);
                familiesPlayersActionItemBinding.buttonKick.setVisibility(8);
                familiesPlayersActionItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        //FamilyPlayersActionAdapter.ViewHolder.m70bind$lambda4$lambda0(FamilyPlayersActionAdapter.this, function2, action, view);
                    }
                });
            }
            familiesPlayersActionItemBinding.buttonPlusAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //FamilyPlayersActionAdapter.ViewHolder.m71bind$lambda4$lambda1(FamilyPlayersActionAdapter.this, function2, action, view);
                }
            });
            familiesPlayersActionItemBinding.buttonMinusAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //FamilyPlayersActionAdapter.ViewHolder.m72bind$lambda4$lambda2(FamilyPlayersActionAdapter.this, function2, action, view);
                }
            });
            familiesPlayersActionItemBinding.buttonKick.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //FamilyPlayersActionAdapter.ViewHolder.m73bind$lambda4$lambda3(FamilyPlayersActionAdapter.this, function2, action, view);
                }
            });
        }

        public static final void m70bind$lambda4$lambda0(FamilyPlayersActionAdapter this$0, Function2 function2, FamilyPlayersAction action, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(action, "$action");
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            if (function2 == null) {
                return;
            }
            function2.invoke(action, 3);
        }

        public static final void m71bind$lambda4$lambda1(FamilyPlayersActionAdapter this$0, Function2 function2, FamilyPlayersAction action, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(action, "$action");
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            if (function2 == null) {
                return;
            }
            function2.invoke(action, 1);
        }

        public static final void m72bind$lambda4$lambda2(FamilyPlayersActionAdapter this$0, Function2 function2, FamilyPlayersAction action, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(action, "$action");
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            if (function2 == null) {
                return;
            }
            function2.invoke(action, 0);
        }

        public static final void m73bind$lambda4$lambda3(FamilyPlayersActionAdapter this$0, Function2 function2, FamilyPlayersAction action, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(action, "$action");
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            if (function2 == null) {
                return;
            }
            function2.invoke(action, 2);
        }
    }
}
