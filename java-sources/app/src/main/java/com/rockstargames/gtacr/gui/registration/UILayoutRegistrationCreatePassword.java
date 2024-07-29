package com.rockstargames.gtacr.gui.registration;

import android.text.Html;
import android.text.InputFilter;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.rockstargames.gtacr.common.UIContainer;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

public class UILayoutRegistrationCreatePassword extends UILayout {
    LinearLayout butBack;
    Button butt;
    CustomEditTextWithBackPressEvent edit1;
    CustomEditTextWithBackPressEvent edit2;
    CustomEditTextWithBackPressEvent edit3;
    private GUIRegistration mRoot;
    private UILayoutRegistrationGeneral mUIParent;
    private View mViewRoot = null;
    TextView textHeader;
    TextView textRestore;

    @Override
    public void onLayoutClose() {
    }

    public UILayoutRegistrationCreatePassword(GUIRegistration root) {
        this.mRoot = root;
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        this.mViewRoot = inflater.inflate(R.layout.registration_create_password, (ViewGroup) null, false);
        this.mUIParent = (UILayoutRegistrationGeneral) this.mRoot.mContainer.getLayout(0);
        this.butBack = (LinearLayout) this.mViewRoot.findViewById(R.id.back_butt);
        this.textHeader = (TextView) this.mViewRoot.findViewById(R.id.header_text);
        this.textRestore = (TextView) this.mViewRoot.findViewById(R.id.restore_text);
        this.butt = (Button) this.mViewRoot.findViewById(R.id.reg_butt);
        this.edit1 = (CustomEditTextWithBackPressEvent) this.mViewRoot.findViewById(R.id.edit1);
        this.edit2 = (CustomEditTextWithBackPressEvent) this.mViewRoot.findViewById(R.id.edit2);
        this.edit3 = (CustomEditTextWithBackPressEvent) this.mViewRoot.findViewById(R.id.edit3);
        return this.mViewRoot;
    }

    @Override
    public void onLayoutShown() {
        this.butt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                UILayoutRegistrationCreatePassword.this.butt.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) UILayoutRegistrationCreatePassword.this.butt.getLayoutParams();
                int width = (int) (UILayoutRegistrationCreatePassword.this.butt.getWidth() * 0.16f);
                layoutParams.height = width;
                UILayoutRegistrationCreatePassword.this.butt.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) UILayoutRegistrationCreatePassword.this.edit1.getLayoutParams();
                layoutParams2.height = width;
                UILayoutRegistrationCreatePassword.this.edit1.setLayoutParams(layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) UILayoutRegistrationCreatePassword.this.edit2.getLayoutParams();
                layoutParams3.height = width;
                UILayoutRegistrationCreatePassword.this.edit2.setLayoutParams(layoutParams3);
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) UILayoutRegistrationCreatePassword.this.edit3.getLayoutParams();
                layoutParams4.height = width;
                UILayoutRegistrationCreatePassword.this.edit3.setLayoutParams(layoutParams4);
            }
        });
        if (this.mRoot.mIsRegistration) {
            RegistrationSet();
            return;
        }
        int i = this.mRoot.mRestoreSet;
        if (i == 0) {
            RestoreSet();
        } else if (i == 1) {
            RestoreNewSet();
        } else if (i == 2) {
            PinSet();
        } else if (i != 3) {
        } else {
            PinRestoreSet();
        }
    }

    private void RegistrationSet() {
        this.butt.setText("Зарегистрироваться");
        this.edit1.setVisibility(0);
        this.edit1.setHint("Электронная почта (необязательно)");
        this.edit2.setVisibility(0);
        this.edit2.setHint("Пароль");
        this.edit3.setVisibility(0);
        this.edit3.setHint("Повторите пароль");
        this.textHeader.setVisibility(8);
        this.textRestore.setVisibility(8);
        this.edit1.setInputType(1);
        this.edit2.setInputType(128);
        this.edit2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.edit2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
        this.edit3.setInputType(128);
        this.edit3.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.edit3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
        this.butt.setAlpha(0.5f);
        this.edit1.setText("");
        this.edit2.setText("");
        this.edit3.setText("");
        this.edit1.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() {
            @Override
            public void callback() {
                NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusable(false);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusableInTouchMode(true);
            }
        });
        this.edit2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (UILayoutRegistrationCreatePassword.this.edit2.getText().length() >= 6 && UILayoutRegistrationCreatePassword.this.edit2.getText().toString().equals(UILayoutRegistrationCreatePassword.this.edit3.getText().toString())) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                    return false;
                }
                UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                return false;
            }
        });
        this.edit2.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() {
            @Override
            public void callback() {
                NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                UILayoutRegistrationCreatePassword.this.edit2.setFocusable(false);
                UILayoutRegistrationCreatePassword.this.edit2.setFocusableInTouchMode(true);
            }
        });
        this.edit3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (UILayoutRegistrationCreatePassword.this.edit3.getText().length() >= 6 && UILayoutRegistrationCreatePassword.this.edit2.getText().toString().equals(UILayoutRegistrationCreatePassword.this.edit3.getText().toString())) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                } else {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                }
                if (i == 66) {
                    NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                    NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                    ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                    view.setFocusable(false);
                    view.setFocusableInTouchMode(true);
                    return true;
                }
                return false;
            }
        });
        this.edit3.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() {
            @Override
            public void callback() {
                NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                UILayoutRegistrationCreatePassword.this.edit3.setFocusable(false);
                UILayoutRegistrationCreatePassword.this.edit3.setFocusableInTouchMode(true);
            }
        });
        this.butBack.setVisibility(4);
        this.butBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.startAnimation(UILayoutRegistrationCreatePassword.this.mRoot.mAnim);
                boolean z = UILayoutRegistrationCreatePassword.this.mRoot.mIsRegistration;
                NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusable(false);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusableInTouchMode(true);
                UILayoutRegistrationCreatePassword.this.edit2.setFocusable(false);
                UILayoutRegistrationCreatePassword.this.edit2.setFocusableInTouchMode(true);
                UILayoutRegistrationCreatePassword.this.edit3.setFocusable(false);
                UILayoutRegistrationCreatePassword.this.edit3.setFocusableInTouchMode(true);
                return false;
            }
        });
        this.butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UILayoutRegistrationCreatePassword.this.edit3.getText().length() >= 6 && UILayoutRegistrationCreatePassword.this.edit2.getText().toString().equals(UILayoutRegistrationCreatePassword.this.edit3.getText().toString())) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                } else {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                }
                if (view.getAlpha() >= 1.0f) {
                    view.startAnimation(UILayoutRegistrationCreatePassword.this.mRoot.mAnim);
                    if (UILayoutRegistrationCreatePassword.this.mRoot.mIsRegistration) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("t", 1);
                            jSONObject.put("s", UILayoutRegistrationCreatePassword.this.edit1.getText().toString());
                            jSONObject.put(TuningConstants.KEY_GET_ID_DETAIL, UILayoutRegistrationCreatePassword.this.edit2.getText().toString());
                            UILayoutRegistrationCreatePassword.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("d", 3);
                    jSONObject2.put("t", 2);
                    jSONObject2.put("s", -1);
                    if (!UILayoutRegistrationCreatePassword.this.edit2.getText().toString().equals(UILayoutRegistrationCreatePassword.this.edit3.getText().toString())) {
                        jSONObject2.put("i", "Пароли не совпадают");
                    } else if (UILayoutRegistrationCreatePassword.this.edit2.getText().length() == 0) {
                        jSONObject2.put("i", "Придумайте пароль");
                    } else {
                        jSONObject2.put("i", "Пароль слишком короткий");
                    }
                    UILayoutRegistrationCreatePassword.this.mRoot.mGUIManager.showGUI(13, jSONObject2);
                } catch (Exception unused2) {
                }
            }
        });
        this.mUIParent.textHint.setText(Html.fromHtml("<b>Для начала игры, заполни все поля</b>\n<ul><li>Пароль должен состоять от 6 до 16 символов</li><li>Пароль чувствителен к регистру</li></ul>"));
    }

    private void RestoreSet() {
        this.textHeader.setVisibility(0);
        this.textHeader.setText("Код восстановления:");
        this.butt.setText("Подтвердить");
        this.edit1.setVisibility(0);
        this.edit1.setHint("Введите код");
        this.edit2.setVisibility(8);
        this.edit3.setVisibility(8);
        this.textRestore.setVisibility(8);
        this.edit1.setInputType(128);
        this.edit1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        this.edit1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});
        this.edit1.setText("");
        this.edit2.setText("");
        this.butt.setAlpha(0.5f);
        this.edit1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (UILayoutRegistrationCreatePassword.this.edit1.getText().length() > 0) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                } else {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                }
                if (i == 66) {
                    NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                    NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                    ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                    view.setFocusable(false);
                    view.setFocusableInTouchMode(true);
                    return true;
                }
                return false;
            }
        });
        this.edit1.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() {
            @Override
            public void callback() {
                NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusable(false);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusableInTouchMode(true);
            }
        });
        this.butBack.setVisibility(0);
        this.butBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.startAnimation(UILayoutRegistrationCreatePassword.this.mRoot.mAnim);
                UIContainer uIContainer = UILayoutRegistrationCreatePassword.this.mUIParent.mContainer;
                UILayoutRegistrationGeneral unused = UILayoutRegistrationCreatePassword.this.mUIParent;
                uIContainer.setCurrentLayout(4);
                return false;
            }
        });
        this.butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UILayoutRegistrationCreatePassword.this.edit1.getText().length() > 0) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                } else {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                }
                if (view.getAlpha() < 1.0f) {
                    return;
                }
                view.startAnimation(UILayoutRegistrationCreatePassword.this.mRoot.mAnim);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 8);
                    jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, UILayoutRegistrationCreatePassword.this.edit1.getText().toString());
                    jSONObject.put("tt", 0);
                    UILayoutRegistrationCreatePassword.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                } catch (Exception unused) {
                }
            }
        });
        int i = this.mRoot.mRestoreMethod;
        String str = i != 1 ? i != 2 ? "на ваш e-mail" : "вам в VK" : "вам в Telegram";
        TextView textView = this.mUIParent.textHint;
        textView.setText(Html.fromHtml("Забыли свой пароль? Мы выслали код восстановления" + str + ". Проверьте указанное место и введите код в поле справа."));
    }

    private void RestoreNewSet() {
        this.textHeader.setVisibility(8);
        this.butt.setText("Подтвердить");
        this.edit1.setVisibility(0);
        this.edit1.setHint("Новый пароль");
        this.edit2.setVisibility(0);
        this.edit2.setHint("Повторите новый пароль");
        this.edit3.setVisibility(8);
        this.textRestore.setVisibility(8);
        this.edit1.setInputType(128);
        this.edit1.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.edit1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
        this.edit2.setInputType(128);
        this.edit2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.edit2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
        this.edit1.setText("");
        this.edit2.setText("");
        this.butt.setAlpha(0.5f);
        this.edit1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (UILayoutRegistrationCreatePassword.this.edit1.getText().length() >= 6 && UILayoutRegistrationCreatePassword.this.edit1.getText().toString().equals(UILayoutRegistrationCreatePassword.this.edit2.getText().toString())) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                    return false;
                }
                UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                return false;
            }
        });
        this.edit1.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() {
            @Override
            public void callback() {
                NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusable(false);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusableInTouchMode(true);
            }
        });
        this.edit2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (UILayoutRegistrationCreatePassword.this.edit2.getText().length() >= 6 && UILayoutRegistrationCreatePassword.this.edit2.getText().toString().equals(UILayoutRegistrationCreatePassword.this.edit1.getText().toString())) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                } else {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                }
                if (i == 66) {
                    NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                    NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                    ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                    view.setFocusable(false);
                    view.setFocusableInTouchMode(true);
                    return true;
                }
                return false;
            }
        });
        this.edit2.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() {
            @Override
            public void callback() {
                NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                UILayoutRegistrationCreatePassword.this.edit2.setFocusable(false);
                UILayoutRegistrationCreatePassword.this.edit2.setFocusableInTouchMode(true);
            }
        });
        this.butBack.setVisibility(0);
        this.butBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.startAnimation(UILayoutRegistrationCreatePassword.this.mRoot.mAnim);
                UIContainer uIContainer = UILayoutRegistrationCreatePassword.this.mUIParent.mContainer;
                UILayoutRegistrationGeneral unused = UILayoutRegistrationCreatePassword.this.mUIParent;
                uIContainer.setCurrentLayout(4);
                return false;
            }
        });
        this.butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UILayoutRegistrationCreatePassword.this.edit2.getText().length() >= 6 && UILayoutRegistrationCreatePassword.this.edit2.getText().toString().equals(UILayoutRegistrationCreatePassword.this.edit1.getText().toString())) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                } else {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                }
                if (view.getAlpha() >= 1.0f) {
                    view.startAnimation(UILayoutRegistrationCreatePassword.this.mRoot.mAnim);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("t", 8);
                        jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, UILayoutRegistrationCreatePassword.this.edit1.getText().toString());
                        jSONObject.put("tt", 4);
                        UILayoutRegistrationCreatePassword.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("d", 3);
                    jSONObject2.put("t", 2);
                    jSONObject2.put("s", -1);
                    if (!UILayoutRegistrationCreatePassword.this.edit2.getText().toString().equals(UILayoutRegistrationCreatePassword.this.edit1.getText().toString())) {
                        jSONObject2.put("i", "Пароли не совпадают");
                    } else if (UILayoutRegistrationCreatePassword.this.edit2.getText().length() == 0) {
                        jSONObject2.put("i", "Придумайте пароль");
                    } else {
                        jSONObject2.put("i", "Пароль слишком короткий");
                    }
                    UILayoutRegistrationCreatePassword.this.mRoot.mGUIManager.showGUI(13, jSONObject2);
                } catch (Exception unused2) {
                }
            }
        });
        this.mUIParent.textHint.setText(Html.fromHtml("Отлично! Код подошел. Теперь придумайте новый пароль, а затем повторите его."));
    }

    public void PinSet() {
        this.textHeader.setVisibility(0);
        this.textHeader.setText("Введите пин-код:");
        this.butt.setText("Подтвердить");
        this.edit1.setVisibility(0);
        this.edit1.setHint("Введите пин-код");
        this.edit2.setVisibility(8);
        this.edit3.setVisibility(8);
        this.textRestore.setVisibility(0);
        this.butBack.setVisibility(4);
        this.textRestore.setVisibility(0);
        this.textRestore.setText(Html.fromHtml("<u>Восстановить пин-код</u>"));
        this.edit1.setInputType(2);
        this.edit1.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.edit1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.edit1.setText("");
        this.edit2.setText("");
        this.butt.setAlpha(0.5f);
        this.edit1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (UILayoutRegistrationCreatePassword.this.edit1.getText().length() >= 4) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                } else {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                }
                if (i == 66) {
                    NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                    NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                    ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                    view.setFocusable(false);
                    view.setFocusableInTouchMode(true);
                    return true;
                }
                return false;
            }
        });
        this.edit1.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() {
            @Override
            public void callback() {
                NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusable(false);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusableInTouchMode(true);
            }
        });
        this.textRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(UILayoutRegistrationCreatePassword.this.mRoot.mAnim);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 7);
                    jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, 1);
                    UILayoutRegistrationCreatePassword.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                } catch (Exception unused) {
                }
            }
        });
        this.butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UILayoutRegistrationCreatePassword.this.edit1.getText().length() >= 4) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                } else {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                }
                if (view.getAlpha() < 1.0f) {
                    return;
                }
                view.startAnimation(UILayoutRegistrationCreatePassword.this.mRoot.mAnim);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 8);
                    jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, UILayoutRegistrationCreatePassword.this.edit1.getText().toString());
                    jSONObject.put("tt", 1);
                    UILayoutRegistrationCreatePassword.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                } catch (Exception unused) {
                }
            }
        });
        this.mUIParent.textHint.setText(Html.fromHtml("Если вы забыли свой пин-код вы можете восстановить его. Нажмите на «Восстановить пин-код» и мы отправим его на ваш e-mail.."));
    }

    public void PinRestoreSet() {
        this.textHeader.setVisibility(0);
        this.textHeader.setText("Введите код аутентификатора:");
        this.butt.setText("Подтвердить");
        this.edit1.setVisibility(0);
        this.edit1.setHint("Введите код");
        this.edit2.setVisibility(8);
        this.edit3.setVisibility(8);
        this.textRestore.setVisibility(0);
        this.edit1.setInputType(128);
        this.edit1.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.edit1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});
        if (this.mRoot.mT != 2) {
            this.butBack.setVisibility(0);
        } else {
            this.butBack.setVisibility(4);
        }
        this.textRestore.setVisibility(0);
        this.textRestore.setText(Html.fromHtml("<u>Восстановить код</u>"));
        this.edit1.setText("");
        this.edit2.setText("");
        this.butt.setAlpha(0.5f);
        this.edit1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (UILayoutRegistrationCreatePassword.this.edit1.getText().length() > 0) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                } else {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                }
                if (i == 66) {
                    NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                    NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                    ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                    view.setFocusable(false);
                    view.setFocusableInTouchMode(true);
                    return true;
                }
                return false;
            }
        });
        this.edit1.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() {
            @Override
            public void callback() {
                NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusable(false);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusableInTouchMode(true);
            }
        });
        this.butBack.setVisibility(0);
        this.butBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                UILayoutRegistrationCreatePassword.this.mRoot.mRestoreSet = 2;
                UILayoutRegistrationCreatePassword.this.PinSet();
                return false;
            }
        });
        this.textRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UILayoutRegistrationCreatePassword.this.mRoot.mT != 2) {
                    view.startAnimation(UILayoutRegistrationCreatePassword.this.mRoot.mAnim);
                }
                UILayoutRegistrationCreatePassword.this.mRoot.mRestoreSet = 4;
                UILayoutRegistrationCreatePassword.this.PinAuthSet();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 7);
                    jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, 2);
                    UILayoutRegistrationCreatePassword.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                } catch (Exception unused) {
                }
            }
        });
        this.butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UILayoutRegistrationCreatePassword.this.edit1.getText().length() > 0) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                } else {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                }
                if (view.getAlpha() < 1.0f) {
                    return;
                }
                view.startAnimation(UILayoutRegistrationCreatePassword.this.mRoot.mAnim);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 8);
                    jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, UILayoutRegistrationCreatePassword.this.edit1.getText().toString());
                    jSONObject.put("tt", 2);
                    UILayoutRegistrationCreatePassword.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                } catch (Exception unused) {
                }
            }
        });
        this.mUIParent.textHint.setText(Html.fromHtml("Введите код Google Authenticator в поле справа."));
    }

    public void PinAuthSet() {
        this.textHeader.setVisibility(0);
        this.textHeader.setText("Введите код отключения:");
        this.butt.setText("Подтвердить");
        this.edit1.setVisibility(0);
        this.edit1.setHint("Введите код");
        this.edit2.setVisibility(8);
        this.edit3.setVisibility(8);
        this.textRestore.setVisibility(0);
        this.butBack.setVisibility(0);
        this.textRestore.setVisibility(8);
        this.edit1.setInputType(128);
        this.edit1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        this.edit1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});
        this.edit1.setText("");
        this.edit2.setText("");
        this.butt.setAlpha(0.5f);
        this.edit1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (UILayoutRegistrationCreatePassword.this.edit1.getText().length() > 0) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                } else {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                }
                if (i == 66) {
                    NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                    NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                    ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                    view.setFocusable(false);
                    view.setFocusableInTouchMode(true);
                    return true;
                }
                return false;
            }
        });
        this.edit1.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() {
            @Override
            public void callback() {
                NvEventQueueActivity nvEventQueueActivity = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                NvEventQueueActivity nvEventQueueActivity2 = UILayoutRegistrationCreatePassword.this.mRoot.mActivity;
                ((InputMethodManager) nvEventQueueActivity.getSystemService("input_method")).hideSoftInputFromWindow(UILayoutRegistrationCreatePassword.this.mViewRoot.getWindowToken(), 0);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusable(false);
                UILayoutRegistrationCreatePassword.this.edit1.setFocusableInTouchMode(true);
            }
        });
        this.butBack.setVisibility(0);
        this.butBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UILayoutRegistrationCreatePassword.this.mRoot.mT != 2) {
                    view.startAnimation(UILayoutRegistrationCreatePassword.this.mRoot.mAnim);
                }
                UILayoutRegistrationCreatePassword.this.mRoot.mRestoreSet = 3;
                UILayoutRegistrationCreatePassword.this.PinRestoreSet();
                return false;
            }
        });
        this.butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UILayoutRegistrationCreatePassword.this.edit1.getText().length() > 0) {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(1.0f);
                } else {
                    UILayoutRegistrationCreatePassword.this.butt.setAlpha(0.5f);
                }
                if (view.getAlpha() < 1.0f) {
                    return;
                }
                view.startAnimation(UILayoutRegistrationCreatePassword.this.mRoot.mAnim);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("t", 8);
                    jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, UILayoutRegistrationCreatePassword.this.edit1.getText().toString());
                    jSONObject.put("tt", 3);
                    UILayoutRegistrationCreatePassword.this.mRoot.mGUIManager.sendJsonData(38, jSONObject);
                } catch (Exception unused) {
                }
            }
        });
        this.mUIParent.textHint.setText(Html.fromHtml("На вашу почту был отправлен код отключения Google Authenticator. Введите его в поле справа."));
    }
}
