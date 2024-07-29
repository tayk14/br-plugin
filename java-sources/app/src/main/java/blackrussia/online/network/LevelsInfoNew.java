package blackrussia.online.network;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\rJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019Jf\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011¨\u00064"}, d2 = {"Lblackrussia/online/network/LevelsInfoNew;", "", GetKeys.GET_PLAYERS_ID, "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "typeId", "awardId", "texture", "rotX", "", "rotY", "rotZ", "(ILjava/lang/String;IILjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getAwardId", "()I", "setAwardId", "(I)V", "getId", "setId", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getRotX", "()Ljava/lang/Float;", "setRotX", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getRotY", "setRotY", "getRotZ", "setRotZ", "getTexture", "setTexture", "getTypeId", "setTypeId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ILjava/lang/String;IILjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lblackrussia/online/network/LevelsInfoNew;", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LevelsInfoNew {
    @SerializedName("awardId")
    private int awardId;
    @SerializedName(GetKeys.GET_PLAYERS_ID)
    private int id;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private String name;
    @SerializedName("rotX")
    private Float rotX;
    @SerializedName("rotY")
    private Float rotY;
    @SerializedName("rotZ")
    private Float rotZ;
    @SerializedName("texture")
    private String texture;
    @SerializedName("typeId")
    private int typeId;

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.typeId;
    }

    public final int component4() {
        return this.awardId;
    }

    public final String component5() {
        return this.texture;
    }

    public final Float component6() {
        return this.rotX;
    }

    public final Float component7() {
        return this.rotY;
    }

    public final Float component8() {
        return this.rotZ;
    }

    public final LevelsInfoNew copy(int i, String name, int i2, int i3, String str, Float f, Float f2, Float f3) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new LevelsInfoNew(i, name, i2, i3, str, f, f2, f3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LevelsInfoNew) {
            LevelsInfoNew levelsInfoNew = (LevelsInfoNew) obj;
            return this.id == levelsInfoNew.id && Intrinsics.areEqual(this.name, levelsInfoNew.name) && this.typeId == levelsInfoNew.typeId && this.awardId == levelsInfoNew.awardId && Intrinsics.areEqual(this.texture, levelsInfoNew.texture) && Intrinsics.areEqual((Object) this.rotX, (Object) levelsInfoNew.rotX) && Intrinsics.areEqual((Object) this.rotY, (Object) levelsInfoNew.rotY) && Intrinsics.areEqual((Object) this.rotZ, (Object) levelsInfoNew.rotZ);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.id * 31) + this.name.hashCode()) * 31) + this.typeId) * 31) + this.awardId) * 31;
        String str = this.texture;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Float f = this.rotX;
        int hashCode3 = (hashCode2 + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.rotY;
        int hashCode4 = (hashCode3 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.rotZ;
        return hashCode4 + (f3 != null ? f3.hashCode() : 0);
    }

    public String toString() {
        return "LevelsInfoNew(id=" + this.id + ", name=" + this.name + ", typeId=" + this.typeId + ", awardId=" + this.awardId + ", texture=" + ((Object) this.texture) + ", rotX=" + this.rotX + ", rotY=" + this.rotY + ", rotZ=" + this.rotZ + ')';
    }

    public LevelsInfoNew(int i, String name, int i2, int i3, String str, Float f, Float f2, Float f3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.typeId = i2;
        this.awardId = i3;
        this.texture = str;
        this.rotX = f;
        this.rotY = f2;
        this.rotZ = f3;
    }

    public LevelsInfoNew(int i, String str, int i2, int i3, String str2, Float f, Float f2, Float f3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, i3, (i4 & 16) != 0 ? null : str2, (i4 & 32) != 0 ? null : f, (i4 & 64) != 0 ? null : f2, (i4 & 128) != 0 ? null : f3);
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

    public final int getTypeId() {
        return this.typeId;
    }

    public final void setTypeId(int i) {
        this.typeId = i;
    }

    public final int getAwardId() {
        return this.awardId;
    }

    public final void setAwardId(int i) {
        this.awardId = i;
    }

    public final String getTexture() {
        return this.texture;
    }

    public final void setTexture(String str) {
        this.texture = str;
    }

    public final Float getRotX() {
        return this.rotX;
    }

    public final void setRotX(Float f) {
        this.rotX = f;
    }

    public final Float getRotY() {
        return this.rotY;
    }

    public final void setRotY(Float f) {
        this.rotY = f;
    }

    public final Float getRotZ() {
        return this.rotZ;
    }

    public final void setRotZ(Float f) {
        this.rotZ = f;
    }
}
