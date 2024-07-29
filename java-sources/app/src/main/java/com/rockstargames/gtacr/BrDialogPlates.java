package com.rockstargames.gtacr;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogPlates extends DialogFragment implements ISAMPGUI {
    private Button[] mButtonsCountry;
    private AppCompatEditText[] mEditTexts;
    private AppCompatEditText mEtRegKz;
    private AppCompatEditText mEtRegRu;
    private LinearLayout[] mLayoutList;
    private NvEventQueueActivity mContext = null;
    private LinearLayout mLayoutMain1 = null;
    private LinearLayout mLayoutMain2 = null;
    private TextView mPlatesFormat = null;
    private TextView mPlatesAllowed = null;
    private TextView mPlatesPrice = null;
    private TextView mPlatesRefreshText = null;
    private TextView mPlatesHint = null;
    private Button mButtonRefresh = null;
    private int mChosenCountry = -1;
    private int mType = -1;
    char[] mAllowedLower = {'a', 'b', 'c', 'e', 'h', 'k', 'm', 'o', 'p', 't', 'x', 'y', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] mAllowedHighUa = {'A', 'B', 'C', 'E', 'H', 'K', 'M', 'O', 'P', 'T', 'X', 'Y', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' '};
    char[] mAllowedHighBy = {'A', 'B', 'C', 'E', 'H', 'K', 'M', 'O', 'P', 'T', 'X', 'Y', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '-'};
    char[] mAllowedReg = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private GUIManager mGUIManager = null;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 1;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogPlates();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mChosenCountry = -1;
        setStyle(0, R.style.CustomDialog);
    }

    public void setPrices(int pricePlate, int priceRefresh) {
        this.mPlatesPrice.setText("Стоимость номерных знаков....................................................................... " + pricePlate + "₽");
        this.mPlatesRefreshText.setText("Стоимость изменения номерных знаков............................................ " + priceRefresh + "₽");
    }

    public void setHint(String str) {
        this.mPlatesHint.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetButtonsCountry(int ignore) {
        if (this.mChosenCountry == -1) {
            this.mLayoutMain2.setVisibility(8);
            this.mLayoutMain1.setVisibility(0);
        }
        if (ignore != 0) {
            this.mButtonsCountry[0].setBackground(ContextCompat.getDrawable(getContext(), R.drawable.br_lbutton_up_unselected));
        }
        if (ignore != 1) {
            this.mButtonsCountry[1].setBackground(ContextCompat.getDrawable(getContext(), R.drawable.br_rbutton_up_unselected));
        }
        if (ignore != 2) {
            this.mButtonsCountry[2].setBackground(ContextCompat.getDrawable(getContext(), R.drawable.br_lbutton_down_unselected));
        }
        if (ignore != 3) {
            this.mButtonsCountry[3].setBackground(ContextCompat.getDrawable(getContext(), R.drawable.br_rbutton_down_unselected));
        }
    }

    public void sendChangedPlate() {
        int i = this.mChosenCountry;
        if (i == -1) {
            return;
        }
        String obj = this.mEditTexts[i].getText().toString();
        String obj2 = this.mChosenCountry == 0 ? this.mEtRegRu.getText().toString() : "tt";
        if (this.mChosenCountry == 3) {
            obj2 = this.mEtRegKz.getText().toString();
        }
        onPlateChangedText(this.mChosenCountry, obj, obj2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mChosenCountry = -1;
        View inflate = inflater.inflate(R.layout.br_platebuy, (ViewGroup) null, false);
        this.mContext = (NvEventQueueActivity) getContext();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setDimAmount(0.0f);
        getDialog().getWindow().setLayout(-1, -1);
        this.mButtonsCountry = new Button[4];
        LinearLayout[] linearLayoutArr = new LinearLayout[4];
        this.mLayoutList = linearLayoutArr;
        this.mEditTexts = new AppCompatEditText[4];
        linearLayoutArr[0] = (LinearLayout) inflate.findViewById(R.id.ru_layout);
        this.mLayoutList[1] = (LinearLayout) inflate.findViewById(R.id.ua_layout);
        this.mLayoutList[2] = (LinearLayout) inflate.findViewById(R.id.by_layout);
        this.mLayoutList[3] = (LinearLayout) inflate.findViewById(R.id.kz_layout);
        this.mEditTexts[0] = (AppCompatEditText) inflate.findViewById(R.id.br_plate_et_ru);
        this.mEditTexts[1] = (AppCompatEditText) inflate.findViewById(R.id.br_plate_et_ua);
        this.mEditTexts[2] = (AppCompatEditText) inflate.findViewById(R.id.br_plate_et_by);
        this.mEditTexts[3] = (AppCompatEditText) inflate.findViewById(R.id.br_plate_et_kz);
        TextWatcher textWatcher = new TextWatcher() { // from class: com.rockstargames.gtacr.BrDialogPlates.1
            boolean _ignore = false;
            boolean resetChanges = false;
            String remembered = null;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (this._ignore) {
                    return;
                }
                this.remembered = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (this._ignore) {
                    return;
                }
                char[] cArr = BrDialogPlates.this.mAllowedLower;
                if (BrDialogPlates.this.mChosenCountry == 1) {
                    cArr = BrDialogPlates.this.mAllowedHighUa;
                }
                if (BrDialogPlates.this.mChosenCountry == 2) {
                    cArr = BrDialogPlates.this.mAllowedHighBy;
                }
                if (!BrDialogPlates.this.isNumberValid(charSequence.toString(), cArr)) {
                    this.resetChanges = true;
                } else {
                    this.resetChanges = false;
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (this._ignore) {
                    BrDialogPlates.this.sendChangedPlate();
                    return;
                }
                if (!this.resetChanges) {
                    if (BrDialogPlates.this.mChosenCountry == 0) {
                        BrDialogPlates.this.isRuNumber(editable.toString());
                    } else if (BrDialogPlates.this.mChosenCountry == 1) {
                        BrDialogPlates.this.isUANumber(editable.toString());
                    } else if (BrDialogPlates.this.mChosenCountry == 2) {
                        BrDialogPlates.this.isBYNumber(editable.toString());
                    } else if (BrDialogPlates.this.mChosenCountry == 3) {
                        BrDialogPlates.this.isKZNumber(editable.toString());
                    }
                } else {
                    this._ignore = true;
                    editable.clear();
                    editable.insert(0, this.remembered);
                    BrDialogPlates.this.setHint("Вы используете неккоректные символы");
                    this._ignore = false;
                }
                BrDialogPlates.this.sendChangedPlate();
            }
        };
        TextWatcher textWatcher2 = new TextWatcher() { // from class: com.rockstargames.gtacr.BrDialogPlates.2
            boolean _ignore = false;
            boolean resetChanges = false;
            String remembered = null;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (this._ignore) {
                    return;
                }
                this.remembered = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (this._ignore) {
                    return;
                }
                if (!BrDialogPlates.this.isRegCorrect(charSequence.toString())) {
                    this.resetChanges = true;
                } else {
                    this.resetChanges = false;
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (this._ignore) {
                    BrDialogPlates.this.sendChangedPlate();
                    return;
                }
                if (this.resetChanges) {
                    this._ignore = true;
                    editable.clear();
                    editable.insert(0, this.remembered);
                    BrDialogPlates.this.setHint("Используйте разрешённые символы");
                    this._ignore = false;
                }
                BrDialogPlates.this.sendChangedPlate();
            }
        };
        for (int i = 0; i < 4; i++) {
            this.mEditTexts[i].addTextChangedListener(textWatcher);
        }
        this.mEtRegRu = (AppCompatEditText) inflate.findViewById(R.id.br_plate_reg_ru_et);
        AppCompatEditText appCompatEditText = (AppCompatEditText) inflate.findViewById(R.id.br_plate_reg_kz_et);
        this.mEtRegKz = appCompatEditText;
        appCompatEditText.addTextChangedListener(textWatcher2);
        this.mEtRegRu.addTextChangedListener(textWatcher2);
        this.mPlatesHint = (TextView) inflate.findViewById(R.id.br_plates_hint);
        this.mButtonsCountry[0] = (Button) inflate.findViewById(R.id.br_plates_rus);
        this.mButtonsCountry[1] = (Button) inflate.findViewById(R.id.br_plates_ua);
        this.mButtonsCountry[2] = (Button) inflate.findViewById(R.id.br_plates_by);
        this.mButtonsCountry[3] = (Button) inflate.findViewById(R.id.br_plates_kz);
        this.mPlatesFormat = (TextView) inflate.findViewById(R.id.br_plates_format);
        this.mPlatesAllowed = (TextView) inflate.findViewById(R.id.br_plates_allowed);
        this.mLayoutMain1 = (LinearLayout) inflate.findViewById(R.id.br_plate_main_1);
        this.mLayoutMain2 = (LinearLayout) inflate.findViewById(R.id.br_plate_main_2);
        this.mLayoutMain1.setVisibility(8);
        this.mLayoutMain2.setVisibility(0);
        this.mPlatesPrice = (TextView) inflate.findViewById(R.id.br_plates_price);
        this.mPlatesRefreshText = (TextView) inflate.findViewById(R.id.br_plates_price_refresh);
        Button button = (Button) inflate.findViewById(R.id.br_plates_button_refresh);
        this.mButtonRefresh = button;
        if (this.mType == 1) {
            button.setVisibility(8);
            this.mPlatesRefreshText.setVisibility(8);
        }
        this.mButtonsCountry[0].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogPlates.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BrDialogPlates.this.resetButtonsCountry(0);
                if (BrDialogPlates.this.mChosenCountry == 0) {
                    return;
                }
                BrDialogPlates.this.mChosenCountry = 0;
                view.setBackground(ContextCompat.getDrawable(BrDialogPlates.this.getContext(), R.drawable.br_lbutton_up_selected));
                BrDialogPlates.this.onRusChosen();
            }
        });
        this.mButtonsCountry[1].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogPlates.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BrDialogPlates.this.resetButtonsCountry(1);
                if (BrDialogPlates.this.mChosenCountry == 1) {
                    return;
                }
                BrDialogPlates.this.mChosenCountry = 1;
                view.setBackground(ContextCompat.getDrawable(BrDialogPlates.this.getContext(), R.drawable.br_rbutton_up_selected));
                BrDialogPlates.this.onUaChosen();
            }
        });
        this.mButtonsCountry[2].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogPlates.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BrDialogPlates.this.resetButtonsCountry(2);
                if (BrDialogPlates.this.mChosenCountry == 2) {
                    return;
                }
                BrDialogPlates.this.mChosenCountry = 2;
                view.setBackground(ContextCompat.getDrawable(BrDialogPlates.this.getContext(), R.drawable.br_lbutton_down_selected));
                BrDialogPlates.this.onBuChosen();
            }
        });
        this.mButtonsCountry[3].setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogPlates.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BrDialogPlates.this.resetButtonsCountry(3);
                if (BrDialogPlates.this.mChosenCountry == 3) {
                    return;
                }
                BrDialogPlates.this.mChosenCountry = 3;
                view.setBackground(ContextCompat.getDrawable(BrDialogPlates.this.getContext(), R.drawable.br_rbutton_down_selected));
                BrDialogPlates.this.onKzChosen();
            }
        });
        ((Button) inflate.findViewById(R.id.br_plates_exit)).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogPlates.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BrDialogPlates.this.onPlateGuiClosed();
                BrDialogPlates.this.mGUIManager.closeGUI(null, 1);
            }
        });
        ((Button) inflate.findViewById(R.id.br_plates_button_refresh)).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogPlates.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BrDialogPlates.this.onPlateGuiRefreshButtonPressed();
            }
        });
        ((Button) inflate.findViewById(R.id.br_plates_button_buy)).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogPlates.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BrDialogPlates.this.mChosenCountry == -1) {
                    return;
                }
                String obj = BrDialogPlates.this.mEditTexts[BrDialogPlates.this.mChosenCountry].getText().toString();
                String obj2 = BrDialogPlates.this.mChosenCountry == 0 ? BrDialogPlates.this.mEtRegRu.getText().toString() : "tt";
                if (BrDialogPlates.this.mChosenCountry == 3) {
                    obj2 = BrDialogPlates.this.mEtRegKz.getText().toString();
                }
                BrDialogPlates.this.onBuyButtonPressed(obj, obj2);
            }
        });
        return inflate;
    }

    public void setPlateTexts(String plate, String reg) {
        int i = this.mChosenCountry;
        if (i == -1) {
            return;
        }
        this.mEditTexts[i].setText(plate);
        int i2 = this.mChosenCountry;
        if (i2 == 0) {
            this.mEtRegRu.setText(reg);
        } else {
            if (i2 != 3) {
                return;
            }
            this.mEtRegKz.setText(reg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRusChosen() {
        this.mPlatesFormat.setText(Html.fromHtml("<b>Формат номера:</b><br>с065мк 777"));
        this.mPlatesAllowed.setText(Html.fromHtml("<b>Разрешённые символы:</b><br>a b c e h k m o p t x y (английские)"));
        this.mLayoutList[0].setVisibility(0);
        this.mLayoutList[1].setVisibility(8);
        this.mLayoutList[2].setVisibility(8);
        this.mLayoutList[3].setVisibility(8);
        if (this.mType == 1) {
            this.mEditTexts[this.mChosenCountry].setFocusableInTouchMode(true);
            this.mEditTexts[this.mChosenCountry].setEnabled(true);
            this.mEtRegRu.setEnabled(true);
            this.mEtRegRu.setFocusableInTouchMode(true);
        } else {
            this.mEditTexts[this.mChosenCountry].setFocusableInTouchMode(false);
            this.mEditTexts[this.mChosenCountry].setEnabled(false);
            this.mEtRegRu.setEnabled(false);
            this.mEtRegRu.setFocusableInTouchMode(false);
        }
        this.mEditTexts[0].setText("");
        this.mEtRegRu.setText("");
        onPlateGuiCountryClicked(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUaChosen() {
        this.mPlatesFormat.setText(Html.fromHtml("<b>Формат номера:</b><br>AA 0000 AA"));
        this.mPlatesAllowed.setText(Html.fromHtml("<b>Разрешённые символы:</b><br>A B C E H K M O P T X Y (английские)"));
        this.mLayoutList[0].setVisibility(8);
        this.mLayoutList[1].setVisibility(0);
        this.mLayoutList[2].setVisibility(8);
        this.mLayoutList[3].setVisibility(8);
        if (this.mType == 1) {
            this.mEditTexts[this.mChosenCountry].setFocusableInTouchMode(true);
            this.mEditTexts[this.mChosenCountry].setEnabled(true);
        } else {
            this.mEditTexts[this.mChosenCountry].setFocusableInTouchMode(false);
            this.mEditTexts[this.mChosenCountry].setEnabled(false);
        }
        this.mEditTexts[this.mChosenCountry].setText("");
        onPlateGuiCountryClicked(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBuChosen() {
        this.mPlatesFormat.setText(Html.fromHtml("<b>Формат номера:</b><br>0000 AA-0"));
        this.mPlatesAllowed.setText(Html.fromHtml("<b>Разрешённые символы:</b><br>A B C E H K M O P T X Y (английские)"));
        this.mLayoutList[0].setVisibility(8);
        this.mLayoutList[1].setVisibility(8);
        this.mLayoutList[2].setVisibility(0);
        this.mLayoutList[3].setVisibility(8);
        if (this.mType == 1) {
            this.mEditTexts[this.mChosenCountry].setFocusableInTouchMode(true);
            this.mEditTexts[this.mChosenCountry].setEnabled(true);
        } else {
            this.mEditTexts[this.mChosenCountry].setFocusableInTouchMode(false);
            this.mEditTexts[this.mChosenCountry].setEnabled(false);
        }
        this.mEditTexts[2].setText("");
        onPlateGuiCountryClicked(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKzChosen() {
        this.mPlatesFormat.setText(Html.fromHtml("<b>Формат номера:</b><br>000aaa 08"));
        this.mPlatesAllowed.setText(Html.fromHtml("<b>Разрешённые символы:</b><br>A B C E H K M O P T X Y (английские)"));
        this.mLayoutList[0].setVisibility(8);
        this.mLayoutList[1].setVisibility(8);
        this.mLayoutList[2].setVisibility(8);
        this.mLayoutList[3].setVisibility(0);
        if (this.mType == 1) {
            this.mEditTexts[this.mChosenCountry].setFocusableInTouchMode(true);
            this.mEditTexts[this.mChosenCountry].setEnabled(true);
            this.mEtRegKz.setEnabled(true);
            this.mEtRegKz.setFocusableInTouchMode(true);
        } else {
            this.mEditTexts[this.mChosenCountry].setFocusableInTouchMode(false);
            this.mEditTexts[this.mChosenCountry].setEnabled(false);
            this.mEtRegKz.setEnabled(false);
            this.mEtRegKz.setFocusableInTouchMode(false);
        }
        this.mEditTexts[3].setEnabled(true);
        this.mEditTexts[3].setText("");
        this.mEtRegKz.setText("");
        onPlateGuiCountryClicked(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNumberValid(String input, char[] valid) {
        for (int i = 0; i < input.length(); i++) {
            boolean z = false;
            for (char c : valid) {
                if (input.charAt(i) == c) {
                    z = true;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRuNumber(String input) {
        return input.length() == 6 && !Character.isDigit(input.charAt(0)) && Character.isDigit(input.charAt(1)) && Character.isDigit(input.charAt(2)) && Character.isDigit(input.charAt(3)) && !Character.isDigit(input.charAt(4)) && !Character.isDigit(input.charAt(5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUANumber(String input) {
        return input.length() == 10 && !Character.isDigit(input.charAt(0)) && !Character.isDigit(input.charAt(1)) && input.charAt(2) == ' ' && Character.isDigit(input.charAt(3)) && Character.isDigit(input.charAt(4)) && Character.isDigit(input.charAt(5)) && Character.isDigit(input.charAt(6)) && input.charAt(7) == ' ' && !Character.isDigit(input.charAt(8)) && !Character.isDigit(input.charAt(9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBYNumber(String input) {
        return input.length() == 9 && Character.isDigit(input.charAt(8)) && input.charAt(7) == '-' && Character.isDigit(input.charAt(0)) && Character.isDigit(input.charAt(1)) && Character.isDigit(input.charAt(2)) && Character.isDigit(input.charAt(3)) && input.charAt(4) == ' ' && !Character.isDigit(input.charAt(5)) && !Character.isDigit(input.charAt(6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isKZNumber(String input) {
        return input.length() == 6 && Character.isDigit(input.charAt(0)) && Character.isDigit(input.charAt(1)) && Character.isDigit(input.charAt(2)) && !Character.isDigit(input.charAt(3)) && !Character.isDigit(input.charAt(4)) && !Character.isDigit(input.charAt(5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRegCorrect(String input) {
        if (this.mChosenCountry == 0 && isNumberValid(input, this.mAllowedReg)) {
            return true;
        }
        return this.mChosenCountry == 3 && isNumberValid(input, this.mAllowedReg);
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
        int i;
        try {
            i = json.getInt("t");
        } catch (Exception unused) {
            i = -1;
        }
        try {
            if (i == 0) {
                setPrices(json.getInt(TuningConstants.KEY_GET_ID_DETAIL), json.getInt("pr"));
            } else {
                if (i != 1) {
                    if (i == 2) {
                        setPlateTexts(json.getString(TuningConstants.KEY_GET_ID_DETAIL), json.getString(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL));
                    }
                }
                setHint(json.getString("h"));
            }
        } catch (Exception unused2) {
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mGUIManager = manager;
        show(activity.getSupportFragmentManager(), "dialog");
        try {
            this.mType = json.getInt("t");
        } catch (Exception unused) {
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        dismissAllowingStateLoss();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        if (getDialog() == null) {
            return false;
        }
        return getDialog().isShowing();
    }

    public void onPlateGuiClosed() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 0);
            this.mGUIManager.sendJsonData(1, jSONObject);
        } catch (Exception unused) {
        }
    }

    public void onPlateGuiCountryClicked(int code) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 1);
            jSONObject.put(Const.FRACTION_CLOSE_KEY, code);
            this.mGUIManager.sendJsonData(1, jSONObject);
        } catch (Exception unused) {
        }
    }

    public void onPlateGuiRefreshButtonPressed() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 2);
            this.mGUIManager.sendJsonData(1, jSONObject);
        } catch (Exception unused) {
        }
    }

    public void onBuyButtonPressed(String plate, String region) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 3);
            jSONObject.put(TuningConstants.KEY_GET_ID_DETAIL, plate);
            jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, region);
            this.mGUIManager.sendJsonData(1, jSONObject);
        } catch (Exception unused) {
        }
    }

    public void onPlateChangedText(int country, String plate, String region) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 4);
            jSONObject.put(Const.FRACTION_CLOSE_KEY, country);
            jSONObject.put(TuningConstants.KEY_GET_ID_DETAIL, plate);
            jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, region);
            this.mGUIManager.sendJsonData(1, jSONObject);
        } catch (Exception unused) {
        }
    }
}
