package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.databinding.FamiliesTopPresentItemBinding;
import com.rockstargames.gtacr.data.FamilyPresent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyTopPresentsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FamilyTopPresentsAdapter$ViewHolder;", "rewardTopList", "", "Lcom/rockstargames/gtacr/data/FamilyPresent;", "(Ljava/util/List;)V", "binding", "Lblackrussia/online/databinding/FamiliesTopPresentItemBinding;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyTopPresentsAdapter extends RecyclerView.Adapter<FamilyTopPresentsAdapter.ViewHolder> {
    private FamiliesTopPresentItemBinding binding;
    private final List<FamilyPresent> rewardTopList;

    public FamilyTopPresentsAdapter(List<FamilyPresent> rewardTopList) {
        Intrinsics.checkNotNullParameter(rewardTopList, "rewardTopList");
        this.rewardTopList = rewardTopList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FamiliesTopPresentItemBinding inflate = FamiliesTopPresentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.rewardTopList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.rewardTopList.size();
    }

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FamilyTopPresentsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FamiliesTopPresentItemBinding;", "(Lblackrussia/online/databinding/FamiliesTopPresentItemBinding;)V", "bind", "", "thisPresent", "Lcom/rockstargames/gtacr/data/FamilyPresent;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final FamiliesTopPresentItemBinding binding;

        public ViewHolder(FamiliesTopPresentItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void bind(FamilyPresent thisPresent) {
            Intrinsics.checkNotNullParameter(thisPresent, "thisPresent");
            FamiliesTopPresentItemBinding familiesTopPresentItemBinding = this.binding;
            familiesTopPresentItemBinding.presentTitle.setText(thisPresent.getThisPresentsName());
            familiesTopPresentItemBinding.presentValue.setText(thisPresent.getThisPresentsValue());
        }
    }
}
