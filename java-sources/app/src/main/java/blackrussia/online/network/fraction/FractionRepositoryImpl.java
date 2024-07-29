package blackrussia.online.network.fraction;

import blackrussia.online.network.fraction.data.FractionQuestsObj;
import blackrussia.online.network.fraction.data.FractionsDocumentsObjList;
import com.rockstargames.gtacr.data.FractionsShopList;
import io.reactivex.rxjava3.core.Single;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

//@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lblackrussia/online/network/fraction/FractionRepositoryImpl;", "Lblackrussia/online/network/fraction/FractionRepository;", "()V", "fractionDataSource", "Lblackrussia/online/network/fraction/FractionDataSource;", "getFractionDataSource", "()Lblackrussia/online/network/fraction/FractionDataSource;", "fractionDataSource$delegate", "Lkotlin/Lazy;", "getFractionDocuments", "Lio/reactivex/rxjava3/core/Single;", "Lblackrussia/online/network/fraction/data/FractionsDocumentsObjList;", "getFractionShopItems", "Lcom/rockstargames/gtacr/data/FractionsShopList;", "getQuestsObj", "Lblackrussia/online/network/fraction/data/FractionQuestsObj;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionRepositoryImpl implements FractionRepository {
    private final Lazy fractionDataSource$delegate = LazyKt.lazy(new Function0<FractionDataSource>() {
        @Override
        public final FractionDataSource invoke() {
            return new FractionDataSource();
        }
    });

    private final FractionDataSource getFractionDataSource() {
        return (FractionDataSource) this.fractionDataSource$delegate.getValue();
    }

    @Override
    public Single<FractionsDocumentsObjList> getFractionDocuments() {
        return getFractionDataSource().getFractionDocuments();
    }

    @Override
    public Single<FractionsShopList> getFractionShopItems() {
        return getFractionDataSource().getFractionShopList();
    }

    @Override
    public Single<FractionQuestsObj> getQuestsObj() {
        return getFractionDataSource().getFractionQuestsObj();
    }
}
