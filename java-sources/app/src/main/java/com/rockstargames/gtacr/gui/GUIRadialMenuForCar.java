package com.rockstargames.gtacr.gui;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import blackrussia.online.R;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import org.json.JSONArray;
import org.json.JSONObject;

public class GUIRadialMenuForCar implements ISAMPGUI {
    private static final int COMFORT_PLUS = 9;
    private static final int DISMISS_WINDOW = 0;
    private static final int DOORS = 3;
    private static final int DRIFT = 8;
    private static final int ENGINE = 6;
    private static final int HEADLIGHT = 14;
    private static final int HIGH_LIGHT = 13;
    private static final int HYDRAULIC = 19;
    private static final int KEY = 2;
    private static final String KEY_ACTION_TYPE = "t";
    private static final String KEY_GET_DATA = "s";
    private static final int LAUNCH_CONTROL = 5;
    private static final String LOG = "LOG_VIEW";
    private static final int NEON = 12;
    private static final int PARKING = 1;
    private static final int PNEWMO_1 = 16;
    private static final int PNEWMO_2 = 17;
    private static final int PNEWMO_3 = 18;
    private static final int SPORT = 10;
    private static final int SPORT_PLUS = 11;
    private static final int STROBOSCOPE = 15;
    private static final int SUSPENSION = 4;
    private static final int TURBO = 7;
    private static final int TYPE_BOAT = 4;
    private static final int TYPE_HELI = 3;
    private static final int TYPE_PLANE = 5;
    private static final int TYPE_TRAILER = 8;
    ImageView bgControlAndSuspension;
    ImageView bgDoorAndLight;
    ImageView bgLightSubmenu;
    ImageView bgSuspensionSubmenu;
    ImageView bgTurboAndEngine;
    ImageView bgTurboSubmenu;
    ImageView buttonClose;
    ImageView buttonComfortPlus;
    ImageView buttonDoor;
    ImageView buttonDrift;
    ImageView buttonEngine;
    ImageView buttonHeadLights;
    ImageView buttonHighLight;
    ImageView buttonHydraulics;
    ImageView buttonKey;
    ImageView buttonLaunchControl;
    ImageView buttonLight;
    ImageView buttonNeon;
    ImageView buttonParking;
    ImageView buttonPnevmo1;
    ImageView buttonPnevmo2;
    ImageView buttonPnevmo3;
    ImageView buttonSport;
    ImageView buttonSportPlus;
    ImageView buttonStroboscope;
    ImageView buttonSuspension;
    ImageView buttonTurbo;
    private NvEventQueueActivity context = null;
    private View rootView = null;
    private PopupWindow popupWindow = null;
    private GUIManager guiManager = null;
    private Animation anim = null;
    private boolean isClickParking = false;
    private boolean isClickKey = false;
    private boolean isClickTurbo = false;
    private boolean isClickEngine = false;
    private boolean isClickDoor = false;
    private boolean isClickLight = false;
    private boolean isClickSuspension = false;
    private boolean isClickLaunchControl = false;
    private boolean isClickDrift = false;
    private boolean isClickComfortPlus = false;
    private boolean isClickSportPlus = false;
    private boolean isClickSport = false;
    private boolean isClickNeon = false;
    private boolean isClickHighLight = false;
    private boolean isClickHeadlights = false;
    private boolean isClickStroboscope = false;
    private boolean isClickPnevmo1 = false;
    private boolean isClickPnevmo2 = false;
    private boolean isClickPnevmo3 = false;
    private boolean isClickHydraulics = false;

    @Override
    public int getGuiId() {
        return 27;
    }

    public static ISAMPGUI newInstance() {
        return new GUIRadialMenuForCar();
    }

    @Override
    public void onPacketIncoming(JSONObject json) {
        Log.v(LOG, "send for server: " + json.toString());
        int optInt = json.optInt("t");
        boolean z = json.optInt("s") != 0;
        switch (optInt) {
            case 1:
                parkingSetClickIsNowNotClickable(z);
                return;
            case 2:
                keySetClickIsNowNotClickable(z);
                return;
            case 3:
                doorSetClickIsNowNotClickable(z);
                return;
            case 4:
            case 7:
            default:
                return;
            case 5:
                launchSetClickIsNowNotClickable(z);
                return;
            case 6:
                engineSetClickIsNowNotClickable(z);
                return;
            case 8:
                driftSetClickIsNowNotClickable(z);
                turboSetClickableIsClickableInSubmenu();
                return;
            case 9:
                comfortPlusSetClickIsNowNotClickable(z);
                turboSetClickableIsClickableInSubmenu();
                return;
            case 10:
                sportSetClickIsNowNotClickable(z);
                turboSetClickableIsClickableInSubmenu();
                return;
            case 11:
                sportPlusSetClickIsNowNotClickable(z);
                turboSetClickableIsClickableInSubmenu();
                return;
            case 12:
                neonSetClickIsNowNotClickable(z);
                lightSetClickableIsClickableInSubmenu();
                return;
            case 13:
                highLightSetClickIsNowNotClickable(z);
                lightSetClickableIsClickableInSubmenu();
                return;
            case 14:
                headlightsSetClickIsNowNotClickable(z);
                lightSetClickableIsClickableInSubmenu();
                return;
            case 15:
                stroboscopeSetClickIsNowNotClickable(z);
                lightSetClickableIsClickableInSubmenu();
                return;
            case 16:
                pnevmo1SetClickIsNowNotClickable(z);
                suspensionSetClickableIsClickableInSubmenu();
                return;
            case 17:
                pnevmo2SetClickIsNowNotClickable(z);
                suspensionSetClickableIsClickableInSubmenu();
                return;
            case 18:
                pnevmo3SetClickIsNowNotClickable(z);
                suspensionSetClickableIsClickableInSubmenu();
                return;
            case 19:
                hydraulicsSetClickIsNowNotClickable(z);
                suspensionSetClickableIsClickableInSubmenu();
                return;
        }
    }

    @Override
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.context = activity;
        this.guiManager = manager;
        if (this.popupWindow == null) {
            Log.v(LOG, json.toString());
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.radial_menu_dialog, (ViewGroup) null, false);
            this.rootView = inflate;
            this.buttonClose = (ImageView) inflate.findViewById(R.id.radial_close);
            this.buttonParking = (ImageView) this.rootView.findViewById(R.id.button_parking);
            this.buttonKey = (ImageView) this.rootView.findViewById(R.id.button_key);
            this.buttonDoor = (ImageView) this.rootView.findViewById(R.id.button_door);
            this.buttonLaunchControl = (ImageView) this.rootView.findViewById(R.id.button_launch_control);
            this.buttonEngine = (ImageView) this.rootView.findViewById(R.id.button_engine);
            this.buttonTurbo = (ImageView) this.rootView.findViewById(R.id.button_turbo);
            this.buttonLight = (ImageView) this.rootView.findViewById(R.id.button_light);
            this.buttonSuspension = (ImageView) this.rootView.findViewById(R.id.button_suspension);
            this.buttonDrift = (ImageView) this.rootView.findViewById(R.id.button_drift);
            this.buttonComfortPlus = (ImageView) this.rootView.findViewById(R.id.button_comfort_plus);
            this.buttonSportPlus = (ImageView) this.rootView.findViewById(R.id.button_sport_plus);
            this.buttonSport = (ImageView) this.rootView.findViewById(R.id.button_sport);
            this.buttonNeon = (ImageView) this.rootView.findViewById(R.id.button_neon);
            this.buttonHighLight = (ImageView) this.rootView.findViewById(R.id.button_high_light);
            this.buttonHeadLights = (ImageView) this.rootView.findViewById(R.id.button_headlights);
            this.buttonStroboscope = (ImageView) this.rootView.findViewById(R.id.button_stroboscope);
            this.buttonPnevmo1 = (ImageView) this.rootView.findViewById(R.id.button_pnevmo1);
            this.buttonPnevmo2 = (ImageView) this.rootView.findViewById(R.id.button_pnevmo2);
            this.buttonPnevmo3 = (ImageView) this.rootView.findViewById(R.id.button_pnevmo3);
            this.buttonHydraulics = (ImageView) this.rootView.findViewById(R.id.button_hydraulics);
            this.bgTurboAndEngine = (ImageView) this.rootView.findViewById(R.id.bg_turbo_engine);
            this.bgDoorAndLight = (ImageView) this.rootView.findViewById(R.id.bg_door_light);
            this.bgControlAndSuspension = (ImageView) this.rootView.findViewById(R.id.bg_control_suspension);
            this.bgLightSubmenu = (ImageView) this.rootView.findViewById(R.id.bg_light_submenu);
            this.bgSuspensionSubmenu = (ImageView) this.rootView.findViewById(R.id.bg_suspension_submenu);
            this.bgTurboSubmenu = (ImageView) this.rootView.findViewById(R.id.bg_turbo_submenu);
            this.popupWindow = new PopupWindow(this.rootView, -1, -1, true);
            this.anim = AnimationUtils.loadAnimation(this.context, R.anim.button_click);
            this.buttonClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$1$GUIRadialMenuForCar(view);
                }
            });
            getData(json);
            this.buttonParking.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$2$GUIRadialMenuForCar(view);
                }
            });
            this.buttonKey.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$3$GUIRadialMenuForCar(view);
                }
            });
            this.buttonDoor.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$4$GUIRadialMenuForCar(view);
                }
            });
            this.buttonLaunchControl.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$5$GUIRadialMenuForCar(view);
                }
            });
            this.buttonEngine.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$6$GUIRadialMenuForCar(view);
                }
            });
            this.buttonTurbo.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$7$GUIRadialMenuForCar(view);
                }
            });
            this.buttonLight.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$8$GUIRadialMenuForCar(view);
                }
            });
            this.buttonSuspension.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$9$GUIRadialMenuForCar(view);
                }
            });
            this.buttonDrift.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$10$GUIRadialMenuForCar(view);
                }
            });
            this.buttonComfortPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$11$GUIRadialMenuForCar(view);
                }
            });
            this.buttonSport.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$12$GUIRadialMenuForCar(view);
                }
            });
            this.buttonSportPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$13$GUIRadialMenuForCar(view);
                }
            });
            this.buttonNeon.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$14$GUIRadialMenuForCar(view);
                }
            });
            this.buttonHighLight.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$15$GUIRadialMenuForCar(view);
                }
            });
            this.buttonHeadLights.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$16$GUIRadialMenuForCar(view);
                }
            });
            this.buttonStroboscope.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$17$GUIRadialMenuForCar(view);
                }
            });
            this.buttonPnevmo1.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$18$GUIRadialMenuForCar(view);
                }
            });
            this.buttonPnevmo2.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$19$GUIRadialMenuForCar(view);
                }
            });
            this.buttonPnevmo3.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$20$GUIRadialMenuForCar(view);
                }
            });
            this.buttonHydraulics.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    GUIRadialMenuForCar.this.lambda$show$21$GUIRadialMenuForCar(view);
                }
            });
            this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    GUIRadialMenuForCar.this.sendServerThisOperation(0);
                    GUIRadialMenuForCar.this.guiManager.closeGUI(null, 27);
                }
            });
            //this.context.toggleDrawing2dStuff(true);
            this.popupWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
            GUIManager.hideSystemUI(this.popupWindow.getContentView());
        }
    }

    public void lambda$show$1$GUIRadialMenuForCar(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                GUIRadialMenuForCar.this.lambda$null$0$GUIRadialMenuForCar();
            }
        }, 200L);
    }

    public void lambda$null$0$GUIRadialMenuForCar() {
        //this.context.toggleDrawing2dStuff(false);
        this.popupWindow.dismiss();
    }

    public void lambda$show$2$GUIRadialMenuForCar(View view) {
        sendServerThisOperation(1);
    }

    public void lambda$show$3$GUIRadialMenuForCar(View view) {
        sendServerThisOperation(2);
    }

    public void lambda$show$4$GUIRadialMenuForCar(View view) {
        sendServerThisOperation(3);
    }

    public void lambda$show$5$GUIRadialMenuForCar(View view) {
        sendServerThisOperation(5);
    }

    public void lambda$show$6$GUIRadialMenuForCar(View view) {
        sendServerThisOperation(6);
    }

    public void lambda$show$7$GUIRadialMenuForCar(View view) {
        if (this.context.getPlayerVehicleType() == 3 || this.context.getPlayerVehicleType() == 4 || this.context.getPlayerVehicleType() == 5 || this.context.getPlayerVehicleType() == 8) {
            showMessageError();
        } else if (!this.isClickTurbo) {
            this.isClickTurbo = true;
            this.bgTurboAndEngine.setImageResource(R.drawable.radial_bg_turbo_engine_and_submenu);
            setVisibilityForTurbo(0);
        } else {
            this.isClickTurbo = false;
            this.bgTurboAndEngine.setImageResource(R.drawable.radial_bg_turbo_engine);
            setVisibilityForTurbo(4);
        }
    }

    public void lambda$show$8$GUIRadialMenuForCar(View view) {
        if (!this.isClickLight) {
            this.isClickLight = true;
            this.bgDoorAndLight.setImageResource(R.drawable.radial_bg_door_light_and_submenu);
            setVisibilityForLight(0);
            return;
        }
        this.isClickLight = false;
        this.bgDoorAndLight.setImageResource(R.drawable.radial_bg_door_light);
        setVisibilityForLight(4);
    }

    public void lambda$show$9$GUIRadialMenuForCar(View view) {
        if (this.context.getPlayerVehicleType() == 3 || this.context.getPlayerVehicleType() == 4 || this.context.getPlayerVehicleType() == 5 || this.context.getPlayerVehicleType() == 8) {
            showMessageError();
        } else if (!this.isClickSuspension) {
            this.isClickSuspension = true;
            this.bgControlAndSuspension.setImageResource(R.drawable.radial_bg_control_suspension_and_submenu);
            setVisibilityForSuspension(0);
        } else {
            this.isClickSuspension = false;
            this.bgControlAndSuspension.setImageResource(R.drawable.radial_bg_control_suspension);
            setVisibilityForSuspension(4);
        }
    }

    public void lambda$show$10$GUIRadialMenuForCar(View view) {
        turboSetClickableIsClickableInSubmenu();
        sendServerThisOperation(8);
    }

    public void lambda$show$11$GUIRadialMenuForCar(View view) {
        turboSetClickableIsClickableInSubmenu();
        sendServerThisOperation(9);
    }

    public void lambda$show$12$GUIRadialMenuForCar(View view) {
        turboSetClickableIsClickableInSubmenu();
        sendServerThisOperation(10);
    }

    public void lambda$show$13$GUIRadialMenuForCar(View view) {
        turboSetClickableIsClickableInSubmenu();
        sendServerThisOperation(11);
    }

    public void lambda$show$14$GUIRadialMenuForCar(View view) {
        lightSetClickableIsClickableInSubmenu();
        sendServerThisOperation(12);
    }

    public void lambda$show$15$GUIRadialMenuForCar(View view) {
        lightSetClickableIsClickableInSubmenu();
        sendServerThisOperation(13);
    }

    public void lambda$show$16$GUIRadialMenuForCar(View view) {
        lightSetClickableIsClickableInSubmenu();
        sendServerThisOperation(14);
    }

    public void lambda$show$17$GUIRadialMenuForCar(View view) {
        lightSetClickableIsClickableInSubmenu();
        sendServerThisOperation(15);
    }

    public void lambda$show$18$GUIRadialMenuForCar(View view) {
        suspensionSetClickableIsClickableInSubmenu();
        sendServerThisOperation(16);
    }

    public void lambda$show$19$GUIRadialMenuForCar(View view) {
        suspensionSetClickableIsClickableInSubmenu();
        sendServerThisOperation(17);
    }

    public void lambda$show$20$GUIRadialMenuForCar(View view) {
        suspensionSetClickableIsClickableInSubmenu();
        sendServerThisOperation(18);
    }

    public void lambda$show$21$GUIRadialMenuForCar(View view) {
        suspensionSetClickableIsClickableInSubmenu();
        sendServerThisOperation(19);
    }

    private void getData(JSONObject jsonObject) {
        JSONArray optJSONArray = jsonObject.optJSONArray("s");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                switch (optJSONArray.optInt(i)) {
                    case 1:
                        parkingSetClickIsNowNotClickable(true);
                        break;
                    case 2:
                        keySetClickIsNowNotClickable(true);
                        break;
                    case 3:
                        doorSetClickIsNowNotClickable(true);
                        break;
                    case 5:
                        launchSetClickIsNowNotClickable(true);
                        break;
                    case 6:
                        engineSetClickIsNowNotClickable(true);
                        break;
                    case 8:
                        driftSetClickIsNowNotClickable(true);
                        turboSetClickableIsClickableInSubmenu();
                        break;
                    case 9:
                        comfortPlusSetClickIsNowNotClickable(true);
                        turboSetClickableIsClickableInSubmenu();
                        break;
                    case 10:
                        sportSetClickIsNowNotClickable(true);
                        turboSetClickableIsClickableInSubmenu();
                        break;
                    case 11:
                        sportPlusSetClickIsNowNotClickable(true);
                        turboSetClickableIsClickableInSubmenu();
                        break;
                    case 12:
                        neonSetClickIsNowNotClickable(true);
                        lightSetClickableIsClickableInSubmenu();
                        break;
                    case 13:
                        highLightSetClickIsNowNotClickable(true);
                        lightSetClickableIsClickableInSubmenu();
                        break;
                    case 14:
                        headlightsSetClickIsNowNotClickable(true);
                        lightSetClickableIsClickableInSubmenu();
                        break;
                    case 15:
                        stroboscopeSetClickIsNowNotClickable(true);
                        lightSetClickableIsClickableInSubmenu();
                        break;
                    case 16:
                        pnevmo1SetClickIsNowNotClickable(true);
                        suspensionSetClickableIsClickableInSubmenu();
                        break;
                    case 17:
                        pnevmo2SetClickIsNowNotClickable(true);
                        suspensionSetClickableIsClickableInSubmenu();
                        break;
                    case 18:
                        pnevmo3SetClickIsNowNotClickable(true);
                        suspensionSetClickableIsClickableInSubmenu();
                        break;
                    case 19:
                        hydraulicsSetClickIsNowNotClickable(true);
                        suspensionSetClickableIsClickableInSubmenu();
                        break;
                }
            }
        }
    }

    public void sendServerThisOperation(int valueKey) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", valueKey);
            this.guiManager.sendJsonData(27, jSONObject);
        } catch (Exception e) {
            Log.v(LOG, "close dismiss exception: " + e);
        }
    }

    private void parkingSetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickParking = true;
            this.buttonParking.setImageResource(R.drawable.radial_parking_checked);
            return;
        }
        this.isClickParking = false;
        this.buttonParking.setImageResource(R.drawable.radial_parking_not_checked);
    }

    private void keySetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickKey = true;
            this.buttonKey.setImageResource(R.drawable.radial_key_checked);
            return;
        }
        this.isClickKey = false;
        this.buttonKey.setImageResource(R.drawable.radial_key_not_checked);
    }

    private void doorSetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickDoor = true;
            this.buttonDoor.setImageResource(R.drawable.radial_door_checked);
            return;
        }
        this.isClickDoor = false;
        this.buttonDoor.setImageResource(R.drawable.radial_door_not_checked);
    }

    private void launchSetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickLaunchControl = true;
            this.buttonLaunchControl.setImageResource(R.drawable.radial_control_checked);
            return;
        }
        this.isClickLaunchControl = false;
        this.buttonLaunchControl.setImageResource(R.drawable.radial_control_not_checked);
    }

    private void engineSetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickEngine = true;
            this.buttonEngine.setImageResource(R.drawable.radial_engine_checked);
            return;
        }
        this.isClickEngine = false;
        this.buttonEngine.setImageResource(R.drawable.radial_engine_not_checked);
    }

    private void driftSetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickDrift = true;
            this.buttonDrift.setImageResource(R.drawable.radial_drift_checked);
            return;
        }
        this.isClickDrift = false;
        this.buttonDrift.setImageResource(R.drawable.radial_drift_not_checked);
    }

    private void comfortPlusSetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickComfortPlus = true;
            this.buttonComfortPlus.setImageResource(R.drawable.radial_comfort_plus_checked);
            return;
        }
        this.isClickComfortPlus = false;
        this.buttonComfortPlus.setImageResource(R.drawable.radial_comfort_plus_not_checked);
    }

    private void sportSetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickSport = true;
            this.buttonSport.setImageResource(R.drawable.radial_sport_checked);
            return;
        }
        this.isClickSport = false;
        this.buttonSport.setImageResource(R.drawable.radial_sport_not_checked);
    }

    private void sportPlusSetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickSportPlus = true;
            this.buttonSportPlus.setImageResource(R.drawable.radial_sport_plus_checked);
            return;
        }
        this.isClickSportPlus = false;
        this.buttonSportPlus.setImageResource(R.drawable.radial_sport_plus_not_checked);
    }

    private void neonSetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickNeon = true;
            this.buttonNeon.setImageResource(R.drawable.radial_neon_checked);
            return;
        }
        this.isClickNeon = false;
        this.buttonNeon.setImageResource(R.drawable.radial_neon_not_checked);
    }

    private void highLightSetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickHighLight = true;
            this.buttonHighLight.setImageResource(R.drawable.radial_high_light_checked);
            return;
        }
        this.isClickHighLight = false;
        this.buttonHighLight.setImageResource(R.drawable.radial_high_light_not_checked);
    }

    private void headlightsSetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickHeadlights = true;
            this.buttonHeadLights.setImageResource(R.drawable.radial_headlights_checked);
            return;
        }
        this.isClickHeadlights = false;
        this.buttonHeadLights.setImageResource(R.drawable.radial_headlights_not_checked);
    }

    private void stroboscopeSetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickStroboscope = true;
            this.buttonStroboscope.setImageResource(R.drawable.radial_stroboscope_checked);
            return;
        }
        this.isClickStroboscope = false;
        this.buttonStroboscope.setImageResource(R.drawable.radial_stroboscope_not_checked);
    }

    private void pnevmo1SetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickPnevmo1 = true;
            this.buttonPnevmo1.setImageResource(R.drawable.radial_pnevmo1_checked);
            return;
        }
        this.isClickPnevmo1 = false;
        this.buttonPnevmo1.setImageResource(R.drawable.radial_pnevmo1_not_checked);
    }

    private void pnevmo2SetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickPnevmo2 = true;
            this.buttonPnevmo2.setImageResource(R.drawable.radial_pnevmo2_checked);
            return;
        }
        this.isClickPnevmo2 = false;
        this.buttonPnevmo2.setImageResource(R.drawable.radial_pnevmo2_not_checked);
    }

    private void pnevmo3SetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickPnevmo3 = true;
            this.buttonPnevmo3.setImageResource(R.drawable.radial_pnevmo3_checked);
            return;
        }
        this.isClickPnevmo3 = false;
        this.buttonPnevmo3.setImageResource(R.drawable.radial_pnevmo3_not_checked);
    }

    private void hydraulicsSetClickIsNowNotClickable(boolean value) {
        if (value) {
            this.isClickHydraulics = true;
            this.buttonHydraulics.setImageResource(R.drawable.radial_hydraulics_checked);
            return;
        }
        this.isClickHydraulics = false;
        this.buttonHydraulics.setImageResource(R.drawable.radial_hydraulics_not_checked);
    }

    private void setVisibilityForTurbo(int valueVisible) {
        this.bgTurboSubmenu.setVisibility(valueVisible);
        this.buttonComfortPlus.setVisibility(valueVisible);
        this.buttonDrift.setVisibility(valueVisible);
        this.buttonSport.setVisibility(valueVisible);
        this.buttonSportPlus.setVisibility(valueVisible);
    }

    private void setVisibilityForLight(int valueVisible) {
        this.bgLightSubmenu.setVisibility(valueVisible);
        this.buttonNeon.setVisibility(valueVisible);
        this.buttonHighLight.setVisibility(valueVisible);
        this.buttonHeadLights.setVisibility(valueVisible);
        this.buttonStroboscope.setVisibility(valueVisible);
    }

    private void setVisibilityForSuspension(int valueVisible) {
        this.bgSuspensionSubmenu.setVisibility(valueVisible);
        this.buttonPnevmo1.setVisibility(valueVisible);
        this.buttonPnevmo2.setVisibility(valueVisible);
        this.buttonPnevmo3.setVisibility(valueVisible);
        this.buttonHydraulics.setVisibility(valueVisible);
    }

    private void turboSetClickableIsClickableInSubmenu() {
        if (this.isClickDrift || this.isClickComfortPlus || this.isClickSportPlus || this.isClickSport) {
            this.buttonTurbo.setImageResource(R.drawable.radial_turbo_checked);
        } else {
            this.buttonTurbo.setImageResource(R.drawable.radial_turbo_not_checked);
        }
    }

    private void lightSetClickableIsClickableInSubmenu() {
        if (this.isClickNeon || this.isClickHighLight || this.isClickHeadlights || this.isClickStroboscope) {
            this.buttonLight.setImageResource(R.drawable.radial_light_checked);
        } else {
            this.buttonLight.setImageResource(R.drawable.radial_light_not_checked);
        }
    }

    private void suspensionSetClickableIsClickableInSubmenu() {
        if (this.isClickPnevmo1 || this.isClickPnevmo2 || this.isClickPnevmo3 || this.isClickHydraulics) {
            this.buttonSuspension.setImageResource(R.drawable.radial_suspension_checked);
        } else {
            this.buttonSuspension.setImageResource(R.drawable.radial_suspension_not_checked);
        }
    }

    @Override
    public void close(JSONObject json) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }

    private void showMessageError() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("o", 1);
            jSONObject.put("t", 2);
            jSONObject.put("d", 2);
            jSONObject.put("i", "Недоступно для данного вида транспорта");
            jSONObject.put("s", -1);
            this.guiManager.onPacketIncoming(13, jSONObject);
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }
}
