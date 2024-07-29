package com.rockstargames.gtacr.gui.familySystem;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesTopPresentsLayoutBinding;
import blackrussia.online.network.FamilySystemList;
import blackrussia.online.network.FamilySystemRewardTopObj;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GameRender;
import com.rockstargames.gtacr.adapters.FamilyTopPresentsAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.FamilyPresent;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J \u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0002J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020\u001dH\u0002J\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020!2\u0006\u0010#\u001a\u00020*H\u0002J\u0006\u0010+\u001a\u00020\u001dR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/UITopPresents;", "Lcom/rockstargames/gtacr/common/UILayout;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Lcom/nvidia/devtech/NvEventQueueActivity;)V", "adapterTop1", "Lcom/rockstargames/gtacr/adapters/FamilyTopPresentsAdapter;", "adapterTop2", "adapterTop3", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesTopPresentsLayoutBinding;", "listPresents1", "", "Lcom/rockstargames/gtacr/data/FamilyPresent;", "listPresents2", "listPresents3", "thisFamilySystemList", "Lblackrussia/online/network/FamilySystemList;", "kotlin.jvm.PlatformType", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "", "onLayoutShown", "renderAccessories", GetKeys.GET_PLAYERS_ID, "", "modelId", "thisObject", "Landroid/widget/ImageView;", "setCollectionsWithPresents", "currentTop", "setDataInView", "setDaysInView", "allDays", "Landroid/widget/TextView;", "setParameters", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UITopPresents extends UILayout {
    private FamilyTopPresentsAdapter adapterTop1;
    private FamilyTopPresentsAdapter adapterTop2;
    private FamilyTopPresentsAdapter adapterTop3;
    private Animation anim;
    private FamiliesTopPresentsLayoutBinding binding;
    private final NvEventQueueActivity context;
    private final List<FamilyPresent> listPresents1;
    private final List<FamilyPresent> listPresents2;
    private final List<FamilyPresent> listPresents3;
    private final FamilySystemList thisFamilySystemList;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UITopPresents(NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.listPresents1 = new ArrayList();
        this.listPresents2 = new ArrayList();
        this.listPresents3 = new ArrayList();
        this.thisFamilySystemList = App.getInstance().getFamilySystemList();
    }

    public final void setParameters() {
        List<FamilyPresent> list = this.listPresents1;
        list.clear();
        list.addAll(setCollectionsWithPresents(0));
        List<FamilyPresent> list2 = this.listPresents2;
        list2.clear();
        list2.addAll(setCollectionsWithPresents(1));
        List<FamilyPresent> list3 = this.listPresents3;
        list3.clear();
        list3.addAll(setCollectionsWithPresents(2));
        setDataInView();
        int accessoriesObjectId = this.thisFamilySystemList.getRewardTopList().get(0).getAccessoriesObjectId();
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding = this.binding;
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding2 = null;
        if (familiesTopPresentsLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesTopPresentsLayoutBinding = null;
        }
        ImageView imageView = familiesTopPresentsLayoutBinding.accessories1Item;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.accessories1Item");
        renderAccessories(0, accessoriesObjectId, imageView);
        int accessoriesObjectId2 = this.thisFamilySystemList.getRewardTopList().get(1).getAccessoriesObjectId();
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding3 = this.binding;
        if (familiesTopPresentsLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesTopPresentsLayoutBinding3 = null;
        }
        ImageView imageView2 = familiesTopPresentsLayoutBinding3.accessories2Item;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.accessories2Item");
        renderAccessories(1, accessoriesObjectId2, imageView2);
        int accessoriesObjectId3 = this.thisFamilySystemList.getRewardTopList().get(2).getAccessoriesObjectId();
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding4 = this.binding;
        if (familiesTopPresentsLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesTopPresentsLayoutBinding4 = null;
        }
        ImageView imageView3 = familiesTopPresentsLayoutBinding4.accessories3Item;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.accessories3Item");
        renderAccessories(2, accessoriesObjectId3, imageView3);
        int accessoriesTime = this.thisFamilySystemList.getRewardTopList().get(0).getAccessoriesTime();
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding5 = this.binding;
        if (familiesTopPresentsLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesTopPresentsLayoutBinding5 = null;
        }
        TextView textView = familiesTopPresentsLayoutBinding5.accessories1ValueDays;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.accessories1ValueDays");
        setDaysInView(accessoriesTime, textView);
        int accessoriesTime2 = this.thisFamilySystemList.getRewardTopList().get(1).getAccessoriesTime();
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding6 = this.binding;
        if (familiesTopPresentsLayoutBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesTopPresentsLayoutBinding6 = null;
        }
        TextView textView2 = familiesTopPresentsLayoutBinding6.accessories2ValueDays;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.accessories2ValueDays");
        setDaysInView(accessoriesTime2, textView2);
        int accessoriesTime3 = this.thisFamilySystemList.getRewardTopList().get(2).getAccessoriesTime();
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding7 = this.binding;
        if (familiesTopPresentsLayoutBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesTopPresentsLayoutBinding2 = familiesTopPresentsLayoutBinding7;
        }
        TextView textView3 = familiesTopPresentsLayoutBinding2.accessories3ValueDays;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.accessories3ValueDays");
        setDaysInView(accessoriesTime3, textView3);
    }

    private final List<FamilyPresent> setCollectionsWithPresents(int i) {
        ArrayList arrayList = new ArrayList();
        FamilySystemRewardTopObj familySystemRewardTopObj = this.thisFamilySystemList.getRewardTopList().get(i);
        if (familySystemRewardTopObj.getAdditionalCar() != 0) {
            arrayList.add(new FamilyPresent("— доп. авто слот:", Intrinsics.stringPlus("+", Integer.valueOf(familySystemRewardTopObj.getAdditionalCar()))));
        }
        if (familySystemRewardTopObj.getMoneyReward() != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(familySystemRewardTopObj.getMoneyReward());
            sb.append((char) 8381);
            arrayList.add(new FamilyPresent("— баланс:", sb.toString()));
        }
        if (familySystemRewardTopObj.getScoreReward() != 0) {
            arrayList.add(new FamilyPresent("— семейных монет:", Intrinsics.stringPlus("+", Integer.valueOf(familySystemRewardTopObj.getScoreReward()))));
        }
        if (familySystemRewardTopObj.getTokenReward() != 0) {
            arrayList.add(new FamilyPresent("— жетонов:", Intrinsics.stringPlus("+", Integer.valueOf(familySystemRewardTopObj.getTokenReward()))));
        }
        return arrayList;
    }

    private final void setDataInView() {
        this.adapterTop1 = new FamilyTopPresentsAdapter(this.listPresents1);
        this.adapterTop2 = new FamilyTopPresentsAdapter(this.listPresents2);
        this.adapterTop3 = new FamilyTopPresentsAdapter(this.listPresents3);
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding = this.binding;
        FamilyTopPresentsAdapter familyTopPresentsAdapter = null;
        if (familiesTopPresentsLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesTopPresentsLayoutBinding = null;
        }
        RecyclerView recyclerView = familiesTopPresentsLayoutBinding.presents1;
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding2 = this.binding;
        if (familiesTopPresentsLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesTopPresentsLayoutBinding2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesTopPresentsLayoutBinding2.getRoot().getContext(), 1, false));
        FamilyTopPresentsAdapter familyTopPresentsAdapter2 = this.adapterTop1;
        if (familyTopPresentsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterTop1");
            familyTopPresentsAdapter2 = null;
        }
        recyclerView.setAdapter(familyTopPresentsAdapter2);
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding3 = this.binding;
        if (familiesTopPresentsLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesTopPresentsLayoutBinding3 = null;
        }
        RecyclerView recyclerView2 = familiesTopPresentsLayoutBinding3.presents2;
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding4 = this.binding;
        if (familiesTopPresentsLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesTopPresentsLayoutBinding4 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(familiesTopPresentsLayoutBinding4.getRoot().getContext(), 1, false));
        FamilyTopPresentsAdapter familyTopPresentsAdapter3 = this.adapterTop2;
        if (familyTopPresentsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterTop2");
            familyTopPresentsAdapter3 = null;
        }
        recyclerView2.setAdapter(familyTopPresentsAdapter3);
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding5 = this.binding;
        if (familiesTopPresentsLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesTopPresentsLayoutBinding5 = null;
        }
        RecyclerView recyclerView3 = familiesTopPresentsLayoutBinding5.presents3;
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding6 = this.binding;
        if (familiesTopPresentsLayoutBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesTopPresentsLayoutBinding6 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(familiesTopPresentsLayoutBinding6.getRoot().getContext(), 1, false));
        FamilyTopPresentsAdapter familyTopPresentsAdapter4 = this.adapterTop3;
        if (familyTopPresentsAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterTop3");
        } else {
            familyTopPresentsAdapter = familyTopPresentsAdapter4;
        }
        recyclerView3.setAdapter(familyTopPresentsAdapter);
    }

    private final void renderAccessories(int i, int i2, final ImageView imageView) {
        GameRender gameRender = this.context.getGameRender();
        if (gameRender == null) {
            return;
        }
        gameRender.RequestRender(0, i, i2, 3, 3, 20.0f, 180.0f, 0.0f, 0.9f, new GameRender.GameRenderListener() {
            @Override
            public final void OnRenderComplete(int i3, byte[] bArr, long j) {
                UITopPresents.m228renderAccessories$lambda10(UITopPresents.this, imageView, i3, bArr, j);
            }
        });
    }

    public static final void m228renderAccessories$lambda10(UITopPresents this$0, final ImageView thisObject, int i, byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        thisObject.setScaleX(-1.0f);
        final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
        Intrinsics.checkNotNullExpressionValue(asIntBuffer, "wrap(buffer)\n           …           .asIntBuffer()");
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
        this$0.context.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                //UITopPresents.m229renderAccessories$lambda10$lambda9$lambda8(UITopPresents.this, thisObject, createBitmap);
            }
        });
    }

    public static final void m229renderAccessories$lambda10$lambda9$lambda8(UITopPresents this_run, ImageView thisObject, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        thisObject.setImageBitmap(bitmap);
        thisObject.animate().alpha(1.0f).setDuration(300L);
    }

    private final void setDaysInView(int i, TextView textView) {
        String str;
        if (i < 5) {
            str = i + " дня";
        } else {
            str = i + " дней";
        }
        textView.setText(str);
    }

    @Override
    public View getView() {
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding = this.binding;
        if (familiesTopPresentsLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesTopPresentsLayoutBinding = null;
        }
        ConstraintLayout root = familiesTopPresentsLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FamiliesTopPresentsLayoutBinding inflate = FamiliesTopPresentsLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        FamiliesTopPresentsLayoutBinding familiesTopPresentsLayoutBinding2 = this.binding;
        if (familiesTopPresentsLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesTopPresentsLayoutBinding = familiesTopPresentsLayoutBinding2;
        }
        ConstraintLayout root = familiesTopPresentsLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }
}
