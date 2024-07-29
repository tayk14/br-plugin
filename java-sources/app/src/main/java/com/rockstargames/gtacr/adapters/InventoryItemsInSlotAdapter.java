package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.databinding.InventoryItemInSlotBinding;
import blackrussia.online.network.InvItems;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.InventoryItemsInSlotAdapter;
import com.rockstargames.gtacr.gui.Useful;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

//@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fBa\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012:\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u001c\u0010\u0017\u001a\u00020\r2\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000bR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/rockstargames/gtacr/adapters/InventoryItemsInSlotAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/InventoryItemsInSlotAdapter$ViewHolder;", "itemsList", "", "Lblackrussia/online/network/InvItems;", "itemsClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "", "position", "", "Lcom/rockstargames/gtacr/gui/inventory/OnItemsClickListener;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "isInventory", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lcom/nvidia/devtech/NvEventQueueActivity;Z)V", "binding", "Lblackrussia/online/databinding/InventoryItemInSlotBinding;", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCheckOnlyElement", "checkedPosition", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InventoryItemsInSlotAdapter extends RecyclerView.Adapter<InventoryItemsInSlotAdapter.ViewHolder> {
    private InventoryItemInSlotBinding binding;
    private final NvEventQueueActivity context;
    private final boolean isInventory;
    private final Function2<InvItems, Integer, Unit> itemsClickListener;
    private final List<InvItems> itemsList;

    public InventoryItemsInSlotAdapter(List<InvItems> itemsList, Function2<? super InvItems, ? super Integer, Unit> itemsClickListener, NvEventQueueActivity nvEventQueueActivity, boolean z) {
        Intrinsics.checkNotNullParameter(itemsList, "itemsList");
        Intrinsics.checkNotNullParameter(itemsClickListener, "itemsClickListener");
        this.itemsList = itemsList;
        this.itemsClickListener = (Function2<InvItems, Integer, Unit>) itemsClickListener;
        this.context = nvEventQueueActivity;
        this.isInventory = z;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        InventoryItemInSlotBinding inflate = InventoryItemInSlotBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        holder.bind(this.itemsList.get(i), this.itemsClickListener);
    }

    @Override
    public int getItemCount() {
        return this.itemsList.size();
    }

    //@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JJ\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2:\u0010\t\u001a6\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nj\u0002`\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/rockstargames/gtacr/adapters/InventoryItemsInSlotAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/InventoryItemInSlotBinding;", "(Lcom/rockstargames/gtacr/adapters/InventoryItemsInSlotAdapter;Lblackrussia/online/databinding/InventoryItemInSlotBinding;)V", "bind", "", "item", "Lblackrussia/online/network/InvItems;", "itemsClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "position", "Lcom/rockstargames/gtacr/gui/inventory/OnItemsClickListener;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final InventoryItemInSlotBinding binding;
        final InventoryItemsInSlotAdapter this$0;

        public ViewHolder(InventoryItemsInSlotAdapter this$0, InventoryItemInSlotBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final InvItems item, final Function2<? super InvItems, ? super Integer, Unit> itemsClickListener) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(itemsClickListener, "itemsClickListener");
            if (!item.getCheck()) {
                this.binding.invSlotActiveBg.setVisibility(4);
            } else {
                this.binding.invSlotActiveBg.setVisibility(0);
            }
            if (item.getItemsValue() != 0) {
                int id = item.getId();
                if (id != 59) {
                    if (id != 134) {
                        switch (id) {
                            case 81:
                                if (item.getThisBitmap() == null) {
                                    String textIfException = item.getTextIfException();
                                    int id2 = item.getId() + getLayoutPosition();
                                    Useful useful = new Useful();
                                    NvEventQueueActivity nvEventQueueActivity = this.this$0.context;
                                    ImageView imageView = this.binding.playersItem;
                                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.playersItem");
                                    useful.renderPlate(nvEventQueueActivity, 2, id2, textIfException, "", imageView, item);
                                    break;
                                } else {
                                    ImageView imageView2 = this.binding.playersItem;
                                    imageView2.setImageBitmap(item.getThisBitmap());
                                    imageView2.setScaleX(-1.0f);
                                    imageView2.setAlpha(1.0f);
                                    break;
                                }
                            case 82:
                                if (item.getThisBitmap() == null) {
                                    String textIfException2 = item.getTextIfException();
                                    int id3 = item.getId() + getLayoutPosition();
                                    Useful useful2 = new Useful();
                                    NvEventQueueActivity nvEventQueueActivity2 = this.this$0.context;
                                    ImageView imageView3 = this.binding.playersItem;
                                    Intrinsics.checkNotNullExpressionValue(imageView3, "binding.playersItem");
                                    useful2.renderPlate(nvEventQueueActivity2, 3, id3, textIfException2, "", imageView3, item);
                                    break;
                                } else {
                                    ImageView imageView4 = this.binding.playersItem;
                                    imageView4.setImageBitmap(item.getThisBitmap());
                                    imageView4.setScaleX(-1.0f);
                                    imageView4.setAlpha(1.0f);
                                    break;
                                }
                            case 83:
                                if (item.getThisBitmap() == null) {
                                    String substringBefore$default = " -" + item.getTextIfException();
                                    String substringAfter$default = item.getTextIfException() + "- ";
                                    int id4 = item.getId() + getLayoutPosition();
                                    Useful useful3 = new Useful();
                                    NvEventQueueActivity nvEventQueueActivity3 = this.this$0.context;
                                    ImageView imageView5 = this.binding.playersItem;
                                    Intrinsics.checkNotNullExpressionValue(imageView5, "binding.playersItem");
                                    useful3.renderPlate(nvEventQueueActivity3, 4, id4, substringBefore$default, substringAfter$default, imageView5, item);
                                    break;
                                } else {
                                    ImageView imageView6 = this.binding.playersItem;
                                    imageView6.setImageBitmap(item.getThisBitmap());
                                    imageView6.setScaleX(-1.0f);
                                    imageView6.setAlpha(1.0f);
                                    break;
                                }
                            default:
                                if (item.getThisBitmap() == null) {
                                    Useful useful4 = new Useful();
                                    NvEventQueueActivity nvEventQueueActivity4 = this.this$0.context;
                                    int id5 = item.getId();
                                    int modelid = item.getModelid();
                                    ImageView imageView7 = this.binding.playersItem;
                                    Intrinsics.checkNotNullExpressionValue(imageView7, "binding.playersItem");
                                    useful4.renderItem(nvEventQueueActivity4, 0, id5, modelid, 3, imageView7, item.getX(), item.getY(), item.getZ(), item.getZoom(), item.getShiftX(), item.getShiftY(), item.getShiftZ(), item);
                                    break;
                                } else {
                                    this.binding.playersItem.setImageBitmap(item.getThisBitmap());
                                    this.binding.playersItem.setScaleX(-1.0f);
                                    break;
                                }
                        }
                    } else if (item.getThisBitmap() == null) {
                        Useful useful5 = new Useful();
                        NvEventQueueActivity nvEventQueueActivity5 = this.this$0.context;
                        int id6 = item.getId();
                        int modelid2 = item.getModelid();
                        ImageView imageView8 = this.binding.playersItem;
                        Intrinsics.checkNotNullExpressionValue(imageView8, "binding.playersItem");
                        useful5.renderItem(nvEventQueueActivity5, 2, id6, modelid2, 1, imageView8, item.getX(), item.getY(), item.getZ(), item.getZoom(), item.getShiftX(), item.getShiftY(), item.getShiftZ(), item);
                    } else {
                        this.binding.playersItem.setImageBitmap(item.getThisBitmap());
                        this.binding.playersItem.setScaleX(-1.0f);
                    }
                } else if (item.getThisBitmap() == null) {
                    String substringBefore$default2 = " -" + item.getTextIfException();
                    String substringAfter$default2 = item.getTextIfException() + "- ";
                    int id7 = item.getId() + getLayoutPosition();
                    Useful useful6 = new Useful();
                    NvEventQueueActivity nvEventQueueActivity6 = this.this$0.context;
                    ImageView imageView9 = this.binding.playersItem;
                    Intrinsics.checkNotNullExpressionValue(imageView9, "binding.playersItem");
                    useful6.renderPlate(nvEventQueueActivity6, 1, id7, substringBefore$default2, substringAfter$default2, imageView9, item);
                } else {
                    ImageView imageView10 = this.binding.playersItem;
                    imageView10.setImageBitmap(item.getThisBitmap());
                    imageView10.setScaleX(-1.0f);
                    imageView10.setAlpha(1.0f);
                }
            } else {
                this.binding.playersItem.setImageBitmap(null);
            }
            if (getLayoutPosition() == 0 && this.this$0.isInventory) {
                this.binding.iconTelephone.setVisibility(0);
            } else {
                this.binding.iconTelephone.setVisibility(8);
            }
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //InventoryItemsInSlotAdapter.ViewHolder.m101bind$lambda4(itemsClickListener, item, this, view);
                }
            });
        }

        public static final void m101bind$lambda4(Function2 itemsClickListener, InvItems item, ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(itemsClickListener, "$itemsClickListener");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            itemsClickListener.invoke(item, Integer.valueOf(this$0.getLayoutPosition()));
        }
    }

    public final void setCheckOnlyElement(int i) {
        int size = this.itemsList.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (this.itemsList.get(i2).getCheck() && i2 != i) {
                this.itemsList.get(i2).setCheck(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }
}
