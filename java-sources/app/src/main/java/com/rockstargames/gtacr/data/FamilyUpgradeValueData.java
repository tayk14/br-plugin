package com.rockstargames.gtacr.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/rockstargames/gtacr/data/FamilyUpgradeValueData;", "", "description", "", "value", "", "(Ljava/lang/String;I)V", "getDescription", "()Ljava/lang/String;", "getValue", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyUpgradeValueData {
    private final String description;
    private final int value;

    public static FamilyUpgradeValueData copy$default(FamilyUpgradeValueData familyUpgradeValueData, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = familyUpgradeValueData.description;
        }
        if ((i2 & 2) != 0) {
            i = familyUpgradeValueData.value;
        }
        return familyUpgradeValueData.copy(str, i);
    }

    public final String component1() {
        return this.description;
    }

    public final int component2() {
        return this.value;
    }

    public final FamilyUpgradeValueData copy(String description, int i) {
        Intrinsics.checkNotNullParameter(description, "description");
        return new FamilyUpgradeValueData(description, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilyUpgradeValueData) {
            FamilyUpgradeValueData familyUpgradeValueData = (FamilyUpgradeValueData) obj;
            return Intrinsics.areEqual(this.description, familyUpgradeValueData.description) && this.value == familyUpgradeValueData.value;
        }
        return false;
    }

    public int hashCode() {
        return (this.description.hashCode() * 31) + this.value;
    }

    public String toString() {
        return "FamilyUpgradeValueData(description=" + this.description + ", value=" + this.value + ')';
    }

    public FamilyUpgradeValueData(String description, int i) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.description = description;
        this.value = i;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getValue() {
        return this.value;
    }
}
