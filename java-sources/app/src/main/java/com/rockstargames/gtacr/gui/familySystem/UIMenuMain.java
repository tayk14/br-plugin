package com.rockstargames.gtacr.gui.familySystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesMenuMainLayoutBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyMenuMainAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.FamilyMainItemData;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.inventory.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0016J\u001a\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u001fH\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\b\u0010*\u001a\u00020\u001fH\u0002J\b\u0010+\u001a\u00020\u001fH\u0002J@\u0010,\u001a\u00020\u001f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000RW\u0010\u0016\u001aK\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u0017j\u0002` X\u0082.¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/UIMenuMain;", "Lcom/rockstargames/gtacr/common/UILayout;", "mainRoot", "Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;", "logicForDialogApply", "Lcom/rockstargames/gtacr/gui/familySystem/LogicForDialogApply;", "(Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;Lcom/rockstargames/gtacr/gui/familySystem/LogicForDialogApply;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesMenuMainLayoutBinding;", "menuAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyMenuMainAdapter;", "menuList", "", "Lcom/rockstargames/gtacr/data/FamilyMainItemData;", "oldTimer", "", "onClickMenuMainList", "Lkotlin/Function3;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "", "position", "Landroid/view/View;", "mView", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickMenuMainList;", "addItemsInMenu", "getView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "setDataInView", "setLogicForMenuClick", "setStartParameters", "upgrades", "repPeopleSkin", "otherState", "playersNickValue", "", "playersIdValue", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIMenuMain extends UILayout {
    private final ActionsWithJSON actionsWithJSON;
    private Animation anim;
    private FamiliesMenuMainLayoutBinding binding;
    private final NvEventQueueActivity context;
    private final LogicForDialogApply logicForDialogApply;
    private final GUIFamilySystem mainRoot;
    private FamilyMenuMainAdapter menuAdapter;
    private final List<FamilyMainItemData> menuList;
    private long oldTimer;
    private Function3<? super FamilyMainItemData, ? super Integer, ? super View, Unit> onClickMenuMainList;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIMenuMain(GUIFamilySystem mainRoot, NvEventQueueActivity context, ActionsWithJSON actionsWithJSON, LogicForDialogApply logicForDialogApply) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.mainRoot = mainRoot;
        this.context = context;
        this.actionsWithJSON = actionsWithJSON;
        this.logicForDialogApply = logicForDialogApply;
        this.menuList = new ArrayList();
    }

    public final void setStartParameters(List<Integer> upgrades, List<Integer> repPeopleSkin, List<Integer> otherState, String playersNickValue, int i) {
        CharSequence text;
        Intrinsics.checkNotNullParameter(upgrades, "upgrades");
        Intrinsics.checkNotNullParameter(repPeopleSkin, "repPeopleSkin");
        Intrinsics.checkNotNullParameter(otherState, "otherState");
        Intrinsics.checkNotNullParameter(playersNickValue, "playersNickValue");
        this.oldTimer = 0L;
        if (upgrades.size() == 6 && repPeopleSkin.size() == 3 && otherState.size() == 12) {
            FamiliesMenuMainLayoutBinding familiesMenuMainLayoutBinding = this.binding;
            if (familiesMenuMainLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                familiesMenuMainLayoutBinding = null;
            }
            TextView textView = familiesMenuMainLayoutBinding.familyStatusValue;
            if (this.mainRoot.getFamilyStatus() == 0) {
                text = this.context.getText(R.string.families_menu_main_layout_brigade_status);
            } else {
                text = this.context.getText(R.string.families_menu_main_layout_syndicate_status);
            }
            textView.setText(text);
            familiesMenuMainLayoutBinding.reputationsValue.setText(String.valueOf(repPeopleSkin.get(0).intValue()));
            familiesMenuMainLayoutBinding.peopleValue.setText(String.valueOf(repPeopleSkin.get(1).intValue()));
            familiesMenuMainLayoutBinding.upgradeStorageValue.setText(this.context.getString(R.string.families_upgrade_storage, new Object[]{String.valueOf(upgrades.get(0).intValue()), String.valueOf(upgrades.get(1).intValue())}));
            familiesMenuMainLayoutBinding.upgradeWeaponValue.setText(this.context.getString(R.string.families_upgrade_weapon, new Object[]{String.valueOf(upgrades.get(2).intValue()), String.valueOf(upgrades.get(3).intValue())}));
            familiesMenuMainLayoutBinding.upgradePeopleValue.setText(this.context.getString(R.string.families_upgrade_people, new Object[]{String.valueOf(upgrades.get(4).intValue()), String.valueOf(upgrades.get(5).intValue())}));
            familiesMenuMainLayoutBinding.moneyValue.setText(this.context.getString(R.string.families_info_money, new Object[]{String.valueOf(otherState.get(0).intValue()), String.valueOf(otherState.get(1).intValue())}));
            familiesMenuMainLayoutBinding.materialsValue.setText(this.context.getString(R.string.families_info_materials, new Object[]{String.valueOf(otherState.get(2).intValue()), String.valueOf(otherState.get(3).intValue())}));
            familiesMenuMainLayoutBinding.masksValue.setText(this.context.getString(R.string.families_info_masks, new Object[]{String.valueOf(otherState.get(4).intValue()), String.valueOf(otherState.get(5).intValue())}));
            familiesMenuMainLayoutBinding.oilsValue.setText(this.context.getString(R.string.families_info_oils, new Object[]{String.valueOf(otherState.get(6).intValue()), String.valueOf(otherState.get(7).intValue())}));
            familiesMenuMainLayoutBinding.armorValue.setText(this.context.getString(R.string.families_info_armor, new Object[]{String.valueOf(otherState.get(8).intValue()), String.valueOf(otherState.get(9).intValue())}));
            familiesMenuMainLayoutBinding.ammunitionValue.setText(this.context.getString(R.string.families_info_ammunition, new Object[]{String.valueOf(otherState.get(10).intValue()), String.valueOf(otherState.get(11).intValue())}));
            familiesMenuMainLayoutBinding.playersNick.setText(this.context.getString(R.string.families_menu_main_layout_players_nick_and_id, new Object[]{playersNickValue, Integer.valueOf(i)}));
            Useful useful = new Useful();
            NvEventQueueActivity nvEventQueueActivity = this.context;
            int intValue = repPeopleSkin.get(2).intValue();
            FrameLayout familySkin = familiesMenuMainLayoutBinding.familySkin;
            Intrinsics.checkNotNullExpressionValue(familySkin, "familySkin");
            useful.renderSkin(nvEventQueueActivity, 2, Constants.ID_SKIN, intValue, 1, familySkin);
        }
    }

    @Override
    public View getView() {
        FamiliesMenuMainLayoutBinding familiesMenuMainLayoutBinding = this.binding;
        if (familiesMenuMainLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuMainLayoutBinding = null;
        }
        ConstraintLayout root = familiesMenuMainLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FamiliesMenuMainLayoutBinding inflate = FamiliesMenuMainLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        FamiliesMenuMainLayoutBinding familiesMenuMainLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        addItemsInMenu();
        setLogicForMenuClick();
        setDataInView();
        FamiliesMenuMainLayoutBinding familiesMenuMainLayoutBinding2 = this.binding;
        if (familiesMenuMainLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuMainLayoutBinding2 = null;
        }
        familiesMenuMainLayoutBinding2.familyStatusValue.setSelected(true);
        familiesMenuMainLayoutBinding2.playersNick.setSelected(true);
        familiesMenuMainLayoutBinding2.peopleValue.setSelected(true);
        familiesMenuMainLayoutBinding2.upgradeStorageValue.setSelected(true);
        familiesMenuMainLayoutBinding2.upgradeWeaponValue.setSelected(true);
        familiesMenuMainLayoutBinding2.upgradePeopleValue.setSelected(true);
        familiesMenuMainLayoutBinding2.moneyValue.setSelected(true);
        familiesMenuMainLayoutBinding2.materialsValue.setSelected(true);
        familiesMenuMainLayoutBinding2.masksValue.setSelected(true);
        familiesMenuMainLayoutBinding2.oilsValue.setSelected(true);
        familiesMenuMainLayoutBinding2.armorValue.setSelected(true);
        familiesMenuMainLayoutBinding2.ammunitionValue.setSelected(true);
        FamiliesMenuMainLayoutBinding familiesMenuMainLayoutBinding3 = this.binding;
        if (familiesMenuMainLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesMenuMainLayoutBinding = familiesMenuMainLayoutBinding3;
        }
        ConstraintLayout root = familiesMenuMainLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void addItemsInMenu() {
        List<FamilyMainItemData> list = this.menuList;
        list.clear();
        list.add(new FamilyMainItemData(1, "Настройка семьи", false, 4, null));
        list.add(new FamilyMainItemData(2, "Управление семьей", false, 4, null));
        list.add(new FamilyMainItemData(3, "Склад", false, 4, null));
        list.add(new FamilyMainItemData(7, "Улучшения", false, 4, null));
        list.add(new FamilyMainItemData(6, "Автопарк", false, 4, null));
        list.add(new FamilyMainItemData(4, "Семейные логи", false, 4, null));
        list.add(new FamilyMainItemData(5, "Черный список", false, 4, null));
        list.add(new FamilyMainItemData(8, "Покинуть семью", false, 4, null));
    }

    private final void setLogicForMenuClick() {
        this.onClickMenuMainList = new Function3<FamilyMainItemData, Integer, View, Unit>() {
            @Override
            public Unit invoke(FamilyMainItemData familyMainItemData, Integer num, View view) {
                invoke(familyMainItemData, num.intValue(), view);
                return Unit.INSTANCE;
            }

            public void invoke(FamilyMainItemData item, int i, View mView) {
                long j;
                GUIFamilySystem gUIFamilySystem;
                ActionsWithJSON actionsWithJSON;
                GUIFamilySystem gUIFamilySystem2;
                ActionsWithJSON actionsWithJSON2;
                GUIFamilySystem gUIFamilySystem3;
                LogicForDialogApply logicForDialogApply;
                ActionsWithJSON actionsWithJSON3;
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(mView, "mView");
                long currentTimeMillis = System.currentTimeMillis();
                j = UIMenuMain.this.oldTimer;
                if (currentTimeMillis - j > 2000) {
                    UIMenuMain.this.oldTimer = System.currentTimeMillis();
                    int itemsId = item.getItemsId();
                    if (itemsId == 3) {
                        gUIFamilySystem = UIMenuMain.this.mainRoot;
                        gUIFamilySystem.listenerLayout(11);
                    } else if (itemsId == 6) {
                        actionsWithJSON = UIMenuMain.this.actionsWithJSON;
                        actionsWithJSON.sendGetLayout(2);
                        gUIFamilySystem2 = UIMenuMain.this.mainRoot;
                        gUIFamilySystem2.setIfFromMainMenuForCarPark(false);
                    } else if (itemsId == 7) {
                        actionsWithJSON2 = UIMenuMain.this.actionsWithJSON;
                        actionsWithJSON2.sendGetLayout(4);
                        gUIFamilySystem3 = UIMenuMain.this.mainRoot;
                        gUIFamilySystem3.setIfFromMainMenuForUpgrade(false);
                    } else if (itemsId != 8) {
                        actionsWithJSON3 = UIMenuMain.this.actionsWithJSON;
                        actionsWithJSON3.setMenuPosition(item.getItemsId());
                    } else {
                        logicForDialogApply = UIMenuMain.this.logicForDialogApply;
                        if (logicForDialogApply == null) {
                            return;
                        }
                        logicForDialogApply.showDialog(null, null, true, null);
                    }
                }
            }
        };
    }

    private final void setDataInView() {
        List<FamilyMainItemData> list = this.menuList;
        Function3<? super FamilyMainItemData, ? super Integer, ? super View, Unit> function3 = this.onClickMenuMainList;
        FamilyMenuMainAdapter familyMenuMainAdapter = null;
        if (function3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onClickMenuMainList");
            function3 = null;
        }
        this.menuAdapter = new FamilyMenuMainAdapter(list, function3, this.context);
        FamiliesMenuMainLayoutBinding familiesMenuMainLayoutBinding = this.binding;
        if (familiesMenuMainLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuMainLayoutBinding = null;
        }
        RecyclerView recyclerView = familiesMenuMainLayoutBinding.menuList;
        FamiliesMenuMainLayoutBinding familiesMenuMainLayoutBinding2 = this.binding;
        if (familiesMenuMainLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuMainLayoutBinding2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesMenuMainLayoutBinding2.getRoot().getContext(), 1, false));
        FamilyMenuMainAdapter familyMenuMainAdapter2 = this.menuAdapter;
        if (familyMenuMainAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuAdapter");
        } else {
            familyMenuMainAdapter = familyMenuMainAdapter2;
        }
        recyclerView.setAdapter(familyMenuMainAdapter);
    }
}
