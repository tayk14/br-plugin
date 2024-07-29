package blackrussia.online.network.fraction.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003JK\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0013\"\u0004\b\u0016\u0010\u0015R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006%"}, d2 = {"Lblackrussia/online/network/fraction/data/FractionsDocumentsItem;", "", "documentId", "", "title", "", "description", "testingItemList", "", "Lblackrussia/online/network/fraction/data/FractionsTestingItem;", "documentStatus", "", "isClicked", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;ZZ)V", "getDescription", "()Ljava/lang/String;", "getDocumentId", "()I", "getDocumentStatus", "()Z", "setDocumentStatus", "(Z)V", "setClicked", "getTestingItemList", "()Ljava/util/List;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsDocumentsItem {
    @SerializedName("documentsContent")
    private final String description;
    @SerializedName("documentID")
    private final int documentId;
    private boolean documentStatus;
    private boolean isClicked;
    @SerializedName("documentTesting")
    private final List<FractionsTestingItem> testingItemList;
    @SerializedName("documentTitle")
    private final String title;

    public static FractionsDocumentsItem copy$default(FractionsDocumentsItem fractionsDocumentsItem, int i, String str, String str2, List list, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = fractionsDocumentsItem.documentId;
        }
        if ((i2 & 2) != 0) {
            str = fractionsDocumentsItem.title;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = fractionsDocumentsItem.description;
        }
        String str4 = str2;
        List<FractionsTestingItem> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = fractionsDocumentsItem.testingItemList;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            z = fractionsDocumentsItem.documentStatus;
        }
        boolean z3 = z;
        if ((i2 & 32) != 0) {
            z2 = fractionsDocumentsItem.isClicked;
        }
        return fractionsDocumentsItem.copy(i, str3, str4, list3, z3, z2);
    }

    public final int component1() {
        return this.documentId;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.description;
    }

    public final List<FractionsTestingItem> component4() {
        return this.testingItemList;
    }

    public final boolean component5() {
        return this.documentStatus;
    }

    public final boolean component6() {
        return this.isClicked;
    }

    public final FractionsDocumentsItem copy(int i, String title, String description, List<FractionsTestingItem> testingItemList, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(testingItemList, "testingItemList");
        return new FractionsDocumentsItem(i, title, description, testingItemList, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FractionsDocumentsItem) {
            FractionsDocumentsItem fractionsDocumentsItem = (FractionsDocumentsItem) obj;
            return this.documentId == fractionsDocumentsItem.documentId && Intrinsics.areEqual(this.title, fractionsDocumentsItem.title) && Intrinsics.areEqual(this.description, fractionsDocumentsItem.description) && Intrinsics.areEqual(this.testingItemList, fractionsDocumentsItem.testingItemList) && this.documentStatus == fractionsDocumentsItem.documentStatus && this.isClicked == fractionsDocumentsItem.isClicked;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.documentId * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.testingItemList.hashCode()) * 31;
        boolean z = this.documentStatus;
        int i = 0;
        if (z) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.isClicked;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "FractionsDocumentsItem(documentId=" + this.documentId + ", title=" + this.title + ", description=" + this.description + ", testingItemList=" + this.testingItemList + ", documentStatus=" + this.documentStatus + ", isClicked=" + this.isClicked + ')';
    }

    public FractionsDocumentsItem(int i, String title, String description, List<FractionsTestingItem> testingItemList, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(testingItemList, "testingItemList");
        this.documentId = i;
        this.title = title;
        this.description = description;
        this.testingItemList = testingItemList;
        this.documentStatus = z;
        this.isClicked = z2;
    }

    public final int getDocumentId() {
        return this.documentId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<FractionsTestingItem> getTestingItemList() {
        return this.testingItemList;
    }

    public final boolean getDocumentStatus() {
        return this.documentStatus;
    }

    public final void setDocumentStatus(boolean z) {
        this.documentStatus = z;
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final void setClicked(boolean z) {
        this.isClicked = z;
    }
}
