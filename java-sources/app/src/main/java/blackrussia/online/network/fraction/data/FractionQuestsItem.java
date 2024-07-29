package blackrussia.online.network.fraction.data;

import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\u0010\rJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J_\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0001J\u0013\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006+"}, d2 = {"Lblackrussia/online/network/fraction/data/FractionQuestsItem;", "", GetKeys.GET_PLAYERS_ID, "", "title", "", "goal", "description", "moneyReward", "scoreReward", "tokenReward", "taskAccess", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/util/List;)V", "getDescription", "()Ljava/lang/String;", "getGoal", "getId", "()I", "isClicked", "", "()Z", "setClicked", "(Z)V", "getMoneyReward", "getScoreReward", "getTaskAccess", "()Ljava/util/List;", "getTitle", "getTokenReward", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionQuestsItem {
    @SerializedName("taskDescription")
    private final String description;
    @SerializedName("taskInfo")
    private final String goal;
    @SerializedName("taskID")
    private final int id;
    private boolean isClicked;
    @SerializedName("taskMoney")
    private final int moneyReward;
    @SerializedName("taskPoint")
    private final int scoreReward;
    @SerializedName("taskAccess")
    private final List<Integer> taskAccess;
    @SerializedName("taskTitle")
    private final String title;
    @SerializedName("taskToken")
    private final int tokenReward;

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.goal;
    }

    public final String component4() {
        return this.description;
    }

    public final int component5() {
        return this.moneyReward;
    }

    public final int component6() {
        return this.scoreReward;
    }

    public final int component7() {
        return this.tokenReward;
    }

    public final List<Integer> component8() {
        return this.taskAccess;
    }

    public final FractionQuestsItem copy(int i, String title, String goal, String description, int i2, int i3, int i4, List<Integer> taskAccess) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(goal, "goal");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(taskAccess, "taskAccess");
        return new FractionQuestsItem(i, title, goal, description, i2, i3, i4, taskAccess);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FractionQuestsItem) {
            FractionQuestsItem fractionQuestsItem = (FractionQuestsItem) obj;
            return this.id == fractionQuestsItem.id && Intrinsics.areEqual(this.title, fractionQuestsItem.title) && Intrinsics.areEqual(this.goal, fractionQuestsItem.goal) && Intrinsics.areEqual(this.description, fractionQuestsItem.description) && this.moneyReward == fractionQuestsItem.moneyReward && this.scoreReward == fractionQuestsItem.scoreReward && this.tokenReward == fractionQuestsItem.tokenReward && Intrinsics.areEqual(this.taskAccess, fractionQuestsItem.taskAccess);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.id * 31) + this.title.hashCode()) * 31) + this.goal.hashCode()) * 31) + this.description.hashCode()) * 31) + this.moneyReward) * 31) + this.scoreReward) * 31) + this.tokenReward) * 31) + this.taskAccess.hashCode();
    }

    public String toString() {
        return "FractionQuestsItem(id=" + this.id + ", title=" + this.title + ", goal=" + this.goal + ", description=" + this.description + ", moneyReward=" + this.moneyReward + ", scoreReward=" + this.scoreReward + ", tokenReward=" + this.tokenReward + ", taskAccess=" + this.taskAccess + ')';
    }

    public FractionQuestsItem(int i, String title, String goal, String description, int i2, int i3, int i4, List<Integer> taskAccess) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(goal, "goal");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(taskAccess, "taskAccess");
        this.id = i;
        this.title = title;
        this.goal = goal;
        this.description = description;
        this.moneyReward = i2;
        this.scoreReward = i3;
        this.tokenReward = i4;
        this.taskAccess = taskAccess;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getGoal() {
        return this.goal;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getMoneyReward() {
        return this.moneyReward;
    }

    public final int getScoreReward() {
        return this.scoreReward;
    }

    public final int getTokenReward() {
        return this.tokenReward;
    }

    public final List<Integer> getTaskAccess() {
        return this.taskAccess;
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final void setClicked(boolean z) {
        this.isClicked = z;
    }
}
