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
import com.rockstargames.gtacr.common.UIContainer;

public final class FamiliesMainContainerBinding implements ViewBinding {
    public final ImageView addMoney;
    public final View bgBlackCoinView;
    public final View bgMoneyView;
    public final View bgTitleMask;
    public final View blackCoinUnderline;
    public final TextView blackCoinValue;
    public final Button buttonBack;
    public final Button buttonClose;
    public final Button buttonFamiliesSetting;
    public final ImageView buttonNotification;
    public final Button buttonTop;
    public final UIContainer mainContainer;
    public final View moneyUnderline;
    public final TextView moneyValue;
    private final ConstraintLayout rootView;
    public final View titleDiver;
    public final TextView titleText;
    public final TextView valueNotification;

    private FamiliesMainContainerBinding(ConstraintLayout rootView, ImageView addMoney, View bgBlackCoinView, View bgMoneyView, View bgTitleMask, View blackCoinUnderline, TextView blackCoinValue, Button buttonBack, Button buttonClose, Button buttonFamiliesSetting, ImageView buttonNotification, Button buttonTop, UIContainer mainContainer, View moneyUnderline, TextView moneyValue, View titleDiver, TextView titleText, TextView valueNotification) {
        this.rootView = rootView;
        this.addMoney = addMoney;
        this.bgBlackCoinView = bgBlackCoinView;
        this.bgMoneyView = bgMoneyView;
        this.bgTitleMask = bgTitleMask;
        this.blackCoinUnderline = blackCoinUnderline;
        this.blackCoinValue = blackCoinValue;
        this.buttonBack = buttonBack;
        this.buttonClose = buttonClose;
        this.buttonFamiliesSetting = buttonFamiliesSetting;
        this.buttonNotification = buttonNotification;
        this.buttonTop = buttonTop;
        this.mainContainer = mainContainer;
        this.moneyUnderline = moneyUnderline;
        this.moneyValue = moneyValue;
        this.titleDiver = titleDiver;
        this.titleText = titleText;
        this.valueNotification = valueNotification;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesMainContainerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesMainContainerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_main_container, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesMainContainerBinding bind(View rootView) {
        int i = R.id.add_money;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.add_money);
        if (imageView != null) {
            i = R.id.bg_black_coin_view;
            View findViewById = rootView.findViewById(R.id.bg_black_coin_view);
            if (findViewById != null) {
                i = R.id.bg_money_view;
                View findViewById2 = rootView.findViewById(R.id.bg_money_view);
                if (findViewById2 != null) {
                    i = R.id.bg_title_mask;
                    View findViewById3 = rootView.findViewById(R.id.bg_title_mask);
                    if (findViewById3 != null) {
                        i = R.id.black_coin_underline;
                        View findViewById4 = rootView.findViewById(R.id.black_coin_underline);
                        if (findViewById4 != null) {
                            i = R.id.black_coin_value;
                            TextView textView = (TextView) rootView.findViewById(R.id.black_coin_value);
                            if (textView != null) {
                                i = R.id.button_back;
                                Button button = (Button) rootView.findViewById(R.id.button_back);
                                if (button != null) {
                                    i = R.id.button_close;
                                    Button button2 = (Button) rootView.findViewById(R.id.button_close);
                                    if (button2 != null) {
                                        i = R.id.button_families_setting;
                                        Button button3 = (Button) rootView.findViewById(R.id.button_families_setting);
                                        if (button3 != null) {
                                            i = R.id.button_notification;
                                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.button_notification);
                                            if (imageView2 != null) {
                                                i = R.id.button_top;
                                                Button button4 = (Button) rootView.findViewById(R.id.button_top);
                                                if (button4 != null) {
                                                    i = R.id.main_container;
                                                    UIContainer uIContainer = (UIContainer) rootView.findViewById(R.id.main_container);
                                                    if (uIContainer != null) {
                                                        i = R.id.money_underline;
                                                        View findViewById5 = rootView.findViewById(R.id.money_underline);
                                                        if (findViewById5 != null) {
                                                            i = R.id.money_value;
                                                            TextView textView2 = (TextView) rootView.findViewById(R.id.money_value);
                                                            if (textView2 != null) {
                                                                i = R.id.title_diver;
                                                                View findViewById6 = rootView.findViewById(R.id.title_diver);
                                                                if (findViewById6 != null) {
                                                                    i = R.id.title_text;
                                                                    TextView textView3 = (TextView) rootView.findViewById(R.id.title_text);
                                                                    if (textView3 != null) {
                                                                        i = R.id.value_notification;
                                                                        TextView textView4 = (TextView) rootView.findViewById(R.id.value_notification);
                                                                        if (textView4 != null) {
                                                                            return new FamiliesMainContainerBinding((ConstraintLayout) rootView, imageView, findViewById, findViewById2, findViewById3, findViewById4, textView, button, button2, button3, imageView2, button4, uIContainer, findViewById5, textView2, findViewById6, textView3, textView4);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
