package com.rockstargames.gtacr.gui.familySystem;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesFamilyControlBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.EntertainmentSystemGamesFilterAdapter;
import com.rockstargames.gtacr.adapters.FamilyPlayersActionAdapter;
import com.rockstargames.gtacr.adapters.FamilyPlayersListAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.EntertainmentGamesFilter;
import com.rockstargames.gtacr.data.FamilyPlayer;
import com.rockstargames.gtacr.data.FamilyPlayersAction;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.inventory.Constants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010/\u001a\u00020\u00142\f\u00100\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0012H\u0002J\b\u00103\u001a\u00020\u0014H\u0002J\u0010\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u0017H\u0002J\b\u00106\u001a\u000207H\u0016J\u001a\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010=\u001a\u00020\u0014H\u0016J\b\u0010>\u001a\u00020\u0014H\u0016J\b\u0010?\u001a\u00020\u0014H\u0002J\b\u0010@\u001a\u00020\u0014H\u0002J\b\u0010A\u001a\u00020\u0014H\u0002J\u0014\u0010B\u001a\u00020\u00142\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0E2\u0006\u0010F\u001a\u00020\u0012H\u0002J\u0016\u0010G\u001a\u00020\u00142\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\t0EH\u0002J\b\u0010I\u001a\u00020\u0014H\u0002J\b\u0010J\u001a\u00020\u0014H\u0002J\b\u0010K\u001a\u00020\u0014H\u0002J\b\u0010L\u001a\u00020\u0014H\u0002J\b\u0010M\u001a\u00020\u0014H\u0002J\b\u0010N\u001a\u00020\u0014H\u0002J#\u0010O\u001a\u00020\u00142\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d2\b\u0010Q\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010RJ\u0006\u0010S\u001a\u00020\u0014J\u0010\u0010T\u001a\u00020\u00142\u0006\u0010U\u001a\u00020VH\u0002J\u0010\u0010W\u001a\u00020\u00142\u0006\u0010X\u001a\u00020\u0012H\u0002J\u0010\u0010Y\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020VH\u0002J\u0016\u0010[\u001a\u00020\u00142\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\t0EH\u0002J\u0006\u0010]\u001a\u00020\u0014J\u0018\u0010^\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000RF\u0010\f\u001a:\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\rj\u0004\u0018\u0001`\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000RF\u0010!\u001a:\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0014\u0018\u00010\rj\u0004\u0018\u0001`$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000RF\u0010*\u001a:\u0012\u0013\u0012\u00110'¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0014\u0018\u00010\rj\u0004\u0018\u0001`,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/UIMenuFamilyPlayersSetting;", "Lcom/rockstargames/gtacr/common/UILayout;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;)V", "allPlayersList", "", "Lcom/rockstargames/gtacr/data/FamilyPlayer;", "binding", "Lblackrussia/online/databinding/FamiliesFamilyControlBinding;", "clickActionsButton", "Lkotlin/Function2;", "Lcom/rockstargames/gtacr/data/FamilyPlayersAction;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisAction", "", "action", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickActionsButton;", "currentPlayer", "", "currentPlayersList", "familyPlayersActionAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyPlayersActionAdapter;", "getPlayerSearch", "oldAction", "", "[Ljava/lang/Integer;", "oldTimerPlayersClick", "", "playerClick", "item", "position", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickPlayerList;", "playersActions", "playersFilter", "Lcom/rockstargames/gtacr/data/EntertainmentGamesFilter;", "playersFilterAdapter", "Lcom/rockstargames/gtacr/adapters/EntertainmentSystemGamesFilterAdapter;", "playersFilterClick", "game", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/EntertainmentFilterClickListener;", "playersListAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyPlayersListAdapter;", "actionWithPlayer", "currentCollection", "currentPlayersNick", "getCurrentAction", "clearInfoAboutPlayer", "getCurrentPlayersPosition", "getCurrentPlayer", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "removePlayerFromAllLists", "setActions", "setActionsDataInView", "setAllPlayers", "allPlayers", "setCurrentPlayersFilterList", "", "currentFilter", "setCurrentPlayersList", "thisList", "setFilter", "setFiltersDataInView", "setLogicForClickActionsButton", "setLogicForPlayerClick", "setLogicForPlayersFilterClick", "setPlayersDataInView", "setPlayersInfo", "playersStates", "playersRankName", "([Ljava/lang/Integer;Ljava/lang/String;)V", "setStartParameters", "setVisibleForFilter", "ifSetVisible", "", "setVisibleForPlayersInfo", "setVisible", "setVisibleSearch", "ifShow", "updateCopyList", "playersList", "updatePlayersAction", "updatePlayersRank", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIMenuFamilyPlayersSetting extends UILayout {
    private final ActionsWithJSON actionsWithJSON;
    private List<FamilyPlayer> allPlayersList;
    private FamiliesFamilyControlBinding binding;
    private Function2<? super FamilyPlayersAction, ? super Integer, Unit> clickActionsButton;
    private final NvEventQueueActivity context;
    private String currentPlayer;
    private final List<FamilyPlayer> currentPlayersList;
    private FamilyPlayersActionAdapter familyPlayersActionAdapter;
    private String getPlayerSearch;
    private Integer[] oldAction;
    private long oldTimerPlayersClick;
    private Function2<? super FamilyPlayer, ? super Integer, Unit> playerClick;
    private final List<FamilyPlayersAction> playersActions;
    private final List<EntertainmentGamesFilter> playersFilter;
    private EntertainmentSystemGamesFilterAdapter playersFilterAdapter;
    private Function2<? super EntertainmentGamesFilter, ? super Integer, Unit> playersFilterClick;
    private FamilyPlayersListAdapter playersListAdapter;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIMenuFamilyPlayersSetting(NvEventQueueActivity context, ActionsWithJSON actionsWithJSON) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.context = context;
        this.actionsWithJSON = actionsWithJSON;
        this.allPlayersList = new ArrayList();
        this.currentPlayersList = new ArrayList();
        this.playersFilter = new ArrayList();
        this.playersActions = new ArrayList();
        this.oldAction = new Integer[]{-1, -1};
        this.getPlayerSearch = "";
        this.currentPlayer = "";
    }

    public final void setStartParameters() {
        if (this.playersFilter.size() == 4) {
            this.playersFilter.get(2).setClicked(true);
            EntertainmentSystemGamesFilterAdapter entertainmentSystemGamesFilterAdapter = this.playersFilterAdapter;
            if (entertainmentSystemGamesFilterAdapter != null) {
                entertainmentSystemGamesFilterAdapter.notifyItemChanged(2);
                entertainmentSystemGamesFilterAdapter.setCheckOnlyElement(2);
            }
        }
        setCurrentPlayersList(setCurrentPlayersFilterList(3));
        FamiliesFamilyControlBinding familiesFamilyControlBinding = this.binding;
        if (familiesFamilyControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding = null;
        }
        familiesFamilyControlBinding.editTextSearch.getText().clear();
        setVisibleSearch(false);
        if (this.familyPlayersActionAdapter == null) {
            setActionsDataInView();
        }
    }

    @Override
    public View getView() {
        FamiliesFamilyControlBinding familiesFamilyControlBinding = this.binding;
        if (familiesFamilyControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding = null;
        }
        ConstraintLayout root = familiesFamilyControlBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FamiliesFamilyControlBinding inflate = FamiliesFamilyControlBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        setLogicForPlayerClick();
        setPlayersDataInView();
        setFilter();
        setActions();
        setLogicForPlayersFilterClick();
        setFiltersDataInView();
        setLogicForClickActionsButton();
        FamiliesFamilyControlBinding familiesFamilyControlBinding = this.binding;
        FamiliesFamilyControlBinding familiesFamilyControlBinding2 = null;
        if (familiesFamilyControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding = null;
        }
        familiesFamilyControlBinding.buttonPlayersFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMenuFamilyPlayersSetting.m216onCreateView$lambda1(UIMenuFamilyPlayersSetting.this, view);
            }
        });
        FamiliesFamilyControlBinding familiesFamilyControlBinding3 = this.binding;
        if (familiesFamilyControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding3 = null;
        }
        familiesFamilyControlBinding3.buttonPlayersSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMenuFamilyPlayersSetting.m217onCreateView$lambda2(UIMenuFamilyPlayersSetting.this, view);
            }
        });
        FamiliesFamilyControlBinding familiesFamilyControlBinding4 = this.binding;
        if (familiesFamilyControlBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding4 = null;
        }
        familiesFamilyControlBinding4.editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FamilyPlayersListAdapter familyPlayersListAdapter;
                Filter filter;
                String str;
                if (charSequence != null) {
                    UIMenuFamilyPlayersSetting.this.getPlayerSearch = charSequence.toString();
                }
                familyPlayersListAdapter = UIMenuFamilyPlayersSetting.this.playersListAdapter;
                if (familyPlayersListAdapter == null || (filter = familyPlayersListAdapter.getFilter()) == null) {
                    return;
                }
                str = UIMenuFamilyPlayersSetting.this.getPlayerSearch;
                filter.filter(str);
            }
        });
        FamiliesFamilyControlBinding familiesFamilyControlBinding5 = this.binding;
        if (familiesFamilyControlBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding5 = null;
        }
        familiesFamilyControlBinding5.buttonBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIMenuFamilyPlayersSetting.m218onCreateView$lambda3(UIMenuFamilyPlayersSetting.this, view);
            }
        });
        FamiliesFamilyControlBinding familiesFamilyControlBinding6 = this.binding;
        if (familiesFamilyControlBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding6 = null;
        }
        familiesFamilyControlBinding6.titleLeftBlock.setSelected(true);
        familiesFamilyControlBinding6.playersPositionValue.setSelected(true);
        familiesFamilyControlBinding6.phoneNumberValue.setSelected(true);
        FamiliesFamilyControlBinding familiesFamilyControlBinding7 = this.binding;
        if (familiesFamilyControlBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesFamilyControlBinding2 = familiesFamilyControlBinding7;
        }
        ConstraintLayout root = familiesFamilyControlBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public static final void m216onCreateView$lambda1(UIMenuFamilyPlayersSetting this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FamiliesFamilyControlBinding familiesFamilyControlBinding = this$0.binding;
        if (familiesFamilyControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding = null;
        }
        if (familiesFamilyControlBinding.playersFilterList.getVisibility() == 0) {
            this$0.setVisibleForFilter(false);
        } else {
            this$0.setVisibleForFilter(true);
        }
    }

    public static final void m217onCreateView$lambda2(UIMenuFamilyPlayersSetting this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FamiliesFamilyControlBinding familiesFamilyControlBinding = this$0.binding;
        FamiliesFamilyControlBinding familiesFamilyControlBinding2 = null;
        if (familiesFamilyControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding = null;
        }
        if (familiesFamilyControlBinding.editTextSearch.getVisibility() == 0) {
            FamiliesFamilyControlBinding familiesFamilyControlBinding3 = this$0.binding;
            if (familiesFamilyControlBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                familiesFamilyControlBinding2 = familiesFamilyControlBinding3;
            }
            familiesFamilyControlBinding2.editTextSearch.getText().clear();
            this$0.setVisibleSearch(false);
            return;
        }
        this$0.setVisibleSearch(true);
    }

    public static final void m218onCreateView$lambda3(UIMenuFamilyPlayersSetting this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actionsWithJSON.sendGetLayout(5);
    }

    private final void setLogicForPlayerClick() {
        this.playerClick = new Function2<FamilyPlayer, Integer, Unit>() {
            @Override
            public Unit invoke(FamilyPlayer familyPlayer, Integer num) {
                invoke(familyPlayer, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(FamilyPlayer item, int i) {
                long j;
                FamilyPlayersListAdapter familyPlayersListAdapter;
                FamiliesFamilyControlBinding familiesFamilyControlBinding;
                List list;
                ActionsWithJSON actionsWithJSON;
                Intrinsics.checkNotNullParameter(item, "item");
                long currentTimeMillis = System.currentTimeMillis();
                j = UIMenuFamilyPlayersSetting.this.oldTimerPlayersClick;
                if (currentTimeMillis - j > 500) {
                    UIMenuFamilyPlayersSetting.this.oldTimerPlayersClick = System.currentTimeMillis();
                    item.setClicked(true);
                    familyPlayersListAdapter = UIMenuFamilyPlayersSetting.this.playersListAdapter;
                    if (familyPlayersListAdapter != null) {
                        familyPlayersListAdapter.notifyItemChanged(i);
                        familyPlayersListAdapter.setCheckOnlyElement(i);
                    }
                    familiesFamilyControlBinding = UIMenuFamilyPlayersSetting.this.binding;
                    if (familiesFamilyControlBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        familiesFamilyControlBinding = null;
                    }
                    familiesFamilyControlBinding.titleRightBlock.setText(item.getPlayersNick());
                    familiesFamilyControlBinding.playersRankValue.setText(String.valueOf(item.getPlayersRank()));
                    list = UIMenuFamilyPlayersSetting.this.playersActions;
                    ((FamilyPlayersAction) list.get(0)).setActionsValue(item.getPlayersRank());
                    UIMenuFamilyPlayersSetting.this.currentPlayer = item.getPlayersNick();
                    actionsWithJSON = UIMenuFamilyPlayersSetting.this.actionsWithJSON;
                    actionsWithJSON.getPlayersInfo(item.getPlayersNick());
                }
            }
        };
    }

    private final void setPlayersDataInView() {
        this.playersListAdapter = new FamilyPlayersListAdapter(this.currentPlayersList, this.playerClick, this.context);
        FamiliesFamilyControlBinding familiesFamilyControlBinding = this.binding;
        FamiliesFamilyControlBinding familiesFamilyControlBinding2 = null;
        if (familiesFamilyControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding = null;
        }
        RecyclerView recyclerView = familiesFamilyControlBinding.playersList;
        FamiliesFamilyControlBinding familiesFamilyControlBinding3 = this.binding;
        if (familiesFamilyControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesFamilyControlBinding2 = familiesFamilyControlBinding3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesFamilyControlBinding2.getRoot().getContext(), 1, false));
        recyclerView.setAdapter(this.playersListAdapter);
    }

    private final void setLogicForPlayersFilterClick() {
        this.playersFilterClick = new Function2<EntertainmentGamesFilter, Integer, Unit>() {
            @Override
            public Unit invoke(EntertainmentGamesFilter entertainmentGamesFilter, Integer num) {
                invoke(entertainmentGamesFilter, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(EntertainmentGamesFilter game, int i) {
                EntertainmentSystemGamesFilterAdapter entertainmentSystemGamesFilterAdapter;
                List currentPlayersFilterList;
                List currentPlayersFilterList2;
                List currentPlayersFilterList3;
                List currentPlayersFilterList4;
                Intrinsics.checkNotNullParameter(game, "game");
                game.setClicked(true);
                entertainmentSystemGamesFilterAdapter = UIMenuFamilyPlayersSetting.this.playersFilterAdapter;
                if (entertainmentSystemGamesFilterAdapter != null) {
                    entertainmentSystemGamesFilterAdapter.notifyItemChanged(i);
                    entertainmentSystemGamesFilterAdapter.setCheckOnlyElement(i);
                }
                int id = game.getId();
                if (id == 0) {
                    UIMenuFamilyPlayersSetting uIMenuFamilyPlayersSetting = UIMenuFamilyPlayersSetting.this;
                    currentPlayersFilterList = uIMenuFamilyPlayersSetting.setCurrentPlayersFilterList(0);
                    uIMenuFamilyPlayersSetting.setCurrentPlayersList(currentPlayersFilterList);
                } else if (id == 1) {
                    UIMenuFamilyPlayersSetting uIMenuFamilyPlayersSetting2 = UIMenuFamilyPlayersSetting.this;
                    currentPlayersFilterList2 = uIMenuFamilyPlayersSetting2.setCurrentPlayersFilterList(1);
                    uIMenuFamilyPlayersSetting2.setCurrentPlayersList(currentPlayersFilterList2);
                } else if (id == 2) {
                    UIMenuFamilyPlayersSetting uIMenuFamilyPlayersSetting3 = UIMenuFamilyPlayersSetting.this;
                    currentPlayersFilterList3 = uIMenuFamilyPlayersSetting3.setCurrentPlayersFilterList(2);
                    uIMenuFamilyPlayersSetting3.setCurrentPlayersList(currentPlayersFilterList3);
                } else if (id == 3) {
                    UIMenuFamilyPlayersSetting uIMenuFamilyPlayersSetting4 = UIMenuFamilyPlayersSetting.this;
                    currentPlayersFilterList4 = uIMenuFamilyPlayersSetting4.setCurrentPlayersFilterList(3);
                    uIMenuFamilyPlayersSetting4.setCurrentPlayersList(currentPlayersFilterList4);
                }
                UIMenuFamilyPlayersSetting.this.setVisibleForFilter(false);
            }
        };
    }

    private final void setFilter() {
        List<EntertainmentGamesFilter> list = this.playersFilter;
        list.clear();
        list.add(new EntertainmentGamesFilter(0, "Только онлайн", false, 4, null));
        list.add(new EntertainmentGamesFilter(1, "Только оффлайн", false, 4, null));
        list.add(new EntertainmentGamesFilter(2, "Ранг по возрастанию", false, 4, null));
        list.add(new EntertainmentGamesFilter(3, "Ранг по убыванию", false, 4, null));
    }

    private final void setActions() {
        List<FamilyPlayersAction> list = this.playersActions;
        list.clear();
        list.add(new FamilyPlayersAction(0, "Изменить ранг", 0, 0));
        list.add(new FamilyPlayersAction(1, "Управление выговорами", 0, 0));
        list.add(new FamilyPlayersAction(2, "Выдать мут (минут)", 0, 0));
        list.add(new FamilyPlayersAction(3, "Выгнать", 0, 1));
    }

    public final void setVisibleForFilter(boolean z) {
        FamiliesFamilyControlBinding familiesFamilyControlBinding = this.binding;
        if (familiesFamilyControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding = null;
        }
        if (z) {
            familiesFamilyControlBinding.playersFilterList.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 23) {
                familiesFamilyControlBinding.buttonPlayersFilter.setBackgroundColor(this.context.getResources().getColor(R.color.color_9F280F, null));
                return;
            } else {
                familiesFamilyControlBinding.buttonPlayersFilter.setBackgroundColor(this.context.getResources().getColor(R.color.color_9F280F));
                return;
            }
        }
        familiesFamilyControlBinding.playersFilterList.setVisibility(4);
        if (Build.VERSION.SDK_INT >= 23) {
            familiesFamilyControlBinding.buttonPlayersFilter.setBackgroundColor(this.context.getResources().getColor(R.color.inv_full_transparency, null));
        } else {
            familiesFamilyControlBinding.buttonPlayersFilter.setBackgroundColor(this.context.getResources().getColor(R.color.inv_full_transparency));
        }
    }

    private final void setFiltersDataInView() {
        this.playersFilterAdapter = new EntertainmentSystemGamesFilterAdapter(this.playersFilter, this.playersFilterClick, this.context);
        FamiliesFamilyControlBinding familiesFamilyControlBinding = this.binding;
        FamiliesFamilyControlBinding familiesFamilyControlBinding2 = null;
        if (familiesFamilyControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding = null;
        }
        RecyclerView recyclerView = familiesFamilyControlBinding.playersFilterList;
        FamiliesFamilyControlBinding familiesFamilyControlBinding3 = this.binding;
        if (familiesFamilyControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesFamilyControlBinding2 = familiesFamilyControlBinding3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesFamilyControlBinding2.getRoot().getContext(), 1, false));
        recyclerView.setAdapter(this.playersFilterAdapter);
    }

    private final void setVisibleSearch(boolean z) {
        FamiliesFamilyControlBinding familiesFamilyControlBinding = this.binding;
        if (familiesFamilyControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding = null;
        }
        if (z) {
            familiesFamilyControlBinding.buttonPlayersFilter.setVisibility(4);
            familiesFamilyControlBinding.playersFilterList.setVisibility(4);
            familiesFamilyControlBinding.titleLeftBlock.setVisibility(4);
            familiesFamilyControlBinding.buttonPlayersSearch.setImageResource(R.drawable.menu_close);
            familiesFamilyControlBinding.editTextSearch.setVisibility(0);
            return;
        }
        familiesFamilyControlBinding.buttonPlayersFilter.setVisibility(0);
        familiesFamilyControlBinding.titleLeftBlock.setVisibility(0);
        familiesFamilyControlBinding.buttonPlayersSearch.setImageResource(R.drawable.br_audio_loupe);
        familiesFamilyControlBinding.editTextSearch.setVisibility(4);
    }

    public final void setAllPlayers(List<FamilyPlayer> allPlayers) {
        Intrinsics.checkNotNullParameter(allPlayers, "allPlayers");
        List<FamilyPlayer> list = this.allPlayersList;
        list.clear();
        list.addAll(allPlayers);
    }

    public final List<FamilyPlayer> setCurrentPlayersFilterList(int i) {
        ArrayList arrayList = new ArrayList();
        List<FamilyPlayer> sortedWith = CollectionsKt.sortedWith(this.allPlayersList, new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                return ComparisonsKt.compareValues(((FamilyPlayer) o).getPlayersNick(), ((FamilyPlayer) t1).getPlayersNick());
            }
        });
        if (i == 0) {
            for (FamilyPlayer familyPlayer : sortedWith) {
                if (familyPlayer.getPlayersStatus() == 1) {
                    arrayList.add(familyPlayer);
                }
            }
        } else if (i == 1) {
            for (FamilyPlayer familyPlayer2 : sortedWith) {
                if (familyPlayer2.getPlayersStatus() == 0) {
                    arrayList.add(familyPlayer2);
                }
            }
        } else if (i == 2) {
            arrayList.addAll(CollectionsKt.sortedWith(sortedWith, new Comparator() {
                @Override
                public int compare(Object o, Object t1) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((FamilyPlayer) o).getPlayersRank()), Integer.valueOf(((FamilyPlayer) t1).getPlayersRank()));
                }
            }));
        } else if (i == 3) {
            arrayList.addAll(CollectionsKt.sortedWith(sortedWith, new Comparator() {
                @Override
                public int compare(Object o, Object t1) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((FamilyPlayer) o).getPlayersRank()), Integer.valueOf(((FamilyPlayer) t1).getPlayersRank()));
                }
            }));
        }
        return arrayList;
    }

    public final void setCurrentPlayersList(List<FamilyPlayer> list) {
        List<FamilyPlayer> list2 = this.currentPlayersList;
        list2.clear();
        list2.addAll(list);
        if (this.currentPlayersList.size() > 0) {
            int size = this.currentPlayersList.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                FamilyPlayer familyPlayer = this.currentPlayersList.get(i);
                if (i == 0) {
                    familyPlayer.setClicked(true);
                    this.playersActions.get(0).setActionsValue(familyPlayer.getPlayersRank());
                    this.currentPlayer = familyPlayer.getPlayersNick();
                    this.actionsWithJSON.getPlayersInfo(familyPlayer.getPlayersNick());
                    FamiliesFamilyControlBinding familiesFamilyControlBinding = this.binding;
                    FamiliesFamilyControlBinding familiesFamilyControlBinding2 = null;
                    if (familiesFamilyControlBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        familiesFamilyControlBinding = null;
                    }
                    familiesFamilyControlBinding.titleRightBlock.setText(familyPlayer.getPlayersNick());
                    FamiliesFamilyControlBinding familiesFamilyControlBinding3 = this.binding;
                    if (familiesFamilyControlBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        familiesFamilyControlBinding2 = familiesFamilyControlBinding3;
                    }
                    familiesFamilyControlBinding2.playersRankValue.setText(String.valueOf(familyPlayer.getPlayersRank()));
                } else if (familyPlayer.isClicked()) {
                    familyPlayer.setClicked(false);
                }
                i = i2;
            }
        }
        FamilyPlayersListAdapter familyPlayersListAdapter = this.playersListAdapter;
        if (familyPlayersListAdapter != null) {
            familyPlayersListAdapter.notifyDataSetChanged();
        }
        updateCopyList(list);
    }

    private final void updateCopyList(List<FamilyPlayer> list) {
        FamilyPlayersListAdapter familyPlayersListAdapter = this.playersListAdapter;
        if (familyPlayersListAdapter == null) {
            return;
        }
        List<FamilyPlayer> copyList = familyPlayersListAdapter.getCopyList();
        copyList.clear();
        copyList.addAll(list);
    }

    private final void updatePlayersRank(String str, int i) {
        actionWithPlayer(this.allPlayersList, str, i);
    }

    private final void actionWithPlayer(List<FamilyPlayer> list, String str, int i) {
        for (FamilyPlayer familyPlayer : list) {
            if (Intrinsics.areEqual(familyPlayer.getPlayersNick(), str)) {
                if (i == 0) {
                    familyPlayer.setPlayersRank(familyPlayer.getPlayersRank() - 1);
                } else if (i == 1) {
                    familyPlayer.setPlayersRank(familyPlayer.getPlayersRank() + 1);
                }
                FamiliesFamilyControlBinding familiesFamilyControlBinding = this.binding;
                if (familiesFamilyControlBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    familiesFamilyControlBinding = null;
                }
                familiesFamilyControlBinding.playersRankValue.setText(String.valueOf(familyPlayer.getPlayersRank()));
                return;
            }
        }
    }

    private final int getCurrentPlayersPosition(String str) {
        if (this.currentPlayersList.size() > 0) {
            int size = this.currentPlayersList.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                if (Intrinsics.areEqual(this.currentPlayersList.get(i).getPlayersNick(), str)) {
                    return i;
                }
                i = i2;
            }
            return 0;
        }
        return 0;
    }

    public final void setPlayersInfo(Integer[] playersStates, String str) {
        Intrinsics.checkNotNullParameter(playersStates, "playersStates");
        if (playersStates.length != 5 || str == null) {
            return;
        }
        setVisibleForPlayersInfo(0);
        FamiliesFamilyControlBinding familiesFamilyControlBinding = this.binding;
        if (familiesFamilyControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding = null;
        }
        Useful useful = new Useful();
        NvEventQueueActivity nvEventQueueActivity = this.context;
        int intValue = playersStates[0].intValue();
        FrameLayout familySkin = familiesFamilyControlBinding.familySkin;
        Intrinsics.checkNotNullExpressionValue(familySkin, "familySkin");
        useful.renderSkin(nvEventQueueActivity, 2, Constants.ID_SKIN, intValue, 1, familySkin);
        familiesFamilyControlBinding.playersPositionValue.setText(str);
        familiesFamilyControlBinding.playersLevelValue.setText(String.valueOf(playersStates[1].intValue()));
        familiesFamilyControlBinding.reprimandsValue.setText(this.context.getString(R.string.hint_quests_value, new Object[]{String.valueOf(playersStates[2].intValue()), ExifInterface.GPS_MEASUREMENT_3D}));
        familiesFamilyControlBinding.phoneNumberValue.setText(String.valueOf(playersStates[3].intValue()));
        List<FamilyPlayersAction> list = this.playersActions;
        list.get(1).setActionsValue(playersStates[2].intValue());
        list.get(2).setActionsValue(playersStates[4].intValue());
        FamilyPlayersActionAdapter familyPlayersActionAdapter = this.familyPlayersActionAdapter;
        if (familyPlayersActionAdapter == null) {
            return;
        }
        familyPlayersActionAdapter.notifyDataSetChanged();
    }

    private final void setLogicForClickActionsButton() {
        this.clickActionsButton = new Function2<FamilyPlayersAction, Integer, Unit>() {
            @Override
            public Unit invoke(FamilyPlayersAction familyPlayersAction, Integer num) {
                invoke(familyPlayersAction, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(FamilyPlayersAction thisAction, int i) {
                long j;
                ActionsWithJSON actionsWithJSON;
                Integer[] numArr;
                Integer[] numArr2;
                Intrinsics.checkNotNullParameter(thisAction, "thisAction");
                long currentTimeMillis = System.currentTimeMillis();
                j = UIMenuFamilyPlayersSetting.this.oldTimerPlayersClick;
                if (currentTimeMillis - j > 1000) {
                    UIMenuFamilyPlayersSetting.this.oldTimerPlayersClick = System.currentTimeMillis();
                    actionsWithJSON = UIMenuFamilyPlayersSetting.this.actionsWithJSON;
                    actionsWithJSON.setActionWithPlayer(thisAction.getActionsId(), i);
                    numArr = UIMenuFamilyPlayersSetting.this.oldAction;
                    numArr[0] = Integer.valueOf(thisAction.getActionsId());
                    numArr2 = UIMenuFamilyPlayersSetting.this.oldAction;
                    numArr2[1] = Integer.valueOf(i);
                }
            }
        };
    }

    private final void setActionsDataInView() {
        this.familyPlayersActionAdapter = new FamilyPlayersActionAdapter(this.playersActions, this.clickActionsButton);
        FamiliesFamilyControlBinding familiesFamilyControlBinding = this.binding;
        FamiliesFamilyControlBinding familiesFamilyControlBinding2 = null;
        if (familiesFamilyControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding = null;
        }
        RecyclerView recyclerView = familiesFamilyControlBinding.actionWithPlayer;
        FamiliesFamilyControlBinding familiesFamilyControlBinding3 = this.binding;
        if (familiesFamilyControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesFamilyControlBinding2 = familiesFamilyControlBinding3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesFamilyControlBinding2.getRoot().getContext(), 1, false));
        recyclerView.setAdapter(this.familyPlayersActionAdapter);
    }

    public final void updatePlayersAction() {
        int size = this.playersActions.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            if (this.oldAction[0].intValue() == this.playersActions.get(i).getActionsId()) {
                int intValue = this.oldAction[1].intValue();
                FamiliesFamilyControlBinding familiesFamilyControlBinding = null;
                if (intValue == 0) {
                    int actionsId = this.playersActions.get(i).getActionsId();
                    if (actionsId == 0) {
                        FamilyPlayersAction familyPlayersAction = this.playersActions.get(i);
                        familyPlayersAction.setActionsValue(familyPlayersAction.getActionsValue() - 1);
                        updatePlayersRank(this.currentPlayer, 0);
                        FamilyPlayersListAdapter familyPlayersListAdapter = this.playersListAdapter;
                        if (familyPlayersListAdapter != null) {
                            familyPlayersListAdapter.notifyItemChanged(getCurrentPlayersPosition(this.currentPlayer));
                        }
                    } else if (actionsId == 1) {
                        FamilyPlayersAction familyPlayersAction2 = this.playersActions.get(i);
                        familyPlayersAction2.setActionsValue(familyPlayersAction2.getActionsValue() - 1);
                        FamiliesFamilyControlBinding familiesFamilyControlBinding2 = this.binding;
                        if (familiesFamilyControlBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            familiesFamilyControlBinding = familiesFamilyControlBinding2;
                        }
                        familiesFamilyControlBinding.reprimandsValue.setText(this.context.getString(R.string.hint_quests_value, new Object[]{String.valueOf(this.playersActions.get(i).getActionsValue()), ExifInterface.GPS_MEASUREMENT_3D}));
                    } else if (actionsId == 2) {
                        if (this.playersActions.get(i).getActionsValue() < 600) {
                            this.playersActions.get(i).setActionsValue(0);
                        } else {
                            FamilyPlayersAction familyPlayersAction3 = this.playersActions.get(i);
                            familyPlayersAction3.setActionsValue(familyPlayersAction3.getActionsValue() - 600);
                        }
                    }
                    FamilyPlayersActionAdapter familyPlayersActionAdapter = this.familyPlayersActionAdapter;
                    if (familyPlayersActionAdapter == null) {
                        return;
                    }
                    familyPlayersActionAdapter.notifyItemChanged(i);
                    return;
                } else if (intValue != 1) {
                    if (intValue != 2) {
                        return;
                    }
                    removePlayerFromAllLists();
                    return;
                } else {
                    int actionsId2 = this.playersActions.get(i).getActionsId();
                    if (actionsId2 == 0) {
                        FamilyPlayersAction familyPlayersAction4 = this.playersActions.get(i);
                        familyPlayersAction4.setActionsValue(familyPlayersAction4.getActionsValue() + 1);
                        updatePlayersRank(this.currentPlayer, 1);
                        FamilyPlayersListAdapter familyPlayersListAdapter2 = this.playersListAdapter;
                        if (familyPlayersListAdapter2 != null) {
                            familyPlayersListAdapter2.notifyItemChanged(getCurrentPlayersPosition(this.currentPlayer));
                        }
                    } else if (actionsId2 == 1) {
                        FamilyPlayersAction familyPlayersAction5 = this.playersActions.get(i);
                        familyPlayersAction5.setActionsValue(familyPlayersAction5.getActionsValue() + 1);
                        if (this.playersActions.get(i).getActionsValue() == 3) {
                            removePlayerFromAllLists();
                        } else {
                            FamiliesFamilyControlBinding familiesFamilyControlBinding3 = this.binding;
                            if (familiesFamilyControlBinding3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            } else {
                                familiesFamilyControlBinding = familiesFamilyControlBinding3;
                            }
                            familiesFamilyControlBinding.reprimandsValue.setText(this.context.getString(R.string.hint_quests_value, new Object[]{String.valueOf(this.playersActions.get(i).getActionsValue()), ExifInterface.GPS_MEASUREMENT_3D}));
                        }
                    } else if (actionsId2 == 2) {
                        if (this.playersActions.get(i).getActionsValue() > 3000) {
                            this.playersActions.get(i).setActionsValue(3600);
                        } else {
                            FamilyPlayersAction familyPlayersAction6 = this.playersActions.get(i);
                            familyPlayersAction6.setActionsValue(familyPlayersAction6.getActionsValue() + 600);
                        }
                    }
                    FamilyPlayersActionAdapter familyPlayersActionAdapter2 = this.familyPlayersActionAdapter;
                    if (familyPlayersActionAdapter2 == null) {
                        return;
                    }
                    familyPlayersActionAdapter2.notifyItemChanged(i);
                    return;
                }
            }
            i = i2;
        }
    }

    private final void removePlayerFromAllLists() {
        int i = 0;
        if (this.allPlayersList.size() > 0) {
            int size = this.allPlayersList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                int i3 = i2 + 1;
                if (Intrinsics.areEqual(this.allPlayersList.get(i2).getPlayersNick(), this.currentPlayer)) {
                    this.allPlayersList.remove(i2);
                    break;
                }
                i2 = i3;
            }
        }
        if (this.currentPlayersList.size() > 0) {
            int size2 = this.currentPlayersList.size();
            while (true) {
                if (i >= size2) {
                    break;
                }
                int i4 = i + 1;
                if (Intrinsics.areEqual(this.currentPlayersList.get(i).getPlayersNick(), this.currentPlayer)) {
                    this.currentPlayersList.remove(i);
                    FamilyPlayersListAdapter familyPlayersListAdapter = this.playersListAdapter;
                    if (familyPlayersListAdapter != null) {
                        familyPlayersListAdapter.notifyItemRemoved(i);
                    }
                } else {
                    i = i4;
                }
            }
        }
        updateCopyList(this.currentPlayersList);
        clearInfoAboutPlayer();
    }

    private final void clearInfoAboutPlayer() {
        setVisibleForPlayersInfo(4);
    }

    private final void setVisibleForPlayersInfo(int i) {
        FamiliesFamilyControlBinding familiesFamilyControlBinding = this.binding;
        if (familiesFamilyControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesFamilyControlBinding = null;
        }
        familiesFamilyControlBinding.playersInfo.setVisibility(i);
        familiesFamilyControlBinding.actionWithPlayer.setVisibility(i);
        familiesFamilyControlBinding.familySkin.setVisibility(i);
        familiesFamilyControlBinding.titleRightBlock.setVisibility(i);
    }
}
