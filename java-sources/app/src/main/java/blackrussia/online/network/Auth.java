package blackrussia.online.network;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003JO\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u0006+"}, d2 = {"Lblackrussia/online/network/Auth;", "", "auth", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "pass", "server", TypedValues.Custom.S_COLOR, "balance", "message", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuth", "()Z", "setAuth", "(Z)V", "getBalance", "()Ljava/lang/String;", "setBalance", "(Ljava/lang/String;)V", "getColor", "setColor", "getMessage", "setMessage", "getName", "setName", "getPass", "setPass", "getServer", "setServer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Auth {
    @SerializedName("auth")
    private boolean auth;
    @SerializedName("balance")
    private String balance;
    @SerializedName(TypedValues.Custom.S_COLOR)
    private String color;
    @SerializedName("message")
    private String message;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private String name;
    @SerializedName("pass")
    private String pass;
    @SerializedName("server")
    private String server;

    public static Auth copy$default(Auth auth, boolean z, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            z = auth.auth;
        }
        if ((i & 2) != 0) {
            str = auth.name;
        }
        String str7 = str;
        if ((i & 4) != 0) {
            str2 = auth.pass;
        }
        String str8 = str2;
        if ((i & 8) != 0) {
            str3 = auth.server;
        }
        String str9 = str3;
        if ((i & 16) != 0) {
            str4 = auth.color;
        }
        String str10 = str4;
        if ((i & 32) != 0) {
            str5 = auth.balance;
        }
        String str11 = str5;
        if ((i & 64) != 0) {
            str6 = auth.message;
        }
        return auth.copy(z, str7, str8, str9, str10, str11, str6);
    }

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
        return this.server;
    }

    public final String component5() {
        return this.color;
    }

    public final String component6() {
        return this.balance;
    }

    public final String component7() {
        return this.message;
    }

    public final Auth copy(boolean z, String name, String pass, String server, String color, String balance, String message) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(pass, "pass");
        Intrinsics.checkNotNullParameter(server, "server");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(message, "message");
        return new Auth(z, name, pass, server, color, balance, message);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Auth) {
            Auth auth = (Auth) obj;
            return this.auth == auth.auth && Intrinsics.areEqual(this.name, auth.name) && Intrinsics.areEqual(this.pass, auth.pass) && Intrinsics.areEqual(this.server, auth.server) && Intrinsics.areEqual(this.color, auth.color) && Intrinsics.areEqual(this.balance, auth.balance) && Intrinsics.areEqual(this.message, auth.message);
        }
        return false;
    }

    public int hashCode() {
        boolean z = this.auth;
        int r0 = 0;
        if (z) {
            r0 = 1;
        }
        return (((((((((((r0 * 31) + this.name.hashCode()) * 31) + this.pass.hashCode()) * 31) + this.server.hashCode()) * 31) + this.color.hashCode()) * 31) + this.balance.hashCode()) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "Auth(auth=" + this.auth + ", name=" + this.name + ", pass=" + this.pass + ", server=" + this.server + ", color=" + this.color + ", balance=" + this.balance + ", message=" + this.message + ')';
    }

    public Auth(boolean z, String name, String pass, String server, String color, String balance, String message) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(pass, "pass");
        Intrinsics.checkNotNullParameter(server, "server");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(message, "message");
        this.auth = z;
        this.name = name;
        this.pass = pass;
        this.server = server;
        this.color = color;
        this.balance = balance;
        this.message = message;
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

    public final String getServer() {
        return this.server;
    }

    public final void setServer(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.server = str;
    }

    public final String getColor() {
        return this.color;
    }

    public final void setColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.color = str;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final void setBalance(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.balance = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }
}
