package com.rockstargames.gtacr.gui.spawnLocation.viewModels;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.rockstargames.gtacr.gui.spawnLocation.network.SpawnLocationActionsWithJson;
import com.rockstargames.gtacr.gui.spawnLocation.network.SpawnLocationRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/rockstargames/gtacr/gui/spawnLocation/viewModels/SpawnLocationViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "spawnLocationActionsWithJson", "Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationActionsWithJson;", "spawnLocationRepository", "Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationRepository;", "(Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationActionsWithJson;Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationRepository;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpawnLocationViewModelFactory implements ViewModelProvider.Factory {
    private final SpawnLocationActionsWithJson spawnLocationActionsWithJson;
    private final SpawnLocationRepository spawnLocationRepository;

    public SpawnLocationViewModelFactory(SpawnLocationActionsWithJson spawnLocationActionsWithJson, SpawnLocationRepository spawnLocationRepository) {
        Intrinsics.checkNotNullParameter(spawnLocationActionsWithJson, "spawnLocationActionsWithJson");
        Intrinsics.checkNotNullParameter(spawnLocationRepository, "spawnLocationRepository");
        this.spawnLocationActionsWithJson = spawnLocationActionsWithJson;
        this.spawnLocationRepository = spawnLocationRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return (T) new SpawnLocationViewModel(this.spawnLocationActionsWithJson, this.spawnLocationRepository);
    }
}
