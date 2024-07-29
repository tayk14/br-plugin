package com.rockstargames.gtacr.gui.familySystem;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesBuyTokenDialogBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.Useful;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/LogicForDialogBuyToken;", "", "mainRoot", "Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "actionsWithJson", "Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;", "(Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesBuyTokenDialogBinding;", "dialogBuyToken", "Landroid/widget/PopupWindow;", "closeDialog", "", "showDialog", "updateCostInBC", "newCost", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LogicForDialogBuyToken {
    private final ActionsWithJSON actionsWithJson;
    private Animation anim;
    private FamiliesBuyTokenDialogBinding binding;
    private final NvEventQueueActivity context;
    private PopupWindow dialogBuyToken;
    private final GUIFamilySystem mainRoot;

    public LogicForDialogBuyToken(GUIFamilySystem mainRoot, NvEventQueueActivity context, ActionsWithJSON actionsWithJson) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionsWithJson, "actionsWithJson");
        this.mainRoot = mainRoot;
        this.context = context;
        this.actionsWithJson = actionsWithJson;
        Object systemService = context.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        FamiliesBuyTokenDialogBinding inflate = FamiliesBuyTokenDialogBinding.inflate((LayoutInflater) systemService);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        this.anim = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        PopupWindow popupWindow = new PopupWindow((View) this.binding.getRoot(), -1, -1, true);
        this.dialogBuyToken = popupWindow;
        if (popupWindow != null) {
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public final void onDismiss() {
                    LogicForDialogBuyToken.m189_init_$lambda0(LogicForDialogBuyToken.this);
                }
            });
        }
        final FamiliesBuyTokenDialogBinding familiesBuyTokenDialogBinding = this.binding;
        familiesBuyTokenDialogBinding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                LogicForDialogBuyToken.m190lambda4$lambda1(LogicForDialogBuyToken.this, view);
            }
        });
        familiesBuyTokenDialogBinding.editTextTokenValue.setGUIManager(mainRoot.getGuiManager());
        familiesBuyTokenDialogBinding.buttonBuyToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                //LogicForDialogBuyToken.m191lambda4$lambda3(mainRoot, this, view);
            }
        });
    }

    public static final void m189_init_$lambda0(LogicForDialogBuyToken this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mainRoot.closeAndroidsButtons();
    }

    public static final void m190lambda4$lambda1(LogicForDialogBuyToken this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.dialogBuyToken;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public static final void m191lambda4$lambda3(blackrussia.online.databinding.FamiliesBuyTokenDialogBinding r3, LogicForDialogBuyToken r4, View r5) {
        Intrinsics.checkNotNullParameter(r3, "$this_apply");
        Intrinsics.checkNotNullParameter(r4, "this$0");
        if (r3 == null) {
            return;
        }
    }

    public final void showDialog() {
        PopupWindow popupWindow = this.dialogBuyToken;
        if (popupWindow != null) {
            popupWindow.showAtLocation(this.context.getParentLayout(), 17, 0, 0);
        }
        FamiliesBuyTokenDialogBinding familiesBuyTokenDialogBinding = this.binding;
        Editable text = familiesBuyTokenDialogBinding.editTextTokenValue.getText();
        if (text != null) {
            text.clear();
        }
        familiesBuyTokenDialogBinding.textValueBuyToken.setText(this.context.getString(R.string.families_buy_token_value_bc, new Object[]{"0"}));
    }

    public final void updateCostInBC(int i) {
        this.binding.textValueBuyToken.setText(this.context.getString(R.string.families_buy_token_value_bc, new Object[]{new Useful().getPriceWithDotForInt(i)}));
    }

    public final void closeDialog() {
        PopupWindow popupWindow = this.dialogBuyToken;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }
}
