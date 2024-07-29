package com.rockstargames.gtacr.gui.familySystem;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import android.widget.TextView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesApplyWindowBinding;
import blackrussia.online.network.FamilySystemShopObj;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.data.FamilyNotificationData;
import com.rockstargames.gtacr.gui.Useful;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012J5\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\u001bJ3\u0010\u001c\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/LogicForDialogApply;", "", "mainRoot", "Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "actionsWithJson", "Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;", "(Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;)V", "anim", "Landroid/view/animation/Animation;", "bindingDialogApply", "Lblackrussia/online/databinding/FamiliesApplyWindowBinding;", "blockedSpam", "", "dialogApply", "Landroid/widget/PopupWindow;", "closeDialogApply", "", "setTextInView", "thisItem", "Lblackrussia/online/network/FamilySystemShopObj;", "thisPrice", "", "ifClickLeave", "thisNotification", "Lcom/rockstargames/gtacr/data/FamilyNotificationData;", "(Lblackrussia/online/network/FamilySystemShopObj;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/rockstargames/gtacr/data/FamilyNotificationData;)V", "showDialog", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LogicForDialogApply {
    private final ActionsWithJSON actionsWithJson;
    private Animation anim;
    private FamiliesApplyWindowBinding bindingDialogApply;
    private boolean blockedSpam;
    private final NvEventQueueActivity context;
    private PopupWindow dialogApply;
    private final GUIFamilySystem mainRoot;

    public LogicForDialogApply(GUIFamilySystem mainRoot, NvEventQueueActivity context, ActionsWithJSON actionsWithJson) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionsWithJson, "actionsWithJson");
        this.mainRoot = mainRoot;
        this.context = context;
        this.actionsWithJson = actionsWithJson;
        Object systemService = context.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        FamiliesApplyWindowBinding inflate = FamiliesApplyWindowBinding.inflate((LayoutInflater) systemService);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.bindingDialogApply = inflate;
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(bindingDia…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        PopupWindow popupWindow = new PopupWindow((View) this.bindingDialogApply.getRoot(), -1, -1, true);
        this.dialogApply = popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public final void onDismiss() {
                LogicForDialogApply.m184_init_$lambda0(LogicForDialogApply.this);
            }
        });
    }

    public static final void m184_init_$lambda0(LogicForDialogApply this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mainRoot.closeAndroidsButtons();
        this$0.blockedSpam = false;
    }

    public final void showDialog(final FamilySystemShopObj familySystemShopObj, final Integer num, final Boolean bool, final FamilyNotificationData familyNotificationData) {
        setTextInView(familySystemShopObj, num, bool, familyNotificationData);
        PopupWindow popupWindow = this.dialogApply;
        if (popupWindow != null) {
            popupWindow.showAtLocation(this.context.getParentLayout(), 17, 0, 0);
        }
        this.bindingDialogApply.buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                LogicForDialogApply.m186showDialog$lambda2(LogicForDialogApply.this, familySystemShopObj, num, bool, familyNotificationData, view);
            }
        });
        this.bindingDialogApply.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                LogicForDialogApply.m188showDialog$lambda3(LogicForDialogApply.this, view);
            }
        });
    }

    public static final void m186showDialog$lambda2(final LogicForDialogApply this$0, final FamilySystemShopObj familySystemShopObj, final Integer num, final Boolean bool, final FamilyNotificationData familyNotificationData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.startAnimation(this$0.anim);
        if (!this$0.blockedSpam) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    LogicForDialogApply.m187showDialog$lambda2$lambda1(familySystemShopObj, this$0, num, bool, familyNotificationData);
                }
            }, 250L);
        }
        this$0.blockedSpam = true;
    }

    public static final void m187showDialog$lambda2$lambda1(FamilySystemShopObj familySystemShopObj, LogicForDialogApply this$0, Integer num, Boolean bool, FamilyNotificationData familyNotificationData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (familySystemShopObj != null) {
            this$0.actionsWithJson.buyItemInShop(familySystemShopObj.getId());
        } else if (num != null) {
            this$0.mainRoot.upgradeFamily();
        } else if (bool != null) {
            this$0.actionsWithJson.sendPressButton(10);
        } else if (familyNotificationData != null) {
            this$0.actionsWithJson.sendDeleteNotification(familyNotificationData.getNotificationsId());
            this$0.closeDialogApply();
        }
    }

    public static final void m188showDialog$lambda3(LogicForDialogApply this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.dialogApply;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    private final void setTextInView(FamilySystemShopObj familySystemShopObj, Integer num, Boolean bool, FamilyNotificationData familyNotificationData) {
        String string;
        if (familySystemShopObj != null) {
            String str = familySystemShopObj.getType() == 0 ? "семейных монет" : "семейных жетонов";
            TextView textView = this.bindingDialogApply.dialogApplyBodyItem;
            int typeId = familySystemShopObj.getTypeId();
            if (typeId == 3) {
                string = this.context.getString(R.string.families_open_box, new Object[]{new Useful().getPriceWithSpacesForInt(familySystemShopObj.getPrice()), str});
            } else if (typeId == 4) {
                string = this.context.getString(R.string.families_apply_buy_syndicate, new Object[]{new Useful().getPriceWithSpacesForInt(familySystemShopObj.getPrice())});
            } else {
                string = this.context.getString(R.string.families_buy_item_in_shop, new Object[]{new Useful().getPriceWithSpacesForInt(familySystemShopObj.getPrice()), str});
            }
            textView.setText(string);
        } else if (num != null) {
            this.bindingDialogApply.dialogApplyBodyItem.setText(this.context.getString(R.string.families_apply_update, new Object[]{new Useful().getPriceWithSpacesForInt(num.intValue())}));
        } else if (bool != null) {
            this.bindingDialogApply.dialogApplyBodyItem.setText(this.context.getText(R.string.families_apply_leave));
        } else if (familyNotificationData != null) {
            this.bindingDialogApply.dialogApplyBodyItem.setText(this.context.getText(R.string.families_apply_delete_notification));
        }
    }

    public final void closeDialogApply() {
        PopupWindow popupWindow = this.dialogApply;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }
}
