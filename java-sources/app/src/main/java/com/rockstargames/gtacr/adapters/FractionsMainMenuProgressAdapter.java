package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionProgressInOrganizationItemBinding;
import com.bumptech.glide.Glide;
import com.rockstargames.gtacr.adapters.FractionsMainMenuProgressAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001aB=\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u001c\u0010\u0013\u001a\u00020\r2\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FractionsMainMenuProgressAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FractionsMainMenuProgressAdapter$FractionsMainMenuProgressViewHolder;", "listOfRanks", "", "", "rankProgress", "listOfImages", "listOfPositions", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "onGetNewRankButtonClickListener", "Lkotlin/Function0;", "", "getOnGetNewRankButtonClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnGetNewRankButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FractionsMainMenuProgressViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsMainMenuProgressAdapter extends RecyclerView.Adapter<FractionsMainMenuProgressAdapter.FractionsMainMenuProgressViewHolder> {
    private final List<Integer> listOfImages;
    private final List<String> listOfPositions;
    private final List<Integer> listOfRanks;
    public Function0<Unit> onGetNewRankButtonClickListener;
    private final List<Integer> rankProgress;

    public FractionsMainMenuProgressAdapter(List<Integer> listOfRanks, List<Integer> rankProgress, List<Integer> listOfImages, List<String> listOfPositions) {
        Intrinsics.checkNotNullParameter(listOfRanks, "listOfRanks");
        Intrinsics.checkNotNullParameter(rankProgress, "rankProgress");
        Intrinsics.checkNotNullParameter(listOfImages, "listOfImages");
        Intrinsics.checkNotNullParameter(listOfPositions, "listOfPositions");
        this.listOfRanks = listOfRanks;
        this.rankProgress = rankProgress;
        this.listOfImages = listOfImages;
        this.listOfPositions = listOfPositions;
    }

    public final Function0<Unit> getOnGetNewRankButtonClickListener() {
        Function0<Unit> function0 = this.onGetNewRankButtonClickListener;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onGetNewRankButtonClickListener");
        return null;
    }

    public final void setOnGetNewRankButtonClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onGetNewRankButtonClickListener = function0;
    }

    //@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J.\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J\u001e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J&\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FractionsMainMenuProgressAdapter$FractionsMainMenuProgressViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FractionProgressInOrganizationItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FractionsMainMenuProgressAdapter;Lblackrussia/online/databinding/FractionProgressInOrganizationItemBinding;)V", "anim", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "getBinding", "()Lblackrussia/online/databinding/FractionProgressInOrganizationItemBinding;", "bind", "", "rankStatus", "", "rankProgress", "", "image", "workPosition", "", "setupItem", "setupRankActual", "setupRankAvailable", "setupRankNext", "setupRankReceived", "setupRankStatus", "setupRankUnavailable", "setupRankUnavailableContactTheLeader", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FractionsMainMenuProgressViewHolder extends RecyclerView.ViewHolder {
        private final Animation anim;
        private final FractionProgressInOrganizationItemBinding binding;
        final FractionsMainMenuProgressAdapter this$0;

        public FractionsMainMenuProgressViewHolder(FractionsMainMenuProgressAdapter this$0, FractionProgressInOrganizationItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
            this.anim = AnimationUtils.loadAnimation(binding.getRoot().getContext(), R.anim.button_click);
        }

        public final FractionProgressInOrganizationItemBinding getBinding() {
            return this.binding;
        }

        public final void bind(int i, List<Integer> rankProgress, int i2, String workPosition) {
            Intrinsics.checkNotNullParameter(rankProgress, "rankProgress");
            Intrinsics.checkNotNullParameter(workPosition, "workPosition");
            this.binding.textViewStaffLevel.setText(String.valueOf(getAdapterPosition() + 1));
            switch (getLayoutPosition()) {
                case 0:
                    setupItem(i2, workPosition, i, rankProgress);
                    break;
                case 1:
                    setupItem(i2, workPosition, i, rankProgress);
                    break;
                case 2:
                    setupItem(i2, workPosition, i, rankProgress);
                    break;
                case 3:
                    setupItem(i2, workPosition, i, rankProgress);
                    break;
                case 4:
                    setupItem(i2, workPosition, i, rankProgress);
                    break;
                case 5:
                    setupItem(i2, workPosition, i, rankProgress);
                    break;
                case 6:
                    setupItem(i2, workPosition, i, rankProgress);
                    break;
                case 7:
                    setupItem(i2, workPosition, i, rankProgress);
                    break;
                case 8:
                    setupItem(i2, workPosition, i, rankProgress);
                    break;
                case 9:
                    setupItem(i2, workPosition, i, rankProgress);
                    break;
            }
            Button button = this.binding.imageButtonGetNewRank;
            final FractionsMainMenuProgressAdapter fractionsMainMenuProgressAdapter = this.this$0;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    FractionsMainMenuProgressViewHolder.m93bind$lambda0(FractionsMainMenuProgressViewHolder.this, fractionsMainMenuProgressAdapter, view);
                }
            });
        }

        public static final void m93bind$lambda0(FractionsMainMenuProgressViewHolder this$0, FractionsMainMenuProgressAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            view.startAnimation(this$0.anim);
            this$1.getOnGetNewRankButtonClickListener().invoke();
        }

        private final void setupItem(int i, String str, int i2, List<Integer> list) {
            FractionProgressInOrganizationItemBinding fractionProgressInOrganizationItemBinding = this.binding;
            Glide.with(getBinding().getRoot().getContext()).load(Integer.valueOf(i)).into(fractionProgressInOrganizationItemBinding.imageViewStaff);
            fractionProgressInOrganizationItemBinding.textViewStaffName.setText(str);
            setupRankStatus(fractionProgressInOrganizationItemBinding, i2, list);
        }

        private final void setupRankUnavailable(FractionProgressInOrganizationItemBinding fractionProgressInOrganizationItemBinding) {
            fractionProgressInOrganizationItemBinding.viewRankStatusReceived.setVisibility(0);
            fractionProgressInOrganizationItemBinding.viewRankStatusReceive.setVisibility(4);
            fractionProgressInOrganizationItemBinding.imageButtonGetNewRank.setVisibility(4);
            fractionProgressInOrganizationItemBinding.progressBarStaffExperience.setProgress(0);
            fractionProgressInOrganizationItemBinding.textViewRankUnavailableContactLeader.setVisibility(4);
            TextView textView = fractionProgressInOrganizationItemBinding.textViewRankStatus;
            textView.setText(R.string.fractions_staff_rank_unavailable);
            textView.setVisibility(0);
            fractionProgressInOrganizationItemBinding.iconFractionsProgressExperience.setVisibility(4);
            fractionProgressInOrganizationItemBinding.tvFractionsExperienceFromTo.setVisibility(4);
        }

        private final void setupRankActual(FractionProgressInOrganizationItemBinding fractionProgressInOrganizationItemBinding, List<Integer> list) {
            fractionProgressInOrganizationItemBinding.viewRankStatusReceived.setVisibility(4);
            fractionProgressInOrganizationItemBinding.viewRankStatusReceive.setVisibility(4);
            fractionProgressInOrganizationItemBinding.imageButtonGetNewRank.setVisibility(4);
            fractionProgressInOrganizationItemBinding.textViewRankUnavailableContactLeader.setVisibility(4);
            fractionProgressInOrganizationItemBinding.textViewRankStatus.setVisibility(4);
            if (list.get(1).intValue() > 0) {
                fractionProgressInOrganizationItemBinding.tvFractionsExperienceFromTo.setVisibility(0);
                fractionProgressInOrganizationItemBinding.iconFractionsProgressExperience.setVisibility(0);
                double intValue = list.get(0).intValue();
                double intValue2 = list.get(1).intValue();
                Double.isNaN(intValue);
                Double.isNaN(intValue2);
                fractionProgressInOrganizationItemBinding.progressBarStaffExperience.setProgress((int) ((intValue / intValue2) * 100.0d));
                fractionProgressInOrganizationItemBinding.tvFractionsExperienceFromTo.setText(fractionProgressInOrganizationItemBinding.getRoot().getContext().getString(R.string.fractions_experience_from_to, list.get(0), list.get(1)));
                return;
            }
            fractionProgressInOrganizationItemBinding.iconFractionsProgressExperience.setVisibility(4);
            fractionProgressInOrganizationItemBinding.tvFractionsExperienceFromTo.setVisibility(4);
            fractionProgressInOrganizationItemBinding.progressBarStaffExperience.setProgress(100);
        }

        private final void setupRankNext(FractionProgressInOrganizationItemBinding fractionProgressInOrganizationItemBinding) {
            fractionProgressInOrganizationItemBinding.viewRankStatusReceived.setVisibility(0);
            fractionProgressInOrganizationItemBinding.viewRankStatusReceive.setVisibility(4);
            fractionProgressInOrganizationItemBinding.imageButtonGetNewRank.setVisibility(4);
            fractionProgressInOrganizationItemBinding.progressBarStaffExperience.setProgress(0);
            fractionProgressInOrganizationItemBinding.textViewRankUnavailableContactLeader.setVisibility(4);
            TextView textView = fractionProgressInOrganizationItemBinding.textViewRankStatus;
            textView.setText(R.string.fractions_staff_rank_next);
            textView.setVisibility(0);
            fractionProgressInOrganizationItemBinding.iconFractionsProgressExperience.setVisibility(4);
            fractionProgressInOrganizationItemBinding.tvFractionsExperienceFromTo.setVisibility(4);
        }

        private final void setupRankAvailable(FractionProgressInOrganizationItemBinding fractionProgressInOrganizationItemBinding) {
            fractionProgressInOrganizationItemBinding.viewRankStatusReceived.setVisibility(0);
            fractionProgressInOrganizationItemBinding.viewRankStatusReceive.setVisibility(0);
            fractionProgressInOrganizationItemBinding.imageButtonGetNewRank.setVisibility(0);
            fractionProgressInOrganizationItemBinding.progressBarStaffExperience.setProgress(0);
            fractionProgressInOrganizationItemBinding.textViewRankUnavailableContactLeader.setVisibility(4);
            TextView textView = fractionProgressInOrganizationItemBinding.textViewRankStatus;
            textView.setText(R.string.fractions_staff_rank_next);
            textView.setVisibility(0);
            fractionProgressInOrganizationItemBinding.iconFractionsProgressExperience.setVisibility(4);
            fractionProgressInOrganizationItemBinding.tvFractionsExperienceFromTo.setVisibility(4);
        }

        private final void setupRankReceived(FractionProgressInOrganizationItemBinding fractionProgressInOrganizationItemBinding) {
            fractionProgressInOrganizationItemBinding.viewRankStatusReceived.setVisibility(0);
            fractionProgressInOrganizationItemBinding.viewRankStatusReceive.setVisibility(4);
            fractionProgressInOrganizationItemBinding.imageButtonGetNewRank.setVisibility(4);
            fractionProgressInOrganizationItemBinding.progressBarStaffExperience.setProgress(100);
            fractionProgressInOrganizationItemBinding.textViewRankUnavailableContactLeader.setVisibility(4);
            TextView textView = fractionProgressInOrganizationItemBinding.textViewRankStatus;
            textView.setText(R.string.fractions_staff_rank_received);
            textView.setVisibility(0);
            fractionProgressInOrganizationItemBinding.iconFractionsProgressExperience.setVisibility(4);
            fractionProgressInOrganizationItemBinding.tvFractionsExperienceFromTo.setVisibility(4);
        }

        private final void setupRankUnavailableContactTheLeader(FractionProgressInOrganizationItemBinding fractionProgressInOrganizationItemBinding) {
            fractionProgressInOrganizationItemBinding.viewRankStatusReceived.setVisibility(0);
            fractionProgressInOrganizationItemBinding.viewRankStatusReceive.setVisibility(4);
            fractionProgressInOrganizationItemBinding.imageButtonGetNewRank.setVisibility(4);
            fractionProgressInOrganizationItemBinding.progressBarStaffExperience.setProgress(0);
            fractionProgressInOrganizationItemBinding.textViewRankUnavailableContactLeader.setVisibility(0);
            TextView textView = fractionProgressInOrganizationItemBinding.textViewRankStatus;
            textView.setText(R.string.fractions_staff_rank_unavailable);
            textView.setVisibility(0);
            fractionProgressInOrganizationItemBinding.iconFractionsProgressExperience.setVisibility(4);
            fractionProgressInOrganizationItemBinding.tvFractionsExperienceFromTo.setVisibility(4);
        }

        private final void setupRankStatus(FractionProgressInOrganizationItemBinding fractionProgressInOrganizationItemBinding, int i, List<Integer> list) {
            if (i == 0) {
                setupRankUnavailable(fractionProgressInOrganizationItemBinding);
            } else if (i == 1) {
                setupRankActual(fractionProgressInOrganizationItemBinding, list);
            } else if (i == 2) {
                setupRankNext(fractionProgressInOrganizationItemBinding);
            } else if (i == 3) {
                setupRankAvailable(fractionProgressInOrganizationItemBinding);
            } else if (i == 4) {
                setupRankReceived(fractionProgressInOrganizationItemBinding);
            } else if (i != 5) {
            } else {
                setupRankUnavailableContactTheLeader(fractionProgressInOrganizationItemBinding);
            }
        }
    }

    @Override
    public FractionsMainMenuProgressViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FractionProgressInOrganizationItemBinding inflate = FractionProgressInOrganizationItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …      false\n            )");
        return new FractionsMainMenuProgressViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(FractionsMainMenuProgressViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if ((!this.listOfRanks.isEmpty()) && (!this.listOfImages.isEmpty()) && (!this.listOfPositions.isEmpty()) && (!this.rankProgress.isEmpty())) {
            holder.bind(this.listOfRanks.get(i).intValue(), this.rankProgress, this.listOfImages.get(i).intValue(), this.listOfPositions.get(i));
            return;
        }
        Toast.makeText(holder.getBinding().getRoot().getContext(), "Error: List in Adapter is empty", 1).show();
    }

    @Override
    public int getItemCount() {
        return this.listOfRanks.size();
    }
}
