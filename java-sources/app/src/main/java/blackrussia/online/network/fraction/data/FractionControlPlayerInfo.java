package blackrussia.online.network.fraction.data;

import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003JO\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000e¨\u0006*"}, d2 = {"Lblackrussia/online/network/fraction/data/FractionControlPlayerInfo;", "", Const.FRACTION_CONTROL_PLAYER_NICKNAME, "", "skinId", "", "level", "rankName", Const.FRACTION_CONTROL_PLAYER_RANK, Const.FRACTION_CONTROL_PLAYER_REPRIMAND, "phoneNumber", "(Ljava/lang/String;IILjava/lang/String;IILjava/lang/String;)V", GetKeys.GET_PLAYERS_ID, "getId", "()I", "setId", "(I)V", "getLevel", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "getPhoneNumber", "getRank", "setRank", "getRankName", "getReprimand", "setReprimand", "getSkinId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionControlPlayerInfo {
    private int id;
    private final int level;
    private String nickname;
    private final String phoneNumber;
    private int rank;
    private final String rankName;
    private int reprimand;
    private final int skinId;

    public static FractionControlPlayerInfo copy$default(FractionControlPlayerInfo fractionControlPlayerInfo, String str, int i, int i2, String str2, int i3, int i4, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = fractionControlPlayerInfo.nickname;
        }
        if ((i5 & 2) != 0) {
            i = fractionControlPlayerInfo.skinId;
        }
        int i6 = i;
        if ((i5 & 4) != 0) {
            i2 = fractionControlPlayerInfo.level;
        }
        int i7 = i2;
        if ((i5 & 8) != 0) {
            str2 = fractionControlPlayerInfo.rankName;
        }
        String str4 = str2;
        if ((i5 & 16) != 0) {
            i3 = fractionControlPlayerInfo.rank;
        }
        int i8 = i3;
        if ((i5 & 32) != 0) {
            i4 = fractionControlPlayerInfo.reprimand;
        }
        int i9 = i4;
        if ((i5 & 64) != 0) {
            str3 = fractionControlPlayerInfo.phoneNumber;
        }
        return fractionControlPlayerInfo.copy(str, i6, i7, str4, i8, i9, str3);
    }

    public final String component1() {
        return this.nickname;
    }

    public final int component2() {
        return this.skinId;
    }

    public final int component3() {
        return this.level;
    }

    public final String component4() {
        return this.rankName;
    }

    public final int component5() {
        return this.rank;
    }

    public final int component6() {
        return this.reprimand;
    }

    public final String component7() {
        return this.phoneNumber;
    }

    public final FractionControlPlayerInfo copy(String nickname, int i, int i2, String rankName, int i3, int i4, String phoneNumber) {
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(rankName, "rankName");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        return new FractionControlPlayerInfo(nickname, i, i2, rankName, i3, i4, phoneNumber);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FractionControlPlayerInfo) {
            FractionControlPlayerInfo fractionControlPlayerInfo = (FractionControlPlayerInfo) obj;
            return Intrinsics.areEqual(this.nickname, fractionControlPlayerInfo.nickname) && this.skinId == fractionControlPlayerInfo.skinId && this.level == fractionControlPlayerInfo.level && Intrinsics.areEqual(this.rankName, fractionControlPlayerInfo.rankName) && this.rank == fractionControlPlayerInfo.rank && this.reprimand == fractionControlPlayerInfo.reprimand && Intrinsics.areEqual(this.phoneNumber, fractionControlPlayerInfo.phoneNumber);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.nickname.hashCode() * 31) + this.skinId) * 31) + this.level) * 31) + this.rankName.hashCode()) * 31) + this.rank) * 31) + this.reprimand) * 31) + this.phoneNumber.hashCode();
    }

    public String toString() {
        return "FractionControlPlayerInfo(nickname=" + this.nickname + ", skinId=" + this.skinId + ", level=" + this.level + ", rankName=" + this.rankName + ", rank=" + this.rank + ", reprimand=" + this.reprimand + ", phoneNumber=" + this.phoneNumber + ')';
    }

    public FractionControlPlayerInfo(String nickname, int i, int i2, String rankName, int i3, int i4, String phoneNumber) {
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(rankName, "rankName");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.nickname = nickname;
        this.skinId = i;
        this.level = i2;
        this.rankName = rankName;
        this.rank = i3;
        this.reprimand = i4;
        this.phoneNumber = phoneNumber;
        this.id = -1;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final void setNickname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickname = str;
    }

    public final int getSkinId() {
        return this.skinId;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getRankName() {
        return this.rankName;
    }

    public final int getRank() {
        return this.rank;
    }

    public final void setRank(int i) {
        this.rank = i;
    }

    public final int getReprimand() {
        return this.reprimand;
    }

    public final void setReprimand(int i) {
        this.reprimand = i;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }
}
