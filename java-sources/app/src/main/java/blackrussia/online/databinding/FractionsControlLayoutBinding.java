package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.CustomEditTextWithBackPressEvent;

public final class FractionsControlLayoutBinding implements ViewBinding {
    public final View bodyRightBlock;
    public final CustomEditTextWithBackPressEvent editTextSearchPlayer;
    public final FrameLayout frameLayoutRenderSkin;
    public final ImageButton imageButtonSearchPlayer;
    public final ImageButton imageButtonSortBy;
    public final RecyclerView recyclerViewControlFraction;
    public final RecyclerView recyclerViewSortBy;
    public final RecyclerView recyclerViewStaffList;
    private final ConstraintLayout rootView;
    public final TextView textViewFractionStaffTitle;
    public final TextView textViewLevel;
    public final TextView textViewPlayersInformation;
    public final TextView textViewPlayersLevel;
    public final TextView textViewPlayersNickname;
    public final TextView textViewPlayersPhoneNumber;
    public final TextView textViewPlayersRank;
    public final TextView textViewPlayersReprimands;
    public final TextView textViewPosition;
    public final View titleLeftBlock;
    public final View viewDivider;
    public final View viewPlayerInformation;
    public final View viewRenderSkin;
    public final View viewSkinEllipse;

    private FractionsControlLayoutBinding(ConstraintLayout rootView, View bodyRightBlock, CustomEditTextWithBackPressEvent editTextSearchPlayer, FrameLayout frameLayoutRenderSkin, ImageButton imageButtonSearchPlayer, ImageButton imageButtonSortBy, RecyclerView recyclerViewControlFraction, RecyclerView recyclerViewSortBy, RecyclerView recyclerViewStaffList, TextView textViewFractionStaffTitle, TextView textViewLevel, TextView textViewPlayersInformation, TextView textViewPlayersLevel, TextView textViewPlayersNickname, TextView textViewPlayersPhoneNumber, TextView textViewPlayersRank, TextView textViewPlayersReprimands, TextView textViewPosition, View titleLeftBlock, View viewDivider, View viewPlayerInformation, View viewRenderSkin, View viewSkinEllipse) {
        this.rootView = rootView;
        this.bodyRightBlock = bodyRightBlock;
        this.editTextSearchPlayer = editTextSearchPlayer;
        this.frameLayoutRenderSkin = frameLayoutRenderSkin;
        this.imageButtonSearchPlayer = imageButtonSearchPlayer;
        this.imageButtonSortBy = imageButtonSortBy;
        this.recyclerViewControlFraction = recyclerViewControlFraction;
        this.recyclerViewSortBy = recyclerViewSortBy;
        this.recyclerViewStaffList = recyclerViewStaffList;
        this.textViewFractionStaffTitle = textViewFractionStaffTitle;
        this.textViewLevel = textViewLevel;
        this.textViewPlayersInformation = textViewPlayersInformation;
        this.textViewPlayersLevel = textViewPlayersLevel;
        this.textViewPlayersNickname = textViewPlayersNickname;
        this.textViewPlayersPhoneNumber = textViewPlayersPhoneNumber;
        this.textViewPlayersRank = textViewPlayersRank;
        this.textViewPlayersReprimands = textViewPlayersReprimands;
        this.textViewPosition = textViewPosition;
        this.titleLeftBlock = titleLeftBlock;
        this.viewDivider = viewDivider;
        this.viewPlayerInformation = viewPlayerInformation;
        this.viewRenderSkin = viewRenderSkin;
        this.viewSkinEllipse = viewSkinEllipse;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsControlLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsControlLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_control_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsControlLayoutBinding bind(View rootView) {
        int i = R.id.body_right_block;
        View findViewById = rootView.findViewById(R.id.body_right_block);
        if (findViewById != null) {
            i = R.id.edit_text_search_player;
            CustomEditTextWithBackPressEvent customEditTextWithBackPressEvent = (CustomEditTextWithBackPressEvent) rootView.findViewById(R.id.edit_text_search_player);
            if (customEditTextWithBackPressEvent != null) {
                i = R.id.frame_layout_render_skin;
                FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.frame_layout_render_skin);
                if (frameLayout != null) {
                    i = R.id.image_button_search_player;
                    ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.image_button_search_player);
                    if (imageButton != null) {
                        i = R.id.image_button_sort_by;
                        ImageButton imageButton2 = (ImageButton) rootView.findViewById(R.id.image_button_sort_by);
                        if (imageButton2 != null) {
                            i = R.id.recycler_view_control_fraction;
                            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_control_fraction);
                            if (recyclerView != null) {
                                i = R.id.recycler_view_sort_by;
                                RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.recycler_view_sort_by);
                                if (recyclerView2 != null) {
                                    i = R.id.recycler_view_staff_list;
                                    RecyclerView recyclerView3 = (RecyclerView) rootView.findViewById(R.id.recycler_view_staff_list);
                                    if (recyclerView3 != null) {
                                        i = R.id.text_view_fraction_staff_title;
                                        TextView textView = (TextView) rootView.findViewById(R.id.text_view_fraction_staff_title);
                                        if (textView != null) {
                                            i = R.id.text_view_level;
                                            TextView textView2 = (TextView) rootView.findViewById(R.id.text_view_level);
                                            if (textView2 != null) {
                                                i = R.id.text_view_players_information;
                                                TextView textView3 = (TextView) rootView.findViewById(R.id.text_view_players_information);
                                                if (textView3 != null) {
                                                    i = R.id.text_view_players_level;
                                                    TextView textView4 = (TextView) rootView.findViewById(R.id.text_view_players_level);
                                                    if (textView4 != null) {
                                                        i = R.id.text_view_players_nickname;
                                                        TextView textView5 = (TextView) rootView.findViewById(R.id.text_view_players_nickname);
                                                        if (textView5 != null) {
                                                            i = R.id.text_view_players_phone_number;
                                                            TextView textView6 = (TextView) rootView.findViewById(R.id.text_view_players_phone_number);
                                                            if (textView6 != null) {
                                                                i = R.id.text_view_players_rank;
                                                                TextView textView7 = (TextView) rootView.findViewById(R.id.text_view_players_rank);
                                                                if (textView7 != null) {
                                                                    i = R.id.text_view_players_reprimands;
                                                                    TextView textView8 = (TextView) rootView.findViewById(R.id.text_view_players_reprimands);
                                                                    if (textView8 != null) {
                                                                        i = R.id.text_view_position;
                                                                        TextView textView9 = (TextView) rootView.findViewById(R.id.text_view_position);
                                                                        if (textView9 != null) {
                                                                            i = R.id.title_left_block;
                                                                            View findViewById2 = rootView.findViewById(R.id.title_left_block);
                                                                            if (findViewById2 != null) {
                                                                                i = R.id.view_divider;
                                                                                View findViewById3 = rootView.findViewById(R.id.view_divider);
                                                                                if (findViewById3 != null) {
                                                                                    i = R.id.view_player_information;
                                                                                    View findViewById4 = rootView.findViewById(R.id.view_player_information);
                                                                                    if (findViewById4 != null) {
                                                                                        i = R.id.view_render_skin;
                                                                                        View findViewById5 = rootView.findViewById(R.id.view_render_skin);
                                                                                        if (findViewById5 != null) {
                                                                                            i = R.id.view_skin_ellipse;
                                                                                            View findViewById6 = rootView.findViewById(R.id.view_skin_ellipse);
                                                                                            if (findViewById6 != null) {
                                                                                                return new FractionsControlLayoutBinding((ConstraintLayout) rootView, findViewById, customEditTextWithBackPressEvent, frameLayout, imageButton, imageButton2, recyclerView, recyclerView2, recyclerView3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, findViewById2, findViewById3, findViewById4, findViewById5, findViewById6);
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
