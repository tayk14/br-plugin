package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesMenuRankOrColorItemBinding implements ViewBinding {
    public final View color;
    public final View colorsBorder;
    public final ImageView ifCurrentColor;
    public final SwitchCompat rankAccessSwitch;
    public final ImageView renameRank;
    private final ConstraintLayout rootView;
    public final TextView valueMenu1;
    public final TextView valueMenu2;

    private FamiliesMenuRankOrColorItemBinding(ConstraintLayout rootView, View color, View colorsBorder, ImageView ifCurrentColor, SwitchCompat rankAccessSwitch, ImageView renameRank, TextView valueMenu1, TextView valueMenu2) {
        this.rootView = rootView;
        this.color = color;
        this.colorsBorder = colorsBorder;
        this.ifCurrentColor = ifCurrentColor;
        this.rankAccessSwitch = rankAccessSwitch;
        this.renameRank = renameRank;
        this.valueMenu1 = valueMenu1;
        this.valueMenu2 = valueMenu2;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesMenuRankOrColorItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesMenuRankOrColorItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_menu_rank_or_color_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesMenuRankOrColorItemBinding bind(View rootView) {
        int i = R.id.color;
        View findViewById = rootView.findViewById(R.id.color);
        if (findViewById != null) {
            i = R.id.colors_border;
            View findViewById2 = rootView.findViewById(R.id.colors_border);
            if (findViewById2 != null) {
                i = R.id.if_current_color;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.if_current_color);
                if (imageView != null) {
                    i = R.id.rank_access_switch;
                    SwitchCompat switchCompat = (SwitchCompat) rootView.findViewById(R.id.rank_access_switch);
                    if (switchCompat != null) {
                        i = R.id.rename_rank;
                        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.rename_rank);
                        if (imageView2 != null) {
                            i = R.id.value_menu_1;
                            TextView textView = (TextView) rootView.findViewById(R.id.value_menu_1);
                            if (textView != null) {
                                i = R.id.value_menu_2;
                                TextView textView2 = (TextView) rootView.findViewById(R.id.value_menu_2);
                                if (textView2 != null) {
                                    return new FamiliesMenuRankOrColorItemBinding((ConstraintLayout) rootView, findViewById, findViewById2, imageView, switchCompat, imageView2, textView, textView2);
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
