package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesRatingLayoutBinding implements ViewBinding {
    public final View bgTitleTableWithColumns;
    public final View bodyTable;
    public final Button buttonTopPrices;
    public final RecyclerView currentFamily;
    public final TextView familyIcon;
    public final TextView familyNick;
    public final RecyclerView familyTop;
    public final View leftBg;
    public final View leftBottomBlock;
    public final ImageView otherTopIcon;
    public final TextView playersGames;
    public final View rightBg;
    private final ConstraintLayout rootView;
    public final TextView titleOtherTop;
    public final TextView titleRating;
    public final TextView titleRatingOther;
    public final ImageView topIcon;
    public final TextView topPosition;
    public final TextView topTable;
    public final TextView valueCaptured;
    public final TextView valueOtherTop;

    private FamiliesRatingLayoutBinding(ConstraintLayout rootView, View bgTitleTableWithColumns, View bodyTable, Button buttonTopPrices, RecyclerView currentFamily, TextView familyIcon, TextView familyNick, RecyclerView familyTop, View leftBg, View leftBottomBlock, ImageView otherTopIcon, TextView playersGames, View rightBg, TextView titleOtherTop, TextView titleRating, TextView titleRatingOther, ImageView topIcon, TextView topPosition, TextView topTable, TextView valueCaptured, TextView valueOtherTop) {
        this.rootView = rootView;
        this.bgTitleTableWithColumns = bgTitleTableWithColumns;
        this.bodyTable = bodyTable;
        this.buttonTopPrices = buttonTopPrices;
        this.currentFamily = currentFamily;
        this.familyIcon = familyIcon;
        this.familyNick = familyNick;
        this.familyTop = familyTop;
        this.leftBg = leftBg;
        this.leftBottomBlock = leftBottomBlock;
        this.otherTopIcon = otherTopIcon;
        this.playersGames = playersGames;
        this.rightBg = rightBg;
        this.titleOtherTop = titleOtherTop;
        this.titleRating = titleRating;
        this.titleRatingOther = titleRatingOther;
        this.topIcon = topIcon;
        this.topPosition = topPosition;
        this.topTable = topTable;
        this.valueCaptured = valueCaptured;
        this.valueOtherTop = valueOtherTop;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesRatingLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesRatingLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_rating_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesRatingLayoutBinding bind(View rootView) {
        int i = R.id.bg_title_table_with_columns;
        View findViewById = rootView.findViewById(R.id.bg_title_table_with_columns);
        if (findViewById != null) {
            i = R.id.body_table;
            View findViewById2 = rootView.findViewById(R.id.body_table);
            if (findViewById2 != null) {
                i = R.id.button_top_prices;
                Button button = (Button) rootView.findViewById(R.id.button_top_prices);
                if (button != null) {
                    i = R.id.current_family;
                    RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.current_family);
                    if (recyclerView != null) {
                        i = R.id.family_icon;
                        TextView textView = (TextView) rootView.findViewById(R.id.family_icon);
                        if (textView != null) {
                            i = R.id.family_nick;
                            TextView textView2 = (TextView) rootView.findViewById(R.id.family_nick);
                            if (textView2 != null) {
                                i = R.id.family_top;
                                RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.family_top);
                                if (recyclerView2 != null) {
                                    i = R.id.left_bg;
                                    View findViewById3 = rootView.findViewById(R.id.left_bg);
                                    if (findViewById3 != null) {
                                        i = R.id.left_bottom_block;
                                        View findViewById4 = rootView.findViewById(R.id.left_bottom_block);
                                        if (findViewById4 != null) {
                                            i = R.id.other_top_icon;
                                            ImageView imageView = (ImageView) rootView.findViewById(R.id.other_top_icon);
                                            if (imageView != null) {
                                                i = R.id.players_games;
                                                TextView textView3 = (TextView) rootView.findViewById(R.id.players_games);
                                                if (textView3 != null) {
                                                    i = R.id.right_bg;
                                                    View findViewById5 = rootView.findViewById(R.id.right_bg);
                                                    if (findViewById5 != null) {
                                                        i = R.id.title_other_top;
                                                        TextView textView4 = (TextView) rootView.findViewById(R.id.title_other_top);
                                                        if (textView4 != null) {
                                                            i = R.id.title_rating;
                                                            TextView textView5 = (TextView) rootView.findViewById(R.id.title_rating);
                                                            if (textView5 != null) {
                                                                i = R.id.title_rating_other;
                                                                TextView textView6 = (TextView) rootView.findViewById(R.id.title_rating_other);
                                                                if (textView6 != null) {
                                                                    i = R.id.top_icon;
                                                                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.top_icon);
                                                                    if (imageView2 != null) {
                                                                        i = R.id.top_position;
                                                                        TextView textView7 = (TextView) rootView.findViewById(R.id.top_position);
                                                                        if (textView7 != null) {
                                                                            i = R.id.top_table;
                                                                            TextView textView8 = (TextView) rootView.findViewById(R.id.top_table);
                                                                            if (textView8 != null) {
                                                                                i = R.id.value_captured;
                                                                                TextView textView9 = (TextView) rootView.findViewById(R.id.value_captured);
                                                                                if (textView9 != null) {
                                                                                    i = R.id.value_other_top;
                                                                                    TextView textView10 = (TextView) rootView.findViewById(R.id.value_other_top);
                                                                                    if (textView10 != null) {
                                                                                        return new FamiliesRatingLayoutBinding((ConstraintLayout) rootView, findViewById, findViewById2, button, recyclerView, textView, textView2, recyclerView2, findViewById3, findViewById4, imageView, textView3, findViewById5, textView4, textView5, textView6, imageView2, textView7, textView8, textView9, textView10);
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
