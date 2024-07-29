package com.rockstargames.gtacr.gui.spawnLocation.network;

import com.rockstargames.gtacr.gui.spawnLocation.data.SpawnLocationList;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;

//@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationRepository;", "", "getListOfSpawnLocationItems", "Lio/reactivex/rxjava3/core/Single;", "Lcom/rockstargames/gtacr/gui/spawnLocation/data/SpawnLocationList;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SpawnLocationRepository {
    Single<SpawnLocationList> getListOfSpawnLocationItems();
}
