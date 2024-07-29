package com.rockstargames.gtacr.gui.familySystem;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesMenuFamilySettingLayoutBinding;
import blackrussia.online.network.FamilySystemColorsObj;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyMenuFamilySettingAdapter;
import com.rockstargames.gtacr.adapters.FamilyMenuMainAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.FamilyMainItemData;
import com.rockstargames.gtacr.data.FamilyRankOrColorData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

//@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u00100\u001a\u00020%2\u0006\u0010+\u001a\u00020\u0011H\u0002J\b\u00101\u001a\u00020(H\u0016J\u001a\u00102\u001a\u00020(2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020%H\u0016J\b\u00108\u001a\u00020%H\u0016J\b\u00109\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020%H\u0002J\b\u0010;\u001a\u00020%H\u0002J\b\u0010<\u001a\u00020%H\u0002J*\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020\u00112\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001d0\b2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00110\bJ\u0010\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020\u0011H\u0002J\u0010\u0010C\u001a\u00020%2\u0006\u0010B\u001a\u00020\u0011H\u0002J&\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u0011J\u000e\u0010I\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010J\u001a\u00020%2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003J\u000e\u0010L\u001a\u00020%2\u0006\u0010M\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000RW\u0010\u001e\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%0\u001fj\u0002`&X\u0082.¢\u0006\u0002\n\u0000RW\u0010'\u001aK\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110(¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b()\u0012\u0004\u0012\u00020%0\u001fj\u0002`*X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006N"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/UIMenuFamilySetting;", "Lcom/rockstargames/gtacr/common/UILayout;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;)V", "adaptersCollection", "", "Lcom/rockstargames/gtacr/data/FamilyRankOrColorData;", "allColorsFromServer", "Lblackrussia/online/network/FamilySystemColorsObj;", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesMenuFamilySettingLayoutBinding;", "currentRankId", "", "familyAccess", "familyAccessInt", "familyChatsColors", "familyRanks", "familySettingAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyMenuFamilySettingAdapter;", "menuAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyMenuMainAdapter;", "menuList", "Lcom/rockstargames/gtacr/data/FamilyMainItemData;", "newRankName", "", "onClickMenuFamilyList", "Lkotlin/Function3;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "position", "clicksType", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickMenuFamilyList;", "onClickMenuMainList", "Landroid/view/View;", "mView", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickMenuMainList;", "ranksPosition", "getRanksPosition", "()I", "setRanksPosition", "(I)V", "getActualAccess", "getView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "setAccess", "setDataInView", "setLogicForOnClickMenuFamilyList", "setLogicForOnClickMenuMainList", "setStartData", "currentColor", "ranksNames", "ranksAccess", "setVisibleEditRanksName", "valueVisible", "setVisibleEditRanksText", "updateAccess", "ifTrueOperation", "oldAccessPosition", "oldRanksPosition", "newAccessStatus", "updateRankName", "updateRightBlock", "newCollection", "updateStartColor", "oldPosition", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIMenuFamilySetting extends UILayout {
    private final ActionsWithJSON actionsWithJSON;
    private final List<FamilyRankOrColorData> adaptersCollection;
    private final List<FamilySystemColorsObj> allColorsFromServer;
    private Animation anim;
    private FamiliesMenuFamilySettingLayoutBinding binding;
    private final NvEventQueueActivity context;
    private int currentRankId;
    private final List<FamilyRankOrColorData> familyAccess;
    private final List<Integer> familyAccessInt;
    private final List<FamilyRankOrColorData> familyChatsColors;
    private final List<FamilyRankOrColorData> familyRanks;
    private FamilyMenuFamilySettingAdapter familySettingAdapter;
    private FamilyMenuMainAdapter menuAdapter;
    private final List<FamilyMainItemData> menuList;
    private String newRankName;
    private Function3<? super FamilyRankOrColorData, ? super Integer, ? super Integer, Unit> onClickMenuFamilyList;
    private Function3<? super FamilyMainItemData, ? super Integer, ? super View, Unit> onClickMenuMainList;
    private int ranksPosition;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIMenuFamilySetting(NvEventQueueActivity context, ActionsWithJSON actionsWithJSON) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.context = context;
        this.actionsWithJSON = actionsWithJSON;
        this.familyRanks = new ArrayList();
        this.familyAccess = new ArrayList();
        this.familyChatsColors = new ArrayList();
        this.adaptersCollection = new ArrayList();
        this.newRankName = "";
        this.familyAccessInt = new ArrayList();
        this.menuList = CollectionsKt.mutableListOf(new FamilyMainItemData(0, "Настройка рангов", true), new FamilyMainItemData(1, "Цвет чата семьи", false, 4, null));
        this.allColorsFromServer = App.getInstance().getFamilySystemList().getColorsList();
    }

    public final int getRanksPosition() {
        return this.ranksPosition;
    }

    public final void setRanksPosition(int i) {
        this.ranksPosition = i;
    }

    public final void setStartData(int i, List<String> ranksNames, List<Integer> ranksAccess) {
        Intrinsics.checkNotNullParameter(ranksNames, "ranksNames");
        Intrinsics.checkNotNullParameter(ranksAccess, "ranksAccess");
        this.familyRanks.clear();
        for (String str : ranksNames) {
            this.familyRanks.add(new FamilyRankOrColorData(0, str, null, null, null, null));
        }
        List<Integer> list = this.familyAccessInt;
        list.clear();
        list.addAll(ranksAccess);
        FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding = null;
        if (this.menuList.size() > 0) {
            int size = this.menuList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                this.menuList.get(i2).setClicked(i2 == 0);
                FamilyMenuMainAdapter familyMenuMainAdapter = this.menuAdapter;
                if (familyMenuMainAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("menuAdapter");
                    familyMenuMainAdapter = null;
                }
                familyMenuMainAdapter.notifyItemChanged(i2);
                i2 = i3;
            }
        }
        List<FamilyRankOrColorData> list2 = this.familyChatsColors;
        list2.clear();
        for (FamilySystemColorsObj familySystemColorsObj : this.allColorsFromServer) {
            list2.add(new FamilyRankOrColorData(2, familySystemColorsObj.getTitle(), null, familySystemColorsObj.getColor(), Boolean.valueOf(familySystemColorsObj.getId() == i), false));
        }
        setVisibleEditRanksName(4);
        setVisibleEditRanksText(4);
        this.currentRankId = 0;
        this.newRankName = "";
        FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding2 = this.binding;
        if (familiesMenuFamilySettingLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesMenuFamilySettingLayoutBinding = familiesMenuFamilySettingLayoutBinding2;
        }
        familiesMenuFamilySettingLayoutBinding.titleRightBlock.setText("Настройка рангов");
        updateRightBlock(this.familyRanks);
    }

    public final void updateRankName(int i) {
        int i2 = i - 1;
        FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding = this.binding;
        FamilyMenuFamilySettingAdapter familyMenuFamilySettingAdapter = null;
        if (familiesMenuFamilySettingLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuFamilySettingLayoutBinding = null;
        }
        if (Intrinsics.areEqual(this.newRankName, "")) {
            return;
        }
        if (i == i) {
            familiesMenuFamilySettingLayoutBinding.titleRank.setText(this.newRankName);
        }
        if (this.familyRanks.size() >= i) {
            int i3 = 0;
            int size = this.familyRanks.size();
            while (i3 < size) {
                int i4 = i3 + 1;
                if (i3 == i2) {
                    this.familyRanks.get(i2).setStatusName(this.newRankName);
                    FamilyMenuFamilySettingAdapter familyMenuFamilySettingAdapter2 = this.familySettingAdapter;
                    if (familyMenuFamilySettingAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("familySettingAdapter");
                    } else {
                        familyMenuFamilySettingAdapter = familyMenuFamilySettingAdapter2;
                    }
                    familyMenuFamilySettingAdapter.notifyItemChanged(i2);
                    return;
                }
                i3 = i4;
            }
        }
    }

    @Override
    public View getView() {
        FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding = this.binding;
        if (familiesMenuFamilySettingLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuFamilySettingLayoutBinding = null;
        }
        ConstraintLayout root = familiesMenuFamilySettingLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FamiliesMenuFamilySettingLayoutBinding inflate = FamiliesMenuFamilySettingLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        setAccess();
        setLogicForOnClickMenuFamilyList();
        setLogicForOnClickMenuMainList();
        setDataInView();
        FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding2 = this.binding;
        if (familiesMenuFamilySettingLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuFamilySettingLayoutBinding2 = null;
        }
        familiesMenuFamilySettingLayoutBinding2.buttonBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMenuFamilySetting.m219onCreateView$lambda6$lambda3(UIMenuFamilySetting.this, view);
            }
        });
        familiesMenuFamilySettingLayoutBinding2.editRanksName.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMenuFamilySetting.m220onCreateView$lambda6$lambda4(UIMenuFamilySetting.this, view);
            }
        });
        FamiliesMenuFamilySettingLayoutBinding finalFamiliesMenuFamilySettingLayoutBinding = familiesMenuFamilySettingLayoutBinding2;
        familiesMenuFamilySettingLayoutBinding2.buttonApplyRename.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMenuFamilySetting.m221onCreateView$lambda6$lambda5(UIMenuFamilySetting.this, finalFamiliesMenuFamilySettingLayoutBinding, view);
            }
        });
        FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding3 = this.binding;
        if (familiesMenuFamilySettingLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesMenuFamilySettingLayoutBinding = familiesMenuFamilySettingLayoutBinding3;
        }
        ConstraintLayout root = familiesMenuFamilySettingLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public static final void m219onCreateView$lambda6$lambda3(UIMenuFamilySetting this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actionsWithJSON.sendGetLayout(5);
    }

    public static final void m220onCreateView$lambda6$lambda4(UIMenuFamilySetting this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVisibleEditRanksName(4);
        this$0.setVisibleEditRanksText(0);
    }

    public static final void m221onCreateView$lambda6$lambda5(UIMenuFamilySetting this$0, FamiliesMenuFamilySettingLayoutBinding this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.setVisibleEditRanksText(4);
        this$0.setVisibleEditRanksName(0);
        Editable text = this_apply.editTextRankName.getText();
        Intrinsics.checkNotNullExpressionValue(text, "editTextRankName.text");
        if (!(text.length() > 0)) {
            Editable text2 = this_apply.editTextRankName.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "editTextRankName.text");
            if (!(!StringsKt.isBlank(text2))) {
                return;
            }
        }
        if (this$0.currentRankId != 0) {
            String obj = this_apply.editTextRankName.getText().toString();
            this$0.newRankName = obj;
            this$0.actionsWithJSON.clickOnRank(this$0.currentRankId, obj);
        }
        this_apply.editTextRankName.getText().clear();
    }

    private final void setLogicForOnClickMenuFamilyList() {
        this.onClickMenuFamilyList = new Function3<FamilyRankOrColorData, Integer, Integer, Unit>() {
            @Override
            public Unit invoke(FamilyRankOrColorData familyRankOrColorData, Integer num, Integer num2) {
                invoke(familyRankOrColorData, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(FamilyRankOrColorData item, int i, int i2) {
                int i3;
                ActionsWithJSON actionsWithJSON;
                int i4;
                ActionsWithJSON actionsWithJSON2;
                FamilyMenuFamilySettingAdapter familyMenuFamilySettingAdapter;
                Intrinsics.checkNotNullParameter(item, "item");
                int i5 = 1;
                if (i2 == 0) {
                    UIMenuFamilySetting.this.currentRankId = i + 1;
                    UIMenuFamilySetting uIMenuFamilySetting = UIMenuFamilySetting.this;
                    i3 = uIMenuFamilySetting.currentRankId;
                    uIMenuFamilySetting.getActualAccess(i3);
                } else if (i2 == 1) {
                    if (item.getCurrentStatus() != null) {
                        Integer currentStatus = item.getCurrentStatus();
                        i5 = (currentStatus == null || currentStatus.intValue() != 0) ? 0 : 0;
                        actionsWithJSON = UIMenuFamilySetting.this.actionsWithJSON;
                        i4 = UIMenuFamilySetting.this.currentRankId;
                        actionsWithJSON.clickOnAccess(i4, i, i5);
                    }
                } else if (i2 != 2) {
                } else {
                    if (item.isClicked() != null && !Intrinsics.areEqual((Object) item.isClicked(), (Object) true)) {
                        item.setClicked(true);
                    } else if (item.isClicked() != null && !Intrinsics.areEqual((Object) item.getIfStartedColor(), (Object) true)) {
                        actionsWithJSON2 = UIMenuFamilySetting.this.actionsWithJSON;
                        actionsWithJSON2.setStartColor(i);
                    }
                    familyMenuFamilySettingAdapter = UIMenuFamilySetting.this.familySettingAdapter;
                    if (familyMenuFamilySettingAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("familySettingAdapter");
                        familyMenuFamilySettingAdapter = null;
                    }
                    familyMenuFamilySettingAdapter.notifyItemChanged(i);
                    familyMenuFamilySettingAdapter.setCheckOnlyElement(i);
                }
            }
        };
    }

    public final void getActualAccess(int i) {
        if (this.familyAccessInt.size() == this.familyAccess.size()) {
            int size = this.familyAccess.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                if (this.familyAccessInt.get(i2).intValue() <= i) {
                    this.familyAccess.get(i2).setCurrentStatus(1);
                } else {
                    this.familyAccess.get(i2).setCurrentStatus(0);
                }
                i2 = i3;
            }
            updateRightBlock(this.familyAccess);
            setVisibleEditRanksName(0);
            setVisibleEditRanksText(4);
            int i4 = i - 1;
            String statusName = this.familyRanks.size() > i4 ? this.familyRanks.get(i4).getStatusName() : "";
            FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding = this.binding;
            FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding2 = null;
            if (familiesMenuFamilySettingLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                familiesMenuFamilySettingLayoutBinding = null;
            }
            familiesMenuFamilySettingLayoutBinding.titleRightBlock.setText("Настройка —");
            FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding3 = this.binding;
            if (familiesMenuFamilySettingLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                familiesMenuFamilySettingLayoutBinding2 = familiesMenuFamilySettingLayoutBinding3;
            }
            familiesMenuFamilySettingLayoutBinding2.titleRank.setText(statusName);
        }
    }

    public final void setVisibleEditRanksName(int i) {
        FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding = this.binding;
        if (familiesMenuFamilySettingLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuFamilySettingLayoutBinding = null;
        }
        familiesMenuFamilySettingLayoutBinding.titleRank.setVisibility(i);
        familiesMenuFamilySettingLayoutBinding.editRanksName.setVisibility(i);
    }

    public final void setVisibleEditRanksText(int i) {
        FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding = this.binding;
        if (familiesMenuFamilySettingLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuFamilySettingLayoutBinding = null;
        }
        familiesMenuFamilySettingLayoutBinding.editTextRankName.setVisibility(i);
        familiesMenuFamilySettingLayoutBinding.buttonApplyRename.setVisibility(i);
    }

    private final void setLogicForOnClickMenuMainList() {
        this.onClickMenuMainList = new Function3<FamilyMainItemData, Integer, View, Unit>() {
            @Override
            public Unit invoke(FamilyMainItemData familyMainItemData, Integer num, View view) {
                invoke(familyMainItemData, num.intValue(), view);
                return Unit.INSTANCE;
            }

            public void invoke(FamilyMainItemData item, int i, View mView) {
                Animation animation;
                FamilyMenuMainAdapter familyMenuMainAdapter;
                List list;
                FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding;
                List list2;
                FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding2;
                List list3;
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(mView, "mView");
                animation = UIMenuFamilySetting.this.anim;
                FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding3 = null;
                if (animation == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("anim");
                    animation = null;
                }
                mView.startAnimation(animation);
                item.setClicked(true);
                familyMenuMainAdapter = UIMenuFamilySetting.this.menuAdapter;
                if (familyMenuMainAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("menuAdapter");
                    familyMenuMainAdapter = null;
                }
                familyMenuMainAdapter.notifyItemChanged(i);
                familyMenuMainAdapter.setCheckOnlyElement(i);
                UIMenuFamilySetting.this.setVisibleEditRanksName(4);
                UIMenuFamilySetting.this.setVisibleEditRanksText(4);
                list = UIMenuFamilySetting.this.adaptersCollection;
                list.clear();
                if (i == 0) {
                    familiesMenuFamilySettingLayoutBinding = UIMenuFamilySetting.this.binding;
                    if (familiesMenuFamilySettingLayoutBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        familiesMenuFamilySettingLayoutBinding3 = familiesMenuFamilySettingLayoutBinding;
                    }
                    familiesMenuFamilySettingLayoutBinding3.titleRightBlock.setText("Настройка рангов");
                    UIMenuFamilySetting uIMenuFamilySetting = UIMenuFamilySetting.this;
                    list2 = uIMenuFamilySetting.familyRanks;
                    uIMenuFamilySetting.updateRightBlock(list2);
                } else if (i != 1) {
                } else {
                    familiesMenuFamilySettingLayoutBinding2 = UIMenuFamilySetting.this.binding;
                    if (familiesMenuFamilySettingLayoutBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        familiesMenuFamilySettingLayoutBinding3 = familiesMenuFamilySettingLayoutBinding2;
                    }
                    familiesMenuFamilySettingLayoutBinding3.titleRightBlock.setText("Настройка цвета чата");
                    UIMenuFamilySetting uIMenuFamilySetting2 = UIMenuFamilySetting.this;
                    list3 = uIMenuFamilySetting2.familyChatsColors;
                    uIMenuFamilySetting2.updateRightBlock(list3);
                }
            }
        };
    }

    public final void updateRightBlock(List<FamilyRankOrColorData> list) {
        List<FamilyRankOrColorData> list2 = this.adaptersCollection;
        list2.clear();
        list2.addAll(list);
        FamilyMenuFamilySettingAdapter familyMenuFamilySettingAdapter = this.familySettingAdapter;
        if (familyMenuFamilySettingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("familySettingAdapter");
            familyMenuFamilySettingAdapter = null;
        }
        familyMenuFamilySettingAdapter.notifyDataSetChanged();
    }

    private final void setDataInView() {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        List<FamilyRankOrColorData> list = this.adaptersCollection;
        Function3<? super FamilyRankOrColorData, ? super Integer, ? super Integer, Unit> function3 = this.onClickMenuFamilyList;
        FamilyMenuMainAdapter familyMenuMainAdapter = null;
        if (function3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onClickMenuFamilyList");
            function3 = null;
        }
        FamilyMenuFamilySettingAdapter familyMenuFamilySettingAdapter = new FamilyMenuFamilySettingAdapter(nvEventQueueActivity, list, function3);
        this.familySettingAdapter = familyMenuFamilySettingAdapter;
        if (familyMenuFamilySettingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("familySettingAdapter");
            familyMenuFamilySettingAdapter = null;
        }
        familyMenuFamilySettingAdapter.setHasStableIds(true);
        FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding = this.binding;
        if (familiesMenuFamilySettingLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuFamilySettingLayoutBinding = null;
        }
        RecyclerView recyclerView = familiesMenuFamilySettingLayoutBinding.ranksOrChatsColorSetting;
        FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding2 = this.binding;
        if (familiesMenuFamilySettingLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuFamilySettingLayoutBinding2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesMenuFamilySettingLayoutBinding2.getRoot().getContext(), 1, false));
        FamilyMenuFamilySettingAdapter familyMenuFamilySettingAdapter2 = this.familySettingAdapter;
        if (familyMenuFamilySettingAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("familySettingAdapter");
            familyMenuFamilySettingAdapter2 = null;
        }
        recyclerView.setAdapter(familyMenuFamilySettingAdapter2);
        recyclerView.setItemViewCacheSize(this.allColorsFromServer.size());
        List<FamilyMainItemData> list2 = this.menuList;
        Function3<? super FamilyMainItemData, ? super Integer, ? super View, Unit> function32 = this.onClickMenuMainList;
        if (function32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onClickMenuMainList");
            function32 = null;
        }
        this.menuAdapter = new FamilyMenuMainAdapter(list2, function32, this.context);
        FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding3 = this.binding;
        if (familiesMenuFamilySettingLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuFamilySettingLayoutBinding3 = null;
        }
        RecyclerView recyclerView2 = familiesMenuFamilySettingLayoutBinding3.menuList;
        FamiliesMenuFamilySettingLayoutBinding familiesMenuFamilySettingLayoutBinding4 = this.binding;
        if (familiesMenuFamilySettingLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesMenuFamilySettingLayoutBinding4 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(familiesMenuFamilySettingLayoutBinding4.getRoot().getContext(), 1, false));
        FamilyMenuMainAdapter familyMenuMainAdapter2 = this.menuAdapter;
        if (familyMenuMainAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuAdapter");
        } else {
            familyMenuMainAdapter = familyMenuMainAdapter2;
        }
        recyclerView2.setAdapter(familyMenuMainAdapter);
    }

    private final void setAccess() {
        List<FamilyRankOrColorData> list = this.familyAccess;
        list.clear();
        list.add(new FamilyRankOrColorData(1, "принять игрока", 0, null, null, null));
        list.add(new FamilyRankOrColorData(1, "выгнать игрока", 0, null, null, null));
        list.add(new FamilyRankOrColorData(1, "изменить ранг", 0, null, null, null));
        list.add(new FamilyRankOrColorData(1, "выдать мут", 0, null, null, null));
        list.add(new FamilyRankOrColorData(1, "участия в войне семей", 0, null, null, null));
        list.add(new FamilyRankOrColorData(1, "складу", 0, null, null, null));
    }

    public final void updateStartColor(int i) {
        if (this.familyChatsColors.size() > i && this.familyChatsColors.get(i).getIfStartedColor() != null) {
            this.familyChatsColors.get(i).setIfStartedColor(true);
        }
        if (this.adaptersCollection.size() <= i || this.adaptersCollection.get(i).getIfStartedColor() == null) {
            return;
        }
        this.adaptersCollection.get(i).setIfStartedColor(true);
        FamilyMenuFamilySettingAdapter familyMenuFamilySettingAdapter = this.familySettingAdapter;
        if (familyMenuFamilySettingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("familySettingAdapter");
            familyMenuFamilySettingAdapter = null;
        }
        familyMenuFamilySettingAdapter.notifyItemChanged(i);
        familyMenuFamilySettingAdapter.setOnlyStartColor(i);
    }

    public final void updateAccess(int i, int i2, int i3, int i4) {
        FamilyMenuFamilySettingAdapter familyMenuFamilySettingAdapter = null;
        if (i == 0) {
            if (this.adaptersCollection.size() > i2 && this.adaptersCollection.get(i2).getCurrentStatus() != null) {
                FamilyMenuFamilySettingAdapter familyMenuFamilySettingAdapter2 = this.familySettingAdapter;
                if (familyMenuFamilySettingAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("familySettingAdapter");
                } else {
                    familyMenuFamilySettingAdapter = familyMenuFamilySettingAdapter2;
                }
                familyMenuFamilySettingAdapter.notifyItemChanged(i2);
            }
            if (this.familyAccessInt.size() > i2) {
                this.familyAccessInt.get(i2);
            }
        } else if (i != 1) {
        } else {
            if (this.adaptersCollection.size() > i2 && this.adaptersCollection.get(i2).getCurrentStatus() != null) {
                this.adaptersCollection.get(i2).setCurrentStatus(Integer.valueOf(i4));
                FamilyMenuFamilySettingAdapter familyMenuFamilySettingAdapter3 = this.familySettingAdapter;
                if (familyMenuFamilySettingAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("familySettingAdapter");
                } else {
                    familyMenuFamilySettingAdapter = familyMenuFamilySettingAdapter3;
                }
                familyMenuFamilySettingAdapter.notifyItemChanged(i2);
            }
            if (this.familyAccessInt.size() > i2) {
                if (i4 == 0) {
                    this.familyAccessInt.set(i2, 5);
                } else {
                    this.familyAccessInt.set(i2, Integer.valueOf(i3));
                }
            }
        }
    }
}
