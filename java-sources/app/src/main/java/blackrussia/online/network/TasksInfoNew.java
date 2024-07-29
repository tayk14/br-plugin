package blackrussia.online.network;

import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006'"}, d2 = {"Lblackrussia/online/network/TasksInfoNew;", "", GetKeys.GET_PLAYERS_ID, "", Const.FRACTION_TYPE_KEY, "", "text", "description", "num", "award", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAward", "()I", "setAward", "(I)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getId", "setId", "getNum", "setNum", "getText", "setText", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TasksInfoNew {
    @SerializedName("award")
    private int award;
    @SerializedName("description")
    private String description;
    @SerializedName(GetKeys.GET_PLAYERS_ID)
    private int id;
    @SerializedName("count")
    private int num;
    @SerializedName("text")
    private String text;
    @SerializedName(Const.FRACTION_TYPE_KEY)
    private String type;

    public static TasksInfoNew copy$default(TasksInfoNew tasksInfoNew, int i, String str, String str2, String str3, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = tasksInfoNew.id;
        }
        if ((i4 & 2) != 0) {
            str = tasksInfoNew.type;
        }
        String str4 = str;
        if ((i4 & 4) != 0) {
            str2 = tasksInfoNew.text;
        }
        String str5 = str2;
        if ((i4 & 8) != 0) {
            str3 = tasksInfoNew.description;
        }
        String str6 = str3;
        if ((i4 & 16) != 0) {
            i2 = tasksInfoNew.num;
        }
        int i5 = i2;
        if ((i4 & 32) != 0) {
            i3 = tasksInfoNew.award;
        }
        return tasksInfoNew.copy(i, str4, str5, str6, i5, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.description;
    }

    public final int component5() {
        return this.num;
    }

    public final int component6() {
        return this.award;
    }

    public final TasksInfoNew copy(int i, String type, String text, String description, int i2, int i3) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(description, "description");
        return new TasksInfoNew(i, type, text, description, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TasksInfoNew) {
            TasksInfoNew tasksInfoNew = (TasksInfoNew) obj;
            return this.id == tasksInfoNew.id && Intrinsics.areEqual(this.type, tasksInfoNew.type) && Intrinsics.areEqual(this.text, tasksInfoNew.text) && Intrinsics.areEqual(this.description, tasksInfoNew.description) && this.num == tasksInfoNew.num && this.award == tasksInfoNew.award;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.id * 31) + this.type.hashCode()) * 31) + this.text.hashCode()) * 31) + this.description.hashCode()) * 31) + this.num) * 31) + this.award;
    }

    public String toString() {
        return "TasksInfoNew(id=" + this.id + ", type=" + this.type + ", text=" + this.text + ", description=" + this.description + ", num=" + this.num + ", award=" + this.award + ')';
    }

    public TasksInfoNew(int i, String type, String text, String description, int i2, int i3) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = i;
        this.type = type;
        this.text = text;
        this.description = description;
        this.num = i2;
        this.award = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final int getNum() {
        return this.num;
    }

    public final void setNum(int i) {
        this.num = i;
    }

    public final int getAward() {
        return this.award;
    }

    public final void setAward(int i) {
        this.award = i;
    }
}
