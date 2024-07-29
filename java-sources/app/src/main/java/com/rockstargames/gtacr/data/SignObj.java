package com.rockstargames.gtacr.data;

import android.text.SpannableString;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010%\u001a\u00020\u0010HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0088\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\bHÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b \u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\"\u0010\u0015¨\u00064"}, d2 = {"Lcom/rockstargames/gtacr/data/SignObj;", "", "leftPosition", "", "leftSignName", "Landroid/text/SpannableString;", "leftStartSpan", "leftSignDescription", "", "leftSignIcon", "rightPosition", "rightSignName", "rightStartSpan", "rightSignDescription", "rightSignIcon", "ifShowUnderline", "", "(Ljava/lang/Integer;Landroid/text/SpannableString;ILjava/lang/String;ILjava/lang/Integer;Landroid/text/SpannableString;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Z)V", "getIfShowUnderline", "()Z", "getLeftPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLeftSignDescription", "()Ljava/lang/String;", "getLeftSignIcon", "()I", "getLeftSignName", "()Landroid/text/SpannableString;", "getLeftStartSpan", "getRightPosition", "getRightSignDescription", "getRightSignIcon", "getRightSignName", "getRightStartSpan", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Landroid/text/SpannableString;ILjava/lang/String;ILjava/lang/Integer;Landroid/text/SpannableString;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Z)Lcom/rockstargames/gtacr/data/SignObj;", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignObj {
    private final boolean ifShowUnderline;
    private final Integer leftPosition;
    private final String leftSignDescription;
    private final int leftSignIcon;
    private final SpannableString leftSignName;
    private final int leftStartSpan;
    private final Integer rightPosition;
    private final String rightSignDescription;
    private final Integer rightSignIcon;
    private final SpannableString rightSignName;
    private final Integer rightStartSpan;

    public final Integer component1() {
        return this.leftPosition;
    }

    public final Integer component10() {
        return this.rightSignIcon;
    }

    public final boolean component11() {
        return this.ifShowUnderline;
    }

    public final SpannableString component2() {
        return this.leftSignName;
    }

    public final int component3() {
        return this.leftStartSpan;
    }

    public final String component4() {
        return this.leftSignDescription;
    }

    public final int component5() {
        return this.leftSignIcon;
    }

    public final Integer component6() {
        return this.rightPosition;
    }

    public final SpannableString component7() {
        return this.rightSignName;
    }

    public final Integer component8() {
        return this.rightStartSpan;
    }

    public final String component9() {
        return this.rightSignDescription;
    }

    public final SignObj copy(Integer num, SpannableString leftSignName, int i, String leftSignDescription, int i2, Integer num2, SpannableString spannableString, Integer num3, String str, Integer num4, boolean z) {
        Intrinsics.checkNotNullParameter(leftSignName, "leftSignName");
        Intrinsics.checkNotNullParameter(leftSignDescription, "leftSignDescription");
        return new SignObj(num, leftSignName, i, leftSignDescription, i2, num2, spannableString, num3, str, num4, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SignObj) {
            SignObj signObj = (SignObj) obj;
            return Intrinsics.areEqual(this.leftPosition, signObj.leftPosition) && Intrinsics.areEqual(this.leftSignName, signObj.leftSignName) && this.leftStartSpan == signObj.leftStartSpan && Intrinsics.areEqual(this.leftSignDescription, signObj.leftSignDescription) && this.leftSignIcon == signObj.leftSignIcon && Intrinsics.areEqual(this.rightPosition, signObj.rightPosition) && Intrinsics.areEqual(this.rightSignName, signObj.rightSignName) && Intrinsics.areEqual(this.rightStartSpan, signObj.rightStartSpan) && Intrinsics.areEqual(this.rightSignDescription, signObj.rightSignDescription) && Intrinsics.areEqual(this.rightSignIcon, signObj.rightSignIcon) && this.ifShowUnderline == signObj.ifShowUnderline;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.leftPosition;
        int hashCode = (((((((((num == null ? 0 : num.hashCode()) * 31) + this.leftSignName.hashCode()) * 31) + this.leftStartSpan) * 31) + this.leftSignDescription.hashCode()) * 31) + this.leftSignIcon) * 31;
        Integer num2 = this.rightPosition;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        SpannableString spannableString = this.rightSignName;
        int hashCode3 = (hashCode2 + (spannableString == null ? 0 : spannableString.hashCode())) * 31;
        Integer num3 = this.rightStartSpan;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.rightSignDescription;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num4 = this.rightSignIcon;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 31;
        boolean z = this.ifShowUnderline;
        int i = 0;
        if (z) {
            i = 1;
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "SignObj(leftPosition=" + this.leftPosition + ", leftSignName=" + ((Object) this.leftSignName) + ", leftStartSpan=" + this.leftStartSpan + ", leftSignDescription=" + this.leftSignDescription + ", leftSignIcon=" + this.leftSignIcon + ", rightPosition=" + this.rightPosition + ", rightSignName=" + ((Object) this.rightSignName) + ", rightStartSpan=" + this.rightStartSpan + ", rightSignDescription=" + ((Object) this.rightSignDescription) + ", rightSignIcon=" + this.rightSignIcon + ", ifShowUnderline=" + this.ifShowUnderline + ')';
    }

    public SignObj(Integer num, SpannableString leftSignName, int i, String leftSignDescription, int i2, Integer num2, SpannableString spannableString, Integer num3, String str, Integer num4, boolean z) {
        Intrinsics.checkNotNullParameter(leftSignName, "leftSignName");
        Intrinsics.checkNotNullParameter(leftSignDescription, "leftSignDescription");
        this.leftPosition = num;
        this.leftSignName = leftSignName;
        this.leftStartSpan = i;
        this.leftSignDescription = leftSignDescription;
        this.leftSignIcon = i2;
        this.rightPosition = num2;
        this.rightSignName = spannableString;
        this.rightStartSpan = num3;
        this.rightSignDescription = str;
        this.rightSignIcon = num4;
        this.ifShowUnderline = z;
    }

    public SignObj(Integer num, SpannableString spannableString, int i, String str, int i2, Integer num2, SpannableString spannableString2, Integer num3, String str2, Integer num4, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, spannableString, i, str, i2, (i3 & 32) != 0 ? null : num2, spannableString2, num3, str2, num4, z);
    }

    public final Integer getLeftPosition() {
        return this.leftPosition;
    }

    public final SpannableString getLeftSignName() {
        return this.leftSignName;
    }

    public final int getLeftStartSpan() {
        return this.leftStartSpan;
    }

    public final String getLeftSignDescription() {
        return this.leftSignDescription;
    }

    public final int getLeftSignIcon() {
        return this.leftSignIcon;
    }

    public final Integer getRightPosition() {
        return this.rightPosition;
    }

    public final SpannableString getRightSignName() {
        return this.rightSignName;
    }

    public final Integer getRightStartSpan() {
        return this.rightStartSpan;
    }

    public final String getRightSignDescription() {
        return this.rightSignDescription;
    }

    public final Integer getRightSignIcon() {
        return this.rightSignIcon;
    }

    public final boolean getIfShowUnderline() {
        return this.ifShowUnderline;
    }
}
