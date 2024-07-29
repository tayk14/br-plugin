package com.rockstargames.gtacr;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogMap implements ISAMPGUI {
    private GUIManager mGUIManager;
    private NvEventQueueActivity mContext = null;
    private PopupWindow mMapWindow = null;
    private View mMapView = null;
    private Animation anim = null;
    private boolean mClosed = true;
    float TempX = -20000.0f;
    float TempY = -20000.0f;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 21;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogMap();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mContext = activity;
        this.mGUIManager = manager;
        if (this.mMapWindow == null) {
            this.mMapView = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.br_taxi_map, (ViewGroup) null, false);
            PopupWindow popupWindow = new PopupWindow(this.mMapView, -1, -1, true);
            this.mMapWindow = popupWindow;
            popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mMapWindow.setSoftInputMode(16);
        }
        this.anim = AnimationUtils.loadAnimation(this.mContext, R.anim.button_click);
        final ImageView imageView = (ImageView) this.mMapView.findViewById(R.id.br_taxi_map_dest);
        this.mMapView.findViewById(R.id.br_taxi_map_exit).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogMap.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.startAnimation(BrDialogMap.this.anim);
                new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogMap.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BrDialogMap.this.mMapWindow.dismiss();
                    }
                }, 400L);
            }
        });
        this.mMapView.findViewById(R.id.br_taxi_map_map).setOnTouchListener(new View.OnTouchListener() { // from class: com.rockstargames.gtacr.BrDialogMap.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (x < NvEventQueueActivity.dpToPx(8.0f, BrDialogMap.this.mContext)) {
                        x = NvEventQueueActivity.dpToPx(8.0f, BrDialogMap.this.mContext);
                    }
                    if (y < NvEventQueueActivity.dpToPx(8.0f, BrDialogMap.this.mContext)) {
                        y = NvEventQueueActivity.dpToPx(8.0f, BrDialogMap.this.mContext);
                    }
                    if (x > view.getWidth() - NvEventQueueActivity.dpToPx(8.0f, BrDialogMap.this.mContext)) {
                        x = view.getWidth() - NvEventQueueActivity.dpToPx(8.0f, BrDialogMap.this.mContext);
                    }
                    if (y > view.getHeight() - NvEventQueueActivity.dpToPx(8.0f, BrDialogMap.this.mContext)) {
                        y = view.getHeight() - NvEventQueueActivity.dpToPx(8.0f, BrDialogMap.this.mContext);
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(NvEventQueueActivity.dpToPx(16.0f, BrDialogMap.this.mContext), NvEventQueueActivity.dpToPx(16.0f, BrDialogMap.this.mContext));
                    layoutParams.setMargins(x - NvEventQueueActivity.dpToPx(8.0f, BrDialogMap.this.mContext), y - NvEventQueueActivity.dpToPx(8.0f, BrDialogMap.this.mContext), 0, 0);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setVisibility(0);
                    BrDialogMap.this.mMapView.findViewById(R.id.br_taxi_map_select).setAlpha(1.0f);
                    BrDialogMap.this.TempX = x;
                    BrDialogMap.this.TempY = y;
                    BrDialogMap.this.TempX -= view.getWidth() / 2.0f;
                    BrDialogMap.this.TempY -= view.getHeight() / 2.0f;
                    BrDialogMap.this.TempX *= 6000.0f / view.getWidth();
                    BrDialogMap brDialogMap = BrDialogMap.this;
                    brDialogMap.TempY = brDialogMap.TempY * (6000.0f / view.getHeight()) * (-1.0f);
                }
                return true;
            }
        });
        this.mMapView.findViewById(R.id.br_taxi_map_select).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogMap.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getAlpha() < 1.0f) {
                    return;
                }
                view.startAnimation(BrDialogMap.this.anim);
                new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogMap.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("t", 0);
                            jSONObject.put("x", BrDialogMap.this.TempX);
                            jSONObject.put("y", BrDialogMap.this.TempY);
                            BrDialogMap.this.mGUIManager.sendJsonData(21, jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        BrDialogMap.this.mClosed = false;
                        BrDialogMap.this.mMapWindow.dismiss();
                    }
                }, 400L);
            }
        });
        this.mMapWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.BrDialogMap.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (BrDialogMap.this.mClosed) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("t", -1);
                        BrDialogMap.this.mGUIManager.sendJsonData(21, jSONObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BrDialogMap.this.mGUIManager.closeGUI(null, 21);
            }
        });
        this.mMapWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        PopupWindow popupWindow = this.mMapWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.mMapWindow;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }
}
