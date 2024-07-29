package blackrussia.online.network;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b.\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003Jw\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u00109\u001a\u00020\u000f2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\t\u0010<\u001a\u00020\bHÖ\u0001R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001e\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018¨\u0006="}, d2 = {"Lblackrussia/online/network/Tune;", "", GetKeys.GET_PLAYERS_ID, "", Const.FRACTION_TYPE_KEY, "selector", "tuneId", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "imageId", FirebaseAnalytics.Param.CURRENCY, "def", "cost", "thisLocation", "checked", "", "(IIIILjava/lang/String;Ljava/lang/String;IIIIZ)V", "getChecked", "()Z", "setChecked", "(Z)V", "getCost", "()I", "setCost", "(I)V", "getCurrency", "setCurrency", "getDef", "setDef", "getId", "setId", "getImageId", "()Ljava/lang/String;", "setImageId", "(Ljava/lang/String;)V", "getName", "setName", "getSelector", "setSelector", "getThisLocation", "setThisLocation", "getTuneId", "setTuneId", "getType", "setType", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Tune {
    private boolean checked;
    private int cost;
    @SerializedName(FirebaseAnalytics.Param.CURRENCY)
    private int currency;
    @SerializedName("def")
    private int def;
    @SerializedName(GetKeys.GET_PLAYERS_ID)
    private int id;
    @SerializedName("imageId")
    private String imageId;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private String name;
    @SerializedName("selector")
    private int selector;
    private int thisLocation;
    @SerializedName("tuneId")
    private int tuneId;
    @SerializedName(Const.FRACTION_TYPE_KEY)
    private int type;

    public final int component1() {
        return this.id;
    }

    public final int component10() {
        return this.thisLocation;
    }

    public final boolean component11() {
        return this.checked;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.selector;
    }

    public final int component4() {
        return this.tuneId;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.imageId;
    }

    public final int component7() {
        return this.currency;
    }

    public final int component8() {
        return this.def;
    }

    public final int component9() {
        return this.cost;
    }

    public final Tune copy(int i, int i2, int i3, int i4, String name, String imageId, int i5, int i6, int i7, int i8, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(imageId, "imageId");
        return new Tune(i, i2, i3, i4, name, imageId, i5, i6, i7, i8, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Tune) {
            Tune tune = (Tune) obj;
            return this.id == tune.id && this.type == tune.type && this.selector == tune.selector && this.tuneId == tune.tuneId && Intrinsics.areEqual(this.name, tune.name) && Intrinsics.areEqual(this.imageId, tune.imageId) && this.currency == tune.currency && this.def == tune.def && this.cost == tune.cost && this.thisLocation == tune.thisLocation && this.checked == tune.checked;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((this.id * 31) + this.type) * 31) + this.selector) * 31) + this.tuneId) * 31) + this.name.hashCode()) * 31) + this.imageId.hashCode()) * 31) + this.currency) * 31) + this.def) * 31) + this.cost) * 31) + this.thisLocation) * 31;
        boolean z = this.checked;
        int i = 0;
        if (z) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "Tune(id=" + this.id + ", type=" + this.type + ", selector=" + this.selector + ", tuneId=" + this.tuneId + ", name=" + this.name + ", imageId=" + this.imageId + ", currency=" + this.currency + ", def=" + this.def + ", cost=" + this.cost + ", thisLocation=" + this.thisLocation + ", checked=" + this.checked + ')';
    }

    public Tune(int i, int i2, int i3, int i4, String name, String imageId, int i5, int i6, int i7, int i8, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(imageId, "imageId");
        this.id = i;
        this.type = i2;
        this.selector = i3;
        this.tuneId = i4;
        this.name = name;
        this.imageId = imageId;
        this.currency = i5;
        this.def = i6;
        this.cost = i7;
        this.thisLocation = i8;
        this.checked = z;
    }

    public Tune(int i, int i2, int i3, int i4, String str, String str2, int i5, int i6, int i7, int i8, boolean z, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, str, str2, i5, i6, i7, (i9 & 512) != 0 ? 0 : i8, (i9 & 1024) != 0 ? false : z);
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final int getSelector() {
        return this.selector;
    }

    public final void setSelector(int i) {
        this.selector = i;
    }

    public final int getTuneId() {
        return this.tuneId;
    }

    public final void setTuneId(int i) {
        this.tuneId = i;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getImageId() {
        return this.imageId;
    }

    public final void setImageId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageId = str;
    }

    public final int getCurrency() {
        return this.currency;
    }

    public final void setCurrency(int i) {
        this.currency = i;
    }

    public final int getDef() {
        return this.def;
    }

    public final void setDef(int i) {
        this.def = i;
    }

    public final int getCost() {
        return this.cost;
    }

    public final void setCost(int i) {
        this.cost = i;
    }

    public final int getThisLocation() {
        return this.thisLocation;
    }

    public final void setThisLocation(int i) {
        this.thisLocation = i;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }
}
