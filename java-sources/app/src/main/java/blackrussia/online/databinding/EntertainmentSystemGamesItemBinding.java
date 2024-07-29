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

public final class EntertainmentSystemGamesItemBinding implements ViewBinding {
    public final TextView actionsTitle;
    public final View bgItem;
    public final View bgItemsBorder;
    public final Button buttonAction;
    public final ImageView itemsIcon;
    private final ConstraintLayout rootView;
    public final TextView valueOfPlayers;

    private EntertainmentSystemGamesItemBinding(ConstraintLayout rootView, TextView actionsTitle, View bgItem, View bgItemsBorder, Button buttonAction, ImageView itemsIcon, TextView valueOfPlayers) {
        this.rootView = rootView;
        this.actionsTitle = actionsTitle;
        this.bgItem = bgItem;
        this.bgItemsBorder = bgItemsBorder;
        this.buttonAction = buttonAction;
        this.itemsIcon = itemsIcon;
        this.valueOfPlayers = valueOfPlayers;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EntertainmentSystemGamesItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EntertainmentSystemGamesItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.entertainment_system_games_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EntertainmentSystemGamesItemBinding bind(View rootView) {
        int i = R.id.actions_title;
        TextView textView = (TextView) rootView.findViewById(R.id.actions_title);
        if (textView != null) {
            i = R.id.bg_item;
            View findViewById = rootView.findViewById(R.id.bg_item);
            if (findViewById != null) {
                i = R.id.bg_items_border;
                View findViewById2 = rootView.findViewById(R.id.bg_items_border);
                if (findViewById2 != null) {
                    i = R.id.button_action;
                    Button button = (Button) rootView.findViewById(R.id.button_action);
                    if (button != null) {
                        i = R.id.items_icon;
                        ImageView imageView = (ImageView) rootView.findViewById(R.id.items_icon);
                        if (imageView != null) {
                            i = R.id.value_of_players;
                            TextView textView2 = (TextView) rootView.findViewById(R.id.value_of_players);
                            if (textView2 != null) {
                                return new EntertainmentSystemGamesItemBinding((ConstraintLayout) rootView, textView, findViewById, findViewById2, button, imageView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
