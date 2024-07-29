package com.rockstargames.gtacr.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012JR\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\n\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018¨\u0006*"}, d2 = {"Lcom/rockstargames/gtacr/data/FamilyRankOrColorData;", "", "statusType", "", "statusName", "", "currentStatus", "thisColor", "ifStartedColor", "", "isClicked", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCurrentStatus", "()Ljava/lang/Integer;", "setCurrentStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIfStartedColor", "()Ljava/lang/Boolean;", "setIfStartedColor", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setClicked", "getStatusName", "()Ljava/lang/String;", "setStatusName", "(Ljava/lang/String;)V", "getStatusType", "()I", "getThisColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/rockstargames/gtacr/data/FamilyRankOrColorData;", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyRankOrColorData {
    private Integer currentStatus;
    private Boolean ifStartedColor;
    private Boolean isClicked;
    private String statusName;
    private final int statusType;
    private final String thisColor;

    public static FamilyRankOrColorData copy$default(FamilyRankOrColorData familyRankOrColorData, int i, String str, Integer num, String str2, Boolean bool, Boolean bool2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = familyRankOrColorData.statusType;
        }
        if ((i2 & 2) != 0) {
            str = familyRankOrColorData.statusName;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            num = familyRankOrColorData.currentStatus;
        }
        Integer num2 = num;
        if ((i2 & 8) != 0) {
            str2 = familyRankOrColorData.thisColor;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            bool = familyRankOrColorData.ifStartedColor;
        }
        Boolean bool3 = bool;
        if ((i2 & 32) != 0) {
            bool2 = familyRankOrColorData.isClicked;
        }
        return familyRankOrColorData.copy(i, str3, num2, str4, bool3, bool2);
    }

    public final int component1() {
        return this.statusType;
    }

    public final String component2() {
        return this.statusName;
    }

    public final Integer component3() {
        return this.currentStatus;
    }

    public final String component4() {
        return this.thisColor;
    }

    public final Boolean component5() {
        return this.ifStartedColor;
    }

    public final Boolean component6() {
        return this.isClicked;
    }

    public final FamilyRankOrColorData copy(int i, String statusName, Integer num, String str, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(statusName, "statusName");
        return new FamilyRankOrColorData(i, statusName, num, str, bool, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilyRankOrColorData) {
            FamilyRankOrColorData familyRankOrColorData = (FamilyRankOrColorData) obj;
            return this.statusType == familyRankOrColorData.statusType && Intrinsics.areEqual(this.statusName, familyRankOrColorData.statusName) && Intrinsics.areEqual(this.currentStatus, familyRankOrColorData.currentStatus) && Intrinsics.areEqual(this.thisColor, familyRankOrColorData.thisColor) && Intrinsics.areEqual(this.ifStartedColor, familyRankOrColorData.ifStartedColor) && Intrinsics.areEqual(this.isClicked, familyRankOrColorData.isClicked);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.statusType * 31) + this.statusName.hashCode()) * 31;
        Integer num = this.currentStatus;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.thisColor;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.ifStartedColor;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isClicked;
        return hashCode4 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "FamilyRankOrColorData(statusType=" + this.statusType + ", statusName=" + this.statusName + ", currentStatus=" + this.currentStatus + ", thisColor=" + ((Object) this.thisColor) + ", ifStartedColor=" + this.ifStartedColor + ", isClicked=" + this.isClicked + ')';
    }

    public FamilyRankOrColorData(int i, String statusName, Integer num, String str, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(statusName, "statusName");
        this.statusType = i;
        this.statusName = statusName;
        this.currentStatus = num;
        this.thisColor = str;
        this.ifStartedColor = bool;
        this.isClicked = bool2;
    }

    public final int getStatusType() {
        return this.statusType;
    }

    public final String getStatusName() {
        return this.statusName;
    }

    public final void setStatusName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.statusName = str;
    }

    public final Integer getCurrentStatus() {
        return this.currentStatus;
    }

    public final void setCurrentStatus(Integer num) {
        this.currentStatus = num;
    }

    public final String getThisColor() {
        return this.thisColor;
    }

    public final Boolean getIfStartedColor() {
        return this.ifStartedColor;
    }

    public final void setIfStartedColor(Boolean bool) {
        this.ifStartedColor = bool;
    }

    public final Boolean isClicked() {
        return this.isClicked;
    }

    public final void setClicked(Boolean bool) {
        this.isClicked = bool;
    }
}
