package blackrussia.online.network;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u001e"}, d2 = {"Lblackrussia/online/network/SocialInteraction;", "", GetKeys.GET_PLAYERS_ID, "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", Const.FRACTION_TYPE_KEY, "org", Const.PAGE_KEY, "(ILjava/lang/String;III)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getOrg", "getPage", "setPage", "(I)V", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SocialInteraction {
    @SerializedName(GetKeys.GET_PLAYERS_ID)
    private final int id;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private final String name;
    @SerializedName("org")
    private final int f4org;
    private int page;
    @SerializedName(Const.FRACTION_TYPE_KEY)
    private final int type;

    public static SocialInteraction copy$default(SocialInteraction socialInteraction, int i, String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = socialInteraction.id;
        }
        if ((i5 & 2) != 0) {
            str = socialInteraction.name;
        }
        String str2 = str;
        if ((i5 & 4) != 0) {
            i2 = socialInteraction.type;
        }
        int i6 = i2;
        if ((i5 & 8) != 0) {
            i3 = socialInteraction.f4org;
        }
        int i7 = i3;
        if ((i5 & 16) != 0) {
            i4 = socialInteraction.page;
        }
        return socialInteraction.copy(i, str2, i6, i7, i4);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.type;
    }

    public final int component4() {
        return this.f4org;
    }

    public final int component5() {
        return this.page;
    }

    public final SocialInteraction copy(int i, String name, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new SocialInteraction(i, name, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SocialInteraction) {
            SocialInteraction socialInteraction = (SocialInteraction) obj;
            return this.id == socialInteraction.id && Intrinsics.areEqual(this.name, socialInteraction.name) && this.type == socialInteraction.type && this.f4org == socialInteraction.f4org && this.page == socialInteraction.page;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.id * 31) + this.name.hashCode()) * 31) + this.type) * 31) + this.f4org) * 31) + this.page;
    }

    public String toString() {
        return "SocialInteraction(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", org=" + this.f4org + ", page=" + this.page + ')';
    }

    public SocialInteraction(int i, String name, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.type = i2;
        this.f4org = i3;
        this.page = i4;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public final int getOrg() {
        return this.f4org;
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }
}
