package com.rockstargames.gtacr.data;

import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/rockstargames/gtacr/data/HintQuestData;", "", "questsText", "Landroid/text/Spanned;", "thisQuestsStatus", "", "maxQuestsStatus", "ifMainQuest", "", "(Landroid/text/Spanned;IIZ)V", "getIfMainQuest", "()Z", "getMaxQuestsStatus", "()I", "setMaxQuestsStatus", "(I)V", "getQuestsText", "()Landroid/text/Spanned;", "getThisQuestsStatus", "setThisQuestsStatus", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HintQuestData {
    private final boolean ifMainQuest;
    private int maxQuestsStatus;
    private final Spanned questsText;
    private int thisQuestsStatus;

    public static HintQuestData copy$default(HintQuestData hintQuestData, Spanned spanned, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            spanned = hintQuestData.questsText;
        }
        if ((i3 & 2) != 0) {
            i = hintQuestData.thisQuestsStatus;
        }
        if ((i3 & 4) != 0) {
            i2 = hintQuestData.maxQuestsStatus;
        }
        if ((i3 & 8) != 0) {
            z = hintQuestData.ifMainQuest;
        }
        return hintQuestData.copy(spanned, i, i2, z);
    }

    public final Spanned component1() {
        return this.questsText;
    }

    public final int component2() {
        return this.thisQuestsStatus;
    }

    public final int component3() {
        return this.maxQuestsStatus;
    }

    public final boolean component4() {
        return this.ifMainQuest;
    }

    public final HintQuestData copy(Spanned questsText, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(questsText, "questsText");
        return new HintQuestData(questsText, i, i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HintQuestData) {
            HintQuestData hintQuestData = (HintQuestData) obj;
            return Intrinsics.areEqual(this.questsText, hintQuestData.questsText) && this.thisQuestsStatus == hintQuestData.thisQuestsStatus && this.maxQuestsStatus == hintQuestData.maxQuestsStatus && this.ifMainQuest == hintQuestData.ifMainQuest;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.questsText.hashCode() * 31) + this.thisQuestsStatus) * 31) + this.maxQuestsStatus) * 31;
        boolean z = this.ifMainQuest;
        int i = 0;
        if (z) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "HintQuestData(questsText=" + ((Object) this.questsText) + ", thisQuestsStatus=" + this.thisQuestsStatus + ", maxQuestsStatus=" + this.maxQuestsStatus + ", ifMainQuest=" + this.ifMainQuest + ')';
    }

    public HintQuestData(Spanned questsText, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(questsText, "questsText");
        this.questsText = questsText;
        this.thisQuestsStatus = i;
        this.maxQuestsStatus = i2;
        this.ifMainQuest = z;
    }

    public final Spanned getQuestsText() {
        return this.questsText;
    }

    public final int getThisQuestsStatus() {
        return this.thisQuestsStatus;
    }

    public final void setThisQuestsStatus(int i) {
        this.thisQuestsStatus = i;
    }

    public final int getMaxQuestsStatus() {
        return this.maxQuestsStatus;
    }

    public final void setMaxQuestsStatus(int i) {
        this.maxQuestsStatus = i;
    }

    public final boolean getIfMainQuest() {
        return this.ifMainQuest;
    }
}
