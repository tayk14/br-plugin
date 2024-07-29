package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesPlayersItemBinding implements ViewBinding {
    public final TextView playersNick;
    public final TextView playersRank;
    public final View playersStatus;
    private final ConstraintLayout rootView;

    private FamiliesPlayersItemBinding(ConstraintLayout rootView, TextView playersNick, TextView playersRank, View playersStatus) {
        this.rootView = rootView;
        this.playersNick = playersNick;
        this.playersRank = playersRank;
        this.playersStatus = playersStatus;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesPlayersItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesPlayersItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_players_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesPlayersItemBinding bind(View rootView) {
        int i = R.id.players_nick;
        TextView textView = (TextView) rootView.findViewById(R.id.players_nick);
        if (textView != null) {
            i = R.id.players_rank;
            TextView textView2 = (TextView) rootView.findViewById(R.id.players_rank);
            if (textView2 != null) {
                i = R.id.players_status;
                View findViewById = rootView.findViewById(R.id.players_status);
                if (findViewById != null) {
                    return new FamiliesPlayersItemBinding((ConstraintLayout) rootView, textView, textView2, findViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
