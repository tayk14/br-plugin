package com.rockstargames.gtacr.adapters;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.DrivingSchoolRadialMenuInfoItemBinding;
import com.rockstargames.gtacr.data.SignObj;
import com.rockstargames.gtacr.gui.drivingSchool.UIClassInfoLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/rockstargames/gtacr/adapters/DrivingSchoolRadialMenuInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/DrivingSchoolRadialMenuInfoAdapter$ViewHolder;", "radialMenuList", "", "Lcom/rockstargames/gtacr/data/SignObj;", "currentRoot", "Lcom/rockstargames/gtacr/gui/drivingSchool/UIClassInfoLayout;", "(Ljava/util/List;Lcom/rockstargames/gtacr/gui/drivingSchool/UIClassInfoLayout;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DrivingSchoolRadialMenuInfoAdapter extends RecyclerView.Adapter<DrivingSchoolRadialMenuInfoAdapter.ViewHolder> {
    private final UIClassInfoLayout currentRoot;
    private final List<SignObj> radialMenuList;

    public DrivingSchoolRadialMenuInfoAdapter(List<SignObj> radialMenuList, UIClassInfoLayout currentRoot) {
        Intrinsics.checkNotNullParameter(radialMenuList, "radialMenuList");
        Intrinsics.checkNotNullParameter(currentRoot, "currentRoot");
        this.radialMenuList = radialMenuList;
        this.currentRoot = currentRoot;
    }

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/adapters/DrivingSchoolRadialMenuInfoAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/DrivingSchoolRadialMenuInfoItemBinding;", "(Lcom/rockstargames/gtacr/adapters/DrivingSchoolRadialMenuInfoAdapter;Lblackrussia/online/databinding/DrivingSchoolRadialMenuInfoItemBinding;)V", "bind", "", "radialMenuItem", "Lcom/rockstargames/gtacr/data/SignObj;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final DrivingSchoolRadialMenuInfoItemBinding binding;
        final DrivingSchoolRadialMenuInfoAdapter this$0;

        public ViewHolder(DrivingSchoolRadialMenuInfoAdapter this$0, DrivingSchoolRadialMenuInfoItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(SignObj radialMenuItem) {
            Intrinsics.checkNotNullParameter(radialMenuItem, "radialMenuItem");
            DrivingSchoolRadialMenuInfoItemBinding drivingSchoolRadialMenuInfoItemBinding = this.binding;
            DrivingSchoolRadialMenuInfoAdapter drivingSchoolRadialMenuInfoAdapter = this.this$0;
            SpannableString leftSignName = radialMenuItem.getLeftSignName();
            leftSignName.setSpan(new ForegroundColorSpan(ContextCompat.getColor(drivingSchoolRadialMenuInfoAdapter.currentRoot.getContext(), R.color.diving_school_green_text_color)), radialMenuItem.getLeftStartSpan(), leftSignName.length(), 33);
            drivingSchoolRadialMenuInfoItemBinding.iconLeftAction.setImageResource(radialMenuItem.getLeftSignIcon());
            drivingSchoolRadialMenuInfoItemBinding.titleLeftAction.setText(leftSignName);
            drivingSchoolRadialMenuInfoItemBinding.textLeftAction.setText(radialMenuItem.getLeftSignDescription());
            Integer leftPosition = radialMenuItem.getLeftPosition();
            if (leftPosition != null) {
                drivingSchoolRadialMenuInfoItemBinding.numberLeftAction.setText(String.valueOf(leftPosition.intValue()));
            }
            if (radialMenuItem.getRightSignIcon() != null && radialMenuItem.getRightSignName() != null && radialMenuItem.getRightSignDescription() != null && radialMenuItem.getRightStartSpan() != null) {
                SpannableString rightSignName = radialMenuItem.getRightSignName();
                rightSignName.setSpan(new ForegroundColorSpan(ContextCompat.getColor(drivingSchoolRadialMenuInfoAdapter.currentRoot.getContext(), R.color.diving_school_green_text_color)), radialMenuItem.getRightStartSpan().intValue(), rightSignName.length(), 33);
                drivingSchoolRadialMenuInfoItemBinding.iconRightAction.setImageResource(radialMenuItem.getRightSignIcon().intValue());
                drivingSchoolRadialMenuInfoItemBinding.titleRightAction.setText(rightSignName);
                drivingSchoolRadialMenuInfoItemBinding.textRightAction.setText(radialMenuItem.getRightSignDescription());
                Integer rightPosition = radialMenuItem.getRightPosition();
                if (rightPosition != null) {
                    drivingSchoolRadialMenuInfoItemBinding.numberRightAction.setText(String.valueOf(rightPosition.intValue()));
                }
            }
            if (radialMenuItem.getIfShowUnderline()) {
                drivingSchoolRadialMenuInfoItemBinding.dividerHorizontalUnderline.setVisibility(0);
            } else {
                drivingSchoolRadialMenuInfoItemBinding.dividerHorizontalUnderline.setVisibility(8);
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DrivingSchoolRadialMenuInfoItemBinding inflate = DrivingSchoolRadialMenuInfoItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f…           parent, false)");
        return new ViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.radialMenuList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.radialMenuList.size();
    }
}
