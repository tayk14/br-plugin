package com.rockstargames.gtacr.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/rockstargames/gtacr/data/InvMainButtonsData;", "", "typeMenu", "", "nameButton", "", "iconsRes", "(ILjava/lang/String;Ljava/lang/String;)V", "getIconsRes", "()Ljava/lang/String;", "setIconsRes", "(Ljava/lang/String;)V", "getNameButton", "setNameButton", "getTypeMenu", "()I", "setTypeMenu", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InvMainButtonsData {
    private String iconsRes;
    private String nameButton;
    private int typeMenu;

    public static InvMainButtonsData copy$default(InvMainButtonsData invMainButtonsData, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = invMainButtonsData.typeMenu;
        }
        if ((i2 & 2) != 0) {
            str = invMainButtonsData.nameButton;
        }
        if ((i2 & 4) != 0) {
            str2 = invMainButtonsData.iconsRes;
        }
        return invMainButtonsData.copy(i, str, str2);
    }

    public final int component1() {
        return this.typeMenu;
    }

    public final String component2() {
        return this.nameButton;
    }

    public final String component3() {
        return this.iconsRes;
    }

    public final InvMainButtonsData copy(int i, String nameButton, String iconsRes) {
        Intrinsics.checkNotNullParameter(nameButton, "nameButton");
        Intrinsics.checkNotNullParameter(iconsRes, "iconsRes");
        return new InvMainButtonsData(i, nameButton, iconsRes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InvMainButtonsData) {
            InvMainButtonsData invMainButtonsData = (InvMainButtonsData) obj;
            return this.typeMenu == invMainButtonsData.typeMenu && Intrinsics.areEqual(this.nameButton, invMainButtonsData.nameButton) && Intrinsics.areEqual(this.iconsRes, invMainButtonsData.iconsRes);
        }
        return false;
    }

    public int hashCode() {
        return (((this.typeMenu * 31) + this.nameButton.hashCode()) * 31) + this.iconsRes.hashCode();
    }

    public String toString() {
        return "InvMainButtonsData(typeMenu=" + this.typeMenu + ", nameButton=" + this.nameButton + ", iconsRes=" + this.iconsRes + ')';
    }

    public InvMainButtonsData(int i, String nameButton, String iconsRes) {
        Intrinsics.checkNotNullParameter(nameButton, "nameButton");
        Intrinsics.checkNotNullParameter(iconsRes, "iconsRes");
        this.typeMenu = i;
        this.nameButton = nameButton;
        this.iconsRes = iconsRes;
    }

    public final int getTypeMenu() {
        return this.typeMenu;
    }

    public final void setTypeMenu(int i) {
        this.typeMenu = i;
    }

    public final String getNameButton() {
        return this.nameButton;
    }

    public final void setNameButton(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nameButton = str;
    }

    public final String getIconsRes() {
        return this.iconsRes;
    }

    public final void setIconsRes(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconsRes = str;
    }
}
