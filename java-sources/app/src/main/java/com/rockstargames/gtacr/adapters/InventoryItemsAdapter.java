package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.databinding.InventoryItemsItemBinding;
import blackrussia.online.network.InvItems;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.inventory.GUIUsersInventory;
import com.rockstargames.gtacr.gui.inventory.UILayoutUsersInventory;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

//@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001 Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012:\u0010\b\u001a6\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tj\u0002`\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0002\u0010\u0014J\b\u0010\u0017\u001a\u00020\rH\u0016J\u001c\u0010\u0018\u001a\u00020\u000f2\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\rR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000RB\u0010\b\u001a6\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tj\u0002`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/rockstargames/gtacr/adapters/InventoryItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/InventoryItemsAdapter$ViewHolder;", "mainRoot", "Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;", "itemsList", "", "Lblackrussia/online/network/InvItems;", "itemsClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "", "position", "", "Lcom/rockstargames/gtacr/gui/inventory/OnItemsClickListener;", "thisRoot", "Lcom/rockstargames/gtacr/gui/inventory/UILayoutUsersInventory;", "positionWithBlocked", "(Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lcom/rockstargames/gtacr/gui/inventory/UILayoutUsersInventory;I)V", "binding", "Lblackrussia/online/databinding/InventoryItemsItemBinding;", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCheckOnlyElement", "checkedPosition", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InventoryItemsAdapter extends RecyclerView.Adapter<InventoryItemsAdapter.ViewHolder> {
    private InventoryItemsItemBinding binding;
    private final Function2<InvItems, Integer, Unit> itemsClickListener;
    private final List<InvItems> itemsList;
    private final GUIUsersInventory mainRoot;
    private final int positionWithBlocked;
    private final UILayoutUsersInventory thisRoot;

    public InventoryItemsAdapter(GUIUsersInventory mainRoot, List<InvItems> itemsList, Function2<? super InvItems, ? super Integer, Unit> itemsClickListener, UILayoutUsersInventory thisRoot, int i) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(itemsList, "itemsList");
        Intrinsics.checkNotNullParameter(itemsClickListener, "itemsClickListener");
        Intrinsics.checkNotNullParameter(thisRoot, "thisRoot");
        this.mainRoot = mainRoot;
        this.itemsList = itemsList;
        this.itemsClickListener = (Function2<InvItems, Integer, Unit>) itemsClickListener;
        this.thisRoot = thisRoot;
        this.positionWithBlocked = i;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        InventoryItemsItemBinding inflate = InventoryItemsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        holder.bind(this.itemsList.get(i), this.itemsClickListener, this.mainRoot);
    }

    @Override
    public int getItemCount() {
        return this.itemsList.size();
    }

    //@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JT\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2:\u0010\t\u001a6\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nj\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/rockstargames/gtacr/adapters/InventoryItemsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/InventoryItemsItemBinding;", "(Lcom/rockstargames/gtacr/adapters/InventoryItemsAdapter;Lblackrussia/online/databinding/InventoryItemsItemBinding;)V", "bind", "", "item", "Lblackrussia/online/network/InvItems;", "itemsClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "position", "Lcom/rockstargames/gtacr/gui/inventory/OnItemsClickListener;", "mainRoot", "Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final InventoryItemsItemBinding binding;
        final InventoryItemsAdapter this$0;

        public ViewHolder(InventoryItemsAdapter this$0, InventoryItemsItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(InvItems item, Function2<? super InvItems, ? super Integer, Unit> itemsClickListener, GUIUsersInventory mainRoot) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(itemsClickListener, "itemsClickListener");
            Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
            if (!item.getCheck()) {
                this.binding.invItemActiveBg.setVisibility(4);
            } else {
                this.binding.invItemActiveBg.setVisibility(0);
            }
            if (item.getItemsValue() == 0) {
                this.binding.invValueItems.setVisibility(4);
                this.binding.invItemItemsIcon.setImageBitmap(null);
                this.binding.bgItemsAura.setVisibility(0);
            } else {
                this.binding.invValueItems.setVisibility(0);
                this.binding.bgItemsAura.setVisibility(4);
                int id = item.getId();
                if (id != 59) {
                    if (id != 134) {
                        switch (id) {
                            case 81:
                                if (item.getThisBitmap() == null) {
                                    String textIfException = item.getTextIfException();
                                    int id2 = item.getId() + getLayoutPosition();
                                    Useful useful = new Useful();
                                    NvEventQueueActivity mainContext = mainRoot.getMainContext();
                                    ImageView imageView = this.binding.invItemItemsIcon;
                                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.invItemItemsIcon");
                                    useful.renderPlate(mainContext, 2, id2, textIfException, "", imageView, item);
                                    break;
                                } else {
                                    this.binding.invItemItemsIcon.setImageBitmap(item.getThisBitmap());
                                    this.binding.invItemItemsIcon.setScaleX(-1.0f);
                                    break;
                                }
                            case 82:
                                if (item.getThisBitmap() == null) {
                                    String textIfException2 = item.getTextIfException();
                                    int id3 = item.getId() + getLayoutPosition();
                                    Useful useful2 = new Useful();
                                    NvEventQueueActivity mainContext2 = mainRoot.getMainContext();
                                    ImageView imageView2 = this.binding.invItemItemsIcon;
                                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.invItemItemsIcon");
                                    useful2.renderPlate(mainContext2, 3, id3, textIfException2, "", imageView2, item);
                                    break;
                                } else {
                                    this.binding.invItemItemsIcon.setImageBitmap(item.getThisBitmap());
                                    this.binding.invItemItemsIcon.setScaleX(-1.0f);
                                    break;
                                }
                            case 83:
                                if (item.getThisBitmap() == null) {
                                    String substringBefore$default =  " -" + item.getTextIfException();
                                    String substringAfter$default = item.getTextIfException() + "- ";
                                    int id4 = item.getId() + getLayoutPosition();
                                    Useful useful3 = new Useful();
                                    NvEventQueueActivity mainContext3 = mainRoot.getMainContext();
                                    ImageView imageView3 = this.binding.invItemItemsIcon;
                                    Intrinsics.checkNotNullExpressionValue(imageView3, "binding.invItemItemsIcon");
                                    useful3.renderPlate(mainContext3, 4, id4, substringBefore$default, substringAfter$default, imageView3, item);
                                    break;
                                } else {
                                    this.binding.invItemItemsIcon.setImageBitmap(item.getThisBitmap());
                                    this.binding.invItemItemsIcon.setScaleX(-1.0f);
                                    break;
                                }
                            default:
                                if (item.getThisBitmap() == null) {
                                    Useful useful4 = new Useful();
                                    NvEventQueueActivity mainContext4 = mainRoot.getMainContext();
                                    int id5 = item.getId();
                                    int modelid = item.getModelid();
                                    ImageView imageView4 = this.binding.invItemItemsIcon;
                                    Intrinsics.checkNotNullExpressionValue(imageView4, "binding.invItemItemsIcon");
                                    useful4.renderItem(mainContext4, 0, id5, modelid, 3, imageView4, item.getX(), item.getY(), item.getZ(), item.getZoom(), item.getShiftX(), item.getShiftY(), item.getShiftZ(), item);
                                    break;
                                } else {
                                    this.binding.invItemItemsIcon.setImageBitmap(item.getThisBitmap());
                                    this.binding.invItemItemsIcon.setScaleX(-1.0f);
                                    break;
                                }
                        }
                    } else if (item.getThisBitmap() == null) {
                        Useful useful5 = new Useful();
                        NvEventQueueActivity mainContext5 = mainRoot.getMainContext();
                        int id6 = item.getId();
                        int modelid2 = item.getModelid();
                        ImageView imageView5 = this.binding.invItemItemsIcon;
                        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.invItemItemsIcon");
                        useful5.renderItem(mainContext5, 2, id6, modelid2, 1, imageView5, item.getX(), item.getY(), item.getZ(), item.getZoom(), item.getShiftX(), item.getShiftY(), item.getShiftZ(), item);
                    } else {
                        this.binding.invItemItemsIcon.setImageBitmap(item.getThisBitmap());
                        this.binding.invItemItemsIcon.setScaleX(-1.0f);
                    }
                } else if (item.getThisBitmap() == null) {
                    String substringBefore$default2 = " -" + item.getTextIfException();
                    String substringAfter$default2 = item.getTextIfException() + "- ";
                    int id7 = item.getId() + getLayoutPosition();
                    Useful useful6 = new Useful();
                    NvEventQueueActivity mainContext6 = mainRoot.getMainContext();
                    ImageView imageView6 = this.binding.invItemItemsIcon;
                    Intrinsics.checkNotNullExpressionValue(imageView6, "binding.invItemItemsIcon");
                    useful6.renderPlate(mainContext6, 1, id7, substringBefore$default2, substringAfter$default2, imageView6, item);
                } else {
                    this.binding.invItemItemsIcon.setImageBitmap(item.getThisBitmap());
                    this.binding.invItemItemsIcon.setScaleX(-1.0f);
                }
            }
            this.binding.invValueItems.setText(String.valueOf(item.getItemsValue()));
            if (getLayoutPosition() > this.this$0.positionWithBlocked) {
                this.binding.bgMask.setVisibility(0);
                if (item.getItemsValue() == 0) {
                    this.binding.iconIfNoActive.setVisibility(0);
                    this.binding.textIfNotActual.setVisibility(0);
                } else {
                    this.binding.iconIfNoActive.setVisibility(4);
                    this.binding.textIfNotActual.setVisibility(4);
                }
            } else {
                this.binding.bgMask.setVisibility(4);
                this.binding.iconIfNoActive.setVisibility(4);
                this.binding.textIfNotActual.setVisibility(4);
            }
            this.binding.getRoot().setOnTouchListener(new InventoryItemsAdapter$ViewHolder$bind$1(this, item, new Ref.BooleanRef(), itemsClickListener, this.this$0, mainRoot));
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
