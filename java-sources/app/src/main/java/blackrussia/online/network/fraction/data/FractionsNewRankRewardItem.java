package blackrussia.online.network.fraction.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lblackrussia/online/network/fraction/data/FractionsNewRankRewardItem;", "", "fractionId", "", "rankReward", "", "newRank", "newRankImage", "(ILjava/util/List;II)V", "getFractionId", "()I", "getNewRank", "getNewRankImage", "getRankReward", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsNewRankRewardItem {
    private final int fractionId;
    private final int newRank;
    private final int newRankImage;
    private final List<Integer> rankReward;

    public static FractionsNewRankRewardItem copy$default(FractionsNewRankRewardItem fractionsNewRankRewardItem, int i, List list, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = fractionsNewRankRewardItem.fractionId;
        }
        if ((i4 & 2) != 0) {
            list = fractionsNewRankRewardItem.rankReward;
        }
        if ((i4 & 4) != 0) {
            i2 = fractionsNewRankRewardItem.newRank;
        }
        if ((i4 & 8) != 0) {
            i3 = fractionsNewRankRewardItem.newRankImage;
        }
        return fractionsNewRankRewardItem.copy(i, list, i2, i3);
    }

    public final int component1() {
        return this.fractionId;
    }

    public final List<Integer> component2() {
        return this.rankReward;
    }

    public final int component3() {
        return this.newRank;
    }

    public final int component4() {
        return this.newRankImage;
    }

    public final FractionsNewRankRewardItem copy(int i, List<Integer> rankReward, int i2, int i3) {
        Intrinsics.checkNotNullParameter(rankReward, "rankReward");
        return new FractionsNewRankRewardItem(i, rankReward, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FractionsNewRankRewardItem) {
            FractionsNewRankRewardItem fractionsNewRankRewardItem = (FractionsNewRankRewardItem) obj;
            return this.fractionId == fractionsNewRankRewardItem.fractionId && Intrinsics.areEqual(this.rankReward, fractionsNewRankRewardItem.rankReward) && this.newRank == fractionsNewRankRewardItem.newRank && this.newRankImage == fractionsNewRankRewardItem.newRankImage;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.fractionId * 31) + this.rankReward.hashCode()) * 31) + this.newRank) * 31) + this.newRankImage;
    }

    public String toString() {
        return "FractionsNewRankRewardItem(fractionId=" + this.fractionId + ", rankReward=" + this.rankReward + ", newRank=" + this.newRank + ", newRankImage=" + this.newRankImage + ')';
    }

    public FractionsNewRankRewardItem(int i, List<Integer> rankReward, int i2, int i3) {
        Intrinsics.checkNotNullParameter(rankReward, "rankReward");
        this.fractionId = i;
        this.rankReward = rankReward;
        this.newRank = i2;
        this.newRankImage = i3;
    }

    public final int getFractionId() {
        return this.fractionId;
    }

    public final List<Integer> getRankReward() {
        return this.rankReward;
    }

    public final int getNewRank() {
        return this.newRank;
    }

    public final int getNewRankImage() {
        return this.newRankImage;
    }
}
