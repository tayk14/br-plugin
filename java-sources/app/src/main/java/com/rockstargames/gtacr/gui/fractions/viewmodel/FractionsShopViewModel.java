package com.rockstargames.gtacr.gui.fractions.viewmodel;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import blackrussia.online.network.fraction.FractionRepository;
import blackrussia.online.network.fraction.FractionRepositoryImpl;
import com.rockstargames.gtacr.data.FractionsShopList;
import com.rockstargames.gtacr.gui.fractions.ActionsWithJSON;
import com.rockstargames.gtacr.gui.fractions.Const;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsShopViewModel;", "Landroidx/lifecycle/ViewModel;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;", "(Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;)V", "getActionsWithJSON", "()Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;", "mutableShopListLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/rockstargames/gtacr/data/FractionsShopList;", "repository", "Lblackrussia/online/network/fraction/FractionRepository;", "getRepository", "()Lblackrussia/online/network/fraction/FractionRepository;", "repository$delegate", "Lkotlin/Lazy;", "shopListLiveData", "Landroidx/lifecycle/LiveData;", "getShopListLiveData", "()Landroidx/lifecycle/LiveData;", "getShopList", "", "sendItemPressed", "uniqueId", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsShopViewModel extends ViewModel {
    private final ActionsWithJSON actionsWithJSON;
    private final MutableLiveData<FractionsShopList> mutableShopListLiveData;
    private final Lazy repository$delegate;
    private final LiveData<FractionsShopList> shopListLiveData;

    public FractionsShopViewModel(ActionsWithJSON actionsWithJSON) {
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.actionsWithJSON = actionsWithJSON;
        this.repository$delegate = LazyKt.lazy(new Function0<FractionRepositoryImpl>() {
            @Override
            public final FractionRepositoryImpl invoke() {
                return new FractionRepositoryImpl();
            }
        });
        MutableLiveData<FractionsShopList> mutableLiveData = new MutableLiveData<>();
        this.mutableShopListLiveData = mutableLiveData;
        this.shopListLiveData = mutableLiveData;
    }

    public final ActionsWithJSON getActionsWithJSON() {
        return this.actionsWithJSON;
    }

    private final FractionRepository getRepository() {
        return (FractionRepository) this.repository$delegate.getValue();
    }

    public final LiveData<FractionsShopList> getShopListLiveData() {
        return this.shopListLiveData;
    }

    public final void getShopList() {
        getRepository().getFractionShopItems().subscribeOn(Schedulers.io()).subscribe(new Consumer() {
            @Override
            public final void accept(Object obj) {
                FractionsShopViewModel.m307getShopList$lambda0(FractionsShopViewModel.this, (FractionsShopList) obj);
            }
        }, new Consumer() {
            @Override
            public final void accept(Object obj) {
                FractionsShopViewModel.m308getShopList$lambda1((Throwable) obj);
            }
        });
    }

    public static final void m307getShopList$lambda0(FractionsShopViewModel this$0, FractionsShopList fractionsShopList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        fractionsShopList.setItemClicked(-1);
        if (fractionsShopList.equals(this$0.mutableShopListLiveData.getValue())) {
            return;
        }
        this$0.mutableShopListLiveData.postValue(fractionsShopList);
    }

    public static final void m308getShopList$lambda1(Throwable th) {
        Log.d(Const.LOG_FRACTION_S, Intrinsics.stringPlus("getShopList  ", th));
    }

    public final void sendItemPressed(int i) {
        this.actionsWithJSON.sendItemInShopPressed(20, i);
    }
}
