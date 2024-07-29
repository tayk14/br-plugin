package com.rockstargames.gtacr.gui.spawnLocation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.SpawnLocationItemBinding;
import com.bumptech.glide.Glide;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.rockstargames.gtacr.gui.spawnLocation.adapters.SpawnLocationAdapter;
import com.rockstargames.gtacr.gui.spawnLocation.data.SpawnLocationItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u001c\u0010\u0016\u001a\u00020\u000f2\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/rockstargames/gtacr/gui/spawnLocation/adapters/SpawnLocationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/gui/spawnLocation/adapters/SpawnLocationAdapter$SpawnLocationViewHolder;", "listOfItems", "", "Lcom/rockstargames/gtacr/gui/spawnLocation/data/SpawnLocationItem;", "listOfImages", "", "listOfAvailability", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "onItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "itemID", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedItemPosition", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SpawnLocationViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpawnLocationAdapter extends RecyclerView.Adapter<SpawnLocationAdapter.SpawnLocationViewHolder> {
    private final List<Integer> listOfAvailability;
    private final List<Integer> listOfImages;
    private final List<SpawnLocationItem> listOfItems;
    public Function1<? super Integer, Unit> onItemClickListener;
    private int selectedItemPosition;

    public SpawnLocationAdapter(List<SpawnLocationItem> listOfItems, List<Integer> listOfImages, List<Integer> listOfAvailability) {
        Intrinsics.checkNotNullParameter(listOfItems, "listOfItems");
        Intrinsics.checkNotNullParameter(listOfImages, "listOfImages");
        Intrinsics.checkNotNullParameter(listOfAvailability, "listOfAvailability");
        this.listOfItems = listOfItems;
        this.listOfImages = listOfImages;
        this.listOfAvailability = listOfAvailability;
        Iterator<SpawnLocationItem> it = listOfItems.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().getSelected()) {
                break;
            } else {
                i++;
            }
        }
        this.selectedItemPosition = i;
    }

    public final Function1<Integer, Unit> getOnItemClickListener() {
        Function1 function1 = this.onItemClickListener;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onItemClickListener");
        return null;
    }

    public final void setOnItemClickListener(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onItemClickListener = function1;
    }

    //@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/rockstargames/gtacr/gui/spawnLocation/adapters/SpawnLocationAdapter$SpawnLocationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/SpawnLocationItemBinding;", "(Lcom/rockstargames/gtacr/gui/spawnLocation/adapters/SpawnLocationAdapter;Lblackrussia/online/databinding/SpawnLocationItemBinding;)V", "viewSelected", "Landroid/view/View;", "getViewSelected", "()Landroid/view/View;", "setViewSelected", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/rockstargames/gtacr/gui/spawnLocation/data/SpawnLocationItem;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SpawnLocationViewHolder extends RecyclerView.ViewHolder {
        private final SpawnLocationItemBinding binding;
        final SpawnLocationAdapter this$0;
        private View viewSelected;

        public static final void m405bind$lambda3$lambda1(View view) {
        }

        public SpawnLocationViewHolder(SpawnLocationAdapter this$0, SpawnLocationItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
            View view = binding.viewSelection;
            Intrinsics.checkNotNullExpressionValue(view, "binding.viewSelection");
            this.viewSelected = view;
        }

        public final View getViewSelected() {
            return this.viewSelected;
        }

        public final void setViewSelected(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.viewSelected = view;
        }

        public final void bind(final SpawnLocationItem item) {
            Object obj;
            boolean z;
            Intrinsics.checkNotNullParameter(item, "item");
            SpawnLocationItemBinding spawnLocationItemBinding = this.binding;
            final SpawnLocationAdapter spawnLocationAdapter = this.this$0;
            Iterator it = spawnLocationAdapter.listOfAvailability.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Number) obj).intValue() == item.getId()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            }
            if (obj == null) {
                spawnLocationItemBinding.viewSelectionUnavailable.setVisibility(0);
                spawnLocationItemBinding.ivLock.setVisibility(0);
                spawnLocationItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        SpawnLocationViewHolder.m405bind$lambda3$lambda1(view);
                    }
                });
            } else {
                spawnLocationItemBinding.viewSelectionUnavailable.setVisibility(4);
                spawnLocationItemBinding.ivLock.setVisibility(4);
                spawnLocationItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        //SpawnLocationAdapter.SpawnLocationViewHolder.m406bind$lambda3$lambda2(SpawnLocationAdapter.this, this, item, view);
                    }
                });
            }
            spawnLocationItemBinding.textViewPlaceName.setText(item.getPlaceName());
            Glide.with(spawnLocationItemBinding.imageViewPlace).load((Integer) spawnLocationAdapter.listOfImages.get(item.getId())).error((int) R.drawable.spawn_location_res_2).into(spawnLocationItemBinding.imageViewPlace);
        }

        public static final void m406bind$lambda3$lambda2(SpawnLocationAdapter this$0, SpawnLocationViewHolder this$1, SpawnLocationItem item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (this$0.selectedItemPosition != this$1.getAdapterPosition()) {
                ((SpawnLocationItem) this$0.listOfItems.get(this$0.selectedItemPosition)).setSelected(false);
                this$0.notifyItemChanged(this$0.selectedItemPosition);
                this$0.selectedItemPosition = this$1.getAdapterPosition();
                item.setSelected(true);
                this$0.notifyItemChanged(this$0.selectedItemPosition);
                this$0.getOnItemClickListener().invoke(Integer.valueOf(item.getId()));
            }
        }
    }

    @Override
    public SpawnLocationViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SpawnLocationItemBinding inflate = SpawnLocationItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater\n ….context), parent, false)");
        return new SpawnLocationViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(SpawnLocationViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.listOfItems.get(i));
        if (this.listOfItems.get(i).getSelected()) {
            holder.itemView.isSelected();
            holder.getViewSelected().setVisibility(0);
            return;
        }
        holder.getViewSelected().setVisibility(4);
    }

    @Override
    public int getItemCount() {
        return this.listOfItems.size();
    }
}
