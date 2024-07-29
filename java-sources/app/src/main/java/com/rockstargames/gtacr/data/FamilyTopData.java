package com.rockstargames.gtacr.data;

import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0018\"\u0004\b\u001b\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u0006/"}, d2 = {"Lcom/rockstargames/gtacr/data/FamilyTopData;", "", "position", "", "familyName", "Landroid/text/Spanned;", "familyType", "familyRep", "familyGlasses", "backgroundColor", "leftIcon", "rightIcon", "isClicked", "", "ifMyFamily", "(ILandroid/text/Spanned;IIIIIIZZ)V", "getBackgroundColor", "()I", "getFamilyGlasses", "getFamilyName", "()Landroid/text/Spanned;", "getFamilyRep", "getFamilyType", "getIfMyFamily", "()Z", "setIfMyFamily", "(Z)V", "setClicked", "getLeftIcon", "getPosition", "getRightIcon", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyTopData {
    private final int backgroundColor;
    private final int familyGlasses;
    private final Spanned familyName;
    private final int familyRep;
    private final int familyType;
    private boolean ifMyFamily;
    private boolean isClicked;
    private final int leftIcon;
    private final int position;
    private final int rightIcon;

    public final int component1() {
        return this.position;
    }

    public final boolean component10() {
        return this.ifMyFamily;
    }

    public final Spanned component2() {
        return this.familyName;
    }

    public final int component3() {
        return this.familyType;
    }

    public final int component4() {
        return this.familyRep;
    }

    public final int component5() {
        return this.familyGlasses;
    }

    public final int component6() {
        return this.backgroundColor;
    }

    public final int component7() {
        return this.leftIcon;
    }

    public final int component8() {
        return this.rightIcon;
    }

    public final boolean component9() {
        return this.isClicked;
    }

    public final FamilyTopData copy(int i, Spanned familyName, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(familyName, "familyName");
        return new FamilyTopData(i, familyName, i2, i3, i4, i5, i6, i7, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilyTopData) {
            FamilyTopData familyTopData = (FamilyTopData) obj;
            return this.position == familyTopData.position && Intrinsics.areEqual(this.familyName, familyTopData.familyName) && this.familyType == familyTopData.familyType && this.familyRep == familyTopData.familyRep && this.familyGlasses == familyTopData.familyGlasses && this.backgroundColor == familyTopData.backgroundColor && this.leftIcon == familyTopData.leftIcon && this.rightIcon == familyTopData.rightIcon && this.isClicked == familyTopData.isClicked && this.ifMyFamily == familyTopData.ifMyFamily;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((this.position * 31) + this.familyName.hashCode()) * 31) + this.familyType) * 31) + this.familyRep) * 31) + this.familyGlasses) * 31) + this.backgroundColor) * 31) + this.leftIcon) * 31) + this.rightIcon) * 31;
        boolean z = this.isClicked;
        int i = 0;
        if (z) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.ifMyFamily;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "FamilyTopData(position=" + this.position + ", familyName=" + ((Object) this.familyName) + ", familyType=" + this.familyType + ", familyRep=" + this.familyRep + ", familyGlasses=" + this.familyGlasses + ", backgroundColor=" + this.backgroundColor + ", leftIcon=" + this.leftIcon + ", rightIcon=" + this.rightIcon + ", isClicked=" + this.isClicked + ", ifMyFamily=" + this.ifMyFamily + ')';
    }

    public FamilyTopData(int i, Spanned familyName, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(familyName, "familyName");
        this.position = i;
        this.familyName = familyName;
        this.familyType = i2;
        this.familyRep = i3;
        this.familyGlasses = i4;
        this.backgroundColor = i5;
        this.leftIcon = i6;
        this.rightIcon = i7;
        this.isClicked = z;
        this.ifMyFamily = z2;
    }

    public FamilyTopData(int i, Spanned spanned, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, spanned, i2, i3, i4, i5, i6, i7, (i8 & 256) != 0 ? false : z, (i8 & 512) != 0 ? false : z2);
    }

    public final int getPosition() {
        return this.position;
    }

    public final Spanned getFamilyName() {
        return this.familyName;
    }

    public final int getFamilyType() {
        return this.familyType;
    }

    public final int getFamilyRep() {
        return this.familyRep;
    }

    public final int getFamilyGlasses() {
        return this.familyGlasses;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getLeftIcon() {
        return this.leftIcon;
    }

    public final int getRightIcon() {
        return this.rightIcon;
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final void setClicked(boolean z) {
        this.isClicked = z;
    }

    public final boolean getIfMyFamily() {
        return this.ifMyFamily;
    }

    public final void setIfMyFamily(boolean z) {
        this.ifMyFamily = z;
    }
}
