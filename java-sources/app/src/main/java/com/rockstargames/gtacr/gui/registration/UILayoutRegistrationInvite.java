package com.rockstargames.gtacr.gui.registration;

import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.common.CustomEditTextWithBackPressEvent;
import com.rockstargames.gtacr.common.UILayout;
import org.json.JSONObject;

public class UILayoutRegistrationInvite extends UILayout {
    Button butEnter;
    Button butSkip;
    CustomEditTextWithBackPressEvent editInvite;
    private GUIRegistration mRoot;
    UILayoutRegistrationGeneral mUIParent;
    private View mViewRoot = null;
    TextView textInvite;

    @Override
    public void onLayoutClose() {
    }

    public UILayoutRegistrationInvite(GUIRegistration root) {
        this.mRoot = root;
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.reg_invite, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        this.editInvite = (CustomEditTextWithBackPressEvent) inflate.findViewById(R.id.invite_nick);
        this.textInvite = (TextView) this.mViewRoot.findViewById(R.id.text_invite);
        this.butEnter = (Button) this.mViewRoot.findViewById(R.id.but_continue);
        this.butSkip = (Button) this.mViewRoot.findViewById(R.id.but_skip);
        this.mUIParent = (UILayoutRegistrationGeneral) this.mRoot.mContainer.getLayout(0);
        this.textInvite.setText(Html.fromHtml("Введя никнейм пригласившего вас игрока, <font color=#FFC634>он и вы</font> получите ценные призы по достижению <font color=#FFC634>3 уровня</font>!"));
        this.butEnter.setAlpha(0.5f);
        this.editInvite.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                UILayoutRegistrationInvite.this.editInvite.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) UILayoutRegistrationInvite.this.editInvite.getLayoutParams();
                int width = (int) (UILayoutRegistrationInvite.this.editInvite.getWidth() * 0.16f);
                layoutParams.height = width;
                UILayoutRegistrationInvite.this.editInvite.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) UILayoutRegistrationInvite.this.butEnter.getLayoutParams();
                layoutParams2.height = width;
                UILayoutRegistrationInvite.this.butEnter.setLayoutParams(layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) UILayoutRegistrationInvite.this.butSkip.getLayoutParams();
                layoutParams3.height = width;
                UILayoutRegistrationInvite.this.butSkip.setLayoutParams(layoutParams3);
            }
        });
        this.editInvite.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (UILayoutRegistrationInvite.this.editInvite.getText().length() == 0) {
                    UILayoutRegistrationInvite.this.butEnter.setAlpha(0.5f);
                } else {
                    UILayoutRegistrationInvite.this.butEnter.setAlpha(1.0f);
                }
                if (i == 66) {
                    NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationInvite.this.mRoot.mActivity;
                    NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationInvite.this.mRoot.mActivity;
                    ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationInvite.this.mViewRoot.getWindowToken(), 0);
                    view.setFocusable(false);
                    view.setFocusableInTouchMode(true);
                    return true;
                }
                return false;
            }
        });
        this.editInvite.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() {
            @Override
            public void callback() {
                NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationInvite.this.mRoot.mActivity;
                NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationInvite.this.mRoot.mActivity;
                ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationInvite.this.mViewRoot.getWindowToken(), 0);
                UILayoutRegistrationInvite.this.editInvite.setFocusable(false);
                UILayoutRegistrationInvite.this.editInvite.setFocusableInTouchMode(true);
            }
        });
        this.butEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getAlpha() < 1.0f) {
                    return;
                }
                view.startAnimation(UILayoutRegistrationInvite.this.mRoot.mAnim);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 4);
                    jSONObject.put("s", UILayoutRegistrationInvite.this.editInvite.getText().toString());
                    UILayoutRegistrationInvite.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.butSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(UILayoutRegistrationInvite.this.mRoot.mAnim);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 4);
                    jSONObject.put("s", "");
                    UILayoutRegistrationInvite.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return this.mViewRoot;
    }

    @Override
    public void onLayoutShown() {
        this.mUIParent.textHint.setText(Html.fromHtml("Никнейм друга должен быть в формате: <b>Nick_Name</b>"));
        this.mUIParent.textHeader.setText("Тебя пригласил друг?");
    }
}
