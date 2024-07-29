package blackrussia.online.network.fraction;

import blackrussia.online.network.DataService;
import blackrussia.online.network.fraction.data.FractionQuestsObj;
import blackrussia.online.network.fraction.data.FractionsDocumentsObjList;
import com.rockstargames.gtacr.data.FractionsShopList;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¨\u0006\n"}, d2 = {"Lblackrussia/online/network/fraction/FractionDataSource;", "", "()V", "getFractionDocuments", "Lio/reactivex/rxjava3/core/Single;", "Lblackrussia/online/network/fraction/data/FractionsDocumentsObjList;", "getFractionQuestsObj", "Lblackrussia/online/network/fraction/data/FractionQuestsObj;", "getFractionShopList", "Lcom/rockstargames/gtacr/data/FractionsShopList;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionDataSource {
    public final Single<FractionsDocumentsObjList> getFractionDocuments() {
        Single<FractionsDocumentsObjList> fractionDocumentsList = DataService.getInstance().getApiService().getFractionDocumentsList();
        Intrinsics.checkNotNullExpressionValue(fractionDocumentsList, "getInstance().apiService.fractionDocumentsList");
        return fractionDocumentsList;
    }

    public final Single<FractionsShopList> getFractionShopList() {
        Single<FractionsShopList> fractionShopList = DataService.getInstance().getApiService().getFractionShopList();
        Intrinsics.checkNotNullExpressionValue(fractionShopList, "getInstance().apiService.fractionShopList");
        return fractionShopList;
    }

    public final Single<FractionQuestsObj> getFractionQuestsObj() {
        Single<FractionQuestsObj> fractionQuestsObj = DataService.getInstance().getApiService().getFractionQuestsObj();
        Intrinsics.checkNotNullExpressionValue(fractionQuestsObj, "getInstance().apiService.fractionQuestsObj");
        return fractionQuestsObj;
    }
}
