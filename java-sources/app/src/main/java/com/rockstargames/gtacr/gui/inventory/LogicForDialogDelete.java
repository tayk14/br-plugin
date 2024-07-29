package com.rockstargames.gtacr.gui.inventory;

import android.view.View;
import blackrussia.online.databinding.InventoryDialogApplyDeletItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/LogicForDialogDelete;", "", "root", "Lcom/rockstargames/gtacr/gui/inventory/UILayoutUsersInventory;", "binding", "Lblackrussia/online/databinding/InventoryDialogApplyDeletItemBinding;", "(Lcom/rockstargames/gtacr/gui/inventory/UILayoutUsersInventory;Lblackrussia/online/databinding/InventoryDialogApplyDeletItemBinding;)V", "setLogicForDialog", "", "startDialogDelete", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LogicForDialogDelete {
    private final InventoryDialogApplyDeletItemBinding binding;
    private final UILayoutUsersInventory root;

    public LogicForDialogDelete(UILayoutUsersInventory root, InventoryDialogApplyDeletItemBinding binding) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.root = root;
        this.binding = binding;
    }

    public final void startDialogDelete() {
        setLogicForDialog();
    }

    private final void setLogicForDialog() {
        this.binding.dialogValueApplyButtonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                LogicForDialogDelete.m332setLogicForDialog$lambda0(LogicForDialogDelete.this, view);
            }
        });
        this.binding.dialogValueApplyButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                LogicForDialogDelete.m333setLogicForDialog$lambda1(LogicForDialogDelete.this, view);
            }
        });
        this.binding.dialogValueApplyButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                LogicForDialogDelete.m334setLogicForDialog$lambda2(LogicForDialogDelete.this, view);
            }
        });
    }

    public static final void m332setLogicForDialog$lambda0(LogicForDialogDelete this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.root.deleteThisItem();
    }

    public static final void m333setLogicForDialog$lambda1(LogicForDialogDelete this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.root.closePopupWindowDelete();
    }

    public static final void m334setLogicForDialog$lambda2(LogicForDialogDelete this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.root.closePopupWindowDelete();
    }
}
