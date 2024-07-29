package com.rockstargames.gtacr.data;

import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/rockstargames/gtacr/data/SocialInteractionButton;", "", GetKeys.GET_PLAYERS_ID, "", "buttonsText", "", "socialType", Const.PAGE_KEY, "(ILjava/lang/String;II)V", "getButtonsText", "()Ljava/lang/String;", "getId", "()I", "getPage", "setPage", "(I)V", "getSocialType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SocialInteractionButton {
    private final String buttonsText;
    private final int id;
    private int page;
    private final int socialType;

    public static SocialInteractionButton copy$default(SocialInteractionButton socialInteractionButton, int i, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = socialInteractionButton.id;
        }
        if ((i4 & 2) != 0) {
            str = socialInteractionButton.buttonsText;
        }
        if ((i4 & 4) != 0) {
            i2 = socialInteractionButton.socialType;
        }
        if ((i4 & 8) != 0) {
            i3 = socialInteractionButton.page;
        }
        return socialInteractionButton.copy(i, str, i2, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.buttonsText;
    }

    public final int component3() {
        return this.socialType;
    }

    public final int component4() {
        return this.page;
    }

    public final SocialInteractionButton copy(int i, String buttonsText, int i2, int i3) {
        Intrinsics.checkNotNullParameter(buttonsText, "buttonsText");
        return new SocialInteractionButton(i, buttonsText, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SocialInteractionButton) {
            SocialInteractionButton socialInteractionButton = (SocialInteractionButton) obj;
            return this.id == socialInteractionButton.id && Intrinsics.areEqual(this.buttonsText, socialInteractionButton.buttonsText) && this.socialType == socialInteractionButton.socialType && this.page == socialInteractionButton.page;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.id * 31) + this.buttonsText.hashCode()) * 31) + this.socialType) * 31) + this.page;
    }

    public String toString() {
        return "SocialInteractionButton(id=" + this.id + ", buttonsText=" + this.buttonsText + ", socialType=" + this.socialType + ", page=" + this.page + ')';
    }

    public SocialInteractionButton(int i, String buttonsText, int i2, int i3) {
        Intrinsics.checkNotNullParameter(buttonsText, "buttonsText");
        this.id = i;
        this.buttonsText = buttonsText;
        this.socialType = i2;
        this.page = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final String getButtonsText() {
        return this.buttonsText;
    }

    public final int getSocialType() {
        return this.socialType;
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }
}
