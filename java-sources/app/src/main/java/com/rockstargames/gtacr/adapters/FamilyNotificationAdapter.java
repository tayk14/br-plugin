package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesNotificationItemBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyNotificationAdapter;
import com.rockstargames.gtacr.data.FamilyNotificationData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bBF\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012)\u0010\b\u001a%\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\tj\u0004\u0018\u0001`\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\r2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R1\u0010\b\u001a%\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\tj\u0004\u0018\u0001`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyNotificationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FamilyNotificationAdapter$ViewHolder;", "familyNotifications", "", "Lcom/rockstargames/gtacr/data/FamilyNotificationData;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "clickNotification", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisNotification", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickNotification;", "(Ljava/util/List;Lcom/nvidia/devtech/NvEventQueueActivity;Lkotlin/jvm/functions/Function1;)V", "binding", "Lblackrussia/online/databinding/FamiliesNotificationItemBinding;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyNotificationAdapter extends RecyclerView.Adapter<FamilyNotificationAdapter.ViewHolder> {
    private FamiliesNotificationItemBinding binding;
    private final Function1<FamilyNotificationData, Unit> clickNotification;
    private final NvEventQueueActivity context;
    private final List<FamilyNotificationData> familyNotifications;

    public FamilyNotificationAdapter(List<FamilyNotificationData> familyNotifications, NvEventQueueActivity context, Function1<? super FamilyNotificationData, Unit> function1) {
        Intrinsics.checkNotNullParameter(familyNotifications, "familyNotifications");
        Intrinsics.checkNotNullParameter(context, "context");
        this.familyNotifications = familyNotifications;
        this.context = context;
        this.clickNotification = (Function1<FamilyNotificationData, Unit>) function1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FamiliesNotificationItemBinding inflate = FamiliesNotificationItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        holder.bind(this.familyNotifications.get(i), this.clickNotification);
    }

    @Override
    public int getItemCount() {
        return this.familyNotifications.size();
    }

    //@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J9\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2)\u0010\t\u001a%\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\u0004\u0018\u0001`\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyNotificationAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FamiliesNotificationItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FamilyNotificationAdapter;Lblackrussia/online/databinding/FamiliesNotificationItemBinding;)V", "bind", "", "notification", "Lcom/rockstargames/gtacr/data/FamilyNotificationData;", "clickNotification", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisNotification", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickNotification;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final FamiliesNotificationItemBinding binding;
        final FamilyNotificationAdapter this$0;

        public ViewHolder(FamilyNotificationAdapter this$0, FamiliesNotificationItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final FamilyNotificationData notification, final Function1<? super FamilyNotificationData, Unit> function1) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            FamiliesNotificationItemBinding familiesNotificationItemBinding = this.binding;
            FamilyNotificationAdapter familyNotificationAdapter = this.this$0;
            familiesNotificationItemBinding.notificationsValue.setText(notification.getNotificationsValue());
            familiesNotificationItemBinding.notificationsAuthor.setText(familyNotificationAdapter.context.getString(R.string.families_notifications_author, new Object[]{notification.getNotificationsAuthor()}));
            familiesNotificationItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //FamilyNotificationAdapter.ViewHolder.m69bind$lambda1$lambda0(Function1.this, notification, view);
                }
            });
        }

        public static final void m69bind$lambda1$lambda0(Function1 function1, FamilyNotificationData notification, View view) {
            Intrinsics.checkNotNullParameter(notification, "$notification");
            if (function1 == null) {
                return;
            }
            function1.invoke(notification);
        }
    }
}
