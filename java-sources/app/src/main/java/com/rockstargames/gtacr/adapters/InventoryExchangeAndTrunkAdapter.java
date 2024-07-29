package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.InventoryExchangeItemBinding;
import blackrussia.online.network.InvItems;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.InventoryExchangeAndTrunkAdapter;
import com.rockstargames.gtacr.gui.Useful;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

//@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001 Ba\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012:\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0002\u0010\u0012J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0018\u001a\u00020\r2\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000bR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/rockstargames/gtacr/adapters/InventoryExchangeAndTrunkAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/InventoryExchangeAndTrunkAdapter$ViewHolder;", "itemsList", "", "Lblackrussia/online/network/InvItems;", "itemsClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "", "position", "", "Lcom/rockstargames/gtacr/gui/inventory/OnItemsClickListener;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "counterForIdsPlate", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lcom/nvidia/devtech/NvEventQueueActivity;I)V", "binding", "Lblackrussia/online/databinding/InventoryExchangeItemBinding;", "getItemCount", "getItemId", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCheckOnlyElement", "checkedPosition", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InventoryExchangeAndTrunkAdapter extends RecyclerView.Adapter<InventoryExchangeAndTrunkAdapter.ViewHolder> {
    private InventoryExchangeItemBinding binding;
    private final NvEventQueueActivity context;
    private final int counterForIdsPlate;
    private final Function2<InvItems, Integer, Unit> itemsClickListener;
    private final List<InvItems> itemsList;

    @Override
    public long getItemId(int i) {
        return i;
    }

    public InventoryExchangeAndTrunkAdapter(List<InvItems> itemsList, Function2<? super InvItems, ? super Integer, Unit> itemsClickListener, NvEventQueueActivity nvEventQueueActivity, int i) {
        Intrinsics.checkNotNullParameter(itemsList, "itemsList");
        Intrinsics.checkNotNullParameter(itemsClickListener, "itemsClickListener");
        this.itemsList = itemsList;
        this.itemsClickListener = (Function2<InvItems, Integer, Unit>) itemsClickListener;
        this.context = nvEventQueueActivity;
        this.counterForIdsPlate = i;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        InventoryExchangeItemBinding inflate = InventoryExchangeItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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

    //@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JJ\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2:\u0010\t\u001a6\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nj\u0002`\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/rockstargames/gtacr/adapters/InventoryExchangeAndTrunkAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/InventoryExchangeItemBinding;", "(Lcom/rockstargames/gtacr/adapters/InventoryExchangeAndTrunkAdapter;Lblackrussia/online/databinding/InventoryExchangeItemBinding;)V", "bind", "", "item", "Lblackrussia/online/network/InvItems;", "itemsClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "position", "Lcom/rockstargames/gtacr/gui/inventory/OnItemsClickListener;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final InventoryExchangeItemBinding binding;
        final InventoryExchangeAndTrunkAdapter this$0;

        public ViewHolder(InventoryExchangeAndTrunkAdapter this$0, InventoryExchangeItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final InvItems item, final Function2<? super InvItems, ? super Integer, Unit> itemsClickListener) {
            int id;
            int layoutPosition;
            String valueOf;
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(itemsClickListener, "itemsClickListener");
            if (!item.getCheck()) {
                this.binding.invItemActiveBg.setVisibility(4);
            } else {
                this.binding.invItemActiveBg.setVisibility(0);
            }
            int i = 2;
            if (item.getItemsValue() == 0) {
                this.binding.invValueItems.setVisibility(4);
                this.binding.invLineUpOrDown.setVisibility(4);
                this.binding.invUnderline.setVisibility(4);
                this.binding.invItemItemsIcon.setImageBitmap(null);
                this.binding.bgItemsAura.setVisibility(0);
            } else {
                this.binding.invValueItems.setVisibility(0);
                this.binding.invLineUpOrDown.setVisibility(0);
                this.binding.invUnderline.setVisibility(0);
                this.binding.bgItemsAura.setVisibility(4);
                int i2 = this.this$0.counterForIdsPlate;
                if (i2 == 0) {
                    id = item.getId();
                    layoutPosition = getLayoutPosition();
                } else if (i2 == 1) {
                    id = item.getId() + getLayoutPosition();
                    layoutPosition = this.this$0.itemsList.size() * 2;
                } else {
                    id = item.getId() + getLayoutPosition();
                    layoutPosition = this.this$0.itemsList.size() * 4;
                }
                int i3 = id + layoutPosition;
                int id2 = item.getId();
                if (id2 != 59) {
                    if (id2 != 134) {
                        switch (id2) {
                            case 81:
                                if (item.getThisBitmap() == null) {
                                    String textIfException = item.getTextIfException();
                                    Useful useful = new Useful();
                                    NvEventQueueActivity nvEventQueueActivity = this.this$0.context;
                                    ImageView imageView = this.binding.invItemItemsIcon;
                                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.invItemItemsIcon");
                                    useful.renderPlate(nvEventQueueActivity, 2, i3, textIfException, "", imageView, item);
                                    break;
                                } else {
                                    ImageView imageView2 = this.binding.invItemItemsIcon;
                                    imageView2.setImageBitmap(item.getThisBitmap());
                                    imageView2.setScaleX(-1.0f);
                                    imageView2.setAlpha(1.0f);
                                    break;
                                }
                            case 82:
                                if (item.getThisBitmap() == null) {
                                    String textIfException2 = item.getTextIfException();
                                    Useful useful2 = new Useful();
                                    NvEventQueueActivity nvEventQueueActivity2 = this.this$0.context;
                                    ImageView imageView3 = this.binding.invItemItemsIcon;
                                    Intrinsics.checkNotNullExpressionValue(imageView3, "binding.invItemItemsIcon");
                                    useful2.renderPlate(nvEventQueueActivity2, 3, i3, textIfException2, "", imageView3, item);
                                    break;
                                } else {
                                    ImageView imageView4 = this.binding.invItemItemsIcon;
                                    imageView4.setImageBitmap(item.getThisBitmap());
                                    imageView4.setScaleX(-1.0f);
                                    imageView4.setAlpha(1.0f);
                                    break;
                                }
                            case 83:
                                if (item.getThisBitmap() == null) {
                                    String substringBefore$default = " -" + item.getTextIfException();
                                    String substringAfter$default = item.getTextIfException() + "- ";
                                    Useful useful3 = new Useful();
                                    NvEventQueueActivity nvEventQueueActivity3 = this.this$0.context;
                                    ImageView imageView5 = this.binding.invItemItemsIcon;
                                    Intrinsics.checkNotNullExpressionValue(imageView5, "binding.invItemItemsIcon");
                                    useful3.renderPlate(nvEventQueueActivity3, 4, i3, substringBefore$default, substringAfter$default, imageView5, item);
                                    break;
                                } else {
                                    ImageView imageView6 = this.binding.invItemItemsIcon;
                                    imageView6.setImageBitmap(item.getThisBitmap());
                                    imageView6.setScaleX(-1.0f);
                                    imageView6.setAlpha(1.0f);
                                    break;
                                }
                            default:
                                if (item.getThisBitmap() == null) {
                                    Useful useful4 = new Useful();
                                    NvEventQueueActivity nvEventQueueActivity4 = this.this$0.context;
                                    int id3 = item.getId();
                                    int modelid = item.getModelid();
                                    ImageView imageView7 = this.binding.invItemItemsIcon;
                                    Intrinsics.checkNotNullExpressionValue(imageView7, "binding.invItemItemsIcon");
                                    useful4.renderItem(nvEventQueueActivity4, 0, id3, modelid, 3, imageView7, item.getX(), item.getY(), item.getZ(), item.getZoom(), item.getShiftX(), item.getShiftY(), item.getShiftZ(), item);
                                    break;
                                } else {
                                    ImageView imageView8 = this.binding.invItemItemsIcon;
                                    imageView8.setImageBitmap(item.getThisBitmap());
                                    imageView8.setScaleX(-1.0f);
                                    imageView8.setAlpha(1.0f);
                                    break;
                                }
                        }
                    } else if (item.getThisBitmap() == null) {
                        Useful useful5 = new Useful();
                        NvEventQueueActivity nvEventQueueActivity5 = this.this$0.context;
                        int id4 = item.getId();
                        int modelid2 = item.getModelid();
                        ImageView imageView9 = this.binding.invItemItemsIcon;
                        Intrinsics.checkNotNullExpressionValue(imageView9, "binding.invItemItemsIcon");
                        useful5.renderItem(nvEventQueueActivity5, 2, id4, modelid2, 1, imageView9, item.getX(), item.getY(), item.getZ(), item.getZoom(), item.getShiftX(), item.getShiftY(), item.getShiftZ(), item);
                    } else {
                        ImageView imageView10 = this.binding.invItemItemsIcon;
                        imageView10.setImageBitmap(item.getThisBitmap());
                        imageView10.setScaleX(-1.0f);
                        imageView10.setAlpha(1.0f);
                    }
                    i = 2;
                } else if (item.getThisBitmap() == null) {
                    i = 2;
                    String substringBefore$default2 = " -" + item.getTextIfException();
                    String substringAfter$default2 = item.getTextIfException() + "- ";
                    Useful useful6 = new Useful();
                    NvEventQueueActivity nvEventQueueActivity6 = this.this$0.context;
                    ImageView imageView11 = this.binding.invItemItemsIcon;
                    Intrinsics.checkNotNullExpressionValue(imageView11, "binding.invItemItemsIcon");
                    useful6.renderPlate(nvEventQueueActivity6, 1, i3, substringBefore$default2, substringAfter$default2, imageView11, item);
                } else {
                    i = 2;
                    ImageView imageView12 = this.binding.invItemItemsIcon;
                    imageView12.setImageBitmap(item.getThisBitmap());
                    imageView12.setScaleX(-1.0f);
                    imageView12.setAlpha(1.0f);
                }
            }
            int whoseItem = item.getWhoseItem();
            if (whoseItem == 0) {
                this.binding.invLineUpOrDown.setVisibility(4);
                this.binding.invUnderline.setVisibility(4);
            } else if (whoseItem == 1) {
                this.binding.invLineUpOrDown.setVisibility(0);
                this.binding.invUnderline.setVisibility(0);
                this.binding.invLineUpOrDown.setImageResource(R.drawable.inv_icon_exchange_up_res);
            } else if (whoseItem == i) {
                this.binding.invLineUpOrDown.setVisibility(0);
                this.binding.invUnderline.setVisibility(0);
                this.binding.invLineUpOrDown.setImageResource(R.drawable.inv_icon_exchange_down_res);
            }
            if (item.getId() == 58) {
                valueOf = item.getTextIfException();
            } else {
                valueOf = String.valueOf(item.getItemsValue());
            }
            this.binding.invValueItems.setText(valueOf);
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //InventoryExchangeAndTrunkAdapter.ViewHolder.m98bind$lambda6(itemsClickListener, item, this, view);
                }
            });
        }

        public static final void m98bind$lambda6(Function2 itemsClickListener, InvItems item, ViewHolder this$0, View view) {
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
