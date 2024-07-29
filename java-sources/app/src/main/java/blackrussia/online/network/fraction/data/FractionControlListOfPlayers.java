package blackrussia.online.network.fraction.data;

import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\u0014¨\u0006 "}, d2 = {"Lblackrussia/online/network/fraction/data/FractionControlListOfPlayers;", "", GetKeys.GET_PLAYERS_ID, "", Const.FRACTION_CONTROL_PLAYER_NICKNAME, "", Const.FRACTION_CONTROL_PLAYER_RANK, "online", "(ILjava/lang/String;II)V", "getId", "()I", "isClicked", "", "()Z", "setClicked", "(Z)V", "getNickname", "()Ljava/lang/String;", "getOnline", "setOnline", "(I)V", "getRank", "setRank", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionControlListOfPlayers {
    private final int id;
    private boolean isClicked;
    private final String nickname;
    private int online;
    private int rank;

    public static FractionControlListOfPlayers copy$default(FractionControlListOfPlayers fractionControlListOfPlayers, int i, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = fractionControlListOfPlayers.id;
        }
        if ((i4 & 2) != 0) {
            str = fractionControlListOfPlayers.nickname;
        }
        if ((i4 & 4) != 0) {
            i2 = fractionControlListOfPlayers.rank;
        }
        if ((i4 & 8) != 0) {
            i3 = fractionControlListOfPlayers.online;
        }
        return fractionControlListOfPlayers.copy(i, str, i2, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.nickname;
    }

    public final int component3() {
        return this.rank;
    }

    public final int component4() {
        return this.online;
    }

    public final FractionControlListOfPlayers copy(int i, String nickname, int i2, int i3) {
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        return new FractionControlListOfPlayers(i, nickname, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FractionControlListOfPlayers) {
            FractionControlListOfPlayers fractionControlListOfPlayers = (FractionControlListOfPlayers) obj;
            return this.id == fractionControlListOfPlayers.id && Intrinsics.areEqual(this.nickname, fractionControlListOfPlayers.nickname) && this.rank == fractionControlListOfPlayers.rank && this.online == fractionControlListOfPlayers.online;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.id * 31) + this.nickname.hashCode()) * 31) + this.rank) * 31) + this.online;
    }

    public String toString() {
        return "FractionControlListOfPlayers(id=" + this.id + ", nickname=" + this.nickname + ", rank=" + this.rank + ", online=" + this.online + ')';
    }

    public FractionControlListOfPlayers(int i, String nickname, int i2, int i3) {
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        this.id = i;
        this.nickname = nickname;
        this.rank = i2;
        this.online = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final int getRank() {
        return this.rank;
    }

    public final void setRank(int i) {
        this.rank = i;
    }

    public final int getOnline() {
        return this.online;
    }

    public final void setOnline(int i) {
        this.online = i;
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final void setClicked(boolean z) {
        this.isClicked = z;
    }
}
