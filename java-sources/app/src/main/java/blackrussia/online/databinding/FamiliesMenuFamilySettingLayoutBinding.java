package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesMenuFamilySettingLayoutBinding implements ViewBinding {
    public final View bodyRightBlock;
    public final ImageView buttonApplyRename;
    public final ImageView buttonBackToMenu;
    public final ImageView editRanksName;
    public final EditText editTextRankName;
    public final View leftTitleDiver;
    public final RecyclerView menuList;
    public final RecyclerView ranksOrChatsColorSetting;
    private final ConstraintLayout rootView;
    public final View tablesTitleLeftBlock;
    public final TextView titleLeftBlock;
    public final TextView titleRank;
    public final TextView titleRightBlock;

    private FamiliesMenuFamilySettingLayoutBinding(ConstraintLayout rootView, View bodyRightBlock, ImageView buttonApplyRename, ImageView buttonBackToMenu, ImageView editRanksName, EditText editTextRankName, View leftTitleDiver, RecyclerView menuList, RecyclerView ranksOrChatsColorSetting, View tablesTitleLeftBlock, TextView titleLeftBlock, TextView titleRank, TextView titleRightBlock) {
        this.rootView = rootView;
        this.bodyRightBlock = bodyRightBlock;
        this.buttonApplyRename = buttonApplyRename;
        this.buttonBackToMenu = buttonBackToMenu;
        this.editRanksName = editRanksName;
        this.editTextRankName = editTextRankName;
        this.leftTitleDiver = leftTitleDiver;
        this.menuList = menuList;
        this.ranksOrChatsColorSetting = ranksOrChatsColorSetting;
        this.tablesTitleLeftBlock = tablesTitleLeftBlock;
        this.titleLeftBlock = titleLeftBlock;
        this.titleRank = titleRank;
        this.titleRightBlock = titleRightBlock;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesMenuFamilySettingLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesMenuFamilySettingLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_menu_family_setting_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesMenuFamilySettingLayoutBinding bind(View rootView) {
        int i = R.id.body_right_block;
        View findViewById = rootView.findViewById(R.id.body_right_block);
        if (findViewById != null) {
            i = R.id.button_apply_rename;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.button_apply_rename);
            if (imageView != null) {
                i = R.id.button_back_to_menu;
                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.button_back_to_menu);
                if (imageView2 != null) {
                    i = R.id.edit_ranks_name;
                    ImageView imageView3 = (ImageView) rootView.findViewById(R.id.edit_ranks_name);
                    if (imageView3 != null) {
                        i = R.id.edit_text_rank_name;
                        EditText editText = (EditText) rootView.findViewById(R.id.edit_text_rank_name);
                        if (editText != null) {
                            i = R.id.left_title_diver;
                            View findViewById2 = rootView.findViewById(R.id.left_title_diver);
                            if (findViewById2 != null) {
                                i = R.id.menu_list;
                                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.menu_list);
                                if (recyclerView != null) {
                                    i = R.id.ranks_or_chats_color_setting;
                                    RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.ranks_or_chats_color_setting);
                                    if (recyclerView2 != null) {
                                        i = R.id.tables_title_left_block;
                                        View findViewById3 = rootView.findViewById(R.id.tables_title_left_block);
                                        if (findViewById3 != null) {
                                            i = R.id.title_left_block;
                                            TextView textView = (TextView) rootView.findViewById(R.id.title_left_block);
                                            if (textView != null) {
                                                i = R.id.title_rank;
                                                TextView textView2 = (TextView) rootView.findViewById(R.id.title_rank);
                                                if (textView2 != null) {
                                                    i = R.id.title_right_block;
                                                    TextView textView3 = (TextView) rootView.findViewById(R.id.title_right_block);
                                                    if (textView3 != null) {
                                                        return new FamiliesMenuFamilySettingLayoutBinding((ConstraintLayout) rootView, findViewById, imageView, imageView2, imageView3, editText, findViewById2, recyclerView, recyclerView2, findViewById3, textView, textView2, textView3);
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
