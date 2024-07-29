package com.rockstargames.gtacr.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/rockstargames/gtacr/data/FamilyMainItemData;", "", "itemsId", "", "itemsTitle", "", "isClicked", "", "(ILjava/lang/String;Z)V", "()Z", "setClicked", "(Z)V", "getItemsId", "()I", "getItemsTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyMainItemData {
    private boolean isClicked;
    private final int itemsId;
    private final String itemsTitle;

    public static FamilyMainItemData copy$default(FamilyMainItemData familyMainItemData, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = familyMainItemData.itemsId;
        }
        if ((i2 & 2) != 0) {
            str = familyMainItemData.itemsTitle;
        }
        if ((i2 & 4) != 0) {
            z = familyMainItemData.isClicked;
        }
        return familyMainItemData.copy(i, str, z);
    }

    public final int component1() {
        return this.itemsId;
    }

    public final String component2() {
        return this.itemsTitle;
    }

    public final boolean component3() {
        return this.isClicked;
    }

    public final FamilyMainItemData copy(int i, String itemsTitle, boolean z) {
        Intrinsics.checkNotNullParameter(itemsTitle, "itemsTitle");
        return new FamilyMainItemData(i, itemsTitle, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilyMainItemData) {
            FamilyMainItemData familyMainItemData = (FamilyMainItemData) obj;
            return this.itemsId == familyMainItemData.itemsId && Intrinsics.areEqual(this.itemsTitle, familyMainItemData.itemsTitle) && this.isClicked == familyMainItemData.isClicked;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.itemsId * 31) + this.itemsTitle.hashCode()) * 31;
        boolean z = this.isClicked;
        int i = 0;
        if (z) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "FamilyMainItemData(itemsId=" + this.itemsId + ", itemsTitle=" + this.itemsTitle + ", isClicked=" + this.isClicked + ')';
    }

    public FamilyMainItemData(int i, String itemsTitle, boolean z) {
        Intrinsics.checkNotNullParameter(itemsTitle, "itemsTitle");
        this.itemsId = i;
        this.itemsTitle = itemsTitle;
        this.isClicked = z;
    }

    public FamilyMainItemData(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z);
    }

    public final int getItemsId() {
        return this.itemsId;
    }

    public final String getItemsTitle() {
        return this.itemsTitle;
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final void setClicked(boolean z) {
        this.isClicked = z;
    }
}
