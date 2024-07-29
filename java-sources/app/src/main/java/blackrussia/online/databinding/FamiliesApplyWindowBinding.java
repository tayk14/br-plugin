package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesApplyWindowBinding implements ViewBinding {
    public final Button buttonApply;
    public final Button buttonCancel;
    public final View dialogApplyBgView;
    public final TextView dialogApplyBodyItem;
    private final ConstraintLayout rootView;

    private FamiliesApplyWindowBinding(ConstraintLayout rootView, Button buttonApply, Button buttonCancel, View dialogApplyBgView, TextView dialogApplyBodyItem) {
        this.rootView = rootView;
        this.buttonApply = buttonApply;
        this.buttonCancel = buttonCancel;
        this.dialogApplyBgView = dialogApplyBgView;
        this.dialogApplyBodyItem = dialogApplyBodyItem;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesApplyWindowBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesApplyWindowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_apply_window, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesApplyWindowBinding bind(View rootView) {
        int i = R.id.button_apply;
        Button button = (Button) rootView.findViewById(R.id.button_apply);
        if (button != null) {
            i = R.id.button_cancel;
            Button button2 = (Button) rootView.findViewById(R.id.button_cancel);
            if (button2 != null) {
                i = R.id.dialog_apply_bg_view;
                View findViewById = rootView.findViewById(R.id.dialog_apply_bg_view);
                if (findViewById != null) {
                    i = R.id.dialog_apply_body_item;
                    TextView textView = (TextView) rootView.findViewById(R.id.dialog_apply_body_item);
                    if (textView != null) {
                        return new FamiliesApplyWindowBinding((ConstraintLayout) rootView, button, button2, findViewById, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
