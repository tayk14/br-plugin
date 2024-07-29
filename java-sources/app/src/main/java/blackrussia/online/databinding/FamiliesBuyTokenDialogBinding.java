package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.rockstargames.gtacr.gui.familySystem.CustomEditText;

public final class FamiliesBuyTokenDialogBinding implements ViewBinding {
    public final Button buttonBuyToken;
    public final Button buttonCancel;
    public final View dialogBuyTokenBgEffect;
    public final View dialogBuyTokenBgView;
    public final TextView dialogBuyTokenBodyItem;
    public final CustomEditText editTextTokenValue;
    private final ConstraintLayout rootView;
    public final TextView textTitleBuyToken;
    public final TextView textValueBuyToken;
    public final View titleDialogBuyToken;

    private FamiliesBuyTokenDialogBinding(ConstraintLayout rootView, Button buttonBuyToken, Button buttonCancel, View dialogBuyTokenBgEffect, View dialogBuyTokenBgView, TextView dialogBuyTokenBodyItem, CustomEditText editTextTokenValue, TextView textTitleBuyToken, TextView textValueBuyToken, View titleDialogBuyToken) {
        this.rootView = rootView;
        this.buttonBuyToken = buttonBuyToken;
        this.buttonCancel = buttonCancel;
        this.dialogBuyTokenBgEffect = dialogBuyTokenBgEffect;
        this.dialogBuyTokenBgView = dialogBuyTokenBgView;
        this.dialogBuyTokenBodyItem = dialogBuyTokenBodyItem;
        this.editTextTokenValue = editTextTokenValue;
        this.textTitleBuyToken = textTitleBuyToken;
        this.textValueBuyToken = textValueBuyToken;
        this.titleDialogBuyToken = titleDialogBuyToken;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesBuyTokenDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesBuyTokenDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_buy_token_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesBuyTokenDialogBinding bind(View rootView) {
        int i = R.id.button_buy_token;
        Button button = (Button) rootView.findViewById(R.id.button_buy_token);
        if (button != null) {
            i = R.id.button_cancel;
            Button button2 = (Button) rootView.findViewById(R.id.button_cancel);
            if (button2 != null) {
                i = R.id.dialog_buy_token_bg_effect;
                View findViewById = rootView.findViewById(R.id.dialog_buy_token_bg_effect);
                if (findViewById != null) {
                    i = R.id.dialog_buy_token_bg_view;
                    View findViewById2 = rootView.findViewById(R.id.dialog_buy_token_bg_view);
                    if (findViewById2 != null) {
                        i = R.id.dialog_buy_token_body_item;
                        TextView textView = (TextView) rootView.findViewById(R.id.dialog_buy_token_body_item);
                        if (textView != null) {
                            i = R.id.edit_text_token_value;
                            CustomEditText customEditText = (CustomEditText) rootView.findViewById(R.id.edit_text_token_value);
                            if (customEditText != null) {
                                i = R.id.text_title_buy_token;
                                TextView textView2 = (TextView) rootView.findViewById(R.id.text_title_buy_token);
                                if (textView2 != null) {
                                    i = R.id.text_value_buy_token;
                                    TextView textView3 = (TextView) rootView.findViewById(R.id.text_value_buy_token);
                                    if (textView3 != null) {
                                        i = R.id.title_dialog_buy_token;
                                        View findViewById3 = rootView.findViewById(R.id.title_dialog_buy_token);
                                        if (findViewById3 != null) {
                                            return new FamiliesBuyTokenDialogBinding((ConstraintLayout) rootView, button, button2, findViewById, findViewById2, textView, customEditText, textView2, textView3, findViewById3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
