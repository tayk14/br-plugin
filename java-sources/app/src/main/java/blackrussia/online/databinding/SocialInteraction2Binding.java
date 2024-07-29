package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class SocialInteraction2Binding implements ViewBinding {
    public final TextView button2;
    public final TextView button4;
    public final TextView button6;
    public final TextView buttonWithNickname;
    public final ImageView closeInteraction;
    private final ConstraintLayout rootView;

    private SocialInteraction2Binding(ConstraintLayout rootView, TextView button2, TextView button4, TextView button6, TextView buttonWithNickname, ImageView closeInteraction) {
        this.rootView = rootView;
        this.button2 = button2;
        this.button4 = button4;
        this.button6 = button6;
        this.buttonWithNickname = buttonWithNickname;
        this.closeInteraction = closeInteraction;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SocialInteraction2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SocialInteraction2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.social_interaction_2, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SocialInteraction2Binding bind(View rootView) {
        int i = R.id.button_2;
        TextView textView = (TextView) rootView.findViewById(R.id.button_2);
        if (textView != null) {
            i = R.id.button_4;
            TextView textView2 = (TextView) rootView.findViewById(R.id.button_4);
            if (textView2 != null) {
                i = R.id.button_6;
                TextView textView3 = (TextView) rootView.findViewById(R.id.button_6);
                if (textView3 != null) {
                    i = R.id.button_with_nickname;
                    TextView textView4 = (TextView) rootView.findViewById(R.id.button_with_nickname);
                    if (textView4 != null) {
                        i = R.id.close_interaction;
                        ImageView imageView = (ImageView) rootView.findViewById(R.id.close_interaction);
                        if (imageView != null) {
                            return new SocialInteraction2Binding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
