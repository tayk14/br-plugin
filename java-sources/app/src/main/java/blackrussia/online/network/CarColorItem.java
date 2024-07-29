package blackrussia.online.network;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001b¨\u0006)"}, d2 = {"Lblackrussia/online/network/CarColorItem;", "", GetKeys.GET_PLAYERS_ID, "", "gameColor", FirebaseAnalytics.Param.PRICE, TypedValues.Custom.S_COLOR, "", "selected", "", "startColor", "(IIILjava/lang/String;ZZ)V", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "getGameColor", "()I", "setGameColor", "(I)V", "getId", "setId", "getPrice", "setPrice", "getSelected", "()Z", "setSelected", "(Z)V", "getStartColor", "setStartColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CarColorItem {
    @SerializedName(TypedValues.Custom.S_COLOR)
    private String color;
    @SerializedName("gameColor")
    private int gameColor;
    @SerializedName(GetKeys.GET_PLAYERS_ID)
    private int id;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private int price;
    private boolean selected;
    private boolean startColor;

    public static CarColorItem copy$default(CarColorItem carColorItem, int i, int i2, int i3, String str, boolean z, boolean z2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = carColorItem.id;
        }
        if ((i4 & 2) != 0) {
            i2 = carColorItem.gameColor;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = carColorItem.price;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            str = carColorItem.color;
        }
        String str2 = str;
        if ((i4 & 16) != 0) {
            z = carColorItem.selected;
        }
        boolean z3 = z;
        if ((i4 & 32) != 0) {
            z2 = carColorItem.startColor;
        }
        return carColorItem.copy(i, i5, i6, str2, z3, z2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.gameColor;
    }

    public final int component3() {
        return this.price;
    }

    public final String component4() {
        return this.color;
    }

    public final boolean component5() {
        return this.selected;
    }

    public final boolean component6() {
        return this.startColor;
    }

    public final CarColorItem copy(int i, int i2, int i3, String color, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new CarColorItem(i, i2, i3, color, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CarColorItem) {
            CarColorItem carColorItem = (CarColorItem) obj;
            return this.id == carColorItem.id && this.gameColor == carColorItem.gameColor && this.price == carColorItem.price && Intrinsics.areEqual(this.color, carColorItem.color) && this.selected == carColorItem.selected && this.startColor == carColorItem.startColor;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.id * 31) + this.gameColor) * 31) + this.price) * 31) + this.color.hashCode()) * 31;
        boolean z = this.selected;
        int i = 0;
        if (z) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.startColor;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "CarColorItem(id=" + this.id + ", gameColor=" + this.gameColor + ", price=" + this.price + ", color=" + this.color + ", selected=" + this.selected + ", startColor=" + this.startColor + ')';
    }

    public CarColorItem(int i, int i2, int i3, String color, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.id = i;
        this.gameColor = i2;
        this.price = i3;
        this.color = color;
        this.selected = z;
        this.startColor = z2;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final int getGameColor() {
        return this.gameColor;
    }

    public final void setGameColor(int i) {
        this.gameColor = i;
    }

    public final int getPrice() {
        return this.price;
    }

    public final void setPrice(int i) {
        this.price = i;
    }

    public final String getColor() {
        return this.color;
    }

    public final void setColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.color = str;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    public final boolean getStartColor() {
        return this.startColor;
    }

    public final void setStartColor(boolean z) {
        this.startColor = z;
    }
}
