package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class SocialNetworkLinkButtonBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final View socialNetworkLinkButtonAura;
    public final View socialNetworkLinkButtonBgColorNotActive;
    public final View socialNetworkLinkButtonBgStyleNotActive;
    public final View socialNetworkLinkButtonBorder;
    public final View socialNetworkLinkButtonIcon;
    public final TextView socialNetworkLinkButtonName;

    private SocialNetworkLinkButtonBinding(ConstraintLayout rootView, View socialNetworkLinkButtonAura, View socialNetworkLinkButtonBgColorNotActive, View socialNetworkLinkButtonBgStyleNotActive, View socialNetworkLinkButtonBorder, View socialNetworkLinkButtonIcon, TextView socialNetworkLinkButtonName) {
        this.rootView = rootView;
        this.socialNetworkLinkButtonAura = socialNetworkLinkButtonAura;
        this.socialNetworkLinkButtonBgColorNotActive = socialNetworkLinkButtonBgColorNotActive;
        this.socialNetworkLinkButtonBgStyleNotActive = socialNetworkLinkButtonBgStyleNotActive;
        this.socialNetworkLinkButtonBorder = socialNetworkLinkButtonBorder;
        this.socialNetworkLinkButtonIcon = socialNetworkLinkButtonIcon;
        this.socialNetworkLinkButtonName = socialNetworkLinkButtonName;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SocialNetworkLinkButtonBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SocialNetworkLinkButtonBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.social_network_link_button, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SocialNetworkLinkButtonBinding bind(View rootView) {
        int i = R.id.social_network_link_button_aura;
        View findViewById = rootView.findViewById(R.id.social_network_link_button_aura);
        if (findViewById != null) {
            i = R.id.social_network_link_button_bg_color_not_active;
            View findViewById2 = rootView.findViewById(R.id.social_network_link_button_bg_color_not_active);
            if (findViewById2 != null) {
                i = R.id.social_network_link_button_bg_style_not_active;
                View findViewById3 = rootView.findViewById(R.id.social_network_link_button_bg_style_not_active);
                if (findViewById3 != null) {
                    i = R.id.social_network_link_button_border;
                    View findViewById4 = rootView.findViewById(R.id.social_network_link_button_border);
                    if (findViewById4 != null) {
                        i = R.id.social_network_link_button_icon;
                        View findViewById5 = rootView.findViewById(R.id.social_network_link_button_icon);
                        if (findViewById5 != null) {
                            i = R.id.social_network_link_button_name;
                            TextView textView = (TextView) rootView.findViewById(R.id.social_network_link_button_name);
                            if (textView != null) {
                                return new SocialNetworkLinkButtonBinding((ConstraintLayout) rootView, findViewById, findViewById2, findViewById3, findViewById4, findViewById5, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
