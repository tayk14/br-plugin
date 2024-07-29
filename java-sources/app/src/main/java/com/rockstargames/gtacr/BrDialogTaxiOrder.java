package com.rockstargames.gtacr;

import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogTaxiOrder implements ISAMPGUI {
    private float PosX;
    private float PosY;
    private Button SendB;
    private Button mChangeEnd;
    private EditText mComment;
    private GUIManager mGUIManager;
    private NvEventQueueActivity mContext = null;
    private PopupWindow mWindow = null;
    private View mRootView = null;
    private PopupWindow mMapWindow = null;
    private View mMapView = null;
    private PopupWindow mWaitWindow = null;
    private View mWaitView = null;
    private PopupWindow mCommWindow = null;
    private View mCommView = null;
    private Animation anim = null;
    private boolean mClosed = true;
    private boolean mByCard = false;
    private int mAgrSelected = 0;
    private int mPriceSelected = 0;
    private int mPlayerMoney = 0;
    private int mPlayerCard = 0;
    private int[] mPrices = new int[9];
    private int[] mActivePrices = new int[9];
    LinearLayout[] Prices = new LinearLayout[3];
    float TempX = -20000.0f;
    float TempY = -20000.0f;
    float DestX = -20000.0f;
    float DestY = -20000.0f;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 17;
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogTaxiOrder();
    }

    private void MapStuff() {
        final ImageView imageView = (ImageView) this.mMapView.findViewById(R.id.br_taxi_map_dest);
        this.mMapView.findViewById(R.id.br_taxi_map_exit).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(BrDialogTaxiOrder.this.anim);
                new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BrDialogTaxiOrder.this.mMapWindow.dismiss();
                    }
                }, 400L);
            }
        });
        this.mMapView.findViewById(R.id.br_taxi_map_map).setOnTouchListener(new View.OnTouchListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (x < NvEventQueueActivity.dpToPx(8.0f, BrDialogTaxiOrder.this.mContext)) {
                        x = NvEventQueueActivity.dpToPx(8.0f, BrDialogTaxiOrder.this.mContext);
                    }
                    if (y < NvEventQueueActivity.dpToPx(8.0f, BrDialogTaxiOrder.this.mContext)) {
                        y = NvEventQueueActivity.dpToPx(8.0f, BrDialogTaxiOrder.this.mContext);
                    }
                    if (x > view.getWidth() - NvEventQueueActivity.dpToPx(8.0f, BrDialogTaxiOrder.this.mContext)) {
                        x = view.getWidth() - NvEventQueueActivity.dpToPx(8.0f, BrDialogTaxiOrder.this.mContext);
                    }
                    if (y > view.getHeight() - NvEventQueueActivity.dpToPx(8.0f, BrDialogTaxiOrder.this.mContext)) {
                        y = view.getHeight() - NvEventQueueActivity.dpToPx(8.0f, BrDialogTaxiOrder.this.mContext);
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(NvEventQueueActivity.dpToPx(16.0f, BrDialogTaxiOrder.this.mContext), NvEventQueueActivity.dpToPx(16.0f, BrDialogTaxiOrder.this.mContext));
                    layoutParams.setMargins(x - NvEventQueueActivity.dpToPx(8.0f, BrDialogTaxiOrder.this.mContext), y - NvEventQueueActivity.dpToPx(8.0f, BrDialogTaxiOrder.this.mContext), 0, 0);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setVisibility(0);
                    BrDialogTaxiOrder.this.mMapView.findViewById(R.id.br_taxi_map_select).setAlpha(1.0f);
                    BrDialogTaxiOrder.this.TempX = x;
                    BrDialogTaxiOrder.this.TempY = y;
                    BrDialogTaxiOrder.this.TempX -= view.getWidth() / 2.0f;
                    BrDialogTaxiOrder.this.TempY -= view.getHeight() / 2.0f;
                    BrDialogTaxiOrder.this.TempX *= 6000.0f / view.getWidth();
                    BrDialogTaxiOrder brDialogTaxiOrder = BrDialogTaxiOrder.this;
                    brDialogTaxiOrder.TempY = brDialogTaxiOrder.TempY * (6000.0f / view.getHeight()) * (-1.0f);
                }
                return true;
            }
        });
        this.mMapView.findViewById(R.id.br_taxi_map_select).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getAlpha() < 1.0f) {
                    return;
                }
                view.startAnimation(BrDialogTaxiOrder.this.anim);
                new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BrDialogTaxiOrder.this.DestX = BrDialogTaxiOrder.this.TempX;
                        BrDialogTaxiOrder.this.DestY = BrDialogTaxiOrder.this.TempY;
                        float sqrt = ((float) Math.sqrt(Math.pow(BrDialogTaxiOrder.this.DestX - BrDialogTaxiOrder.this.PosX, 2.0d) + Math.pow(BrDialogTaxiOrder.this.DestY - BrDialogTaxiOrder.this.PosY, 2.0d))) / 1000.0f;
                        for (int i = 0; i < 9; i++) {
                            BrDialogTaxiOrder.this.mActivePrices[i] = (int) ((3.0f + sqrt) * BrDialogTaxiOrder.this.mPrices[i]);
                        }
                        for (int i2 = 0; i2 < 3; i2++) {
                            ((TextView) BrDialogTaxiOrder.this.Prices[i2].getChildAt(1)).setText(String.format("%,.0f ₽", Float.valueOf(BrDialogTaxiOrder.this.mActivePrices[(BrDialogTaxiOrder.this.mAgrSelected * 3) + i2])));
                        }
                        if ((!BrDialogTaxiOrder.this.mByCard || BrDialogTaxiOrder.this.mPlayerCard >= BrDialogTaxiOrder.this.mActivePrices[BrDialogTaxiOrder.this.mPriceSelected + (BrDialogTaxiOrder.this.mAgrSelected * 3)]) && ((BrDialogTaxiOrder.this.mByCard || BrDialogTaxiOrder.this.mPlayerMoney >= BrDialogTaxiOrder.this.mActivePrices[BrDialogTaxiOrder.this.mPriceSelected + (BrDialogTaxiOrder.this.mAgrSelected * 3)]) && BrDialogTaxiOrder.this.DestX > -20000.0f)) {
                            BrDialogTaxiOrder.this.SendB.setAlpha(1.0f);
                        } else {
                            BrDialogTaxiOrder.this.SendB.setAlpha(0.5f);
                        }
                        BrDialogTaxiOrder.this.mChangeEnd.setBackground(ContextCompat.getDrawable(BrDialogTaxiOrder.this.mContext, R.drawable.button_br_red_unfilled));
                        BrDialogTaxiOrder.this.mChangeEnd.setText("Изменить");
                        BrDialogTaxiOrder.this.mMapWindow.dismiss();
                    }
                }, 400L);
            }
        });
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, final NvEventQueueActivity activity) {
        this.mContext = activity;
        this.mGUIManager = manager;
        if (this.mWindow == null) {
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
            this.mRootView = layoutInflater.inflate(R.layout.br_taxi_order, (ViewGroup) null, false);
            PopupWindow popupWindow = new PopupWindow(this.mRootView, -1, -1, true);
            this.mWindow = popupWindow;
            popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mWindow.setSoftInputMode(16);
            this.mGUIManager.setCustomTouchInterceptor(this.mWindow);
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.4
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (BrDialogTaxiOrder.this.mClosed) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("t", -1);
                            BrDialogTaxiOrder.this.mGUIManager.sendJsonData(17, jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    BrDialogTaxiOrder.this.mMapWindow.dismiss();
                    BrDialogTaxiOrder.this.mWaitWindow.dismiss();
                    BrDialogTaxiOrder.this.mGUIManager.closeGUI(null, 17);
                }
            });
            this.mMapView = layoutInflater.inflate(R.layout.br_taxi_map, (ViewGroup) null, false);
            PopupWindow popupWindow2 = new PopupWindow(this.mMapView, -1, -1, true);
            this.mMapWindow = popupWindow2;
            popupWindow2.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mMapWindow.setSoftInputMode(16);
            this.mWaitView = layoutInflater.inflate(R.layout.br_taxi_wait, (ViewGroup) null, false);
            PopupWindow popupWindow3 = new PopupWindow(this.mWaitView, -2, -2, true);
            this.mWaitWindow = popupWindow3;
            popupWindow3.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mWaitWindow.setSoftInputMode(16);
            this.mWaitWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (BrDialogTaxiOrder.this.mClosed) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("t", 1);
                            BrDialogTaxiOrder.this.mGUIManager.sendJsonData(17, jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            this.mWaitView.findViewById(R.id.br_taxi_wait_close).setOnTouchListener(new View.OnTouchListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    view.startAnimation(BrDialogTaxiOrder.this.anim);
                    new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BrDialogTaxiOrder.this.mWaitWindow.dismiss();
                        }
                    }, 400L);
                    return true;
                }
            });
            this.mCommView = layoutInflater.inflate(R.layout.br_taxi_comment, (ViewGroup) null, false);
            PopupWindow popupWindow4 = new PopupWindow(this.mCommView, -2, -2, true);
            this.mCommWindow = popupWindow4;
            popupWindow4.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mCommWindow.setSoftInputMode(16);
            this.mCommWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.7
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    BrDialogTaxiOrder.this.mWindow.dismiss();
                }
            });
            this.mCommView.findViewById(R.id.br_taxi_comment_close).setOnTouchListener(new View.OnTouchListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.8
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    view.startAnimation(BrDialogTaxiOrder.this.anim);
                    new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BrDialogTaxiOrder.this.mCommWindow.dismiss();
                        }
                    }, 400L);
                    return true;
                }
            });
            MapStuff();
            this.mRootView.findViewById(R.id.br_taxi_order_close).setOnTouchListener(new View.OnTouchListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.9
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    view.startAnimation(BrDialogTaxiOrder.this.anim);
                    new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BrDialogTaxiOrder.this.mWindow.dismiss();
                        }
                    }, 400L);
                    return true;
                }
            });
        }
        this.mContext = activity;
        this.anim = AnimationUtils.loadAnimation(activity, R.anim.button_click);
        final FrameLayout[] frameLayoutArr = {(FrameLayout) this.mRootView.findViewById(R.id.br_taxi_order_yandex), (FrameLayout) this.mRootView.findViewById(R.id.br_taxi_order_city), (FrameLayout) this.mRootView.findViewById(R.id.br_taxi_order_gett)};
        this.Prices[0] = (LinearLayout) this.mRootView.findViewById(R.id.br_taxi_order_econom);
        this.Prices[1] = (LinearLayout) this.mRootView.findViewById(R.id.br_taxi_order_comfotable);
        this.Prices[2] = (LinearLayout) this.mRootView.findViewById(R.id.br_taxi_order_business);
        this.SendB = (Button) this.mRootView.findViewById(R.id.br_taxi_order_send);
        this.mComment = (EditText) this.mRootView.findViewById(R.id.br_taxi_order_comm);
        Switch r3 = (Switch) this.mRootView.findViewById(R.id.br_taxi_order_check);
        final ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.br_taxi_order_money);
        final ImageView imageView2 = (ImageView) this.mRootView.findViewById(R.id.br_taxi_order_card);
        r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                BrDialogTaxiOrder.this.mByCard = b;
                if (b) {
                    imageView.getDrawable().setColorFilter(-11513776, PorterDuff.Mode.MULTIPLY);
                    imageView2.getDrawable().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
                } else {
                    imageView.getDrawable().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
                    imageView2.getDrawable().setColorFilter(-11513776, PorterDuff.Mode.MULTIPLY);
                }
                if ((!BrDialogTaxiOrder.this.mByCard || BrDialogTaxiOrder.this.mPlayerCard >= BrDialogTaxiOrder.this.mActivePrices[BrDialogTaxiOrder.this.mPriceSelected + (BrDialogTaxiOrder.this.mAgrSelected * 3)]) && ((BrDialogTaxiOrder.this.mByCard || BrDialogTaxiOrder.this.mPlayerMoney >= BrDialogTaxiOrder.this.mActivePrices[BrDialogTaxiOrder.this.mPriceSelected + (BrDialogTaxiOrder.this.mAgrSelected * 3)]) && BrDialogTaxiOrder.this.DestX > -20000.0f)) {
                    BrDialogTaxiOrder.this.SendB.setAlpha(1.0f);
                } else {
                    BrDialogTaxiOrder.this.SendB.setAlpha(0.5f);
                }
            }
        });
        Button button = (Button) this.mRootView.findViewById(R.id.br_taxi_order_end_butt);
        this.mChangeEnd = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(BrDialogTaxiOrder.this.anim);
                new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("t", 2);
                            BrDialogTaxiOrder.this.mGUIManager.sendJsonData(17, jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 400L);
            }
        });
        final TextView[] textViewArr = {(TextView) this.mRootView.findViewById(R.id.br_taxi_text_yandex), (TextView) this.mRootView.findViewById(R.id.br_taxi_text_city), (TextView) this.mRootView.findViewById(R.id.br_taxi_text_gett)};
        try {
            ((TextView) this.mRootView.findViewById(R.id.br_taxi_order_start)).setText("Ваш адрес: " + json.getString("pl"));
            this.mPlayerMoney = json.getInt("m");
            this.mPlayerCard = json.getInt("ca");
            for (int i = 0; i < 9; i++) {
                int[] iArr = this.mActivePrices;
                int[] iArr2 = this.mPrices;
                int i2 = json.getJSONArray(TuningConstants.KEY_GET_ID_DETAIL).getInt(i);
                iArr2[i] = i2;
                iArr[i] = i2;
            }
            this.PosX = json.getInt("x");
            this.PosY = json.getInt("y");
            int i3 = 0;
            while (i3 < 3) {
                textViewArr[i3].setVisibility(4);
                frameLayoutArr[i3].setBackground(ContextCompat.getDrawable(this.mContext, i3 == 0 ? R.drawable.br_list_active : R.drawable.background_br_input));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayoutArr[i3].getLayoutParams();
                layoutParams.width = NvEventQueueActivity.dpToPx(120.0f, this.mContext);
                layoutParams.height = NvEventQueueActivity.dpToPx(50.0f, this.mContext);
                layoutParams.topMargin = NvEventQueueActivity.dpToPx(10.0f, this.mContext);
                layoutParams.rightMargin = NvEventQueueActivity.dpToPx(15.0f, this.mContext);
                frameLayoutArr[i3].setLayoutParams(layoutParams);
                if (i3 == json.getInt("f") || i3 == json.getInt("s")) {
                    textViewArr[i3].setVisibility(0);
                    if (i3 == json.getInt("s")) {
                        textViewArr[i3].setText("Повышенный спрос");
                    } else {
                        textViewArr[i3].setText("Самый быстрый");
                    }
                    frameLayoutArr[i3].setBackground(ContextCompat.getDrawable(this.mContext, i3 == 0 ? R.drawable.br_taxi_aelem : R.drawable.br_taxi_elem));
                    layoutParams.width = NvEventQueueActivity.dpToPx(130.0f, this.mContext);
                    layoutParams.height = NvEventQueueActivity.dpToPx(60.0f, this.mContext);
                    layoutParams.rightMargin = NvEventQueueActivity.dpToPx(5.0f, this.mContext);
                    layoutParams.topMargin = 0;
                    frameLayoutArr[i3].setLayoutParams(layoutParams);
                }
                i3++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i4 = 0; i4 < 3; i4++) {
            frameLayoutArr[i4].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    view.startAnimation(BrDialogTaxiOrder.this.anim);
                    int i5 = 0;
                    while (true) {
                        if (i5 >= 3) {
                            i5 = -1;
                            break;
                        } else if (view == frameLayoutArr[i5]) {
                            break;
                        } else {
                            i5++;
                        }
                    }
                    frameLayoutArr[BrDialogTaxiOrder.this.mAgrSelected].setBackground(ContextCompat.getDrawable(BrDialogTaxiOrder.this.mContext, textViewArr[BrDialogTaxiOrder.this.mAgrSelected].getVisibility() == 0 ? R.drawable.br_taxi_elem : R.drawable.background_br_input));
                    frameLayoutArr[i5].setBackground(ContextCompat.getDrawable(BrDialogTaxiOrder.this.mContext, textViewArr[i5].getVisibility() == 0 ? R.drawable.br_taxi_aelem : R.drawable.br_list_active));
                    BrDialogTaxiOrder.this.mAgrSelected = i5;
                    if ((!BrDialogTaxiOrder.this.mByCard || BrDialogTaxiOrder.this.mPlayerCard >= BrDialogTaxiOrder.this.mActivePrices[BrDialogTaxiOrder.this.mPriceSelected + (BrDialogTaxiOrder.this.mAgrSelected * 3)]) && ((BrDialogTaxiOrder.this.mByCard || BrDialogTaxiOrder.this.mPlayerMoney >= BrDialogTaxiOrder.this.mActivePrices[BrDialogTaxiOrder.this.mPriceSelected + (BrDialogTaxiOrder.this.mAgrSelected * 3)]) && BrDialogTaxiOrder.this.DestX > -20000.0f)) {
                        BrDialogTaxiOrder.this.SendB.setAlpha(1.0f);
                    } else {
                        BrDialogTaxiOrder.this.SendB.setAlpha(0.5f);
                    }
                    for (int i6 = 0; i6 < 3; i6++) {
                        ((TextView) BrDialogTaxiOrder.this.Prices[i6].getChildAt(1)).setText(String.format("%,.0f ₽", Float.valueOf(BrDialogTaxiOrder.this.mActivePrices[(BrDialogTaxiOrder.this.mAgrSelected * 3) + i6])));
                    }
                }
            });
            this.Prices[i4].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    view.startAnimation(BrDialogTaxiOrder.this.anim);
                    int i5 = 0;
                    while (true) {
                        if (i5 >= 3) {
                            i5 = -1;
                            break;
                        } else if (view == BrDialogTaxiOrder.this.Prices[i5]) {
                            break;
                        } else {
                            i5++;
                        }
                    }
                    BrDialogTaxiOrder.this.Prices[BrDialogTaxiOrder.this.mPriceSelected].setBackground(ContextCompat.getDrawable(BrDialogTaxiOrder.this.mContext, R.drawable.background_br_input));
                    BrDialogTaxiOrder.this.Prices[i5].setBackground(ContextCompat.getDrawable(BrDialogTaxiOrder.this.mContext, R.drawable.br_rent_exit));
                    BrDialogTaxiOrder.this.mPriceSelected = i5;
                    if ((!BrDialogTaxiOrder.this.mByCard || BrDialogTaxiOrder.this.mPlayerCard >= BrDialogTaxiOrder.this.mActivePrices[BrDialogTaxiOrder.this.mPriceSelected + (BrDialogTaxiOrder.this.mAgrSelected * 3)]) && ((BrDialogTaxiOrder.this.mByCard || BrDialogTaxiOrder.this.mPlayerMoney >= BrDialogTaxiOrder.this.mActivePrices[BrDialogTaxiOrder.this.mPriceSelected + (BrDialogTaxiOrder.this.mAgrSelected * 3)]) && BrDialogTaxiOrder.this.DestX > -20000.0f)) {
                        BrDialogTaxiOrder.this.SendB.setAlpha(1.0f);
                    } else {
                        BrDialogTaxiOrder.this.SendB.setAlpha(0.5f);
                    }
                }
            });
        }
        this.SendB.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getAlpha() < 1.0f) {
                    return;
                }
                view.startAnimation(BrDialogTaxiOrder.this.anim);
                new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogTaxiOrder.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("t", 0);
                            jSONObject.put("x", BrDialogTaxiOrder.this.DestX);
                            jSONObject.put("y", BrDialogTaxiOrder.this.DestY);
                            jSONObject.put("a", BrDialogTaxiOrder.this.mAgrSelected);
                            jSONObject.put(TuningConstants.KEY_GET_ID_DETAIL, BrDialogTaxiOrder.this.mPriceSelected);
                            jSONObject.put("m", BrDialogTaxiOrder.this.mByCard ? 0 : 1);
                            jSONObject.put("ma", BrDialogTaxiOrder.this.mActivePrices[(BrDialogTaxiOrder.this.mAgrSelected * 3) + BrDialogTaxiOrder.this.mPriceSelected]);
                            jSONObject.put(TuningConstants.KEY_SEND_COLOR_FOR_PREVIEW, BrDialogTaxiOrder.this.mComment.getText().toString());
                            BrDialogTaxiOrder.this.mGUIManager.sendJsonData(17, jSONObject);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        BrDialogTaxiOrder.this.mWaitWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
                    }
                }, 400L);
            }
        });
        boolean z = this.mByCard;
        if ((!z || this.mPlayerCard >= this.mActivePrices[this.mPriceSelected + (this.mAgrSelected * 3)]) && ((z || this.mPlayerMoney >= this.mActivePrices[this.mPriceSelected + (this.mAgrSelected * 3)]) && this.DestX > -20000.0f)) {
            this.SendB.setAlpha(1.0f);
        } else {
            this.SendB.setAlpha(0.5f);
        }
        for (int i5 = 0; i5 < 3; i5++) {
            ((TextView) this.Prices[i5].getChildAt(1)).setText(String.format("%,.0f ₽", Float.valueOf(this.mActivePrices[(this.mAgrSelected * 3) + i5])));
        }
        imageView2.getDrawable().setColorFilter(-11513776, PorterDuff.Mode.MULTIPLY);
        this.mWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
        try {
            int i = json.getInt("t");
            if (i == 0) {
                this.mClosed = false;
                this.mWaitWindow.dismiss();
                ((TextView) this.mCommView.findViewById(R.id.br_taxi_comment_title)).setText("Автомобиль найден");
                ((TextView) this.mCommView.findViewById(R.id.br_taxi_comment_comm)).setGravity(2);
                ((TextView) this.mCommView.findViewById(R.id.br_taxi_comment_comm)).setPadding(NvEventQueueActivity.dpToPx(20.0f, this.mContext), 0, 0, 0);
                ((TextView) this.mCommView.findViewById(R.id.br_taxi_comment_comm)).setText(Html.fromHtml("Имя: " + json.getString("n") + "<br>Номер: " + json.getString("nu") + "<br>Авто: " + json.getString("a")));
                Vibrator vibrator = (Vibrator) this.mContext.getSystemService("vibrator");
                if (vibrator.hasVibrator()) {
                    vibrator.vibrate(300L);
                }
                this.mCommWindow.showAtLocation(this.mContext.getParentLayout(), 17, 0, 0);
                return;
            }
            if (i == 1) {
                this.mMapWindow.showAtLocation(this.mContext.getParentLayout(), 17, 0, 0);
                return;
            }
            if (i != 2) {
                return;
            }
            this.DestX = (float) json.getDouble("x");
            this.DestY = (float) json.getDouble("y");
            float sqrt = ((float) Math.sqrt(Math.pow(this.DestX - this.PosX, 2.0d) + Math.pow(this.DestY - this.PosY, 2.0d))) / 1000.0f;
            for (int i2 = 0; i2 < 9; i2++) {
                this.mActivePrices[i2] = (int) ((3.0f + sqrt) * this.mPrices[i2]);
            }
            for (int i3 = 0; i3 < 3; i3++) {
                ((TextView) this.Prices[i3].getChildAt(1)).setText(String.format("%,.0f ₽", Float.valueOf(this.mActivePrices[(this.mAgrSelected * 3) + i3])));
            }
            boolean z = this.mByCard;
            if ((!z || this.mPlayerCard >= this.mActivePrices[this.mPriceSelected + (this.mAgrSelected * 3)]) && ((z || this.mPlayerMoney >= this.mActivePrices[this.mPriceSelected + (this.mAgrSelected * 3)]) && this.DestX > -20000.0f)) {
                this.SendB.setAlpha(1.0f);
            } else {
                this.SendB.setAlpha(0.5f);
            }
            this.mChangeEnd.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.button_br_red_unfilled));
            this.mChangeEnd.setText("Изменить");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
