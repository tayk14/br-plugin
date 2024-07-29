package com.rockstargames.gtacr.gui.fractions.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import blackrussia.online.network.fraction.data.FractionControlListOfPlayers;
import blackrussia.online.network.fraction.data.FractionControlPlayerInfo;
import com.rockstargames.gtacr.gui.fractions.ActionsWithJSON;
import com.rockstargames.gtacr.gui.fractions.Const;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

//@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\bJ\u000e\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\bJ\u000e\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\bJ\u000e\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\bJ\u000e\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\bJ\u0010\u00101\u001a\u00020'2\b\u00102\u001a\u0004\u0018\u00010\u000bJ\u000e\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020\bJ\u000e\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u0014J\u000e\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020\bJ\u000e\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020\bJ\u0016\u0010;\u001a\u00020'2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018J\u0016\u0010=\u001a\u00020'2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\rR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\rR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\rR\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#¨\u0006>"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsControlViewModel;", "Landroidx/lifecycle/ViewModel;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;", "(Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;)V", "getActionsWithJSON", "()Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;", "fractionsControlChosenAccountId", "", "infoAboutPlayerLiveData", "Landroidx/lifecycle/LiveData;", "Lblackrussia/online/network/fraction/data/FractionControlPlayerInfo;", "getInfoAboutPlayerLiveData", "()Landroidx/lifecycle/LiveData;", "menuSortedPressedLiveData", "getMenuSortedPressedLiveData", "mutableInfoAboutPlayerLiveData", "Landroidx/lifecycle/MutableLiveData;", "mutableMenuSortedPressedMutableLiveData", "mutableNewPlayersPosition", "", "mutableNewPlayersRankLiveData", "mutableNewPlayersReprimandLiveData", "mutableSortedStaffList", "", "Lblackrussia/online/network/fraction/data/FractionControlListOfPlayers;", "mutableStaffListLiveData", "newPlayersPosition", "getNewPlayersPosition", "newPlayersRankLiveData", "getNewPlayersRankLiveData", "newPlayersReprimandLiveData", "getNewPlayersReprimandLiveData", "sortedStaffListLiveData", "getSortedStaffListLiveData", "()Landroidx/lifecycle/MutableLiveData;", "staffListLiveData", "getStaffListLiveData", "dismissPlayerFromFraction", "", "dismissedPlayerId", "sendButtonPressed", Const.FRACTION_BUTTON_KEY, "sendChangeRank", "changeRank", "sendChangeReprimands", "changeReprimand", "sendPlayerChosenId", "accountId", "setInfoAboutPlayer", "item", "setMenuSortedPressed", "pressed", "setNewPlayersPosition", "newPosition", "setNewPlayersRankLiveData", "newRank", "setNewPlayersReprimandLiveData", "newReprimand", "setSortedStaffListLiveData", "list", "setStaffListLiveData", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsControlViewModel extends ViewModel {
    private final ActionsWithJSON actionsWithJSON;
    private int fractionsControlChosenAccountId;
    private final LiveData<FractionControlPlayerInfo> infoAboutPlayerLiveData;
    private final LiveData<Integer> menuSortedPressedLiveData;
    private final MutableLiveData<FractionControlPlayerInfo> mutableInfoAboutPlayerLiveData;
    private final MutableLiveData<Integer> mutableMenuSortedPressedMutableLiveData;
    private final MutableLiveData<String> mutableNewPlayersPosition;
    private final MutableLiveData<Integer> mutableNewPlayersRankLiveData;
    private final MutableLiveData<Integer> mutableNewPlayersReprimandLiveData;
    private final MutableLiveData<List<FractionControlListOfPlayers>> mutableSortedStaffList;
    private final MutableLiveData<List<FractionControlListOfPlayers>> mutableStaffListLiveData;
    private final LiveData<String> newPlayersPosition;
    private final LiveData<Integer> newPlayersRankLiveData;
    private final LiveData<Integer> newPlayersReprimandLiveData;
    private final MutableLiveData<List<FractionControlListOfPlayers>> sortedStaffListLiveData;
    private final MutableLiveData<List<FractionControlListOfPlayers>> staffListLiveData;

    public FractionsControlViewModel(ActionsWithJSON actionsWithJSON) {
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.actionsWithJSON = actionsWithJSON;
        this.fractionsControlChosenAccountId = -1;
        MutableLiveData<List<FractionControlListOfPlayers>> mutableLiveData = new MutableLiveData<>();
        this.mutableStaffListLiveData = mutableLiveData;
        this.staffListLiveData = mutableLiveData;
        MutableLiveData<List<FractionControlListOfPlayers>> mutableLiveData2 = new MutableLiveData<>();
        this.mutableSortedStaffList = mutableLiveData2;
        this.sortedStaffListLiveData = mutableLiveData2;
        MutableLiveData<Integer> mutableLiveData3 = new MutableLiveData<>();
        this.mutableMenuSortedPressedMutableLiveData = mutableLiveData3;
        this.menuSortedPressedLiveData = mutableLiveData3;
        MutableLiveData<FractionControlPlayerInfo> mutableLiveData4 = new MutableLiveData<>();
        this.mutableInfoAboutPlayerLiveData = mutableLiveData4;
        this.infoAboutPlayerLiveData = mutableLiveData4;
        MutableLiveData<Integer> mutableLiveData5 = new MutableLiveData<>();
        this.mutableNewPlayersRankLiveData = mutableLiveData5;
        this.newPlayersRankLiveData = mutableLiveData5;
        MutableLiveData<String> mutableLiveData6 = new MutableLiveData<>();
        this.mutableNewPlayersPosition = mutableLiveData6;
        this.newPlayersPosition = mutableLiveData6;
        MutableLiveData<Integer> mutableLiveData7 = new MutableLiveData<>();
        this.mutableNewPlayersReprimandLiveData = mutableLiveData7;
        this.newPlayersReprimandLiveData = mutableLiveData7;
    }

    public final ActionsWithJSON getActionsWithJSON() {
        return this.actionsWithJSON;
    }

    public final MutableLiveData<List<FractionControlListOfPlayers>> getStaffListLiveData() {
        return this.staffListLiveData;
    }

    public final MutableLiveData<List<FractionControlListOfPlayers>> getSortedStaffListLiveData() {
        return this.sortedStaffListLiveData;
    }

    public final LiveData<Integer> getMenuSortedPressedLiveData() {
        return this.menuSortedPressedLiveData;
    }

    public final LiveData<FractionControlPlayerInfo> getInfoAboutPlayerLiveData() {
        return this.infoAboutPlayerLiveData;
    }

    public final LiveData<Integer> getNewPlayersRankLiveData() {
        return this.newPlayersRankLiveData;
    }

    public final LiveData<String> getNewPlayersPosition() {
        return this.newPlayersPosition;
    }

    public final LiveData<Integer> getNewPlayersReprimandLiveData() {
        return this.newPlayersReprimandLiveData;
    }

    public final void setStaffListLiveData(List<FractionControlListOfPlayers> list) {
        this.mutableStaffListLiveData.setValue(list);
    }

    public final void setSortedStaffListLiveData(List<FractionControlListOfPlayers> list) {
        List<FractionControlListOfPlayers> list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            sendPlayerChosenId(list.get(0).getId());
            for (FractionControlListOfPlayers fractionControlListOfPlayers : list) {
                fractionControlListOfPlayers.setClicked(false);
            }
            list.get(0).setClicked(true);
        }
        this.mutableSortedStaffList.setValue(list);
    }

    public final void setMenuSortedPressed(int i) {
        this.mutableMenuSortedPressedMutableLiveData.setValue(Integer.valueOf(i));
    }

    public final void setInfoAboutPlayer(FractionControlPlayerInfo fractionControlPlayerInfo) {
        this.mutableInfoAboutPlayerLiveData.setValue(fractionControlPlayerInfo);
        if (fractionControlPlayerInfo == null) {
            return;
        }
        fractionControlPlayerInfo.setId(this.fractionsControlChosenAccountId);
    }

    public final void setNewPlayersRankLiveData(int i) {
        this.mutableNewPlayersRankLiveData.setValue(Integer.valueOf(i));
        this.mutableNewPlayersRankLiveData.setValue(-1);
    }

    public final void setNewPlayersPosition(String newPosition) {
        Intrinsics.checkNotNullParameter(newPosition, "newPosition");
        this.mutableNewPlayersPosition.setValue(newPosition);
    }

    public final void setNewPlayersReprimandLiveData(int i) {
        this.mutableNewPlayersReprimandLiveData.setValue(Integer.valueOf(i));
        this.mutableNewPlayersReprimandLiveData.setValue(-1);
    }

    public final void dismissPlayerFromFraction(int i) {
        boolean z;
        List<FractionControlListOfPlayers> value = this.mutableStaffListLiveData.getValue();
        List<FractionControlListOfPlayers> value2 = this.mutableStaffListLiveData.getValue();
        Object obj = null;
        if (value2 != null) {
            obj = (FractionControlListOfPlayers) obj;
        }
        if (value != null) {
            TypeIntrinsics.asMutableCollection(value).remove(obj);
        }
        List<FractionControlListOfPlayers> value3 = this.mutableSortedStaffList.getValue();
        if (value3 != null) {
            TypeIntrinsics.asMutableCollection(value3).remove(obj);
        }
        this.mutableStaffListLiveData.setValue(value);
        this.mutableSortedStaffList.setValue(value3);
    }

    public final void sendPlayerChosenId(int i) {
        if (this.fractionsControlChosenAccountId != i) {
            this.fractionsControlChosenAccountId = i;
            if (i > 0) {
                this.actionsWithJSON.sendPlayerChosenId(i);
            }
        }
    }

    public final void sendChangeRank(int i) {
        this.actionsWithJSON.sendChangeRankOrReprimand(16, i);
    }

    public final void sendChangeReprimands(int i) {
        this.actionsWithJSON.sendChangeRankOrReprimand(17, i);
    }

    public final void sendButtonPressed(int i) {
        this.actionsWithJSON.sendButtonPressed(9, i);
    }
}
