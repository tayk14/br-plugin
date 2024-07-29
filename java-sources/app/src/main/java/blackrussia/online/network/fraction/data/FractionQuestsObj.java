package blackrussia.online.network.fraction.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lblackrussia/online/network/fraction/data/FractionQuestsObj;", "", "fractionQuests", "", "Lblackrussia/online/network/fraction/data/FractionQuestsList;", "(Ljava/util/List;)V", "getFractionQuests", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionQuestsObj {
    @SerializedName("fractionTask")
    private final List<FractionQuestsList> fractionQuests;

    public static FractionQuestsObj copy$default(FractionQuestsObj fractionQuestsObj, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = fractionQuestsObj.fractionQuests;
        }
        return fractionQuestsObj.copy(list);
    }

    public final List<FractionQuestsList> component1() {
        return this.fractionQuests;
    }

    public final FractionQuestsObj copy(List<FractionQuestsList> fractionQuests) {
        Intrinsics.checkNotNullParameter(fractionQuests, "fractionQuests");
        return new FractionQuestsObj(fractionQuests);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FractionQuestsObj) && Intrinsics.areEqual(this.fractionQuests, ((FractionQuestsObj) obj).fractionQuests);
    }

    public int hashCode() {
        return this.fractionQuests.hashCode();
    }

    public String toString() {
        return "FractionQuestsObj(fractionQuests=" + this.fractionQuests + ')';
    }

    public FractionQuestsObj(List<FractionQuestsList> fractionQuests) {
        Intrinsics.checkNotNullParameter(fractionQuests, "fractionQuests");
        this.fractionQuests = fractionQuests;
    }

    public final List<FractionQuestsList> getFractionQuests() {
        return this.fractionQuests;
    }
}
