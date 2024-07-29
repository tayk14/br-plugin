package com.rockstargames.gtacr.gui.entertainmentSystem;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.EntertainmentSystemTopLayoutBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.EntertainmentSystemGamesFilterAdapter;
import com.rockstargames.gtacr.adapters.EntertainmentSystemPlayersTopAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.EntertainmentGamesFilter;
import com.rockstargames.gtacr.data.EntertainmentPlayersData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0018H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J(\u0010-\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u0016H\u0002J\b\u00102\u001a\u00020\u0018H\u0002J\u000e\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0016J\b\u00105\u001a\u00020\u0018H\u0002J\u0010\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u0016H\u0003J\b\u00108\u001a\u00020\u0018H\u0002J\b\u00109\u001a\u00020\u0018H\u0002J\u0010\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u0016H\u0002J\u0010\u0010<\u001a\u00020\u00182\u0006\u0010=\u001a\u00020\u001eH\u0002J\u0010\u0010>\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u0016H\u0002J\u0010\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u001eH\u0002J\u000e\u0010A\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0016J\u0018\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u00162\u0006\u00100\u001a\u00020/H\u0002J\u0016\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0011j\u0002`\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/rockstargames/gtacr/gui/entertainmentSystem/UIPlayersTop;", "Lcom/rockstargames/gtacr/common/UILayout;", "mainRoot", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/GUIEntertainmentSystem;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Lcom/rockstargames/gtacr/gui/entertainmentSystem/GUIEntertainmentSystem;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/EntertainmentSystemTopLayoutBinding;", "currentPlayer", "", "Lcom/rockstargames/gtacr/data/EntertainmentPlayersData;", "currentPlayerTopAdapter", "Lcom/rockstargames/gtacr/adapters/EntertainmentSystemPlayersTopAdapter;", "entertainmentFilterClickListener", "Lkotlin/Function2;", "Lcom/rockstargames/gtacr/data/EntertainmentGamesFilter;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "game", "", "position", "", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/EntertainmentFilterClickListener;", "gamesFilterAdapter", "Lcom/rockstargames/gtacr/adapters/EntertainmentSystemGamesFilterAdapter;", "gamesList", "isAllTopUpdate", "", "isCurrentUpdate", "isVisibleFilter", "playersTopAdapter", "topPlayers", "addGamesForFilter", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "setCurrentPlayer", "playersNick", "", "thisGame", "allGames", "setCurrentPlayerTop", "setInitialParameters", "currentGamesId", "setItemsInFilterList", "setListInView", "currentList", "setLogicForClickFilter", "setPlayersTopList", "setVisibleFirstPosition", "valueOfVisible", "setVisibleForFilter", "ifNowVisible", "setVisibleOtherPosition", "setVisibleTopBlock", "isFirstThreePositions", "updateCurrentInfo", "updateMainStatus", "thisPosition", "updateTopInfo", "thisCollection", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIPlayersTop extends UILayout {
    private Animation anim;
    private EntertainmentSystemTopLayoutBinding binding;
    private final NvEventQueueActivity context;
    private final List<EntertainmentPlayersData> currentPlayer;
    private EntertainmentSystemPlayersTopAdapter currentPlayerTopAdapter;
    private Function2<? super EntertainmentGamesFilter, ? super Integer, Unit> entertainmentFilterClickListener;
    private EntertainmentSystemGamesFilterAdapter gamesFilterAdapter;
    private final List<EntertainmentGamesFilter> gamesList;
    private boolean isAllTopUpdate;
    private boolean isCurrentUpdate;
    private boolean isVisibleFilter;
    private final GUIEntertainmentSystem mainRoot;
    private EntertainmentSystemPlayersTopAdapter playersTopAdapter;
    private final List<EntertainmentPlayersData> topPlayers;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIPlayersTop(GUIEntertainmentSystem mainRoot, NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainRoot = mainRoot;
        this.context = context;
        this.topPlayers = new ArrayList();
        this.currentPlayer = new ArrayList();
        this.gamesList = new ArrayList();
    }

    @Override
    public View getView() {
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding = this.binding;
        if (entertainmentSystemTopLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemTopLayoutBinding = null;
        }
        ConstraintLayout root = entertainmentSystemTopLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void setInitialParameters(int i) {
        if (this.mainRoot.getArrWithCurrentTopPositions().size() > i && this.mainRoot.getArrWithCurrentTopGames().size() > i) {
            setCurrentPlayer(this.mainRoot.getArrWithCurrentTopPositions().get(i).intValue(), this.mainRoot.getCurrentNick(), i, this.mainRoot.getArrWithCurrentTopGames().get(i).intValue());
            this.isCurrentUpdate = true;
        } else {
            setCurrentPlayer(999, this.mainRoot.getCurrentNick(), i, 0);
            this.isCurrentUpdate = false;
        }
        setCurrentPlayerTop();
        if (this.currentPlayer.size() <= 0 || this.gamesList.size() <= i) {
            return;
        }
        updateMainStatus(this.currentPlayer.get(0).getPosition(), this.gamesList.get(0).getName());
        EntertainmentSystemPlayersTopAdapter entertainmentSystemPlayersTopAdapter = this.currentPlayerTopAdapter;
        if (entertainmentSystemPlayersTopAdapter != null) {
            entertainmentSystemPlayersTopAdapter.notifyItemChanged(0);
        }
        setListInView(i);
        setVisibleForFilter(true);
    }

    public final void updateCurrentInfo(int i) {
        if (this.isCurrentUpdate || this.mainRoot.getArrWithCurrentTopPositions().size() <= i || this.mainRoot.getArrWithCurrentTopGames().size() <= i) {
            return;
        }
        this.isCurrentUpdate = true;
        setCurrentPlayer(this.mainRoot.getArrWithCurrentTopPositions().get(i).intValue(), this.mainRoot.getCurrentNick(), i, this.mainRoot.getArrWithCurrentTopGames().get(i).intValue());
        if (this.currentPlayer.size() > 0 && this.gamesList.size() > i) {
            updateMainStatus(this.currentPlayer.get(0).getPosition(), this.gamesList.get(i).getName());
        }
        EntertainmentSystemPlayersTopAdapter entertainmentSystemPlayersTopAdapter = this.currentPlayerTopAdapter;
        if (entertainmentSystemPlayersTopAdapter == null) {
            return;
        }
        entertainmentSystemPlayersTopAdapter.notifyDataSetChanged();
    }

    public final void updateTopInfo(int i, int i2) {
        if (i != i2 || this.gamesList.size() <= i2) {
            return;
        }
        setListInView(i2);
        this.gamesList.get(i2).setClicked(true);
        EntertainmentSystemGamesFilterAdapter entertainmentSystemGamesFilterAdapter = this.gamesFilterAdapter;
        if (entertainmentSystemGamesFilterAdapter == null) {
            return;
        }
        entertainmentSystemGamesFilterAdapter.notifyItemChanged(i2);
        entertainmentSystemGamesFilterAdapter.setCheckOnlyElement(i2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        EntertainmentSystemTopLayoutBinding inflate = EntertainmentSystemTopLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        setPlayersTopList();
        addGamesForFilter();
        setLogicForClickFilter();
        setItemsInFilterList();
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding2 = this.binding;
        if (entertainmentSystemTopLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemTopLayoutBinding2 = null;
        }
        entertainmentSystemTopLayoutBinding2.title3.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIPlayersTop.m159onCreateView$lambda2$lambda1(UIPlayersTop.this, view);
            }
        });
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding3 = this.binding;
        if (entertainmentSystemTopLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            entertainmentSystemTopLayoutBinding = entertainmentSystemTopLayoutBinding3;
        }
        ConstraintLayout root = entertainmentSystemTopLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public static final void m159onCreateView$lambda2$lambda1(UIPlayersTop this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVisibleForFilter(this$0.isVisibleFilter);
    }

    private final void setPlayersTopList() {
        EntertainmentSystemPlayersTopAdapter entertainmentSystemPlayersTopAdapter = new EntertainmentSystemPlayersTopAdapter(this.topPlayers, this.context);
        this.playersTopAdapter = entertainmentSystemPlayersTopAdapter;
        if (entertainmentSystemPlayersTopAdapter != null) {
            entertainmentSystemPlayersTopAdapter.setHasStableIds(true);
        }
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding = this.binding;
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding2 = null;
        if (entertainmentSystemTopLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemTopLayoutBinding = null;
        }
        RecyclerView recyclerView = entertainmentSystemTopLayoutBinding.playersTop;
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding3 = this.binding;
        if (entertainmentSystemTopLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            entertainmentSystemTopLayoutBinding2 = entertainmentSystemTopLayoutBinding3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(entertainmentSystemTopLayoutBinding2.getRoot().getContext(), 1, false));
        recyclerView.setAdapter(this.playersTopAdapter);
        recyclerView.setItemViewCacheSize(20);
    }

    public final void setCurrentPlayer(int i, String str, int i2, int i3) {
        List<EntertainmentPlayersData> list = this.currentPlayer;
        list.clear();
        list.add(new EntertainmentPlayersData(i, str, i2, i3 == 0 ? "-" : String.valueOf(i3), 0, 0));
    }

    private final void setCurrentPlayerTop() {
        this.currentPlayerTopAdapter = new EntertainmentSystemPlayersTopAdapter(this.currentPlayer, this.context);
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding = this.binding;
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding2 = null;
        if (entertainmentSystemTopLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemTopLayoutBinding = null;
        }
        RecyclerView recyclerView = entertainmentSystemTopLayoutBinding.currentPlayer;
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding3 = this.binding;
        if (entertainmentSystemTopLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            entertainmentSystemTopLayoutBinding2 = entertainmentSystemTopLayoutBinding3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(entertainmentSystemTopLayoutBinding2.getRoot().getContext(), 1, false));
        recyclerView.setAdapter(this.currentPlayerTopAdapter);
    }

    public final void setVisibleForFilter(boolean z) {
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding = this.binding;
        if (entertainmentSystemTopLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemTopLayoutBinding = null;
        }
        if (!z) {
            this.isVisibleFilter = true;
            entertainmentSystemTopLayoutBinding.listWithGamesFilter.setVisibility(0);
            entertainmentSystemTopLayoutBinding.arrowSubmenu.setImageResource(R.drawable.entertainment_system_arrow_up);
            if (Build.VERSION.SDK_INT >= 23) {
                entertainmentSystemTopLayoutBinding.title3.setBackgroundColor(this.context.getResources().getColor(R.color.color_9F280F, null));
                return;
            } else {
                entertainmentSystemTopLayoutBinding.title3.setBackgroundColor(this.context.getResources().getColor(R.color.color_9F280F));
                return;
            }
        }
        this.isVisibleFilter = false;
        entertainmentSystemTopLayoutBinding.listWithGamesFilter.setVisibility(4);
        entertainmentSystemTopLayoutBinding.arrowSubmenu.setImageResource(R.drawable.entertainment_system_arrow_down);
        if (Build.VERSION.SDK_INT >= 23) {
            entertainmentSystemTopLayoutBinding.title3.setBackgroundColor(this.context.getResources().getColor(R.color.inv_full_transparency, null));
        } else {
            entertainmentSystemTopLayoutBinding.title3.setBackgroundColor(this.context.getResources().getColor(R.color.inv_full_transparency));
        }
    }

    private final void addGamesForFilter() {
        List<EntertainmentGamesFilter> list = this.gamesList;
        list.add(new EntertainmentGamesFilter(0, "Командное сражение", true));
        list.add(new EntertainmentGamesFilter(1, "Рубилово", false, 4, null));
        list.add(new EntertainmentGamesFilter(2, "Дерби", false, 4, null));
        list.add(new EntertainmentGamesFilter(3, "Танковые баталии", false, 4, null));
        list.add(new EntertainmentGamesFilter(4, "Битва вооружений", false, 4, null));
        list.add(new EntertainmentGamesFilter(5, "Гонки", false, 4, null));
    }

    private final void setLogicForClickFilter() {
        this.entertainmentFilterClickListener = new Function2<EntertainmentGamesFilter, Integer, Unit>() {
            @Override
            public Unit invoke(EntertainmentGamesFilter entertainmentGamesFilter, Integer num) {
                invoke(entertainmentGamesFilter, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(EntertainmentGamesFilter r8, int r9) {
            }
        };
    }

    private final void setItemsInFilterList() {
        List<EntertainmentGamesFilter> list = this.gamesList;
        Function2<? super EntertainmentGamesFilter, ? super Integer, Unit> function2 = this.entertainmentFilterClickListener;
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding = null;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entertainmentFilterClickListener");
            function2 = null;
        }
        this.gamesFilterAdapter = new EntertainmentSystemGamesFilterAdapter(list, function2, this.context);
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding2 = this.binding;
        if (entertainmentSystemTopLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemTopLayoutBinding2 = null;
        }
        RecyclerView recyclerView = entertainmentSystemTopLayoutBinding2.listWithGamesFilter;
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding3 = this.binding;
        if (entertainmentSystemTopLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            entertainmentSystemTopLayoutBinding = entertainmentSystemTopLayoutBinding3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(entertainmentSystemTopLayoutBinding.getRoot().getContext(), 1, false));
        recyclerView.setAdapter(this.gamesFilterAdapter);
    }

    public final void setListInView(int i) {
        this.topPlayers.clear();
        if (i == 0) {
            this.topPlayers.addAll(this.mainRoot.getListWithTopPlayers0());
        } else if (i == 1) {
            this.topPlayers.addAll(this.mainRoot.getListWithTopPlayers1());
        } else if (i == 2) {
            this.topPlayers.addAll(this.mainRoot.getListWithTopPlayers2());
        } else if (i == 3) {
            this.topPlayers.addAll(this.mainRoot.getListWithTopPlayers3());
        } else if (i == 4) {
            this.topPlayers.addAll(this.mainRoot.getListWithTopPlayers4());
        } else if (i == 5) {
            this.topPlayers.addAll(this.mainRoot.getListWithTopPlayers5());
        }
        EntertainmentSystemPlayersTopAdapter entertainmentSystemPlayersTopAdapter = this.playersTopAdapter;
        if (entertainmentSystemPlayersTopAdapter == null) {
            return;
        }
        entertainmentSystemPlayersTopAdapter.notifyDataSetChanged();
    }

    public final void updateMainStatus(int i, String str) {
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding = null;
        if (i == 1) {
            setVisibleTopBlock(true);
            EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding2 = this.binding;
            if (entertainmentSystemTopLayoutBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                entertainmentSystemTopLayoutBinding = entertainmentSystemTopLayoutBinding2;
            }
            entertainmentSystemTopLayoutBinding.topIcon.setImageResource(R.drawable.entertainment_system_top_1_res);
            entertainmentSystemTopLayoutBinding.valueGame.setText(this.context.getString(R.string.entertainment_system_top_games_name, new Object[]{str}));
        } else if (i == 2) {
            setVisibleTopBlock(true);
            EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding3 = this.binding;
            if (entertainmentSystemTopLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                entertainmentSystemTopLayoutBinding = entertainmentSystemTopLayoutBinding3;
            }
            entertainmentSystemTopLayoutBinding.topIcon.setImageResource(R.drawable.entertainment_system_top_2_res);
            entertainmentSystemTopLayoutBinding.valueGame.setText(this.context.getString(R.string.entertainment_system_top_games_name, new Object[]{str}));
        } else if (i == 3) {
            setVisibleTopBlock(true);
            EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding4 = this.binding;
            if (entertainmentSystemTopLayoutBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                entertainmentSystemTopLayoutBinding = entertainmentSystemTopLayoutBinding4;
            }
            entertainmentSystemTopLayoutBinding.topIcon.setImageResource(R.drawable.entertainment_system_top_3_res);
            entertainmentSystemTopLayoutBinding.valueGame.setText(this.context.getString(R.string.entertainment_system_top_games_name, new Object[]{str}));
        } else {
            setVisibleTopBlock(false);
            EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding5 = this.binding;
            if (entertainmentSystemTopLayoutBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                entertainmentSystemTopLayoutBinding = entertainmentSystemTopLayoutBinding5;
            }
            entertainmentSystemTopLayoutBinding.valueOtherTop.setText(this.context.getString(R.string.entertainment_system_value_other_top, new Object[]{String.valueOf(i)}));
            entertainmentSystemTopLayoutBinding.valueGameOther.setText(this.context.getString(R.string.entertainment_system_top_games_name, new Object[]{str}));
        }
    }

    private final void setVisibleTopBlock(boolean z) {
        if (z) {
            setVisibleFirstPosition(0);
            setVisibleOtherPosition(4);
            return;
        }
        setVisibleFirstPosition(4);
        setVisibleOtherPosition(0);
    }

    private final void setVisibleFirstPosition(int i) {
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding = this.binding;
        if (entertainmentSystemTopLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemTopLayoutBinding = null;
        }
        entertainmentSystemTopLayoutBinding.topIcon.setVisibility(i);
        entertainmentSystemTopLayoutBinding.titleGame.setVisibility(i);
        entertainmentSystemTopLayoutBinding.valueGame.setVisibility(i);
    }

    private final void setVisibleOtherPosition(int i) {
        EntertainmentSystemTopLayoutBinding entertainmentSystemTopLayoutBinding = this.binding;
        if (entertainmentSystemTopLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemTopLayoutBinding = null;
        }
        entertainmentSystemTopLayoutBinding.titleOtherTop.setVisibility(i);
        entertainmentSystemTopLayoutBinding.otherTopIcon.setVisibility(i);
        entertainmentSystemTopLayoutBinding.valueOtherTop.setVisibility(i);
        entertainmentSystemTopLayoutBinding.titleGameOther.setVisibility(i);
        entertainmentSystemTopLayoutBinding.valueGameOther.setVisibility(i);
    }
}
