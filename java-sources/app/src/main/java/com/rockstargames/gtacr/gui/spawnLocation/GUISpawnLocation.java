package com.rockstargames.gtacr.gui.spawnLocation;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import blackrussia.online.R;
import blackrussia.online.databinding.SpawnLocationMainContainerBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.common.UIContainer;
import com.rockstargames.gtacr.gui.fractions.FractionsUtilsKt;
import com.rockstargames.gtacr.gui.spawnLocation.network.SpawnLocationActionsWithJson;
import com.rockstargames.gtacr.gui.spawnLocation.network.SpawnLocationRepository;
import com.rockstargames.gtacr.gui.spawnLocation.network.SpawnLocationRepositoryImpl;
import com.rockstargames.gtacr.gui.spawnLocation.ui.UISpawnLocation;
import com.rockstargames.gtacr.gui.spawnLocation.viewModels.SpawnLocationViewModel;
import com.rockstargames.gtacr.gui.spawnLocation.viewModels.SpawnLocationViewModelFactory;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0012\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010&\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J&\u0010'\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/rockstargames/gtacr/gui/spawnLocation/GUISpawnLocation;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "()V", "_binding", "Lblackrussia/online/databinding/SpawnLocationMainContainerBinding;", "activity", "Lcom/nvidia/devtech/NvEventQueueActivity;", "binding", "getBinding", "()Lblackrussia/online/databinding/SpawnLocationMainContainerBinding;", "container", "Lcom/rockstargames/gtacr/common/UIContainer;", "popupWindow", "Landroid/widget/PopupWindow;", "spawnLocationLayout", "Lcom/rockstargames/gtacr/gui/spawnLocation/ui/UISpawnLocation;", "spawnLocationRepository", "Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationRepository;", "getSpawnLocationRepository", "()Lcom/rockstargames/gtacr/gui/spawnLocation/network/SpawnLocationRepository;", "spawnLocationRepository$delegate", "Lkotlin/Lazy;", "spawnLocationViewModel", "Lcom/rockstargames/gtacr/gui/spawnLocation/viewModels/SpawnLocationViewModel;", "close", "", "json", "Lorg/json/JSONObject;", "getGuiId", "", "initContainer", "initPopupWindow", "initViewModel", "manager", "Lcom/rockstargames/gtacr/GUIManager;", "isShowingGui", "", "onPacketIncoming", "setDataFromJson", "show", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GUISpawnLocation implements ISAMPGUI {
    public static final Companion Companion = new Companion(null);
    private SpawnLocationMainContainerBinding _binding;
    private NvEventQueueActivity activity;
    private UIContainer container;
    private PopupWindow popupWindow;
    private UISpawnLocation spawnLocationLayout;
    private final Lazy spawnLocationRepository$delegate = LazyKt.lazy(new Function0<SpawnLocationRepositoryImpl>() {
        @Override
        public final SpawnLocationRepositoryImpl invoke() {
            return new SpawnLocationRepositoryImpl();
        }
    });
    private SpawnLocationViewModel spawnLocationViewModel;

    @JvmStatic
    public static final GUISpawnLocation newInstance() {
        return Companion.newInstance();
    }

    @Override
    public int getGuiId() {
        return 50;
    }

    private final SpawnLocationMainContainerBinding getBinding() {
        SpawnLocationMainContainerBinding spawnLocationMainContainerBinding = this._binding;
        Intrinsics.checkNotNull(spawnLocationMainContainerBinding);
        return spawnLocationMainContainerBinding;
    }

    private final SpawnLocationRepository getSpawnLocationRepository() {
        return (SpawnLocationRepository) this.spawnLocationRepository$delegate.getValue();
    }

    //@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/spawnLocation/GUISpawnLocation$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/spawnLocation/GUISpawnLocation;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GUISpawnLocation newInstance() {
            return new GUISpawnLocation();
        }
    }

    @Override
    public void onPacketIncoming(JSONObject jSONObject) {
        setDataFromJson(jSONObject);
    }

    @Override
    public void show(JSONObject jSONObject, GUIManager gUIManager, NvEventQueueActivity nvEventQueueActivity) {
        this.activity = nvEventQueueActivity;
        if (this.popupWindow == null) {
            initPopupWindow();
        }
        initViewModel(gUIManager);
        initContainer();
        setDataFromJson(jSONObject);
    }

    private final void setDataFromJson(JSONObject jSONObject) {
        PopupWindow popupWindow;
        SpawnLocationViewModel spawnLocationViewModel;
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("m");
        List<Integer> mutableIntList = optJSONArray == null ? null : FractionsUtilsKt.toMutableIntList(optJSONArray);
        if (mutableIntList != null && (spawnLocationViewModel = this.spawnLocationViewModel) != null) {
            spawnLocationViewModel.setListOfAvailability(mutableIntList);
        }
        int optInt = jSONObject.optInt("s");
        if (optInt == 1) {
            Toast.makeText(this.activity, (int) R.string.spawn_location_error, 0).show();
        } else if (optInt == 2 && (popupWindow = this.popupWindow) != null) {
            popupWindow.dismiss();
        }
    }

    private final void initViewModel(GUIManager gUIManager) {
        NvEventQueueActivity nvEventQueueActivity = this.activity;
        if (nvEventQueueActivity != null) {
            this.spawnLocationViewModel = (SpawnLocationViewModel) new ViewModelProvider(nvEventQueueActivity, new SpawnLocationViewModelFactory(new SpawnLocationActionsWithJson(gUIManager), getSpawnLocationRepository())).get(SpawnLocationViewModel.class);
        }
        SpawnLocationViewModel spawnLocationViewModel = this.spawnLocationViewModel;
        if (spawnLocationViewModel == null) {
            return;
        }
        spawnLocationViewModel.getListOfItems();
    }

    private final void initContainer() {
        PopupWindow popupWindow;
        this.container = getBinding().mainContainer;
        SpawnLocationViewModel spawnLocationViewModel = this.spawnLocationViewModel;
        UISpawnLocation uISpawnLocation = null;
        if (spawnLocationViewModel != null && (popupWindow = this.popupWindow) != null) {
            uISpawnLocation = new UISpawnLocation(spawnLocationViewModel, popupWindow);
        }
        this.spawnLocationLayout = uISpawnLocation;
        UIContainer uIContainer = this.container;
        if (uIContainer != null) {
            uIContainer.addLayout(0, uISpawnLocation);
        }
        UIContainer uIContainer2 = this.container;
        if (uIContainer2 == null) {
            return;
        }
        uIContainer2.setCurrentLayout(0);
    }

    private final void initPopupWindow() {
        NvEventQueueActivity nvEventQueueActivity = this.activity;
        Object systemService = nvEventQueueActivity == null ? null : nvEventQueueActivity.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this._binding = SpawnLocationMainContainerBinding.inflate((LayoutInflater) systemService);
        PopupWindow popupWindow = new PopupWindow((View) getBinding().getRoot(), -1, -1, true);
        this.popupWindow = popupWindow;
        if (popupWindow != null) {
            popupWindow.setClippingEnabled(false);
        }
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public final void onDismiss() {
                    GUISpawnLocation.m404initPopupWindow$lambda4(GUISpawnLocation.this);
                }
            });
        }
        PopupWindow popupWindow3 = this.popupWindow;
        if (popupWindow3 != null) {
            popupWindow3.setFocusable(false);
        }
        PopupWindow popupWindow4 = this.popupWindow;
        if (popupWindow4 == null) {
            return;
        }
        popupWindow4.setSoftInputMode(48);
    }

    public static final void m404initPopupWindow$lambda4(GUISpawnLocation this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SpawnLocationMainContainerBinding spawnLocationMainContainerBinding = this$0._binding;
        GUIManager.hideSystemUI(spawnLocationMainContainerBinding == null ? null : spawnLocationMainContainerBinding.getRoot());
    }

    @Override
    public void close(JSONObject jSONObject) {
        ViewModelStore viewModelStore;
        GUIManager.hideSystemUI(getBinding().getRoot());
        NvEventQueueActivity nvEventQueueActivity = this.activity;
        if (nvEventQueueActivity != null && (viewModelStore = nvEventQueueActivity.getViewModelStore()) != null) {
            viewModelStore.clear();
        }
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.popupWindow = null;
    }

    @Override
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return false;
        }
        Intrinsics.checkNotNull(popupWindow);
        return popupWindow.isShowing();
    }
}
