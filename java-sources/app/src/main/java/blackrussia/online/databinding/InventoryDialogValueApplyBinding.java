package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class InventoryDialogValueApplyBinding implements ViewBinding {
    public final View dialogValueApplyBgEffect;
    public final View dialogValueApplyBgView;
    public final Button dialogValueApplyButtonApply;
    public final ImageView dialogValueApplyButtonClose;
    public final ImageView dialogValueApplyItemsIcon;
    public final TextView dialogValueApplyMaxValue;
    public final TextView dialogValueApplyMinValue;
    public final SeekBar dialogValueApplySeekbarWithValue;
    public final TextView dialogValueApplyTitleItem;
    private final ConstraintLayout rootView;

    private InventoryDialogValueApplyBinding(ConstraintLayout rootView, View dialogValueApplyBgEffect, View dialogValueApplyBgView, Button dialogValueApplyButtonApply, ImageView dialogValueApplyButtonClose, ImageView dialogValueApplyItemsIcon, TextView dialogValueApplyMaxValue, TextView dialogValueApplyMinValue, SeekBar dialogValueApplySeekbarWithValue, TextView dialogValueApplyTitleItem) {
        this.rootView = rootView;
        this.dialogValueApplyBgEffect = dialogValueApplyBgEffect;
        this.dialogValueApplyBgView = dialogValueApplyBgView;
        this.dialogValueApplyButtonApply = dialogValueApplyButtonApply;
        this.dialogValueApplyButtonClose = dialogValueApplyButtonClose;
        this.dialogValueApplyItemsIcon = dialogValueApplyItemsIcon;
        this.dialogValueApplyMaxValue = dialogValueApplyMaxValue;
        this.dialogValueApplyMinValue = dialogValueApplyMinValue;
        this.dialogValueApplySeekbarWithValue = dialogValueApplySeekbarWithValue;
        this.dialogValueApplyTitleItem = dialogValueApplyTitleItem;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InventoryDialogValueApplyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryDialogValueApplyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_dialog_value_apply, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryDialogValueApplyBinding bind(View rootView) {
        int i = R.id.dialog_value_apply_bg_effect;
        View findViewById = rootView.findViewById(R.id.dialog_value_apply_bg_effect);
        if (findViewById != null) {
            i = R.id.dialog_value_apply_bg_view;
            View findViewById2 = rootView.findViewById(R.id.dialog_value_apply_bg_view);
            if (findViewById2 != null) {
                i = R.id.dialog_value_apply_button_apply;
                Button button = (Button) rootView.findViewById(R.id.dialog_value_apply_button_apply);
                if (button != null) {
                    i = R.id.dialog_value_apply_button_close;
                    ImageView imageView = (ImageView) rootView.findViewById(R.id.dialog_value_apply_button_close);
                    if (imageView != null) {
                        i = R.id.dialog_value_apply_items_icon;
                        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.dialog_value_apply_items_icon);
                        if (imageView2 != null) {
                            i = R.id.dialog_value_apply_max_value;
                            TextView textView = (TextView) rootView.findViewById(R.id.dialog_value_apply_max_value);
                            if (textView != null) {
                                i = R.id.dialog_value_apply_min_value;
                                TextView textView2 = (TextView) rootView.findViewById(R.id.dialog_value_apply_min_value);
                                if (textView2 != null) {
                                    i = R.id.dialog_value_apply_seekbar_with_value;
                                    SeekBar seekBar = (SeekBar) rootView.findViewById(R.id.dialog_value_apply_seekbar_with_value);
                                    if (seekBar != null) {
                                        i = R.id.dialog_value_apply_title_item;
                                        TextView textView3 = (TextView) rootView.findViewById(R.id.dialog_value_apply_title_item);
                                        if (textView3 != null) {
                                            return new InventoryDialogValueApplyBinding((ConstraintLayout) rootView, findViewById, findViewById2, button, imageView, imageView2, textView, textView2, seekBar, textView3);
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
