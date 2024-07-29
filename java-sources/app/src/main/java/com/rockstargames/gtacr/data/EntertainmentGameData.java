package com.rockstargames.gtacr.data;

import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0018¨\u0006'"}, d2 = {"Lcom/rockstargames/gtacr/data/EntertainmentGameData;", "", GetKeys.GET_PLAYERS_ID, "", "gamesName", "", "idIcon", "players", "status", "description", "isClicked", "", "(ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Z)V", "getDescription", "()Ljava/lang/String;", "getGamesName", "getId", "()I", "getIdIcon", "()Z", "setClicked", "(Z)V", "getPlayers", "setPlayers", "(I)V", "getStatus", "setStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EntertainmentGameData {
    private final String description;
    private final String gamesName;
    private final int id;
    private final String idIcon;
    private boolean isClicked;
    private int players;
    private int status;

    public static EntertainmentGameData copy$default(EntertainmentGameData entertainmentGameData, int i, String str, String str2, int i2, int i3, String str3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = entertainmentGameData.id;
        }
        if ((i4 & 2) != 0) {
            str = entertainmentGameData.gamesName;
        }
        String str4 = str;
        if ((i4 & 4) != 0) {
            str2 = entertainmentGameData.idIcon;
        }
        String str5 = str2;
        if ((i4 & 8) != 0) {
            i2 = entertainmentGameData.players;
        }
        int i5 = i2;
        if ((i4 & 16) != 0) {
            i3 = entertainmentGameData.status;
        }
        int i6 = i3;
        if ((i4 & 32) != 0) {
            str3 = entertainmentGameData.description;
        }
        String str6 = str3;
        if ((i4 & 64) != 0) {
            z = entertainmentGameData.isClicked;
        }
        return entertainmentGameData.copy(i, str4, str5, i5, i6, str6, z);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.gamesName;
    }

    public final String component3() {
        return this.idIcon;
    }

    public final int component4() {
        return this.players;
    }

    public final int component5() {
        return this.status;
    }

    public final String component6() {
        return this.description;
    }

    public final boolean component7() {
        return this.isClicked;
    }

    public final EntertainmentGameData copy(int i, String gamesName, String idIcon, int i2, int i3, String description, boolean z) {
        Intrinsics.checkNotNullParameter(gamesName, "gamesName");
        Intrinsics.checkNotNullParameter(idIcon, "idIcon");
        Intrinsics.checkNotNullParameter(description, "description");
        return new EntertainmentGameData(i, gamesName, idIcon, i2, i3, description, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EntertainmentGameData) {
            EntertainmentGameData entertainmentGameData = (EntertainmentGameData) obj;
            return this.id == entertainmentGameData.id && Intrinsics.areEqual(this.gamesName, entertainmentGameData.gamesName) && Intrinsics.areEqual(this.idIcon, entertainmentGameData.idIcon) && this.players == entertainmentGameData.players && this.status == entertainmentGameData.status && Intrinsics.areEqual(this.description, entertainmentGameData.description) && this.isClicked == entertainmentGameData.isClicked;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.id * 31) + this.gamesName.hashCode()) * 31) + this.idIcon.hashCode()) * 31) + this.players) * 31) + this.status) * 31) + this.description.hashCode()) * 31;
        boolean z = this.isClicked;
        int i = 0;
        if (z) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "EntertainmentGameData(id=" + this.id + ", gamesName=" + this.gamesName + ", idIcon=" + this.idIcon + ", players=" + this.players + ", status=" + this.status + ", description=" + this.description + ", isClicked=" + this.isClicked + ')';
    }

    public EntertainmentGameData(int i, String gamesName, String idIcon, int i2, int i3, String description, boolean z) {
        Intrinsics.checkNotNullParameter(gamesName, "gamesName");
        Intrinsics.checkNotNullParameter(idIcon, "idIcon");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = i;
        this.gamesName = gamesName;
        this.idIcon = idIcon;
        this.players = i2;
        this.status = i3;
        this.description = description;
        this.isClicked = z;
    }

    public EntertainmentGameData(int i, String str, String str2, int i2, int i3, String str3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, i2, i3, str3, (i4 & 64) != 0 ? false : z);
    }

    public final int getId() {
        return this.id;
    }

    public final String getGamesName() {
        return this.gamesName;
    }

    public final String getIdIcon() {
        return this.idIcon;
    }

    public final int getPlayers() {
        return this.players;
    }

    public final void setPlayers(int i) {
        this.players = i;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final void setClicked(boolean z) {
        this.isClicked = z;
    }
}
