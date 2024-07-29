package com.rockstargames.gtacr.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/rockstargames/gtacr/data/MessageData;", "", "players", "", "message", "", "actionStatus", "itemsName", "valueOfMoney", "(ILjava/lang/String;ILjava/lang/String;I)V", "getActionStatus", "()I", "getItemsName", "()Ljava/lang/String;", "getMessage", "getPlayers", "getValueOfMoney", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MessageData {
    private final int actionStatus;
    private final String itemsName;
    private final String message;
    private final int players;
    private final int valueOfMoney;

    public static MessageData copy$default(MessageData messageData, int i, String str, int i2, String str2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = messageData.players;
        }
        if ((i4 & 2) != 0) {
            str = messageData.message;
        }
        String str3 = str;
        if ((i4 & 4) != 0) {
            i2 = messageData.actionStatus;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            str2 = messageData.itemsName;
        }
        String str4 = str2;
        if ((i4 & 16) != 0) {
            i3 = messageData.valueOfMoney;
        }
        return messageData.copy(i, str3, i5, str4, i3);
    }

    public final int component1() {
        return this.players;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.actionStatus;
    }

    public final String component4() {
        return this.itemsName;
    }

    public final int component5() {
        return this.valueOfMoney;
    }

    public final MessageData copy(int i, String message, int i2, String itemsName, int i3) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(itemsName, "itemsName");
        return new MessageData(i, message, i2, itemsName, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageData) {
            MessageData messageData = (MessageData) obj;
            return this.players == messageData.players && Intrinsics.areEqual(this.message, messageData.message) && this.actionStatus == messageData.actionStatus && Intrinsics.areEqual(this.itemsName, messageData.itemsName) && this.valueOfMoney == messageData.valueOfMoney;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.players * 31) + this.message.hashCode()) * 31) + this.actionStatus) * 31) + this.itemsName.hashCode()) * 31) + this.valueOfMoney;
    }

    public String toString() {
        return "MessageData(players=" + this.players + ", message=" + this.message + ", actionStatus=" + this.actionStatus + ", itemsName=" + this.itemsName + ", valueOfMoney=" + this.valueOfMoney + ')';
    }

    public MessageData(int i, String message, int i2, String itemsName, int i3) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(itemsName, "itemsName");
        this.players = i;
        this.message = message;
        this.actionStatus = i2;
        this.itemsName = itemsName;
        this.valueOfMoney = i3;
    }

    public final int getPlayers() {
        return this.players;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getActionStatus() {
        return this.actionStatus;
    }

    public final String getItemsName() {
        return this.itemsName;
    }

    public final int getValueOfMoney() {
        return this.valueOfMoney;
    }
}
