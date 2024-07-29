package com.rockstargames.gtacr.gui.registration;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.common.GUIPopupWindow;
import com.rockstargames.gtacr.common.UIContainer;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

public class GUIRegistration implements ISAMPGUI {
    public static final int REGISTATION_LAYOUT_CHOOSE_SEX = 1;
    public static final int REGISTATION_LAYOUT_GENERAL = 0;
    public static final int REGISTATION_LAYOUT_PERSON = 2;
    public static final int REGISTRATION_RESTORE = 0;
    public static final int REGISTRATION_RESTORE_NEW = 1;
    public static final int REGISTRATION_RESTORE_PIN = 2;
    public static final int REGISTRATION_RESTORE_PIN_AUTH = 4;
    public static final int REGISTRATION_RESTORE_PIN_NEW = 3;
    public int mT;
    UILayoutRegistrationGeneral uiGeneral;
    public NvEventQueueActivity mActivity = null;
    public GUIManager mGUIManager = null;
    private GUIPopupWindow mWindow = null;
    private GUIPopupWindow mPopup = null;
    public UIContainer mContainer = null;
    public View mViewRoot = null;
    public Bitmap mLogoBitmap = null;
    public Animation mAnim = null;
    public boolean mIsRegistration = false;
    public boolean mHasFingerprint = false;
    public boolean mNeedPasswordNow = false;
    public boolean mHasMail = false;
    public int mRestoreSet = -1;
    public boolean isMale = true;
    public int mRestoreMethod = 0;

    @Override
    public int getGuiId() {
        return 38;
    }

    public static ISAMPGUI newInstance() {
        return new GUIRegistration();
    }

    @Override
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mGUIManager = manager;
        this.mActivity = activity;
        if (this.mWindow == null) {
            this.mViewRoot = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.registration_mainframe, (ViewGroup) null, false);
            GUIPopupWindow gUIPopupWindow = new GUIPopupWindow(this.mViewRoot, -1, -1, true);
            this.mWindow = gUIPopupWindow;
            gUIPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    GUIRegistration.this.mGUIManager.notifyGUIClosed(GUIRegistration.this.getGuiId(), null);
                    GUIRegistration.this.mActivity.toggleDrawing2dStuff(false);
                }
            });
            this.mWindow.setAnimationStyle(R.style.PopupWindowAnimation);
        }
        GUIManager.hideSystemUI(this.mViewRoot);
        this.mAnim = AnimationUtils.loadAnimation(activity, R.anim.button_click);
        this.mIsRegistration = json.optInt(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL) == 0;
        this.mHasFingerprint = json.optInt("f", 0) == 1;
        this.mNeedPasswordNow = json.optInt("f", 0) == 2;
        this.mHasMail = json.optInt(TuningConstants.KEY_GET_ID_DETAIL, 0) != 0;
        UIContainer uIContainer = (UIContainer) this.mViewRoot.findViewById(R.id.container);
        this.mContainer = uIContainer;
        uIContainer.addLayout(0, new UILayoutRegistrationGeneral(this));
        this.mContainer.addLayout(1, new UILayoutRegistrationSex(this));
        this.mContainer.addLayout(2, new UILayoutRegistrationPerson(this));
        this.uiGeneral = (UILayoutRegistrationGeneral) this.mContainer.getLayout(0);
        this.mContainer.setCurrentLayout(0);
        this.mActivity.toggleDrawing2dStuff(true);
        this.mWindow.showAtLocation(this.mActivity.getParentLayout(), 17, 0, 0);
    }

    @Override
    public void onPacketIncoming(JSONObject json) {
        int optInt = json.optInt("t");
        this.mT = optInt;
        UILayoutRegistrationGeneral uILayoutRegistrationGeneral = (UILayoutRegistrationGeneral) this.mContainer.getLayout(0);
        if (optInt != 0) {
            if (optInt == 1) {
                this.mRestoreSet = 2;
                uILayoutRegistrationGeneral.mContainer.setCurrentLayout(1);
            } else if (optInt == 2) {
                this.mRestoreSet = 3;
                uILayoutRegistrationGeneral.mContainer.setCurrentLayout(1);
            } else if (optInt == 3) {
                this.mIsRegistration = true;
                this.uiGeneral.mContainer.setCurrentLayout(3);
                this.mContainer.setCurrentLayout(1);
            } else if (optInt != 4) {
            } else {
                this.mRestoreMethod = json.optInt("m");
                this.mRestoreSet = 0;
                uILayoutRegistrationGeneral.mContainer.setCurrentLayout(1);
            }
        } else if (this.mIsRegistration) {
            int currentLayoutId = this.uiGeneral.mContainer.getCurrentLayoutId();
            UILayoutRegistrationGeneral uILayoutRegistrationGeneral2 = this.uiGeneral;
            if (currentLayoutId != 3) {
                if (uILayoutRegistrationGeneral2.mContainer.getCurrentLayoutId() == 1 && !this.mActivity.isSupportFingerPrint) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("t", 2);
                        jSONObject.put("s", "");
                        jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, 0);
                        this.mGUIManager.sendJsonData(38, jSONObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.uiGeneral.mContainer.setCurrentLayout(3);
                    return;
                }
                this.uiGeneral.mContainer.setCurrentLayout(this.uiGeneral.mContainer.getCurrentLayoutId() + 1);
            } else if (this.mContainer.getCurrentLayoutId() != 1) {
                this.mContainer.setCurrentLayout(1);
            } else {
                this.mContainer.setCurrentLayout(2);
                this.mViewRoot.setBackground(null);
            }
        } else if (uILayoutRegistrationGeneral.mContainer.getCurrentLayoutId() == 1) {
            int i = this.mRestoreSet;
            if (i == 0) {
                this.mRestoreSet = i + 1;
                uILayoutRegistrationGeneral.mContainer.setCurrentLayout(1);
                return;
            }
            this.mWindow.dismiss();
        } else {
            this.mWindow.dismiss();
        }
    }

    @Override
    public void close(JSONObject json) {
        GUIPopupWindow gUIPopupWindow = this.mWindow;
        if (gUIPopupWindow != null) {
            gUIPopupWindow.dismiss();
        }
    }

    @Override
    public boolean isShowingGui() {
        GUIPopupWindow gUIPopupWindow = this.mWindow;
        if (gUIPopupWindow != null) {
            return gUIPopupWindow.isShowing();
        }
        return false;
    }

    public void showPopup(String header, String content, String button, View.OnClickListener closeListener, View.OnClickListener okListener) {
        GUIPopupWindow gUIPopupWindow = this.mPopup;
        if (gUIPopupWindow != null) {
            gUIPopupWindow.dismiss();
        }
        View inflate = ((LayoutInflater) this.mActivity.getSystemService("layout_inflater")).inflate(R.layout.halloween_popup, (ViewGroup) null, false);
        this.mPopup = new GUIPopupWindow(inflate, -2, -2, true);
        inflate.findViewById(R.id.ok).setOnClickListener(okListener);
        if (closeListener != null) {
            inflate.findViewById(R.id.close).setOnClickListener(closeListener);
        } else {
            inflate.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GUIRegistration.this.mPopup.dismiss();
                }
            });
        }
        if (okListener != null) {
            inflate.findViewById(R.id.ok).setOnClickListener(okListener);
        } else {
            inflate.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GUIRegistration.this.mPopup.dismiss();
                }
            });
        }
        ((TextView) inflate.findViewById(R.id.header)).setText(header);
        ((TextView) inflate.findViewById(R.id.content)).setText(content);
        ((TextView) inflate.findViewById(R.id.content)).setTextSize(2, 12.0f);
        ((Button) inflate.findViewById(R.id.ok)).setText(button);
        this.mPopup.showAtLocation(this.mActivity.getParentLayout(), 17, 0, 0);
        this.mPopup.setDimming(0.8f);
    }
}
