package com.rockstargames.gtacr.gui.fractions.viewmodel;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import blackrussia.online.network.fraction.FractionRepository;
import blackrussia.online.network.fraction.FractionRepositoryImpl;
import blackrussia.online.network.fraction.data.FractionsDocumentsItem;
import blackrussia.online.network.fraction.data.FractionsDocumentsObj;
import blackrussia.online.network.fraction.data.FractionsDocumentsObjList;
import blackrussia.online.network.fraction.data.FractionsTestingItem;
import com.rockstargames.gtacr.data.FractionsTestingResult;
import com.rockstargames.gtacr.gui.fractions.ActionsWithJSON;
import com.rockstargames.gtacr.gui.fractions.Const;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

//@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0007J\u0016\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007J\u0016\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007J\u0016\u0010*\u001a\u00020!2\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bJ\u000e\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u0007J\u000e\u0010.\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0007J\u0010\u0010/\u001a\u00020!2\b\u00100\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\tR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\t¨\u00061"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsDocumentsViewModel;", "Landroidx/lifecycle/ViewModel;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;", "(Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;)V", "documentIdLiveData", "Landroidx/lifecycle/LiveData;", "", "getDocumentIdLiveData", "()Landroidx/lifecycle/LiveData;", "documentsListLivedata", "", "Lblackrussia/online/network/fraction/data/FractionsDocumentsItem;", "getDocumentsListLivedata", "mutableDocumentIdLiveData", "Landroidx/lifecycle/MutableLiveData;", "mutableDocumentsListLiveData", "mutableFractionIdLiveData", "mutableTestingLiveData", "Lblackrussia/online/network/fraction/data/FractionsTestingItem;", "mutableTestingResultLiveData", "Lcom/rockstargames/gtacr/data/FractionsTestingResult;", "repository", "Lblackrussia/online/network/fraction/FractionRepository;", "getRepository", "()Lblackrussia/online/network/fraction/FractionRepository;", "repository$delegate", "Lkotlin/Lazy;", "testingLiveData", "getTestingLiveData", "testingResultLiveData", "getTestingResultLiveData", "getDocumentsAndTestingLists", "", "sendAnswerChosen", "chosenAnswerIndex", "sendButtonAcquaintedPressed", "documentId", "documentNumber", "sendButtonPressed", "currentLayout", "typeKey", "setDisplayButtonAcquainted", "displayButtonAcquainted", "setFractionId", "fractionId", "setTestingList", "setTestingResult", "item", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsDocumentsViewModel extends ViewModel {
    private final ActionsWithJSON actionsWithJSON;
    private final LiveData<Integer> documentIdLiveData;
    private final LiveData<List<FractionsDocumentsItem>> documentsListLivedata;
    private final MutableLiveData<Integer> mutableDocumentIdLiveData;
    private final MutableLiveData<List<FractionsDocumentsItem>> mutableDocumentsListLiveData;
    private final MutableLiveData<Integer> mutableFractionIdLiveData;
    private final MutableLiveData<List<FractionsTestingItem>> mutableTestingLiveData;
    private MutableLiveData<FractionsTestingResult> mutableTestingResultLiveData;
    private final Lazy repository$delegate;
    private final LiveData<List<FractionsTestingItem>> testingLiveData;
    private final LiveData<FractionsTestingResult> testingResultLiveData;

    public FractionsDocumentsViewModel(ActionsWithJSON actionsWithJSON) {
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.actionsWithJSON = actionsWithJSON;
        this.repository$delegate = LazyKt.lazy(new Function0<FractionRepositoryImpl>() {
            @Override
            public final FractionRepositoryImpl invoke() {
                return new FractionRepositoryImpl();
            }
        });
        MutableLiveData<List<FractionsDocumentsItem>> mutableLiveData = new MutableLiveData<>();
        this.mutableDocumentsListLiveData = mutableLiveData;
        this.documentsListLivedata = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this.mutableDocumentIdLiveData = mutableLiveData2;
        this.documentIdLiveData = mutableLiveData2;
        MutableLiveData<List<FractionsTestingItem>> mutableLiveData3 = new MutableLiveData<>();
        this.mutableTestingLiveData = mutableLiveData3;
        this.testingLiveData = mutableLiveData3;
        MutableLiveData<FractionsTestingResult> mutableLiveData4 = new MutableLiveData<>();
        this.mutableTestingResultLiveData = mutableLiveData4;
        this.testingResultLiveData = mutableLiveData4;
        this.mutableFractionIdLiveData = new MutableLiveData<>();
    }

    private final FractionRepository getRepository() {
        return (FractionRepository) this.repository$delegate.getValue();
    }

    public final LiveData<List<FractionsDocumentsItem>> getDocumentsListLivedata() {
        return this.documentsListLivedata;
    }

    public final LiveData<Integer> getDocumentIdLiveData() {
        return this.documentIdLiveData;
    }

    public final LiveData<List<FractionsTestingItem>> getTestingLiveData() {
        return this.testingLiveData;
    }

    public final LiveData<FractionsTestingResult> getTestingResultLiveData() {
        return this.testingResultLiveData;
    }

    public final void setFractionId(int i) {
        this.mutableFractionIdLiveData.setValue(Integer.valueOf(i));
    }

    public final void sendButtonPressed(int i, int i2) {
        this.actionsWithJSON.sendButtonPressed(i, i2);
    }

    public final void sendButtonAcquaintedPressed(int i, int i2) {
        this.actionsWithJSON.sendButtonAcquaintedPressed(i, i2);
    }

    public final void sendAnswerChosen(int i) {
        this.actionsWithJSON.sendAnswerChosen(i + 1);
    }

    public final void setTestingList(int i) {
        Object obj;
        FractionsDocumentsItem fractionsDocumentsItem = null;
        boolean z;
        List<FractionsDocumentsItem> value = this.mutableDocumentsListLiveData.getValue();
        if (value == null) {
            fractionsDocumentsItem = null;
        } else {

        }
        this.mutableDocumentIdLiveData.setValue(Integer.valueOf(i));
        this.mutableTestingLiveData.setValue(fractionsDocumentsItem != null ? fractionsDocumentsItem.getTestingItemList() : null);
    }

    public final void setTestingResult(FractionsTestingResult fractionsTestingResult) {
        this.mutableTestingResultLiveData.setValue(fractionsTestingResult);
    }

    public final void getDocumentsAndTestingLists() {
        getRepository().getFractionDocuments().subscribeOn(Schedulers.io()).subscribe(new Consumer() {
            @Override
            public final void accept(Object obj) {
                FractionsDocumentsViewModel.m302getDocumentsAndTestingLists$lambda3(FractionsDocumentsViewModel.this, (FractionsDocumentsObjList) obj);
            }
        }, new Consumer() {
            @Override
            public final void accept(Object obj) {
                FractionsDocumentsViewModel.m303getDocumentsAndTestingLists$lambda4((Throwable) obj);
            }
        });
    }

    public static final void m302getDocumentsAndTestingLists$lambda3(FractionsDocumentsViewModel this$0, FractionsDocumentsObjList fractionsDocumentsObjList) {
        Object obj;
        Object obj2 = null;
        boolean z;
        Intrinsics.checkNotNullParameter(this$0, "this$0");

        FractionsDocumentsObj fractionsDocumentsObj = (FractionsDocumentsObj) obj2;
        List<FractionsDocumentsItem> fractionDocuments = fractionsDocumentsObj == null ? null : fractionsDocumentsObj.getFractionDocuments();
        if (fractionDocuments != null) {
            if (this$0.mutableDocumentsListLiveData.getValue() != null) {
                List<FractionsDocumentsItem> value2 = this$0.mutableDocumentsListLiveData.getValue();
                Intrinsics.checkNotNull(value2);
                Intrinsics.checkNotNullExpressionValue(value2, "mutableDocumentsListLiveData.value!!");
            } else {
                fractionDocuments.get(0).setClicked(true);
            }
            this$0.mutableDocumentsListLiveData.postValue(fractionDocuments);
        }
    }

    public static final void m303getDocumentsAndTestingLists$lambda4(Throwable th) {
        Log.d(Const.LOG_FRACTION_S, Intrinsics.stringPlus("getDocumentsList ERROR  ", th));
    }

    public final void setDisplayButtonAcquainted(List<Integer> displayButtonAcquainted) {
        Intrinsics.checkNotNullParameter(displayButtonAcquainted, "displayButtonAcquainted");
        if (this.mutableDocumentsListLiveData.getValue() != null) {
            List<FractionsDocumentsItem> value = this.mutableDocumentsListLiveData.getValue();
            Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.collections.MutableList<blackrussia.online.network.fraction.data.FractionsDocumentsItem>");
            List<FractionsDocumentsItem> asMutableList = TypeIntrinsics.asMutableList(value);
            int size = asMutableList.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                if (i < displayButtonAcquainted.size()) {
                    FractionsDocumentsItem fractionsDocumentsItem = asMutableList.get(i);
                    Integer num = displayButtonAcquainted.get(i);
                    fractionsDocumentsItem.setDocumentStatus((num == null ? 0 : num.intValue()) != 0);
                }
                i = i2;
            }
            this.mutableDocumentsListLiveData.setValue(asMutableList);
        }
    }
}
