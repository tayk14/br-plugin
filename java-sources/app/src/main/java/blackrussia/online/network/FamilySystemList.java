package blackrussia.online.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0002\u0010\rJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003JY\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006!"}, d2 = {"Lblackrussia/online/network/FamilySystemList;", "", "upgradeList", "", "Lblackrussia/online/network/FamilySystemUpgradeObj;", "rewardTopList", "Lblackrussia/online/network/FamilySystemRewardTopObj;", "shopList", "Lblackrussia/online/network/FamilySystemShopObj;", "tasksList", "Lblackrussia/online/network/FamilySystemTasksObj;", "colorsList", "Lblackrussia/online/network/FamilySystemColorsObj;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getColorsList", "()Ljava/util/List;", "getRewardTopList", "getShopList", "getTasksList", "getUpgradeList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilySystemList {
    @SerializedName("Colors")
    private final List<FamilySystemColorsObj> colorsList;
    @SerializedName("RewardTop")
    private final List<FamilySystemRewardTopObj> rewardTopList;
    @SerializedName("Shop")
    private final List<FamilySystemShopObj> shopList;
    @SerializedName("Tasks")
    private final List<FamilySystemTasksObj> tasksList;
    @SerializedName("Upgrade")
    private final List<FamilySystemUpgradeObj> upgradeList;

    public static FamilySystemList copy$default(FamilySystemList familySystemList, List list, List list2, List list3, List list4, List list5, int i, Object obj) {
        List<FamilySystemUpgradeObj> list6 = list;
        if ((i & 1) != 0) {
            list6 = familySystemList.upgradeList;
        }
        List<FamilySystemRewardTopObj> list7 = list2;
        if ((i & 2) != 0) {
            list7 = familySystemList.rewardTopList;
        }
        List list8 = list7;
        List<FamilySystemShopObj> list9 = list3;
        if ((i & 4) != 0) {
            list9 = familySystemList.shopList;
        }
        List list10 = list9;
        List<FamilySystemTasksObj> list11 = list4;
        if ((i & 8) != 0) {
            list11 = familySystemList.tasksList;
        }
        List list12 = list11;
        List<FamilySystemColorsObj> list13 = list5;
        if ((i & 16) != 0) {
            list13 = familySystemList.colorsList;
        }
        return familySystemList.copy(list6, list8, list10, list12, list13);
    }

    public final List<FamilySystemUpgradeObj> component1() {
        return this.upgradeList;
    }

    public final List<FamilySystemRewardTopObj> component2() {
        return this.rewardTopList;
    }

    public final List<FamilySystemShopObj> component3() {
        return this.shopList;
    }

    public final List<FamilySystemTasksObj> component4() {
        return this.tasksList;
    }

    public final List<FamilySystemColorsObj> component5() {
        return this.colorsList;
    }

    public final FamilySystemList copy(List<FamilySystemUpgradeObj> upgradeList, List<FamilySystemRewardTopObj> rewardTopList, List<FamilySystemShopObj> shopList, List<FamilySystemTasksObj> tasksList, List<FamilySystemColorsObj> colorsList) {
        Intrinsics.checkNotNullParameter(upgradeList, "upgradeList");
        Intrinsics.checkNotNullParameter(rewardTopList, "rewardTopList");
        Intrinsics.checkNotNullParameter(shopList, "shopList");
        Intrinsics.checkNotNullParameter(tasksList, "tasksList");
        Intrinsics.checkNotNullParameter(colorsList, "colorsList");
        return new FamilySystemList(upgradeList, rewardTopList, shopList, tasksList, colorsList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilySystemList) {
            FamilySystemList familySystemList = (FamilySystemList) obj;
            return Intrinsics.areEqual(this.upgradeList, familySystemList.upgradeList) && Intrinsics.areEqual(this.rewardTopList, familySystemList.rewardTopList) && Intrinsics.areEqual(this.shopList, familySystemList.shopList) && Intrinsics.areEqual(this.tasksList, familySystemList.tasksList) && Intrinsics.areEqual(this.colorsList, familySystemList.colorsList);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.upgradeList.hashCode() * 31) + this.rewardTopList.hashCode()) * 31) + this.shopList.hashCode()) * 31) + this.tasksList.hashCode()) * 31) + this.colorsList.hashCode();
    }

    public String toString() {
        return "FamilySystemList(upgradeList=" + this.upgradeList + ", rewardTopList=" + this.rewardTopList + ", shopList=" + this.shopList + ", tasksList=" + this.tasksList + ", colorsList=" + this.colorsList + ')';
    }

    public FamilySystemList(List<FamilySystemUpgradeObj> upgradeList, List<FamilySystemRewardTopObj> rewardTopList, List<FamilySystemShopObj> shopList, List<FamilySystemTasksObj> tasksList, List<FamilySystemColorsObj> colorsList) {
        Intrinsics.checkNotNullParameter(upgradeList, "upgradeList");
        Intrinsics.checkNotNullParameter(rewardTopList, "rewardTopList");
        Intrinsics.checkNotNullParameter(shopList, "shopList");
        Intrinsics.checkNotNullParameter(tasksList, "tasksList");
        Intrinsics.checkNotNullParameter(colorsList, "colorsList");
        this.upgradeList = upgradeList;
        this.rewardTopList = rewardTopList;
        this.shopList = shopList;
        this.tasksList = tasksList;
        this.colorsList = colorsList;
    }

    public final List<FamilySystemUpgradeObj> getUpgradeList() {
        return this.upgradeList;
    }

    public final List<FamilySystemRewardTopObj> getRewardTopList() {
        return this.rewardTopList;
    }

    public final List<FamilySystemShopObj> getShopList() {
        return this.shopList;
    }

    public final List<FamilySystemTasksObj> getTasksList() {
        return this.tasksList;
    }

    public final List<FamilySystemColorsObj> getColorsList() {
        return this.colorsList;
    }
}
