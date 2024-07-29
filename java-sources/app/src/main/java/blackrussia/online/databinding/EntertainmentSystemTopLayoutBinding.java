package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class EntertainmentSystemTopLayoutBinding implements ViewBinding {
    public final ImageView arrowSubmenu;
    public final View bodyTable;
    public final RecyclerView currentPlayer;
    public final View leftBg;
    public final RecyclerView listWithGamesFilter;
    public final ImageView otherTopIcon;
    public final RecyclerView playersTop;
    public final View rightBg;
    private final ConstraintLayout rootView;
    public final TextView title1;
    public final TextView title2;
    public final TextView title3;
    public final TextView title4;
    public final TextView titleGame;
    public final TextView titleGameOther;
    public final TextView titleOtherTop;
    public final ImageView topIcon;
    public final View topTable;
    public final TextView valueGame;
    public final TextView valueGameOther;
    public final TextView valueOtherTop;

    private EntertainmentSystemTopLayoutBinding(ConstraintLayout rootView, ImageView arrowSubmenu, View bodyTable, RecyclerView currentPlayer, View leftBg, RecyclerView listWithGamesFilter, ImageView otherTopIcon, RecyclerView playersTop, View rightBg, TextView title1, TextView title2, TextView title3, TextView title4, TextView titleGame, TextView titleGameOther, TextView titleOtherTop, ImageView topIcon, View topTable, TextView valueGame, TextView valueGameOther, TextView valueOtherTop) {
        this.rootView = rootView;
        this.arrowSubmenu = arrowSubmenu;
        this.bodyTable = bodyTable;
        this.currentPlayer = currentPlayer;
        this.leftBg = leftBg;
        this.listWithGamesFilter = listWithGamesFilter;
        this.otherTopIcon = otherTopIcon;
        this.playersTop = playersTop;
        this.rightBg = rightBg;
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
        this.title4 = title4;
        this.titleGame = titleGame;
        this.titleGameOther = titleGameOther;
        this.titleOtherTop = titleOtherTop;
        this.topIcon = topIcon;
        this.topTable = topTable;
        this.valueGame = valueGame;
        this.valueGameOther = valueGameOther;
        this.valueOtherTop = valueOtherTop;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EntertainmentSystemTopLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EntertainmentSystemTopLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.entertainment_system_top_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EntertainmentSystemTopLayoutBinding bind(View rootView) {
        int i = R.id.arrow_submenu;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.arrow_submenu);
        if (imageView != null) {
            i = R.id.body_table;
            View findViewById = rootView.findViewById(R.id.body_table);
            if (findViewById != null) {
                i = R.id.current_player;
                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.current_player);
                if (recyclerView != null) {
                    i = R.id.left_bg;
                    View findViewById2 = rootView.findViewById(R.id.left_bg);
                    if (findViewById2 != null) {
                        i = R.id.list_with_games_filter;
                        RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.list_with_games_filter);
                        if (recyclerView2 != null) {
                            i = R.id.other_top_icon;
                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.other_top_icon);
                            if (imageView2 != null) {
                                i = R.id.players_top;
                                RecyclerView recyclerView3 = (RecyclerView) rootView.findViewById(R.id.players_top);
                                if (recyclerView3 != null) {
                                    i = R.id.right_bg;
                                    View findViewById3 = rootView.findViewById(R.id.right_bg);
                                    if (findViewById3 != null) {
                                        i = R.id.title_1;
                                        TextView textView = (TextView) rootView.findViewById(R.id.title_1);
                                        if (textView != null) {
                                            i = R.id.title_2;
                                            TextView textView2 = (TextView) rootView.findViewById(R.id.title_2);
                                            if (textView2 != null) {
                                                i = R.id.title_3;
                                                TextView textView3 = (TextView) rootView.findViewById(R.id.title_3);
                                                if (textView3 != null) {
                                                    i = R.id.title_4;
                                                    TextView textView4 = (TextView) rootView.findViewById(R.id.title_4);
                                                    if (textView4 != null) {
                                                        i = R.id.title_game;
                                                        TextView textView5 = (TextView) rootView.findViewById(R.id.title_game);
                                                        if (textView5 != null) {
                                                            i = R.id.title_game_other;
                                                            TextView textView6 = (TextView) rootView.findViewById(R.id.title_game_other);
                                                            if (textView6 != null) {
                                                                i = R.id.title_other_top;
                                                                TextView textView7 = (TextView) rootView.findViewById(R.id.title_other_top);
                                                                if (textView7 != null) {
                                                                    i = R.id.top_icon;
                                                                    ImageView imageView3 = (ImageView) rootView.findViewById(R.id.top_icon);
                                                                    if (imageView3 != null) {
                                                                        i = R.id.top_table;
                                                                        View findViewById4 = rootView.findViewById(R.id.top_table);
                                                                        if (findViewById4 != null) {
                                                                            i = R.id.value_game;
                                                                            TextView textView8 = (TextView) rootView.findViewById(R.id.value_game);
                                                                            if (textView8 != null) {
                                                                                i = R.id.value_game_other;
                                                                                TextView textView9 = (TextView) rootView.findViewById(R.id.value_game_other);
                                                                                if (textView9 != null) {
                                                                                    i = R.id.value_other_top;
                                                                                    TextView textView10 = (TextView) rootView.findViewById(R.id.value_other_top);
                                                                                    if (textView10 != null) {
                                                                                        return new EntertainmentSystemTopLayoutBinding((ConstraintLayout) rootView, imageView, findViewById, recyclerView, findViewById2, recyclerView2, imageView2, recyclerView3, findViewById3, textView, textView2, textView3, textView4, textView5, textView6, textView7, imageView3, findViewById4, textView8, textView9, textView10);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
