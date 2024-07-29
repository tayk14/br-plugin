package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class InventoryDialogApplyDeletItemBinding implements ViewBinding {
    public final View dialogValueApplyBgEffect;
    public final View dialogValueApplyBgView;
    public final Button dialogValueApplyButtonApply;
    public final Button dialogValueApplyButtonCancel;
    public final ImageView dialogValueApplyButtonClose;
    public final TextView dialogValueApplyTitleItem;
    private final ConstraintLayout rootView;

    private InventoryDialogApplyDeletItemBinding(ConstraintLayout rootView, View dialogValueApplyBgEffect, View dialogValueApplyBgView, Button dialogValueApplyButtonApply, Button dialogValueApplyButtonCancel, ImageView dialogValueApplyButtonClose, TextView dialogValueApplyTitleItem) {
        this.rootView = rootView;
        this.dialogValueApplyBgEffect = dialogValueApplyBgEffect;
        this.dialogValueApplyBgView = dialogValueApplyBgView;
        this.dialogValueApplyButtonApply = dialogValueApplyButtonApply;
        this.dialogValueApplyButtonCancel = dialogValueApplyButtonCancel;
        this.dialogValueApplyButtonClose = dialogValueApplyButtonClose;
        this.dialogValueApplyTitleItem = dialogValueApplyTitleItem;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InventoryDialogApplyDeletItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryDialogApplyDeletItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_dialog_apply_delet_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryDialogApplyDeletItemBinding bind(View rootView) {
        int i = R.id.dialog_value_apply_bg_effect;
        View findViewById = rootView.findViewById(R.id.dialog_value_apply_bg_effect);
        if (findViewById != null) {
            i = R.id.dialog_value_apply_bg_view;
            View findViewById2 = rootView.findViewById(R.id.dialog_value_apply_bg_view);
            if (findViewById2 != null) {
                i = R.id.dialog_value_apply_button_apply;
                Button button = (Button) rootView.findViewById(R.id.dialog_value_apply_button_apply);
                if (button != null) {
                    i = R.id.dialog_value_apply_button_cancel;
                    Button button2 = (Button) rootView.findViewById(R.id.dialog_value_apply_button_cancel);
                    if (button2 != null) {
                        i = R.id.dialog_value_apply_button_close;
                        ImageView imageView = (ImageView) rootView.findViewById(R.id.dialog_value_apply_button_close);
                        if (imageView != null) {
                            i = R.id.dialog_value_apply_title_item;
                            TextView textView = (TextView) rootView.findViewById(R.id.dialog_value_apply_title_item);
                            if (textView != null) {
                                return new InventoryDialogApplyDeletItemBinding((ConstraintLayout) rootView, findViewById, findViewById2, button, button2, imageView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
