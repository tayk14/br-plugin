package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class EntertainmentSystemFinalWindowBinding implements ViewBinding {
    public final View closeFinalWindow;
    public final TextView gamesStatus;
    private final ConstraintLayout rootView;

    private EntertainmentSystemFinalWindowBinding(ConstraintLayout rootView, View closeFinalWindow, TextView gamesStatus) {
        this.rootView = rootView;
        this.closeFinalWindow = closeFinalWindow;
        this.gamesStatus = gamesStatus;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EntertainmentSystemFinalWindowBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EntertainmentSystemFinalWindowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.entertainment_system_final_window, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EntertainmentSystemFinalWindowBinding bind(View rootView) {
        int i = R.id.close_final_window;
        View findViewById = rootView.findViewById(R.id.close_final_window);
        if (findViewById != null) {
            i = R.id.games_status;
            TextView textView = (TextView) rootView.findViewById(R.id.games_status);
            if (textView != null) {
                return new EntertainmentSystemFinalWindowBinding((ConstraintLayout) rootView, findViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
