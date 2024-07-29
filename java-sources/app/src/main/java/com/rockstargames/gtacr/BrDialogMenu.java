package com.rockstargames.gtacr;

import android.graphics.Typeface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogMenu implements ISAMPGUI {
    private View bottomBlackMenu;
    private TextView helpTextMenu;
    private View leftBlackMenu;
    private GUIManager mGUIManager;
    private View rightBlackMenu;
    private View topBlackMenu;
    Typeface typeface;
    private View windowMenu;
    private NvEventQueueActivity mContext = null;
    private PopupWindow mWindow = null;
    private View mRootView = null;
    private Animation anim = null;
    private int Index = -1;
    private boolean closed = true;
    private LinearLayout mUp = null;
    private LinearLayout mDown = null;
    private LinearLayout mDown2 = null;
    private boolean mInIsFamily = false;
    private int[] itemLocation = new int[3];
    private int itemsHeight = 0;
    private int itemsWidth = 0;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 14;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogMenu();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x02fc */
    /* JADX INFO: Access modifiers changed from: private */
    public void Update(boolean IsChat) {
        int i;
        String str;
        int i2;
        String str2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mUp.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mDown.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mDown2.getLayoutParams();
        this.mUp.removeAllViews();
        this.mDown.removeAllViews();
        this.mDown2.removeAllViews();
        this.Index = -1;
        float f = 0.6f;
        int i3 = R.drawable.background_br_input;
        float f2 = 1.0f;
        float f3 = 2.0f;
        int i4 = 1;
        if (!IsChat) {
            int height = this.mRootView.findViewById(R.id.br_menu_layout).getHeight() / 4;
            layoutParams3.height = height;
            layoutParams2.height = height;
            layoutParams.height = height;
            this.mUp.setLayoutParams(new LinearLayout.LayoutParams(layoutParams));
            this.mUp.setWeightSum(4.0f);
            this.mDown.setLayoutParams(new LinearLayout.LayoutParams(layoutParams2));
            this.mDown.setWeightSum(4.0f);
            this.mDown2.setLayoutParams(new LinearLayout.LayoutParams(layoutParams3));
            this.mDown2.setWeightSum(4.0f);
            this.mDown2.setVisibility(0);
            ((TextView) this.mRootView.findViewById(R.id.br_menu_title)).setText("Действия");
            int i5 = 0;
            while (i5 < 11) {
                switch (i5) {
                    case 0:
                        i2 = R.drawable.br_menu_compass;
                        str2 = "Навигатор";
                        break;
                    case 1:
                        i2 = R.drawable.br_menu_taxi;
                        str2 = "Вызов такси";
                        break;
                    case 2:
                        i2 = R.drawable.br_menu_menu;
                        str2 = "Меню";
                        break;
                    case 3:
                        i2 = R.drawable.br_menu_chat;
                        str2 = "Общение";
                        break;
                    case 4:
                        i2 = R.drawable.br_menu_bag;
                        str2 = "Инвентарь";
                        break;
                    case 5:
                        i2 = R.drawable.br_menu_anim;
                        str2 = "Анимации";
                        break;
                    case 6:
                        i2 = R.drawable.br_menu_ruble;
                        str2 = "Донат";
                        break;
                    case 7:
                        i2 = R.drawable.br_menu_car;
                        str2 = "Автомобили";
                        break;
                    case 8:
                        i2 = R.drawable.gift_box;
                        str2 = "Промокод";
                        break;
                    case 9:
                        i2 = R.drawable.help_desk;
                        str2 = "Жалоба";
                        break;
                    case 10:
                        i2 = R.drawable.br_menu_family;
                        str2 = "Семья";
                        break;
                    default:
                        i2 = 0;
                        str2 = null;
                        break;
                }
                LinearLayout linearLayout = new LinearLayout(this.mContext);
                linearLayout.setOrientation(i4);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                layoutParams4.setMargins(NvEventQueueActivity.dpToPx(f3, this.mContext), 0, NvEventQueueActivity.dpToPx(f3, this.mContext), 0);
                linearLayout.setLayoutParams(layoutParams4);
                linearLayout.setWeightSum(1.0f);
                linearLayout.setBackgroundResource(i3);
                FrameLayout frameLayout = new FrameLayout(this.mContext);
                frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, f));
                ImageView imageView = new ImageView(this.mContext);
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(NvEventQueueActivity.dpToPx(28.0f, this.mContext), NvEventQueueActivity.dpToPx(28.0f, this.mContext));
                layoutParams5.gravity = 81;
                layoutParams5.bottomMargin = NvEventQueueActivity.dpToPx(5.0f, this.mContext);
                imageView.setLayoutParams(layoutParams5);
                imageView.setImageResource(i2);
                frameLayout.addView(imageView);
                TextView textView = new TextView(this.mContext);
                textView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.4f));
                textView.setText(str2);
                textView.setTextSize(14.0f);
                textView.setTextColor(-1);
                textView.setGravity(17);
                textView.setTypeface(this.typeface);
                linearLayout.addView(frameLayout);
                linearLayout.addView(textView);
                if (i5 <= 3) {
                    this.mUp.addView(linearLayout);
                } else if (i5 <= 7) {
                    this.mDown.addView(linearLayout);
                } else {
                    this.mDown2.addView(linearLayout);
                    if (i5 == 10) {
                        if (!this.mInIsFamily) {
                            linearLayout.setVisibility(4);
                        }
                        LinearLayout linearLayout2 = new LinearLayout(this.mContext);
                        linearLayout2.setOrientation(1);
                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                        layoutParams6.setMargins(NvEventQueueActivity.dpToPx(2.0f, this.mContext), 0, NvEventQueueActivity.dpToPx(2.0f, this.mContext), 0);
                        linearLayout2.setLayoutParams(layoutParams6);
                        linearLayout2.setWeightSum(1.0f);
                        linearLayout2.setVisibility(4);
                        this.mDown2.addView(linearLayout2);
                    }
                }
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogMenu.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BrDialogMenu.this.Index < 0) {
                            for (int i6 = 0; i6 < 11; i6++) {
                                if (BrDialogMenu.this.mUp.getChildAt(i6) == view || BrDialogMenu.this.mDown.getChildAt(i6 - 4) == view || BrDialogMenu.this.mDown2.getChildAt(i6 - 8) == view) {
                                    view.startAnimation(BrDialogMenu.this.anim);
                                    BrDialogMenu.this.Index = i6;
                                    new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogMenu.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (BrDialogMenu.this.Index == 3) {
                                                BrDialogMenu.this.Update(true);
                                                return;
                                            }
                                            JSONObject jSONObject = new JSONObject();
                                            try {
                                                jSONObject.put("t", BrDialogMenu.this.Index);
                                                BrDialogMenu.this.mGUIManager.sendJsonData(14, jSONObject);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            BrDialogMenu.this.closed = false;
                                            BrDialogMenu.this.close(null);
                                        }
                                    }, 400L);
                                    return;
                                }
                            }
                        }
                    }
                });
                i5++;
                f3 = 2.0f;
                i4 = 1;
                f = 0.6f;
                i3 = R.drawable.background_br_input;
            }
            return;
        }
        int height2 = this.mRootView.findViewById(R.id.br_menu_layout).getHeight() / 3;
        layoutParams2.height = height2;
        layoutParams.height = height2;
        this.mUp.setLayoutParams(new LinearLayout.LayoutParams(layoutParams));
        this.mUp.setWeightSum(3.0f);
        this.mDown.setLayoutParams(new LinearLayout.LayoutParams(layoutParams2));
        this.mDown.setWeightSum(3.0f);
        this.mDown2.setVisibility(8);
        ((TextView) this.mRootView.findViewById(R.id.br_menu_title)).setText("Общение");
        int i6 = 0;
        while (i6 < 6) {
            if (i6 == 0) {
                i = R.drawable.menu_passport;
                str = "Передать паспорт";
            } else if (i6 == 1) {
                i = R.drawable.menu_med;
                str = "Передать мед.карту";
            } else if (i6 == 2) {
                i = R.drawable.menu_paper;
                str = "Передать лицензии";
            } else if (i6 == 3) {
                i = R.drawable.menu_lic;
                str = "Передать ПТС";
            } else if (i6 == 4) {
                i = R.drawable.menu_exchange;
                str = "Совершить обмен";
            } else if (i6 != 5) {
                i = 0;
                str = null;
            } else {
                i = R.drawable.menu_back;
                str = "Назад";
            }
            LinearLayout linearLayout3 = new LinearLayout(this.mContext);
            linearLayout3.setOrientation(1);
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -1, f2);
            layoutParams7.setMargins(NvEventQueueActivity.dpToPx(2.0f, this.mContext), 0, NvEventQueueActivity.dpToPx(2.0f, this.mContext), 0);
            linearLayout3.setLayoutParams(layoutParams7);
            linearLayout3.setBackgroundResource(R.drawable.background_br_input);
            FrameLayout frameLayout2 = new FrameLayout(this.mContext);
            frameLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.6f));
            ImageView imageView2 = new ImageView(this.mContext);
            FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(NvEventQueueActivity.dpToPx(30.0f, this.mContext), NvEventQueueActivity.dpToPx(30.0f, this.mContext));
            layoutParams8.gravity = 81;
            layoutParams8.bottomMargin = NvEventQueueActivity.dpToPx(5.0f, this.mContext);
            imageView2.setLayoutParams(layoutParams8);
            imageView2.setImageResource(i);
            frameLayout2.addView(imageView2);
            TextView textView2 = new TextView(this.mContext);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.4f));
            textView2.setText(str);
            textView2.setTextSize(14.0f);
            textView2.setTextColor(-1);
            textView2.setGravity(17);
            textView2.setTypeface(this.typeface);
            linearLayout3.addView(frameLayout2);
            linearLayout3.addView(textView2);
            (i6 <= 2 ? this.mUp : this.mDown).addView(linearLayout3);
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogMenu.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BrDialogMenu.this.Index < 0) {
                        for (int i7 = 0; i7 < 6; i7++) {
                            if ((i7 <= 2 && BrDialogMenu.this.mUp.getChildAt(i7) == view) || (i7 > 2 && BrDialogMenu.this.mDown.getChildAt(i7 - 3) == view)) {
                                view.startAnimation(BrDialogMenu.this.anim);
                                BrDialogMenu.this.Index = i7;
                                new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogMenu.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (BrDialogMenu.this.Index == 5) {
                                            BrDialogMenu.this.Update(false);
                                            return;
                                        }
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put("t", BrDialogMenu.this.Index + 30);
                                            BrDialogMenu.this.mGUIManager.sendJsonData(14, jSONObject);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        BrDialogMenu.this.closed = false;
                                        BrDialogMenu.this.close(null);
                                    }
                                }, 400L);
                                return;
                            }
                        }
                    }
                }
            });
            i6++;
            f2 = 1.0f;
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mContext = activity;
        this.mGUIManager = manager;
        if (this.mWindow == null) {
            this.mRootView = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.br_menu_action, (ViewGroup) null, false);
            PopupWindow popupWindow = new PopupWindow(this.mRootView, -1, -1, true);
            this.mWindow = popupWindow;
            popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mWindow.setSoftInputMode(16);
            this.mGUIManager.setCustomTouchInterceptor(this.mWindow);
            this.mInIsFamily = json.optBoolean("f", false);
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.BrDialogMenu.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (BrDialogMenu.this.closed) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("t", -1);
                            jSONObject.put("i", 1);
                            BrDialogMenu.this.mGUIManager.sendJsonData(14, jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    BrDialogMenu.this.mContext.setDraw2dStuff();
                    BrDialogMenu.this.mGUIManager.closeGUI(null, 14);
                }
            });
            this.mContext = activity;
            this.mUp = (LinearLayout) this.mRootView.findViewById(R.id.br_menu_up);
            this.mDown = (LinearLayout) this.mRootView.findViewById(R.id.br_menu_down);
            this.mDown2 = (LinearLayout) this.mRootView.findViewById(R.id.br_menu_down2);
            this.mRootView.findViewById(R.id.br_menu_close).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogMenu.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BrDialogMenu.this.Index >= 0) {
                        return;
                    }
                    BrDialogMenu.this.Index = 8;
                    view.startAnimation(BrDialogMenu.this.anim);
                    new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogMenu.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BrDialogMenu.this.close(null);
                        }
                    }, 400L);
                }
            });
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogMenu.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BrDialogMenu.this.mWindow.dismiss();
                }
            });
            this.mRootView.findViewById(R.id.br_menu_layout).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.rockstargames.gtacr.BrDialogMenu.6
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    BrDialogMenu.this.mRootView.findViewById(R.id.br_menu_layout).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) BrDialogMenu.this.mUp.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) BrDialogMenu.this.mDown.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) BrDialogMenu.this.mDown2.getLayoutParams();
                    int height = BrDialogMenu.this.mRootView.findViewById(R.id.br_menu_layout).getHeight() / 4;
                    layoutParams3.height = height;
                    layoutParams2.height = height;
                    layoutParams.height = height;
                    BrDialogMenu.this.mUp.setLayoutParams(new LinearLayout.LayoutParams(layoutParams));
                    BrDialogMenu.this.mDown.setLayoutParams(new LinearLayout.LayoutParams(layoutParams2));
                    BrDialogMenu.this.mDown2.setLayoutParams(new LinearLayout.LayoutParams(layoutParams3));
                }
            });
            this.anim = AnimationUtils.loadAnimation(this.mContext, R.anim.button_click);
            this.typeface = Typeface.createFromAsset(this.mContext.getAssets(), "Fonts/Roboto-Regular.ttf");
        }
        Update(false);
        this.closed = true;
        this.mWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
        GUIManager.hideSystemUI(this.mWindow.getContentView());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", -1);
            jSONObject.put("i", 0);
            this.mGUIManager.sendJsonData(14, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.windowMenu = this.mRootView.findViewById(R.id.window_menu);
        this.topBlackMenu = this.mRootView.findViewById(R.id.top_black_menu);
        this.leftBlackMenu = this.mRootView.findViewById(R.id.left_black_menu);
        this.rightBlackMenu = this.mRootView.findViewById(R.id.right_black_menu);
        this.bottomBlackMenu = this.mRootView.findViewById(R.id.bottom_black_menu);
        this.helpTextMenu = (TextView) this.mRootView.findViewById(R.id.help_text_2_menu);
        new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.-$$Lambda$BrDialogMenu$L9W-Po5k5P_MyN-w6K51YEvqH2s
            @Override // java.lang.Runnable
            public final void run() {
                BrDialogMenu.this.getParams();
            }
        }, 100L);
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getParams() {
        this.mDown.getLocationInWindow(this.itemLocation);
        if (this.mDown.getChildAt(0) != null) {
            this.itemsHeight = this.mDown.getChildAt(0).getHeight();
            this.itemsWidth = this.mDown.getChildAt(0).getWidth();
        }
    }

    void startGuide() {
        new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.-$$Lambda$BrDialogMenu$HF3R1A1-8sdnTbGuQcpbJUIySXM
            @Override // java.lang.Runnable
            public final void run() {
                BrDialogMenu.this.lambda$startGuide$0$BrDialogMenu();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$startGuide$0$BrDialogMenu() {
        new BrDialogMenuHelp(this.mRootView, this.itemsWidth, this.itemsHeight, this.itemLocation).startGuide();
        visibleHelpBlock(true);
        setClickLogic();
    }

    private void visibleHelpBlock(Boolean isVisible) {
        if (isVisible.booleanValue()) {
            this.windowMenu.setVisibility(0);
            this.topBlackMenu.setVisibility(0);
            this.leftBlackMenu.setVisibility(0);
            this.rightBlackMenu.setVisibility(0);
            this.bottomBlackMenu.setVisibility(0);
            this.helpTextMenu.setVisibility(0);
            return;
        }
        this.windowMenu.setVisibility(4);
        this.topBlackMenu.setVisibility(4);
        this.leftBlackMenu.setVisibility(4);
        this.rightBlackMenu.setVisibility(4);
        this.bottomBlackMenu.setVisibility(4);
        this.helpTextMenu.setVisibility(4);
    }

    private void setClickLogic() {
        this.windowMenu.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.-$$Lambda$BrDialogMenu$l25K2NRYm8V1h-IeoUqUJzYzfiA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrDialogMenu.this.lambda$setClickLogic$1$BrDialogMenu(view);
            }
        });
        this.topBlackMenu.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.-$$Lambda$BrDialogMenu$xoWYHkHM_B6XUcQnOAGGu67Zlr8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrDialogMenu.this.lambda$setClickLogic$2$BrDialogMenu(view);
            }
        });
        this.leftBlackMenu.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.-$$Lambda$BrDialogMenu$dZzw8W8IE9ZrWbOzWelBuOLFMqs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrDialogMenu.this.lambda$setClickLogic$3$BrDialogMenu(view);
            }
        });
        this.rightBlackMenu.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.-$$Lambda$BrDialogMenu$juwTUaU4-3lX2b5AkvY02Vr_Avo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrDialogMenu.this.lambda$setClickLogic$4$BrDialogMenu(view);
            }
        });
        this.bottomBlackMenu.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.-$$Lambda$BrDialogMenu$sriT3bnOSqlkQQ_JISTIPkiH7bY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrDialogMenu.this.lambda$setClickLogic$5$BrDialogMenu(view);
            }
        });
    }

    public /* synthetic */ void lambda$setClickLogic$1$BrDialogMenu(View view) {
        visibleHelpBlock(false);
    }

    public /* synthetic */ void lambda$setClickLogic$2$BrDialogMenu(View view) {
        visibleHelpBlock(false);
    }

    public /* synthetic */ void lambda$setClickLogic$3$BrDialogMenu(View view) {
        visibleHelpBlock(false);
    }

    public /* synthetic */ void lambda$setClickLogic$4$BrDialogMenu(View view) {
        visibleHelpBlock(false);
    }

    public /* synthetic */ void lambda$setClickLogic$5$BrDialogMenu(View view) {
        visibleHelpBlock(false);
    }
}
