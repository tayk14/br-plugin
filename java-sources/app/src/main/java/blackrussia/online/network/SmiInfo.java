package blackrussia.online.network;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lblackrussia/online/network/SmiInfo;", "", GetKeys.GET_PLAYERS_ID, "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "isChecked", "", "(ILjava/lang/String;Z)V", "getId", "()I", "setId", "(I)V", "()Z", "setChecked", "(Z)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SmiInfo {
    @SerializedName(GetKeys.GET_PLAYERS_ID)
    private int id;
    private boolean isChecked;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private String name;

    public static SmiInfo copy$default(SmiInfo smiInfo, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = smiInfo.id;
        }
        if ((i2 & 2) != 0) {
            str = smiInfo.name;
        }
        if ((i2 & 4) != 0) {
            z = smiInfo.isChecked;
        }
        return smiInfo.copy(i, str, z);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.isChecked;
    }

    public final SmiInfo copy(int i, String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new SmiInfo(i, name, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SmiInfo) {
            SmiInfo smiInfo = (SmiInfo) obj;
            return this.id == smiInfo.id && Intrinsics.areEqual(this.name, smiInfo.name) && this.isChecked == smiInfo.isChecked;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.id * 31) + this.name.hashCode()) * 31;
        boolean z = this.isChecked;
        int i = 0;
        if (z) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "SmiInfo(id=" + this.id + ", name=" + this.name + ", isChecked=" + this.isChecked + ')';
    }

    public SmiInfo(int i, String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.isChecked = z;
    }

    public SmiInfo(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z);
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }
}
