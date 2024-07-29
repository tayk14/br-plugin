package com.rockstargames.gtacr.gui.registration;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import blackrussia.online.App;
import blackrussia.online.R;
import com.appsflyer.AppsFlyerLib;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.inventory.Constants;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.util.HashMap;
import org.json.JSONObject;

public class UILayoutRegistrationPerson extends UILayout {
    ImageView butLeft;
    Button butPlay;
    ImageView butRight;
    ImageView imgClose;
    ImageView imgPerson;
    int[] mIds;
    private GUIRegistration mRoot;
    TextView textHint;
    private View mViewRoot = null;
    int[] mMaleIds = {78, 79, Constants.ID_SKIN, 136, 230, 158, 159, 71, 161};
    int[] mFemaleIds = {77, 135, 137, 212, 239, 218};
    int mCurrId = 0;

    @Override
    public void onLayoutClose() {
    }

    public UILayoutRegistrationPerson(GUIRegistration root) {
        this.mRoot = root;
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.reg_person, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        this.butLeft = (ImageView) inflate.findViewById(R.id.arrow_left);
        this.butRight = (ImageView) this.mViewRoot.findViewById(R.id.arrow_right);
        this.butPlay = (Button) this.mViewRoot.findViewById(R.id.play_butt);
        this.imgClose = (ImageView) this.mViewRoot.findViewById(R.id.person_close_h);
        this.imgPerson = (ImageView) this.mViewRoot.findViewById(R.id.perosn_img);
        this.textHint = (TextView) this.mViewRoot.findViewById(R.id.hint_person);
        this.butLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UILayoutRegistrationPerson uILayoutRegistrationPerson = null;
                view.startAnimation(UILayoutRegistrationPerson.this.mRoot.mAnim);
                UILayoutRegistrationPerson uILayoutRegistrationPerson2 = UILayoutRegistrationPerson.this;
                int i = uILayoutRegistrationPerson2.mCurrId - 1;
                uILayoutRegistrationPerson2.mCurrId = i;
                if (i < 0) {
                    UILayoutRegistrationPerson.this.mCurrId = uILayoutRegistrationPerson.mIds.length - 1;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", -1);
                    jSONObject.put("i", UILayoutRegistrationPerson.this.mIds[UILayoutRegistrationPerson.this.mCurrId]);
                    UILayoutRegistrationPerson.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.butRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(UILayoutRegistrationPerson.this.mRoot.mAnim);
                UILayoutRegistrationPerson uILayoutRegistrationPerson = UILayoutRegistrationPerson.this;
                int i = uILayoutRegistrationPerson.mCurrId + 1;
                uILayoutRegistrationPerson.mCurrId = i;
                if (i >= UILayoutRegistrationPerson.this.mIds.length) {
                    UILayoutRegistrationPerson.this.mCurrId = 0;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", -1);
                    jSONObject.put("i", UILayoutRegistrationPerson.this.mIds[UILayoutRegistrationPerson.this.mCurrId]);
                    UILayoutRegistrationPerson.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.butPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(UILayoutRegistrationPerson.this.mRoot.mAnim);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 5);
                    jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, UILayoutRegistrationPerson.this.mIds[UILayoutRegistrationPerson.this.mCurrId]);
                    UILayoutRegistrationPerson.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                    String firstName = (UILayoutRegistrationPerson.this.mRoot.mActivity.getCurrServer() >= App.getInstance().getServerList().size() || App.getInstance().getServerList().get(UILayoutRegistrationPerson.this.mRoot.mActivity.getCurrServer()).getFirstName().contains("test")) ? "TEST SERVER" : App.getInstance().getServerList().get(UILayoutRegistrationPerson.this.mRoot.mActivity.getCurrServer()).getFirstName();
                    HashMap hashMap = new HashMap();
                    hashMap.put("user_nickname", UILayoutRegistrationPerson.this.mRoot.mActivity.getNick());
                    hashMap.put("server", firstName);
                    AppsFlyerLib.getInstance().logEvent(UILayoutRegistrationPerson.this.mRoot.mActivity, "Register", hashMap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                UILayoutRegistrationPerson.this.mRoot.close(jSONObject);
            }
        });
        this.textHint.setText(Html.fromHtml("Теперь тебе предстоит выбрать персонажа. Нажимай <font color=#FFC634>«Влево»</font> и <font color=#FFC634>«Вправо»</font>, чтобы найти свой стиль."));
        this.textHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(8);
                UILayoutRegistrationPerson.this.imgPerson.setVisibility(8);
                UILayoutRegistrationPerson.this.imgClose.setVisibility(8);
            }
        });
        this.imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(8);
                UILayoutRegistrationPerson.this.imgPerson.setVisibility(8);
                UILayoutRegistrationPerson.this.textHint.setVisibility(8);
            }
        });
        return this.mViewRoot;
    }

    @Override
    public void onLayoutShown() {
        if (this.mRoot.isMale) {
            this.mIds = this.mMaleIds;
        } else {
            this.mIds = this.mFemaleIds;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", -1);
            jSONObject.put("i", this.mIds[0]);
            this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mViewRoot.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                UILayoutRegistrationPerson.this.mViewRoot.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) UILayoutRegistrationPerson.this.imgPerson.getLayoutParams();
                layoutParams.height = (int) (UILayoutRegistrationPerson.this.mViewRoot.getHeight() * 0.5f);
                layoutParams.width = layoutParams.height;
                UILayoutRegistrationPerson.this.imgPerson.setLayoutParams(layoutParams);
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) UILayoutRegistrationPerson.this.textHint.getLayoutParams();
                layoutParams2.leftMargin = (int) (UILayoutRegistrationPerson.this.imgPerson.getWidth() * (-0.3f));
                UILayoutRegistrationPerson.this.textHint.setLayoutParams(layoutParams2);
            }
        });
    }
}
