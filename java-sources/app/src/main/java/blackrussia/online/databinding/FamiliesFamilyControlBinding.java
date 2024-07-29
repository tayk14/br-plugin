package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesFamilyControlBinding implements ViewBinding {
    public final RecyclerView actionWithPlayer;
    public final View bgFamilySkin;
    public final View bodyPlayersInfo;
    public final View bodyRightBlock;
    public final ImageView buttonBackToMenu;
    public final ImageView buttonPlayersFilter;
    public final ImageView buttonPlayersSearch;
    public final EditText editTextSearch;
    public final FrameLayout familySkin;
    public final View leftTitleDiver;
    public final View mainBodyPlayersInfo;
    public final TextView personalFile;
    public final TextView phoneNumber;
    public final TextView phoneNumberValue;
    public final RecyclerView playersFilterList;
    public final NestedScrollView playersInfo;
    public final TextView playersLevel;
    public final TextView playersLevelValue;
    public final RecyclerView playersList;
    public final TextView playersPosition;
    public final TextView playersPositionValue;
    public final TextView playersRank;
    public final TextView playersRankValue;
    public final TextView reprimands;
    public final TextView reprimandsValue;
    private final ConstraintLayout rootView;
    public final View tablesTitleLeftBlock;
    public final TextView titleLeftBlock;
    public final TextView titleRightBlock;

    private FamiliesFamilyControlBinding(ConstraintLayout rootView, RecyclerView actionWithPlayer, View bgFamilySkin, View bodyPlayersInfo, View bodyRightBlock, ImageView buttonBackToMenu, ImageView buttonPlayersFilter, ImageView buttonPlayersSearch, EditText editTextSearch, FrameLayout familySkin, View leftTitleDiver, View mainBodyPlayersInfo, TextView personalFile, TextView phoneNumber, TextView phoneNumberValue, RecyclerView playersFilterList, NestedScrollView playersInfo, TextView playersLevel, TextView playersLevelValue, RecyclerView playersList, TextView playersPosition, TextView playersPositionValue, TextView playersRank, TextView playersRankValue, TextView reprimands, TextView reprimandsValue, View tablesTitleLeftBlock, TextView titleLeftBlock, TextView titleRightBlock) {
        this.rootView = rootView;
        this.actionWithPlayer = actionWithPlayer;
        this.bgFamilySkin = bgFamilySkin;
        this.bodyPlayersInfo = bodyPlayersInfo;
        this.bodyRightBlock = bodyRightBlock;
        this.buttonBackToMenu = buttonBackToMenu;
        this.buttonPlayersFilter = buttonPlayersFilter;
        this.buttonPlayersSearch = buttonPlayersSearch;
        this.editTextSearch = editTextSearch;
        this.familySkin = familySkin;
        this.leftTitleDiver = leftTitleDiver;
        this.mainBodyPlayersInfo = mainBodyPlayersInfo;
        this.personalFile = personalFile;
        this.phoneNumber = phoneNumber;
        this.phoneNumberValue = phoneNumberValue;
        this.playersFilterList = playersFilterList;
        this.playersInfo = playersInfo;
        this.playersLevel = playersLevel;
        this.playersLevelValue = playersLevelValue;
        this.playersList = playersList;
        this.playersPosition = playersPosition;
        this.playersPositionValue = playersPositionValue;
        this.playersRank = playersRank;
        this.playersRankValue = playersRankValue;
        this.reprimands = reprimands;
        this.reprimandsValue = reprimandsValue;
        this.tablesTitleLeftBlock = tablesTitleLeftBlock;
        this.titleLeftBlock = titleLeftBlock;
        this.titleRightBlock = titleRightBlock;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesFamilyControlBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesFamilyControlBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_family_control, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesFamilyControlBinding bind(View rootView) {
        int i = R.id.action_with_player;
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.action_with_player);
        if (recyclerView != null) {
            i = R.id.bg_family_skin;
            View findViewById = rootView.findViewById(R.id.bg_family_skin);
            if (findViewById != null) {
                i = R.id.body_players_info;
                View findViewById2 = rootView.findViewById(R.id.body_players_info);
                if (findViewById2 != null) {
                    i = R.id.body_right_block;
                    View findViewById3 = rootView.findViewById(R.id.body_right_block);
                    if (findViewById3 != null) {
                        i = R.id.button_back_to_menu;
                        ImageView imageView = (ImageView) rootView.findViewById(R.id.button_back_to_menu);
                        if (imageView != null) {
                            i = R.id.button_players_filter;
                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.button_players_filter);
                            if (imageView2 != null) {
                                i = R.id.button_players_search;
                                ImageView imageView3 = (ImageView) rootView.findViewById(R.id.button_players_search);
                                if (imageView3 != null) {
                                    i = R.id.edit_text_search;
                                    EditText editText = (EditText) rootView.findViewById(R.id.edit_text_search);
                                    if (editText != null) {
                                        i = R.id.family_skin;
                                        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.family_skin);
                                        if (frameLayout != null) {
                                            i = R.id.left_title_diver;
                                            View findViewById4 = rootView.findViewById(R.id.left_title_diver);
                                            if (findViewById4 != null) {
                                                i = R.id.main_body_players_info;
                                                View findViewById5 = rootView.findViewById(R.id.main_body_players_info);
                                                if (findViewById5 != null) {
                                                    i = R.id.personal_file;
                                                    TextView textView = (TextView) rootView.findViewById(R.id.personal_file);
                                                    if (textView != null) {
                                                        i = R.id.phone_number;
                                                        TextView textView2 = (TextView) rootView.findViewById(R.id.phone_number);
                                                        if (textView2 != null) {
                                                            i = R.id.phone_number_value;
                                                            TextView textView3 = (TextView) rootView.findViewById(R.id.phone_number_value);
                                                            if (textView3 != null) {
                                                                i = R.id.players_filter_list;
                                                                RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.players_filter_list);
                                                                if (recyclerView2 != null) {
                                                                    i = R.id.players_info;
                                                                    NestedScrollView nestedScrollView = (NestedScrollView) rootView.findViewById(R.id.players_info);
                                                                    if (nestedScrollView != null) {
                                                                        i = R.id.players_level;
                                                                        TextView textView4 = (TextView) rootView.findViewById(R.id.players_level);
                                                                        if (textView4 != null) {
                                                                            i = R.id.players_level_value;
                                                                            TextView textView5 = (TextView) rootView.findViewById(R.id.players_level_value);
                                                                            if (textView5 != null) {
                                                                                i = R.id.players_list;
                                                                                RecyclerView recyclerView3 = (RecyclerView) rootView.findViewById(R.id.players_list);
                                                                                if (recyclerView3 != null) {
                                                                                    i = R.id.players_position;
                                                                                    TextView textView6 = (TextView) rootView.findViewById(R.id.players_position);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.players_position_value;
                                                                                        TextView textView7 = (TextView) rootView.findViewById(R.id.players_position_value);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.players_rank;
                                                                                            TextView textView8 = (TextView) rootView.findViewById(R.id.players_rank);
                                                                                            if (textView8 != null) {
                                                                                                i = R.id.players_rank_value;
                                                                                                TextView textView9 = (TextView) rootView.findViewById(R.id.players_rank_value);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.reprimands;
                                                                                                    TextView textView10 = (TextView) rootView.findViewById(R.id.reprimands);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.reprimands_value;
                                                                                                        TextView textView11 = (TextView) rootView.findViewById(R.id.reprimands_value);
                                                                                                        if (textView11 != null) {
                                                                                                            i = R.id.tables_title_left_block;
                                                                                                            View findViewById6 = rootView.findViewById(R.id.tables_title_left_block);
                                                                                                            if (findViewById6 != null) {
                                                                                                                i = R.id.title_left_block;
                                                                                                                TextView textView12 = (TextView) rootView.findViewById(R.id.title_left_block);
                                                                                                                if (textView12 != null) {
                                                                                                                    i = R.id.title_right_block;
                                                                                                                    TextView textView13 = (TextView) rootView.findViewById(R.id.title_right_block);
                                                                                                                    if (textView13 != null) {
                                                                                                                        return new FamiliesFamilyControlBinding((ConstraintLayout) rootView, recyclerView, findViewById, findViewById2, findViewById3, imageView, imageView2, imageView3, editText, frameLayout, findViewById4, findViewById5, textView, textView2, textView3, recyclerView2, nestedScrollView, textView4, textView5, recyclerView3, textView6, textView7, textView8, textView9, textView10, textView11, findViewById6, textView12, textView13);
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
