package com.rockstargames.gtacr.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/rockstargames/gtacr/data/FamilyNotificationData;", "", "notificationsValue", "", "notificationsAuthor", "notificationsId", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getNotificationsAuthor", "()Ljava/lang/String;", "getNotificationsId", "()I", "getNotificationsValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyNotificationData {
    private final String notificationsAuthor;
    private final int notificationsId;
    private final String notificationsValue;

    public static FamilyNotificationData copy$default(FamilyNotificationData familyNotificationData, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = familyNotificationData.notificationsValue;
        }
        if ((i2 & 2) != 0) {
            str2 = familyNotificationData.notificationsAuthor;
        }
        if ((i2 & 4) != 0) {
            i = familyNotificationData.notificationsId;
        }
        return familyNotificationData.copy(str, str2, i);
    }

    public final String component1() {
        return this.notificationsValue;
    }

    public final String component2() {
        return this.notificationsAuthor;
    }

    public final int component3() {
        return this.notificationsId;
    }

    public final FamilyNotificationData copy(String notificationsValue, String notificationsAuthor, int i) {
        Intrinsics.checkNotNullParameter(notificationsValue, "notificationsValue");
        Intrinsics.checkNotNullParameter(notificationsAuthor, "notificationsAuthor");
        return new FamilyNotificationData(notificationsValue, notificationsAuthor, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilyNotificationData) {
            FamilyNotificationData familyNotificationData = (FamilyNotificationData) obj;
            return Intrinsics.areEqual(this.notificationsValue, familyNotificationData.notificationsValue) && Intrinsics.areEqual(this.notificationsAuthor, familyNotificationData.notificationsAuthor) && this.notificationsId == familyNotificationData.notificationsId;
        }
        return false;
    }

    public int hashCode() {
        return (((this.notificationsValue.hashCode() * 31) + this.notificationsAuthor.hashCode()) * 31) + this.notificationsId;
    }

    public String toString() {
        return "FamilyNotificationData(notificationsValue=" + this.notificationsValue + ", notificationsAuthor=" + this.notificationsAuthor + ", notificationsId=" + this.notificationsId + ')';
    }

    public FamilyNotificationData(String notificationsValue, String notificationsAuthor, int i) {
        Intrinsics.checkNotNullParameter(notificationsValue, "notificationsValue");
        Intrinsics.checkNotNullParameter(notificationsAuthor, "notificationsAuthor");
        this.notificationsValue = notificationsValue;
        this.notificationsAuthor = notificationsAuthor;
        this.notificationsId = i;
    }

    public final String getNotificationsValue() {
        return this.notificationsValue;
    }

    public final String getNotificationsAuthor() {
        return this.notificationsAuthor;
    }

    public final int getNotificationsId() {
        return this.notificationsId;
    }
}
