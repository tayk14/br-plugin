package com.rockstargames.gtacr.BlackPass;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.google.android.gms.common.ConnectionResult;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.BlackPass.BlackPassLevelsAdapter;
import com.rockstargames.gtacr.BlackPass.BlackPassMarathonAdapter;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.GameRender;
import com.rockstargames.gtacr.common.DialogNoNavBar;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.GUIDonate;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.json.JSONObject;

public class BrBlackPass extends UILayout {
    public static final int LAYOUT_ACTIVATE = 4;
    public static final int LAYOUT_MARATHON = 2;
    public static final int LAYOUT_NUM = 5;
    public static final int LAYOUT_PASS = 0;
    public static final int LAYOUT_RATING = 3;
    public static final int LAYOUT_TASKS = 1;
    private static final int PRIZE_ACCESSORIES = 5;
    private static final int PRIZE_BLACK_COIN = 3;
    private static final int PRIZE_CAR = 8;
    private static final int PRIZE_DISCOUNT_ACCESSORIES = 13;
    private static final int PRIZE_DISCOUNT_CAR = 11;
    private static final int PRIZE_DISCOUNT_PRODUCT = 16;
    private static final int PRIZE_DISCOUNT_SERVICE = 15;
    private static final int PRIZE_DISCOUNT_SET = 14;
    private static final int PRIZE_DISCOUNT_SKIN = 12;
    private static final int PRIZE_DISCOUNT_VIP = 17;
    private static final int PRIZE_EXP = 0;
    private static final int PRIZE_MONEY = 1;
    private static final int PRIZE_RULLET = 6;
    private static final int PRIZE_SET = 9;
    private static final int PRIZE_SKIN = 7;
    private static final int PRIZE_TIME_CAR = 2;
    private static final int PRIZE_TIME_SKIN = 10;
    private static final int PRIZE_VINYL = 20;
    private static final int PRIZE_VIP = 4;
    private static final int PRIZE_VIP_TIME = 19;
    private static final int PRIZE_X2 = 18;
    boolean ActivePremium;
    public int Level;
    private int PrevLayout;
    public Animation anim;
    DialogNoNavBar dialog;
    NvEventQueueActivity mActivity;
    public NvEventQueueActivity mContext;
    public GUIDonate mGUID;
    public GUIManager mGUIManager;
    private PopupWindow mWindow = null;
    public View mRootView = null;
    private BlackPassMainLayout mPassLayout = null;
    private BlackPassActivateLayout mActivateLayout = null;
    private BlackPassRatingLayout mRatingLayout = null;
    private BlackPassMarathonLayout mMarathonLayout = null;
    private BlackPassTasksLayout mTasksLayout = null;
    private FrameLayout MainFrame = null;
    private LinearLayout mHeader = null;
    public int mCurrLayout = 0;
    private View[] mLayoutsArr = new View[5];
    private Button[] mLayoutsButts = new Button[4];

    @Override
    public void onLayoutClose() {
    }

    public NvEventQueueActivity getNvEvent() {
        return this.mContext;
    }

    public void InfoWindow(String infoText) {
        final DialogNoNavBar dialogNoNavBar = new DialogNoNavBar(this.mContext);
        dialogNoNavBar.requestWindowFeature(1);
        dialogNoNavBar.setContentView(R.layout.br_dialog_error_success);
        dialogNoNavBar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialogNoNavBar.getWindow().setDimAmount(0.4f);
        ((Button) dialogNoNavBar.findViewById(R.id.dw_button_ok)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BrBlackPass.this.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                view.startAnimation(BrBlackPass.this.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialogNoNavBar.dismiss();
                    }
                }, 250L);
            }
        });
        ((Button) dialogNoNavBar.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BrBlackPass.this.mContext.getSoundApi().playSound("donate_click_close_sfx");
                view.startAnimation(BrBlackPass.this.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialogNoNavBar.dismiss();
                    }
                }, 250L);
            }
        });
        ((TextView) dialogNoNavBar.findViewById(R.id.dw_caption)).setText("Внимание");
        ((TextView) dialogNoNavBar.findViewById(R.id.dw_bold)).setText(infoText);
        ((TextView) dialogNoNavBar.findViewById(R.id.dw_default)).setVisibility(8);
        dialogNoNavBar.findViewById(R.id.dw_icon).setBackgroundResource(R.drawable.checkbox_red_icon);
        dialogNoNavBar.show();
        this.mContext.getSoundApi().playSound("donate_error_sfx");
    }

    public void showConfirmationDialog(int price, String caption, String msg, final View.OnClickListener listenerOk, View.OnClickListener listenerCancel) {
        if (this.dialog != null) {
            closeDialog();
        }
        DialogNoNavBar dialogNoNavBar = new DialogNoNavBar(getNvEvent());
        this.dialog = dialogNoNavBar;
        dialogNoNavBar.requestWindowFeature(1);
        this.dialog.setContentView(R.layout.br_popup);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialog.getWindow().setDimAmount(0.4f);
        ((TextView) this.dialog.findViewById(R.id.dw_info)).setText(GUIManager.transfromColors("Вы действительно желаете\n{f4b939}" + msg + " за " + price + GUIManager.getBCText() + "?"));
        ((TextView) this.dialog.findViewById(R.id.dw_caption)).setText(caption);
        Button button = (Button) this.dialog.findViewById(R.id.dw_button_ok);
        button.setText("Да");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerOk.onClick(v);
            }
        });
        Button button2 = (Button) this.dialog.findViewById(R.id.dw_button_cancel);
        button2.setText("Нет");
        button2.setOnClickListener(listenerCancel);
        getNvEvent().getSoundApi().playSound("donate_pop_up_sfx");
        this.dialog.show();
        GUIManager.hideSystemUI(this.dialog.getWindow().getDecorView());
    }

    public void closeDialog() {
        DialogNoNavBar dialogNoNavBar = this.dialog;
        if (dialogNoNavBar != null) {
            dialogNoNavBar.cancel();
        }
        getNvEvent().getParentLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    GUIManager.hideSystemUI(BrBlackPass.this.mWindow.getContentView());
                } catch (Exception unused) {
                }
            }
        }, 300L);
        this.dialog = null;
    }

    public void SetupAwardImg(final ImageView img, int typeId, int awardId, String texture, float rotX, float rotY, float rotZ, final int pos, final RecyclerView.ViewHolder holder) {
        img.setAlpha(1.0f);
        switch (typeId) {
            case 0:
                img.setImageResource(R.drawable.bp_exp);
                return;
            case 1:
                img.setImageResource(R.drawable.bp_money);
                return;
            case 2:
            case 8:
                getNvEvent().getGameRender().RequestRender(7, pos, awardId, 1, 1, rotX, rotY, rotZ, 0.78f, new GameRender.GameRenderListener() {
                    @Override
                    public void OnRenderComplete(int id, byte[] buffer, long length) {
                        int i;
                        int i2;
                        if (BrBlackPass.this.mCurrLayout != 2) {
                            i = ((BlackPassLevelsAdapter.ViewHolder) holder).mPosition;
                            i2 = pos >= 6000 ? ((BlackPassLevelsAdapter.ViewHolder) holder).mPType : ((BlackPassLevelsAdapter.ViewHolder) holder).mType;
                        } else {
                            i = ((BlackPassMarathonAdapter.ViewHolder) holder).mPosition;
                            i2 = ((BlackPassMarathonAdapter.ViewHolder) holder).mType;
                        }
                        int i3 = i + 5000;
                        int i4 = pos;
                        if ((i3 != i4 && i3 + 1000 != i4 && i + 10000 != i4) || (i2 != 2 && i2 != 8)) {
                            img.setAlpha(1.0f);
                            return;
                        }
                        final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
                        createBitmap.setHasAlpha(true);
                        IntBuffer asIntBuffer = ByteBuffer.wrap(buffer).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
                        int[] iArr = new int[asIntBuffer.remaining()];
                        asIntBuffer.get(iArr);
                        createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
                        BrBlackPass.this.getNvEvent().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                img.setImageBitmap(createBitmap);
                            }
                        });
                    }
                });
                return;
            case 3:
                img.setImageResource(R.drawable.bp_bc);
                return;
            case 4:
            case 19:
                if (awardId == 0) {
                    img.setImageResource(R.drawable.vip_silver);
                    return;
                } else if (awardId == 1) {
                    img.setImageResource(R.drawable.vip_gold);
                    return;
                } else if (awardId != 2) {
                    return;
                } else {
                    img.setImageResource(R.drawable.vip_platinum);
                    return;
                }
            case 5:
                getNvEvent().getGameRender().RequestRender(0, pos, awardId, 3, 3, rotX, rotY, rotZ, 0.78f, new GameRender.GameRenderListener() {
                    @Override
                    public void OnRenderComplete(int id, byte[] buffer, long length) {
                        int i;
                        int i2;
                        if (BrBlackPass.this.mCurrLayout != 2) {
                            i = ((BlackPassLevelsAdapter.ViewHolder) holder).mPosition;
                            i2 = pos >= 6000 ? ((BlackPassLevelsAdapter.ViewHolder) holder).mPType : ((BlackPassLevelsAdapter.ViewHolder) holder).mType;
                        } else {
                            i = ((BlackPassMarathonAdapter.ViewHolder) holder).mPosition;
                            i2 = ((BlackPassMarathonAdapter.ViewHolder) holder).mType;
                        }
                        int i3 = i + 5000;
                        int i4 = pos;
                        if ((i3 != i4 && i3 + 1000 != i4 && i + 10000 != i4) || i2 != 5) {
                            img.setAlpha(1.0f);
                            return;
                        }
                        final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
                        createBitmap.setHasAlpha(true);
                        IntBuffer asIntBuffer = ByteBuffer.wrap(buffer).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
                        int[] iArr = new int[asIntBuffer.remaining()];
                        asIntBuffer.get(iArr);
                        createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
                        BrBlackPass.this.getNvEvent().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                img.setImageBitmap(createBitmap);
                            }
                        });
                    }
                });
                return;
            case 6:
                if (awardId == 0) {
                    img.setImageResource(R.drawable.bp_brullet);
                    return;
                } else if (awardId == 1) {
                    img.setImageResource(R.drawable.bp_srullet);
                    return;
                } else if (awardId == 2) {
                    img.setImageResource(R.drawable.bp_rullet);
                    return;
                } else if (awardId != 3) {
                    return;
                } else {
                    img.setImageResource(R.drawable.bp_rullet);
                    return;
                }
            case 7:
            case 10:
                getNvEvent().getGameRender().RequestRender(2, pos, awardId, 1, 1, rotX, rotY, rotZ, 0.78f, new GameRender.GameRenderListener() {
                    @Override
                    public void OnRenderComplete(int id, byte[] buffer, long length) {
                        int i;
                        int i2;
                        if (BrBlackPass.this.mCurrLayout != 2) {
                            i = ((BlackPassLevelsAdapter.ViewHolder) holder).mPosition;
                            i2 = pos >= 6000 ? ((BlackPassLevelsAdapter.ViewHolder) holder).mPType : ((BlackPassLevelsAdapter.ViewHolder) holder).mType;
                        } else {
                            i = ((BlackPassMarathonAdapter.ViewHolder) holder).mPosition;
                            i2 = ((BlackPassMarathonAdapter.ViewHolder) holder).mType;
                        }
                        int i3 = i + 5000;
                        int i4 = pos;
                        if ((i3 != i4 && i3 + 1000 != i4 && i + 10000 != i4) || (i2 != 7 && i2 != 10)) {
                            img.setAlpha(1.0f);
                            return;
                        }
                        final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
                        createBitmap.setHasAlpha(true);
                        IntBuffer asIntBuffer = ByteBuffer.wrap(buffer).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
                        int[] iArr = new int[asIntBuffer.remaining()];
                        asIntBuffer.get(iArr);
                        createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
                        BrBlackPass.this.getNvEvent().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                img.setImageBitmap(createBitmap);
                            }
                        });
                    }
                });
                return;
            case 9:
                switch (awardId) {
                    case 0:
                        img.setImageResource(R.drawable.packet_selchanin);
                        return;
                    case 1:
                        img.setImageResource(R.drawable.packet_bandit);
                        return;
                    case 2:
                        img.setImageResource(R.drawable.packet_yung);
                        return;
                    case 3:
                        img.setImageResource(R.drawable.packet_gangster);
                        return;
                    case 4:
                        img.setImageResource(R.drawable.hw_fred);
                        return;
                    case 5:
                        img.setImageResource(R.drawable.hw_daffna);
                        return;
                    case 6:
                        img.setImageResource(R.drawable.packet_ghost_racer);
                        return;
                    case 7:
                        img.setImageResource(R.drawable.packet_deputat);
                        return;
                    case 8:
                        img.setImageResource(R.drawable.hw_witch);
                        return;
                    case 9:
                        img.setImageResource(R.drawable.hw_smile);
                        return;
                    case 10:
                        img.setImageResource(R.drawable.hw_kruger);
                        return;
                    case 11:
                        img.setImageResource(R.drawable.hw_scream);
                        return;
                    case 12:
                        img.setImageResource(R.drawable.packet_mafiozi);
                        return;
                    case 13:
                        img.setImageResource(R.drawable.packet_mazhor);
                        return;
                    case 14:
                        img.setImageResource(R.drawable.hw_kostyan);
                        return;
                    default:
                        return;
                }
            case 11:
                img.setImageResource(R.drawable.discount_cars);
                return;
            case 12:
                img.setImageResource(R.drawable.discount_skins);
                return;
            case 13:
                img.setImageResource(R.drawable.discount_accs);
                return;
            case 14:
                img.setImageResource(R.drawable.discount_set);
                return;
            case 15:
                img.setImageResource(R.drawable.discount_service);
                return;
            case 16:
                img.setImageResource(R.drawable.discount_prods);
                return;
            case 17:
                img.setImageResource(R.drawable.discount_vip);
                return;
            case 18:
                img.setImageResource(R.drawable.x2_cash);
                return;
            case 20:
                if (texture == null) {
                    return;
                }
                getNvEvent().getGameRender().RequestTexture(texture, pos, new GameRender.GameTextureListener() {
                    @Override
                    public void OnTextureGet(int id, final Bitmap bitmap) {
                        int i;
                        int i2;
                        if (BrBlackPass.this.mCurrLayout != 2) {
                            i = ((BlackPassLevelsAdapter.ViewHolder) holder).mPosition;
                            i2 = pos >= 6000 ? ((BlackPassLevelsAdapter.ViewHolder) holder).mPType : ((BlackPassLevelsAdapter.ViewHolder) holder).mType;
                        } else {
                            i = ((BlackPassMarathonAdapter.ViewHolder) holder).mPosition;
                            i2 = ((BlackPassMarathonAdapter.ViewHolder) holder).mType;
                        }
                        int i3 = i + 5000;
                        int i4 = pos;
                        if ((i3 != i4 && i3 + 1000 != i4 && i + 10000 != i4) || i2 != 20) {
                            img.setAlpha(1.0f);
                        } else {
                            BrBlackPass.this.getNvEvent().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img.setImageBitmap(bitmap);
                                }
                            });
                        }
                    }
                });
                return;
            default:
                return;
        }
    }

    public void ShowPrizeWindow(Drawable img, String name, final int id, final int pos) {
        View inflate = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.bp_prize, (ViewGroup) null, false);
        final PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
        popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
        popupWindow.setSoftInputMode(16);
        this.mGUIManager.setCustomTouchInterceptor(popupWindow);
        GUIManager.hideSystemUI(inflate);
        ((ImageView) inflate.findViewById(R.id.bp_prize_img)).setImageDrawable(img);
        ((TextView) inflate.findViewById(R.id.bp_prize_name)).setText(name);
        ((Button) inflate.findViewById(R.id.bp_prize_get)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(BrBlackPass.this.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BrBlackPass.this.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                        popupWindow.dismiss();
                    }
                }, 250L);
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("t", -1);
                    jSONObject.put("la", BrBlackPass.this.mCurrLayout);
                    jSONObject.put("ty", 2);
                    jSONObject.put(GetKeys.GET_PLAYERS_ID, id);
                    jSONObject.put(TuningConstants.KEY_GET_ID_DETAIL, pos);
                    BrBlackPass.this.mGUIManager.sendJsonData(22, jSONObject);
                } catch (Exception unused) {
                }
            }
        });
        ((Button) inflate.findViewById(R.id.bp_prize_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BrBlackPass.this.mContext.getSoundApi().playSound("donate_click_close_sfx");
                view.startAnimation(BrBlackPass.this.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        popupWindow.dismiss();
                    }
                }, 250L);
            }
        });
        popupWindow.showAtLocation(this.mContext.getParentLayout(), 17, 0, 0);
        this.mContext.getSoundApi().playSound("donate_success_scr_sfx");
    }

    public void disableOtherButts(int except) {
        int i = 0;
        while (i < 4) {
            this.mLayoutsButts[i].setBackground(ContextCompat.getDrawable(this.mContext, i != except ? R.drawable.donate_tile_button_gray : R.drawable.button_yellow_gradient));
            this.mLayoutsButts[i].setTextColor(i != except ? -1 : -16777216);
            i++;
        }
    }

    public void EnableActivateLayout(boolean act) {
        int i = this.mCurrLayout;
        if (i == 4 && act) {
            return;
        }
        if (act) {
            this.PrevLayout = i;
            this.mLayoutsArr[i].setVisibility(4);
            this.mCurrLayout = 4;
            this.mLayoutsArr[4].setVisibility(0);
            this.mHeader.setVisibility(8);
        } else {
            this.mHeader.setVisibility(0);
            this.mLayoutsArr[this.mCurrLayout].setVisibility(4);
            int i2 = this.PrevLayout;
            this.mCurrLayout = i2;
            this.mLayoutsArr[i2].setVisibility(0);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", -1);
            jSONObject.put("ty", 0);
            jSONObject.put("la", this.mCurrLayout);
            this.mGUIManager.sendJsonData(22, jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override
    public View getView() {
        return this.mRootView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.br_bp, (ViewGroup) null, false);
        this.mRootView = inflate;
        this.MainFrame = (FrameLayout) inflate.findViewById(R.id.bp_main_frame);
        this.mHeader = (LinearLayout) this.mRootView.findViewById(R.id.bp_header);
        this.mLayoutsArr[0] = inflater.inflate(R.layout.bp_pass, (ViewGroup) null, false);
        this.mLayoutsArr[1] = inflater.inflate(R.layout.bp_tasks, (ViewGroup) null, false);
        this.mLayoutsArr[2] = inflater.inflate(R.layout.bp_marathon, (ViewGroup) null, false);
        this.mLayoutsArr[3] = inflater.inflate(R.layout.bp_rating, (ViewGroup) null, false);
        this.mLayoutsArr[4] = inflater.inflate(R.layout.bp_activate, (ViewGroup) null, false);
        this.MainFrame.addView(this.mLayoutsArr[0]);
        this.MainFrame.addView(this.mLayoutsArr[1]);
        this.MainFrame.addView(this.mLayoutsArr[3]);
        this.MainFrame.addView(this.mLayoutsArr[2]);
        this.MainFrame.addView(this.mLayoutsArr[4]);
        this.mPassLayout = new BlackPassMainLayout(this, this.mLayoutsArr[0], this.mActivity, this.mGUIManager);
        this.mActivateLayout = new BlackPassActivateLayout(this, this.mLayoutsArr[4], this.mActivity, this.mGUIManager);
        this.mRatingLayout = new BlackPassRatingLayout(this, this.mLayoutsArr[3], this.mActivity, this.mGUIManager);
        this.mMarathonLayout = new BlackPassMarathonLayout(this, this.mLayoutsArr[2], this.mActivity, this.mGUIManager);
        this.mTasksLayout = new BlackPassTasksLayout(this, this.mLayoutsArr[1], this.mActivity, this.mGUIManager);
        this.mLayoutsButts[0] = (Button) this.mRootView.findViewById(R.id.br_bp_butt_pass);
        this.mLayoutsButts[1] = (Button) this.mRootView.findViewById(R.id.br_bp_butt_tasks);
        this.mLayoutsButts[2] = (Button) this.mRootView.findViewById(R.id.br_bp_butt_marathon);
        this.mLayoutsButts[3] = (Button) this.mRootView.findViewById(R.id.br_bp_butt_rating);
        this.mLayoutsArr[1].setVisibility(4);
        this.mLayoutsArr[2].setVisibility(4);
        this.mLayoutsArr[3].setVisibility(4);
        this.mLayoutsArr[4].setVisibility(4);
        disableOtherButts(this.mCurrLayout);
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            this.mLayoutsButts[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI != BrBlackPass.this.mCurrLayout) {
                        BrBlackPass.this.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                        view.startAnimation(BrBlackPass.this.anim);
                        BrBlackPass.this.mCurrLayout = finalI;
                        BrBlackPass.this.disableOtherButts(finalI);
                        int i2 = 0;
                        while (i2 < 5) {
                            BrBlackPass.this.mLayoutsArr[i2].setVisibility(i2 == finalI ? 0 : 4);
                            i2++;
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("t", -1);
                            jSONObject.put("ty", 0);
                            jSONObject.put("la", finalI);
                            BrBlackPass.this.mGUIManager.sendJsonData(22, jSONObject);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
        this.mRootView.findViewById(R.id.bp_layout).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                BrBlackPass.this.AlignStuff();
            }
        });
        return this.mRootView;
    }

    @Override
    public void onLayoutShown() {
        this.mCurrLayout = 0;
        disableOtherButts(0);
        this.mHeader.setVisibility(0);
        int i = 0;
        while (i < 5) {
            this.mLayoutsArr[i].setVisibility(i == 0 ? 0 : 4);
            i++;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", -2);
            this.mGUIManager.sendJsonData(22, jSONObject);
        } catch (Exception unused) {
        }
    }

    public BrBlackPass(GUIManager manager, NvEventQueueActivity activity, GUIDonate donate) {
        this.mContext = null;
        this.anim = null;
        this.mContext = activity;
        this.mGUIManager = manager;
        this.anim = AnimationUtils.loadAnimation(activity, R.anim.button_click);
        this.mActivity = activity;
        this.mGUID = donate;
    }

    public void AlignStuff() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mHeader.getLayoutParams();
        int height = (int) (this.mRootView.findViewById(R.id.bp_layout).getHeight() / 5.0f);
        layoutParams.height = height;
        this.mHeader.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mRootView.findViewById(R.id.bp_frame_bar).getLayoutParams();
        layoutParams2.height = (int) (height / 3.0f);
        this.mRootView.findViewById(R.id.bp_frame_bar).setLayoutParams(layoutParams2);
    }

    public void UpdatePassPremium() {
        this.mPassLayout.mAdapter.IsAwardActivePremium = false;
        for (int i = 0; i < this.Level; i++) {
            this.mPassLayout.mAdapter.notifyItemChanged(i);
        }
    }

    public void onJsonDataIncoming(JSONObject json) {
        try {
            if (json.getInt("ty") == 2) {
                if (json.getInt("s") == 0) {
                    InfoWindow(json.getString(TuningConstants.KEY_GET_DETAILS_LIST_WITH_COST_AND_STATUS));
                    return;
                }
            } else if (json.getInt("ty") == 3) {
                ((TextView) this.mRootView.findViewById(R.id.br_bp_exp)).setText("" + json.getInt("e") + " из 1 500 очков");
                ProgressBar progressBar = (ProgressBar) this.mRootView.findViewById(R.id.br_bp_progress);
                progressBar.setMax(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                progressBar.setProgress(json.getInt("e"));
                if (json.getInt("l") != this.Level) {
                    this.Level = json.getInt("l");
                    ((TextView) this.mRootView.findViewById(R.id.br_bp_level)).setText("" + this.Level);
                    this.mPassLayout.UpdateLevel();
                }
            }
            boolean z = true;
            if (json.getInt("ty") == -1) {
                if (json.getInt("a") == 0) {
                    z = false;
                }
                this.ActivePremium = z;
                ((TextView) this.mRootView.findViewById(R.id.br_bp_name)).setText(json.getString("sn"));
                ((TextView) this.mRootView.findViewById(R.id.br_bp_leader)).setText(Html.fromHtml("Лидер сезона <font color='#FFBA08'>" + json.getString("ln").toUpperCase() + "</font>"));
                StringBuilder sb = new StringBuilder();
                sb.append("");
                int i = json.getInt(GetKeys.GET_PLAYERS_LEVEL);
                this.Level = i;
                sb.append(i);
                ((TextView) this.mRootView.findViewById(R.id.br_bp_level)).setText(sb.toString());
                ((TextView) this.mRootView.findViewById(R.id.br_bp_time)).setText(Html.fromHtml("До конца сезона осталось: <font color='#FFBA08'>" + (json.getInt("td") / 86400) + " дн. " + ((json.getInt("td") % 86400) / 3600) + " ч.</font>"));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(json.getInt("ec"));
                sb2.append(" из 1 500 очков");
                ((TextView) this.mRootView.findViewById(R.id.br_bp_exp)).setText(sb2.toString());
                ProgressBar progressBar2 = (ProgressBar) this.mRootView.findViewById(R.id.br_bp_progress);
                progressBar2.setMax(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                progressBar2.setProgress(json.getInt("ec"));
                this.mPassLayout.onJsonDataIncoming(json);
                return;
            }
            int i2 = json.getInt("la");
            if (i2 == 0) {
                this.mPassLayout.onJsonDataIncoming(json);
            } else if (i2 == 1) {
                this.mTasksLayout.onJsonDataIncoming(json);
            } else if (i2 == 2) {
                this.mMarathonLayout.onJsonDataIncoming(json);
            } else if (i2 == 3) {
                this.mRatingLayout.onJsonDataIncoming(json);
            } else if (i2 != 4) {
            } else {
                this.mActivateLayout.onJsonDataIncoming(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
