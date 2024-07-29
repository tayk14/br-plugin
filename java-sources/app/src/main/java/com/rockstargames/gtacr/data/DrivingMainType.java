package com.rockstargames.gtacr.data;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\r\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u0014¨\u0006#"}, d2 = {"Lcom/rockstargames/gtacr/data/DrivingMainType;", "", GetKeys.GET_PLAYERS_ID, "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "image", FirebaseAnalytics.Param.PRICE, "isUnBlock", "isCheck", "", "(ILjava/lang/String;Ljava/lang/String;IIZ)V", "getId", "()I", "getImage", "()Ljava/lang/String;", "()Z", "setCheck", "(Z)V", "setUnBlock", "(I)V", "getName", "getPrice", "setPrice", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DrivingMainType {
    private final int id;
    private final String image;
    private boolean isCheck;
    private int isUnBlock;
    private final String name;
    private int price;

    public static DrivingMainType copy$default(DrivingMainType drivingMainType, int i, String str, String str2, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = drivingMainType.id;
        }
        if ((i4 & 2) != 0) {
            str = drivingMainType.name;
        }
        String str3 = str;
        if ((i4 & 4) != 0) {
            str2 = drivingMainType.image;
        }
        String str4 = str2;
        if ((i4 & 8) != 0) {
            i2 = drivingMainType.price;
        }
        int i5 = i2;
        if ((i4 & 16) != 0) {
            i3 = drivingMainType.isUnBlock;
        }
        int i6 = i3;
        if ((i4 & 32) != 0) {
            z = drivingMainType.isCheck;
        }
        return drivingMainType.copy(i, str3, str4, i5, i6, z);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.image;
    }

    public final int component4() {
        return this.price;
    }

    public final int component5() {
        return this.isUnBlock;
    }

    public final boolean component6() {
        return this.isCheck;
    }

    public final DrivingMainType copy(int i, String name, String image, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(image, "image");
        return new DrivingMainType(i, name, image, i2, i3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrivingMainType) {
            DrivingMainType drivingMainType = (DrivingMainType) obj;
            return this.id == drivingMainType.id && Intrinsics.areEqual(this.name, drivingMainType.name) && Intrinsics.areEqual(this.image, drivingMainType.image) && this.price == drivingMainType.price && this.isUnBlock == drivingMainType.isUnBlock && this.isCheck == drivingMainType.isCheck;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((this.id * 31) + this.name.hashCode()) * 31) + this.image.hashCode()) * 31) + this.price) * 31) + this.isUnBlock) * 31;
        boolean z = this.isCheck;
        int i = 0;
        if (z) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "DrivingMainType(id=" + this.id + ", name=" + this.name + ", image=" + this.image + ", price=" + this.price + ", isUnBlock=" + this.isUnBlock + ", isCheck=" + this.isCheck + ')';
    }

    public DrivingMainType(int i, String name, String image, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(image, "image");
        this.id = i;
        this.name = name;
        this.image = image;
        this.price = i2;
        this.isUnBlock = i3;
        this.isCheck = z;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getImage() {
        return this.image;
    }

    public final int getPrice() {
        return this.price;
    }

    public final void setPrice(int i) {
        this.price = i;
    }

    public final int isUnBlock() {
        return this.isUnBlock;
    }

    public final void setUnBlock(int i) {
        this.isUnBlock = i;
    }

    public final boolean isCheck() {
        return this.isCheck;
    }

    public final void setCheck(boolean z) {
        this.isCheck = z;
    }
}
