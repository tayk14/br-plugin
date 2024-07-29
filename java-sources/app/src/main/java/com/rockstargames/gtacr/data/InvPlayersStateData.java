package com.rockstargames.gtacr.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/rockstargames/gtacr/data/InvPlayersStateData;", "", "typeState", "", "thisValueState", "maxValueState", "iconsRes", "", "(IIILjava/lang/String;)V", "getIconsRes", "()Ljava/lang/String;", "setIconsRes", "(Ljava/lang/String;)V", "getMaxValueState", "()I", "setMaxValueState", "(I)V", "getThisValueState", "setThisValueState", "getTypeState", "setTypeState", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InvPlayersStateData {
    private String iconsRes;
    private int maxValueState;
    private int thisValueState;
    private int typeState;

    public static InvPlayersStateData copy$default(InvPlayersStateData invPlayersStateData, int i, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = invPlayersStateData.typeState;
        }
        if ((i4 & 2) != 0) {
            i2 = invPlayersStateData.thisValueState;
        }
        if ((i4 & 4) != 0) {
            i3 = invPlayersStateData.maxValueState;
        }
        if ((i4 & 8) != 0) {
            str = invPlayersStateData.iconsRes;
        }
        return invPlayersStateData.copy(i, i2, i3, str);
    }

    public final int component1() {
        return this.typeState;
    }

    public final int component2() {
        return this.thisValueState;
    }

    public final int component3() {
        return this.maxValueState;
    }

    public final String component4() {
        return this.iconsRes;
    }

    public final InvPlayersStateData copy(int i, int i2, int i3, String iconsRes) {
        Intrinsics.checkNotNullParameter(iconsRes, "iconsRes");
        return new InvPlayersStateData(i, i2, i3, iconsRes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InvPlayersStateData) {
            InvPlayersStateData invPlayersStateData = (InvPlayersStateData) obj;
            return this.typeState == invPlayersStateData.typeState && this.thisValueState == invPlayersStateData.thisValueState && this.maxValueState == invPlayersStateData.maxValueState && Intrinsics.areEqual(this.iconsRes, invPlayersStateData.iconsRes);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.typeState * 31) + this.thisValueState) * 31) + this.maxValueState) * 31) + this.iconsRes.hashCode();
    }

    public String toString() {
        return "InvPlayersStateData(typeState=" + this.typeState + ", thisValueState=" + this.thisValueState + ", maxValueState=" + this.maxValueState + ", iconsRes=" + this.iconsRes + ')';
    }

    public InvPlayersStateData(int i, int i2, int i3, String iconsRes) {
        Intrinsics.checkNotNullParameter(iconsRes, "iconsRes");
        this.typeState = i;
        this.thisValueState = i2;
        this.maxValueState = i3;
        this.iconsRes = iconsRes;
    }

    public final int getTypeState() {
        return this.typeState;
    }

    public final void setTypeState(int i) {
        this.typeState = i;
    }

    public final int getThisValueState() {
        return this.thisValueState;
    }

    public final void setThisValueState(int i) {
        this.thisValueState = i;
    }

    public final int getMaxValueState() {
        return this.maxValueState;
    }

    public final void setMaxValueState(int i) {
        this.maxValueState = i;
    }

    public final String getIconsRes() {
        return this.iconsRes;
    }

    public final void setIconsRes(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconsRes = str;
    }
}
