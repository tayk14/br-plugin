package blackrussia.online.network;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lblackrussia/online/network/TuneGuiScreen;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "footer", "Ljava/util/ArrayList;", "Lblackrussia/online/network/TuneGuiNode;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getFooter", "()Ljava/util/ArrayList;", "setFooter", "(Ljava/util/ArrayList;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TuneGuiScreen {
    @SerializedName("footer")
    private ArrayList<TuneGuiNode> footer;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private String name;

    public static TuneGuiScreen copy$default(TuneGuiScreen tuneGuiScreen, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tuneGuiScreen.name;
        }
        if ((i & 2) != 0) {
            arrayList = tuneGuiScreen.footer;
        }
        return tuneGuiScreen.copy(str, arrayList);
    }

    public final String component1() {
        return this.name;
    }

    public final ArrayList<TuneGuiNode> component2() {
        return this.footer;
    }

    public final TuneGuiScreen copy(String name, ArrayList<TuneGuiNode> footer) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(footer, "footer");
        return new TuneGuiScreen(name, footer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TuneGuiScreen) {
            TuneGuiScreen tuneGuiScreen = (TuneGuiScreen) obj;
            return Intrinsics.areEqual(this.name, tuneGuiScreen.name) && Intrinsics.areEqual(this.footer, tuneGuiScreen.footer);
        }
        return false;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.footer.hashCode();
    }

    public String toString() {
        return "TuneGuiScreen(name=" + this.name + ", footer=" + this.footer + ')';
    }

    public TuneGuiScreen(String name, ArrayList<TuneGuiNode> footer) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(footer, "footer");
        this.name = name;
        this.footer = footer;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final ArrayList<TuneGuiNode> getFooter() {
        return this.footer;
    }

    public final void setFooter(ArrayList<TuneGuiNode> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.footer = arrayList;
    }
}
