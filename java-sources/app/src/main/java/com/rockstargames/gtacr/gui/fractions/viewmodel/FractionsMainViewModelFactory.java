package com.rockstargames.gtacr.gui.fractions.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.rockstargames.gtacr.gui.fractions.ActionsWithJSON;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsMainViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;", "(Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;)V", "getActionsWithJSON", "()Lcom/rockstargames/gtacr/gui/fractions/ActionsWithJSON;", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FractionsMainViewModelFactory implements ViewModelProvider.Factory {
    private final ActionsWithJSON actionsWithJSON;

    public FractionsMainViewModelFactory(ActionsWithJSON actionsWithJSON) {
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.actionsWithJSON = actionsWithJSON;
    }

    public final ActionsWithJSON getActionsWithJSON() {
        return this.actionsWithJSON;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return (T) new FractionsMainViewModel(this.actionsWithJSON);
    }
}
