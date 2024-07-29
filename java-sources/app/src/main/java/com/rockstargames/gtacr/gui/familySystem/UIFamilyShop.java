package com.rockstargames.gtacr.gui.familySystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesShopLayoutBinding;
import blackrussia.online.network.FamilySystemShopObj;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyShopAdapter;
import com.rockstargames.gtacr.common.UILayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u001aH\u0016J\b\u0010&\u001a\u00020\u001aH\u0016J\b\u0010'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0013J\u0018\u0010+\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0013H\u0002J\b\u0010-\u001a\u00020\u001aH\u0002J\u0006\u0010.\u001a\u00020\u001aR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0014\u001a6\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0015j\u0002`\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/UIFamilyShop;", "Lcom/rockstargames/gtacr/common/UILayout;", "mainRoot", "Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "logicForDialogApply", "Lcom/rockstargames/gtacr/gui/familySystem/LogicForDialogApply;", "(Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/familySystem/LogicForDialogApply;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesShopLayoutBinding;", "currentItems", "", "Lblackrussia/online/network/FamilySystemShopObj;", "familyUseful", "Lcom/rockstargames/gtacr/gui/familySystem/FamilyUseful;", "itemsId", "", "onClickItemInShopList", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisItem", "position", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickItemInShopList;", "shopAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyShopAdapter;", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "setDataInView", "setLogicForClickItemInShop", "setStartParameters", "familyStatus", "setVisibleForSyndicateItemAndUncheck", "ifLeader", "uncheckItems", "updateAfterPurchase", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIFamilyShop extends UILayout {
    private Animation anim;
    private FamiliesShopLayoutBinding binding;
    private final NvEventQueueActivity context;
    private final List<FamilySystemShopObj> currentItems;
    private final FamilyUseful familyUseful;
    private int itemsId;
    private final LogicForDialogApply logicForDialogApply;
    private final GUIFamilySystem mainRoot;
    private Function2<? super FamilySystemShopObj, ? super Integer, Unit> onClickItemInShopList;
    private FamilyShopAdapter shopAdapter;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIFamilyShop(GUIFamilySystem mainRoot, NvEventQueueActivity context, LogicForDialogApply logicForDialogApply) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainRoot = mainRoot;
        this.context = context;
        this.logicForDialogApply = logicForDialogApply;
        this.familyUseful = new FamilyUseful(context);
        this.currentItems = new ArrayList();
        this.itemsId = -1;
    }

    public final void setStartParameters(int i) {
        this.itemsId = -1;
        uncheckItems();
        setDataInView();
        setVisibleForSyndicateItemAndUncheck(i, this.mainRoot.getIfLeader());
    }

    @Override
    public View getView() {
        FamiliesShopLayoutBinding familiesShopLayoutBinding = this.binding;
        if (familiesShopLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesShopLayoutBinding = null;
        }
        ConstraintLayout root = familiesShopLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FamiliesShopLayoutBinding inflate = FamiliesShopLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        FamiliesShopLayoutBinding familiesShopLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        List<FamilySystemShopObj> list = this.currentItems;
        list.clear();
        list.addAll(App.getInstance().getFamilySystemList().getShopList());
        setLogicForClickItemInShop();
        FamiliesShopLayoutBinding familiesShopLayoutBinding2 = this.binding;
        if (familiesShopLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesShopLayoutBinding = familiesShopLayoutBinding2;
        }
        ConstraintLayout root = familiesShopLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setLogicForClickItemInShop() {
        this.onClickItemInShopList = new Function2<FamilySystemShopObj, Integer, Unit>() {
            @Override
            public Unit invoke(FamilySystemShopObj familySystemShopObj, Integer num) {
                invoke(familySystemShopObj, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(FamilySystemShopObj thisItem, int i) {
                int i2;
                LogicForDialogApply logicForDialogApply;
                FamilyShopAdapter familyShopAdapter;
                Intrinsics.checkNotNullParameter(thisItem, "thisItem");
                i2 = UIFamilyShop.this.itemsId;
                if (i2 == thisItem.getId()) {
                    logicForDialogApply = UIFamilyShop.this.logicForDialogApply;
                    if (logicForDialogApply == null) {
                        return;
                    }
                    logicForDialogApply.showDialog(thisItem, null, null, null);
                    return;
                }
                thisItem.setClicked(true);
                familyShopAdapter = UIFamilyShop.this.shopAdapter;
                if (familyShopAdapter != null) {
                    familyShopAdapter.notifyItemChanged(i);
                    familyShopAdapter.setCheckOnlyElement(i);
                }
                UIFamilyShop.this.itemsId = thisItem.getId();
            }
        };
    }

    private final void setDataInView() {
        List<FamilySystemShopObj> list = this.currentItems;
        Function2<? super FamilySystemShopObj, ? super Integer, Unit> function2 = this.onClickItemInShopList;
        FamiliesShopLayoutBinding familiesShopLayoutBinding = null;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onClickItemInShopList");
            function2 = null;
        }
        this.shopAdapter = new FamilyShopAdapter(list, function2, this.familyUseful, this.context);
        FamiliesShopLayoutBinding familiesShopLayoutBinding2 = this.binding;
        if (familiesShopLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesShopLayoutBinding2 = null;
        }
        RecyclerView recyclerView = familiesShopLayoutBinding2.marketList;
        FamiliesShopLayoutBinding familiesShopLayoutBinding3 = this.binding;
        if (familiesShopLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesShopLayoutBinding = familiesShopLayoutBinding3;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(familiesShopLayoutBinding.getRoot().getContext(), 3));
        recyclerView.setAdapter(this.shopAdapter);
    }

    private final void uncheckItems() {
        for (FamilySystemShopObj familySystemShopObj : this.currentItems) {
            if (familySystemShopObj.isClicked()) {
                familySystemShopObj.setClicked(false);
            }
        }
    }

    private final void setVisibleForSyndicateItemAndUncheck(int i, int i2) {
        if (i == 1 || i2 == 0) {
            int i3 = 0;
            int size = this.currentItems.size();
            while (i3 < size) {
                int i4 = i3 + 1;
                if (this.currentItems.get(i3).getTypeId() == 4) {
                    this.currentItems.remove(i3);
                    FamilyShopAdapter familyShopAdapter = this.shopAdapter;
                    if (familyShopAdapter != null) {
                        familyShopAdapter.notifyItemRemoved(i3);
                    }
                }
                i3 = i4;
            }
        }
    }

    public final void updateAfterPurchase() {
        if (this.itemsId == 8) {
            this.mainRoot.setFamilyStatus(1);
            setVisibleForSyndicateItemAndUncheck(1, this.mainRoot.getIfLeader());
            this.itemsId = -1;
        }
    }
}
