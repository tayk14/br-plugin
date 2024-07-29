package com.rockstargames.gtacr.data;

import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/rockstargames/gtacr/data/DrivingAnswer;", "", GetKeys.GET_PLAYERS_ID, "", "answersText", "", "isChecked", "", "(ILjava/lang/String;Z)V", "getAnswersText", "()Ljava/lang/String;", "setAnswersText", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "()Z", "setChecked", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DrivingAnswer {
    private String answersText;
    private int id;
    private boolean isChecked;

    public static DrivingAnswer copy$default(DrivingAnswer drivingAnswer, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = drivingAnswer.id;
        }
        if ((i2 & 2) != 0) {
            str = drivingAnswer.answersText;
        }
        if ((i2 & 4) != 0) {
            z = drivingAnswer.isChecked;
        }
        return drivingAnswer.copy(i, str, z);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.answersText;
    }

    public final boolean component3() {
        return this.isChecked;
    }

    public final DrivingAnswer copy(int i, String answersText, boolean z) {
        Intrinsics.checkNotNullParameter(answersText, "answersText");
        return new DrivingAnswer(i, answersText, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrivingAnswer) {
            DrivingAnswer drivingAnswer = (DrivingAnswer) obj;
            return this.id == drivingAnswer.id && Intrinsics.areEqual(this.answersText, drivingAnswer.answersText) && this.isChecked == drivingAnswer.isChecked;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.id * 31) + this.answersText.hashCode()) * 31;
        boolean z = this.isChecked;
        int i = 0;
        if (z) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "DrivingAnswer(id=" + this.id + ", answersText=" + this.answersText + ", isChecked=" + this.isChecked + ')';
    }

    public DrivingAnswer(int i, String answersText, boolean z) {
        Intrinsics.checkNotNullParameter(answersText, "answersText");
        this.id = i;
        this.answersText = answersText;
        this.isChecked = z;
    }

    public DrivingAnswer(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z);
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final String getAnswersText() {
        return this.answersText;
    }

    public final void setAnswersText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.answersText = str;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }
}
