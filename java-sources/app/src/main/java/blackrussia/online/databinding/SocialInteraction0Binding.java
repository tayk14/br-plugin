package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class SocialInteraction0Binding implements ViewBinding {
    public final TextView button4;
    public final TextView buttonWithNickname;
    public final ImageView closeInteraction;
    private final ConstraintLayout rootView;

    private SocialInteraction0Binding(ConstraintLayout rootView, TextView button4, TextView buttonWithNickname, ImageView closeInteraction) {
        this.rootView = rootView;
        this.button4 = button4;
        this.buttonWithNickname = buttonWithNickname;
        this.closeInteraction = closeInteraction;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SocialInteraction0Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SocialInteraction0Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.social_interaction_0, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SocialInteraction0Binding bind(View rootView) {
        int i = R.id.button_4;
        TextView textView = (TextView) rootView.findViewById(R.id.button_4);
        if (textView != null) {
            i = R.id.button_with_nickname;
            TextView textView2 = (TextView) rootView.findViewById(R.id.button_with_nickname);
            if (textView2 != null) {
                i = R.id.close_interaction;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.close_interaction);
                if (imageView != null) {
                    return new SocialInteraction0Binding((ConstraintLayout) rootView, textView, textView2, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
