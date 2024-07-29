package com.rockstargames.gtacr.gui.spawnLocation.network;

import blackrussia.online.network.DataService;
import com.rockstargames.gtacr.gui.spawnLocation.data.SpawnLocationList;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationDataSource;", "", "()V", "getSpawnLocationList", "Lio/reactivex/rxjava3/core/Single;", "Lcom/rockstargames/gtacr/gui/spawnLocation/data/SpawnLocationList;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpawnLocationDataSource {
    public final Single<SpawnLocationList> getSpawnLocationList() {
        Single<SpawnLocationList> spawnLocationList = DataService.getInstance().getApiService().getSpawnLocationList();
        Intrinsics.checkNotNullExpressionValue(spawnLocationList, "getInstance().apiService.spawnLocationList");
        return spawnLocationList;
    }
}
