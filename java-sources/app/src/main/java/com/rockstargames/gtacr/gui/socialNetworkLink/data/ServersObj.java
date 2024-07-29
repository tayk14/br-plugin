package com.rockstargames.gtacr.gui.socialNetworkLink.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/rockstargames/gtacr/gui/socialNetworkLink/data/ServersObj;", "", "serverWithoutDisplay", "", "", "(Ljava/util/List;)V", "getServerWithoutDisplay", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ServersObj {
    private final List<Integer> serverWithoutDisplay;

    public static ServersObj copy$default(ServersObj serversObj, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = serversObj.serverWithoutDisplay;
        }
        return serversObj.copy(list);
    }

    public final List<Integer> component1() {
        return this.serverWithoutDisplay;
    }

    public final ServersObj copy(List<Integer> serverWithoutDisplay) {
        Intrinsics.checkNotNullParameter(serverWithoutDisplay, "serverWithoutDisplay");
        return new ServersObj(serverWithoutDisplay);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ServersObj) && Intrinsics.areEqual(this.serverWithoutDisplay, ((ServersObj) obj).serverWithoutDisplay);
    }

    public int hashCode() {
        return this.serverWithoutDisplay.hashCode();
    }

    public String toString() {
        return "ServersObj(serverWithoutDisplay=" + this.serverWithoutDisplay + ')';
    }

    public ServersObj(List<Integer> serverWithoutDisplay) {
        Intrinsics.checkNotNullParameter(serverWithoutDisplay, "serverWithoutDisplay");
        this.serverWithoutDisplay = serverWithoutDisplay;
    }

    public final List<Integer> getServerWithoutDisplay() {
        return this.serverWithoutDisplay;
    }
}
