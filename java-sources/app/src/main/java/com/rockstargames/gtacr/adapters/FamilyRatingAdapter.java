package com.rockstargames.gtacr.adapters;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesRatingItemBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyRatingAdapter;
import com.rockstargames.gtacr.data.FamilyTopData;
import com.rockstargames.gtacr.gui.Useful;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0019B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\fR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyRatingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FamilyRatingAdapter$ViewHolder;", "familyTopList", "", "Lcom/rockstargames/gtacr/data/FamilyTopData;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Ljava/util/List;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "binding", "Lblackrussia/online/databinding/FamiliesRatingItemBinding;", "getItemCount", "", "getItemId", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCheckOnlyElement", "checkedPosition", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyRatingAdapter extends RecyclerView.Adapter<FamilyRatingAdapter.ViewHolder> {
    private FamiliesRatingItemBinding binding;
    private final NvEventQueueActivity context;
    private final List<FamilyTopData> familyTopList;

    @Override
    public long getItemId(int i) {
        return i;
    }

    public FamilyRatingAdapter(List<FamilyTopData> familyTopList, NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(familyTopList, "familyTopList");
        Intrinsics.checkNotNullParameter(context, "context");
        this.familyTopList = familyTopList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FamiliesRatingItemBinding inflate = FamiliesRatingItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        return new ViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.familyTopList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.familyTopList.size();
    }

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyRatingAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FamiliesRatingItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FamilyRatingAdapter;Lblackrussia/online/databinding/FamiliesRatingItemBinding;)V", "bind", "", "thisFamily", "Lcom/rockstargames/gtacr/data/FamilyTopData;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final FamiliesRatingItemBinding binding;
        final FamilyRatingAdapter this$0;

        public static final void m78bind$lambda1$lambda0(View view) {
        }

        public ViewHolder(FamilyRatingAdapter this$0, FamiliesRatingItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(FamilyTopData thisFamily) {
            Intrinsics.checkNotNullParameter(thisFamily, "thisFamily");
            FamiliesRatingItemBinding familiesRatingItemBinding = this.binding;
            FamilyRatingAdapter familyRatingAdapter = this.this$0;
            familiesRatingItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    ViewHolder.m78bind$lambda1$lambda0(view);
                }
            });
            familiesRatingItemBinding.topPosition.setText(String.valueOf(thisFamily.getPosition()));
            familiesRatingItemBinding.familyNick.setText(thisFamily.getFamilyName());
            familiesRatingItemBinding.familyRep.setText(new Useful().getPriceWithSpacesForInt(thisFamily.getFamilyRep()));
            familiesRatingItemBinding.valueCaptured.setText(new Useful().getPriceWithSpacesForInt(thisFamily.getFamilyGlasses()));
            boolean isClicked = thisFamily.isClicked();
            if (isClicked) {
                if (Build.VERSION.SDK_INT >= 23) {
                    this.binding.getRoot().setBackgroundColor(familyRatingAdapter.context.getResources().getColor(R.color.blue_not_active_switch, null));
                } else {
                    this.binding.getRoot().setBackgroundColor(familyRatingAdapter.context.getResources().getColor(R.color.blue_not_active_switch));
                }
                if (thisFamily.getFamilyType() == 1) {
                    familiesRatingItemBinding.familyIcon.setImageResource(R.drawable.families_sindycate_active_icon_res);
                } else {
                    familiesRatingItemBinding.familyIcon.setImageResource(R.drawable.families_brigade_active_icon_res);
                }
            } else if (!isClicked) {
                if (Build.VERSION.SDK_INT >= 23) {
                    this.binding.getRoot().setBackgroundColor(familyRatingAdapter.context.getResources().getColor(thisFamily.getBackgroundColor(), null));
                } else {
                    this.binding.getRoot().setBackgroundColor(familyRatingAdapter.context.getResources().getColor(thisFamily.getBackgroundColor()));
                }
                if (thisFamily.getFamilyType() == 1) {
                    familiesRatingItemBinding.familyIcon.setImageResource(R.drawable.families_sindycate_not_active_icon_res);
                } else {
                    familiesRatingItemBinding.familyIcon.setImageResource(R.drawable.families_brigade_not_active_icon_res);
                }
            }
            familiesRatingItemBinding.leftIcon.setImageResource(thisFamily.getLeftIcon());
            familiesRatingItemBinding.rightIcon.setImageResource(thisFamily.getRightIcon());
            familiesRatingItemBinding.familyNick.setSelected(true);
            familiesRatingItemBinding.familyRep.setSelected(true);
            familiesRatingItemBinding.valueCaptured.setSelected(true);
        }
    }

    public final void setCheckOnlyElement(int i) {
        int size = this.familyTopList.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (this.familyTopList.get(i2).isClicked() && i2 != i) {
                this.familyTopList.get(i2).setClicked(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }
}
