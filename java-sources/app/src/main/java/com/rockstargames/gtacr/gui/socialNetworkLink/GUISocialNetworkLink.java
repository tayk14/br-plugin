package com.rockstargames.gtacr.gui.socialNetworkLink;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.Preferences;
import blackrussia.online.R;
import blackrussia.online.Utils;
import blackrussia.online.databinding.SocialNetworkLinkLayoutBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.fractions.FractionsUtilsKt;
import com.rockstargames.gtacr.gui.socialNetworkLink.adapters.SocialButtonAdapter;
import com.rockstargames.gtacr.gui.socialNetworkLink.data.ServersObj;
import com.rockstargames.gtacr.gui.socialNetworkLink.data.SocialButtonObj;
import com.rockstargames.gtacr.gui.socialNetworkLink.network.SocialNetworkActionWithJSON;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J&\u0010)\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010*\u001a\u0004\u0018\u00010\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010,\u001a\u00020\u00172\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/rockstargames/gtacr/gui/socialNetworkLink/GUISocialNetworkLink;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "()V", "actionWithJSON", "Lcom/rockstargames/gtacr/gui/socialNetworkLink/network/SocialNetworkActionWithJSON;", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/SocialNetworkLinkLayoutBinding;", "buttonAdapter", "Lcom/rockstargames/gtacr/gui/socialNetworkLink/adapters/SocialButtonAdapter;", "buttonsList", "", "Lcom/rockstargames/gtacr/gui/socialNetworkLink/data/SocialButtonObj;", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "mainActivity", "Lcom/nvidia/devtech/NvEventQueueActivity;", "popupWindow", "Landroid/widget/PopupWindow;", "statusCheckBox", "", "close", "", "json", "Lorg/json/JSONObject;", "closeAndroidsButtons", "getDataFromJSON", "getGuiId", "getMainActivity", "initButtons", "initButtonsView", "initPopupWindow", "isShowingGui", "", "onPacketIncoming", "setBackgroundImage", "imageRes", "currentView", "Landroid/view/View;", "setNullableParameters", "show", "manager", "activity", "updateButtonStatus", "buttonStatus", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GUISocialNetworkLink implements ISAMPGUI {
    public static final Companion Companion = new Companion(null);
    private SocialNetworkActionWithJSON actionWithJSON;
    private Animation anim;
    private SocialNetworkLinkLayoutBinding binding;
    private SocialButtonAdapter buttonAdapter;
    private final List<SocialButtonObj> buttonsList = new ArrayList();
    private GUIManager guiManager;
    private NvEventQueueActivity mainActivity;
    private PopupWindow popupWindow;
    private int statusCheckBox;

    @JvmStatic
    public static final GUISocialNetworkLink newInstance() {
        return Companion.newInstance();
    }

    @Override
    public int getGuiId() {
        return 52;
    }

    @Override
    public void onPacketIncoming(JSONObject jSONObject) {
    }

    public final NvEventQueueActivity getMainActivity() {
        return this.mainActivity;
    }

    //@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/socialNetworkLink/GUISocialNetworkLink$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/socialNetworkLink/GUISocialNetworkLink;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GUISocialNetworkLink newInstance() {
            return new GUISocialNetworkLink();
        }
    }

    @Override
    public void show(JSONObject jSONObject, final GUIManager gUIManager, final NvEventQueueActivity nvEventQueueActivity) {
        this.mainActivity = nvEventQueueActivity;
        this.guiManager = gUIManager;
        this.actionWithJSON = new SocialNetworkActionWithJSON(gUIManager);
        initButtons();
        getDataFromJSON(jSONObject);
        if (this.popupWindow == null) {
            initPopupWindow();
        }
        initButtonsView();
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public final void onDismiss() {
                    GUISocialNetworkLink.m399show$lambda1(GUISocialNetworkLink.this, nvEventQueueActivity, gUIManager);
                }
            });
        }
        final SocialNetworkLinkLayoutBinding socialNetworkLinkLayoutBinding = this.binding;
        if (socialNetworkLinkLayoutBinding == null) {
            return;
        }
        socialNetworkLinkLayoutBinding.socialNetworkLinkButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUISocialNetworkLink.m400show$lambda5$lambda2(GUISocialNetworkLink.this, view);
            }
        });
        socialNetworkLinkLayoutBinding.socialNetworkLinkCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                GUISocialNetworkLink.m401show$lambda5$lambda3(GUISocialNetworkLink.this, compoundButton, z);
            }
        });
        socialNetworkLinkLayoutBinding.socialNetworkLinkCheckboxText.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                //GUISocialNetworkLink.m402show$lambda5$lambda4(SocialNetworkLinkLayoutBinding.this, view);
            }
        });
    }

    public static final void m399show$lambda1(GUISocialNetworkLink this$0, NvEventQueueActivity nvEventQueueActivity, GUIManager gUIManager) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NvEventQueueActivity nvEventQueueActivity2 = this$0.mainActivity;
        if (nvEventQueueActivity2 != null && this$0.statusCheckBox == 1) {
            ServersObj serversObj = (ServersObj) Preferences.getObject(nvEventQueueActivity2, "status", ServersObj.class);
            if (serversObj != null) {
                serversObj.getServerWithoutDisplay().add(Integer.valueOf(nvEventQueueActivity2.getCurrServer()));
                Preferences.putObject(this$0.mainActivity, "status", serversObj);
            } else {
                Preferences.putObject(this$0.mainActivity, "status", new ServersObj(CollectionsKt.mutableListOf(Integer.valueOf(nvEventQueueActivity2.getCurrServer()))));
            }
        }
        if (nvEventQueueActivity != null) {
            //nvEventQueueActivity.toggleDrawing2dStuff(false);
        }
        if (gUIManager != null) {
            gUIManager.closeGUI(null, this$0.getGuiId());
        }
        this$0.setNullableParameters();
    }

    public static final void m400show$lambda5$lambda2(GUISocialNetworkLink this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public static final void m401show$lambda5$lambda3(GUISocialNetworkLink this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.statusCheckBox = z ? 1 : 0;
    }

    public static final void m402show$lambda5$lambda4(SocialNetworkLinkLayoutBinding _binding, View view) {
        Intrinsics.checkNotNullParameter(_binding, "$_binding");
        _binding.socialNetworkLinkCheckbox.setChecked(!_binding.socialNetworkLinkCheckbox.isChecked());
    }

    private final void getDataFromJSON(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(SocialNetworkLinkUtils.KEY_BUTTON_STATUS);
        List<Integer> mutableIntList = optJSONArray == null ? null : FractionsUtilsKt.toMutableIntList(optJSONArray);
        if (mutableIntList == null) {
            mutableIntList = CollectionsKt.mutableListOf(1, 1);
        }
        updateButtonStatus(mutableIntList);
    }

    private final void updateButtonStatus(List<Integer> list) {
        if (list == null || list.size() != this.buttonsList.size()) {
            return;
        }
        int size = this.buttonsList.size();
        for (int i = 0; i < size; i++) {
            this.buttonsList.get(i).setActive(list.get(i).intValue());
        }
    }

    private final void initPopupWindow() {
        NvEventQueueActivity nvEventQueueActivity = this.mainActivity;
        Object systemService = nvEventQueueActivity == null ? null : nvEventQueueActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        SocialNetworkLinkLayoutBinding inflate = SocialNetworkLinkLayoutBinding.inflate((LayoutInflater) systemService);
        this.binding = inflate;
        if (inflate == null) {
            return;
        }
        this.anim = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        this.popupWindow = new PopupWindow((View) inflate.getRoot(), -1, -1, true);
        NvEventQueueActivity nvEventQueueActivity2 = this.mainActivity;
        if (nvEventQueueActivity2 != null) {
            nvEventQueueActivity2.toggleDrawing2dStuff(true);
        }
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            GUIManager.hideSystemUI(popupWindow.getContentView());
        }
        closeAndroidsButtons();
        ConstraintLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "_binding.root");
        setBackgroundImage(R.drawable.social_network_link_bg_res, root);
        View view = inflate.socialNetworkLinkVipPresentBg;
        Intrinsics.checkNotNullExpressionValue(view, "_binding.socialNetworkLinkVipPresentBg");
        setBackgroundImage(R.drawable.social_network_link_vip_present_item_res, view);
        View view2 = inflate.socialNetworkLinkMoneyPresentBg;
        Intrinsics.checkNotNullExpressionValue(view2, "_binding.socialNetworkLinkMoneyPresentBg");
        setBackgroundImage(R.drawable.social_network_link_money_present_item_res, view2);
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 == null) {
            return;
        }
        NvEventQueueActivity nvEventQueueActivity3 = this.mainActivity;
        popupWindow2.showAtLocation(nvEventQueueActivity3 != null ? nvEventQueueActivity3.getParentLayout() : null, 17, 0, 0);
    }

    private final void closeAndroidsButtons() {
        new Useful().closeAndroidsInterface(this.mainActivity, this.popupWindow);
    }

    private final void setBackgroundImage(int i, View view) {
        Utils.setBackground(this.mainActivity, i, view);
    }

    private final void initButtons() {
        Resources resources;
        Resources resources2;
        List<SocialButtonObj> list = this.buttonsList;
        NvEventQueueActivity nvEventQueueActivity = this.mainActivity;
        CharSequence charSequence = null;
        list.add(new SocialButtonObj(0, String.valueOf((nvEventQueueActivity == null || (resources = nvEventQueueActivity.getResources()) == null) ? null : resources.getText(R.string.social_network_link_button_vk_title)), R.drawable.social_network_link_vk_icon_res, R.drawable.social_network_link_vk_not_active_icon_res, 1));
        NvEventQueueActivity nvEventQueueActivity2 = this.mainActivity;
        if (nvEventQueueActivity2 != null && (resources2 = nvEventQueueActivity2.getResources()) != null) {
            charSequence = resources2.getText(R.string.social_network_link_button_telegram_title);
        }
        list.add(new SocialButtonObj(1, String.valueOf(charSequence), R.drawable.social_network_link_telegram_icon_res, R.drawable.social_network_link_telegram_not_active_icon_res, 1));
    }

    private final void initButtonsView() {
        this.buttonAdapter = new SocialButtonAdapter(this, this.buttonsList, this.actionWithJSON);
        SocialNetworkLinkLayoutBinding socialNetworkLinkLayoutBinding = this.binding;
        if (socialNetworkLinkLayoutBinding == null) {
            return;
        }
        RecyclerView recyclerView = socialNetworkLinkLayoutBinding.socialNetworkLinkButtons;
        recyclerView.setLayoutManager(new LinearLayoutManager(socialNetworkLinkLayoutBinding.getRoot().getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(this.buttonAdapter);
    }

    @Override
    public void close(JSONObject jSONObject) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    @Override
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return false;
        }
        Intrinsics.checkNotNull(popupWindow);
        return popupWindow.isShowing();
    }

    private final void setNullableParameters() {
        this.mainActivity = null;
        this.popupWindow = null;
        this.guiManager = null;
        this.binding = null;
        this.anim = null;
        this.actionWithJSON = null;
        this.buttonAdapter = null;
    }
}
