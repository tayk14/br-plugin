package blackrussia.online.network;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u000bJ\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J¥\u0001\u0010 \u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R.\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR.\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR.\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR.\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR.\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006("}, d2 = {"Lblackrussia/online/network/SmiList;", "", "lowClass", "Ljava/util/ArrayList;", "Lblackrussia/online/network/SmiInfo;", "Lkotlin/collections/ArrayList;", "carMiddleClass", "carHighClass", "carMotoClass", "carUniqueClass", "accessoriesList", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getAccessoriesList", "()Ljava/util/ArrayList;", "setAccessoriesList", "(Ljava/util/ArrayList;)V", "getCarHighClass", "setCarHighClass", "getCarMiddleClass", "setCarMiddleClass", "getCarMotoClass", "setCarMotoClass", "getCarUniqueClass", "setCarUniqueClass", "getLowClass", "setLowClass", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SmiList {
    @SerializedName("accessories")
    private ArrayList<SmiInfo> accessoriesList;
    @SerializedName("highClass")
    private ArrayList<SmiInfo> carHighClass;
    @SerializedName("middleClass")
    private ArrayList<SmiInfo> carMiddleClass;
    @SerializedName("motoClass")
    private ArrayList<SmiInfo> carMotoClass;
    @SerializedName("uniqueClass")
    private ArrayList<SmiInfo> carUniqueClass;
    @SerializedName("lowClass")
    private ArrayList<SmiInfo> lowClass;

    public static SmiList copy$default(SmiList smiList, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, ArrayList arrayList6, int i, Object obj) {
        ArrayList<SmiInfo> arrayList7 = arrayList;
        if ((i & 1) != 0) {
            arrayList7 = smiList.lowClass;
        }
        ArrayList<SmiInfo> arrayList8 = arrayList2;
        if ((i & 2) != 0) {
            arrayList8 = smiList.carMiddleClass;
        }
        ArrayList arrayList9 = arrayList8;
        ArrayList<SmiInfo> arrayList10 = arrayList3;
        if ((i & 4) != 0) {
            arrayList10 = smiList.carHighClass;
        }
        ArrayList arrayList11 = arrayList10;
        ArrayList<SmiInfo> arrayList12 = arrayList4;
        if ((i & 8) != 0) {
            arrayList12 = smiList.carMotoClass;
        }
        ArrayList arrayList13 = arrayList12;
        ArrayList<SmiInfo> arrayList14 = arrayList5;
        if ((i & 16) != 0) {
            arrayList14 = smiList.carUniqueClass;
        }
        ArrayList arrayList15 = arrayList14;
        ArrayList<SmiInfo> arrayList16 = arrayList6;
        if ((i & 32) != 0) {
            arrayList16 = smiList.accessoriesList;
        }
        return smiList.copy(arrayList7, arrayList9, arrayList11, arrayList13, arrayList15, arrayList16);
    }

    public final ArrayList<SmiInfo> component1() {
        return this.lowClass;
    }

    public final ArrayList<SmiInfo> component2() {
        return this.carMiddleClass;
    }

    public final ArrayList<SmiInfo> component3() {
        return this.carHighClass;
    }

    public final ArrayList<SmiInfo> component4() {
        return this.carMotoClass;
    }

    public final ArrayList<SmiInfo> component5() {
        return this.carUniqueClass;
    }

    public final ArrayList<SmiInfo> component6() {
        return this.accessoriesList;
    }

    public final SmiList copy(ArrayList<SmiInfo> lowClass, ArrayList<SmiInfo> carMiddleClass, ArrayList<SmiInfo> carHighClass, ArrayList<SmiInfo> carMotoClass, ArrayList<SmiInfo> carUniqueClass, ArrayList<SmiInfo> accessoriesList) {
        Intrinsics.checkNotNullParameter(lowClass, "lowClass");
        Intrinsics.checkNotNullParameter(carMiddleClass, "carMiddleClass");
        Intrinsics.checkNotNullParameter(carHighClass, "carHighClass");
        Intrinsics.checkNotNullParameter(carMotoClass, "carMotoClass");
        Intrinsics.checkNotNullParameter(carUniqueClass, "carUniqueClass");
        Intrinsics.checkNotNullParameter(accessoriesList, "accessoriesList");
        return new SmiList(lowClass, carMiddleClass, carHighClass, carMotoClass, carUniqueClass, accessoriesList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SmiList) {
            SmiList smiList = (SmiList) obj;
            return Intrinsics.areEqual(this.lowClass, smiList.lowClass) && Intrinsics.areEqual(this.carMiddleClass, smiList.carMiddleClass) && Intrinsics.areEqual(this.carHighClass, smiList.carHighClass) && Intrinsics.areEqual(this.carMotoClass, smiList.carMotoClass) && Intrinsics.areEqual(this.carUniqueClass, smiList.carUniqueClass) && Intrinsics.areEqual(this.accessoriesList, smiList.accessoriesList);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.lowClass.hashCode() * 31) + this.carMiddleClass.hashCode()) * 31) + this.carHighClass.hashCode()) * 31) + this.carMotoClass.hashCode()) * 31) + this.carUniqueClass.hashCode()) * 31) + this.accessoriesList.hashCode();
    }

    public String toString() {
        return "SmiList(lowClass=" + this.lowClass + ", carMiddleClass=" + this.carMiddleClass + ", carHighClass=" + this.carHighClass + ", carMotoClass=" + this.carMotoClass + ", carUniqueClass=" + this.carUniqueClass + ", accessoriesList=" + this.accessoriesList + ')';
    }

    public SmiList(ArrayList<SmiInfo> lowClass, ArrayList<SmiInfo> carMiddleClass, ArrayList<SmiInfo> carHighClass, ArrayList<SmiInfo> carMotoClass, ArrayList<SmiInfo> carUniqueClass, ArrayList<SmiInfo> accessoriesList) {
        Intrinsics.checkNotNullParameter(lowClass, "lowClass");
        Intrinsics.checkNotNullParameter(carMiddleClass, "carMiddleClass");
        Intrinsics.checkNotNullParameter(carHighClass, "carHighClass");
        Intrinsics.checkNotNullParameter(carMotoClass, "carMotoClass");
        Intrinsics.checkNotNullParameter(carUniqueClass, "carUniqueClass");
        Intrinsics.checkNotNullParameter(accessoriesList, "accessoriesList");
        this.lowClass = lowClass;
        this.carMiddleClass = carMiddleClass;
        this.carHighClass = carHighClass;
        this.carMotoClass = carMotoClass;
        this.carUniqueClass = carUniqueClass;
        this.accessoriesList = accessoriesList;
    }

    public final ArrayList<SmiInfo> getLowClass() {
        return this.lowClass;
    }

    public final void setLowClass(ArrayList<SmiInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.lowClass = arrayList;
    }

    public final ArrayList<SmiInfo> getCarMiddleClass() {
        return this.carMiddleClass;
    }

    public final void setCarMiddleClass(ArrayList<SmiInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.carMiddleClass = arrayList;
    }

    public final ArrayList<SmiInfo> getCarHighClass() {
        return this.carHighClass;
    }

    public final void setCarHighClass(ArrayList<SmiInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.carHighClass = arrayList;
    }

    public final ArrayList<SmiInfo> getCarMotoClass() {
        return this.carMotoClass;
    }

    public final void setCarMotoClass(ArrayList<SmiInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.carMotoClass = arrayList;
    }

    public final ArrayList<SmiInfo> getCarUniqueClass() {
        return this.carUniqueClass;
    }

    public final void setCarUniqueClass(ArrayList<SmiInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.carUniqueClass = arrayList;
    }

    public final ArrayList<SmiInfo> getAccessoriesList() {
        return this.accessoriesList;
    }

    public final void setAccessoriesList(ArrayList<SmiInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.accessoriesList = arrayList;
    }
}
