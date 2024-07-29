package com.rockstargames.gtacr.gui.entertainmentSystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.EntertainmentSystemGamesLayoutBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.EntertainmentSystemActionsAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.EntertainmentGameData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010(\u001a\u00020\u0011H\u0002J\b\u0010)\u001a\u00020*H\u0016J\u001a\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u0011H\u0016J\b\u00101\u001a\u00020\u0011H\u0016J\u0010\u00102\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u00020\u0011H\u0002J\b\u00104\u001a\u00020\u0011H\u0002J\b\u00105\u001a\u00020\u0011H\u0002J\u0014\u00106\u001a\u00020\u00112\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000f08RB\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\nj\u0002`\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000RB\u0010\u001d\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\nj\u0002`\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/rockstargames/gtacr/gui/entertainmentSystem/UIGamesLayout;", "Lcom/rockstargames/gtacr/common/UILayout;", "mainRoot", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/GUIEntertainmentSystem;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/ActionsWithJSON;", "(Lcom/rockstargames/gtacr/gui/entertainmentSystem/GUIEntertainmentSystem;Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/entertainmentSystem/ActionsWithJSON;)V", "actionsClickListener", "Lkotlin/Function2;", "Lcom/rockstargames/gtacr/data/EntertainmentGameData;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "action", "", "position", "", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/EntertainmentActionsClickListener;", "actionsDescription", "", "getActionsDescription", "()Ljava/lang/String;", "setActionsDescription", "(Ljava/lang/String;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/EntertainmentSystemGamesLayoutBinding;", "buttonClickListener", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/EntertainmentActionsButtonClickListener;", "gamesAdapter", "Lcom/rockstargames/gtacr/adapters/EntertainmentSystemActionsAdapter;", "gamesList", "", "gamesTitle", "getGamesTitle", "setGamesTitle", "oldActionsTimer", "", "addGameInList", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "setGlobalDescription", "setItemsInGameList", "setLogicForActionsClick", "setLogicForButtonClick", "updatePlayersInLobby", "playersInLobby", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIGamesLayout extends UILayout {
    private Function2<? super EntertainmentGameData, ? super Integer, Unit> actionsClickListener;
    private String actionsDescription;
    private final ActionsWithJSON actionsWithJSON;
    private Animation anim;
    private EntertainmentSystemGamesLayoutBinding binding;
    private Function2<? super EntertainmentGameData, ? super Integer, Unit> buttonClickListener;
    private final NvEventQueueActivity context;
    private EntertainmentSystemActionsAdapter gamesAdapter;
    private final List<EntertainmentGameData> gamesList;
    private String gamesTitle;
    private final GUIEntertainmentSystem mainRoot;
    private long oldActionsTimer;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIGamesLayout(GUIEntertainmentSystem mainRoot, NvEventQueueActivity context, ActionsWithJSON actionsWithJSON) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.mainRoot = mainRoot;
        this.context = context;
        this.actionsWithJSON = actionsWithJSON;
        this.gamesList = new ArrayList();
        this.actionsDescription = "";
        this.gamesTitle = "";
    }

    public final String getActionsDescription() {
        return this.actionsDescription;
    }

    public final void setActionsDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.actionsDescription = str;
    }

    public final String getGamesTitle() {
        return this.gamesTitle;
    }

    public final void setGamesTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gamesTitle = str;
    }

    @Override
    public View getView() {
        EntertainmentSystemGamesLayoutBinding entertainmentSystemGamesLayoutBinding = this.binding;
        if (entertainmentSystemGamesLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemGamesLayoutBinding = null;
        }
        ConstraintLayout root = entertainmentSystemGamesLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void updatePlayersInLobby(List<Integer> playersInLobby) {
        Intrinsics.checkNotNullParameter(playersInLobby, "playersInLobby");
        if (playersInLobby.size() == 6) {
            int i = 0;
            int size = this.gamesList.size();
            while (i < size) {
                int i2 = i + 1;
                if (this.gamesList.get(i).getPlayers() != playersInLobby.get(i).intValue()) {
                    this.gamesList.get(i).setPlayers(playersInLobby.get(i).intValue());
                    EntertainmentSystemActionsAdapter entertainmentSystemActionsAdapter = this.gamesAdapter;
                    if (entertainmentSystemActionsAdapter != null) {
                        entertainmentSystemActionsAdapter.notifyItemChanged(i);
                    }
                }
                i = i2;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        EntertainmentSystemGamesLayoutBinding inflate = EntertainmentSystemGamesLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        EntertainmentSystemGamesLayoutBinding entertainmentSystemGamesLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        addGameInList();
        setLogicForActionsClick();
        setLogicForButtonClick();
        setItemsInGameList();
        EntertainmentSystemGamesLayoutBinding entertainmentSystemGamesLayoutBinding2 = this.binding;
        if (entertainmentSystemGamesLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            entertainmentSystemGamesLayoutBinding = entertainmentSystemGamesLayoutBinding2;
        }
        ConstraintLayout root = entertainmentSystemGamesLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setLogicForActionsClick() {
        this.actionsClickListener = new Function2<EntertainmentGameData, Integer, Unit>() {
            @Override
            public Unit invoke(EntertainmentGameData entertainmentGameData, Integer num) {
                invoke(entertainmentGameData, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(EntertainmentGameData action, int i) {
                EntertainmentSystemActionsAdapter entertainmentSystemActionsAdapter;
                Intrinsics.checkNotNullParameter(action, "action");
                if (!action.isClicked()) {
                    action.setClicked(true);
                    entertainmentSystemActionsAdapter = UIGamesLayout.this.gamesAdapter;
                    if (entertainmentSystemActionsAdapter != null) {
                        entertainmentSystemActionsAdapter.notifyItemChanged(i);
                        entertainmentSystemActionsAdapter.setCheckOnlyElement(i);
                    }
                }
                UIGamesLayout.this.setGlobalDescription(action);
            }
        };
    }

    private final void setLogicForButtonClick() {
        this.buttonClickListener = new Function2<EntertainmentGameData, Integer, Unit>() {
            @Override
            public Unit invoke(EntertainmentGameData entertainmentGameData, Integer num) {
                invoke(entertainmentGameData, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(EntertainmentGameData action, int i) {
                long j;
                long j2;
                List list;
                ActionsWithJSON actionsWithJSON;
                GUIEntertainmentSystem gUIEntertainmentSystem;
                EntertainmentSystemActionsAdapter entertainmentSystemActionsAdapter;
                ActionsWithJSON actionsWithJSON2;
                GUIEntertainmentSystem gUIEntertainmentSystem2;
                List list2;
                Intrinsics.checkNotNullParameter(action, "action");
                j = UIGamesLayout.this.oldActionsTimer;
                if (j != System.currentTimeMillis()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = UIGamesLayout.this.oldActionsTimer;
                    if (currentTimeMillis - j2 > 500) {
                        UIGamesLayout.this.oldActionsTimer = System.currentTimeMillis();
                        list = UIGamesLayout.this.gamesList;
                        int size = list.size();
                        int i2 = 0;
                        while (i2 < size) {
                            int i3 = i2 + 1;
                            if (i2 != i) {
                                list2 = UIGamesLayout.this.gamesList;
                                if (((EntertainmentGameData) list2.get(i2)).getStatus() == 1) {
                                    return;
                                }
                            }
                            i2 = i3;
                        }
                        UIGamesLayout uIGamesLayout = UIGamesLayout.this;
                        if (action.getStatus() == 1) {
                            action.setStatus(0);
                            actionsWithJSON2 = uIGamesLayout.actionsWithJSON;
                            actionsWithJSON2.sendPressButton(2);
                            gUIEntertainmentSystem2 = uIGamesLayout.mainRoot;
                            gUIEntertainmentSystem2.setCurrentGamesId(0);
                        } else {
                            action.setStatus(1);
                            actionsWithJSON = uIGamesLayout.actionsWithJSON;
                            actionsWithJSON.sendGetLobby(action.getId());
                            gUIEntertainmentSystem = uIGamesLayout.mainRoot;
                            gUIEntertainmentSystem.setCurrentGamesId(action.getId());
                        }
                        action.setClicked(true);
                        entertainmentSystemActionsAdapter = UIGamesLayout.this.gamesAdapter;
                        if (entertainmentSystemActionsAdapter != null) {
                            entertainmentSystemActionsAdapter.notifyItemChanged(i);
                            entertainmentSystemActionsAdapter.setCheckOnlyElement(i);
                        }
                        UIGamesLayout.this.setGlobalDescription(action);
                    }
                }
            }
        };
    }

    public final void setGlobalDescription(EntertainmentGameData entertainmentGameData) {
        if (this.actionsDescription.length() == 0) {
            this.mainRoot.setVisibleForButtonInfo(0);
        }
        this.actionsDescription = entertainmentGameData.getDescription();
        this.gamesTitle = entertainmentGameData.getGamesName();
    }

    private final void setItemsInGameList() {
        List<EntertainmentGameData> list = this.gamesList;
        Function2<? super EntertainmentGameData, ? super Integer, Unit> function2 = this.actionsClickListener;
        EntertainmentSystemGamesLayoutBinding entertainmentSystemGamesLayoutBinding = null;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsClickListener");
            function2 = null;
        }
        Function2<? super EntertainmentGameData, ? super Integer, Unit> function22 = this.buttonClickListener;
        if (function22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonClickListener");
            function22 = null;
        }
        this.gamesAdapter = new EntertainmentSystemActionsAdapter(list, function2, function22, this.context);
        EntertainmentSystemGamesLayoutBinding entertainmentSystemGamesLayoutBinding2 = this.binding;
        if (entertainmentSystemGamesLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemGamesLayoutBinding2 = null;
        }
        RecyclerView recyclerView = entertainmentSystemGamesLayoutBinding2.listWithGames;
        EntertainmentSystemGamesLayoutBinding entertainmentSystemGamesLayoutBinding3 = this.binding;
        if (entertainmentSystemGamesLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            entertainmentSystemGamesLayoutBinding = entertainmentSystemGamesLayoutBinding3;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(entertainmentSystemGamesLayoutBinding.getRoot().getContext(), 3));
        recyclerView.setAdapter(this.gamesAdapter);
    }

    private final void addGameInList() {
        ArrayList arrayList = new ArrayList();
        if (this.mainRoot.getArrWithAllPlayers().size() == 6) {
            arrayList.addAll(this.mainRoot.getArrWithAllPlayers());
        } else {
            int i = 0;
            while (i < 6) {
                i++;
                arrayList.add(0);
            }
        }
        List<EntertainmentGameData> list = this.gamesList;
        list.add(new EntertainmentGameData(0, "Командное сражение", "entertainment_system_item_battleground_res", ((Number) arrayList.get(0)).intValue(), 0, "Командное сражение — игра, в которой Вам необходимо бок о бок с другими игроками сражаться против соперников! Побеждает та команда, которая набрала большее число убийств за время игры!", false, 64, null));
        list.add(new EntertainmentGameData(1, "Рубилово", "entertainment_system_item_rubilovo_res", ((Number) arrayList.get(1)).intValue(), 0, "Рубилово - игра, в которой выжившие сражаются с зараженными! Станьте оплотом сопротивления и дайте отпор мертвецам или наоборот - не дайте выжившим ни малейшего шанса.", false, 64, null));
        list.add(new EntertainmentGameData(2, "Дерби", "entertainment_system_item_flatout_res", ((Number) arrayList.get(2)).intValue(), 0, "Дерби - сражайтесь с другими игроками за право быть царём горы! Получайте новую технику и устраняйте своих соперников. Победит тот, кто упадёт наименьшее количество раз. Дерзайте!", false, 64, null));
        list.add(new EntertainmentGameData(3, "Танковые баталии", "entertainment_system_item_tank_battles_res", ((Number) arrayList.get(3)).intValue(), 0, "Танковые баталии - игра, в которой 4 игрока соревнуются за статус самого лучшего танкиста. Ваша задача убить максимальное число танков за 3 минуты, сражаясь с другими танкистами.", false, 64, null));
        list.add(new EntertainmentGameData(4, "Битва вооружений", "entertainment_system_item_arms_battle_res", ((Number) arrayList.get(4)).intValue(), 0, "Гонка вооружений — это мероприятие, в котором задача игроков заключается в убийстве других и получении нового вооружения. Победит тот, кто первым дойдет до последнего оружия.", false, 64, null));
        list.add(new EntertainmentGameData(5, "Гонки", "entertainment_system_item_rice_res", ((Number) arrayList.get(5)).intValue(), 0, "Гонки - участвуйте в классическом автомобильном сражении. Достигните конечной точки первым и одержите победу над другими королями автомобильного мира. Помните, первым до финиша доедет самый дерзкий и смелый водитель. Вперёд!", false, 64, null));
    }
}
