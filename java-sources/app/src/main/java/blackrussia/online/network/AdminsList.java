package blackrussia.online.network;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lblackrussia/online/network/AdminsList;", "", "server", "", "nicks", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(ILjava/util/ArrayList;)V", "getNicks", "()Ljava/util/ArrayList;", "setNicks", "(Ljava/util/ArrayList;)V", "getServer", "()I", "setServer", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AdminsList {
    @SerializedName("nicks")
    private ArrayList<String> nicks;
    @SerializedName("server")
    private int server;

    public static AdminsList copy$default(AdminsList adminsList, int i, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = adminsList.server;
        }
        if ((i2 & 2) != 0) {
            arrayList = adminsList.nicks;
        }
        return adminsList.copy(i, arrayList);
    }

    public final int component1() {
        return this.server;
    }

    public final ArrayList<String> component2() {
        return this.nicks;
    }

    public final AdminsList copy(int i, ArrayList<String> nicks) {
        Intrinsics.checkNotNullParameter(nicks, "nicks");
        return new AdminsList(i, nicks);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdminsList) {
            AdminsList adminsList = (AdminsList) obj;
            return this.server == adminsList.server && Intrinsics.areEqual(this.nicks, adminsList.nicks);
        }
        return false;
    }

    public int hashCode() {
        return (this.server * 31) + this.nicks.hashCode();
    }

    public String toString() {
        return "AdminsList(server=" + this.server + ", nicks=" + this.nicks + ')';
    }

    public AdminsList(int i, ArrayList<String> nicks) {
        Intrinsics.checkNotNullParameter(nicks, "nicks");
        this.server = i;
        this.nicks = nicks;
    }

    public final int getServer() {
        return this.server;
    }

    public final void setServer(int i) {
        this.server = i;
    }

    public final ArrayList<String> getNicks() {
        return this.nicks;
    }

    public final void setNicks(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.nicks = arrayList;
    }
}
