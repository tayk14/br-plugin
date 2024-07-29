package blackrussia.online.network;

import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006!"}, d2 = {"Lblackrussia/online/network/TuneVinyls;", "", GetKeys.GET_PLAYERS_ID, "", "nameVinyl", "", "selected", "", "startVinyl", "firstRender", "(ILjava/lang/String;ZZZ)V", "getFirstRender", "()Z", "setFirstRender", "(Z)V", "getId", "()I", "getNameVinyl", "()Ljava/lang/String;", "getSelected", "setSelected", "getStartVinyl", "setStartVinyl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TuneVinyls {
    private boolean firstRender;
    @SerializedName(GetKeys.GET_PLAYERS_ID)
    private final int id;
    @SerializedName("nameVinyl")
    private final String nameVinyl;
    private boolean selected;
    private boolean startVinyl;

    public static TuneVinyls copy$default(TuneVinyls tuneVinyls, int i, String str, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tuneVinyls.id;
        }
        if ((i2 & 2) != 0) {
            str = tuneVinyls.nameVinyl;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            z = tuneVinyls.selected;
        }
        boolean z4 = z;
        if ((i2 & 8) != 0) {
            z2 = tuneVinyls.startVinyl;
        }
        boolean z5 = z2;
        if ((i2 & 16) != 0) {
            z3 = tuneVinyls.firstRender;
        }
        return tuneVinyls.copy(i, str2, z4, z5, z3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.nameVinyl;
    }

    public final boolean component3() {
        return this.selected;
    }

    public final boolean component4() {
        return this.startVinyl;
    }

    public final boolean component5() {
        return this.firstRender;
    }

    public final TuneVinyls copy(int i, String nameVinyl, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(nameVinyl, "nameVinyl");
        return new TuneVinyls(i, nameVinyl, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TuneVinyls) {
            TuneVinyls tuneVinyls = (TuneVinyls) obj;
            return this.id == tuneVinyls.id && Intrinsics.areEqual(this.nameVinyl, tuneVinyls.nameVinyl) && this.selected == tuneVinyls.selected && this.startVinyl == tuneVinyls.startVinyl && this.firstRender == tuneVinyls.firstRender;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.id * 31) + this.nameVinyl.hashCode()) * 31;
        boolean z = this.selected;
        int i = 0;
        if (z) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.startVinyl;
        int i3 = 0;
        if (z2) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.firstRender;
        return i4 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        return "TuneVinyls(id=" + this.id + ", nameVinyl=" + this.nameVinyl + ", selected=" + this.selected + ", startVinyl=" + this.startVinyl + ", firstRender=" + this.firstRender + ')';
    }

    public TuneVinyls(int i, String nameVinyl, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(nameVinyl, "nameVinyl");
        this.id = i;
        this.nameVinyl = nameVinyl;
        this.selected = z;
        this.startVinyl = z2;
        this.firstRender = z3;
    }

    public TuneVinyls(int i, String str, boolean z, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? true : z3);
    }

    public final int getId() {
        return this.id;
    }

    public final String getNameVinyl() {
        return this.nameVinyl;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    public final boolean getStartVinyl() {
        return this.startVinyl;
    }

    public final void setStartVinyl(boolean z) {
        this.startVinyl = z;
    }

    public final boolean getFirstRender() {
        return this.firstRender;
    }

    public final void setFirstRender(boolean z) {
        this.firstRender = z;
    }
}
