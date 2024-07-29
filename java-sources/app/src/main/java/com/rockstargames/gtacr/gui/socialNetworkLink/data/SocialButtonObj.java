package com.rockstargames.gtacr.gui.socialNetworkLink.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000b\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/rockstargames/gtacr/gui/socialNetworkLink/data/SocialButtonObj;", "", "buttonId", "", "buttonName", "", "buttonResIdIfActive", "buttonResIdIfNotActive", "isActive", "(ILjava/lang/String;III)V", "getButtonId", "()I", "getButtonName", "()Ljava/lang/String;", "getButtonResIdIfActive", "getButtonResIdIfNotActive", "setActive", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SocialButtonObj {
    private final int buttonId;
    private final String buttonName;
    private final int buttonResIdIfActive;
    private final int buttonResIdIfNotActive;
    private int isActive;

    public static SocialButtonObj copy$default(SocialButtonObj socialButtonObj, int i, String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = socialButtonObj.buttonId;
        }
        if ((i5 & 2) != 0) {
            str = socialButtonObj.buttonName;
        }
        String str2 = str;
        if ((i5 & 4) != 0) {
            i2 = socialButtonObj.buttonResIdIfActive;
        }
        int i6 = i2;
        if ((i5 & 8) != 0) {
            i3 = socialButtonObj.buttonResIdIfNotActive;
        }
        int i7 = i3;
        if ((i5 & 16) != 0) {
            i4 = socialButtonObj.isActive;
        }
        return socialButtonObj.copy(i, str2, i6, i7, i4);
    }

    public final int component1() {
        return this.buttonId;
    }

    public final String component2() {
        return this.buttonName;
    }

    public final int component3() {
        return this.buttonResIdIfActive;
    }

    public final int component4() {
        return this.buttonResIdIfNotActive;
    }

    public final int component5() {
        return this.isActive;
    }

    public final SocialButtonObj copy(int i, String buttonName, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        return new SocialButtonObj(i, buttonName, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SocialButtonObj) {
            SocialButtonObj socialButtonObj = (SocialButtonObj) obj;
            return this.buttonId == socialButtonObj.buttonId && Intrinsics.areEqual(this.buttonName, socialButtonObj.buttonName) && this.buttonResIdIfActive == socialButtonObj.buttonResIdIfActive && this.buttonResIdIfNotActive == socialButtonObj.buttonResIdIfNotActive && this.isActive == socialButtonObj.isActive;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.buttonId * 31) + this.buttonName.hashCode()) * 31) + this.buttonResIdIfActive) * 31) + this.buttonResIdIfNotActive) * 31) + this.isActive;
    }

    public String toString() {
        return "SocialButtonObj(buttonId=" + this.buttonId + ", buttonName=" + this.buttonName + ", buttonResIdIfActive=" + this.buttonResIdIfActive + ", buttonResIdIfNotActive=" + this.buttonResIdIfNotActive + ", isActive=" + this.isActive + ')';
    }

    public SocialButtonObj(int i, String buttonName, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        this.buttonId = i;
        this.buttonName = buttonName;
        this.buttonResIdIfActive = i2;
        this.buttonResIdIfNotActive = i3;
        this.isActive = i4;
    }

    public final int getButtonId() {
        return this.buttonId;
    }

    public final String getButtonName() {
        return this.buttonName;
    }

    public final int getButtonResIdIfActive() {
        return this.buttonResIdIfActive;
    }

    public final int getButtonResIdIfNotActive() {
        return this.buttonResIdIfNotActive;
    }

    public final int isActive() {
        return this.isActive;
    }

    public final void setActive(int i) {
        this.isActive = i;
    }
}
