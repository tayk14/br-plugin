package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionsShopItemBinding;
import com.bumptech.glide.Glide;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FractionsShopAdapter;
import com.rockstargames.gtacr.data.FractionsShopItem;
import com.rockstargames.gtacr.data.FractionsShopList;
import com.rockstargames.gtacr.gui.fractions.FractionsUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\nH\u0016J\u001c\u0010\u0014\u001a\u00020\u000e2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FractionsShopAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/FractionsShopAdapter$FractionsShopViewHolder;", "list", "Lcom/rockstargames/gtacr/data/FractionsShopList;", "activity", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Lcom/rockstargames/gtacr/data/FractionsShopList;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "onItemClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "uniqueId", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FractionsShopViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsShopAdapter extends RecyclerView.Adapter<FractionsShopAdapter.FractionsShopViewHolder> {
    private final NvEventQueueActivity activity;
    private final FractionsShopList list;
    public Function1<? super Integer, Unit> onItemClickListener;

    public FractionsShopAdapter(FractionsShopList list, NvEventQueueActivity activity) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.list = list;
        this.activity = activity;
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

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/rockstargames/gtacr/adapters/FractionsShopAdapter$FractionsShopViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/FractionsShopItemBinding;", "(Lcom/rockstargames/gtacr/adapters/FractionsShopAdapter;Lblackrussia/online/databinding/FractionsShopItemBinding;)V", "getBinding", "()Lblackrussia/online/databinding/FractionsShopItemBinding;", "bind", "", "item", "Lcom/rockstargames/gtacr/data/FractionsShopItem;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FractionsShopViewHolder extends RecyclerView.ViewHolder {
        private final FractionsShopItemBinding binding;
        final FractionsShopAdapter this$0;

        public FractionsShopViewHolder(FractionsShopAdapter this$0, FractionsShopItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final FractionsShopItemBinding getBinding() {
            return this.binding;
        }

        public final void bind(final FractionsShopItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            FractionsShopItemBinding fractionsShopItemBinding = this.binding;
            final FractionsShopAdapter fractionsShopAdapter = this.this$0;
            fractionsShopItemBinding.textViewTitle.setText(item.getBoxName());
            fractionsShopItemBinding.textViewPrice.setText(String.valueOf(item.getBoxPrice()));
            if (item.getRender() == null) {
                if (item.getTypeID() == 3) {
                    Glide.with(fractionsShopItemBinding.imageViewBoxImage).load(Integer.valueOf((int) R.drawable.tuning_icon_box)).into(fractionsShopItemBinding.imageViewBoxImage);
                } else {
                    int objectID = item.getObjectID();
                    if (objectID == 7344) {
                        NvEventQueueActivity nvEventQueueActivity = fractionsShopAdapter.activity;
                        int itemId = item.getItemId();
                        int objectID2 = item.getObjectID();
                        ImageView imageViewBoxImage = fractionsShopItemBinding.imageViewBoxImage;
                        Intrinsics.checkNotNullExpressionValue(imageViewBoxImage, "imageViewBoxImage");
                        FractionsUtilsKt.renderShopItem(nvEventQueueActivity, itemId, objectID2, imageViewBoxImage, item, 20.0f, 180.0f, 0.0f, 0.6f);
                    } else if (objectID == 7374) {
                        NvEventQueueActivity nvEventQueueActivity2 = fractionsShopAdapter.activity;
                        int itemId2 = item.getItemId();
                        int objectID3 = item.getObjectID();
                        ImageView imageViewBoxImage2 = fractionsShopItemBinding.imageViewBoxImage;
                        Intrinsics.checkNotNullExpressionValue(imageViewBoxImage2, "imageViewBoxImage");
                        FractionsUtilsKt.renderShopItem(nvEventQueueActivity2, itemId2, objectID3, imageViewBoxImage2, item, 20.0f, 180.0f, 0.0f, 0.7f);
                    } else if (objectID == 7378) {
                        NvEventQueueActivity nvEventQueueActivity3 = fractionsShopAdapter.activity;
                        int itemId3 = item.getItemId();
                        int objectID4 = item.getObjectID();
                        ImageView imageViewBoxImage3 = fractionsShopItemBinding.imageViewBoxImage;
                        Intrinsics.checkNotNullExpressionValue(imageViewBoxImage3, "imageViewBoxImage");
                        FractionsUtilsKt.renderShopItem(nvEventQueueActivity3, itemId3, objectID4, imageViewBoxImage3, item, 0.0f, 0.0f, 90.0f, 0.6f);
                    } else if (objectID == 7385) {
                        NvEventQueueActivity nvEventQueueActivity4 = fractionsShopAdapter.activity;
                        int itemId4 = item.getItemId();
                        int objectID5 = item.getObjectID();
                        ImageView imageViewBoxImage4 = fractionsShopItemBinding.imageViewBoxImage;
                        Intrinsics.checkNotNullExpressionValue(imageViewBoxImage4, "imageViewBoxImage");
                        FractionsUtilsKt.renderShopItem(nvEventQueueActivity4, itemId4, objectID5, imageViewBoxImage4, item, 45.0f, 90.0f, 70.0f, 0.9f);
                    } else if (objectID == 7387) {
                        NvEventQueueActivity nvEventQueueActivity5 = fractionsShopAdapter.activity;
                        int itemId5 = item.getItemId();
                        int objectID6 = item.getObjectID();
                        ImageView imageViewBoxImage5 = fractionsShopItemBinding.imageViewBoxImage;
                        Intrinsics.checkNotNullExpressionValue(imageViewBoxImage5, "imageViewBoxImage");
                        FractionsUtilsKt.renderShopItem(nvEventQueueActivity5, itemId5, objectID6, imageViewBoxImage5, item, 0.0f, 90.0f, 70.0f, 0.8f);
                    } else if (objectID != 7390) {
                        NvEventQueueActivity nvEventQueueActivity6 = fractionsShopAdapter.activity;
                        int itemId6 = item.getItemId();
                        int objectID7 = item.getObjectID();
                        ImageView imageViewBoxImage6 = fractionsShopItemBinding.imageViewBoxImage;
                        Intrinsics.checkNotNullExpressionValue(imageViewBoxImage6, "imageViewBoxImage");
                        FractionsUtilsKt.renderShopItem(nvEventQueueActivity6, itemId6, objectID7, imageViewBoxImage6, item);
                    } else {
                        NvEventQueueActivity nvEventQueueActivity7 = fractionsShopAdapter.activity;
                        int itemId7 = item.getItemId();
                        int objectID8 = item.getObjectID();
                        ImageView imageViewBoxImage7 = fractionsShopItemBinding.imageViewBoxImage;
                        Intrinsics.checkNotNullExpressionValue(imageViewBoxImage7, "imageViewBoxImage");
                        FractionsUtilsKt.renderShopItem(nvEventQueueActivity7, itemId7, objectID8, imageViewBoxImage7, item, 0.0f, 260.0f, 0.0f, 0.8f);
                    }
                }
            } else {
                fractionsShopItemBinding.imageViewBoxImage.setImageBitmap(item.getRender());
            }
            fractionsShopItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //FractionsShopAdapter.FractionsShopViewHolder.m95bind$lambda1$lambda0(FractionsShopAdapter.this, this, item, view);
                }
            });
        }

        public static final void m95bind$lambda1$lambda0(FractionsShopAdapter this$0, FractionsShopViewHolder this$1, FractionsShopItem item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (this$0.list.getItemClicked() != this$1.getAdapterPosition()) {
                if (this$0.list.getItemClicked() >= 0) {
                    this$0.notifyItemChanged(this$0.list.getItemClicked());
                }
                this$0.list.setItemClicked(this$1.getAdapterPosition());
                this$0.notifyItemChanged(this$1.getAdapterPosition());
                return;
            }
            this$0.getOnItemClickListener().invoke(Integer.valueOf(item.getUniqueId()));
            this$0.list.setItemClicked(-1);
            this$0.notifyItemChanged(this$1.getAdapterPosition());
        }
    }

    @Override
    public FractionsShopViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FractionsShopItemBinding inflate = FractionsShopItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …      false\n            )");
        return new FractionsShopViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(FractionsShopViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.list.getList().get(i));
        if (this.list.getItemClicked() == i) {
            holder.itemView.isSelected();
            holder.itemView.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.fractions_shop_item_selected_bg));
            return;
        }
        holder.itemView.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.fractions_shop_item_bg));
    }

    @Override
    public int getItemCount() {
        return this.list.getList().size();
    }
}
