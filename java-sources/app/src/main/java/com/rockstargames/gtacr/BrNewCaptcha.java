package com.rockstargames.gtacr;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.net.URL;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrNewCaptcha implements ISAMPGUI {
    private static boolean mIsShowing = false;
    private String CaptchaURL;
    private boolean dontSend;
    DownloadImageTask task;
    private Activity mContext = null;
    private GUIManager mGUIManager = null;
    private PopupWindow mWindow = null;
    private View mViewRoot = null;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 26;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    /* loaded from: classes2.dex */
    private class DownloadImageTask extends Thread {
        FrameLayout bmImage;
        Bitmap mIcon11;
        String urls;

        public DownloadImageTask(FrameLayout bmImage, String url) {
            this.bmImage = bmImage;
            this.urls = url;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String str = this.urls;
            this.mIcon11 = null;
            try {
                this.mIcon11 = BitmapFactory.decodeStream(new URL(str).openStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (BrNewCaptcha.mIsShowing) {
                BrNewCaptcha.this.mContext.runOnUiThread(new Runnable() { // from class: com.rockstargames.gtacr.BrNewCaptcha.DownloadImageTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadImageTask.this.bmImage.setBackground(new BitmapDrawable(BrNewCaptcha.this.mContext.getResources(), DownloadImageTask.this.mIcon11));
                        DownloadImageTask.this.bmImage.getChildAt(0).setVisibility(4);
                    }
                });
            }
        }
    }

    public static ISAMPGUI newInstance() {
        return new BrNewCaptcha();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        if (mIsShowing) {
            return;
        }
        mIsShowing = true;
        if (activity != null) {
            this.mContext = activity;
        }
        this.mGUIManager = manager;
        try {
            this.CaptchaURL = json.getString(TuningConstants.KEY_GET_ALL_COLLAPSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.mWindow == null) {
            this.mViewRoot = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.br_new_captcha, (ViewGroup) null, false);
            PopupWindow popupWindow = new PopupWindow(this.mViewRoot, -2, -2, true);
            this.mWindow = popupWindow;
            popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mGUIManager.setCustomTouchInterceptor(this.mWindow);
            this.mWindow.setSoftInputMode(16);
            DownloadImageTask downloadImageTask = new DownloadImageTask((FrameLayout) this.mViewRoot.findViewById(R.id.br_new_captha_img), this.CaptchaURL);
            this.task = downloadImageTask;
            downloadImageTask.start();
            final EditText editText = (EditText) this.mViewRoot.findViewById(R.id.br_new_caphca_line);
            final Button button = (Button) this.mViewRoot.findViewById(R.id.br_new_capcha_ok);
            button.setAlpha(0.6f);
            editText.addTextChangedListener(new TextWatcher() { // from class: com.rockstargames.gtacr.BrNewCaptcha.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (editable.toString().isEmpty()) {
                        button.setAlpha(0.6f);
                    } else {
                        button.setAlpha(1.0f);
                    }
                }
            });
            final Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.button_click);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrNewCaptcha.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getAlpha() < 1.0f) {
                        return;
                    }
                    view.startAnimation(loadAnimation);
                    new Handler().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrNewCaptcha.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("t", 0);
                                jSONObject.put("s", editText.getText().toString());
                                BrNewCaptcha.this.mGUIManager.sendJsonData(26, jSONObject);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }, 400L);
                }
            });
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.BrNewCaptcha.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (BrNewCaptcha.this.task != null) {
                        DownloadImageTask downloadImageTask2 = BrNewCaptcha.this.task;
                        BrNewCaptcha.this.task = null;
                        downloadImageTask2.interrupt();
                    }
                    if (!BrNewCaptcha.this.dontSend) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("t", 0);
                            jSONObject.put("s", editText.getText().toString());
                            BrNewCaptcha.this.mGUIManager.sendJsonData(26, jSONObject);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    boolean unused = BrNewCaptcha.mIsShowing = false;
                }
            });
            this.mWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow != null) {
            this.dontSend = true;
            popupWindow.dismiss();
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        return mIsShowing;
    }
}
