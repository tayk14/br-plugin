package com.rockstargames.gtacr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Html;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.TextView;
import blackrussia.online.Preferences;
import blackrussia.online.network.DonateItem;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.GUIBlackPassBanner;
import com.rockstargames.gtacr.gui.GUIDonate;
import com.rockstargames.gtacr.gui.GUIPlayersList;
import com.rockstargames.gtacr.gui.GUIRadialMenuForCar;
import com.rockstargames.gtacr.gui.GUISmiEditor;
import com.rockstargames.gtacr.gui.TutorialHints.GUITutorial;
import com.rockstargames.gtacr.gui.drivingSchool.GUIDrivingSchool;
import com.rockstargames.gtacr.gui.entertainmentSystem.GUIEntertainmentSystem;
import com.rockstargames.gtacr.gui.entertainmentSystem.GUIEntertainmentSystemFinalWindow;
import com.rockstargames.gtacr.gui.familySystem.GUIFamilySystem;
import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.fractions.GUIFractionSystem;
import com.rockstargames.gtacr.gui.halloween.GUIHalloween;
import com.rockstargames.gtacr.gui.halloween.GUIHalloweenGame;
import com.rockstargames.gtacr.gui.inventory.GUICarsTrunkOrCloset;
import com.rockstargames.gtacr.gui.inventory.GUIUsersInventory;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import com.rockstargames.gtacr.gui.registration.GUIRegistration;
import com.rockstargames.gtacr.gui.socialAction.GUISocialInteraction;
import com.rockstargames.gtacr.gui.socialNetworkLink.GUISocialNetworkLink;
import com.rockstargames.gtacr.gui.socialNetworkLink.SocialNetworkLinkUtils;
import com.rockstargames.gtacr.gui.socialNetworkLink.data.ServersObj;
import com.rockstargames.gtacr.gui.spawnLocation.GUISpawnLocation;
import com.rockstargames.gtacr.gui.tuning.GUITuning;
import com.rockstargames.gtacr.gui.vipAccount.GUIVipAccount;
import com.rockstargames.gtacr.gui.woundSystem.GUIWoundSystem;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class GUIManager {
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private native void initGUIManager();

    public static final int DIALOG_AUDIO = 9;
    public static final int DIALOG_CAPTCHA = 20;
    public static final int DIALOG_CAR_TRUNK = 34;
    public static final int DIALOG_CHOOSE_SERVER = 11;
    public static final int DIALOG_DANCE = 15;
    public static final int DIALOG_DINER = 3;
    public static final int DIALOG_DRIVING_SCHOOL = 37;
    public static final int DIALOG_ENTERTAINMENT_SYSTEM = 42;
    public static final int DIALOG_ENTERTAINMENT_SYSTEM_FINAL = 43;
    public static final int DIALOG_FAMILY_SYSTEM = 45;
    public static final int DIALOG_FINGERPRINT = 12;
    public static final int DIALOG_FRACTION_SYSTEM = 46;
    public static final int DIALOG_FUELFILL = 2;
    public static final int DIALOG_GRAPHIC_SETTINGS = 19;
    public static final int DIALOG_HACK = 4;
    public static final int DIALOG_HALLOWEEN = 30;
    public static final int DIALOG_HALLOWEEN_GAME = 31;
    public static final int DIALOG_MAP = 21;
    public static final int DIALOG_MENU = 14;
    public static final int DIALOG_NEW_CAPTCHA = 26;
    public static final int DIALOG_NY_BANNER = 35;
    public static final int DIALOG_PAUSEMENU = 47;
    public static final int DIALOG_PIPES = 8;
    public static final int DIALOG_PLATES = 1;
    public static final int DIALOG_PLAYER_LIST = 25;
    public static final int DIALOG_RADIAL_MENU = 27;
    public static final int DIALOG_REGISTRATION = 38;
    public static final int DIALOG_RENT = 6;
    public static final int DIALOG_ROBBERY = 5;
    public static final int DIALOG_SAWMILL = 23;
    public static final int DIALOG_SMI_EDITOR = 24;
    public static final int DIALOG_SOCIAL_INTERACTION = 36;
    public static final int DIALOG_SOCIAL_NETWORK_LINK = 52;
    public static final int DIALOG_SPAWN_LOCATION = 50;
    public static final int DIALOG_TAB = 32;
    public static final int DIALOG_TAXI = 16;
    public static final int DIALOG_TAXI_ORDER = 17;
    public static final int DIALOG_TAXI_RATING = 18;
    public static final int DIALOG_TUNING = 28;
    public static final int DIALOG_TUTORIAL = 39;
    public static final int DIALOG_TYPE_CREATE_EVERY_TIME = 3;
    public static final int DIALOG_TYPE_OFTEN = 1;
    public static final int DIALOG_TYPE_RARELY = 2;
    public static final int DIALOG_USER_INVENTORY = 33;
    public static final int DIALOG_VIP_ACCOUNT = 41;
    public static final int DIALOG_VOICE = 0;
    public static final int DIALOG_WEBVIEW = 51;
    public static final int DIALOG_WINDOW_SAMP = 10;
    public static final int DIALOG_WIRES = 7;
    public static final int DIALOG_WOUND_SYSTEM = 40;
    public static final int DONATE = 22;
    public static final int GUI_MAX = 256;
    public static final int NOTIFICATION = 13;
    private Boolean ifOpenedSNL = false;
    NvEventQueueActivity mActivity;
    private LinkedList<ISAMPGUI> mGUIStack;
    int[] mGUITypes;
    ISAMPGUI[] mGUIs;

    public boolean mIsPlayerSpawned = false;

    public static String getBCText() {
        return " BC";
    }

    public static String getRublesText() {
        return " ₽";
    }

    public void onGUIClosed(int guiid) {
    }

    public Boolean getGUIs(Integer id) {
        return Boolean.valueOf(this.mGUIs[id.intValue()] != null ? this.mGUIs[id.intValue()].isShowingGui() : false);
    }

    public static String getPriceText(DonateItem item) {
        if (item == null) {
            return getBCText();
        }
        if (item.getRubles() != null && item.getRubles().equals(1)) {
            return getRublesText();
        }
        return getBCText();
    }

    public static String getPriceFromInt(float number) {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.getDefault());
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');
        return new DecimalFormat("#,###,###", decimalFormatSymbols).format(number);
    }

    public static String getPriceFromInt(int number) {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.getDefault());
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');
        return new DecimalFormat("#,###,###", decimalFormatSymbols).format(number);
    }

    public static String getPriceWithSpaces(int number) {
        return new DecimalFormat("#,###,###", new DecimalFormatSymbols(Locale.getDefault())).format(number);
    }

    public static String getPriceWithSpacesForLong(long number) {
        return new DecimalFormat("#,###,###", new DecimalFormatSymbols(Locale.getDefault())).format(number);
    }

    public static View[] getChildViewsWithTag(Context context, View root, String tag, int count) {
        View[] viewArr = new View[count];
        for (int i = 0; i < count; i++) {
            viewArr[i] = root.findViewById(context.getResources().getIdentifier(tag + i, GetKeys.GET_PLAYERS_ID, context.getPackageName()));
        }
        return viewArr;
    }

    public static void makeAllViewsVisible(ViewGroup root) {
        root.setVisibility(0);
        for (int i = 0; i < root.getChildCount(); i++) {
            if (root.getChildAt(i) instanceof ViewGroup) {
                makeAllViewsVisible((ViewGroup) root.getChildAt(i));
            } else {
                root.getChildAt(i).setVisibility(0);
            }
        }
    }

    public static int getTextLength(TextView textView) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(textView.getTextSize());
        textPaint.setTypeface(textView.getTypeface());
        return (int) textPaint.measureText(textView.getText().toString());
    }

    public static void changeTextViewWidth(final TextView textView) {
        textView.post(new Runnable() { // from class: com.rockstargames.gtacr.GUIManager.1
            @Override // java.lang.Runnable
            public void run() {
                TextPaint textPaint = new TextPaint();
                textPaint.setTextSize(textView.getTextSize());
                textPaint.setTypeface(textView.getTypeface());
                textPaint.measureText(textView.getText().toString());
                StaticLayout staticLayout = new StaticLayout(textView.getText(), textPaint, 10000, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                int lineCount = staticLayout.getLineCount();
                float lineWidth = staticLayout.getLineWidth(0);
                for (int i = 0; i < lineCount; i++) {
                    if (staticLayout.getLineWidth(i) >= lineWidth) {
                        lineWidth = staticLayout.getLineWidth(i) + 5.0f;
                    }
                }
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                layoutParams.width = (int) lineWidth;
                textView.setLayoutParams(layoutParams);
            }
        });
    }

    public static Spanned transfromColors(String str) {
        int i;
        if (str == null) {
            str = "";
        }
        LinkedList linkedList = new LinkedList();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (str.charAt(i4) == '{' && (i = i4 + 7) < str.length()) {
                String str2 = new String() + "#";
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                int i5 = i4 + 1;
                sb.append(str.substring(i5, i));
                linkedList.addLast(sb.toString());
                str = str.substring(0, i5) + "repl" + i3 + str.substring(i, str.length());
                i3++;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (i2 == 0) {
                String quote = Pattern.quote(new String() + "{repl" + i2 + "}");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("<font color='");
                sb2.append(str3);
                sb2.append("'>");
                str = str.replaceAll(quote, sb2.toString());
            } else {
                String quote2 = Pattern.quote(new String() + "{repl" + i2 + "}");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("</font><font color='");
                sb3.append(str3);
                sb3.append("'>");
                str = str.replaceAll(quote2, sb3.toString());
            }
            i2++;
        }
        if (linkedList.size() >= 1) {
            str = str + "</font>";
        }
        return Html.fromHtml(str.replaceAll(Pattern.quote("\n"), "<br>"));
    }

    private void setGuiType(int id, int type) {
        this.mGUITypes[id] = type;
    }

    public ISAMPGUI createGuiFromId(int id) {
        switch (id) {
            case 0:
                return BrDialogVoice.newInstance();
            case 1:
                return BrDialogPlates.newInstance();
            case 2:
                return BrDialogFuelFill.newInstance();
            case 3:
                return BrDialogDiner.newInstance();
            case 4:
                return BrDialogHack.newInstance();
            case 5:
                return BrDialogRobbery.newInstance();
            case 6:
                return BrDialogRent.newInstance();
            case 7:
                return BrDialogWires.newInstance();
            case 8:
                return BrDialogPipes.newInstance();
            case 9:
                return BrAudioDialog.newInstance();
            case 10:
                return BrDialogWindow.newInstance();
            case 11:
                return BrChooseServerDialog.newInstance();
            case 12:
                return BrFingerPrintDialog.newInstance();
            case 13:
                return BrNotification.newInstance();
            case 14:
                return BrDialogMenu.newInstance();
            case 15:
                return BrDialogDance.newInstance();
            case 16:
                return BrDialogTaxi.newInstance();
            case 17:
                return BrDialogTaxiOrder.newInstance();
            case 18:
                return BrDialogTaxiRating.newInstance();
            case 19:
                return BrDialogGraphicsSettings.newInstance();
            case 20:
                return BrCaptcha.newInstance();
            case 21:
                return BrDialogMap.newInstance();
            case 22:
                return GUIDonate.newInstance();
            case 23:
                return BrDialogSawmill.newInstance();
            case 24:
                return GUISmiEditor.newInstance();
            case 25:
                return GUIPlayersList.newInstance();
            case 26:
                return BrNewCaptcha.newInstance();
            case 27:
                return GUIRadialMenuForCar.newInstance();
            case 28:
                return GUITuning.newInstance();
            case 29:
            case 32:
            case 44:
            case 47:
            case 48:
            case 49:
            case 51:
            default:
                return null;
            case 30:
                return GUIHalloween.newInstance();
            case 31:
                return GUIHalloweenGame.newInstance();
            case 33:
                return GUIUsersInventory.Companion.newInstance();
            case 34:
                return GUICarsTrunkOrCloset.Companion.newInstance();
            case 35:
                return GUIBlackPassBanner.newInstance();
            case 36:
                return GUISocialInteraction.Companion.newInstance();
            case 37:
                return GUIDrivingSchool.Companion.newInstance();
            case 38:
                return GUIRegistration.newInstance();
            case 39:
                return GUITutorial.newInstance();
            case 40:
                return GUIWoundSystem.Companion.newInstance();
            case 41:
                return GUIVipAccount.newInstance();
            case 42:
                return GUIEntertainmentSystem.newInstance();
            case 43:
                return GUIEntertainmentSystemFinalWindow.newInstance();
            case 45:
                return GUIFamilySystem.newInstance();
            case 46:
                return GUIFractionSystem.newInstance();
            case 50:
                return GUISpawnLocation.newInstance();
            case 52:
                return GUISocialNetworkLink.newInstance();
        }
    }

    public GUIManager(NvEventQueueActivity activity) {
        initGUIManager();

        this.mActivity = null;
        this.mGUIs = null;
        this.mGUITypes = null;
        this.mGUIStack = null;
        this.mActivity = activity;
        this.mGUIs = new ISAMPGUI[256];
        this.mGUITypes = new int[256];
        this.mGUIStack = new LinkedList<>();
        setGuiType(0, 2);
        setGuiType(1, 2);
        setGuiType(2, 2);
        setGuiType(3, 2);
        setGuiType(4, 2);
        setGuiType(5, 2);
        setGuiType(6, 2);
        setGuiType(8, 2);
        setGuiType(7, 2);
        setGuiType(9, 2);
        setGuiType(12, 2);
        setGuiType(13, 3);
        setGuiType(14, 1);
        setGuiType(15, 2);
        setGuiType(16, 2);
        setGuiType(17, 2);
        setGuiType(18, 2);
        setGuiType(20, 2);
        setGuiType(21, 2);
        setGuiType(23, 2);
        setGuiType(26, 2);
        setGuiType(10, 1);
        setGuiType(11, 2);
        setGuiType(19, 2);
        setGuiType(30, 2);
        setGuiType(31, 2);
        setGuiType(22, 2);
        setGuiType(28, 2);
        setGuiType(25, 2);
        setGuiType(27, 2);
        setGuiType(24, 2);
        setGuiType(33, 2);
        setGuiType(34, 2);
        setGuiType(35, 2);
        setGuiType(36, 2);
        setGuiType(37, 2);
        setGuiType(38, 2);
        setGuiType(39, 2);
        setGuiType(40, 2);
        setGuiType(41, 2);
        setGuiType(42, 2);
        setGuiType(43, 2);
        setGuiType(45, 2);
        setGuiType(46, 2);
        setGuiType(52, 2);
        setGuiType(50, 2);
    }

    public void onPacketIncoming(int guiid, JSONObject data) {
        if (guiid >= 256 || guiid < 0) {
            return;
        }
        if (data.optInt("o") == 1) {
            if (guiid == 38) {
                Preferences.putObject(this.mActivity, SocialNetworkLinkUtils.KEY_BUTTON_STATUS, data.optJSONArray(SocialNetworkLinkUtils.KEY_BUTTON_STATUS));
            }
            showGUI(guiid, data);
            return;
        }
        if (data.optInt(Const.FRACTION_CLOSE_KEY) != 1 || this.mGUIs[guiid] == null) {
            ISAMPGUI[] isampguiArr = this.mGUIs;
            if (isampguiArr[guiid] != null) {
                isampguiArr[guiid].onPacketIncoming(data);
                return;
            }
            return;
        }
        if (guiid != 10) {
            closeGUI(data, guiid);
        } else {
            closeSAMPWindow(data);
        }
    }

    public void sendJsonData(int guiid, JSONObject object) {
        try {
            byte[] bytes = object.toString().getBytes("windows-1251");
            if (bytes == null) {
                return;
            }
            if (guiid == 38) {
                this.mActivity.sendRegerdsJsonData(guiid, bytes);
            } else {
                this.mActivity.sendJsonData(guiid, bytes);
            }
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    public void closeSAMPWindow(JSONObject json) {
        if (this.mGUIStack.size() == 0) {
            return;
        }
        for (int i = 0; i < this.mGUIStack.size(); i++) {
            ISAMPGUI isampgui = this.mGUIStack.get(i);
            if (this.mGUIs[10] == isampgui) {
                isampgui.close(json);
                this.mGUIStack.remove(isampgui);
                return;
            }
        }
    }

    public void closeAllWindows() {
        if (this.mGUIStack.size() == 0) {
            return;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.rockstargames.gtacr.GUIManager.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < GUIManager.this.mGUIStack.size(); i++) {
                    ((ISAMPGUI) GUIManager.this.mGUIStack.get(i)).close(jSONObject);
                }
                GUIManager.this.mGUIStack.clear();
            }
        });
    }

    public void closeAllWindowsExSAMP() {
        if (this.mGUIStack.size() == 0) {
            return;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.rockstargames.gtacr.GUIManager.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < GUIManager.this.mGUIStack.size(); i++) {
                    ISAMPGUI isampgui = (ISAMPGUI) GUIManager.this.mGUIStack.get(i);
                    if (isampgui != GUIManager.this.mGUIs[10]) {
                        isampgui.close(jSONObject);
                    }
                }
                GUIManager.this.mGUIStack.clear();
            }
        });
    }

    public void closeGUI(JSONObject json, int guiId) {
//        this.mHandler.post(() -> {
//            if (json != null && json.optInt("not") == 1) {
//                BrNotification.closeNotificationById(json.optInt("b"));
//                return;
//            }
//            if (this.mGUIStack.size() != 0) {
//                ISAMPGUI[] isampguiArr = this.mGUIs;
//                if (isampguiArr[guiId] != null) {
//
//                }
//            }
//        });

        this.mHandler.post(() -> {
            this.mGUIs[guiId].close(json);
            this.mGUIStack.remove(this.mGUIs[guiId]);
            this.mGUIs[guiId] = null;
        });
    }

    public void notifyGUIClosed(int guiid, JSONObject json) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Const.FRACTION_CLOSE_KEY, 1);
            sendJsonData(guiid, jSONObject);
        } catch (Exception unused) {
        }
    }

    public void onSpawn() {
        final Handler handler = new Handler(Looper.getMainLooper());
        new Thread(new Runnable() { // from class: com.rockstargames.gtacr.-$$Lambda$GUIManager$tsvhkMkRTyK-9EsdinpV_U0TDj0
            @Override // java.lang.Runnable
            public final void run() {
                GUIManager.this.lambda$onSpawn$1$GUIManager(handler);
            }
        }).start();
    }

    public /* synthetic */ void lambda$onSpawn$1$GUIManager(final Handler handler_) {
        while (!this.ifOpenedSNL.booleanValue()) {
            SystemClock.sleep(7000L);
            if (!this.ifOpenedSNL.booleanValue()) {
                handler_.post(new Runnable() { // from class: com.rockstargames.gtacr.-$$Lambda$GUIManager$EyagvNfpG9NAAZkNEIyLNK5OAJo
                    @Override // java.lang.Runnable
                    public final void run() {
                        GUIManager.this.lambda$null$0$GUIManager();
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$null$0$GUIManager() {
        if (getGUIs(35).booleanValue() || getGUIs(10).booleanValue()) {
            return;
        }
        getArrayAndOpenSocialNetworkLink();
    }

    private void getArrayAndOpenSocialNetworkLink() {
        this.ifOpenedSNL = true;
        ServersObj serversObj = (ServersObj) Preferences.getObject(this.mActivity, "status", ServersObj.class);
        if (serversObj != null) {
            for (int i = 0; i < serversObj.getServerWithoutDisplay().size(); i++) {
                if (serversObj.getServerWithoutDisplay().get(i).intValue() == this.mActivity.getCurrServer()) {
                    return;
                }
            }
        }
        JSONArray jSONArray = (JSONArray) Preferences.getObject(this.mActivity, SocialNetworkLinkUtils.KEY_BUTTON_STATUS, JSONArray.class);
        if (jSONArray != null && jSONArray.length() == 2) {
            try {
                if (((Double) jSONArray.get(0)).doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    if (((Double) jSONArray.get(1)).doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("o", 1);
            jSONObject.put(SocialNetworkLinkUtils.KEY_BUTTON_STATUS, jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        onPacketIncoming(52, jSONObject);
    }

    public static void hideSystemUI(Window window) {
        hideSystemUI(window.getDecorView());
    }

    public static void hideSystemUI(View view) {
        view.setSystemUiVisibility(7942);
    }

    public static void hideSystemUIver2(View view) {
        if (Build.VERSION.SDK_INT > 29) {
            view.setSystemUiVisibility(6150);
        } else {
            view.setSystemUiVisibility(6662);
        }
    }

    public boolean isShowingGui() {
        if (BrNotification.mActiveNotifications > 0) {
            return true;
        }
        if (this.mGUIStack.size() == 0) {
            return false;
        }
        return this.mGUIStack.peek().isShowingGui();
    }

    public void showGUI(int guiid, JSONObject json) {
        this.mHandler.post(() -> {
            if (guiid == 51) {
                this.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(json.optString("s"))));
                return;
            }
            if (this.mGUITypes[guiid] == 3) {
                createGuiFromId(guiid).show(json, this, this.mActivity);
                return;
            }
            ISAMPGUI[] isampguiArr = this.mGUIs;
            if (isampguiArr[guiid] == null) {
                this.mGUIs[guiid] = createGuiFromId(guiid);
            } else {
                isampguiArr[guiid].close(null);
                if (this.mGUITypes[guiid] == 2) {
                    this.mGUIs[guiid] = null;
                    this.mGUIs[guiid] = createGuiFromId(guiid);
                }
            }
            this.mGUIStack.remove(this.mGUIs[guiid]);
            this.mGUIStack.push(this.mGUIs[guiid]);
            this.mGUIs[guiid].show(json, this, this.mActivity);
        });
    }

    public void setCustomTouchInterceptor(PopupWindow window) {
        window.setTouchInterceptor(new View.OnTouchListener() { // from class: com.rockstargames.gtacr.GUIManager.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    return motionEvent.getX() < 0.0f || motionEvent.getX() > ((float) view.getWidth()) || motionEvent.getY() < 0.0f || motionEvent.getY() > ((float) view.getHeight());
                }
                return false;
            }
        });
    }
}
