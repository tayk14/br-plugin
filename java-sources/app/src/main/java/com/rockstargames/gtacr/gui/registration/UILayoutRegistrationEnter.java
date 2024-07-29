package com.rockstargames.gtacr.gui.registration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.UIContainer;
import com.rockstargames.gtacr.common.UILayout;

public class UILayoutRegistrationEnter extends UILayout {
    Button butEnter;
    Button butGoogleEnter;
    Button butVkEnter;
    private GUIRegistration mRoot;
    private UILayoutRegistrationGeneral mUIParent;
    private View mViewRoot = null;
    TextView textHeader;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutRegistrationEnter(GUIRegistration root) {
        this.mRoot = root;
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.registration_enter, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        this.textHeader = (TextView) inflate.findViewById(R.id.text_header);
        this.butEnter = (Button) this.mViewRoot.findViewById(R.id.enter);
        this.butVkEnter = (Button) this.mViewRoot.findViewById(R.id.vk_enter);
        this.butGoogleEnter = (Button) this.mViewRoot.findViewById(R.id.google_enter);
        this.mUIParent = (UILayoutRegistrationGeneral) this.mRoot.mContainer.getLayout(0);
        this.mViewRoot.findViewById(R.id.reg_ll).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                UILayoutRegistrationEnter.this.mViewRoot.findViewById(R.id.reg_ll).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) UILayoutRegistrationEnter.this.butEnter.getLayoutParams();
                layoutParams.height = (int) (UILayoutRegistrationEnter.this.butEnter.getWidth() * 0.16f);
                UILayoutRegistrationEnter.this.butEnter.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) UILayoutRegistrationEnter.this.butVkEnter.getLayoutParams();
                layoutParams2.height = (int) (UILayoutRegistrationEnter.this.butVkEnter.getWidth() * 0.16f);
                UILayoutRegistrationEnter.this.butVkEnter.setLayoutParams(layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) UILayoutRegistrationEnter.this.butGoogleEnter.getLayoutParams();
                layoutParams3.height = (int) (UILayoutRegistrationEnter.this.butGoogleEnter.getWidth() * 0.16f);
                UILayoutRegistrationEnter.this.butGoogleEnter.setLayoutParams(layoutParams3);
                UILayoutRegistrationEnter.this.mUIParent.mHeightField = layoutParams3.height;
                LinearLayout linearLayout = (LinearLayout) UILayoutRegistrationEnter.this.mViewRoot.findViewById(R.id.reg_ll);
                linearLayout.setPadding(linearLayout.getPaddingLeft(), UILayoutRegistrationEnter.this.mViewRoot.getHeight() / 5, linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
            }
        });
        if (this.mRoot.mIsRegistration) {
            this.textHeader.setText("Выберите способ регистрации:");
            this.butEnter.setBackgroundResource(R.drawable.reg_but2);
            this.butVkEnter.setBackgroundResource(R.drawable.reg_but_vk2);
            this.butGoogleEnter.setBackgroundResource(R.drawable.reg_but_google2);
        } else {
            this.textHeader.setText("Выберите способ авторизации:");
            this.butEnter.setBackgroundResource(R.drawable.reg_but);
            this.butVkEnter.setBackgroundResource(R.drawable.reg_but_vk);
            this.butGoogleEnter.setBackgroundResource(R.drawable.reg_but_google);
        }
        this.butEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(UILayoutRegistrationEnter.this.mRoot.mAnim);
                if (UILayoutRegistrationEnter.this.mRoot.mIsRegistration) {
                    UIContainer uIContainer = UILayoutRegistrationEnter.this.mUIParent.mContainer;
                    UILayoutRegistrationGeneral unused = UILayoutRegistrationEnter.this.mUIParent;
                    uIContainer.setCurrentLayout(1);
                    return;
                }
                UIContainer uIContainer2 = UILayoutRegistrationEnter.this.mUIParent.mContainer;
                UILayoutRegistrationGeneral unused2 = UILayoutRegistrationEnter.this.mUIParent;
                uIContainer2.setCurrentLayout(4);
            }
        });
        return this.mViewRoot;
    }
}
