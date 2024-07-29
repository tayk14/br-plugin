package com.rockstargames.gtacr.gui.fractions;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import androidx.constraintlayout.widget.ConstraintSet;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionsNewRankLayoutBinding;
import blackrussia.online.network.fraction.data.FractionsNewRankRewardItem;
import com.bumptech.glide.Glide;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsMainViewModel;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0006\u0010\u0015\u001a\u00020\u0012R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/UIGetNewRankDialog;", "", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "item", "Lblackrussia/online/network/fraction/data/FractionsNewRankRewardItem;", "mainViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsMainViewModel;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Lblackrussia/online/network/fraction/data/FractionsNewRankRewardItem;Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsMainViewModel;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FractionsNewRankLayoutBinding;", "blockedSpam", "", "dialogNewRank", "Landroid/widget/PopupWindow;", "closeDialog", "", "setData", "setRewardsGone", "showDialog", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIGetNewRankDialog {
    private Animation anim;
    private FractionsNewRankLayoutBinding binding;
    private boolean blockedSpam;
    private final NvEventQueueActivity context;
    private PopupWindow dialogNewRank;
    private final FractionsNewRankRewardItem item;
    private final FractionsMainViewModel mainViewModel;

    public UIGetNewRankDialog(NvEventQueueActivity context, FractionsNewRankRewardItem item, FractionsMainViewModel mainViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(mainViewModel, "mainViewModel");
        this.context = context;
        this.item = item;
        this.mainViewModel = mainViewModel;
        Object systemService = context.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        FractionsNewRankLayoutBinding inflate = FractionsNewRankLayoutBinding.inflate((LayoutInflater) systemService);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        FractionsNewRankLayoutBinding fractionsNewRankLayoutBinding = this.binding;
        Glide.with(fractionsNewRankLayoutBinding.bgEffectShadow).load(Integer.valueOf((int) R.drawable.fractions_new_rank_layout_bg)).into(fractionsNewRankLayoutBinding.bgEffectShadow);
        Glide.with(fractionsNewRankLayoutBinding.bgViewEllipse).load(Integer.valueOf((int) R.drawable.fractions_new_rank_ellipse_bg)).into(fractionsNewRankLayoutBinding.bgViewEllipse);
        Glide.with(fractionsNewRankLayoutBinding.imageViewLavr).load(Integer.valueOf((int) R.drawable.fractions_laurel_ic)).into(fractionsNewRankLayoutBinding.imageViewLavr);
        Glide.with(fractionsNewRankLayoutBinding.ivAward1).load(Integer.valueOf((int) R.drawable.fractions_shop_item_rubles_money_icon_res)).into(fractionsNewRankLayoutBinding.ivAward1);
        Glide.with(fractionsNewRankLayoutBinding.ivAward2).load(Integer.valueOf((int) R.drawable.fractions_money_star_ic)).into(fractionsNewRankLayoutBinding.ivAward2);
        Glide.with(fractionsNewRankLayoutBinding.ivAward3).load(Integer.valueOf((int) R.drawable.fractions_money_box_ic)).into(fractionsNewRankLayoutBinding.ivAward3);
        this.dialogNewRank = new PopupWindow((View) this.binding.getRoot(), -1, -1, false);
        this.binding.buttonGetReward.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIGetNewRankDialog.m298_init_$lambda2(UIGetNewRankDialog.this, view);
            }
        });
        PopupWindow popupWindow = this.dialogNewRank;
        if (popupWindow == null) {
            return;
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public final void onDismiss() {
                UIGetNewRankDialog.m299_init_$lambda3(UIGetNewRankDialog.this);
            }
        });
    }

    public static final void m298_init_$lambda2(UIGetNewRankDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.startAnimation(this$0.anim);
        if (this$0.blockedSpam) {
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                //UIGetNewRankDialog.m301lambda2$lambda1(UIGetNewRankDialog.this);
            }
        }, 250L);
        this$0.blockedSpam = true;
    }

    public static final void m301lambda2$lambda1(UIGetNewRankDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.blockedSpam = false;
        this$0.closeDialog();
    }

    public static final void m299_init_$lambda3(UIGetNewRankDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new Useful().closeAndroidsInterface(this$0.context, this$0.dialogNewRank);
        this$0.mainViewModel.sendButtonPressed(2, 8);
        this$0.mainViewModel.setFractionsNewRankRewardItem(null);
    }

    public final void showDialog() {
        setData();
        PopupWindow popupWindow = this.dialogNewRank;
        if (popupWindow == null) {
            return;
        }
        popupWindow.showAtLocation(this.context.getParentLayout(), 17, 0, 0);
    }

    private final void setData() {
        FractionsNewRankLayoutBinding fractionsNewRankLayoutBinding = this.binding;
        FractionsNewRankRewardItem fractionsNewRankRewardItem = this.item;
        fractionsNewRankLayoutBinding.textViewRank.setText(String.valueOf(fractionsNewRankRewardItem.getNewRank()));
        Glide.with(fractionsNewRankLayoutBinding.imageViewStaffRank).load(Integer.valueOf(fractionsNewRankRewardItem.getNewRankImage())).into(fractionsNewRankLayoutBinding.imageViewStaffRank);
        if (fractionsNewRankRewardItem.getRankReward().get(0).intValue() == 0 || fractionsNewRankRewardItem.getRankReward().get(1).intValue() == 0 || fractionsNewRankRewardItem.getRankReward().get(2).intValue() == 0) {
            setRewardsGone();
            return;
        }
        fractionsNewRankLayoutBinding.textViewReward1.setText(this.context.getString(R.string.fractions_new_rank_award_1, new Object[]{fractionsNewRankRewardItem.getRankReward().get(0)}));
        fractionsNewRankLayoutBinding.textViewReward2.setText(this.context.getString(R.string.fractions_new_rank_award_2, new Object[]{fractionsNewRankRewardItem.getRankReward().get(1)}));
        fractionsNewRankLayoutBinding.textViewReward3.setText(this.context.getString(R.string.fractions_new_rank_award_3, new Object[]{fractionsNewRankRewardItem.getRankReward().get(2)}));
    }

    private final void setRewardsGone() {
        FractionsNewRankLayoutBinding fractionsNewRankLayoutBinding = this.binding;
        fractionsNewRankLayoutBinding.textViewReward1.setVisibility(8);
        fractionsNewRankLayoutBinding.textViewReward2.setVisibility(8);
        fractionsNewRankLayoutBinding.textViewReward3.setVisibility(8);
        fractionsNewRankLayoutBinding.ivAward1.setVisibility(8);
        fractionsNewRankLayoutBinding.ivAward2.setVisibility(8);
        fractionsNewRankLayoutBinding.ivAward3.setVisibility(8);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(fractionsNewRankLayoutBinding.getRoot());
        constraintSet.connect(R.id.button_get_reward, 6, R.id.main_view_new_rank, 6);
        constraintSet.connect(R.id.button_get_reward, 7, R.id.main_view_new_rank, 7);
        constraintSet.applyTo(fractionsNewRankLayoutBinding.getRoot());
    }

    private final void closeDialog() {
        PopupWindow popupWindow = this.dialogNewRank;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }
}
