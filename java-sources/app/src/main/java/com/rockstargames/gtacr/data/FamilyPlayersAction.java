package com.rockstargames.gtacr.data;

import com.rockstargames.gtacr.gui.fractions.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/rockstargames/gtacr/data/FamilyPlayersAction;", "", "actionsId", "", "actionsTitle", "", "actionsValue", Const.FRACTION_TYPE_KEY, "(ILjava/lang/String;II)V", "getActionsId", "()I", "setActionsId", "(I)V", "getActionsTitle", "()Ljava/lang/String;", "setActionsTitle", "(Ljava/lang/String;)V", "getActionsValue", "setActionsValue", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyPlayersAction {
    private int actionsId;
    private String actionsTitle;
    private int actionsValue;
    private final int type;

    public static FamilyPlayersAction copy$default(FamilyPlayersAction familyPlayersAction, int i, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = familyPlayersAction.actionsId;
        }
        if ((i4 & 2) != 0) {
            str = familyPlayersAction.actionsTitle;
        }
        if ((i4 & 4) != 0) {
            i2 = familyPlayersAction.actionsValue;
        }
        if ((i4 & 8) != 0) {
            i3 = familyPlayersAction.type;
        }
        return familyPlayersAction.copy(i, str, i2, i3);
    }

    public final int component1() {
        return this.actionsId;
    }

    public final String component2() {
        return this.actionsTitle;
    }

    public final int component3() {
        return this.actionsValue;
    }

    public final int component4() {
        return this.type;
    }

    public final FamilyPlayersAction copy(int i, String actionsTitle, int i2, int i3) {
        Intrinsics.checkNotNullParameter(actionsTitle, "actionsTitle");
        return new FamilyPlayersAction(i, actionsTitle, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilyPlayersAction) {
            FamilyPlayersAction familyPlayersAction = (FamilyPlayersAction) obj;
            return this.actionsId == familyPlayersAction.actionsId && Intrinsics.areEqual(this.actionsTitle, familyPlayersAction.actionsTitle) && this.actionsValue == familyPlayersAction.actionsValue && this.type == familyPlayersAction.type;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.actionsId * 31) + this.actionsTitle.hashCode()) * 31) + this.actionsValue) * 31) + this.type;
    }

    public String toString() {
        return "FamilyPlayersAction(actionsId=" + this.actionsId + ", actionsTitle=" + this.actionsTitle + ", actionsValue=" + this.actionsValue + ", type=" + this.type + ')';
    }

    public FamilyPlayersAction(int i, String actionsTitle, int i2, int i3) {
        Intrinsics.checkNotNullParameter(actionsTitle, "actionsTitle");
        this.actionsId = i;
        this.actionsTitle = actionsTitle;
        this.actionsValue = i2;
        this.type = i3;
    }

    public final int getActionsId() {
        return this.actionsId;
    }

    public final void setActionsId(int i) {
        this.actionsId = i;
    }

    public final String getActionsTitle() {
        return this.actionsTitle;
    }

    public final void setActionsTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.actionsTitle = str;
    }

    public final int getActionsValue() {
        return this.actionsValue;
    }

    public final void setActionsValue(int i) {
        this.actionsValue = i;
    }

    public final int getType() {
        return this.type;
    }
}
