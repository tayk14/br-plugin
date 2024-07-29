package blackrussia.online.network;

import android.graphics.Bitmap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003Je\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010*\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011¨\u0006."}, d2 = {"Lblackrussia/online/network/FamilySystemShopObj;", "", GetKeys.GET_PLAYERS_ID, "", "title", "", "objectId", Const.FRACTION_TYPE_KEY, "typeId", FirebaseAnalytics.Param.PRICE, "serverId", "isClicked", "", "thisRender", "Landroid/graphics/Bitmap;", "(ILjava/lang/String;IIIIIZLandroid/graphics/Bitmap;)V", "getId", "()I", "()Z", "setClicked", "(Z)V", "getObjectId", "getPrice", "getServerId", "getThisRender", "()Landroid/graphics/Bitmap;", "setThisRender", "(Landroid/graphics/Bitmap;)V", "getTitle", "()Ljava/lang/String;", "getType", "getTypeId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilySystemShopObj {
    @SerializedName(GetKeys.GET_PLAYERS_ID)
    private final int id;
    private boolean isClicked;
    @SerializedName("object_id")
    private final int objectId;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private final int price;
    @SerializedName("server_id")
    private final int serverId;
    private Bitmap thisRender;
    @SerializedName("title")
    private final String title;
    @SerializedName(Const.FRACTION_TYPE_KEY)
    private final int type;
    @SerializedName("type_id")
    private final int typeId;

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.objectId;
    }

    public final int component4() {
        return this.type;
    }

    public final int component5() {
        return this.typeId;
    }

    public final int component6() {
        return this.price;
    }

    public final int component7() {
        return this.serverId;
    }

    public final boolean component8() {
        return this.isClicked;
    }

    public final Bitmap component9() {
        return this.thisRender;
    }

    public final FamilySystemShopObj copy(int i, String title, int i2, int i3, int i4, int i5, int i6, boolean z, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new FamilySystemShopObj(i, title, i2, i3, i4, i5, i6, z, bitmap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilySystemShopObj) {
            FamilySystemShopObj familySystemShopObj = (FamilySystemShopObj) obj;
            return this.id == familySystemShopObj.id && Intrinsics.areEqual(this.title, familySystemShopObj.title) && this.objectId == familySystemShopObj.objectId && this.type == familySystemShopObj.type && this.typeId == familySystemShopObj.typeId && this.price == familySystemShopObj.price && this.serverId == familySystemShopObj.serverId && this.isClicked == familySystemShopObj.isClicked && Intrinsics.areEqual(this.thisRender, familySystemShopObj.thisRender);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.id * 31) + this.title.hashCode()) * 31) + this.objectId) * 31) + this.type) * 31) + this.typeId) * 31) + this.price) * 31) + this.serverId) * 31;
        boolean z = this.isClicked;
        int i = 0;
        if (z) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        Bitmap bitmap = this.thisRender;
        return i2 + (bitmap == null ? 0 : bitmap.hashCode());
    }

    public String toString() {
        return "FamilySystemShopObj(id=" + this.id + ", title=" + this.title + ", objectId=" + this.objectId + ", type=" + this.type + ", typeId=" + this.typeId + ", price=" + this.price + ", serverId=" + this.serverId + ", isClicked=" + this.isClicked + ", thisRender=" + this.thisRender + ')';
    }

    public FamilySystemShopObj(int i, String title, int i2, int i3, int i4, int i5, int i6, boolean z, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = i;
        this.title = title;
        this.objectId = i2;
        this.type = i3;
        this.typeId = i4;
        this.price = i5;
        this.serverId = i6;
        this.isClicked = z;
        this.thisRender = bitmap;
    }

    public FamilySystemShopObj(int i, String str, int i2, int i3, int i4, int i5, int i6, boolean z, Bitmap bitmap, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, i3, i4, i5, i6, (i7 & 128) != 0 ? false : z, (i7 & 256) != 0 ? null : bitmap);
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getObjectId() {
        return this.objectId;
    }

    public final int getType() {
        return this.type;
    }

    public final int getTypeId() {
        return this.typeId;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getServerId() {
        return this.serverId;
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final void setClicked(boolean z) {
        this.isClicked = z;
    }

    public final Bitmap getThisRender() {
        return this.thisRender;
    }

    public final void setThisRender(Bitmap bitmap) {
        this.thisRender = bitmap;
    }
}
