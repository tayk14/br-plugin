package com.rockstargames.gtacr.gui.registration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

public class UILayoutRegistrationSex extends UILayout {
    ImageView butFemale;
    ImageView butMale;
    Button butPlay;
    ImageView imgLogo;
    private GUIRegistration mRoot;
    private View mViewRoot = null;
    boolean isMaleActive = true;

    @Override
    public void onLayoutShown() {
    }

    public UILayoutRegistrationSex(GUIRegistration root) {
        this.mRoot = root;
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.registration_sex, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        this.butMale = (ImageView) inflate.findViewById(R.id.male_butt);
        this.butFemale = (ImageView) this.mViewRoot.findViewById(R.id.female_butt);
        this.butPlay = (Button) this.mViewRoot.findViewById(R.id.butt);
        this.imgLogo = (ImageView) this.mViewRoot.findViewById(R.id.logo);
        if (this.mRoot.mLogoBitmap != null) {
            this.imgLogo.setImageBitmap(this.mRoot.mLogoBitmap);
        }
        this.imgLogo.setVisibility(8);
        this.butMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(UILayoutRegistrationSex.this.mRoot.mAnim);
                if (UILayoutRegistrationSex.this.isMaleActive) {
                    return;
                }
                UILayoutRegistrationSex.this.butMale.setImageResource(R.drawable.reg_male_active);
                UILayoutRegistrationSex.this.butFemale.setImageResource(R.drawable.reg_female);
                UILayoutRegistrationSex.this.isMaleActive = true;
            }
        });
        this.butFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(UILayoutRegistrationSex.this.mRoot.mAnim);
                if (UILayoutRegistrationSex.this.isMaleActive) {
                    UILayoutRegistrationSex.this.butMale.setImageResource(R.drawable.reg_male);
                    UILayoutRegistrationSex.this.butFemale.setImageResource(R.drawable.reg_female_active);
                    UILayoutRegistrationSex.this.isMaleActive = false;
                }
            }
        });
        this.butPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(UILayoutRegistrationSex.this.mRoot.mAnim);
                UILayoutRegistrationSex.this.mRoot.isMale = UILayoutRegistrationSex.this.isMaleActive;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 3);
                    jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, UILayoutRegistrationSex.this.isMaleActive ? 0 : 1);
                    UILayoutRegistrationSex.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return this.mViewRoot;
    }

    @Override
    public void onLayoutClose() {
        this.mViewRoot.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                UILayoutRegistrationSex.this.mViewRoot.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) UILayoutRegistrationSex.this.imgLogo.getLayoutParams();
                layoutParams.height = (int) (UILayoutRegistrationSex.this.mViewRoot.getHeight() * 0.15f);
                layoutParams.width = layoutParams.height * 2;
                UILayoutRegistrationSex.this.imgLogo.setLayoutParams(layoutParams);
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) UILayoutRegistrationSex.this.butMale.getLayoutParams();
                layoutParams2.height = (int) (UILayoutRegistrationSex.this.mViewRoot.getHeight() * 0.6f);
                layoutParams2.width = layoutParams2.height;
                UILayoutRegistrationSex.this.butMale.setLayoutParams(layoutParams2);
            }
        });
    }
}
