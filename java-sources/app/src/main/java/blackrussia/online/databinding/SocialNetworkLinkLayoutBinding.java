package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class SocialNetworkLinkLayoutBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final View socialNetworkLinkAdd;
    public final Button socialNetworkLinkButtonClose;
    public final RecyclerView socialNetworkLinkButtons;
    public final CheckBox socialNetworkLinkCheckbox;
    public final TextView socialNetworkLinkCheckboxText;
    public final TextView socialNetworkLinkDescription;
    public final View socialNetworkLinkMoneyPresentBg;
    public final TextView socialNetworkLinkPresentsTitle;
    public final View socialNetworkLinkTitle;
    public final View socialNetworkLinkVipPresentBg;

    private SocialNetworkLinkLayoutBinding(ConstraintLayout rootView, View socialNetworkLinkAdd, Button socialNetworkLinkButtonClose, RecyclerView socialNetworkLinkButtons, CheckBox socialNetworkLinkCheckbox, TextView socialNetworkLinkCheckboxText, TextView socialNetworkLinkDescription, View socialNetworkLinkMoneyPresentBg, TextView socialNetworkLinkPresentsTitle, View socialNetworkLinkTitle, View socialNetworkLinkVipPresentBg) {
        this.rootView = rootView;
        this.socialNetworkLinkAdd = socialNetworkLinkAdd;
        this.socialNetworkLinkButtonClose = socialNetworkLinkButtonClose;
        this.socialNetworkLinkButtons = socialNetworkLinkButtons;
        this.socialNetworkLinkCheckbox = socialNetworkLinkCheckbox;
        this.socialNetworkLinkCheckboxText = socialNetworkLinkCheckboxText;
        this.socialNetworkLinkDescription = socialNetworkLinkDescription;
        this.socialNetworkLinkMoneyPresentBg = socialNetworkLinkMoneyPresentBg;
        this.socialNetworkLinkPresentsTitle = socialNetworkLinkPresentsTitle;
        this.socialNetworkLinkTitle = socialNetworkLinkTitle;
        this.socialNetworkLinkVipPresentBg = socialNetworkLinkVipPresentBg;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SocialNetworkLinkLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SocialNetworkLinkLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.social_network_link_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SocialNetworkLinkLayoutBinding bind(View rootView) {
        int i = R.id.social_network_link_add;
        View findViewById = rootView.findViewById(R.id.social_network_link_add);
        if (findViewById != null) {
            i = R.id.social_network_link_button_close;
            Button button = (Button) rootView.findViewById(R.id.social_network_link_button_close);
            if (button != null) {
                i = R.id.social_network_link_buttons;
                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.social_network_link_buttons);
                if (recyclerView != null) {
                    i = R.id.social_network_link_checkbox;
                    CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.social_network_link_checkbox);
                    if (checkBox != null) {
                        i = R.id.social_network_link_checkbox_text;
                        TextView textView = (TextView) rootView.findViewById(R.id.social_network_link_checkbox_text);
                        if (textView != null) {
                            i = R.id.social_network_link_description;
                            TextView textView2 = (TextView) rootView.findViewById(R.id.social_network_link_description);
                            if (textView2 != null) {
                                i = R.id.social_network_link_money_present_bg;
                                View findViewById2 = rootView.findViewById(R.id.social_network_link_money_present_bg);
                                if (findViewById2 != null) {
                                    i = R.id.social_network_link_presents_title;
                                    TextView textView3 = (TextView) rootView.findViewById(R.id.social_network_link_presents_title);
                                    if (textView3 != null) {
                                        i = R.id.social_network_link_title;
                                        View findViewById3 = rootView.findViewById(R.id.social_network_link_title);
                                        if (findViewById3 != null) {
                                            i = R.id.social_network_link_vip_present_bg;
                                            View findViewById4 = rootView.findViewById(R.id.social_network_link_vip_present_bg);
                                            if (findViewById4 != null) {
                                                return new SocialNetworkLinkLayoutBinding((ConstraintLayout) rootView, findViewById, button, recyclerView, checkBox, textView, textView2, findViewById2, textView3, findViewById3, findViewById4);
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
