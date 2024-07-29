package blackrussia.online.network;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00000\tj\b\u0012\u0004\u0012\u00020\u0000`\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00000\tj\b\u0012\u0004\u0012\u00020\u0000`\nHÆ\u0003JO\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00000\tj\b\u0012\u0004\u0012\u00020\u0000`\nHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR.\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00000\tj\b\u0012\u0004\u0012\u00020\u0000`\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006'"}, d2 = {"Lblackrussia/online/network/TuneGuiNode;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "opensType", "", "selectorId", "imageId", "names", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;IILjava/lang/String;Ljava/util/ArrayList;)V", "getImageId", "()Ljava/lang/String;", "setImageId", "(Ljava/lang/String;)V", "getName", "setName", "getNames", "()Ljava/util/ArrayList;", "setNames", "(Ljava/util/ArrayList;)V", "getOpensType", "()I", "setOpensType", "(I)V", "getSelectorId", "setSelectorId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TuneGuiNode {
    @SerializedName("imageId")
    private String imageId;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private String name;
    @SerializedName("names")
    private ArrayList<TuneGuiNode> names;
    @SerializedName("opensType")
    private int opensType;
    @SerializedName("selectorId")
    private int selectorId;

    public static TuneGuiNode copy$default(TuneGuiNode tuneGuiNode, String str, int i, int i2, String str2, ArrayList arrayList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = tuneGuiNode.name;
        }
        if ((i3 & 2) != 0) {
            i = tuneGuiNode.opensType;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = tuneGuiNode.selectorId;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            str2 = tuneGuiNode.imageId;
        }
        String str3 = str2;
        ArrayList<TuneGuiNode> arrayList2 = arrayList;
        if ((i3 & 16) != 0) {
            arrayList2 = tuneGuiNode.names;
        }
        return tuneGuiNode.copy(str, i4, i5, str3, arrayList2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.opensType;
    }

    public final int component3() {
        return this.selectorId;
    }

    public final String component4() {
        return this.imageId;
    }

    public final ArrayList<TuneGuiNode> component5() {
        return this.names;
    }

    public final TuneGuiNode copy(String str, int i, int i2, String str2, ArrayList<TuneGuiNode> names) {
        Intrinsics.checkNotNullParameter(names, "names");
        return new TuneGuiNode(str, i, i2, str2, names);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TuneGuiNode) {
            TuneGuiNode tuneGuiNode = (TuneGuiNode) obj;
            return Intrinsics.areEqual(this.name, tuneGuiNode.name) && this.opensType == tuneGuiNode.opensType && this.selectorId == tuneGuiNode.selectorId && Intrinsics.areEqual(this.imageId, tuneGuiNode.imageId) && Intrinsics.areEqual(this.names, tuneGuiNode.names);
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.opensType) * 31) + this.selectorId) * 31;
        String str2 = this.imageId;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.names.hashCode();
    }

    public String toString() {
        return "TuneGuiNode(name=" + ((Object) this.name) + ", opensType=" + this.opensType + ", selectorId=" + this.selectorId + ", imageId=" + ((Object) this.imageId) + ", names=" + this.names + ')';
    }

    public TuneGuiNode(String str, int i, int i2, String str2, ArrayList<TuneGuiNode> names) {
        Intrinsics.checkNotNullParameter(names, "names");
        this.name = str;
        this.opensType = i;
        this.selectorId = i2;
        this.imageId = str2;
        this.names = names;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final int getOpensType() {
        return this.opensType;
    }

    public final void setOpensType(int i) {
        this.opensType = i;
    }

    public final int getSelectorId() {
        return this.selectorId;
    }

    public final void setSelectorId(int i) {
        this.selectorId = i;
    }

    public final String getImageId() {
        return this.imageId;
    }

    public final void setImageId(String str) {
        this.imageId = str;
    }

    public final ArrayList<TuneGuiNode> getNames() {
        return this.names;
    }

    public final void setNames(ArrayList<TuneGuiNode> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.names = arrayList;
    }
}
