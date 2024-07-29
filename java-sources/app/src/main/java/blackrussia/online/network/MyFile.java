package blackrussia.online.network;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lblackrussia/online/network/MyFile;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "path", "size", "", "date", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getName", "setName", "getPath", "setPath", "getSize", "()J", "setSize", "(J)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MyFile {
    @SerializedName("date")
    private String date;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private String name;
    @SerializedName("path")
    private String path;
    @SerializedName("size")
    private long size;

    public static MyFile copy$default(MyFile myFile, String str, String str2, long j, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = myFile.name;
        }
        if ((i & 2) != 0) {
            str2 = myFile.path;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            j = myFile.size;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str3 = myFile.date;
        }
        return myFile.copy(str, str4, j2, str3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.path;
    }

    public final long component3() {
        return this.size;
    }

    public final String component4() {
        return this.date;
    }

    public final MyFile copy(String name, String path, long j, String date) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(date, "date");
        return new MyFile(name, path, j, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MyFile) {
            MyFile myFile = (MyFile) obj;
            return Intrinsics.areEqual(this.name, myFile.name) && Intrinsics.areEqual(this.path, myFile.path) && this.size == myFile.size && Intrinsics.areEqual(this.date, myFile.date);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.path.hashCode()) * 31) + MyFile$$ExternalSynthetic0.m0(this.size)) * 31) + this.date.hashCode();
    }

    public String toString() {
        return "MyFile(name=" + this.name + ", path=" + this.path + ", size=" + this.size + ", date=" + this.date + ')';
    }

    public MyFile(String name, String path, long j, String date) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(date, "date");
        this.name = name;
        this.path = path;
        this.size = j;
        this.date = date;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final long getSize() {
        return this.size;
    }

    public final void setSize(long j) {
        this.size = j;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }
}
