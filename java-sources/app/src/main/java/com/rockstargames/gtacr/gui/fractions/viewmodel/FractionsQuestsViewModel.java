package com.rockstargames.gtacr.gui.fractions.viewmodel;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import blackrussia.online.network.fraction.FractionRepository;
import blackrussia.online.network.fraction.FractionRepositoryImpl;
import blackrussia.online.network.fraction.data.FractionQuestsItem;
import blackrussia.online.network.fraction.data.FractionQuestsList;
import blackrussia.online.network.fraction.data.FractionQuestsObj;
import com.rockstargames.gtacr.gui.fractions.ActionsWithJSON;
import com.rockstargames.gtacr.gui.fractions.Const;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

//@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsQuestsViewModel;", "Landroidx/lifecycle/ViewModel;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;", "(Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;)V", "mutableQuestsLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lblackrussia/online/network/fraction/data/FractionQuestsItem;", "questsLiveData", "Landroidx/lifecycle/LiveData;", "getQuestsLiveData", "()Landroidx/lifecycle/LiveData;", "questsObjMutableLivedata", "Lblackrussia/online/network/fraction/data/FractionQuestsList;", "repository", "Lblackrussia/online/network/fraction/FractionRepository;", "getRepository", "()Lblackrussia/online/network/fraction/FractionRepository;", "repository$delegate", "Lkotlin/Lazy;", "getQuestsObj", "", "sendStartQuest", "taskId", "", "setQuestsList", "fractionId", Const.FRACTION_CONTROL_PLAYER_RANK, "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsQuestsViewModel extends ViewModel {
    private final ActionsWithJSON actionsWithJSON;
    private final MutableLiveData<List<FractionQuestsItem>> mutableQuestsLiveData;
    private final LiveData<List<FractionQuestsItem>> questsLiveData;
    private final MutableLiveData<List<FractionQuestsList>> questsObjMutableLivedata;
    private final Lazy repository$delegate;

    public FractionsQuestsViewModel(ActionsWithJSON actionsWithJSON) {
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.actionsWithJSON = actionsWithJSON;
        this.repository$delegate = LazyKt.lazy(new Function0<FractionRepositoryImpl>() {
            @Override
            public final FractionRepositoryImpl invoke() {
                return new FractionRepositoryImpl();
            }
        });
        this.questsObjMutableLivedata = new MutableLiveData<>();
        MutableLiveData<List<FractionQuestsItem>> mutableLiveData = new MutableLiveData<>();
        this.mutableQuestsLiveData = mutableLiveData;
        this.questsLiveData = mutableLiveData;
    }

    private final FractionRepository getRepository() {
        return (FractionRepository) this.repository$delegate.getValue();
    }

    public final LiveData<List<FractionQuestsItem>> getQuestsLiveData() {
        return this.questsLiveData;
    }

    public final void getQuestsObj() {
        getRepository().getQuestsObj().subscribeOn(Schedulers.io()).subscribe(new Consumer() {
            @Override
            public final void accept(Object obj) {
                FractionsQuestsViewModel.m304getQuestsObj$lambda0(FractionsQuestsViewModel.this, (FractionQuestsObj) obj);
            }
        }, new Consumer() {
            @Override
            public final void accept(Object obj) {
                FractionsQuestsViewModel.m305getQuestsObj$lambda1((Throwable) obj);
            }
        });
    }

    public static final void m304getQuestsObj$lambda0(FractionsQuestsViewModel this$0, FractionQuestsObj fractionQuestsObj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.questsObjMutableLivedata.postValue(fractionQuestsObj.getFractionQuests());
    }

    public static final void m305getQuestsObj$lambda1(Throwable th) {
        Log.e(Const.LOG_FRACTION_S, Intrinsics.stringPlus("getQuestsList ERROR: ", th));
    }

    public final void setQuestsList(int i, int i2) {
        Object obj;
        Object obj2;
        boolean z;
        if (this.questsObjMutableLivedata.getValue() == null) {
            getQuestsObj();
            Log.e(Const.LOG_FRACTION_S, "questsObjMutableLivedata.value == NULL");
            return;
        }
        List<FractionQuestsList> value = this.questsObjMutableLivedata.getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "questsObjMutableLivedata.value!!");
    }

    public final void sendStartQuest(int i) {
        this.actionsWithJSON.sendStartQuest(i);
    }
}
