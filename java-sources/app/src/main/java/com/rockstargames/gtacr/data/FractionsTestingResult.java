package com.rockstargames.gtacr.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/rockstargames/gtacr/data/FractionsTestingResult;", "", "testingResult", "", "testingTotal", "quantityOfQuestions", "(III)V", "getQuantityOfQuestions", "()I", "getTestingResult", "getTestingTotal", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsTestingResult {
    private final int quantityOfQuestions;
    private final int testingResult;
    private final int testingTotal;

    public static FractionsTestingResult copy$default(FractionsTestingResult fractionsTestingResult, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = fractionsTestingResult.testingResult;
        }
        if ((i4 & 2) != 0) {
            i2 = fractionsTestingResult.testingTotal;
        }
        if ((i4 & 4) != 0) {
            i3 = fractionsTestingResult.quantityOfQuestions;
        }
        return fractionsTestingResult.copy(i, i2, i3);
    }

    public final int component1() {
        return this.testingResult;
    }

    public final int component2() {
        return this.testingTotal;
    }

    public final int component3() {
        return this.quantityOfQuestions;
    }

    public final FractionsTestingResult copy(int i, int i2, int i3) {
        return new FractionsTestingResult(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FractionsTestingResult) {
            FractionsTestingResult fractionsTestingResult = (FractionsTestingResult) obj;
            return this.testingResult == fractionsTestingResult.testingResult && this.testingTotal == fractionsTestingResult.testingTotal && this.quantityOfQuestions == fractionsTestingResult.quantityOfQuestions;
        }
        return false;
    }

    public int hashCode() {
        return (((this.testingResult * 31) + this.testingTotal) * 31) + this.quantityOfQuestions;
    }

    public String toString() {
        return "FractionsTestingResult(testingResult=" + this.testingResult + ", testingTotal=" + this.testingTotal + ", quantityOfQuestions=" + this.quantityOfQuestions + ')';
    }

    public FractionsTestingResult(int i, int i2, int i3) {
        this.testingResult = i;
        this.testingTotal = i2;
        this.quantityOfQuestions = i3;
    }

    public FractionsTestingResult(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public final int getTestingResult() {
        return this.testingResult;
    }

    public final int getTestingTotal() {
        return this.testingTotal;
    }

    public final int getQuantityOfQuestions() {
        return this.quantityOfQuestions;
    }
}
