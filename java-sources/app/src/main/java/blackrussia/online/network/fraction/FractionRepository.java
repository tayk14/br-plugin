package blackrussia.online.network.fraction;

import blackrussia.online.network.fraction.data.FractionQuestsObj;
import blackrussia.online.network.fraction.data.FractionsDocumentsObjList;
import com.rockstargames.gtacr.data.FractionsShopList;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H&¨\u0006\t"}, d2 = {"Lblackrussia/online/network/fraction/FractionRepository;", "", "getFractionDocuments", "Lio/reactivex/rxjava3/core/Single;", "Lblackrussia/online/network/fraction/data/FractionsDocumentsObjList;", "getFractionShopItems", "Lcom/rockstargames/gtacr/data/FractionsShopList;", "getQuestsObj", "Lblackrussia/online/network/fraction/data/FractionQuestsObj;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FractionRepository {
    Single<FractionsDocumentsObjList> getFractionDocuments();

    Single<FractionsShopList> getFractionShopItems();

    Single<FractionQuestsObj> getQuestsObj();
}
