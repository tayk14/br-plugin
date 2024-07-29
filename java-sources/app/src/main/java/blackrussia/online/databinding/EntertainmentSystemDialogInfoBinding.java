package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class EntertainmentSystemDialogInfoBinding implements ViewBinding {
    public final View dialogInfoBgEffect;
    public final View dialogInfoBgView;
    public final TextView dialogInfoBodyItem;
    public final ImageView dialogInfoButtonClose;
    public final TextView dialogInfoTitleItem;
    private final ConstraintLayout rootView;

    private EntertainmentSystemDialogInfoBinding(ConstraintLayout rootView, View dialogInfoBgEffect, View dialogInfoBgView, TextView dialogInfoBodyItem, ImageView dialogInfoButtonClose, TextView dialogInfoTitleItem) {
        this.rootView = rootView;
        this.dialogInfoBgEffect = dialogInfoBgEffect;
        this.dialogInfoBgView = dialogInfoBgView;
        this.dialogInfoBodyItem = dialogInfoBodyItem;
        this.dialogInfoButtonClose = dialogInfoButtonClose;
        this.dialogInfoTitleItem = dialogInfoTitleItem;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EntertainmentSystemDialogInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EntertainmentSystemDialogInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.entertainment_system_dialog_info, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EntertainmentSystemDialogInfoBinding bind(View rootView) {
        int i = R.id.dialog_info_bg_effect;
        View findViewById = rootView.findViewById(R.id.dialog_info_bg_effect);
        if (findViewById != null) {
            i = R.id.dialog_info_bg_view;
            View findViewById2 = rootView.findViewById(R.id.dialog_info_bg_view);
            if (findViewById2 != null) {
                i = R.id.dialog_info_body_item;
                TextView textView = (TextView) rootView.findViewById(R.id.dialog_info_body_item);
                if (textView != null) {
                    i = R.id.dialog_info_button_close;
                    ImageView imageView = (ImageView) rootView.findViewById(R.id.dialog_info_button_close);
                    if (imageView != null) {
                        i = R.id.dialog_info_title_item;
                        TextView textView2 = (TextView) rootView.findViewById(R.id.dialog_info_title_item);
                        if (textView2 != null) {
                            return new EntertainmentSystemDialogInfoBinding((ConstraintLayout) rootView, findViewById, findViewById2, textView, imageView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
