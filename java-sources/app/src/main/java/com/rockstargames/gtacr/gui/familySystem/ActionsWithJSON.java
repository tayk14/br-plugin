package com.rockstargames.gtacr.gui.familySystem;

import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

//@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bJ\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bJ\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0013J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\bJ\u001e\u0010\"\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bJ\u0016\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bJ\u000e\u0010'\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\bJ\u000e\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\bJ\u000e\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\bJ\u000e\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;", "", "guiManager", "Lcom/rockstargames/gtacr/GUIManager;", "(Lcom/rockstargames/gtacr/GUIManager;)V", "buyItemInShop", "", "itemsId", "", "buyToken", "valueOfToken", "clickOnAccess", "ranksPosition", "accessPosition", "accessStatus", "clickOnCar", "modelId", "clickOnRank", "ranksName", "", "getPlayersInfo", "playersNick", "openLog", "openStore", "ifSafeOrStore", "sendDeleteNotification", "thisNotificationId", "sendGetLayout", "typeKey", "sendMessageError", "message", "sendMessageForServer", "thisMessage", "sendPressButton", "setActionWithCar", "currentAction", "access", "setActionWithPlayer", "actionsType", "setClickOnStore", "setMenuPosition", "menuId", "setStartColor", "colorsPosition", "setUpgradeForFamily", "upgradeId", "startQuest", "questsId", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActionsWithJSON {
    private final GUIManager guiManager;

    public ActionsWithJSON(GUIManager gUIManager) {
        this.guiManager = gUIManager;
    }

    public final void sendPressButton(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendGetLayout(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void startQuest(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 1);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void clickOnCar(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 2);
            jSONObject.put("s", 1);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void setActionWithCar(int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 2);
            jSONObject.put("s", 2);
            jSONObject.put("m", i);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, i2);
            if (i3 != -1) {
                jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, i3);
            }
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void buyItemInShop(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 3);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void setUpgradeForFamily(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 4);
            jSONObject.put("s", 1);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void setMenuPosition(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 5);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void clickOnRank(int i, String ranksName) {
        Intrinsics.checkNotNullParameter(ranksName, "ranksName");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 5);
            jSONObject.put("s", 1);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, 1);
            jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, i);
            jSONObject.put("n", ranksName);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void getPlayersInfo(String playersNick) {
        Intrinsics.checkNotNullParameter(playersNick, "playersNick");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 5);
            jSONObject.put("s", 1);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, 2);
            jSONObject.put("n", playersNick);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void clickOnAccess(int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 5);
            jSONObject.put("s", 2);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, 1);
            jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, i);
            jSONObject.put(TuningConstants.KEY_GET_DETAILS_LIST_WITH_COST_AND_STATUS, i2);
            jSONObject.put("n", i3);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void setActionWithPlayer(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 5);
            jSONObject.put("s", 2);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, 2);
            jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, i);
            if (i2 != 2) {
                jSONObject.put(TuningConstants.KEY_GET_DETAILS_LIST_WITH_COST_AND_STATUS, i2);
            }
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void setStartColor(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 5);
            jSONObject.put("s", 3);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, 1);
            jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void setClickOnStore(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 5);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, 3);
            jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void openStore(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 5);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, 3);
            jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, i);
            jSONObject.put("s", 1);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void openLog() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 5);
            jSONObject.put(GetKeys.GET_PLAYERS_ID, 4);
            jSONObject.put("s", 1);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendMessageForServer(String thisMessage) {
        Intrinsics.checkNotNullParameter(thisMessage, "thisMessage");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 6);
            jSONObject.put("b", 1);
            jSONObject.put("m", thisMessage);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendDeleteNotification(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 6);
            jSONObject.put("b", 2);
            jSONObject.put("x", i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void buyToken(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 9);
            jSONObject.put("s", 2);
            jSONObject.put("v", i);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.sendJsonData(45, jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void sendMessageError(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("o", 1);
            jSONObject.put("t", 2);
            jSONObject.put("d", 2);
            jSONObject.put("i", message);
            jSONObject.put("s", -1);
            GUIManager gUIManager = this.guiManager;
            if (gUIManager == null) {
                return;
            }
            gUIManager.onPacketIncoming(13, jSONObject);
        } catch (Exception unused) {
        }
    }
}
