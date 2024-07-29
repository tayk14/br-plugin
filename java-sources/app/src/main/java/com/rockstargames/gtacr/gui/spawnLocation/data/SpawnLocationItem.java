package com.rockstargames.gtacr.gui.spawnLocation.data;

import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/rockstargames/gtacr/gui/spawnLocation/data/SpawnLocationItem;", "", GetKeys.GET_PLAYERS_ID, "", "place", "placeName", "", "(IILjava/lang/String;)V", "getId", "()I", "getPlace", "getPlaceName", "()Ljava/lang/String;", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpawnLocationItem {
    @SerializedName(GetKeys.GET_PLAYERS_ID)
    private final int id;
    @SerializedName("place")
    private final int place;
    @SerializedName("place_name")
    private final String placeName;
    private boolean selected;

    public static SpawnLocationItem copy$default(SpawnLocationItem spawnLocationItem, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = spawnLocationItem.id;
        }
        if ((i3 & 2) != 0) {
            i2 = spawnLocationItem.place;
        }
        if ((i3 & 4) != 0) {
            str = spawnLocationItem.placeName;
        }
        return spawnLocationItem.copy(i, i2, str);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.place;
    }

    public final String component3() {
        return this.placeName;
    }

    public final SpawnLocationItem copy(int i, int i2, String placeName) {
        Intrinsics.checkNotNullParameter(placeName, "placeName");
        return new SpawnLocationItem(i, i2, placeName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SpawnLocationItem) {
            SpawnLocationItem spawnLocationItem = (SpawnLocationItem) obj;
            return this.id == spawnLocationItem.id && this.place == spawnLocationItem.place && Intrinsics.areEqual(this.placeName, spawnLocationItem.placeName);
        }
        return false;
    }

    public int hashCode() {
        return (((this.id * 31) + this.place) * 31) + this.placeName.hashCode();
    }

    public String toString() {
        return "SpawnLocationItem(id=" + this.id + ", place=" + this.place + ", placeName=" + this.placeName + ')';
    }

    public SpawnLocationItem(int i, int i2, String placeName) {
        Intrinsics.checkNotNullParameter(placeName, "placeName");
        this.id = i;
        this.place = i2;
        this.placeName = placeName;
    }

    public final int getId() {
        return this.id;
    }

    public final int getPlace() {
        return this.place;
    }

    public final String getPlaceName() {
        return this.placeName;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }
}
