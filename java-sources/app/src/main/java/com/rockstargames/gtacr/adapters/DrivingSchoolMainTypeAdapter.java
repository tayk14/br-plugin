package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.DrivingSchoolMainItemBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.DrivingSchoolMainTypeAdapter;
import com.rockstargames.gtacr.data.DrivingMainType;
import com.rockstargames.gtacr.gui.Useful;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fBr\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012S\u0010\b\u001aO\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tj\u0004\u0018\u0001`\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\rH\u0016J\u001c\u0010\u0017\u001a\u00020\u00112\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R[\u0010\b\u001aO\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tj\u0004\u0018\u0001`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/rockstargames/gtacr/adapters/DrivingSchoolMainTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/DrivingSchoolMainTypeAdapter$ViewHolder;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "schoolsTypes", "", "Lcom/rockstargames/gtacr/data/DrivingMainType;", "mainTypeSchoolClickListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "", "position", "Landroid/view/View;", "view", "", "Lcom/rockstargames/gtacr/gui/drivingSchool/OnMainTypeSchoolClickListener;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "invisible", "visible", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnlyItemCheck", "thisPosition", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DrivingSchoolMainTypeAdapter extends RecyclerView.Adapter<DrivingSchoolMainTypeAdapter.ViewHolder> {
    private final NvEventQueueActivity context;
    private final int invisible;
    private final Function3<DrivingMainType, Integer, View, Unit> mainTypeSchoolClickListener;
    private final List<DrivingMainType> schoolsTypes;
    private int visible;

    public DrivingSchoolMainTypeAdapter(NvEventQueueActivity nvEventQueueActivity, List<DrivingMainType> schoolsTypes, Function3<? super DrivingMainType, ? super Integer, ? super View, Unit> function3) {
        Intrinsics.checkNotNullParameter(schoolsTypes, "schoolsTypes");
        this.context = nvEventQueueActivity;
        this.schoolsTypes = schoolsTypes;
        this.mainTypeSchoolClickListener = (Function3<DrivingMainType, Integer, View, Unit>) function3;
        this.invisible = 4;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DrivingSchoolMainItemBinding inflate = DrivingSchoolMainItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f…           parent, false)");
        return new ViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.schoolsTypes.get(i));
    }

    @Override
    public int getItemCount() {
        return this.schoolsTypes.size();
    }

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/adapters/DrivingSchoolMainTypeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/DrivingSchoolMainItemBinding;", "(Lcom/rockstargames/gtacr/adapters/DrivingSchoolMainTypeAdapter;Lblackrussia/online/databinding/DrivingSchoolMainItemBinding;)V", "bind", "", "typeSchool", "Lcom/rockstargames/gtacr/data/DrivingMainType;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final DrivingSchoolMainItemBinding binding;
        final DrivingSchoolMainTypeAdapter this$0;

        public ViewHolder(DrivingSchoolMainTypeAdapter this$0, DrivingSchoolMainItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final DrivingMainType typeSchool) {
            Intrinsics.checkNotNullParameter(typeSchool, "typeSchool");
            DrivingSchoolMainItemBinding drivingSchoolMainItemBinding = this.binding;
            final DrivingSchoolMainTypeAdapter drivingSchoolMainTypeAdapter = this.this$0;
            drivingSchoolMainItemBinding.titleMainItem.setText(typeSchool.getName());
            drivingSchoolMainItemBinding.drivingSchoolValuePrice.setText(GUIManager.getPriceWithSpaces(typeSchool.getPrice()));
            drivingSchoolMainItemBinding.iconDrivingSchool.setImageDrawable(new Useful().getDrawableByName(typeSchool.getImage(), drivingSchoolMainTypeAdapter.context));
            int isUnBlock = typeSchool.isUnBlock();
            if (isUnBlock == 0) {
                drivingSchoolMainItemBinding.bgMaskDrivingSchool.setVisibility(drivingSchoolMainTypeAdapter.visible);
                drivingSchoolMainItemBinding.iconIfNoActiveDrivingSchool.setVisibility(drivingSchoolMainTypeAdapter.visible);
                drivingSchoolMainItemBinding.textIfNotActualDrivingSchool.setText("Недостаточно\nсредств");
                drivingSchoolMainItemBinding.textIfNotActualDrivingSchool.setVisibility(drivingSchoolMainTypeAdapter.visible);
            } else if (isUnBlock == 1) {
                drivingSchoolMainItemBinding.bgMaskDrivingSchool.setVisibility(drivingSchoolMainTypeAdapter.invisible);
                drivingSchoolMainItemBinding.iconIfNoActiveDrivingSchool.setVisibility(drivingSchoolMainTypeAdapter.invisible);
                drivingSchoolMainItemBinding.textIfNotActualDrivingSchool.setVisibility(drivingSchoolMainTypeAdapter.invisible);
            } else if (isUnBlock == 2) {
                drivingSchoolMainItemBinding.bgMaskDrivingSchool.setVisibility(drivingSchoolMainTypeAdapter.visible);
                drivingSchoolMainItemBinding.iconIfNoActiveDrivingSchool.setVisibility(drivingSchoolMainTypeAdapter.visible);
                drivingSchoolMainItemBinding.textIfNotActualDrivingSchool.setText("Уже имеется");
                drivingSchoolMainItemBinding.textIfNotActualDrivingSchool.setVisibility(drivingSchoolMainTypeAdapter.visible);
            }
            if (!typeSchool.isCheck()) {
                NvEventQueueActivity nvEventQueueActivity = drivingSchoolMainTypeAdapter.context;
                if (nvEventQueueActivity != null) {
                    drivingSchoolMainItemBinding.drivingSchoolBg.setBackground(ResourcesCompat.getDrawable(nvEventQueueActivity.getResources(), R.drawable.driving_school_not_active_main_item_bg, null));
                    drivingSchoolMainItemBinding.drivingSchoolMainItem.setBackground(ResourcesCompat.getDrawable(nvEventQueueActivity.getResources(), R.drawable.driving_school_bg_not_active_main_item, null));
                }
                drivingSchoolMainItemBinding.bgPrice.setVisibility(4);
            } else {
                NvEventQueueActivity nvEventQueueActivity2 = drivingSchoolMainTypeAdapter.context;
                if (nvEventQueueActivity2 != null) {
                    drivingSchoolMainItemBinding.drivingSchoolBg.setBackground(ResourcesCompat.getDrawable(nvEventQueueActivity2.getResources(), R.drawable.driving_school_active_main_item_bg, null));
                    drivingSchoolMainItemBinding.drivingSchoolMainItem.setBackground(ResourcesCompat.getDrawable(nvEventQueueActivity2.getResources(), R.drawable.driving_school_bg_active_main_item, null));
                }
                drivingSchoolMainItemBinding.bgPrice.setVisibility(0);
            }
            drivingSchoolMainItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //DrivingSchoolMainTypeAdapter.ViewHolder.m53bind$lambda3$lambda2(this$0, typeSchool, this, view);
                }
            });
        }

        public static final void m53bind$lambda3$lambda2(DrivingSchoolMainTypeAdapter this$0, DrivingMainType typeSchool, ViewHolder this$1, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(typeSchool, "$typeSchool");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Function3 function3 = this$0.mainTypeSchoolClickListener;
            if (function3 == null) {
                return;
            }
            Integer valueOf = Integer.valueOf(this$1.getLayoutPosition());
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function3.invoke(typeSchool, valueOf, it);
        }
    }

    public final void setOnlyItemCheck(int i) {
        int size = this.schoolsTypes.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (i2 != i && this.schoolsTypes.get(i2).isCheck()) {
                this.schoolsTypes.get(i2).setCheck(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }
}
