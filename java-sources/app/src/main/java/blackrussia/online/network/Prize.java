package blackrussia.online.network;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b)\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003Jc\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\fHÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001e\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016¨\u00065"}, d2 = {"Lblackrussia/online/network/Prize;", "", "auth", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "pass", "balance", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "message", "title", "count", "", "objectPrize", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;II)V", "getAuth", "()Z", "setAuth", "(Z)V", "getBalance", "()Ljava/lang/String;", "setBalance", "(Ljava/lang/String;)V", "getCount", "()I", "setCount", "(I)V", "getError", "setError", "getMessage", "setMessage", "getName", "setName", "getObjectPrize", "setObjectPrize", "getPass", "setPass", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Prize {
    @SerializedName("auth")
    private boolean auth;
    @SerializedName("balance")
    private String balance;
    @SerializedName("count")
    private int count;
    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    private boolean error;
    @SerializedName("message")
    private String message;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private String name;
    @SerializedName("object")
    private int objectPrize;
    @SerializedName("pass")
    private String pass;
    @SerializedName("title")
    private String title;

    public final boolean component1() {
        return this.auth;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.pass;
    }

    public final String component4() {
        return this.balance;
    }

    public final boolean component5() {
        return this.error;
    }

    public final String component6() {
        return this.message;
    }

    public final String component7() {
        return this.title;
    }

    public final int component8() {
        return this.count;
    }

    public final int component9() {
        return this.objectPrize;
    }

    public final Prize copy(boolean z, String name, String pass, String balance, boolean z2, String message, String title, int i, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(pass, "pass");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(title, "title");
        return new Prize(z, name, pass, balance, z2, message, title, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Prize) {
            Prize prize = (Prize) obj;
            return this.auth == prize.auth && Intrinsics.areEqual(this.name, prize.name) && Intrinsics.areEqual(this.pass, prize.pass) && Intrinsics.areEqual(this.balance, prize.balance) && this.error == prize.error && Intrinsics.areEqual(this.message, prize.message) && Intrinsics.areEqual(this.title, prize.title) && this.count == prize.count && this.objectPrize == prize.objectPrize;
        }
        return false;
    }

    public int hashCode() {
        boolean z = this.auth;
        int r0 = 0;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((((((r0 * 31) + this.name.hashCode()) * 31) + this.pass.hashCode()) * 31) + this.balance.hashCode()) * 31;
        boolean z2 = this.error;
        return ((((((((hashCode + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.message.hashCode()) * 31) + this.title.hashCode()) * 31) + this.count) * 31) + this.objectPrize;
    }

    public String toString() {
        return "Prize(auth=" + this.auth + ", name=" + this.name + ", pass=" + this.pass + ", balance=" + this.balance + ", error=" + this.error + ", message=" + this.message + ", title=" + this.title + ", count=" + this.count + ", objectPrize=" + this.objectPrize + ')';
    }

    public Prize(boolean z, String name, String pass, String balance, boolean z2, String message, String title, int i, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(pass, "pass");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(title, "title");
        this.auth = z;
        this.name = name;
        this.pass = pass;
        this.balance = balance;
        this.error = z2;
        this.message = message;
        this.title = title;
        this.count = i;
        this.objectPrize = i2;
    }

    public final boolean getAuth() {
        return this.auth;
    }

    public final void setAuth(boolean z) {
        this.auth = z;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getPass() {
        return this.pass;
    }

    public final void setPass(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pass = str;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final void setBalance(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.balance = str;
    }

    public final boolean getError() {
        return this.error;
    }

    public final void setError(boolean z) {
        this.error = z;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final int getObjectPrize() {
        return this.objectPrize;
    }

    public final void setObjectPrize(int i) {
        this.objectPrize = i;
    }
}
