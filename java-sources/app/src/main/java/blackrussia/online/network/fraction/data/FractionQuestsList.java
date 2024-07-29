package blackrussia.online.network.fraction.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lblackrussia/online/network/fraction/data/FractionQuestsList;", "", "fractionID", "", "taskList", "", "Lblackrussia/online/network/fraction/data/FractionQuestsItem;", "(ILjava/util/List;)V", "getFractionID", "()I", "getTaskList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionQuestsList {
    @SerializedName("fractionID")
    private final int fractionID;
    @SerializedName("taskList")
    private final List<FractionQuestsItem> taskList;

    public static FractionQuestsList copy$default(FractionQuestsList fractionQuestsList, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = fractionQuestsList.fractionID;
        }
        if ((i2 & 2) != 0) {
            list = fractionQuestsList.taskList;
        }
        return fractionQuestsList.copy(i, list);
    }

    public final int component1() {
        return this.fractionID;
    }

    public final List<FractionQuestsItem> component2() {
        return this.taskList;
    }

    public final FractionQuestsList copy(int i, List<FractionQuestsItem> taskList) {
        Intrinsics.checkNotNullParameter(taskList, "taskList");
        return new FractionQuestsList(i, taskList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FractionQuestsList) {
            FractionQuestsList fractionQuestsList = (FractionQuestsList) obj;
            return this.fractionID == fractionQuestsList.fractionID && Intrinsics.areEqual(this.taskList, fractionQuestsList.taskList);
        }
        return false;
    }

    public int hashCode() {
        return (this.fractionID * 31) + this.taskList.hashCode();
    }

    public String toString() {
        return "FractionQuestsList(fractionID=" + this.fractionID + ", taskList=" + this.taskList + ')';
    }

    public FractionQuestsList(int i, List<FractionQuestsItem> taskList) {
        Intrinsics.checkNotNullParameter(taskList, "taskList");
        this.fractionID = i;
        this.taskList = taskList;
    }

    public final int getFractionID() {
        return this.fractionID;
    }

    public final List<FractionQuestsItem> getTaskList() {
        return this.taskList;
    }
}
