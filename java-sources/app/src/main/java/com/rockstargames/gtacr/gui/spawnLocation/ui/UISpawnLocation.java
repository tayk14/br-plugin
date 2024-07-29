package com.rockstargames.gtacr.gui.spawnLocation.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import blackrussia.online.R;
import blackrussia.online.databinding.SpawnLocationLayoutBinding;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.fractions.FractionsUtilsKt;
import com.rockstargames.gtacr.gui.spawnLocation.adapters.SpawnLocationAdapter;
import com.rockstargames.gtacr.gui.spawnLocation.data.SpawnLocationItem;
import com.rockstargames.gtacr.gui.spawnLocation.data.SpawnLocationList;
import com.rockstargames.gtacr.gui.spawnLocation.viewModels.SpawnLocationViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0010H\u0002J$\u0010!\u001a\u00020\u001b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/rockstargames/gtacr/gui/spawnLocation/ui/UISpawnLocation;", "Lcom/rockstargames/gtacr/common/UILayout;", "spawnLocationViewModel", "Lcom/rockstargames/gtacr/gui/spawnLocation/viewModels/SpawnLocationViewModel;", "popupWindow", "Landroid/widget/PopupWindow;", "(Lcom/rockstargames/gtacr/gui/spawnLocation/viewModels/SpawnLocationViewModel;Landroid/widget/PopupWindow;)V", "_binding", "Lblackrussia/online/databinding/SpawnLocationLayoutBinding;", "binding", "getBinding", "()Lblackrussia/online/databinding/SpawnLocationLayoutBinding;", "spawnAdapter", "Lcom/rockstargames/gtacr/gui/spawnLocation/adapters/SpawnLocationAdapter;", "getListOfImagesFunction", "", "", "listOfItems", "Lcom/rockstargames/gtacr/gui/spawnLocation/data/SpawnLocationItem;", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "", "onLayoutShown", "removeObservers", "setObservers", "setOnButtonEnterClickListener", "itemId", "setSpawnAdapter", "", "listOfAvailability", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UISpawnLocation extends UILayout {
    private SpawnLocationLayoutBinding _binding;
    private final PopupWindow popupWindow;
    private SpawnLocationAdapter spawnAdapter;
    private final SpawnLocationViewModel spawnLocationViewModel;

    public UISpawnLocation(SpawnLocationViewModel spawnLocationViewModel, PopupWindow popupWindow) {
        Intrinsics.checkNotNullParameter(spawnLocationViewModel, "spawnLocationViewModel");
        Intrinsics.checkNotNullParameter(popupWindow, "popupWindow");
        this.spawnLocationViewModel = spawnLocationViewModel;
        this.popupWindow = popupWindow;
    }

    private final SpawnLocationLayoutBinding getBinding() {
        SpawnLocationLayoutBinding spawnLocationLayoutBinding = this._binding;
        Intrinsics.checkNotNull(spawnLocationLayoutBinding);
        return spawnLocationLayoutBinding;
    }

    @Override
    public View getView() {
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = SpawnLocationLayoutBinding.inflate(inflater);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setSpawnAdapter(List<SpawnLocationItem> list, List<Integer> list2) {
        SpawnLocationAdapter spawnLocationAdapter = new SpawnLocationAdapter(list, getListOfImagesFunction(list), list2);
        this.spawnAdapter = spawnLocationAdapter;
        if (spawnLocationAdapter != null) {
            spawnLocationAdapter.setOnItemClickListener(new Function1<Integer, Unit>() {

                @Override
                public Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    UISpawnLocation.this.setOnButtonEnterClickListener(i);
                }
            });
        }
        getBinding().recyclerViewSpawnLocation.setAdapter(this.spawnAdapter);
    }

    private final void setObservers() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.spawnLocationViewModel.getMediatorMutableLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UISpawnLocation.m409setObservers$lambda3$lambda1(UISpawnLocation.this, (SpawnLocationList) obj);
            }
        });
        this.spawnLocationViewModel.getErrorLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UISpawnLocation.m410setObservers$lambda3$lambda2(UISpawnLocation.this, (String) obj);
            }
        });
    }

    public static final void m409setObservers$lambda3$lambda1(UISpawnLocation this$0, SpawnLocationList spawnLocationList) {
        Object obj = null;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((!spawnLocationList.getSpawnLocationList().isEmpty()) && (!spawnLocationList.getListOfAvailability().isEmpty())) {
            this$0.setSpawnAdapter(spawnLocationList.getSpawnLocationList(), spawnLocationList.getListOfAvailability());
            SpawnLocationItem spawnLocationItem = (SpawnLocationItem) obj;
            if (spawnLocationItem != null) {
                this$0.setOnButtonEnterClickListener(spawnLocationItem.getId());
            }
            this$0.popupWindow.showAtLocation(this$0.getBinding().getRoot(), 17, 0, 0);
        }
    }

    public static final void m410setObservers$lambda3$lambda2(UISpawnLocation this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.getContext(), Intrinsics.stringPlus("Ошибка получения данных. Возможно отсутствует интернет. ", str), 1).show();
    }

    private final void removeObservers() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.spawnLocationViewModel.getMediatorMutableLiveData().removeObservers(lifecycleOwner);
        this.spawnLocationViewModel.getErrorLiveData().removeObservers(lifecycleOwner);
    }

    public final void setOnButtonEnterClickListener(final int i) {
        getBinding().buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UISpawnLocation.m411setOnButtonEnterClickListener$lambda6(UISpawnLocation.this, i, view);
            }
        });
    }

    public static final void m411setOnButtonEnterClickListener$lambda6(final UISpawnLocation this$0, final int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.startAnimation(AnimationUtils.loadAnimation(this$0.getContext(), R.anim.button_click));
        new Handler(this$0.getContext().getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                UISpawnLocation.m412setOnButtonEnterClickListener$lambda6$lambda5(i, this$0);
            }
        }, 200L);
    }

    public static final void m412setOnButtonEnterClickListener$lambda6$lambda5(int i, UISpawnLocation this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i > -1) {
            this$0.spawnLocationViewModel.sendChosenPlace(i);
        } else {
            Toast.makeText(this$0.getContext(), "Выберите место появления", 0).show();
        }
    }

    private final List<Integer> getListOfImagesFunction(List<SpawnLocationItem> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                String stringPlus = Intrinsics.stringPlus("@drawable/spawn_location_res_", Integer.valueOf(i));
                Resources resources = getContext().getResources();
                if (resources != null) {
                    arrayList.add(Integer.valueOf(resources.getIdentifier(stringPlus, "drawable", getContext().getPackageName())));
                }
                if (i == size) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    @Override
    public void onLayoutShown() {
        GUIManager.hideSystemUI(getBinding().getRoot());
        setObservers();
    }

    @Override
    public void onLayoutClose() {
        removeObservers();
    }
}
