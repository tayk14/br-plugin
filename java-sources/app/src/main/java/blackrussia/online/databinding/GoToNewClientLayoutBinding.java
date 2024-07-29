package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class GoToNewClientLayoutBinding implements ViewBinding {
    public final ImageButton close;
    public final Button play;
    private final ConstraintLayout rootView;
    public final TextView textView;

    private GoToNewClientLayoutBinding(ConstraintLayout rootView, ImageButton close, Button play, TextView textView) {
        this.rootView = rootView;
        this.close = close;
        this.play = play;
        this.textView = textView;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GoToNewClientLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static GoToNewClientLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.go_to_new_client_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static GoToNewClientLayoutBinding bind(View rootView) {
        int i = R.id.close;
        ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.close);
        if (imageButton != null) {
            i = R.id.play;
            Button button = (Button) rootView.findViewById(R.id.play);
            if (button != null) {
                i = R.id.text_view;
                TextView textView = (TextView) rootView.findViewById(R.id.text_view);
                if (textView != null) {
                    return new GoToNewClientLayoutBinding((ConstraintLayout) rootView, imageButton, button, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
