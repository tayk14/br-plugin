package com.rockstargames.gtacr.gui.fractions.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import blackrussia.online.network.fraction.data.FractionsNewRankRewardItem;
import blackrussia.online.network.fraction.data.FractionsProgressStaffItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.rockstargames.gtacr.gui.fractions.ActionsWithJSON;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007J&\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0007J\u000e\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u0007J\u0010\u0010.\u001a\u00020\u001e2\b\u0010/\u001a\u0004\u0018\u00010\u0016J\u000e\u00100\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\t¨\u00061"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsMainViewModel;", "Landroidx/lifecycle/ViewModel;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;", "(Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;)V", "addAddTokensBCValueLiveData", "Landroidx/lifecycle/LiveData;", "", "getAddAddTokensBCValueLiveData", "()Landroidx/lifecycle/LiveData;", "addTokensPriceLiveData", "getAddTokensPriceLiveData", "fractionIdLiveData", "getFractionIdLiveData", "fractionTokensLiveData", "getFractionTokensLiveData", "mutableAddTokensBCValueLiveData", "Landroidx/lifecycle/MutableLiveData;", "mutableAddTokensPriceLiveData", "mutableFractionIdLiveData", "mutableFractionTokensLiveData", "mutableNewRankRewardItemLiveData", "Lblackrussia/online/network/fraction/data/FractionsNewRankRewardItem;", "mutableProgressStaffItemLiveData", "Lblackrussia/online/network/fraction/data/FractionsProgressStaffItem;", "newRankRewardItemLiveData", "getNewRankRewardItemLiveData", "progressStaffItemLiveData", "getProgressStaffItemLiveData", "sendButtonPressed", "", "currentLayout", "typeKey", "sendKeyWithType", "currentPage", "mainKey", "", "value", "setAddTokensPrice", FirebaseAnalytics.Param.PRICE, "setBCValue", "bcValue", "setFractionId", "fractionId", "setFractionTokens", "fractionTokens", "setFractionsNewRankRewardItem", "item", "setFractionsProgressStaffItem", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsMainViewModel extends ViewModel {
    private final ActionsWithJSON actionsWithJSON;
    private final LiveData<Integer> addAddTokensBCValueLiveData;
    private final LiveData<Integer> addTokensPriceLiveData;
    private final LiveData<Integer> fractionIdLiveData;
    private final LiveData<Integer> fractionTokensLiveData;
    private final MutableLiveData<Integer> mutableAddTokensBCValueLiveData;
    private final MutableLiveData<Integer> mutableAddTokensPriceLiveData;
    private final MutableLiveData<Integer> mutableFractionIdLiveData;
    private final MutableLiveData<Integer> mutableFractionTokensLiveData;
    private final MutableLiveData<FractionsNewRankRewardItem> mutableNewRankRewardItemLiveData;
    private final MutableLiveData<FractionsProgressStaffItem> mutableProgressStaffItemLiveData;
    private final LiveData<FractionsNewRankRewardItem> newRankRewardItemLiveData;
    private final LiveData<FractionsProgressStaffItem> progressStaffItemLiveData;

    public FractionsMainViewModel(ActionsWithJSON actionsWithJSON) {
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.actionsWithJSON = actionsWithJSON;
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this.mutableFractionTokensLiveData = mutableLiveData;
        this.fractionTokensLiveData = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this.mutableFractionIdLiveData = mutableLiveData2;
        this.fractionIdLiveData = mutableLiveData2;
        MutableLiveData<FractionsProgressStaffItem> mutableLiveData3 = new MutableLiveData<>();
        this.mutableProgressStaffItemLiveData = mutableLiveData3;
        this.progressStaffItemLiveData = mutableLiveData3;
        MutableLiveData<FractionsNewRankRewardItem> mutableLiveData4 = new MutableLiveData<>();
        this.mutableNewRankRewardItemLiveData = mutableLiveData4;
        this.newRankRewardItemLiveData = mutableLiveData4;
        MutableLiveData<Integer> mutableLiveData5 = new MutableLiveData<>();
        this.mutableAddTokensPriceLiveData = mutableLiveData5;
        this.addTokensPriceLiveData = mutableLiveData5;
        MutableLiveData<Integer> mutableLiveData6 = new MutableLiveData<>();
        this.mutableAddTokensBCValueLiveData = mutableLiveData6;
        this.addAddTokensBCValueLiveData = mutableLiveData6;
    }

    public final LiveData<Integer> getFractionTokensLiveData() {
        return this.fractionTokensLiveData;
    }

    public final LiveData<Integer> getFractionIdLiveData() {
        return this.fractionIdLiveData;
    }

    public final LiveData<FractionsProgressStaffItem> getProgressStaffItemLiveData() {
        return this.progressStaffItemLiveData;
    }

    public final LiveData<FractionsNewRankRewardItem> getNewRankRewardItemLiveData() {
        return this.newRankRewardItemLiveData;
    }

    public final LiveData<Integer> getAddTokensPriceLiveData() {
        return this.addTokensPriceLiveData;
    }

    public final LiveData<Integer> getAddAddTokensBCValueLiveData() {
        return this.addAddTokensBCValueLiveData;
    }

    public final void setFractionId(int i) {
        this.mutableFractionIdLiveData.setValue(Integer.valueOf(i));
    }

    public final void setFractionTokens(int i) {
        this.mutableFractionTokensLiveData.setValue(Integer.valueOf(i));
    }

    public final void setFractionsProgressStaffItem(FractionsProgressStaffItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.mutableProgressStaffItemLiveData.setValue(item);
    }

    public final void setFractionsNewRankRewardItem(FractionsNewRankRewardItem fractionsNewRankRewardItem) {
        this.mutableNewRankRewardItemLiveData.setValue(fractionsNewRankRewardItem);
    }

    public final void setAddTokensPrice(int i) {
        this.mutableAddTokensPriceLiveData.setValue(Integer.valueOf(i));
    }

    public final void setBCValue(int i) {
        this.mutableAddTokensBCValueLiveData.setValue(Integer.valueOf(i));
    }

    public final void sendButtonPressed(int i, int i2) {
        this.actionsWithJSON.sendButtonPressed(i, i2);
    }

    public final void sendKeyWithType(int i, int i2, String mainKey, int i3) {
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        this.actionsWithJSON.sendKeyWithType(i, i2, mainKey, i3);
    }
}
