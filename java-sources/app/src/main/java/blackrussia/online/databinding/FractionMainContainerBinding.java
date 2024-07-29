package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.UIContainer;

public final class FractionMainContainerBinding implements ViewBinding {
    public final View bgMoneyView;
    public final View bgTitleMask;
    public final View bgTitleView;
    public final ImageButton buttonAddMoney;
    public final ImageButton buttonBack;
    public final Button buttonClose;
    public final ImageButton buttonFractionsDocuments;
    public final ImageButton buttonFractionsSetting;
    public final ImageButton buttonMoneyShop;
    public final ImageView iconTitleFraction;
    public final UIContainer mainContainer;
    public final View moneyUnderline;
    public final TextView moneyValue;
    private final ConstraintLayout rootView;
    public final TextView textTitleFraction;
    public final View titleDiver;
    public final ImageView viewBackgroundMainContainer;

    private FractionMainContainerBinding(ConstraintLayout rootView, View bgMoneyView, View bgTitleMask, View bgTitleView, ImageButton buttonAddMoney, ImageButton buttonBack, Button buttonClose, ImageButton buttonFractionsDocuments, ImageButton buttonFractionsSetting, ImageButton buttonMoneyShop, ImageView iconTitleFraction, UIContainer mainContainer, View moneyUnderline, TextView moneyValue, TextView textTitleFraction, View titleDiver, ImageView viewBackgroundMainContainer) {
        this.rootView = rootView;
        this.bgMoneyView = bgMoneyView;
        this.bgTitleMask = bgTitleMask;
        this.bgTitleView = bgTitleView;
        this.buttonAddMoney = buttonAddMoney;
        this.buttonBack = buttonBack;
        this.buttonClose = buttonClose;
        this.buttonFractionsDocuments = buttonFractionsDocuments;
        this.buttonFractionsSetting = buttonFractionsSetting;
        this.buttonMoneyShop = buttonMoneyShop;
        this.iconTitleFraction = iconTitleFraction;
        this.mainContainer = mainContainer;
        this.moneyUnderline = moneyUnderline;
        this.moneyValue = moneyValue;
        this.textTitleFraction = textTitleFraction;
        this.titleDiver = titleDiver;
        this.viewBackgroundMainContainer = viewBackgroundMainContainer;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionMainContainerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionMainContainerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fraction_main_container, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionMainContainerBinding bind(View rootView) {
        int i = R.id.bg_money_view;
        View findViewById = rootView.findViewById(R.id.bg_money_view);
        if (findViewById != null) {
            i = R.id.bg_title_mask;
            View findViewById2 = rootView.findViewById(R.id.bg_title_mask);
            if (findViewById2 != null) {
                i = R.id.bg_title_view;
                View findViewById3 = rootView.findViewById(R.id.bg_title_view);
                if (findViewById3 != null) {
                    i = R.id.button_add_money;
                    ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.button_add_money);
                    if (imageButton != null) {
                        i = R.id.button_back;
                        ImageButton imageButton2 = (ImageButton) rootView.findViewById(R.id.button_back);
                        if (imageButton2 != null) {
                            i = R.id.button_close;
                            Button button = (Button) rootView.findViewById(R.id.button_close);
                            if (button != null) {
                                i = R.id.button_fractions_documents;
                                ImageButton imageButton3 = (ImageButton) rootView.findViewById(R.id.button_fractions_documents);
                                if (imageButton3 != null) {
                                    i = R.id.button_fractions_setting;
                                    ImageButton imageButton4 = (ImageButton) rootView.findViewById(R.id.button_fractions_setting);
                                    if (imageButton4 != null) {
                                        i = R.id.button_money_shop;
                                        ImageButton imageButton5 = (ImageButton) rootView.findViewById(R.id.button_money_shop);
                                        if (imageButton5 != null) {
                                            i = R.id.icon_title_fraction;
                                            ImageView imageView = (ImageView) rootView.findViewById(R.id.icon_title_fraction);
                                            if (imageView != null) {
                                                i = R.id.main_container;
                                                UIContainer uIContainer = (UIContainer) rootView.findViewById(R.id.main_container);
                                                if (uIContainer != null) {
                                                    i = R.id.money_underline;
                                                    View findViewById4 = rootView.findViewById(R.id.money_underline);
                                                    if (findViewById4 != null) {
                                                        i = R.id.money_value;
                                                        TextView textView = (TextView) rootView.findViewById(R.id.money_value);
                                                        if (textView != null) {
                                                            i = R.id.text_title_fraction;
                                                            TextView textView2 = (TextView) rootView.findViewById(R.id.text_title_fraction);
                                                            if (textView2 != null) {
                                                                i = R.id.title_diver;
                                                                View findViewById5 = rootView.findViewById(R.id.title_diver);
                                                                if (findViewById5 != null) {
                                                                    i = R.id.view_background_main_container;
                                                                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.view_background_main_container);
                                                                    if (imageView2 != null) {
                                                                        return new FractionMainContainerBinding((ConstraintLayout) rootView, findViewById, findViewById2, findViewById3, imageButton, imageButton2, button, imageButton3, imageButton4, imageButton5, imageView, uIContainer, findViewById4, textView, textView2, findViewById5, imageView2);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
