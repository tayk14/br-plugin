package com.rockstargames.gtacr.gui.inventory;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import blackrussia.online.databinding.InventoryDialogValueApplyBinding;
import blackrussia.online.network.InvItems;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.Useful;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B|\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012Q\u0010\b\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tj\u0002`\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\rH\u0002J\u0006\u0010\u0013\u001a\u00020\rJ\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RY\u0010\b\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tj\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/LogicForMigrateItemsInCar;", "", "item", "Lblackrussia/online/network/InvItems;", "binding", "Lblackrussia/online/databinding/InventoryDialogValueApplyBinding;", "action", "", "clickActionListenerFromDialogApply", "Lkotlin/Function3;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "applyAction", "", "Lcom/rockstargames/gtacr/gui/inventory/ActionListenerFromDialogApply;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Lblackrussia/online/network/InvItems;Lblackrussia/online/databinding/InventoryDialogValueApplyBinding;ILkotlin/jvm/functions/Function3;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "getActionsFromDialog", "openDialogApply", "setLogicForSeekBarChange", "setStartParametersInView", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LogicForMigrateItemsInCar {
    private final int action;
    private final InventoryDialogValueApplyBinding binding;
    private final Function3<InvItems, Integer, Integer, Unit> clickActionListenerFromDialogApply;
    private final NvEventQueueActivity context;
    private final InvItems item;

    public LogicForMigrateItemsInCar(InvItems invItems, InventoryDialogValueApplyBinding binding, int i, Function3<? super InvItems, ? super Integer, ? super Integer, Unit> clickActionListenerFromDialogApply, NvEventQueueActivity nvEventQueueActivity) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(clickActionListenerFromDialogApply, "clickActionListenerFromDialogApply");
        this.item = invItems;
        this.binding = binding;
        this.action = i;
        this.clickActionListenerFromDialogApply = (Function3<InvItems, Integer, Integer, Unit>) clickActionListenerFromDialogApply;
        this.context = nvEventQueueActivity;
    }

    public final void openDialogApply() {
        setStartParametersInView();
        setLogicForSeekBarChange();
        getActionsFromDialog();
    }

    private final void setStartParametersInView() {
        InventoryDialogValueApplyBinding inventoryDialogValueApplyBinding = this.binding;
        inventoryDialogValueApplyBinding.dialogValueApplyMinValue.setText("1");
        TextView textView = inventoryDialogValueApplyBinding.dialogValueApplyMaxValue;
        InvItems invItems = this.item;
        textView.setText(String.valueOf(invItems == null ? null : Integer.valueOf(invItems.getItemsValue())));
        TextView textView2 = inventoryDialogValueApplyBinding.dialogValueApplyTitleItem;
        InvItems invItems2 = this.item;
        textView2.setText(invItems2 != null ? invItems2.getName() : null);
        InvItems invItems3 = this.item;
        if (invItems3 == null) {
            return;
        }
        inventoryDialogValueApplyBinding.dialogValueApplySeekbarWithValue.setMax(invItems3.getItemsValue() - 1);
        int i = invItems3.getId() == 134 ? 2 : 0;
        int i2 = invItems3.getId() == 134 ? 1 : 3;
        if (invItems3.getThisBitmap() == null) {
            Useful useful = new Useful();
            NvEventQueueActivity nvEventQueueActivity = this.context;
            int id = invItems3.getId();
            int modelid = invItems3.getModelid();
            ImageView imageView = this.binding.dialogValueApplyItemsIcon;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.dialogValueApplyItemsIcon");
            useful.renderItem(nvEventQueueActivity, i, id, modelid, i2, imageView, invItems3.getX(), invItems3.getY(), invItems3.getZ(), invItems3.getZoom(), invItems3.getShiftX(), invItems3.getShiftY(), invItems3.getShiftZ(), invItems3);
            return;
        }
        this.binding.dialogValueApplyItemsIcon.setImageBitmap(invItems3.getThisBitmap());
    }

    private final void setLogicForSeekBarChange() {
        this.binding.dialogValueApplySeekbarWithValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                InventoryDialogValueApplyBinding inventoryDialogValueApplyBinding;
                inventoryDialogValueApplyBinding = LogicForMigrateItemsInCar.this.binding;
                inventoryDialogValueApplyBinding.dialogValueApplyMinValue.setText(String.valueOf(i + 1));
            }
        });
    }

    private final void getActionsFromDialog() {
        this.binding.dialogValueApplyButtonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                LogicForMigrateItemsInCar.m335getActionsFromDialog$lambda2(LogicForMigrateItemsInCar.this, view);
            }
        });
        this.binding.dialogValueApplyButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                LogicForMigrateItemsInCar.m336getActionsFromDialog$lambda3(LogicForMigrateItemsInCar.this, view);
            }
        });
    }

    public static final void m335getActionsFromDialog$lambda2(LogicForMigrateItemsInCar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int progress = this$0.binding.dialogValueApplySeekbarWithValue.getProgress() + 1;
        InvItems invItems = this$0.item;
        if (invItems != null) {
            invItems.setItemsValue(progress);
        }
        this$0.clickActionListenerFromDialogApply.invoke(this$0.item, Integer.valueOf(this$0.action), 11);
    }

    public static final void m336getActionsFromDialog$lambda3(LogicForMigrateItemsInCar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clickActionListenerFromDialogApply.invoke(this$0.item, Integer.valueOf(this$0.action), 10);
    }
}
