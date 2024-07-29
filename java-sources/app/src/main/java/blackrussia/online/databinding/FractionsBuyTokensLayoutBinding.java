package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.CustomEditTextWithBackPressEvent;

public final class FractionsBuyTokensLayoutBinding implements ViewBinding {
    public final ImageView bgEffectShadow;
    public final View bgHeaderView;
    public final Button buttonByuTokens;
    public final Button buttonCancel;
    public final View buyTokensMainView;
    public final CustomEditTextWithBackPressEvent editTextTokens;
    private final ConstraintLayout rootView;
    public final TextView textViewBcValue;
    public final TextView textViewBuyTokensFor;
    public final TextView textViewEnterTokensSum;
    public final View titleDiver;

    private FractionsBuyTokensLayoutBinding(ConstraintLayout rootView, ImageView bgEffectShadow, View bgHeaderView, Button buttonByuTokens, Button buttonCancel, View buyTokensMainView, CustomEditTextWithBackPressEvent editTextTokens, TextView textViewBcValue, TextView textViewBuyTokensFor, TextView textViewEnterTokensSum, View titleDiver) {
        this.rootView = rootView;
        this.bgEffectShadow = bgEffectShadow;
        this.bgHeaderView = bgHeaderView;
        this.buttonByuTokens = buttonByuTokens;
        this.buttonCancel = buttonCancel;
        this.buyTokensMainView = buyTokensMainView;
        this.editTextTokens = editTextTokens;
        this.textViewBcValue = textViewBcValue;
        this.textViewBuyTokensFor = textViewBuyTokensFor;
        this.textViewEnterTokensSum = textViewEnterTokensSum;
        this.titleDiver = titleDiver;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsBuyTokensLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsBuyTokensLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_buy_tokens_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsBuyTokensLayoutBinding bind(View rootView) {
        int i = R.id.bg_effect_shadow;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.bg_effect_shadow);
        if (imageView != null) {
            i = R.id.bg_header_view;
            View findViewById = rootView.findViewById(R.id.bg_header_view);
            if (findViewById != null) {
                i = R.id.button_byu_tokens;
                Button button = (Button) rootView.findViewById(R.id.button_byu_tokens);
                if (button != null) {
                    i = R.id.button_cancel;
                    Button button2 = (Button) rootView.findViewById(R.id.button_cancel);
                    if (button2 != null) {
                        i = R.id.buy_tokens_main_view;
                        View findViewById2 = rootView.findViewById(R.id.buy_tokens_main_view);
                        if (findViewById2 != null) {
                            i = R.id.edit_text_tokens;
                            CustomEditTextWithBackPressEvent customEditTextWithBackPressEvent = (CustomEditTextWithBackPressEvent) rootView.findViewById(R.id.edit_text_tokens);
                            if (customEditTextWithBackPressEvent != null) {
                                i = R.id.text_view_bc_value;
                                TextView textView = (TextView) rootView.findViewById(R.id.text_view_bc_value);
                                if (textView != null) {
                                    i = R.id.text_view_buy_tokens_for;
                                    TextView textView2 = (TextView) rootView.findViewById(R.id.text_view_buy_tokens_for);
                                    if (textView2 != null) {
                                        i = R.id.text_view_enter_tokens_sum;
                                        TextView textView3 = (TextView) rootView.findViewById(R.id.text_view_enter_tokens_sum);
                                        if (textView3 != null) {
                                            i = R.id.title_diver;
                                            View findViewById3 = rootView.findViewById(R.id.title_diver);
                                            if (findViewById3 != null) {
                                                return new FractionsBuyTokensLayoutBinding((ConstraintLayout) rootView, imageView, findViewById, button, button2, findViewById2, customEditTextWithBackPressEvent, textView, textView2, textView3, findViewById3);
                                            }
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
