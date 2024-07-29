package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class EntertainmentSystemTopItemBinding implements ViewBinding {
    public final ImageView gameIcon;
    public final ImageView leftIcon;
    public final TextView playersGames;
    public final TextView playersNick;
    public final ImageView rightIcon;
    private final ConstraintLayout rootView;
    public final TextView topPosition;

    private EntertainmentSystemTopItemBinding(ConstraintLayout rootView, ImageView gameIcon, ImageView leftIcon, TextView playersGames, TextView playersNick, ImageView rightIcon, TextView topPosition) {
        this.rootView = rootView;
        this.gameIcon = gameIcon;
        this.leftIcon = leftIcon;
        this.playersGames = playersGames;
        this.playersNick = playersNick;
        this.rightIcon = rightIcon;
        this.topPosition = topPosition;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EntertainmentSystemTopItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EntertainmentSystemTopItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.entertainment_system_top_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EntertainmentSystemTopItemBinding bind(View rootView) {
        int i = R.id.game_icon;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.game_icon);
        if (imageView != null) {
            i = R.id.left_icon;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.left_icon);
            if (imageView2 != null) {
                i = R.id.players_games;
                TextView textView = (TextView) rootView.findViewById(R.id.players_games);
                if (textView != null) {
                    i = R.id.players_nick;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.players_nick);
                    if (textView2 != null) {
                        i = R.id.right_icon;
                        ImageView imageView3 = (ImageView) rootView.findViewById(R.id.right_icon);
                        if (imageView3 != null) {
                            i = R.id.top_position;
                            TextView textView3 = (TextView) rootView.findViewById(R.id.top_position);
                            if (textView3 != null) {
                                return new EntertainmentSystemTopItemBinding((ConstraintLayout) rootView, imageView, imageView2, textView, textView2, imageView3, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
