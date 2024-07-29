package com.rockstargames.gtacr.gui.familySystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesMenuTheStoreOrTheSafeLayoutBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyMenuMainAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.FamilyMainItemData;
import com.rockstargames.gtacr.gui.Useful;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\u001a\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u001cH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J\u0016\u0010(\u001a\u00020\u001c2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\u0014\u0010+\u001a\u00020\u001c2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u0010J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\fH\u0002J\u0014\u00101\u001a\u00020\u001c2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\f0\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R[\u0010\u0014\u001aO\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0015j\u0004\u0018\u0001`\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/UIMenuFamilyStore;", "Lcom/rockstargames/gtacr/common/UILayout;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesMenuTheStoreOrTheSafeLayoutBinding;", "currentStore", "", "menuAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyMenuMainAdapter;", "menuList", "", "Lcom/rockstargames/gtacr/data/FamilyMainItemData;", "oldTimerForClick", "", "onClickMenuList", "Lkotlin/Function3;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "position", "Landroid/view/View;", "mView", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickMenuMainList;", "getView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "setDataInMenu", "setDataInView", "setDescriptionForStore", "otherState", "setLogicForClickOnMenuList", "setStartParameters", "setTitle", "title", "", "setVisibleForInfo", "valueOfVisible", "updateParameters", "newParameters", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIMenuFamilyStore extends UILayout {
    private final ActionsWithJSON actionsWithJSON;
    private Animation anim;
    private FamiliesMenuTheStoreOrTheSafeLayoutBinding binding;
    private final NvEventQueueActivity context;
    private int currentStore;
    private FamilyMenuMainAdapter menuAdapter;
    private final List<FamilyMainItemData> menuList;
    private long oldTimerForClick;
    private Function3<? super FamilyMainItemData, ? super Integer, ? super View, Unit> onClickMenuList;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIMenuFamilyStore(NvEventQueueActivity context, ActionsWithJSON actionsWithJSON) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.context = context;
        this.actionsWithJSON = actionsWithJSON;
        this.menuList = new ArrayList();
        this.currentStore = -1;
    }

    public final void setStartParameters(List<Integer> otherState) {
        Intrinsics.checkNotNullParameter(otherState, "otherState");
        if (this.menuList.size() > 0) {
            int size = this.menuList.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                this.menuList.get(i).setClicked(i == 0);
                FamilyMenuMainAdapter familyMenuMainAdapter = this.menuAdapter;
                if (familyMenuMainAdapter != null) {
                    familyMenuMainAdapter.notifyItemChanged(i);
                }
                i = i2;
            }
            this.currentStore = this.menuList.get(0).getItemsId();
            setVisibleForInfo(0);
            setTitle(this.menuList.get(0).getItemsTitle());
            FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding = this.binding;
            if (familiesMenuTheStoreOrTheSafeLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                familiesMenuTheStoreOrTheSafeLayoutBinding = null;
            }
            familiesMenuTheStoreOrTheSafeLayoutBinding.buttonGoToTheContents.setVisibility(0);
        }
        if (otherState.size() == 12) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(otherState.get(0));
            arrayList.add(otherState.get(2));
            arrayList.add(otherState.get(4));
            arrayList.add(otherState.get(6));
            arrayList.add(otherState.get(8));
            setDescriptionForStore(arrayList);
        }
    }

    public final void updateParameters(List<Integer> newParameters) {
        Intrinsics.checkNotNullParameter(newParameters, "newParameters");
        setDescriptionForStore(newParameters);
    }

    @Override
    public View getView() {
        FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding = this.binding;
        if (familiesMenuTheStoreOrTheSafeLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuTheStoreOrTheSafeLayoutBinding = null;
        }
        ConstraintLayout root = familiesMenuTheStoreOrTheSafeLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FamiliesMenuTheStoreOrTheSafeLayoutBinding inflate = FamiliesMenuTheStoreOrTheSafeLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        setDataInMenu();
        setLogicForClickOnMenuList();
        setDataInView();
        FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding2 = this.binding;
        if (familiesMenuTheStoreOrTheSafeLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuTheStoreOrTheSafeLayoutBinding2 = null;
        }
        familiesMenuTheStoreOrTheSafeLayoutBinding2.buttonGoToTheContents.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMenuFamilyStore.m223onCreateView$lambda2(UIMenuFamilyStore.this, view);
            }
        });
        FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding3 = this.binding;
        if (familiesMenuTheStoreOrTheSafeLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuTheStoreOrTheSafeLayoutBinding3 = null;
        }
        familiesMenuTheStoreOrTheSafeLayoutBinding3.buttonBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMenuFamilyStore.m224onCreateView$lambda3(UIMenuFamilyStore.this, view);
            }
        });
        FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding4 = this.binding;
        if (familiesMenuTheStoreOrTheSafeLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuTheStoreOrTheSafeLayoutBinding4 = null;
        }
        familiesMenuTheStoreOrTheSafeLayoutBinding4.allMoneyValue.setSelected(true);
        familiesMenuTheStoreOrTheSafeLayoutBinding4.materialsValue.setSelected(true);
        familiesMenuTheStoreOrTheSafeLayoutBinding4.masksValue.setSelected(true);
        familiesMenuTheStoreOrTheSafeLayoutBinding4.oilValue.setSelected(true);
        FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding5 = this.binding;
        if (familiesMenuTheStoreOrTheSafeLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesMenuTheStoreOrTheSafeLayoutBinding = familiesMenuTheStoreOrTheSafeLayoutBinding5;
        }
        ConstraintLayout root = familiesMenuTheStoreOrTheSafeLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public static final void m223onCreateView$lambda2(UIMenuFamilyStore this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.currentStore == -1 || System.currentTimeMillis() - this$0.oldTimerForClick <= 200) {
            return;
        }
        this$0.oldTimerForClick = System.currentTimeMillis();
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        this$0.actionsWithJSON.setClickOnStore(this$0.currentStore);
    }

    public static final void m224onCreateView$lambda3(UIMenuFamilyStore this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actionsWithJSON.sendGetLayout(5);
    }

    private final void setLogicForClickOnMenuList() {
        this.onClickMenuList = new Function3<FamilyMainItemData, Integer, View, Unit>() {
            @Override
            public Unit invoke(FamilyMainItemData familyMainItemData, Integer num, View view) {
                invoke(familyMainItemData, num.intValue(), view);
                return Unit.INSTANCE;
            }

            public void invoke(FamilyMainItemData item, int i, View mView) {
                long j;
                Animation animation;
                FamilyMenuMainAdapter familyMenuMainAdapter;
                FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding;
                FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding2;
                FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding3;
                FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding4;
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(mView, "mView");
                long currentTimeMillis = System.currentTimeMillis();
                j = UIMenuFamilyStore.this.oldTimerForClick;
                if (currentTimeMillis - j > 200) {
                    UIMenuFamilyStore.this.oldTimerForClick = System.currentTimeMillis();
                    animation = UIMenuFamilyStore.this.anim;
                    FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding5 = null;
                    if (animation == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("anim");
                        animation = null;
                    }
                    mView.startAnimation(animation);
                    UIMenuFamilyStore.this.currentStore = item.getItemsId();
                    item.setClicked(true);
                    familyMenuMainAdapter = UIMenuFamilyStore.this.menuAdapter;
                    if (familyMenuMainAdapter != null) {
                        familyMenuMainAdapter.notifyItemChanged(i);
                        familyMenuMainAdapter.setCheckOnlyElement(i);
                    }
                    int itemsId = item.getItemsId();
                    if (itemsId == 0) {
                        familiesMenuTheStoreOrTheSafeLayoutBinding = UIMenuFamilyStore.this.binding;
                        if (familiesMenuTheStoreOrTheSafeLayoutBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            familiesMenuTheStoreOrTheSafeLayoutBinding = null;
                        }
                        if (familiesMenuTheStoreOrTheSafeLayoutBinding.titleContentsOfTheSafe.getVisibility() == 4) {
                            UIMenuFamilyStore.this.setVisibleForInfo(0);
                        }
                    } else if (itemsId == 1) {
                        familiesMenuTheStoreOrTheSafeLayoutBinding4 = UIMenuFamilyStore.this.binding;
                        if (familiesMenuTheStoreOrTheSafeLayoutBinding4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            familiesMenuTheStoreOrTheSafeLayoutBinding4 = null;
                        }
                        if (familiesMenuTheStoreOrTheSafeLayoutBinding4.titleContentsOfTheSafe.getVisibility() == 0) {
                            UIMenuFamilyStore.this.setVisibleForInfo(4);
                        }
                    }
                    UIMenuFamilyStore.this.setTitle(item.getItemsTitle());
                    familiesMenuTheStoreOrTheSafeLayoutBinding2 = UIMenuFamilyStore.this.binding;
                    if (familiesMenuTheStoreOrTheSafeLayoutBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        familiesMenuTheStoreOrTheSafeLayoutBinding2 = null;
                    }
                    if (familiesMenuTheStoreOrTheSafeLayoutBinding2.buttonGoToTheContents.getVisibility() == 4) {
                        familiesMenuTheStoreOrTheSafeLayoutBinding3 = UIMenuFamilyStore.this.binding;
                        if (familiesMenuTheStoreOrTheSafeLayoutBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            familiesMenuTheStoreOrTheSafeLayoutBinding5 = familiesMenuTheStoreOrTheSafeLayoutBinding3;
                        }
                        familiesMenuTheStoreOrTheSafeLayoutBinding5.buttonGoToTheContents.setVisibility(0);
                    }
                }
            }
        };
    }

    private final void setDataInMenu() {
        List<FamilyMainItemData> list = this.menuList;
        list.clear();
        list.add(new FamilyMainItemData(0, "Сейф", false, 4, null));
        list.add(new FamilyMainItemData(1, "Склад", false, 4, null));
    }

    private final void setDataInView() {
        this.menuAdapter = new FamilyMenuMainAdapter(this.menuList, this.onClickMenuList, this.context);
        FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding = this.binding;
        FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding2 = null;
        if (familiesMenuTheStoreOrTheSafeLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuTheStoreOrTheSafeLayoutBinding = null;
        }
        RecyclerView recyclerView = familiesMenuTheStoreOrTheSafeLayoutBinding.upgradeList;
        FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding3 = this.binding;
        if (familiesMenuTheStoreOrTheSafeLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesMenuTheStoreOrTheSafeLayoutBinding2 = familiesMenuTheStoreOrTheSafeLayoutBinding3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesMenuTheStoreOrTheSafeLayoutBinding2.getRoot().getContext(), 1, false));
        recyclerView.setAdapter(this.menuAdapter);
    }

    public final void setVisibleForInfo(int i) {
        FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding = this.binding;
        if (familiesMenuTheStoreOrTheSafeLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuTheStoreOrTheSafeLayoutBinding = null;
        }
        familiesMenuTheStoreOrTheSafeLayoutBinding.titleContentsOfTheSafe.setVisibility(i);
        familiesMenuTheStoreOrTheSafeLayoutBinding.allMoney.setVisibility(i);
        familiesMenuTheStoreOrTheSafeLayoutBinding.allMoneyValue.setVisibility(i);
        familiesMenuTheStoreOrTheSafeLayoutBinding.materials.setVisibility(i);
        familiesMenuTheStoreOrTheSafeLayoutBinding.materialsValue.setVisibility(i);
        familiesMenuTheStoreOrTheSafeLayoutBinding.masks.setVisibility(i);
        familiesMenuTheStoreOrTheSafeLayoutBinding.masksValue.setVisibility(i);
        familiesMenuTheStoreOrTheSafeLayoutBinding.oil.setVisibility(i);
        familiesMenuTheStoreOrTheSafeLayoutBinding.oilValue.setVisibility(i);
        familiesMenuTheStoreOrTheSafeLayoutBinding.armor.setVisibility(i);
        familiesMenuTheStoreOrTheSafeLayoutBinding.armorValue.setVisibility(i);
    }

    public final void setTitle(String str) {
        FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding = this.binding;
        if (familiesMenuTheStoreOrTheSafeLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuTheStoreOrTheSafeLayoutBinding = null;
        }
        String str2 = str;
        familiesMenuTheStoreOrTheSafeLayoutBinding.storeTitle.setText(str2);
        familiesMenuTheStoreOrTheSafeLayoutBinding.titleRightBlock.setText(str2);
        TextView textView = familiesMenuTheStoreOrTheSafeLayoutBinding.actionTitle;
        if (!Intrinsics.areEqual(str, "")) {
            str2 = this.context.getString(R.string.families_store_use_title, new Object[]{str});
        }
        textView.setText(str2);
    }

    private final void setDescriptionForStore(List<Integer> list) {
        FamiliesMenuTheStoreOrTheSafeLayoutBinding familiesMenuTheStoreOrTheSafeLayoutBinding = this.binding;
        if (familiesMenuTheStoreOrTheSafeLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuTheStoreOrTheSafeLayoutBinding = null;
        }
        NvEventQueueActivity nvEventQueueActivity = this.context;
        if (list.size() == 5) {
            familiesMenuTheStoreOrTheSafeLayoutBinding.allMoneyValue.setText(nvEventQueueActivity.getString(R.string.families_store_money, new Object[]{new Useful().getPriceWithSpacesForInt(list.get(0).intValue())}));
            familiesMenuTheStoreOrTheSafeLayoutBinding.materialsValue.setText(nvEventQueueActivity.getString(R.string.families_store_materials, new Object[]{list.get(1)}));
            familiesMenuTheStoreOrTheSafeLayoutBinding.masksValue.setText(nvEventQueueActivity.getString(R.string.families_store_masks, new Object[]{list.get(2)}));
            familiesMenuTheStoreOrTheSafeLayoutBinding.oilValue.setText(nvEventQueueActivity.getString(R.string.families_store_oil, new Object[]{list.get(3)}));
            familiesMenuTheStoreOrTheSafeLayoutBinding.armorValue.setText(nvEventQueueActivity.getString(R.string.families_store_armor, new Object[]{list.get(4)}));
        }
    }
}
