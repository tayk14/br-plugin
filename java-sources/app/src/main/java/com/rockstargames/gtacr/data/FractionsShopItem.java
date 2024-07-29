package com.rockstargames.gtacr.data;

import android.graphics.Bitmap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.fractions.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000e¨\u0006)"}, d2 = {"Lcom/rockstargames/gtacr/data/FractionsShopItem;", "", "uniqueId", "", "boxName", "", "typeID", "objectID", "itemId", "boxPrice", "(ILjava/lang/String;IIII)V", "getBoxName", "()Ljava/lang/String;", "getBoxPrice", "()I", "isClicked", "", "()Z", "setClicked", "(Z)V", "getItemId", "getObjectID", "render", "Landroid/graphics/Bitmap;", "getRender", "()Landroid/graphics/Bitmap;", "setRender", "(Landroid/graphics/Bitmap;)V", "getTypeID", "getUniqueId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsShopItem {
    @SerializedName("title")
    private final String boxName;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private final int boxPrice;
    private boolean isClicked;
    @SerializedName("itemID")
    private final int itemId;
    @SerializedName("objectID")
    private final int objectID;
    private Bitmap render;
    @SerializedName("typeID")
    private final int typeID;
    @SerializedName(Const.FRACTION_SHOP_UNIQUE_ID)
    private final int uniqueId;

    public static FractionsShopItem copy$default(FractionsShopItem fractionsShopItem, int i, String str, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = fractionsShopItem.uniqueId;
        }
        if ((i6 & 2) != 0) {
            str = fractionsShopItem.boxName;
        }
        String str2 = str;
        if ((i6 & 4) != 0) {
            i2 = fractionsShopItem.typeID;
        }
        int i7 = i2;
        if ((i6 & 8) != 0) {
            i3 = fractionsShopItem.objectID;
        }
        int i8 = i3;
        if ((i6 & 16) != 0) {
            i4 = fractionsShopItem.itemId;
        }
        int i9 = i4;
        if ((i6 & 32) != 0) {
            i5 = fractionsShopItem.boxPrice;
        }
        return fractionsShopItem.copy(i, str2, i7, i8, i9, i5);
    }

    public final int component1() {
        return this.uniqueId;
    }

    public final String component2() {
        return this.boxName;
    }

    public final int component3() {
        return this.typeID;
    }

    public final int component4() {
        return this.objectID;
    }

    public final int component5() {
        return this.itemId;
    }

    public final int component6() {
        return this.boxPrice;
    }

    public final FractionsShopItem copy(int i, String boxName, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(boxName, "boxName");
        return new FractionsShopItem(i, boxName, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FractionsShopItem) {
            FractionsShopItem fractionsShopItem = (FractionsShopItem) obj;
            return this.uniqueId == fractionsShopItem.uniqueId && Intrinsics.areEqual(this.boxName, fractionsShopItem.boxName) && this.typeID == fractionsShopItem.typeID && this.objectID == fractionsShopItem.objectID && this.itemId == fractionsShopItem.itemId && this.boxPrice == fractionsShopItem.boxPrice;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.uniqueId * 31) + this.boxName.hashCode()) * 31) + this.typeID) * 31) + this.objectID) * 31) + this.itemId) * 31) + this.boxPrice;
    }

    public String toString() {
        return "FractionsShopItem(uniqueId=" + this.uniqueId + ", boxName=" + this.boxName + ", typeID=" + this.typeID + ", objectID=" + this.objectID + ", itemId=" + this.itemId + ", boxPrice=" + this.boxPrice + ')';
    }

    public FractionsShopItem(int i, String boxName, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(boxName, "boxName");
        this.uniqueId = i;
        this.boxName = boxName;
        this.typeID = i2;
        this.objectID = i3;
        this.itemId = i4;
        this.boxPrice = i5;
    }

    public final int getUniqueId() {
        return this.uniqueId;
    }

    public final String getBoxName() {
        return this.boxName;
    }

    public final int getTypeID() {
        return this.typeID;
    }

    public final int getObjectID() {
        return this.objectID;
    }

    public final int getItemId() {
        return this.itemId;
    }

    public final int getBoxPrice() {
        return this.boxPrice;
    }

    public final Bitmap getRender() {
        return this.render;
    }

    public final void setRender(Bitmap bitmap) {
        this.render = bitmap;
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final void setClicked(boolean z) {
        this.isClicked = z;
    }
}
