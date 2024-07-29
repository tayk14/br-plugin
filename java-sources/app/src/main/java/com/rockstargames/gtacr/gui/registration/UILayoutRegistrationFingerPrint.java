package com.rockstargames.gtacr.gui.registration;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import blackrussia.online.R;
import com.google.firebase.messaging.Constants;
import com.rockstargames.gtacr.common.GUIPopupWindow;
import com.rockstargames.gtacr.common.UIContainer;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

public class UILayoutRegistrationFingerPrint extends UILayout {
    LinearLayout butBack;
    Button butSkip;
    ImageView imgAutoHint;
    ImageView imgFinger;
    LinearLayout llText;
    private GUIRegistration mRoot;
    private GUIPopupWindow mScannerWindow;
    private UILayoutRegistrationGeneral mUIParent;
    private View mViewRoot = null;
    Switch switchAuto;

    @Override
    public void onLayoutClose() {
    }

    public UILayoutRegistrationFingerPrint(GUIRegistration root) {
        this.mRoot = root;
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.reg_fingerprint, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        this.imgFinger = (ImageView) inflate.findViewById(R.id.finger_img);
        this.butBack = (LinearLayout) this.mViewRoot.findViewById(R.id.back);
        this.switchAuto = (Switch) this.mViewRoot.findViewById(R.id.auto_switch);
        this.llText = (LinearLayout) this.mViewRoot.findViewById(R.id.auto_text);
        this.butSkip = (Button) this.mViewRoot.findViewById(R.id.butt_skip);
        this.imgAutoHint = (ImageView) this.mViewRoot.findViewById(R.id.auto_img);
        this.mUIParent = (UILayoutRegistrationGeneral) this.mRoot.mContainer.getLayout(0);
        if (this.mRoot.mIsRegistration) {
            this.switchAuto.setVisibility(8);
            this.llText.setVisibility(8);
            this.butSkip.setVisibility(0);
        } else {
            this.switchAuto.setVisibility(0);
            this.llText.setVisibility(0);
            this.butSkip.setVisibility(8);
        }
        this.imgFinger.setOnClickListener(new AnonymousClass1(this));
        this.butSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(UILayoutRegistrationFingerPrint.this.mRoot.mAnim);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 2);
                    jSONObject.put("s", "");
                    jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, 0);
                    UILayoutRegistrationFingerPrint.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                UIContainer uIContainer = UILayoutRegistrationFingerPrint.this.mUIParent.mContainer;
                UILayoutRegistrationGeneral unused = UILayoutRegistrationFingerPrint.this.mUIParent;
                uIContainer.setCurrentLayout(3);
            }
        });
        this.switchAuto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    UILayoutRegistrationFingerPrint.this.switchAuto.setThumbResource(R.drawable.switch_circle);
                } else {
                    UILayoutRegistrationFingerPrint.this.switchAuto.setThumbResource(R.drawable.switch_off_circle);
                }
            }
        });
        this.imgAutoHint.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.startAnimation(UILayoutRegistrationFingerPrint.this.mRoot.mAnim);
                UILayoutRegistrationFingerPrint.this.mRoot.showPopup("Автовход", "При активации переключателя автовхода, система запомнит ваши данные и авторизует вас автоматически, при следующей авторизации без ввода данных. Активация автовхода работает в течении 15 минут после последнего отключения от сервера. По истечению времени после отключения игрока с сервера, автовход автоматически отключается.", "Ок", null, null);
                return false;
            }
        });
        this.butBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.startAnimation(UILayoutRegistrationFingerPrint.this.mRoot.mAnim);
                if (UILayoutRegistrationFingerPrint.this.mRoot.mIsRegistration) {
                    UIContainer uIContainer = UILayoutRegistrationFingerPrint.this.mUIParent.mContainer;
                    UILayoutRegistrationGeneral unused = UILayoutRegistrationFingerPrint.this.mUIParent;
                    uIContainer.setCurrentLayout(1);
                    return false;
                }
                UIContainer uIContainer2 = UILayoutRegistrationFingerPrint.this.mUIParent.mContainer;
                UILayoutRegistrationGeneral unused2 = UILayoutRegistrationFingerPrint.this.mUIParent;
                uIContainer2.setCurrentLayout(4);
                return false;
            }
        });
        return this.mViewRoot;
    }

    public class AnonymousClass1 implements View.OnClickListener {
        final UILayoutRegistrationFingerPrint val$parentUI;

        AnonymousClass1(final UILayoutRegistrationFingerPrint val$parentUI) {
            this.val$parentUI = val$parentUI;
        }

        @Override
        public void onClick(View view) {
            view.startAnimation(UILayoutRegistrationFingerPrint.this.mRoot.mAnim);
            new Handler().postDelayed(new RunnableC00451(), 300L);
        }

        public class RunnableC00451 implements Runnable {
            RunnableC00451() {
            }

            @Override
            public void run() {
                if (UILayoutRegistrationFingerPrint.this.mScannerWindow != null) {
                    UILayoutRegistrationFingerPrint.this.mScannerWindow.dismiss();
                }
                View inflate = ((LayoutInflater) UILayoutRegistrationFingerPrint.this.mRoot.mActivity.getSystemService("layout_inflater")).inflate(R.layout.halloween_popup, (ViewGroup) null, false);
                UILayoutRegistrationFingerPrint.this.mScannerWindow = new GUIPopupWindow(inflate, -2, -2, false);
                inflate.findViewById(R.id.close).setVisibility(8);
                inflate.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                UILayoutRegistrationFingerPrint.this.mScannerWindow.dismiss();
                            }
                        }, 500L);
                    }
                });
                ((TextView) inflate.findViewById(R.id.header)).setText("Сканер");
                ((TextView) inflate.findViewById(R.id.content)).setText("Приложите палец к сканеру отпечатков");
                ((Button) inflate.findViewById(R.id.ok)).setText("Назад");
                UILayoutRegistrationFingerPrint.this.mScannerWindow.showAtLocation(UILayoutRegistrationFingerPrint.this.mRoot.mActivity.getParentLayout(), 17, 0, 0);
                UILayoutRegistrationFingerPrint.this.mScannerWindow.setDimming(1.0f);
            }
        }
    }

    @Override
    public void onLayoutShown() {
        if (!this.mRoot.mIsRegistration) {
            this.mUIParent.textHint.setText("Кликните по отпечатку пальца для того чтобы идентифицировать вас!");
        } else {
            this.mUIParent.textHint.setText("Активировав отпечаток пальца, вы сможете входить без ввода пароля.\n\nКликните по отпечатку пальца для того чтобы идентифицировать вас.");
        }
    }

    public void OnScanResult(String key) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 2);
            jSONObject.put("s", key);
            jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, this.mRoot.mIsRegistration ? 0 : 1);
            jSONObject.put("tt", this.switchAuto.isChecked() ? 1 : 0);
            this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
