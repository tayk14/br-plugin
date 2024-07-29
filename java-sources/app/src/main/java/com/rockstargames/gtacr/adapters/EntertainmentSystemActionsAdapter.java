package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.EntertainmentSystemGamesItemBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.EntertainmentSystemActionsAdapter;
import com.rockstargames.gtacr.data.EntertainmentGameData;
import com.rockstargames.gtacr.gui.Useful;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001!B\u0093\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012:\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000e\u0012:\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u001c\u0010\u0019\u001a\u00020\r2\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000bRB\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000RB\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/rockstargames/gtacr/adapters/EntertainmentSystemActionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/EntertainmentSystemActionsAdapter$ViewHolder;", "actionsList", "", "Lcom/rockstargames/gtacr/data/EntertainmentGameData;", "actionsClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "action", "", "position", "", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/EntertainmentActionsClickListener;", "buttonClickListener", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/EntertainmentActionsButtonClickListener;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/EntertainmentSystemGamesItemBinding;", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCheckOnlyElement", "checkedPosition", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EntertainmentSystemActionsAdapter extends RecyclerView.Adapter<EntertainmentSystemActionsAdapter.ViewHolder> {
    private final Function2<EntertainmentGameData, Integer, Unit> actionsClickListener;
    private final List<EntertainmentGameData> actionsList;
    private Animation anim;
    private EntertainmentSystemGamesItemBinding binding;
    private final Function2<EntertainmentGameData, Integer, Unit> buttonClickListener;
    private final NvEventQueueActivity context;

    public EntertainmentSystemActionsAdapter(List<EntertainmentGameData> actionsList, Function2<? super EntertainmentGameData, ? super Integer, Unit> actionsClickListener, Function2<? super EntertainmentGameData, ? super Integer, Unit> buttonClickListener, NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(actionsList, "actionsList");
        Intrinsics.checkNotNullParameter(actionsClickListener, "actionsClickListener");
        Intrinsics.checkNotNullParameter(buttonClickListener, "buttonClickListener");
        Intrinsics.checkNotNullParameter(context, "context");
        this.actionsList = actionsList;
        this.actionsClickListener = (Function2<EntertainmentGameData, Integer, Unit>) actionsClickListener;
        this.buttonClickListener = (Function2<EntertainmentGameData, Integer, Unit>) buttonClickListener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        EntertainmentSystemGamesItemBinding inflate = EntertainmentSystemGamesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        return new ViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.actionsList.get(i), this.actionsClickListener, this.buttonClickListener);
    }

    @Override
    public int getItemCount() {
        return this.actionsList.size();
    }

    //@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0086\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2:\u0010\f\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\rj\u0002`\u00112:\u0010\u0012\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\rj\u0002`\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/rockstargames/gtacr/adapters/EntertainmentSystemActionsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/EntertainmentSystemGamesItemBinding;", "(Lcom/rockstargames/gtacr/adapters/EntertainmentSystemActionsAdapter;Lblackrussia/online/databinding/EntertainmentSystemGamesItemBinding;)V", "invisible", "", "visible", "bind", "", "action", "Lcom/rockstargames/gtacr/data/EntertainmentGameData;", "actionsClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "position", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/EntertainmentActionsClickListener;", "buttonClickListener", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/EntertainmentActionsButtonClickListener;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final EntertainmentSystemGamesItemBinding binding;
        private final int invisible;
        final EntertainmentSystemActionsAdapter this$0;
        private int visible;

        public ViewHolder(EntertainmentSystemActionsAdapter this$0, EntertainmentSystemGamesItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
            this.invisible = 4;
        }

        public final void bind(final EntertainmentGameData action, final Function2<? super EntertainmentGameData, ? super Integer, Unit> actionsClickListener, final Function2<? super EntertainmentGameData, ? super Integer, Unit> buttonClickListener) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(actionsClickListener, "actionsClickListener");
            Intrinsics.checkNotNullParameter(buttonClickListener, "buttonClickListener");
            EntertainmentSystemActionsAdapter entertainmentSystemActionsAdapter = this.this$0;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.binding.getRoot().getContext(), R.anim.button_click);
            Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
            entertainmentSystemActionsAdapter.anim = loadAnimation;
            EntertainmentSystemGamesItemBinding entertainmentSystemGamesItemBinding = this.binding;
            final EntertainmentSystemActionsAdapter entertainmentSystemActionsAdapter2 = this.this$0;
            if (action.isClicked()) {
                entertainmentSystemGamesItemBinding.bgItemsBorder.setVisibility(this.visible);
            } else {
                entertainmentSystemGamesItemBinding.bgItemsBorder.setVisibility(this.invisible);
            }
            entertainmentSystemGamesItemBinding.actionsTitle.setText(action.getGamesName());
            entertainmentSystemGamesItemBinding.itemsIcon.setImageDrawable(new Useful().getDrawableByName(action.getIdIcon(), entertainmentSystemActionsAdapter2.context));
            entertainmentSystemGamesItemBinding.valueOfPlayers.setText(entertainmentSystemActionsAdapter2.context.getString(R.string.entertainment_system_players, new Object[]{String.valueOf(action.getPlayers())}));
            if (action.getStatus() == 0) {
                entertainmentSystemGamesItemBinding.buttonAction.setBackground(ResourcesCompat.getDrawable(entertainmentSystemActionsAdapter2.context.getResources(), R.drawable.button_apply_actual_style, null));
                entertainmentSystemGamesItemBinding.buttonAction.setText(entertainmentSystemActionsAdapter2.context.getText(R.string.entertainment_system_button_participate));
            } else {
                entertainmentSystemGamesItemBinding.buttonAction.setBackground(ResourcesCompat.getDrawable(entertainmentSystemActionsAdapter2.context.getResources(), R.drawable.button_cancel_actual_style, null));
                entertainmentSystemGamesItemBinding.buttonAction.setText(entertainmentSystemActionsAdapter2.context.getText(R.string.entertainment_system_button_leave));
            }
            entertainmentSystemGamesItemBinding.buttonAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //EntertainmentSystemActionsAdapter.ViewHolder.m54bind$lambda2$lambda0(EntertainmentSystemActionsAdapter.this, buttonClickListener, action, this, view);
                }
            });
            entertainmentSystemGamesItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //EntertainmentSystemActionsAdapter.ViewHolder.m55bind$lambda2$lambda1(actionsClickListener, action, this$0, view);
                }
            });
        }

        public static final void m54bind$lambda2$lambda0(EntertainmentSystemActionsAdapter this$0, Function2 buttonClickListener, EntertainmentGameData action, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(buttonClickListener, "$buttonClickListener");
            Intrinsics.checkNotNullParameter(action, "$action");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            buttonClickListener.invoke(action, Integer.valueOf(this$1.getLayoutPosition()));
        }

        public static final void m55bind$lambda2$lambda1(Function2 actionsClickListener, EntertainmentGameData action, ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(actionsClickListener, "$actionsClickListener");
            Intrinsics.checkNotNullParameter(action, "$action");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            actionsClickListener.invoke(action, Integer.valueOf(this$0.getLayoutPosition()));
        }
    }

    public final void setCheckOnlyElement(int i) {
        int size = this.actionsList.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (this.actionsList.get(i2).isClicked() && i2 != i) {
                this.actionsList.get(i2).setClicked(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }
}
