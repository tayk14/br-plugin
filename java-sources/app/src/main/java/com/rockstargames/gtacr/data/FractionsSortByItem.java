package com.rockstargames.gtacr.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/rockstargames/gtacr/data/FractionsSortByItem;", "", "title", "", "isClicked", "", "(Ljava/lang/String;Z)V", "()Z", "setClicked", "(Z)V", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsSortByItem {
    private boolean isClicked;
    private final String title;

    public static FractionsSortByItem copy$default(FractionsSortByItem fractionsSortByItem, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fractionsSortByItem.title;
        }
        if ((i & 2) != 0) {
            z = fractionsSortByItem.isClicked;
        }
        return fractionsSortByItem.copy(str, z);
    }

    public final String component1() {
        return this.title;
    }

    public final boolean component2() {
        return this.isClicked;
    }

    public final FractionsSortByItem copy(String title, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new FractionsSortByItem(title, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FractionsSortByItem) {
            FractionsSortByItem fractionsSortByItem = (FractionsSortByItem) obj;
            return Intrinsics.areEqual(this.title, fractionsSortByItem.title) && this.isClicked == fractionsSortByItem.isClicked;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        boolean z = this.isClicked;
        int i = 0;
        if (z) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "FractionsSortByItem(title=" + this.title + ", isClicked=" + this.isClicked + ')';
    }

    public FractionsSortByItem(String title, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.isClicked = z;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final void setClicked(boolean z) {
        this.isClicked = z;
    }
}
