package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class SocialInteractionBinding implements ViewBinding {
    public final View bgSocialInteraction;
    public final View bottomBlackSocial;
    public final TextView button1;
    public final TextView button2;
    public final TextView button3;
    public final TextView button4;
    public final TextView button5;
    public final TextView button6;
    public final TextView button7;
    public final TextView buttonWithNickname;
    public final ImageView closeInteraction;
    public final TextView helpText1Social;
    public final TextView helpText2Social;
    public final View leftBlackSocial;
    public final View rightBlackSocial;
    private final ConstraintLayout rootView;
    public final View topBlackSocial;
    public final View windowSocial;

    private SocialInteractionBinding(ConstraintLayout rootView, View bgSocialInteraction, View bottomBlackSocial, TextView button1, TextView button2, TextView button3, TextView button4, TextView button5, TextView button6, TextView button7, TextView buttonWithNickname, ImageView closeInteraction, TextView helpText1Social, TextView helpText2Social, View leftBlackSocial, View rightBlackSocial, View topBlackSocial, View windowSocial) {
        this.rootView = rootView;
        this.bgSocialInteraction = bgSocialInteraction;
        this.bottomBlackSocial = bottomBlackSocial;
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.button4 = button4;
        this.button5 = button5;
        this.button6 = button6;
        this.button7 = button7;
        this.buttonWithNickname = buttonWithNickname;
        this.closeInteraction = closeInteraction;
        this.helpText1Social = helpText1Social;
        this.helpText2Social = helpText2Social;
        this.leftBlackSocial = leftBlackSocial;
        this.rightBlackSocial = rightBlackSocial;
        this.topBlackSocial = topBlackSocial;
        this.windowSocial = windowSocial;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SocialInteractionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SocialInteractionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.social_interaction, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SocialInteractionBinding bind(View rootView) {
        int i = R.id.bg_social_interaction;
        View findViewById = rootView.findViewById(R.id.bg_social_interaction);
        if (findViewById != null) {
            i = R.id.bottom_black_social;
            View findViewById2 = rootView.findViewById(R.id.bottom_black_social);
            if (findViewById2 != null) {
                i = R.id.button_1;
                TextView textView = (TextView) rootView.findViewById(R.id.button_1);
                if (textView != null) {
                    i = R.id.button_2;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.button_2);
                    if (textView2 != null) {
                        i = R.id.button_3;
                        TextView textView3 = (TextView) rootView.findViewById(R.id.button_3);
                        if (textView3 != null) {
                            i = R.id.button_4;
                            TextView textView4 = (TextView) rootView.findViewById(R.id.button_4);
                            if (textView4 != null) {
                                i = R.id.button_5;
                                TextView textView5 = (TextView) rootView.findViewById(R.id.button_5);
                                if (textView5 != null) {
                                    i = R.id.button_6;
                                    TextView textView6 = (TextView) rootView.findViewById(R.id.button_6);
                                    if (textView6 != null) {
                                        i = R.id.button_7;
                                        TextView textView7 = (TextView) rootView.findViewById(R.id.button_7);
                                        if (textView7 != null) {
                                            i = R.id.button_with_nickname;
                                            TextView textView8 = (TextView) rootView.findViewById(R.id.button_with_nickname);
                                            if (textView8 != null) {
                                                i = R.id.close_interaction;
                                                ImageView imageView = (ImageView) rootView.findViewById(R.id.close_interaction);
                                                if (imageView != null) {
                                                    i = R.id.help_text_1_social;
                                                    TextView textView9 = (TextView) rootView.findViewById(R.id.help_text_1_social);
                                                    if (textView9 != null) {
                                                        i = R.id.help_text_2_social;
                                                        TextView textView10 = (TextView) rootView.findViewById(R.id.help_text_2_social);
                                                        if (textView10 != null) {
                                                            i = R.id.left_black_social;
                                                            View findViewById3 = rootView.findViewById(R.id.left_black_social);
                                                            if (findViewById3 != null) {
                                                                i = R.id.right_black_social;
                                                                View findViewById4 = rootView.findViewById(R.id.right_black_social);
                                                                if (findViewById4 != null) {
                                                                    i = R.id.top_black_social;
                                                                    View findViewById5 = rootView.findViewById(R.id.top_black_social);
                                                                    if (findViewById5 != null) {
                                                                        i = R.id.window_social;
                                                                        View findViewById6 = rootView.findViewById(R.id.window_social);
                                                                        if (findViewById6 != null) {
                                                                            return new SocialInteractionBinding((ConstraintLayout) rootView, findViewById, findViewById2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, imageView, textView9, textView10, findViewById3, findViewById4, findViewById5, findViewById6);
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
