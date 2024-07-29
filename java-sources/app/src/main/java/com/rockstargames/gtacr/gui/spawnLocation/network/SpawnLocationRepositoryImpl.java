package com.rockstargames.gtacr.gui.spawnLocation.network;

import com.rockstargames.gtacr.gui.spawnLocation.data.SpawnLocationList;
import io.reactivex.rxjava3.core.Single;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

//@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationRepositoryImpl;", "Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationRepository;", "()V", "spawnLocationDataSource", "Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationDataSource;", "getSpawnLocationDataSource", "()Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationDataSource;", "spawnLocationDataSource$delegate", "Lkotlin/Lazy;", "getListOfSpawnLocationItems", "Lio/reactivex/rxjava3/core/Single;", "Lcom/rockstargames/gtacr/gui/spawnLocation/data/SpawnLocationList;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpawnLocationRepositoryImpl implements SpawnLocationRepository {
    private final Lazy spawnLocationDataSource$delegate = LazyKt.lazy(new Function0<SpawnLocationDataSource>() {
        @Override
        public final SpawnLocationDataSource invoke() {
            return new SpawnLocationDataSource();
        }
    });

    private final SpawnLocationDataSource getSpawnLocationDataSource() {
        return (SpawnLocationDataSource) this.spawnLocationDataSource$delegate.getValue();
    }

    @Override
    public Single<SpawnLocationList> getListOfSpawnLocationItems() {
        return getSpawnLocationDataSource().getSpawnLocationList();
    }
}
