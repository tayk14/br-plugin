package com.rockstargames.gtacr.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/rockstargames/gtacr/data/FractionsShopList;", "", "list", "", "Lcom/rockstargames/gtacr/data/FractionsShopItem;", "itemClicked", "", "(Ljava/util/List;I)V", "getItemClicked", "()I", "setItemClicked", "(I)V", "getList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsShopList {
    private int itemClicked;
    @SerializedName("fractionMenuStore")
    private final List<FractionsShopItem> list;

    public static FractionsShopList copy$default(FractionsShopList fractionsShopList, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = fractionsShopList.list;
        }
        if ((i2 & 2) != 0) {
            i = fractionsShopList.itemClicked;
        }
        return fractionsShopList.copy(list, i);
    }

    public final List<FractionsShopItem> component1() {
        return this.list;
    }

    public final int component2() {
        return this.itemClicked;
    }

    public final FractionsShopList copy(List<FractionsShopItem> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new FractionsShopList(list, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FractionsShopList) {
            FractionsShopList fractionsShopList = (FractionsShopList) obj;
            return Intrinsics.areEqual(this.list, fractionsShopList.list) && this.itemClicked == fractionsShopList.itemClicked;
        }
        return false;
    }

    public int hashCode() {
        return (this.list.hashCode() * 31) + this.itemClicked;
    }

    public String toString() {
        return "FractionsShopList(list=" + this.list + ", itemClicked=" + this.itemClicked + ')';
    }

    public FractionsShopList(List<FractionsShopItem> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.itemClicked = i;
    }

    public FractionsShopList(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? -1 : i);
    }

    public final List<FractionsShopItem> getList() {
        return this.list;
    }

    public final int getItemClicked() {
        return this.itemClicked;
    }

    public final void setItemClicked(int i) {
        this.itemClicked = i;
    }
}
