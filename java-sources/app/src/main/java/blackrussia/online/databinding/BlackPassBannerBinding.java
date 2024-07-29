package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class BlackPassBannerBinding implements ViewBinding {
    public final View bannerBonusBody1;
    public final View bannerBonusBody2;
    public final View bannerBonusBody3;
    public final View bannerBonusHelpView2;
    public final ImageView bannerBonusIcon1;
    public final TextView bannerBonusTitleText1;
    public final TextView bannerBonusTitleText2;
    public final TextView bannerBonusTitleText3;
    public final View bannerMainTitle;
    public final AppCompatButton nyBannerButt;
    public final AppCompatButton nyBannerClose;
    public final TextView nyText1;
    public final TextView nyText2;
    private final ConstraintLayout rootView;

    private BlackPassBannerBinding(ConstraintLayout rootView, View bannerBonusBody1, View bannerBonusBody2, View bannerBonusBody3, View bannerBonusHelpView2, ImageView bannerBonusIcon1, TextView bannerBonusTitleText1, TextView bannerBonusTitleText2, TextView bannerBonusTitleText3, View bannerMainTitle, AppCompatButton nyBannerButt, AppCompatButton nyBannerClose, TextView nyText1, TextView nyText2) {
        this.rootView = rootView;
        this.bannerBonusBody1 = bannerBonusBody1;
        this.bannerBonusBody2 = bannerBonusBody2;
        this.bannerBonusBody3 = bannerBonusBody3;
        this.bannerBonusHelpView2 = bannerBonusHelpView2;
        this.bannerBonusIcon1 = bannerBonusIcon1;
        this.bannerBonusTitleText1 = bannerBonusTitleText1;
        this.bannerBonusTitleText2 = bannerBonusTitleText2;
        this.bannerBonusTitleText3 = bannerBonusTitleText3;
        this.bannerMainTitle = bannerMainTitle;
        this.nyBannerButt = nyBannerButt;
        this.nyBannerClose = nyBannerClose;
        this.nyText1 = nyText1;
        this.nyText2 = nyText2;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlackPassBannerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BlackPassBannerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.black_pass_banner, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlackPassBannerBinding bind(View rootView) {
        int i = R.id.banner_bonus_body_1;
        View findViewById = rootView.findViewById(R.id.banner_bonus_body_1);
        if (findViewById != null) {
            i = R.id.banner_bonus_body_2;
            View findViewById2 = rootView.findViewById(R.id.banner_bonus_body_2);
            if (findViewById2 != null) {
                i = R.id.banner_bonus_body_3;
                View findViewById3 = rootView.findViewById(R.id.banner_bonus_body_3);
                if (findViewById3 != null) {
                    i = R.id.banner_bonus_help_view_2;
                    View findViewById4 = rootView.findViewById(R.id.banner_bonus_help_view_2);
                    if (findViewById4 != null) {
                        i = R.id.banner_bonus_icon_1;
                        ImageView imageView = (ImageView) rootView.findViewById(R.id.banner_bonus_icon_1);
                        if (imageView != null) {
                            i = R.id.banner_bonus_title_text_1;
                            TextView textView = (TextView) rootView.findViewById(R.id.banner_bonus_title_text_1);
                            if (textView != null) {
                                i = R.id.banner_bonus_title_text_2;
                                TextView textView2 = (TextView) rootView.findViewById(R.id.banner_bonus_title_text_2);
                                if (textView2 != null) {
                                    i = R.id.banner_bonus_title_text_3;
                                    TextView textView3 = (TextView) rootView.findViewById(R.id.banner_bonus_title_text_3);
                                    if (textView3 != null) {
                                        i = R.id.banner_main_title;
                                        View findViewById5 = rootView.findViewById(R.id.banner_main_title);
                                        if (findViewById5 != null) {
                                            i = R.id.ny_banner_butt;
                                            AppCompatButton appCompatButton = (AppCompatButton) rootView.findViewById(R.id.ny_banner_butt);
                                            if (appCompatButton != null) {
                                                i = R.id.ny_banner_close;
                                                AppCompatButton appCompatButton2 = (AppCompatButton) rootView.findViewById(R.id.ny_banner_close);
                                                if (appCompatButton2 != null) {
                                                    i = R.id.ny_text_1;
                                                    TextView textView4 = (TextView) rootView.findViewById(R.id.ny_text_1);
                                                    if (textView4 != null) {
                                                        i = R.id.ny_text_2;
                                                        TextView textView5 = (TextView) rootView.findViewById(R.id.ny_text_2);
                                                        if (textView5 != null) {
                                                            return new BlackPassBannerBinding((ConstraintLayout) rootView, findViewById, findViewById2, findViewById3, findViewById4, imageView, textView, textView2, textView3, findViewById5, appCompatButton, appCompatButton2, textView4, textView5);
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
