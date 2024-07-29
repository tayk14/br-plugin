package com.rockstargames.gtacr.gui.entertainmentSystem;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import blackrussia.online.R;
import blackrussia.online.databinding.EntertainmentSystemDialogInfoBinding;
import blackrussia.online.databinding.EntertainmentSystemMainBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.common.UIContainer;
import com.rockstargames.gtacr.data.EntertainmentPlayersData;
import com.rockstargames.gtacr.gui.Useful;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 W2\u00020\u0001:\u0001WB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0012\u0010F\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010G\u001a\u00020\tH\u0016J\b\u0010H\u001a\u00020CH\u0002J\u0010\u0010I\u001a\u00020C2\u0006\u0010J\u001a\u00020\u0017H\u0002J\b\u0010K\u001a\u00020(H\u0016J\u0010\u0010L\u001a\u00020C2\u0006\u0010M\u001a\u00020\tH\u0002J\u0012\u0010N\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0018\u0010O\u001a\u00020C2\u0006\u0010P\u001a\u00020\u001e2\u0006\u0010Q\u001a\u00020\u001eH\u0002J\u000e\u0010R\u001a\u00020C2\u0006\u0010S\u001a\u00020\tJ\u000e\u0010T\u001a\u00020C2\u0006\u0010S\u001a\u00020\tJ$\u0010U\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010V\u001a\u0004\u0018\u00010$2\u0006\u0010J\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000bR\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020/0\b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u000bR\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020/0\b¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u000bR\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020/0\b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u000bR\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020/0\b¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u000bR\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020/0\b¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u000bR\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/rockstargames/gtacr/gui/entertainmentSystem/GUIEntertainmentSystem;", "Lcom/rockstargames/gtacr/ISAMPGUI;", "()V", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/ActionsWithJSON;", "anim", "Landroid/view/animation/Animation;", "arrWithAllPlayers", "", "", "getArrWithAllPlayers", "()Ljava/util/List;", "arrWithCurrentTopGames", "getArrWithCurrentTopGames", "arrWithCurrentTopPositions", "getArrWithCurrentTopPositions", "binding", "Lblackrussia/online/databinding/EntertainmentSystemMainBinding;", "bindingInfo", "Lblackrussia/online/databinding/EntertainmentSystemDialogInfoBinding;", "container", "Lcom/rockstargames/gtacr/common/UIContainer;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "currentGamesId", "getCurrentGamesId", "()I", "setCurrentGamesId", "(I)V", "currentNick", "", "getCurrentNick", "()Ljava/lang/String;", "setCurrentNick", "(Ljava/lang/String;)V", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "inflater", "Landroid/view/LayoutInflater;", "isThePlayerClosed", "", "layoutGames", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/UIGamesLayout;", "layoutTopPlayers", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/UIPlayersTop;", "listWithLayout", "listWithTopPlayers0", "Lcom/rockstargames/gtacr/data/EntertainmentPlayersData;", "getListWithTopPlayers0", "listWithTopPlayers1", "getListWithTopPlayers1", "listWithTopPlayers2", "getListWithTopPlayers2", "listWithTopPlayers3", "getListWithTopPlayers3", "listWithTopPlayers4", "getListWithTopPlayers4", "listWithTopPlayers5", "getListWithTopPlayers5", "oldInfoTimer", "", "popupWindow", "Landroid/widget/PopupWindow;", "popupWindowInfo", "transformJsonToCorrectType", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/GetAllStartParametersAndTransformationToCorrectType;", "addAllData", "", "json", "Lorg/json/JSONObject;", "close", "getGuiId", "initialisationContainer", "initialisationPopupWindow", "activity", "isShowingGui", "listenerLayout", "idLayout", "onPacketIncoming", "openDialogInfo", "gamesTitle", "gamesDescription", "setVisibleForButtonBack", "visibleValue", "setVisibleForButtonInfo", "show", "manager", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GUIEntertainmentSystem implements ISAMPGUI {
    public static final Companion Companion = new Companion(null);
    private ActionsWithJSON actionsWithJSON;
    private Animation anim;
    private EntertainmentSystemMainBinding binding;
    private EntertainmentSystemDialogInfoBinding bindingInfo;
    private UIContainer container;
    private NvEventQueueActivity context;
    private int currentGamesId;
    private GUIManager guiManager;
    private LayoutInflater inflater;
    private UIGamesLayout layoutGames;
    private UIPlayersTop layoutTopPlayers;
    private long oldInfoTimer;
    private PopupWindow popupWindow;
    private PopupWindow popupWindowInfo;
    private GetAllStartParametersAndTransformationToCorrectType transformJsonToCorrectType;
    private final List<Integer> listWithLayout = new ArrayList();
    private final List<Integer> arrWithAllPlayers = new ArrayList();
    private final List<EntertainmentPlayersData> listWithTopPlayers0 = new ArrayList();
    private final List<EntertainmentPlayersData> listWithTopPlayers1 = new ArrayList();
    private final List<EntertainmentPlayersData> listWithTopPlayers2 = new ArrayList();
    private final List<EntertainmentPlayersData> listWithTopPlayers3 = new ArrayList();
    private final List<EntertainmentPlayersData> listWithTopPlayers4 = new ArrayList();
    private final List<EntertainmentPlayersData> listWithTopPlayers5 = new ArrayList();
    private final List<Integer> arrWithCurrentTopPositions = new ArrayList();
    private final List<Integer> arrWithCurrentTopGames = new ArrayList();
    private String currentNick = "";
    private boolean isThePlayerClosed = true;

    @JvmStatic
    public static final GUIEntertainmentSystem newInstance() {
        return Companion.newInstance();
    }

    @Override
    public int getGuiId() {
        return 42;
    }

    public final List<Integer> getArrWithAllPlayers() {
        return this.arrWithAllPlayers;
    }

    public final List<EntertainmentPlayersData> getListWithTopPlayers0() {
        return this.listWithTopPlayers0;
    }

    public final List<EntertainmentPlayersData> getListWithTopPlayers1() {
        return this.listWithTopPlayers1;
    }

    public final List<EntertainmentPlayersData> getListWithTopPlayers2() {
        return this.listWithTopPlayers2;
    }

    public final List<EntertainmentPlayersData> getListWithTopPlayers3() {
        return this.listWithTopPlayers3;
    }

    public final List<EntertainmentPlayersData> getListWithTopPlayers4() {
        return this.listWithTopPlayers4;
    }

    public final List<EntertainmentPlayersData> getListWithTopPlayers5() {
        return this.listWithTopPlayers5;
    }

    public final List<Integer> getArrWithCurrentTopPositions() {
        return this.arrWithCurrentTopPositions;
    }

    public final List<Integer> getArrWithCurrentTopGames() {
        return this.arrWithCurrentTopGames;
    }

    public final String getCurrentNick() {
        return this.currentNick;
    }

    public final void setCurrentNick(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentNick = str;
    }

    public final int getCurrentGamesId() {
        return this.currentGamesId;
    }

    public final void setCurrentGamesId(int i) {
        this.currentGamesId = i;
    }

    //@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/rockstargames/gtacr/gui/entertainmentSystem/GUIEntertainmentSystem$Companion;", "", "()V", "newInstance", "Lcom/rockstargames/gtacr/gui/entertainmentSystem/GUIEntertainmentSystem;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GUIEntertainmentSystem newInstance() {
            return new GUIEntertainmentSystem();
        }
    }

    @Override
    public void onPacketIncoming(JSONObject jSONObject) {
        GetAllStartParametersAndTransformationToCorrectType getAllStartParametersAndTransformationToCorrectType = this.transformJsonToCorrectType;
        if (getAllStartParametersAndTransformationToCorrectType != null && jSONObject != null) {
            if (jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_PLAYERS_PERIODICALLY) != null) {
                List<Integer> arrWithAllPlayers = getArrWithAllPlayers();
                arrWithAllPlayers.clear();
                arrWithAllPlayers.addAll(getAllStartParametersAndTransformationToCorrectType.getArrWithAllPlayers(jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_PLAYERS_PERIODICALLY)));
                UIGamesLayout uIGamesLayout = this.layoutGames;
                if (uIGamesLayout != null) {
                    uIGamesLayout.updatePlayersInLobby(getArrWithAllPlayers());
                }
            }
            if (jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_TOP_PLAYERS_0) != null) {
                getListWithTopPlayers0().addAll(getAllStartParametersAndTransformationToCorrectType.getListWithTopPlayers0(jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_TOP_PLAYERS_0)));
                UIPlayersTop uIPlayersTop = this.layoutTopPlayers;
                if (uIPlayersTop != null) {
                    uIPlayersTop.updateTopInfo(0, getCurrentGamesId());
                }
            }
            if (jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_TOP_PLAYERS_1) != null) {
                getListWithTopPlayers1().addAll(getAllStartParametersAndTransformationToCorrectType.getListWithTopPlayers1(jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_TOP_PLAYERS_1)));
                UIPlayersTop uIPlayersTop2 = this.layoutTopPlayers;
                if (uIPlayersTop2 != null) {
                    uIPlayersTop2.updateTopInfo(1, getCurrentGamesId());
                }
            }
            if (jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_TOP_PLAYERS_2) != null) {
                getListWithTopPlayers2().addAll(getAllStartParametersAndTransformationToCorrectType.getListWithTopPlayers2(jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_TOP_PLAYERS_2)));
                UIPlayersTop uIPlayersTop3 = this.layoutTopPlayers;
                if (uIPlayersTop3 != null) {
                    uIPlayersTop3.updateTopInfo(2, getCurrentGamesId());
                }
            }
            if (jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_TOP_PLAYERS_3) != null) {
                getListWithTopPlayers3().addAll(getAllStartParametersAndTransformationToCorrectType.getListWithTopPlayers3(jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_TOP_PLAYERS_3)));
                UIPlayersTop uIPlayersTop4 = this.layoutTopPlayers;
                if (uIPlayersTop4 != null) {
                    uIPlayersTop4.updateTopInfo(3, getCurrentGamesId());
                }
            }
            if (jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_TOP_PLAYERS_4) != null) {
                getListWithTopPlayers4().addAll(getAllStartParametersAndTransformationToCorrectType.getListWithTopPlayers4(jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_TOP_PLAYERS_4)));
                UIPlayersTop uIPlayersTop5 = this.layoutTopPlayers;
                if (uIPlayersTop5 != null) {
                    uIPlayersTop5.updateTopInfo(4, getCurrentGamesId());
                }
            }
            if (jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_TOP_PLAYERS_5) != null) {
                getListWithTopPlayers5().addAll(getAllStartParametersAndTransformationToCorrectType.getListWithTopPlayers5(jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_TOP_PLAYERS_5)));
                UIPlayersTop uIPlayersTop6 = this.layoutTopPlayers;
                if (uIPlayersTop6 != null) {
                    uIPlayersTop6.updateTopInfo(5, getCurrentGamesId());
                }
            }
            if (jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_CURRENT_TOP_POSITION) != null) {
                getArrWithCurrentTopPositions().addAll(getAllStartParametersAndTransformationToCorrectType.getArrWithCurrentTopPositions(jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_CURRENT_TOP_POSITION)));
                UIPlayersTop uIPlayersTop7 = this.layoutTopPlayers;
                if (uIPlayersTop7 != null) {
                    uIPlayersTop7.updateCurrentInfo(getCurrentGamesId());
                }
            }
            if (jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_CURRENT_TOP_GAMES) != null) {
                getArrWithCurrentTopGames().addAll(getAllStartParametersAndTransformationToCorrectType.getArrWithCurrentTopGames(jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_CURRENT_TOP_GAMES)));
                UIPlayersTop uIPlayersTop8 = this.layoutTopPlayers;
                if (uIPlayersTop8 != null) {
                    uIPlayersTop8.updateCurrentInfo(getCurrentGamesId());
                }
            }
        }
        Integer valueOf = jSONObject == null ? null : Integer.valueOf(jSONObject.optInt("t"));
        if (valueOf != null && valueOf.intValue() == 3) {
            this.isThePlayerClosed = false;
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow == null) {
                return;
            }
            popupWindow.dismiss();
        }
    }

    @Override
    public void show(JSONObject jSONObject, GUIManager gUIManager, NvEventQueueActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.context = activity;
        this.guiManager = gUIManager;
        this.transformJsonToCorrectType = new GetAllStartParametersAndTransformationToCorrectType();
        this.actionsWithJSON = new ActionsWithJSON(gUIManager);
        addAllData(jSONObject);
        if (this.popupWindow == null) {
            initialisationPopupWindow(activity);
            EntertainmentSystemMainBinding entertainmentSystemMainBinding = this.binding;
            if (entertainmentSystemMainBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                entertainmentSystemMainBinding = null;
            }
            entertainmentSystemMainBinding.buttonClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIEntertainmentSystem.m148show$lambda11$lambda4(GUIEntertainmentSystem.this, view);
                }
            });
            entertainmentSystemMainBinding.buttonBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIEntertainmentSystem.m150show$lambda11$lambda6(GUIEntertainmentSystem.this, view);
                }
            });
            entertainmentSystemMainBinding.buttonInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIEntertainmentSystem.m152show$lambda11$lambda8(GUIEntertainmentSystem.this, view);
                }
            });
            entertainmentSystemMainBinding.buttonTop.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIEntertainmentSystem.m146show$lambda11$lambda10(GUIEntertainmentSystem.this, view);
                }
            });
        }
        initialisationContainer();
        listenerLayout(0);
        UIGamesLayout uIGamesLayout = this.layoutGames;
        if (uIGamesLayout != null) {
            uIGamesLayout.updatePlayersInLobby(this.arrWithAllPlayers);
        }
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public final void onDismiss() {
                GUIEntertainmentSystem.m153show$lambda12(GUIEntertainmentSystem.this);
            }
        });
    }

    public static final void m148show$lambda11$lambda4(GUIEntertainmentSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (System.currentTimeMillis() - this$0.oldInfoTimer > 400) {
            this$0.oldInfoTimer = System.currentTimeMillis();
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    //GUIEntertainmentSystem.m149show$lambda11$lambda4$lambda3(GUIEntertainmentSystem.this);
                }
            }, 250L);
        }
    }

    public static final void m149show$lambda11$lambda4$lambda3(GUIEntertainmentSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public static final void m150show$lambda11$lambda6(GUIEntertainmentSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (System.currentTimeMillis() - this$0.oldInfoTimer > 400) {
            this$0.oldInfoTimer = System.currentTimeMillis();
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    //GUIEntertainmentSystem.m151show$lambda11$lambda6$lambda5(GUIEntertainmentSystem.this);
                }
            }, 250L);
        }
    }

    public static final void m151show$lambda11$lambda6$lambda5(GUIEntertainmentSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.listenerLayout(0);
        this$0.setVisibleForButtonBack(4);
    }

    public static final void m152show$lambda11$lambda8(GUIEntertainmentSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (System.currentTimeMillis() - this$0.oldInfoTimer > 400) {
            this$0.oldInfoTimer = System.currentTimeMillis();
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            UIGamesLayout uIGamesLayout = this$0.layoutGames;
            if (uIGamesLayout == null) {
                return;
            }
            this$0.openDialogInfo(uIGamesLayout.getGamesTitle(), uIGamesLayout.getActionsDescription());
        }
    }

    public static final void m146show$lambda11$lambda10(GUIEntertainmentSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (System.currentTimeMillis() - this$0.oldInfoTimer > 400) {
            this$0.oldInfoTimer = System.currentTimeMillis();
            Animation animation = this$0.anim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anim");
                animation = null;
            }
            view.startAnimation(animation);
            new Handler().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    //GUIEntertainmentSystem.m147show$lambda11$lambda10$lambda9(GUIEntertainmentSystem.this);
                }
            }, 250L);
        }
    }

    public static final void m147show$lambda11$lambda10$lambda9(GUIEntertainmentSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.listenerLayout(1);
        UIPlayersTop uIPlayersTop = this$0.layoutTopPlayers;
        if (uIPlayersTop != null) {
            uIPlayersTop.setInitialParameters(this$0.currentGamesId);
        }
        this$0.setVisibleForButtonBack(0);
        if (this$0.listWithTopPlayers0.size() == 0 || this$0.listWithTopPlayers1.size() == 0 || this$0.listWithTopPlayers2.size() == 0 || this$0.listWithTopPlayers3.size() == 0 || this$0.listWithTopPlayers4.size() == 0 || this$0.listWithTopPlayers5.size() == 0) {
            ActionsWithJSON actionsWithJSON = this$0.actionsWithJSON;
            if (actionsWithJSON == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                actionsWithJSON = null;
            }
            actionsWithJSON.sendPressButton(4);
        }
    }

    public static final void m153show$lambda12(GUIEntertainmentSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isThePlayerClosed) {
            ActionsWithJSON actionsWithJSON = this$0.actionsWithJSON;
            if (actionsWithJSON == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
                actionsWithJSON = null;
            }
            actionsWithJSON.sendPressButton(3);
        }
        NvEventQueueActivity nvEventQueueActivity = this$0.context;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        //nvEventQueueActivity.toggleDrawing2dStuff(false);
        PopupWindow popupWindow = this$0.popupWindowInfo;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        GUIManager gUIManager = this$0.guiManager;
        if (gUIManager == null) {
            return;
        }
        gUIManager.closeGUI(null, 42);
    }

    private final void initialisationPopupWindow(NvEventQueueActivity nvEventQueueActivity) {
        Object systemService = nvEventQueueActivity.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutInflater layoutInflater = (LayoutInflater) systemService;
        this.inflater = layoutInflater;
        NvEventQueueActivity nvEventQueueActivity2 = null;
        if (layoutInflater == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inflater");
            layoutInflater = null;
        }
        EntertainmentSystemMainBinding inflate = EntertainmentSystemMainBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        EntertainmentSystemMainBinding entertainmentSystemMainBinding = this.binding;
        if (entertainmentSystemMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemMainBinding = null;
        }
        this.popupWindow = new PopupWindow((View) entertainmentSystemMainBinding.getRoot(), -1, -1, true);
        NvEventQueueActivity nvEventQueueActivity3 = this.context;
        if (nvEventQueueActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            nvEventQueueActivity2 = nvEventQueueActivity3;
        }
        nvEventQueueActivity2.toggleDrawing2dStuff(true);
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            GUIManager.hideSystemUI(popupWindow.getContentView());
        }
        new Useful().closeAndroidsInterface(nvEventQueueActivity, this.popupWindow);
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 == null) {
            return;
        }
        popupWindow2.showAtLocation(nvEventQueueActivity.getParentLayout(), 17, 0, 0);
    }

    private final void initialisationContainer() {
        EntertainmentSystemMainBinding entertainmentSystemMainBinding = this.binding;
        NvEventQueueActivity nvEventQueueActivity = null;
        if (entertainmentSystemMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemMainBinding = null;
        }
        this.container = entertainmentSystemMainBinding.myContainer;
        NvEventQueueActivity nvEventQueueActivity2 = this.context;
        if (nvEventQueueActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity2 = null;
        }
        ActionsWithJSON actionsWithJSON = this.actionsWithJSON;
        if (actionsWithJSON == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionsWithJSON");
            actionsWithJSON = null;
        }
        UIGamesLayout uIGamesLayout = new UIGamesLayout(this, nvEventQueueActivity2, actionsWithJSON);
        this.layoutGames = uIGamesLayout;
        UIContainer uIContainer = this.container;
        if (uIContainer != null) {
            uIContainer.addLayout(0, uIGamesLayout);
        }
        NvEventQueueActivity nvEventQueueActivity3 = this.context;
        if (nvEventQueueActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            nvEventQueueActivity = nvEventQueueActivity3;
        }
        UIPlayersTop uIPlayersTop = new UIPlayersTop(this, nvEventQueueActivity);
        this.layoutTopPlayers = uIPlayersTop;
        UIContainer uIContainer2 = this.container;
        if (uIContainer2 != null) {
            uIContainer2.addLayout(1, uIPlayersTop);
        }
        this.listWithLayout.clear();
        this.listWithLayout.add(0);
        this.listWithLayout.add(1);
    }

    private final void listenerLayout(int i) {
        for (Integer num : this.listWithLayout) {
            if (i == num.intValue()) {
                UIContainer uIContainer = this.container;
                if (uIContainer == null) {
                    return;
                }
                uIContainer.setCurrentLayout(i);
                return;
            }
        }
    }

    public final void setVisibleForButtonInfo(int i) {
        EntertainmentSystemMainBinding entertainmentSystemMainBinding = this.binding;
        if (entertainmentSystemMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemMainBinding = null;
        }
        entertainmentSystemMainBinding.buttonInfo.setVisibility(i);
    }

    public final void setVisibleForButtonBack(int i) {
        EntertainmentSystemMainBinding entertainmentSystemMainBinding = this.binding;
        if (entertainmentSystemMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            entertainmentSystemMainBinding = null;
        }
        entertainmentSystemMainBinding.buttonBack.setVisibility(i);
    }

    private final void addAllData(JSONObject jSONObject) {
        GetAllStartParametersAndTransformationToCorrectType getAllStartParametersAndTransformationToCorrectType = this.transformJsonToCorrectType;
        if (getAllStartParametersAndTransformationToCorrectType == null || jSONObject == null) {
            return;
        }
        getArrWithAllPlayers().addAll(getAllStartParametersAndTransformationToCorrectType.getArrWithAllPlayers(jSONObject.optJSONArray(Utils.KEY_GET_ARR_WITH_PLAYERS_START)));
        String optString = jSONObject.optString(Utils.KEY_GET_ARR_WITH_CURRENT_TOP_NICK);
        Intrinsics.checkNotNullExpressionValue(optString, "json_.optString(KEY_GET_ARR_WITH_CURRENT_TOP_NICK)");
        setCurrentNick(optString);
    }

    private final void openDialogInfo(String str, String str2) {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        NvEventQueueActivity nvEventQueueActivity2 = null;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        Object systemService = nvEventQueueActivity.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        EntertainmentSystemDialogInfoBinding inflate = EntertainmentSystemDialogInfoBinding.inflate((LayoutInflater) systemService);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.bindingInfo = inflate;
        EntertainmentSystemDialogInfoBinding entertainmentSystemDialogInfoBinding = this.bindingInfo;
        if (entertainmentSystemDialogInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingInfo");
            entertainmentSystemDialogInfoBinding = null;
        }
        PopupWindow popupWindow = new PopupWindow((View) entertainmentSystemDialogInfoBinding.getRoot(), -1, -1, true);
        this.popupWindowInfo = popupWindow;
        if (popupWindow != null) {
            NvEventQueueActivity nvEventQueueActivity3 = this.context;
            if (nvEventQueueActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                nvEventQueueActivity3 = null;
            }
            popupWindow.showAtLocation(nvEventQueueActivity3.getParentLayout(), 17, 0, 0);
        }
        EntertainmentSystemDialogInfoBinding entertainmentSystemDialogInfoBinding2 = this.bindingInfo;
        if (entertainmentSystemDialogInfoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingInfo");
            entertainmentSystemDialogInfoBinding2 = null;
        }
        entertainmentSystemDialogInfoBinding2.dialogInfoButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GUIEntertainmentSystem.m143openDialogInfo$lambda18$lambda17(GUIEntertainmentSystem.this, view);
            }
        });
        entertainmentSystemDialogInfoBinding2.dialogInfoTitleItem.setText(str);
        entertainmentSystemDialogInfoBinding2.dialogInfoBodyItem.setText(str2);
        PopupWindow popupWindow2 = this.popupWindowInfo;
        if (popupWindow2 != null) {
            popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public final void onDismiss() {
                    GUIEntertainmentSystem.m145openDialogInfo$lambda19(GUIEntertainmentSystem.this);
                }
            });
        }
        Useful useful = new Useful();
        NvEventQueueActivity nvEventQueueActivity4 = this.context;
        if (nvEventQueueActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            nvEventQueueActivity2 = nvEventQueueActivity4;
        }
        useful.closeAndroidsInterface(nvEventQueueActivity2, this.popupWindowInfo);
    }

    public static final void m143openDialogInfo$lambda18$lambda17(GUIEntertainmentSystem this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animation animation = this$0.anim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anim");
            animation = null;
        }
        view.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                //GUIEntertainmentSystem.m144openDialogInfo$lambda18$lambda17$lambda16(GUIEntertainmentSystem.this);
            }
        }, 250L);
    }

    public static final void m144openDialogInfo$lambda18$lambda17$lambda16(GUIEntertainmentSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindowInfo;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public static final void m145openDialogInfo$lambda19(GUIEntertainmentSystem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Useful useful = new Useful();
        NvEventQueueActivity nvEventQueueActivity = this$0.context;
        if (nvEventQueueActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            nvEventQueueActivity = null;
        }
        useful.closeAndroidsInterface(nvEventQueueActivity, this$0.popupWindow);
    }

    @Override
    public void close(JSONObject jSONObject) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        PopupWindow popupWindow2 = this.popupWindowInfo;
        if (popupWindow2 == null) {
            return;
        }
        popupWindow2.dismiss();
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
