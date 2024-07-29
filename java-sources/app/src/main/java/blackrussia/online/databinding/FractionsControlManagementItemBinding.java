package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FractionsControlManagementItemBinding implements ViewBinding {
    public final ImageButton imageButtonMinus;
    public final ImageButton imageButtonPlus;
    private final ConstraintLayout rootView;
    public final TextView textViewChangingParameter;
    public final TextView textViewChangingParameterTitle;

    private FractionsControlManagementItemBinding(ConstraintLayout rootView, ImageButton imageButtonMinus, ImageButton imageButtonPlus, TextView textViewChangingParameter, TextView textViewChangingParameterTitle) {
        this.rootView = rootView;
        this.imageButtonMinus = imageButtonMinus;
        this.imageButtonPlus = imageButtonPlus;
        this.textViewChangingParameter = textViewChangingParameter;
        this.textViewChangingParameterTitle = textViewChangingParameterTitle;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsControlManagementItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsControlManagementItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_control_management_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsControlManagementItemBinding bind(View rootView) {
        int i = R.id.image_button_minus;
        ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.image_button_minus);
        if (imageButton != null) {
            i = R.id.image_button_plus;
            ImageButton imageButton2 = (ImageButton) rootView.findViewById(R.id.image_button_plus);
            if (imageButton2 != null) {
                i = R.id.text_view_changing_parameter;
                TextView textView = (TextView) rootView.findViewById(R.id.text_view_changing_parameter);
                if (textView != null) {
                    i = R.id.text_view_changing_parameter_title;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.text_view_changing_parameter_title);
                    if (textView2 != null) {
                        return new FractionsControlManagementItemBinding((ConstraintLayout) rootView, imageButton, imageButton2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
