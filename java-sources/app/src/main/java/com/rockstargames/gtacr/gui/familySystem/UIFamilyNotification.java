package com.rockstargames.gtacr.gui.familySystem;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesNotificationLayoutBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.FamilyNotificationAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.FamilyNotificationData;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

//@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0011J\b\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020\u0015H\u0016J\u000e\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020\u0015H\u0002J\b\u0010-\u001a\u00020\u0015H\u0002J\u0014\u0010.\u001a\u00020\u00152\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R1\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010j\u0004\u0018\u0001`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/UIFamilyNotification;", "Lcom/rockstargames/gtacr/common/UILayout;", "mainRoot", "Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;", "logicForDialogApply", "Lcom/rockstargames/gtacr/gui/familySystem/LogicForDialogApply;", "(Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;Lcom/rockstargames/gtacr/gui/familySystem/LogicForDialogApply;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesNotificationLayoutBinding;", "clickNotification", "Lkotlin/Function1;", "Lcom/rockstargames/gtacr/data/FamilyNotificationData;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisNotification", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickNotification;", "familyNotifications", "", "notificationAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyNotificationAdapter;", "oldTimer", "", "addNewNotification", "newNotification", "addOldNotification", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "removeNotification", "oldId", "", "setDataInView", "setLogicForClickNotification", "setStartData", "notifications", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIFamilyNotification extends UILayout {
    private final ActionsWithJSON actionsWithJSON;
    private Animation anim;
    private FamiliesNotificationLayoutBinding binding;
    private Function1<? super FamilyNotificationData, Unit> clickNotification;
    private final NvEventQueueActivity context;
    private final List<FamilyNotificationData> familyNotifications;
    private final LogicForDialogApply logicForDialogApply;
    private final GUIFamilySystem mainRoot;
    private FamilyNotificationAdapter notificationAdapter;
    private long oldTimer;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIFamilyNotification(GUIFamilySystem mainRoot, NvEventQueueActivity context, ActionsWithJSON actionsWithJSON, LogicForDialogApply logicForDialogApply) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.mainRoot = mainRoot;
        this.context = context;
        this.actionsWithJSON = actionsWithJSON;
        this.logicForDialogApply = logicForDialogApply;
        this.familyNotifications = new ArrayList();
    }

    public final void setStartData(List<FamilyNotificationData> notifications) {
        Intrinsics.checkNotNullParameter(notifications, "notifications");
        List<FamilyNotificationData> list = this.familyNotifications;
        list.clear();
        list.addAll(notifications);
        FamilyNotificationAdapter familyNotificationAdapter = this.notificationAdapter;
        FamiliesNotificationLayoutBinding familiesNotificationLayoutBinding = null;
        if (familyNotificationAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationAdapter");
            familyNotificationAdapter = null;
        }
        familyNotificationAdapter.notifyDataSetChanged();
        FamiliesNotificationLayoutBinding familiesNotificationLayoutBinding2 = this.binding;
        if (familiesNotificationLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesNotificationLayoutBinding = familiesNotificationLayoutBinding2;
        }
        if (this.mainRoot.getIfLeader() == 1) {
            familiesNotificationLayoutBinding.addNewNotification.setVisibility(0);
            familiesNotificationLayoutBinding.editTextNotification.setVisibility(0);
            return;
        }
        familiesNotificationLayoutBinding.addNewNotification.setVisibility(4);
        familiesNotificationLayoutBinding.editTextNotification.setVisibility(4);
    }

    public final void addNewNotification(FamilyNotificationData newNotification) {
        Intrinsics.checkNotNullParameter(newNotification, "newNotification");
        this.familyNotifications.add(0, newNotification);
        if (this.familyNotifications.size() > 5) {
            this.familyNotifications.remove(5);
        }
        FamilyNotificationAdapter familyNotificationAdapter = this.notificationAdapter;
        if (familyNotificationAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationAdapter");
            familyNotificationAdapter = null;
        }
        familyNotificationAdapter.notifyDataSetChanged();
    }

    public final void addOldNotification(FamilyNotificationData newNotification) {
        Intrinsics.checkNotNullParameter(newNotification, "newNotification");
        this.familyNotifications.add(newNotification);
        FamilyNotificationAdapter familyNotificationAdapter = this.notificationAdapter;
        if (familyNotificationAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationAdapter");
            familyNotificationAdapter = null;
        }
        familyNotificationAdapter.notifyDataSetChanged();
    }

    public final void removeNotification(int i) {
        if (this.familyNotifications.size() > 0) {
            int i2 = 0;
            int size = this.familyNotifications.size();
            while (i2 < size) {
                int i3 = i2 + 1;
                if (this.familyNotifications.get(i2).getNotificationsId() == i) {
                    this.familyNotifications.remove(i2);
                    FamilyNotificationAdapter familyNotificationAdapter = this.notificationAdapter;
                    if (familyNotificationAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("notificationAdapter");
                        familyNotificationAdapter = null;
                    }
                    familyNotificationAdapter.notifyItemRemoved(i2);
                    return;
                }
                i2 = i3;
            }
        }
    }

    @Override
    public View getView() {
        FamiliesNotificationLayoutBinding familiesNotificationLayoutBinding = this.binding;
        if (familiesNotificationLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesNotificationLayoutBinding = null;
        }
        ConstraintLayout root = familiesNotificationLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FamiliesNotificationLayoutBinding inflate = FamiliesNotificationLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        FamiliesNotificationLayoutBinding familiesNotificationLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        setLogicForClickNotification();
        setDataInView();
        FamiliesNotificationLayoutBinding familiesNotificationLayoutBinding2 = this.binding;
        if (familiesNotificationLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesNotificationLayoutBinding2 = null;
        }
        FamiliesNotificationLayoutBinding finalFamiliesNotificationLayoutBinding = familiesNotificationLayoutBinding2;
        familiesNotificationLayoutBinding2.addNewNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIFamilyNotification.m192onCreateView$lambda3$lambda2(UIFamilyNotification.this, finalFamiliesNotificationLayoutBinding, view);
            }
        });
        FamiliesNotificationLayoutBinding familiesNotificationLayoutBinding3 = this.binding;
        if (familiesNotificationLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesNotificationLayoutBinding = familiesNotificationLayoutBinding3;
        }
        ConstraintLayout root = familiesNotificationLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public static final void m192onCreateView$lambda3$lambda2(UIFamilyNotification this$0, FamiliesNotificationLayoutBinding this_apply, View view) {
        Editable text = null;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        FamiliesNotificationLayoutBinding familiesNotificationLayoutBinding = null;
        if (System.currentTimeMillis() - this$0.oldTimer > 300) {
            this$0.oldTimer = System.currentTimeMillis();
            Editable text2 = this_apply.editTextNotification.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "editTextNotification.text");
            if (!(text2.length() > 0)) {
                Intrinsics.checkNotNullExpressionValue(this_apply.editTextNotification.getText(), "editTextNotification.text");
                if (!(!StringsKt.isBlank(text))) {
                    this$0.actionsWithJSON.sendMessageError("Введите текст в поле для ввода");
                }
            }
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            this$0.actionsWithJSON.sendMessageForServer(this_apply.editTextNotification.getText().toString());
            this_apply.editTextNotification.getText().clear();
            Object systemService = this$0.context.getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            FamiliesNotificationLayoutBinding familiesNotificationLayoutBinding2 = this$0.binding;
            if (familiesNotificationLayoutBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                familiesNotificationLayoutBinding2 = null;
            }
            inputMethodManager.hideSoftInputFromWindow(familiesNotificationLayoutBinding2.getRoot().getWindowToken(), 0);
            this_apply.editTextNotification.setFocusable(false);
            this_apply.editTextNotification.setFocusableInTouchMode(true);
        }
        FamiliesNotificationLayoutBinding familiesNotificationLayoutBinding3 = this$0.binding;
        if (familiesNotificationLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesNotificationLayoutBinding = familiesNotificationLayoutBinding3;
        }
        GUIManager.hideSystemUI(familiesNotificationLayoutBinding.getRoot());
    }

    private final void setDataInView() {
        this.notificationAdapter = new FamilyNotificationAdapter(this.familyNotifications, this.context, this.clickNotification);
        FamiliesNotificationLayoutBinding familiesNotificationLayoutBinding = this.binding;
        FamilyNotificationAdapter familyNotificationAdapter = null;
        if (familiesNotificationLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesNotificationLayoutBinding = null;
        }
        RecyclerView recyclerView = familiesNotificationLayoutBinding.familyNotifications;
        FamiliesNotificationLayoutBinding familiesNotificationLayoutBinding2 = this.binding;
        if (familiesNotificationLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesNotificationLayoutBinding2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesNotificationLayoutBinding2.getRoot().getContext(), 1, false));
        FamilyNotificationAdapter familyNotificationAdapter2 = this.notificationAdapter;
        if (familyNotificationAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationAdapter");
        } else {
            familyNotificationAdapter = familyNotificationAdapter2;
        }
        recyclerView.setAdapter(familyNotificationAdapter);
    }

    private final void setLogicForClickNotification() {
        this.clickNotification = new Function1<FamilyNotificationData, Unit>() {
            @Override
            public Unit invoke(FamilyNotificationData familyNotificationData) {
                invoke2(familyNotificationData);
                return Unit.INSTANCE;
            }

            public void invoke2(FamilyNotificationData r3) {
            }
        };
    }
}
