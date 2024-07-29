package com.rockstargames.gtacr.gui.familySystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesUpgradesLayoutBinding;
import blackrussia.online.network.FamilySystemUpgradeObj;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.kingfisher.easyviewindicator.AnyViewIndicator;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyUpgradeAdapter;
import com.rockstargames.gtacr.adapters.FamilyUpgradeParentItemAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.FamilyUpgradeData;
import com.rockstargames.gtacr.data.FamilyUpgradeValueData;
import com.rockstargames.gtacr.gui.Useful;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ,\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\u001b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020)0\u001b2\u0006\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0013H\u0002J\u0010\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u0013H\u0002J&\u00102\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u00132\f\u0010-\u001a\b\u0012\u0004\u0012\u00020'03H\u0002J\b\u00104\u001a\u000205H\u0016J\u001a\u00106\u001a\u0002052\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\u0015H\u0016J\b\u0010<\u001a\u00020\u0015H\u0016J\u0018\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0013H\u0002J\u0018\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u0013H\u0002J\u0018\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020\u0013H\u0002J\b\u0010F\u001a\u00020\u0015H\u0002J\u001c\u0010G\u001a\u00020\u00152\u0006\u0010H\u001a\u00020\u00132\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bJ\b\u0010J\u001a\u00020\u0015H\u0002J\b\u0010K\u001a\u00020\u0015H\u0002J\b\u0010L\u001a\u00020\u0015H\u0002J\u0018\u0010M\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0013H\u0002J\u000e\u0010N\u001a\u00020\u00152\u0006\u0010O\u001a\u00020PJ\u0010\u0010Q\u001a\u00020\u00152\u0006\u0010R\u001a\u00020\u0013H\u0002J\u0010\u0010S\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u000e\u0010T\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u0013J\u0010\u0010U\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0006\u0010V\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000RF\u0010\r\u001a:\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000ej\u0004\u0018\u0001`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/UIMenuFamilyUpgrade;", "Lcom/rockstargames/gtacr/common/UILayout;", "activity", "Lcom/nvidia/devtech/NvEventQueueActivity;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;", "logicForDialogApply", "Lcom/rockstargames/gtacr/gui/familySystem/LogicForDialogApply;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;Lcom/rockstargames/gtacr/gui/familySystem/LogicForDialogApply;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesUpgradesLayoutBinding;", "clickUpdateItem", "Lkotlin/Function2;", "Lcom/rockstargames/gtacr/data/FamilyUpgradeData;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "updateItem", "", "position", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickUpdateItem;", "currentUpgradeId", "familyUpgradeParentItemAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyUpgradeParentItemAdapter;", "levels", "", "maxFamilyLevel", "maxMoney", "maxStoreLevel", "maxWeaponsLevel", "oldMoney", "oldTimerForClickOnUpgrade", "", "thisPrice", "upgradeAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyUpgradeAdapter;", "upgradeAllListFromApp", "Lblackrussia/online/network/FamilySystemUpgradeObj;", "upgradeCurrentValueList", "Lcom/rockstargames/gtacr/data/FamilyUpgradeValueData;", "upgradeList", "upgradeNewValueList", "actionWithCollection", "currentCollection", "currentId", "currentLevel", "clearInfoAboutUpgrade", "setVisible", "getMaxMoney", "", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "setCurrentData", "description", "", "value", "setCurrentMoney", "getCurrentMoney", "setCurrentUpgradePrice", "thisId", "thisLevel", "setLogicForClickUpdateItem", "setStartData", "currentMoneyOnStore", "currentUpgrades", "setUpdateDataList", "setUpgradeData", "setUpgradeDataInView", "setUpgradeLevels", "setVisibleButtonBackToMenu", "ifFromMainMenu", "", "setVisibleButtonUpgrade", "getPrice", "updateDataForUpgrade", "updateState", "updateTitleForRightBlock", "upgradeFamily", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIMenuFamilyUpgrade extends UILayout {
    private final ActionsWithJSON actionsWithJSON;
    private final NvEventQueueActivity activity;
    private Animation anim;
    private FamiliesUpgradesLayoutBinding binding;
    private Function2<? super FamilyUpgradeData, ? super Integer, Unit> clickUpdateItem;
    private int currentUpgradeId;
    private FamilyUpgradeParentItemAdapter familyUpgradeParentItemAdapter;
    private final List<Integer> levels;
    private final LogicForDialogApply logicForDialogApply;
    private int maxFamilyLevel;
    private int maxMoney;
    private int maxStoreLevel;
    private int maxWeaponsLevel;
    private int oldMoney;
    private long oldTimerForClickOnUpgrade;
    private int thisPrice;
    private FamilyUpgradeAdapter upgradeAdapter;
    private final List<FamilySystemUpgradeObj> upgradeAllListFromApp;
    private final List<FamilyUpgradeValueData> upgradeCurrentValueList;
    private final List<FamilyUpgradeData> upgradeList;
    private final List<FamilyUpgradeValueData> upgradeNewValueList;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIMenuFamilyUpgrade(NvEventQueueActivity activity, ActionsWithJSON actionsWithJSON, LogicForDialogApply logicForDialogApply) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.activity = activity;
        this.actionsWithJSON = actionsWithJSON;
        this.logicForDialogApply = logicForDialogApply;
        this.upgradeList = new ArrayList();
        this.currentUpgradeId = -1;
        this.oldMoney = -1;
        this.maxMoney = -1;
        this.upgradeAllListFromApp = new ArrayList();
        this.upgradeCurrentValueList = new ArrayList();
        this.upgradeNewValueList = new ArrayList();
        this.levels = new ArrayList();
    }

    public final void setVisibleButtonBackToMenu(boolean z) {
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding = this.binding;
        if (familiesUpgradesLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesUpgradesLayoutBinding = null;
        }
        familiesUpgradesLayoutBinding.buttonBackToMenu.setVisibility(z ? 4 : 0);
    }

    public final void setStartData(int i, List<Integer> currentUpgrades) {
        Intrinsics.checkNotNullParameter(currentUpgrades, "currentUpgrades");
        this.currentUpgradeId = -1;
        this.thisPrice = 0;
        this.oldMoney = i;
        if (this.upgradeList.size() > 0 && this.upgradeList.size() == currentUpgrades.size()) {
            int size = this.upgradeList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                FamilyUpgradeData familyUpgradeData = this.upgradeList.get(i2);
                familyUpgradeData.setClicked(false);
                familyUpgradeData.setUpgradeCurrentLevel(currentUpgrades.get(i2).intValue());
                if (i2 == 0) {
                    this.maxMoney = getMaxMoney(familyUpgradeData.getUpgradeId(), familyUpgradeData.getUpgradeCurrentLevel(), this.upgradeAllListFromApp);
                }
                FamilyUpgradeAdapter familyUpgradeAdapter = this.upgradeAdapter;
                if (familyUpgradeAdapter != null) {
                    familyUpgradeAdapter.notifyItemChanged(i2);
                }
                i2 = i3;
            }
        }
        setCurrentMoney(this.oldMoney, this.maxMoney);
        clearInfoAboutUpgrade(4);
    }

    private final void setCurrentMoney(int i, int i2) {
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding = this.binding;
        if (familiesUpgradesLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesUpgradesLayoutBinding = null;
        }
        TextView textView = familiesUpgradesLayoutBinding.moneyOnStoreValue;
        textView.setText(this.activity.getString(R.string.families_info_money, new Object[]{new Useful().getPriceWithSpacesForInt(i), new Useful().getPriceWithSpacesForInt(i2)}));
        textView.setSelected(true);
    }

    private final int getMaxMoney(int i, int i2, List<FamilySystemUpgradeObj> list) {
        for (FamilySystemUpgradeObj familySystemUpgradeObj : list) {
            if (familySystemUpgradeObj.getId() == i && familySystemUpgradeObj.getLevel() == i2) {
                return familySystemUpgradeObj.getMoney();
            }
        }
        return 0;
    }

    public final void updateState(int i) {
        int size = this.upgradeList.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (this.upgradeList.get(i2).getUpgradeId() == i) {
                FamilyUpgradeData familyUpgradeData = this.upgradeList.get(i2);
                familyUpgradeData.setUpgradeCurrentLevel(familyUpgradeData.getUpgradeCurrentLevel() + 1);
                FamilyUpgradeAdapter familyUpgradeAdapter = this.upgradeAdapter;
                if (familyUpgradeAdapter != null) {
                    familyUpgradeAdapter.notifyItemChanged(i2);
                }
                this.oldMoney -= this.thisPrice;
                if (i == 0) {
                    this.maxMoney = getMaxMoney(i, this.upgradeList.get(i2).getUpgradeCurrentLevel(), this.upgradeAllListFromApp);
                }
                setCurrentMoney(this.oldMoney, this.maxMoney);
                updateDataForUpgrade(this.upgradeList.get(i2));
                return;
            }
            i2 = i3;
        }
    }

    @Override
    public View getView() {
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding = this.binding;
        if (familiesUpgradesLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesUpgradesLayoutBinding = null;
        }
        ConstraintLayout root = familiesUpgradesLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FamiliesUpgradesLayoutBinding inflate = FamiliesUpgradesLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        List<FamilySystemUpgradeObj> list = this.upgradeAllListFromApp;
        list.clear();
        list.addAll(App.getInstance().getFamilySystemList().getUpgradeList());
        setLogicForClickUpdateItem();
        setUpgradeData();
        setUpgradeDataInView();
        setUpdateDataList();
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding2 = this.binding;
        if (familiesUpgradesLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesUpgradesLayoutBinding2 = null;
        }
        familiesUpgradesLayoutBinding2.buttonUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMenuFamilyUpgrade.m226onCreateView$lambda4(UIMenuFamilyUpgrade.this, view);
            }
        });
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding3 = this.binding;
        if (familiesUpgradesLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesUpgradesLayoutBinding3 = null;
        }
        familiesUpgradesLayoutBinding3.buttonBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMenuFamilyUpgrade.m227onCreateView$lambda5(UIMenuFamilyUpgrade.this, view);
            }
        });
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding4 = this.binding;
        if (familiesUpgradesLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesUpgradesLayoutBinding = familiesUpgradesLayoutBinding4;
        }
        ConstraintLayout root = familiesUpgradesLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public static final void m226onCreateView$lambda4(UIMenuFamilyUpgrade this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!(view.getAlpha() == 1.0f) || this$0.currentUpgradeId == -1 || System.currentTimeMillis() - this$0.oldTimerForClickOnUpgrade <= 1000) {
            return;
        }
        this$0.oldTimerForClickOnUpgrade = System.currentTimeMillis();
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        LogicForDialogApply logicForDialogApply = this$0.logicForDialogApply;
        if (logicForDialogApply == null) {
            return;
        }
        logicForDialogApply.showDialog(null, Integer.valueOf(this$0.thisPrice), null, null);
    }

    public static final void m227onCreateView$lambda5(UIMenuFamilyUpgrade this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actionsWithJSON.sendGetLayout(5);
    }

    public final void upgradeFamily() {
        int i = this.currentUpgradeId;
        if (i != -1) {
            this.actionsWithJSON.setUpgradeForFamily(i);
        }
    }

    private final void setLogicForClickUpdateItem() {
        this.clickUpdateItem = new Function2<FamilyUpgradeData, Integer, Unit>() {
            @Override
            public Unit invoke(FamilyUpgradeData familyUpgradeData, Integer num) {
                invoke(familyUpgradeData, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(FamilyUpgradeData updateItem, int i) {
                long j;
                FamilyUpgradeAdapter familyUpgradeAdapter;
                Intrinsics.checkNotNullParameter(updateItem, "updateItem");
                long currentTimeMillis = System.currentTimeMillis();
                j = UIMenuFamilyUpgrade.this.oldTimerForClickOnUpgrade;
                if (currentTimeMillis - j > 1000) {
                    UIMenuFamilyUpgrade.this.oldTimerForClickOnUpgrade = System.currentTimeMillis();
                    updateItem.setClicked(true);
                    familyUpgradeAdapter = UIMenuFamilyUpgrade.this.upgradeAdapter;
                    if (familyUpgradeAdapter != null) {
                        familyUpgradeAdapter.notifyItemChanged(i);
                        familyUpgradeAdapter.setCheckOnlyElement(i);
                    }
                    UIMenuFamilyUpgrade.this.updateTitleForRightBlock(updateItem);
                    UIMenuFamilyUpgrade.this.currentUpgradeId = updateItem.getUpgradeId();
                    UIMenuFamilyUpgrade.this.clearInfoAboutUpgrade(0);
                    UIMenuFamilyUpgrade.this.updateDataForUpgrade(updateItem);
                }
            }
        };
    }

    public final void updateDataForUpgrade(FamilyUpgradeData familyUpgradeData) {
        setCurrentUpgradePrice(familyUpgradeData.getUpgradeId(), familyUpgradeData.getUpgradeCurrentLevel());
        setUpgradeLevels(familyUpgradeData.getUpgradeId(), familyUpgradeData.getUpgradeCurrentLevel());
        setUpdateDataList();
        setVisibleButtonUpgrade(this.thisPrice);
    }

    public final void updateTitleForRightBlock(FamilyUpgradeData familyUpgradeData) {
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding = this.binding;
        if (familiesUpgradesLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesUpgradesLayoutBinding = null;
        }
        familiesUpgradesLayoutBinding.upgradeTitle.setText(familyUpgradeData.getUpgradeDescription());
    }

    private final void setUpgradeDataInView() {
        this.upgradeAdapter = new FamilyUpgradeAdapter(this.upgradeList, this.clickUpdateItem, this.activity);
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding = this.binding;
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding2 = null;
        if (familiesUpgradesLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesUpgradesLayoutBinding = null;
        }
        RecyclerView recyclerView = familiesUpgradesLayoutBinding.upgradeList;
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding3 = this.binding;
        if (familiesUpgradesLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesUpgradesLayoutBinding2 = familiesUpgradesLayoutBinding3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesUpgradesLayoutBinding2.getRoot().getContext(), 1, false));
        recyclerView.setAdapter(this.upgradeAdapter);
    }

    private final void setUpgradeData() {
        this.maxStoreLevel = 0;
        this.maxWeaponsLevel = 0;
        this.maxFamilyLevel = 0;
        for (FamilySystemUpgradeObj familySystemUpgradeObj : this.upgradeAllListFromApp) {
            int id = familySystemUpgradeObj.getId();
            if (id == 0) {
                this.maxStoreLevel++;
            } else if (id == 1) {
                this.maxWeaponsLevel++;
            } else if (id == 2) {
                this.maxFamilyLevel++;
            }
        }
        List<FamilyUpgradeData> list = this.upgradeList;
        list.clear();
        list.add(new FamilyUpgradeData(0, "Улучшить склад", "Склад", 0, this.maxStoreLevel, false, 32, null));
        list.add(new FamilyUpgradeData(1, "Улучшить оружейный склад", "Оружейный склад", 0, this.maxWeaponsLevel, false, 32, null));
        list.add(new FamilyUpgradeData(2, "Улучшить кол-во членов семьи", "Число участников", 0, this.maxFamilyLevel, false, 32, null));
    }

    public final void clearInfoAboutUpgrade(int i) {
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding = this.binding;
        if (familiesUpgradesLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesUpgradesLayoutBinding = null;
        }
        familiesUpgradesLayoutBinding.bodyUpgradeInfoNewLayout.setVisibility(i);
        familiesUpgradesLayoutBinding.buttonUpgrade.setVisibility(i);
    }

    private final void setVisibleButtonUpgrade(int i) {
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding = this.binding;
        if (familiesUpgradesLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesUpgradesLayoutBinding = null;
        }
        if (i == 0) {
            familiesUpgradesLayoutBinding.buttonUpgrade.setAlpha(0.5f);
        } else {
            familiesUpgradesLayoutBinding.buttonUpgrade.setAlpha(1.0f);
        }
    }

    private final void setCurrentUpgradePrice(int i, int i2) {
        if (i != 0) {
            if (i == 1) {
                if (i2 == this.maxWeaponsLevel) {
                    this.thisPrice = 0;
                }
            } else if (i == 2 && i2 == this.maxFamilyLevel) {
                this.thisPrice = 0;
            }
        } else if (i2 == this.maxStoreLevel) {
            this.thisPrice = 0;
        }
        int i3 = i2 + 1;
        for (FamilySystemUpgradeObj familySystemUpgradeObj : this.upgradeAllListFromApp) {
            if (familySystemUpgradeObj.getId() == i && familySystemUpgradeObj.getLevel() == i3) {
                this.thisPrice = familySystemUpgradeObj.getPrice();
                return;
            }
        }
    }

    private final void setUpgradeLevels(int i, int i2) {
        actionWithCollection(this.upgradeCurrentValueList, i, i2);
        int i3 = i2 + 1;
        actionWithCollection(this.upgradeNewValueList, i, i3);
        List<Integer> list = this.levels;
        list.clear();
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding = null;
        if (this.upgradeNewValueList.size() != 0) {
            list.add(Integer.valueOf(i2));
            list.add(Integer.valueOf(i3));
            FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding2 = this.binding;
            if (familiesUpgradesLayoutBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                familiesUpgradesLayoutBinding = familiesUpgradesLayoutBinding2;
            }
            familiesUpgradesLayoutBinding.viewDotIndicator.setVisibility(0);
            return;
        }
        list.add(Integer.valueOf(i2));
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding3 = this.binding;
        if (familiesUpgradesLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesUpgradesLayoutBinding = familiesUpgradesLayoutBinding3;
        }
        familiesUpgradesLayoutBinding.viewDotIndicator.setVisibility(8);
    }

    private final List<FamilyUpgradeValueData> actionWithCollection(List<FamilyUpgradeValueData> list, int i, int i2) {
        list.clear();
        for (FamilySystemUpgradeObj familySystemUpgradeObj : this.upgradeAllListFromApp) {
            if (i == familySystemUpgradeObj.getId() && i2 == familySystemUpgradeObj.getLevel()) {
                if (familySystemUpgradeObj.getMoney() != 0) {
                    list.add(setCurrentData("money", familySystemUpgradeObj.getMoney()));
                }
                if (familySystemUpgradeObj.getMaterials() != 0) {
                    list.add(setCurrentData("materials", familySystemUpgradeObj.getMaterials()));
                }
                if (familySystemUpgradeObj.getMasks() != 0) {
                    list.add(setCurrentData("masks", familySystemUpgradeObj.getMasks()));
                }
                if (familySystemUpgradeObj.getGasoline() != 0) {
                    list.add(setCurrentData("gasoline", familySystemUpgradeObj.getGasoline()));
                }
                if (familySystemUpgradeObj.getArmour() != 0) {
                    list.add(setCurrentData("armour", familySystemUpgradeObj.getArmour()));
                }
                if (familySystemUpgradeObj.getPeople() != 0) {
                    list.add(setCurrentData("people", familySystemUpgradeObj.getPeople()));
                }
                if (familySystemUpgradeObj.getAmmo() != 0) {
                    list.add(setCurrentData("ammo", familySystemUpgradeObj.getAmmo()));
                }
            }
        }
        return list;
    }

    private final FamilyUpgradeValueData setCurrentData(String str, int i) {
        return new FamilyUpgradeValueData(str, i);
    }

    private final void setUpdateDataList() {
        this.familyUpgradeParentItemAdapter = new FamilyUpgradeParentItemAdapter(this.levels, this.upgradeCurrentValueList, this.upgradeNewValueList, this.activity);
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding = this.binding;
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding2 = null;
        if (familiesUpgradesLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesUpgradesLayoutBinding = null;
        }
        RecyclerView recyclerView = familiesUpgradesLayoutBinding.allUpgradeParameters;
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding3 = this.binding;
        if (familiesUpgradesLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesUpgradesLayoutBinding3 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesUpgradesLayoutBinding3.getRoot().getContext(), 0, false));
        recyclerView.setAdapter(this.familyUpgradeParentItemAdapter);
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding4 = this.binding;
        if (familiesUpgradesLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesUpgradesLayoutBinding4 = null;
        }
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding5 = this.binding;
        if (familiesUpgradesLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesUpgradesLayoutBinding5 = null;
        }
        AnyViewIndicator anyViewIndicator = familiesUpgradesLayoutBinding5.viewDotIndicator;
        anyViewIndicator.setItemCount(2);
        anyViewIndicator.setCurrentPosition(0);
        FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding6 = this.binding;
        if (familiesUpgradesLayoutBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesUpgradesLayoutBinding2 = familiesUpgradesLayoutBinding6;
        }
        familiesUpgradesLayoutBinding2.allUpgradeParameters.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                FamiliesUpgradesLayoutBinding familiesUpgradesLayoutBinding7;
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrollStateChanged(recyclerView2, i);
                if (i == 0) {
                    RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                    Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                    familiesUpgradesLayoutBinding7 = UIMenuFamilyUpgrade.this.binding;
                    if (familiesUpgradesLayoutBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        familiesUpgradesLayoutBinding7 = null;
                    }
                    familiesUpgradesLayoutBinding7.viewDotIndicator.setCurrentPosition(findFirstVisibleItemPosition);
                }
            }
        });
    }
}
