package com.rockstargames.gtacr.gui.fractions;

import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionMainMenuLayoutBinding;
import blackrussia.online.network.fraction.data.FractionsProgressStaffItem;
import com.bumptech.glide.Glide;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.FractionsMainMenuProgressAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsMainViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J2\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\b\u0010&\u001a\u00020\u001aH\u0002J,\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020 0\"2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\b\u0010+\u001a\u00020\u001aH\u0002J\b\u0010,\u001a\u00020\u001aH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/UIFractionMainLayout;", "Lcom/rockstargames/gtacr/common/UILayout;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "mainViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsMainViewModel;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsMainViewModel;)V", "_binding", "Lblackrussia/online/databinding/FractionMainMenuLayoutBinding;", "anim", "Landroid/view/animation/Animation;", "binding", "getBinding", "()Lblackrussia/online/databinding/FractionMainMenuLayoutBinding;", "isClickedMainItem", "", "progressAdapter", "Lcom/rockstargames/gtacr/adapters/FractionsMainMenuProgressAdapter;", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "", "onLayoutShown", "setUpData", "fractionsProgressStaffItem", "Lblackrussia/online/network/fraction/data/FractionsProgressStaffItem;", "imageForTasksBackground", "", "listOfImageForAdapter", "", "listOfPositionForAdapter", "", "", "setupButtonClickListeners", "setupProgressAdapter", "item", "listOfImages", "listOfPosition", "setupRecyclerView", "setupTextProgressInOrganisation", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIFractionMainLayout extends UILayout {
    private FractionMainMenuLayoutBinding _binding;
    private Animation anim;
    private final NvEventQueueActivity context;
    private boolean isClickedMainItem;
    private final FractionsMainViewModel mainViewModel;
    private FractionsMainMenuProgressAdapter progressAdapter;

    @Override
    public void onLayoutClose() {
    }

    public UIFractionMainLayout(NvEventQueueActivity context, FractionsMainViewModel mainViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mainViewModel, "mainViewModel");
        this.context = context;
        this.mainViewModel = mainViewModel;
    }

    public final FractionMainMenuLayoutBinding getBinding() {
        FractionMainMenuLayoutBinding fractionMainMenuLayoutBinding = this._binding;
        Intrinsics.checkNotNull(fractionMainMenuLayoutBinding);
        return fractionMainMenuLayoutBinding;
    }

    @Override
    public View getView() {
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FractionMainMenuLayoutBinding.inflate(inflater);
        this.anim = AnimationUtils.loadAnimation(this.context, R.anim.button_click);
        setupRecyclerView();
        setupTextProgressInOrganisation();
        setupButtonClickListeners();
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public void onLayoutShown() {
        GUIManager.hideSystemUI(getBinding().getRoot());
    }

    private final void setupRecyclerView() {
        RecyclerView recyclerView = getBinding().recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(this.progressAdapter);
    }

    public final void setUpData(FractionsProgressStaffItem fractionsProgressStaffItem, int i, List<Integer> listOfImageForAdapter, List<String> listOfPositionForAdapter) {
        Intrinsics.checkNotNullParameter(fractionsProgressStaffItem, "fractionsProgressStaffItem");
        Intrinsics.checkNotNullParameter(listOfImageForAdapter, "listOfImageForAdapter");
        Intrinsics.checkNotNullParameter(listOfPositionForAdapter, "listOfPositionForAdapter");
        Glide.with(getBinding().getRoot().getContext()).load(Integer.valueOf(i)).into(getBinding().imageButtonFractionsTasks);
        setupProgressAdapter(fractionsProgressStaffItem, listOfImageForAdapter, listOfPositionForAdapter);
        int indexOf = fractionsProgressStaffItem.getRankStatus().indexOf(1);
        boolean z = false;
        if (1 <= indexOf && indexOf < 9) {
            z = true;
        }
        if (z) {
            getBinding().recyclerView.scrollToPosition(indexOf - 1);
        } else if (indexOf == 9) {
            getBinding().recyclerView.scrollToPosition(indexOf);
        }
        getBinding().recyclerView.setAdapter(this.progressAdapter);
    }

    private final void setupProgressAdapter(FractionsProgressStaffItem fractionsProgressStaffItem, List<Integer> list, List<String> list2) {
        FractionsMainMenuProgressAdapter fractionsMainMenuProgressAdapter = new FractionsMainMenuProgressAdapter(fractionsProgressStaffItem.getRankStatus(), fractionsProgressStaffItem.getRankProgress(), list, list2);
        fractionsMainMenuProgressAdapter.setOnGetNewRankButtonClickListener(new UIFractionMainLayout$setupProgressAdapter$1$1$1(this));
        this.progressAdapter = fractionsMainMenuProgressAdapter;
    }

    private final void setupTextProgressInOrganisation() {
        SpannableString spannableString = new SpannableString(this.context.getString(R.string.progress_in_organisation));
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.context, R.color.color_FFA61D)), 0, 8, 33);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.context, R.color.white)), 9, spannableString.length(), 33);
        getBinding().textViewProgressInOrganisation.setText(spannableString);
    }

    private final void setupButtonClickListeners() {
        getBinding().imageButtonFractionsTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIFractionMainLayout.m263setupButtonClickListeners$lambda6$lambda5(UIFractionMainLayout.this, view);
            }
        });
    }

    public static final void m263setupButtonClickListeners$lambda6$lambda5(UIFractionMainLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.startAnimation(this$0.anim);
        if (!this$0.isClickedMainItem) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    //UIFractionMainLayout.m264setupButtonClickListeners$lambda6$lambda5$lambda4(UIFractionMainLayout.this);
                }
            }, 250L);
        }
        this$0.isClickedMainItem = true;
    }

    public static final void m264setupButtonClickListeners$lambda6$lambda5$lambda4(UIFractionMainLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isClickedMainItem = false;
        this$0.mainViewModel.sendButtonPressed(1, 6);
    }
}
