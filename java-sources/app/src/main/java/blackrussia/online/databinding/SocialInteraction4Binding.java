package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class SocialInteraction4Binding implements ViewBinding {
    public final TextView button1;
    public final TextView button3;
    public final TextView button4;
    public final TextView button5;
    public final TextView button7;
    public final TextView buttonWithNickname;
    public final ImageView closeInteraction;
    private final ConstraintLayout rootView;

    private SocialInteraction4Binding(ConstraintLayout rootView, TextView button1, TextView button3, TextView button4, TextView button5, TextView button7, TextView buttonWithNickname, ImageView closeInteraction) {
        this.rootView = rootView;
        this.button1 = button1;
        this.button3 = button3;
        this.button4 = button4;
        this.button5 = button5;
        this.button7 = button7;
        this.buttonWithNickname = buttonWithNickname;
        this.closeInteraction = closeInteraction;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SocialInteraction4Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SocialInteraction4Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.social_interaction_4, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SocialInteraction4Binding bind(View rootView) {
        int i = R.id.button_1;
        TextView textView = (TextView) rootView.findViewById(R.id.button_1);
        if (textView != null) {
            i = R.id.button_3;
            TextView textView2 = (TextView) rootView.findViewById(R.id.button_3);
            if (textView2 != null) {
                i = R.id.button_4;
                TextView textView3 = (TextView) rootView.findViewById(R.id.button_4);
                if (textView3 != null) {
                    i = R.id.button_5;
                    TextView textView4 = (TextView) rootView.findViewById(R.id.button_5);
                    if (textView4 != null) {
                        i = R.id.button_7;
                        TextView textView5 = (TextView) rootView.findViewById(R.id.button_7);
                        if (textView5 != null) {
                            i = R.id.button_with_nickname;
                            TextView textView6 = (TextView) rootView.findViewById(R.id.button_with_nickname);
                            if (textView6 != null) {
                                i = R.id.close_interaction;
                                ImageView imageView = (ImageView) rootView.findViewById(R.id.close_interaction);
                                if (imageView != null) {
                                    return new SocialInteraction4Binding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, imageView);
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
