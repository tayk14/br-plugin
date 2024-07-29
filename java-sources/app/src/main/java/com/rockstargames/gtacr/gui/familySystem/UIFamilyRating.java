package com.rockstargames.gtacr.gui.familySystem;

import android.os.Handler;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesRatingLayoutBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyRatingAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.FamilyTopData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J,\u0010\u001e\u001a\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000e2\u0006\u0010#\u001a\u00020 H\u0002J4\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000e2\u0006\u0010#\u001a\u00020 H\u0007J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020 H\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020 H\u0002J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020 H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/UIFamilyRating;", "Lcom/rockstargames/gtacr/common/UILayout;", "mainRoot", "Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Lcom/rockstargames/gtacr/gui/familySystem/GUIFamilySystem;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesRatingLayoutBinding;", "familyTopAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyRatingAdapter;", "familyTopList", "", "Lcom/rockstargames/gtacr/data/FamilyTopData;", "myFamilyTopAdapter", "myFamilyTopList", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "", "onLayoutShown", "setCurrentFamilyTop", "setDataInTopList", "setListOfOtherFamilies", "otherFamiliesTopValues", "", "otherFamiliesTopNames", "Landroid/text/Spanned;", "myRating", "setStartParameters", "myFamily", "setVisibleFirstPosition", "valueOfVisible", "setVisibleOtherPosition", "setVisibleTopBlock", "isFirstThreePositions", "", "updateMainTopStatus", "thisPosition", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIFamilyRating extends UILayout {
    private Animation anim;
    private FamiliesRatingLayoutBinding binding;
    private final NvEventQueueActivity context;
    private FamilyRatingAdapter familyTopAdapter;
    private final List<FamilyTopData> familyTopList;
    private final GUIFamilySystem mainRoot;
    private FamilyRatingAdapter myFamilyTopAdapter;
    private final List<FamilyTopData> myFamilyTopList;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIFamilyRating(GUIFamilySystem mainRoot, NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainRoot = mainRoot;
        this.context = context;
        this.familyTopList = new ArrayList();
        this.myFamilyTopList = new ArrayList();
    }

    public final void setStartParameters(FamilyTopData myFamily, List<Integer> otherFamiliesTopValues, List<Spanned> otherFamiliesTopNames, int i) {
        Intrinsics.checkNotNullParameter(myFamily, "myFamily");
        Intrinsics.checkNotNullParameter(otherFamiliesTopValues, "otherFamiliesTopValues");
        Intrinsics.checkNotNullParameter(otherFamiliesTopNames, "otherFamiliesTopNames");
        List<FamilyTopData> list = this.myFamilyTopList;
        list.clear();
        list.add(myFamily);
        updateMainTopStatus(this.myFamilyTopList.get(0).getPosition());
        this.familyTopList.clear();
        setListOfOtherFamilies(otherFamiliesTopValues, otherFamiliesTopNames, i);
        FamilyRatingAdapter familyRatingAdapter = this.familyTopAdapter;
        FamilyRatingAdapter familyRatingAdapter2 = null;
        if (familyRatingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("familyTopAdapter");
            familyRatingAdapter = null;
        }
        familyRatingAdapter.notifyDataSetChanged();
        FamilyRatingAdapter familyRatingAdapter3 = this.myFamilyTopAdapter;
        if (familyRatingAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myFamilyTopAdapter");
        } else {
            familyRatingAdapter2 = familyRatingAdapter3;
        }
        familyRatingAdapter2.notifyDataSetChanged();
    }

    private final void setListOfOtherFamilies(List<Integer> list, List<Spanned> list2, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i6 = 0;
        int i7 = 1;
        int i8 = 2;
        while (i6 < list.size() - 1) {
            arrayList.add(list.get(i6));
            arrayList2.add(list.get(i7));
            arrayList3.add(list.get(i8));
            i6 += 3;
            i7 += 3;
            i8 += 3;
        }
        if (arrayList.size() == arrayList2.size() && arrayList.size() == arrayList3.size() && arrayList.size() == list2.size()) {
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                int i10 = i9 + 1;
                if (i10 == 1) {
                    i2 = R.drawable.entertainment_system_top_1_left_res;
                    i3 = R.drawable.entertainment_system_top_1_right_res;
                } else if (i10 == 2) {
                    i2 = R.drawable.entertainment_system_top_2_left_res;
                    i3 = R.drawable.entertainment_system_top_2_right_res;
                } else if (i10 != 3) {
                    i2 = 0;
                    i3 = 0;
                } else {
                    i2 = R.drawable.entertainment_system_top_3_left_res;
                    i3 = R.drawable.entertainment_system_top_3_right_res;
                }
                if (i10 % 2 == 0) {
                    i4 = i;
                    i5 = R.color.color_333548;
                } else {
                    i4 = i;
                    i5 = R.color.color_252736;
                }
                if (i10 == i4) {
                    this.familyTopList.add(new FamilyTopData(i10, list2.get(i9), ((Number) arrayList3.get(i9)).intValue(), ((Number) arrayList.get(i9)).intValue(), ((Number) arrayList2.get(i9)).intValue(), i5, i2, i3, false, true, 256, null));
                } else {
                    this.familyTopList.add(new FamilyTopData(i10, list2.get(i9), ((Number) arrayList3.get(i9)).intValue(), ((Number) arrayList.get(i9)).intValue(), ((Number) arrayList2.get(i9)).intValue(), i5, i2, i3, false, false, 256, null));
                }
                i9 = i10;
            }
        }
    }

    @Override
    public View getView() {
        FamiliesRatingLayoutBinding familiesRatingLayoutBinding = this.binding;
        if (familiesRatingLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesRatingLayoutBinding = null;
        }
        ConstraintLayout root = familiesRatingLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FamiliesRatingLayoutBinding inflate = FamiliesRatingLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        FamiliesRatingLayoutBinding familiesRatingLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        setDataInTopList();
        setCurrentFamilyTop();
        FamiliesRatingLayoutBinding familiesRatingLayoutBinding2 = this.binding;
        if (familiesRatingLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesRatingLayoutBinding2 = null;
        }
        familiesRatingLayoutBinding2.buttonTopPrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIFamilyRating.m196onCreateView$lambda3(UIFamilyRating.this, view);
            }
        });
        FamiliesRatingLayoutBinding familiesRatingLayoutBinding3 = this.binding;
        if (familiesRatingLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesRatingLayoutBinding = familiesRatingLayoutBinding3;
        }
        ConstraintLayout root = familiesRatingLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public static final void m196onCreateView$lambda3(UIFamilyRating this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                //UIFamilyRating.m197onCreateView$lambda3$lambda2(UIFamilyRating.this);
            }
        }, 250L);
    }

    public static final void m197onCreateView$lambda3$lambda2(UIFamilyRating this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mainRoot.listenerLayout(2);
    }

    private final void setDataInTopList() {
        FamilyRatingAdapter familyRatingAdapter = new FamilyRatingAdapter(this.familyTopList, this.context);
        this.familyTopAdapter = familyRatingAdapter;
        FamilyRatingAdapter familyRatingAdapter2 = null;
        if (familyRatingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("familyTopAdapter");
            familyRatingAdapter = null;
        }
        familyRatingAdapter.setHasStableIds(true);
        FamiliesRatingLayoutBinding familiesRatingLayoutBinding = this.binding;
        if (familiesRatingLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesRatingLayoutBinding = null;
        }
        RecyclerView recyclerView = familiesRatingLayoutBinding.familyTop;
        FamiliesRatingLayoutBinding familiesRatingLayoutBinding2 = this.binding;
        if (familiesRatingLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesRatingLayoutBinding2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesRatingLayoutBinding2.getRoot().getContext(), 1, false));
        FamilyRatingAdapter familyRatingAdapter3 = this.familyTopAdapter;
        if (familyRatingAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("familyTopAdapter");
        } else {
            familyRatingAdapter2 = familyRatingAdapter3;
        }
        recyclerView.setAdapter(familyRatingAdapter2);
        recyclerView.setItemViewCacheSize(20);
    }

    private final void setCurrentFamilyTop() {
        this.myFamilyTopAdapter = new FamilyRatingAdapter(this.myFamilyTopList, this.context);
        FamiliesRatingLayoutBinding familiesRatingLayoutBinding = this.binding;
        FamilyRatingAdapter familyRatingAdapter = null;
        if (familiesRatingLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesRatingLayoutBinding = null;
        }
        RecyclerView recyclerView = familiesRatingLayoutBinding.currentFamily;
        FamiliesRatingLayoutBinding familiesRatingLayoutBinding2 = this.binding;
        if (familiesRatingLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesRatingLayoutBinding2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesRatingLayoutBinding2.getRoot().getContext(), 1, false));
        FamilyRatingAdapter familyRatingAdapter2 = this.myFamilyTopAdapter;
        if (familyRatingAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myFamilyTopAdapter");
        } else {
            familyRatingAdapter = familyRatingAdapter2;
        }
        recyclerView.setAdapter(familyRatingAdapter);
    }

    private final void updateMainTopStatus(int i) {
        FamiliesRatingLayoutBinding familiesRatingLayoutBinding = null;
        if (i == 1) {
            setVisibleTopBlock(true);
            FamiliesRatingLayoutBinding familiesRatingLayoutBinding2 = this.binding;
            if (familiesRatingLayoutBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                familiesRatingLayoutBinding = familiesRatingLayoutBinding2;
            }
            familiesRatingLayoutBinding.topIcon.setImageResource(R.drawable.entertainment_system_top_1_res);
        } else if (i == 2) {
            setVisibleTopBlock(true);
            FamiliesRatingLayoutBinding familiesRatingLayoutBinding3 = this.binding;
            if (familiesRatingLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                familiesRatingLayoutBinding = familiesRatingLayoutBinding3;
            }
            familiesRatingLayoutBinding.topIcon.setImageResource(R.drawable.entertainment_system_top_2_res);
        } else if (i == 3) {
            setVisibleTopBlock(true);
            FamiliesRatingLayoutBinding familiesRatingLayoutBinding4 = this.binding;
            if (familiesRatingLayoutBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                familiesRatingLayoutBinding = familiesRatingLayoutBinding4;
            }
            familiesRatingLayoutBinding.topIcon.setImageResource(R.drawable.entertainment_system_top_3_res);
        } else {
            setVisibleTopBlock(false);
            FamiliesRatingLayoutBinding familiesRatingLayoutBinding5 = this.binding;
            if (familiesRatingLayoutBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                familiesRatingLayoutBinding = familiesRatingLayoutBinding5;
            }
            familiesRatingLayoutBinding.valueOtherTop.setText(this.context.getString(R.string.entertainment_system_value_other_top, new Object[]{String.valueOf(i)}));
        }
    }

    private final void setVisibleTopBlock(boolean z) {
        if (z) {
            setVisibleFirstPosition(0);
            setVisibleOtherPosition(4);
            return;
        }
        setVisibleFirstPosition(4);
        setVisibleOtherPosition(0);
    }

    private final void setVisibleFirstPosition(int i) {
        FamiliesRatingLayoutBinding familiesRatingLayoutBinding = this.binding;
        if (familiesRatingLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesRatingLayoutBinding = null;
        }
        familiesRatingLayoutBinding.topIcon.setVisibility(i);
        familiesRatingLayoutBinding.titleRating.setVisibility(i);
    }

    private final void setVisibleOtherPosition(int i) {
        FamiliesRatingLayoutBinding familiesRatingLayoutBinding = this.binding;
        if (familiesRatingLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesRatingLayoutBinding = null;
        }
        familiesRatingLayoutBinding.titleOtherTop.setVisibility(i);
        familiesRatingLayoutBinding.otherTopIcon.setVisibility(i);
        familiesRatingLayoutBinding.valueOtherTop.setVisibility(i);
        familiesRatingLayoutBinding.titleRatingOther.setVisibility(i);
    }
}
