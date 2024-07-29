package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class EntertainmentSystemGamesLayoutBinding implements ViewBinding {
    public final RecyclerView listWithGames;
    private final ConstraintLayout rootView;

    private EntertainmentSystemGamesLayoutBinding(ConstraintLayout rootView, RecyclerView listWithGames) {
        this.rootView = rootView;
        this.listWithGames = listWithGames;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EntertainmentSystemGamesLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EntertainmentSystemGamesLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.entertainment_system_games_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EntertainmentSystemGamesLayoutBinding bind(View rootView) {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list_with_games);
        if (recyclerView != null) {
            return new EntertainmentSystemGamesLayoutBinding((ConstraintLayout) rootView, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.list_with_games)));
    }
}
