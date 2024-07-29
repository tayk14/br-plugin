package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class SocialInteraction1Binding implements ViewBinding {
    public final TextView button3;
    public final TextView button5;
    public final TextView buttonWithNickname;
    public final ImageView closeInteraction;
    private final ConstraintLayout rootView;

    private SocialInteraction1Binding(ConstraintLayout rootView, TextView button3, TextView button5, TextView buttonWithNickname, ImageView closeInteraction) {
        this.rootView = rootView;
        this.button3 = button3;
        this.button5 = button5;
        this.buttonWithNickname = buttonWithNickname;
        this.closeInteraction = closeInteraction;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SocialInteraction1Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SocialInteraction1Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.social_interaction_1, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SocialInteraction1Binding bind(View rootView) {
        int i = R.id.button_3;
        TextView textView = (TextView) rootView.findViewById(R.id.button_3);
        if (textView != null) {
            i = R.id.button_5;
            TextView textView2 = (TextView) rootView.findViewById(R.id.button_5);
            if (textView2 != null) {
                i = R.id.button_with_nickname;
                TextView textView3 = (TextView) rootView.findViewById(R.id.button_with_nickname);
                if (textView3 != null) {
                    i = R.id.close_interaction;
                    ImageView imageView = (ImageView) rootView.findViewById(R.id.close_interaction);
                    if (imageView != null) {
                        return new SocialInteraction1Binding((ConstraintLayout) rootView, textView, textView2, textView3, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
