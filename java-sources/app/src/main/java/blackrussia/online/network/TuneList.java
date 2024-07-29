package blackrussia.online.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lblackrussia/online/network/TuneList;", "", "array", "", "Lblackrussia/online/network/Tune;", "(Ljava/util/List;)V", "getArray", "()Ljava/util/List;", "setArray", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TuneList {
    @SerializedName("array")
    private List<Tune> array;

    public static TuneList copy$default(TuneList tuneList, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = tuneList.array;
        }
        return tuneList.copy(list);
    }

    public final List<Tune> component1() {
        return this.array;
    }

    public final TuneList copy(List<Tune> array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new TuneList(array);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TuneList) && Intrinsics.areEqual(this.array, ((TuneList) obj).array);
    }

    public int hashCode() {
        return this.array.hashCode();
    }

    public String toString() {
        return "TuneList(array=" + this.array + ')';
    }

    public TuneList(List<Tune> array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.array = array;
    }

    public final List<Tune> getArray() {
        return this.array;
    }

    public final void setArray(List<Tune> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.array = list;
    }
}
