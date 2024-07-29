package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class EntertainmentSystemGamesFilterItemBinding implements ViewBinding {
    public final TextView gameItemFilter;
    private final ConstraintLayout rootView;

    private EntertainmentSystemGamesFilterItemBinding(ConstraintLayout rootView, TextView gameItemFilter) {
        this.rootView = rootView;
        this.gameItemFilter = gameItemFilter;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EntertainmentSystemGamesFilterItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EntertainmentSystemGamesFilterItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.entertainment_system_games_filter_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EntertainmentSystemGamesFilterItemBinding bind(View rootView) {
        TextView textView = (TextView) rootView.findViewById(R.id.game_item_filter);
        if (textView != null) {
            return new EntertainmentSystemGamesFilterItemBinding((ConstraintLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.game_item_filter)));
    }
}
