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

public final class FamiliesPlayersActionItemBinding implements ViewBinding {
    public final TextView actionsTitle;
    public final TextView actionsValue;
    public final Button buttonKick;
    public final ImageView buttonMinusAction;
    public final ImageView buttonPlusAction;
    private final ConstraintLayout rootView;

    private FamiliesPlayersActionItemBinding(ConstraintLayout rootView, TextView actionsTitle, TextView actionsValue, Button buttonKick, ImageView buttonMinusAction, ImageView buttonPlusAction) {
        this.rootView = rootView;
        this.actionsTitle = actionsTitle;
        this.actionsValue = actionsValue;
        this.buttonKick = buttonKick;
        this.buttonMinusAction = buttonMinusAction;
        this.buttonPlusAction = buttonPlusAction;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesPlayersActionItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesPlayersActionItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_players_action_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesPlayersActionItemBinding bind(View rootView) {
        int i = R.id.actions_title;
        TextView textView = (TextView) rootView.findViewById(R.id.actions_title);
        if (textView != null) {
            i = R.id.actions_value;
            TextView textView2 = (TextView) rootView.findViewById(R.id.actions_value);
            if (textView2 != null) {
                i = R.id.button_kick;
                Button button = (Button) rootView.findViewById(R.id.button_kick);
                if (button != null) {
                    i = R.id.button_minus_action;
                    ImageView imageView = (ImageView) rootView.findViewById(R.id.button_minus_action);
                    if (imageView != null) {
                        i = R.id.button_plus_action;
                        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.button_plus_action);
                        if (imageView2 != null) {
                            return new FamiliesPlayersActionItemBinding((ConstraintLayout) rootView, textView, textView2, button, imageView, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
