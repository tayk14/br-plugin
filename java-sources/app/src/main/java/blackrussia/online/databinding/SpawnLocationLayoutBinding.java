package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class SpawnLocationLayoutBinding implements ViewBinding {
    public final Button buttonEnter;
    public final RecyclerView recyclerViewSpawnLocation;
    private final ConstraintLayout rootView;
    public final TextView tvSpawnPlace;

    private SpawnLocationLayoutBinding(ConstraintLayout rootView, Button buttonEnter, RecyclerView recyclerViewSpawnLocation, TextView tvSpawnPlace) {
        this.rootView = rootView;
        this.buttonEnter = buttonEnter;
        this.recyclerViewSpawnLocation = recyclerViewSpawnLocation;
        this.tvSpawnPlace = tvSpawnPlace;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SpawnLocationLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SpawnLocationLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.spawn_location_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SpawnLocationLayoutBinding bind(View rootView) {
        int i = R.id.button_enter;
        Button button = (Button) rootView.findViewById(R.id.button_enter);
        if (button != null) {
            i = R.id.recycler_view_spawn_location;
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_spawn_location);
            if (recyclerView != null) {
                i = R.id.tv_spawn_place;
                TextView textView = (TextView) rootView.findViewById(R.id.tv_spawn_place);
                if (textView != null) {
                    return new SpawnLocationLayoutBinding((ConstraintLayout) rootView, button, recyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
