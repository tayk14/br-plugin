package blackrussia.online.network;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003Jm\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u00102\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00067"}, d2 = {"Lblackrussia/online/network/Server;", "", "ip", "", "port", "online", "maxonline", TypedValues.Custom.S_COLOR, "x2", "", "key", AppMeasurementSdk.ConditionalUserProperty.NAME, "firstName", "secondName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "getFirstName", "setFirstName", "getIp", "setIp", "getKey", "setKey", "getMaxonline", "setMaxonline", "getName", "setName", "getOnline", "setOnline", "getPort", "setPort", "getSecondName", "setSecondName", "getX2", "()Z", "setX2", "(Z)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Server {
    @SerializedName(TypedValues.Custom.S_COLOR)
    private String color;
    @SerializedName("firstname")
    private String firstName;
    @SerializedName("ip")
    private String ip;
    @SerializedName("key")
    private String key;
    @SerializedName("maxonline")
    private String maxonline;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private String name;
    @SerializedName("online")
    private String online;
    @SerializedName("port")
    private String port;
    @SerializedName("secondname")
    private String secondName;
    @SerializedName("x2")
    private boolean x2;

    public final String component1() {
        return this.ip;
    }

    public final String component10() {
        return this.secondName;
    }

    public final String component2() {
        return this.port;
    }

    public final String component3() {
        return this.online;
    }

    public final String component4() {
        return this.maxonline;
    }

    public final String component5() {
        return this.color;
    }

    public final boolean component6() {
        return this.x2;
    }

    public final String component7() {
        return this.key;
    }

    public final String component8() {
        return this.name;
    }

    public final String component9() {
        return this.firstName;
    }

    public final Server copy(String ip, String port, String online, String maxonline, String color, boolean z, String key, String name, String firstName, String secondName) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(port, "port");
        Intrinsics.checkNotNullParameter(online, "online");
        Intrinsics.checkNotNullParameter(maxonline, "maxonline");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(secondName, "secondName");
        return new Server(ip, port, online, maxonline, color, z, key, name, firstName, secondName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Server) {
            Server server = (Server) obj;
            return Intrinsics.areEqual(this.ip, server.ip) && Intrinsics.areEqual(this.port, server.port) && Intrinsics.areEqual(this.online, server.online) && Intrinsics.areEqual(this.maxonline, server.maxonline) && Intrinsics.areEqual(this.color, server.color) && this.x2 == server.x2 && Intrinsics.areEqual(this.key, server.key) && Intrinsics.areEqual(this.name, server.name) && Intrinsics.areEqual(this.firstName, server.firstName) && Intrinsics.areEqual(this.secondName, server.secondName);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((this.ip.hashCode() * 31) + this.port.hashCode()) * 31) + this.online.hashCode()) * 31) + this.maxonline.hashCode()) * 31) + this.color.hashCode()) * 31;
        boolean z = this.x2;
        int i = 0;
        if (z) {
            i = 1;
        }
        return ((((((((hashCode + i) * 31) + this.key.hashCode()) * 31) + this.name.hashCode()) * 31) + this.firstName.hashCode()) * 31) + this.secondName.hashCode();
    }

    public String toString() {
        return "Server(ip=" + this.ip + ", port=" + this.port + ", online=" + this.online + ", maxonline=" + this.maxonline + ", color=" + this.color + ", x2=" + this.x2 + ", key=" + this.key + ", name=" + this.name + ", firstName=" + this.firstName + ", secondName=" + this.secondName + ')';
    }

    public Server(String ip, String port, String online, String maxonline, String color, boolean z, String key, String name, String firstName, String secondName) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(port, "port");
        Intrinsics.checkNotNullParameter(online, "online");
        Intrinsics.checkNotNullParameter(maxonline, "maxonline");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(secondName, "secondName");
        this.ip = ip;
        this.port = port;
        this.online = online;
        this.maxonline = maxonline;
        this.color = color;
        this.x2 = z;
        this.key = key;
        this.name = name;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public final String getIp() {
        return this.ip;
    }

    public final void setIp(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ip = str;
    }

    public final String getPort() {
        return this.port;
    }

    public final void setPort(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.port = str;
    }

    public final String getOnline() {
        return this.online;
    }

    public final void setOnline(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.online = str;
    }

    public final String getMaxonline() {
        return this.maxonline;
    }

    public final void setMaxonline(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.maxonline = str;
    }

    public final String getColor() {
        return this.color;
    }

    public final void setColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.color = str;
    }

    public final boolean getX2() {
        return this.x2;
    }

    public final void setX2(boolean z) {
        this.x2 = z;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final void setFirstName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstName = str;
    }

    public final String getSecondName() {
        return this.secondName;
    }

    public final void setSecondName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secondName = str;
    }
}
