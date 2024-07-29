package blackrussia.online.network;

import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006$"}, d2 = {"Lblackrussia/online/network/FamilySystemTasksObj;", "", GetKeys.GET_PLAYERS_ID, "", "title", "", "description", "moneyReward", "scoreReward", "tokenReward", "isClicked", "", "(ILjava/lang/String;Ljava/lang/String;IIIZ)V", "getDescription", "()Ljava/lang/String;", "getId", "()I", "()Z", "setClicked", "(Z)V", "getMoneyReward", "getScoreReward", "getTitle", "getTokenReward", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilySystemTasksObj {
    @SerializedName("description")
    private final String description;
    @SerializedName(GetKeys.GET_PLAYERS_ID)
    private final int id;
    private boolean isClicked;
    @SerializedName("money_reward")
    private final int moneyReward;
    @SerializedName("score_reward")
    private final int scoreReward;
    @SerializedName("title")
    private final String title;
    @SerializedName("token_reward")
    private final int tokenReward;

    public static FamilySystemTasksObj copy$default(FamilySystemTasksObj familySystemTasksObj, int i, String str, String str2, int i2, int i3, int i4, boolean z, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = familySystemTasksObj.id;
        }
        if ((i5 & 2) != 0) {
            str = familySystemTasksObj.title;
        }
        String str3 = str;
        if ((i5 & 4) != 0) {
            str2 = familySystemTasksObj.description;
        }
        String str4 = str2;
        if ((i5 & 8) != 0) {
            i2 = familySystemTasksObj.moneyReward;
        }
        int i6 = i2;
        if ((i5 & 16) != 0) {
            i3 = familySystemTasksObj.scoreReward;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            i4 = familySystemTasksObj.tokenReward;
        }
        int i8 = i4;
        if ((i5 & 64) != 0) {
            z = familySystemTasksObj.isClicked;
        }
        return familySystemTasksObj.copy(i, str3, str4, i6, i7, i8, z);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.description;
    }

    public final int component4() {
        return this.moneyReward;
    }

    public final int component5() {
        return this.scoreReward;
    }

    public final int component6() {
        return this.tokenReward;
    }

    public final boolean component7() {
        return this.isClicked;
    }

    public final FamilySystemTasksObj copy(int i, String title, String description, int i2, int i3, int i4, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        return new FamilySystemTasksObj(i, title, description, i2, i3, i4, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilySystemTasksObj) {
            FamilySystemTasksObj familySystemTasksObj = (FamilySystemTasksObj) obj;
            return this.id == familySystemTasksObj.id && Intrinsics.areEqual(this.title, familySystemTasksObj.title) && Intrinsics.areEqual(this.description, familySystemTasksObj.description) && this.moneyReward == familySystemTasksObj.moneyReward && this.scoreReward == familySystemTasksObj.scoreReward && this.tokenReward == familySystemTasksObj.tokenReward && this.isClicked == familySystemTasksObj.isClicked;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.id * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.moneyReward) * 31) + this.scoreReward) * 31) + this.tokenReward) * 31;
        boolean z = this.isClicked;
        int i = 0;
        if (z) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "FamilySystemTasksObj(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", moneyReward=" + this.moneyReward + ", scoreReward=" + this.scoreReward + ", tokenReward=" + this.tokenReward + ", isClicked=" + this.isClicked + ')';
    }

    public FamilySystemTasksObj(int i, String title, String description, int i2, int i3, int i4, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = i;
        this.title = title;
        this.description = description;
        this.moneyReward = i2;
        this.scoreReward = i3;
        this.tokenReward = i4;
        this.isClicked = z;
    }

    public FamilySystemTasksObj(int i, String str, String str2, int i2, int i3, int i4, boolean z, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, i2, i3, i4, (i5 & 64) != 0 ? false : z);
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
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

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final void setClicked(boolean z) {
        this.isClicked = z;
    }
}
