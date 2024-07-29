package com.rockstargames.gtacr.gui.spawnLocation.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import com.rockstargames.gtacr.gui.spawnLocation.data.SpawnLocationItem;
import com.rockstargames.gtacr.gui.spawnLocation.data.SpawnLocationList;
import com.rockstargames.gtacr.gui.spawnLocation.network.SpawnLocationActionsWithJson;
import com.rockstargames.gtacr.gui.spawnLocation.network.SpawnLocationRepository;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001aH\u0014J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0012J\u0014\u0010\u001e\u001a\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/rockstargames/gtacr/gui/spawnLocation/viewModels/SpawnLocationViewModel;", "Landroidx/lifecycle/ViewModel;", "spawnLocationActionsWithJson", "Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationActionsWithJson;", "spawnLocationRepository", "Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationRepository;", "(Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationActionsWithJson;Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationRepository;)V", "disposable", "Lio/reactivex/rxjava3/disposables/Disposable;", "errorLiveData", "Landroidx/lifecycle/LiveData;", "", "getErrorLiveData", "()Landroidx/lifecycle/LiveData;", "errorMutableLiveData", "Landroidx/lifecycle/MutableLiveData;", "listOfAvailabilityMutableLiveData", "", "", "mediatorMutableLiveData", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/rockstargames/gtacr/gui/spawnLocation/data/SpawnLocationList;", "getMediatorMutableLiveData", "()Landroidx/lifecycle/MediatorLiveData;", "spawnLocationListMutableLiveData", "getListOfItems", "", "onCleared", "sendChosenPlace", GetKeys.GET_PLAYERS_ID, "setListOfAvailability", "listOfAvailability", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpawnLocationViewModel extends ViewModel {
    private Disposable disposable;
    private final LiveData<String> errorLiveData;
    private final MutableLiveData<String> errorMutableLiveData;
    private final MutableLiveData<List<Integer>> listOfAvailabilityMutableLiveData;
    private final MediatorLiveData<SpawnLocationList> mediatorMutableLiveData;
    private final SpawnLocationActionsWithJson spawnLocationActionsWithJson;
    private final MutableLiveData<SpawnLocationList> spawnLocationListMutableLiveData;
    private final SpawnLocationRepository spawnLocationRepository;

    public SpawnLocationViewModel(SpawnLocationActionsWithJson spawnLocationActionsWithJson, SpawnLocationRepository spawnLocationRepository) {
        Intrinsics.checkNotNullParameter(spawnLocationActionsWithJson, "spawnLocationActionsWithJson");
        Intrinsics.checkNotNullParameter(spawnLocationRepository, "spawnLocationRepository");
        this.spawnLocationActionsWithJson = spawnLocationActionsWithJson;
        this.spawnLocationRepository = spawnLocationRepository;
        MediatorLiveData<SpawnLocationList> mediatorLiveData = new MediatorLiveData<>();
        this.mediatorMutableLiveData = mediatorLiveData;
        MutableLiveData<SpawnLocationList> mutableLiveData = new MutableLiveData<>();
        this.spawnLocationListMutableLiveData = mutableLiveData;
        MutableLiveData<List<Integer>> mutableLiveData2 = new MutableLiveData<>();
        this.listOfAvailabilityMutableLiveData = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this.errorMutableLiveData = mutableLiveData3;
        this.errorLiveData = mutableLiveData3;
        mediatorLiveData.addSource(mutableLiveData, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                SpawnLocationViewModel.m413_init_$lambda0(SpawnLocationViewModel.this, (SpawnLocationList) obj);
            }
        });
        mediatorLiveData.addSource(mutableLiveData2, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                SpawnLocationViewModel.m414_init_$lambda1(SpawnLocationViewModel.this, (List) obj);
            }
        });
    }

    public final MediatorLiveData<SpawnLocationList> getMediatorMutableLiveData() {
        return this.mediatorMutableLiveData;
    }

    public final LiveData<String> getErrorLiveData() {
        return this.errorLiveData;
    }

    public static final void m413_init_$lambda0(SpawnLocationViewModel this$0, SpawnLocationList value) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(value, "value");
        SpawnLocationList value2 = this$0.mediatorMutableLiveData.getValue();
        if (value2 == null) {
            value2 = new SpawnLocationList(new ArrayList());
        }
        value2.setSpawnLocationList(value.getSpawnLocationList());
        this$0.mediatorMutableLiveData.setValue(value2);
    }

    public static final void m414_init_$lambda1(SpawnLocationViewModel this$0, List value) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(value, "value");
        SpawnLocationList value2 = this$0.mediatorMutableLiveData.getValue();
        if (value2 == null) {
            value2 = new SpawnLocationList(new ArrayList());
        }
        value2.setListOfAvailability(value);
        this$0.mediatorMutableLiveData.setValue(value2);
    }

    public final void getListOfItems() {
        this.disposable = this.spawnLocationRepository.getListOfSpawnLocationItems().subscribeOn(Schedulers.io()).subscribe(new Consumer() {
            @Override
            public final void accept(Object obj) {
                SpawnLocationViewModel.m415getListOfItems$lambda3(SpawnLocationViewModel.this, (SpawnLocationList) obj);
            }
        }, new Consumer() {
            @Override
            public final void accept(Object obj) {
                SpawnLocationViewModel.m416getListOfItems$lambda4(SpawnLocationViewModel.this, (Throwable) obj);
            }
        });
    }

    public static final void m415getListOfItems$lambda3(SpawnLocationViewModel this$0, SpawnLocationList spawnLocationList) {
        Object obj = null;
        boolean z;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SpawnLocationItem spawnLocationItem = (SpawnLocationItem) obj;
        if (spawnLocationItem != null) {
            spawnLocationList.getSpawnLocationList().get(spawnLocationList.getSpawnLocationList().indexOf(spawnLocationItem)).setSelected(true);
        }
        this$0.spawnLocationListMutableLiveData.postValue(spawnLocationList);
    }

    public static final void m416getListOfItems$lambda4(SpawnLocationViewModel this$0, Throwable th) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.errorMutableLiveData.postValue(th.getMessage());
    }

    public final void setListOfAvailability(List<Integer> listOfAvailability) {
        Intrinsics.checkNotNullParameter(listOfAvailability, "listOfAvailability");
        this.listOfAvailabilityMutableLiveData.setValue(listOfAvailability);
    }

    public final void sendChosenPlace(int i) {
        this.spawnLocationActionsWithJson.sendKey(i);
    }

    @Override
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.disposable;
        if (disposable == null) {
            return;
        }
        disposable.dispose();
    }
}
