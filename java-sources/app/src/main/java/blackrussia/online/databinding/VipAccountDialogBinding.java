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

public final class VipAccountDialogBinding implements ViewBinding {
    public final View bottomYellowLine;
    public final Button buttonByuVip;
    public final View closeVipAccountDialog;
    public final View helpEndPosition;
    public final View iconWorker;
    public final View leftBlock;
    public final TextView moneyCurrency;
    public final TextView moneyCurrencyInfo;
    public final TextView moneyCurrencyWould;
    public final ImageView moneyIcon;
    public final ImageView moneyIconWould;
    public final TextView moneyValue;
    public final TextView moneyValueWould;
    public final View possibleEarningsBg;
    private final ConstraintLayout rootView;
    public final View topYellowLine;
    public final TextView vipAccountText1;
    public final TextView vipAccountText2;
    public final View vipCrowIcon;
    public final View whiteLine;
    public final TextView wouldEarnTitle;
    public final ImageView wouldVip;
    public final View yourPayBg;
    public final TextView yourPayTitle;

    private VipAccountDialogBinding(ConstraintLayout rootView, View bottomYellowLine, Button buttonByuVip, View closeVipAccountDialog, View helpEndPosition, View iconWorker, View leftBlock, TextView moneyCurrency, TextView moneyCurrencyInfo, TextView moneyCurrencyWould, ImageView moneyIcon, ImageView moneyIconWould, TextView moneyValue, TextView moneyValueWould, View possibleEarningsBg, View topYellowLine, TextView vipAccountText1, TextView vipAccountText2, View vipCrowIcon, View whiteLine, TextView wouldEarnTitle, ImageView wouldVip, View yourPayBg, TextView yourPayTitle) {
        this.rootView = rootView;
        this.bottomYellowLine = bottomYellowLine;
        this.buttonByuVip = buttonByuVip;
        this.closeVipAccountDialog = closeVipAccountDialog;
        this.helpEndPosition = helpEndPosition;
        this.iconWorker = iconWorker;
        this.leftBlock = leftBlock;
        this.moneyCurrency = moneyCurrency;
        this.moneyCurrencyInfo = moneyCurrencyInfo;
        this.moneyCurrencyWould = moneyCurrencyWould;
        this.moneyIcon = moneyIcon;
        this.moneyIconWould = moneyIconWould;
        this.moneyValue = moneyValue;
        this.moneyValueWould = moneyValueWould;
        this.possibleEarningsBg = possibleEarningsBg;
        this.topYellowLine = topYellowLine;
        this.vipAccountText1 = vipAccountText1;
        this.vipAccountText2 = vipAccountText2;
        this.vipCrowIcon = vipCrowIcon;
        this.whiteLine = whiteLine;
        this.wouldEarnTitle = wouldEarnTitle;
        this.wouldVip = wouldVip;
        this.yourPayBg = yourPayBg;
        this.yourPayTitle = yourPayTitle;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static VipAccountDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static VipAccountDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.vip_account_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static VipAccountDialogBinding bind(View rootView) {
        int i = R.id.bottom_yellow_line;
        View findViewById = rootView.findViewById(R.id.bottom_yellow_line);
        if (findViewById != null) {
            i = R.id.button_byu_vip;
            Button button = (Button) rootView.findViewById(R.id.button_byu_vip);
            if (button != null) {
                i = R.id.close_vip_account_dialog;
                View findViewById2 = rootView.findViewById(R.id.close_vip_account_dialog);
                if (findViewById2 != null) {
                    i = R.id.help_end_position;
                    View findViewById3 = rootView.findViewById(R.id.help_end_position);
                    if (findViewById3 != null) {
                        i = R.id.icon_worker;
                        View findViewById4 = rootView.findViewById(R.id.icon_worker);
                        if (findViewById4 != null) {
                            i = R.id.left_block;
                            View findViewById5 = rootView.findViewById(R.id.left_block);
                            if (findViewById5 != null) {
                                i = R.id.money_currency;
                                TextView textView = (TextView) rootView.findViewById(R.id.money_currency);
                                if (textView != null) {
                                    i = R.id.money_currency_info;
                                    TextView textView2 = (TextView) rootView.findViewById(R.id.money_currency_info);
                                    if (textView2 != null) {
                                        i = R.id.money_currency_would;
                                        TextView textView3 = (TextView) rootView.findViewById(R.id.money_currency_would);
                                        if (textView3 != null) {
                                            i = R.id.money_icon;
                                            ImageView imageView = (ImageView) rootView.findViewById(R.id.money_icon);
                                            if (imageView != null) {
                                                i = R.id.money_icon_would;
                                                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.money_icon_would);
                                                if (imageView2 != null) {
                                                    i = R.id.money_value;
                                                    TextView textView4 = (TextView) rootView.findViewById(R.id.money_value);
                                                    if (textView4 != null) {
                                                        i = R.id.money_value_would;
                                                        TextView textView5 = (TextView) rootView.findViewById(R.id.money_value_would);
                                                        if (textView5 != null) {
                                                            i = R.id.possible_earnings_bg;
                                                            View findViewById6 = rootView.findViewById(R.id.possible_earnings_bg);
                                                            if (findViewById6 != null) {
                                                                i = R.id.top_yellow_line;
                                                                View findViewById7 = rootView.findViewById(R.id.top_yellow_line);
                                                                if (findViewById7 != null) {
                                                                    i = R.id.vip_account_text_1;
                                                                    TextView textView6 = (TextView) rootView.findViewById(R.id.vip_account_text_1);
                                                                    if (textView6 != null) {
                                                                        i = R.id.vip_account_text_2;
                                                                        TextView textView7 = (TextView) rootView.findViewById(R.id.vip_account_text_2);
                                                                        if (textView7 != null) {
                                                                            i = R.id.vip_crow_icon;
                                                                            View findViewById8 = rootView.findViewById(R.id.vip_crow_icon);
                                                                            if (findViewById8 != null) {
                                                                                i = R.id.white_line;
                                                                                View findViewById9 = rootView.findViewById(R.id.white_line);
                                                                                if (findViewById9 != null) {
                                                                                    i = R.id.would_earn_title;
                                                                                    TextView textView8 = (TextView) rootView.findViewById(R.id.would_earn_title);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.would_vip;
                                                                                        ImageView imageView3 = (ImageView) rootView.findViewById(R.id.would_vip);
                                                                                        if (imageView3 != null) {
                                                                                            i = R.id.your_pay_bg;
                                                                                            View findViewById10 = rootView.findViewById(R.id.your_pay_bg);
                                                                                            if (findViewById10 != null) {
                                                                                                i = R.id.your_pay_title;
                                                                                                TextView textView9 = (TextView) rootView.findViewById(R.id.your_pay_title);
                                                                                                if (textView9 != null) {
                                                                                                    return new VipAccountDialogBinding((ConstraintLayout) rootView, findViewById, button, findViewById2, findViewById3, findViewById4, findViewById5, textView, textView2, textView3, imageView, imageView2, textView4, textView5, findViewById6, findViewById7, textView6, textView7, findViewById8, findViewById9, textView8, imageView3, findViewById10, textView9);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
