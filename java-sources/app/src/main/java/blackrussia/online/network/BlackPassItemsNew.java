package blackrussia.online.network;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0003j\b\u0012\u0004\u0012\u00020\u000b`\u0005¢\u0006\u0002\u0010\fJ\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0003j\b\u0012\u0004\u0012\u00020\u000b`\u0005HÆ\u0003J{\u0010 \u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0003j\b\u0012\u0004\u0012\u00020\u000b`\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R.\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R.\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0003j\b\u0012\u0004\u0012\u00020\u000b`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006'"}, d2 = {"Lblackrussia/online/network/BlackPassItemsNew;", "", "StandartLevel", "Ljava/util/ArrayList;", "Lblackrussia/online/network/LevelsInfoNew;", "Lkotlin/collections/ArrayList;", "PremiumLevel", "MarathonLevel", "LevelPrices", "", "Tasks", "Lblackrussia/online/network/TasksInfoNew;", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;ILjava/util/ArrayList;)V", "getLevelPrices", "()I", "setLevelPrices", "(I)V", "getMarathonLevel", "()Ljava/util/ArrayList;", "setMarathonLevel", "(Ljava/util/ArrayList;)V", "getPremiumLevel", "setPremiumLevel", "getStandartLevel", "setStandartLevel", "getTasks", "setTasks", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlackPassItemsNew {
    @SerializedName("LevelPrices")
    private int LevelPrices;
    @SerializedName("MarathonLevel")
    private ArrayList<LevelsInfoNew> MarathonLevel;
    @SerializedName("PremiumLevel")
    private ArrayList<LevelsInfoNew> PremiumLevel;
    @SerializedName("StandartLevel")
    private ArrayList<LevelsInfoNew> StandartLevel;
    @SerializedName("Tasks")
    private ArrayList<TasksInfoNew> Tasks;

    public static BlackPassItemsNew copy$default(BlackPassItemsNew blackPassItemsNew, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i, ArrayList arrayList4, int i2, Object obj) {
        ArrayList<LevelsInfoNew> arrayList5 = arrayList;
        if ((i2 & 1) != 0) {
            arrayList5 = blackPassItemsNew.StandartLevel;
        }
        ArrayList<LevelsInfoNew> arrayList6 = arrayList2;
        if ((i2 & 2) != 0) {
            arrayList6 = blackPassItemsNew.PremiumLevel;
        }
        ArrayList arrayList7 = arrayList6;
        ArrayList<LevelsInfoNew> arrayList8 = arrayList3;
        if ((i2 & 4) != 0) {
            arrayList8 = blackPassItemsNew.MarathonLevel;
        }
        ArrayList arrayList9 = arrayList8;
        if ((i2 & 8) != 0) {
            i = blackPassItemsNew.LevelPrices;
        }
        int i3 = i;
        ArrayList<TasksInfoNew> arrayList10 = arrayList4;
        if ((i2 & 16) != 0) {
            arrayList10 = blackPassItemsNew.Tasks;
        }
        return blackPassItemsNew.copy(arrayList5, arrayList7, arrayList9, i3, arrayList10);
    }

    public final ArrayList<LevelsInfoNew> component1() {
        return this.StandartLevel;
    }

    public final ArrayList<LevelsInfoNew> component2() {
        return this.PremiumLevel;
    }

    public final ArrayList<LevelsInfoNew> component3() {
        return this.MarathonLevel;
    }

    public final int component4() {
        return this.LevelPrices;
    }

    public final ArrayList<TasksInfoNew> component5() {
        return this.Tasks;
    }

    public final BlackPassItemsNew copy(ArrayList<LevelsInfoNew> StandartLevel, ArrayList<LevelsInfoNew> PremiumLevel, ArrayList<LevelsInfoNew> MarathonLevel, int i, ArrayList<TasksInfoNew> Tasks) {
        Intrinsics.checkNotNullParameter(StandartLevel, "StandartLevel");
        Intrinsics.checkNotNullParameter(PremiumLevel, "PremiumLevel");
        Intrinsics.checkNotNullParameter(MarathonLevel, "MarathonLevel");
        Intrinsics.checkNotNullParameter(Tasks, "Tasks");
        return new BlackPassItemsNew(StandartLevel, PremiumLevel, MarathonLevel, i, Tasks);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlackPassItemsNew) {
            BlackPassItemsNew blackPassItemsNew = (BlackPassItemsNew) obj;
            return Intrinsics.areEqual(this.StandartLevel, blackPassItemsNew.StandartLevel) && Intrinsics.areEqual(this.PremiumLevel, blackPassItemsNew.PremiumLevel) && Intrinsics.areEqual(this.MarathonLevel, blackPassItemsNew.MarathonLevel) && this.LevelPrices == blackPassItemsNew.LevelPrices && Intrinsics.areEqual(this.Tasks, blackPassItemsNew.Tasks);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.StandartLevel.hashCode() * 31) + this.PremiumLevel.hashCode()) * 31) + this.MarathonLevel.hashCode()) * 31) + this.LevelPrices) * 31) + this.Tasks.hashCode();
    }

    public String toString() {
        return "BlackPassItemsNew(StandartLevel=" + this.StandartLevel + ", PremiumLevel=" + this.PremiumLevel + ", MarathonLevel=" + this.MarathonLevel + ", LevelPrices=" + this.LevelPrices + ", Tasks=" + this.Tasks + ')';
    }

    public BlackPassItemsNew(ArrayList<LevelsInfoNew> StandartLevel, ArrayList<LevelsInfoNew> PremiumLevel, ArrayList<LevelsInfoNew> MarathonLevel, int i, ArrayList<TasksInfoNew> Tasks) {
        Intrinsics.checkNotNullParameter(StandartLevel, "StandartLevel");
        Intrinsics.checkNotNullParameter(PremiumLevel, "PremiumLevel");
        Intrinsics.checkNotNullParameter(MarathonLevel, "MarathonLevel");
        Intrinsics.checkNotNullParameter(Tasks, "Tasks");
        this.StandartLevel = StandartLevel;
        this.PremiumLevel = PremiumLevel;
        this.MarathonLevel = MarathonLevel;
        this.LevelPrices = i;
        this.Tasks = Tasks;
    }

    public final ArrayList<LevelsInfoNew> getStandartLevel() {
        return this.StandartLevel;
    }

    public final void setStandartLevel(ArrayList<LevelsInfoNew> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.StandartLevel = arrayList;
    }

    public final ArrayList<LevelsInfoNew> getPremiumLevel() {
        return this.PremiumLevel;
    }

    public final void setPremiumLevel(ArrayList<LevelsInfoNew> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.PremiumLevel = arrayList;
    }

    public final ArrayList<LevelsInfoNew> getMarathonLevel() {
        return this.MarathonLevel;
    }

    public final void setMarathonLevel(ArrayList<LevelsInfoNew> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.MarathonLevel = arrayList;
    }

    public final int getLevelPrices() {
        return this.LevelPrices;
    }

    public final void setLevelPrices(int i) {
        this.LevelPrices = i;
    }

    public final ArrayList<TasksInfoNew> getTasks() {
        return this.Tasks;
    }

    public final void setTasks(ArrayList<TasksInfoNew> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.Tasks = arrayList;
    }
}
