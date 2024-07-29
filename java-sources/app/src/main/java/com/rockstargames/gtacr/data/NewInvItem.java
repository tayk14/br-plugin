package com.rockstargames.gtacr.data;

import android.graphics.Bitmap;
import blackrussia.online.network.InvItems$$ExternalSynthetic0;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bP\b\u0086\b\u0018\u00002\u00020\u0001B«\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\rHÆ\u0003J\t\u0010S\u001a\u00020\rHÆ\u0003J\t\u0010T\u001a\u00020\rHÆ\u0003J\t\u0010U\u001a\u00020\rHÆ\u0003J\t\u0010V\u001a\u00020\rHÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010[\u001a\u00020\u001aHÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0005HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\tHÆ\u0003J\t\u0010a\u001a\u00020\tHÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\rHÆ\u0003J\t\u0010d\u001a\u00020\rHÆ\u0003JÓ\u0001\u0010e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010f\u001a\u00020\u001a2\b\u0010g\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010h\u001a\u00020\u0003HÖ\u0001J\t\u0010i\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\u001a\u0010\u001b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00108\"\u0004\b<\u0010:R\u001a\u0010\u000f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010&\"\u0004\b@\u0010(R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001e\"\u0004\bF\u0010 R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010*\"\u0004\bH\u0010,R\u001a\u0010\u0010\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00108\"\u0004\bJ\u0010:R\u001a\u0010\u0011\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00108\"\u0004\bL\u0010:R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00108\"\u0004\bN\u0010:R\u001a\u0010\u0013\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00108\"\u0004\bP\u0010:¨\u0006j"}, d2 = {"Lcom/rockstargames/gtacr/data/NewInvItem;", "", GetKeys.GET_PLAYERS_ID, "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "desc", "modelid", "weight", "", "addw", "fold", "shiftX", "", "shiftY", "shiftZ", "x", "y", "z", "zoom", "itemsValue", "textIfException", "whoseItem", "thisBitmap", "Landroid/graphics/Bitmap;", "check", "", "position", "(ILjava/lang/String;Ljava/lang/String;IDDIFFFFFFFILjava/lang/String;ILandroid/graphics/Bitmap;ZI)V", "getAddw", "()D", "setAddw", "(D)V", "getCheck", "()Z", "setCheck", "(Z)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getFold", "()I", "setFold", "(I)V", "getId", "setId", "getItemsValue", "setItemsValue", "getModelid", "setModelid", "getName", "setName", "getPosition", "setPosition", "getShiftX", "()F", "setShiftX", "(F)V", "getShiftY", "setShiftY", "getShiftZ", "setShiftZ", "getTextIfException", "setTextIfException", "getThisBitmap", "()Landroid/graphics/Bitmap;", "setThisBitmap", "(Landroid/graphics/Bitmap;)V", "getWeight", "setWeight", "getWhoseItem", "setWhoseItem", "getX", "setX", "getY", "setY", "getZ", "setZ", "getZoom", "setZoom", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewInvItem {
    private double addw;
    private boolean check;
    private String desc;
    private int fold;
    private int id;
    private int itemsValue;
    private int modelid;
    private String name;
    private int position;
    private float shiftX;
    private float shiftY;
    private float shiftZ;
    private String textIfException;
    private Bitmap thisBitmap;
    private double weight;
    private int whoseItem;
    private float x;
    private float y;
    private float z;
    private float zoom;

    public final int component1() {
        return this.id;
    }

    public final float component10() {
        return this.shiftZ;
    }

    public final float component11() {
        return this.x;
    }

    public final float component12() {
        return this.y;
    }

    public final float component13() {
        return this.z;
    }

    public final float component14() {
        return this.zoom;
    }

    public final int component15() {
        return this.itemsValue;
    }

    public final String component16() {
        return this.textIfException;
    }

    public final int component17() {
        return this.whoseItem;
    }

    public final Bitmap component18() {
        return this.thisBitmap;
    }

    public final boolean component19() {
        return this.check;
    }

    public final String component2() {
        return this.name;
    }

    public final int component20() {
        return this.position;
    }

    public final String component3() {
        return this.desc;
    }

    public final int component4() {
        return this.modelid;
    }

    public final double component5() {
        return this.weight;
    }

    public final double component6() {
        return this.addw;
    }

    public final int component7() {
        return this.fold;
    }

    public final float component8() {
        return this.shiftX;
    }

    public final float component9() {
        return this.shiftY;
    }

    public final NewInvItem copy(int i, String name, String desc, int i2, double d, double d2, int i3, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i4, String textIfException, int i5, Bitmap bitmap, boolean z, int i6) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(textIfException, "textIfException");
        return new NewInvItem(i, name, desc, i2, d, d2, i3, f, f2, f3, f4, f5, f6, f7, i4, textIfException, i5, bitmap, z, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewInvItem) {
            NewInvItem newInvItem = (NewInvItem) obj;
            return this.id == newInvItem.id && Intrinsics.areEqual(this.name, newInvItem.name) && Intrinsics.areEqual(this.desc, newInvItem.desc) && this.modelid == newInvItem.modelid && Intrinsics.areEqual((Object) Double.valueOf(this.weight), (Object) Double.valueOf(newInvItem.weight)) && Intrinsics.areEqual((Object) Double.valueOf(this.addw), (Object) Double.valueOf(newInvItem.addw)) && this.fold == newInvItem.fold && Intrinsics.areEqual((Object) Float.valueOf(this.shiftX), (Object) Float.valueOf(newInvItem.shiftX)) && Intrinsics.areEqual((Object) Float.valueOf(this.shiftY), (Object) Float.valueOf(newInvItem.shiftY)) && Intrinsics.areEqual((Object) Float.valueOf(this.shiftZ), (Object) Float.valueOf(newInvItem.shiftZ)) && Intrinsics.areEqual((Object) Float.valueOf(this.x), (Object) Float.valueOf(newInvItem.x)) && Intrinsics.areEqual((Object) Float.valueOf(this.y), (Object) Float.valueOf(newInvItem.y)) && Intrinsics.areEqual((Object) Float.valueOf(this.z), (Object) Float.valueOf(newInvItem.z)) && Intrinsics.areEqual((Object) Float.valueOf(this.zoom), (Object) Float.valueOf(newInvItem.zoom)) && this.itemsValue == newInvItem.itemsValue && Intrinsics.areEqual(this.textIfException, newInvItem.textIfException) && this.whoseItem == newInvItem.whoseItem && Intrinsics.areEqual(this.thisBitmap, newInvItem.thisBitmap) && this.check == newInvItem.check && this.position == newInvItem.position;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((this.id * 31) + this.name.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.modelid) * 31) + InvItems$$ExternalSynthetic0.m0(this.weight)) * 31) + InvItems$$ExternalSynthetic0.m0(this.addw)) * 31) + this.fold) * 31) + Float.floatToIntBits(this.shiftX)) * 31) + Float.floatToIntBits(this.shiftY)) * 31) + Float.floatToIntBits(this.shiftZ)) * 31) + Float.floatToIntBits(this.x)) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.z)) * 31) + Float.floatToIntBits(this.zoom)) * 31) + this.itemsValue) * 31) + this.textIfException.hashCode()) * 31) + this.whoseItem) * 31;
        Bitmap bitmap = this.thisBitmap;
        int hashCode2 = (hashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        boolean z = this.check;
        int i = 0;
        if (z) {
            i = 1;
        }
        return ((hashCode2 + i) * 31) + this.position;
    }

    public String toString() {
        return "NewInvItem(id=" + this.id + ", name=" + this.name + ", desc=" + this.desc + ", modelid=" + this.modelid + ", weight=" + this.weight + ", addw=" + this.addw + ", fold=" + this.fold + ", shiftX=" + this.shiftX + ", shiftY=" + this.shiftY + ", shiftZ=" + this.shiftZ + ", x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", zoom=" + this.zoom + ", itemsValue=" + this.itemsValue + ", textIfException=" + this.textIfException + ", whoseItem=" + this.whoseItem + ", thisBitmap=" + this.thisBitmap + ", check=" + this.check + ", position=" + this.position + ')';
    }

    public NewInvItem(int i, String name, String desc, int i2, double d, double d2, int i3, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i4, String textIfException, int i5, Bitmap bitmap, boolean z, int i6) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(textIfException, "textIfException");
        this.id = i;
        this.name = name;
        this.desc = desc;
        this.modelid = i2;
        this.weight = d;
        this.addw = d2;
        this.fold = i3;
        this.shiftX = f;
        this.shiftY = f2;
        this.shiftZ = f3;
        this.x = f4;
        this.y = f5;
        this.z = f6;
        this.zoom = f7;
        this.itemsValue = i4;
        this.textIfException = textIfException;
        this.whoseItem = i5;
        this.thisBitmap = bitmap;
        this.check = z;
        this.position = i6;
    }

    public NewInvItem(int i, String str, String str2, int i2, double d, double d2, int i3, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i4, String str3, int i5, Bitmap bitmap, boolean z, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, i2, d, d2, i3, f, f2, f3, f4, f5, f6, f7, i4, str3, (i7 & 65536) != 0 ? 0 : i5, bitmap, (i7 & 262144) != 0 ? false : z, i6);
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

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final int getModelid() {
        return this.modelid;
    }

    public final void setModelid(int i) {
        this.modelid = i;
    }

    public final double getWeight() {
        return this.weight;
    }

    public final void setWeight(double d) {
        this.weight = d;
    }

    public final double getAddw() {
        return this.addw;
    }

    public final void setAddw(double d) {
        this.addw = d;
    }

    public final int getFold() {
        return this.fold;
    }

    public final void setFold(int i) {
        this.fold = i;
    }

    public final float getShiftX() {
        return this.shiftX;
    }

    public final void setShiftX(float f) {
        this.shiftX = f;
    }

    public final float getShiftY() {
        return this.shiftY;
    }

    public final void setShiftY(float f) {
        this.shiftY = f;
    }

    public final float getShiftZ() {
        return this.shiftZ;
    }

    public final void setShiftZ(float f) {
        this.shiftZ = f;
    }

    public final float getX() {
        return this.x;
    }

    public final void setX(float f) {
        this.x = f;
    }

    public final float getY() {
        return this.y;
    }

    public final void setY(float f) {
        this.y = f;
    }

    public final float getZ() {
        return this.z;
    }

    public final void setZ(float f) {
        this.z = f;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public final int getItemsValue() {
        return this.itemsValue;
    }

    public final void setItemsValue(int i) {
        this.itemsValue = i;
    }

    public final String getTextIfException() {
        return this.textIfException;
    }

    public final void setTextIfException(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.textIfException = str;
    }

    public final int getWhoseItem() {
        return this.whoseItem;
    }

    public final void setWhoseItem(int i) {
        this.whoseItem = i;
    }

    public final Bitmap getThisBitmap() {
        return this.thisBitmap;
    }

    public final void setThisBitmap(Bitmap bitmap) {
        this.thisBitmap = bitmap;
    }

    public final boolean getCheck() {
        return this.check;
    }

    public final void setCheck(boolean z) {
        this.check = z;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }
}
