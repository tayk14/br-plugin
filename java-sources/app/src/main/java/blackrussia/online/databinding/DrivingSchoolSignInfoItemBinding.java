package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class DrivingSchoolSignInfoItemBinding implements ViewBinding {
    public final View blockWithLeftSign;
    public final View blockWithRightSign;
    public final View dividerHorizontalUnderline;
    public final ImageView iconSingLeft;
    public final ImageView iconSingRight;
    private final ConstraintLayout rootView;
    public final TextView textSignLeft;
    public final TextView textSignRight;
    public final TextView titleSignLeft;
    public final TextView titleSignRight;

    private DrivingSchoolSignInfoItemBinding(ConstraintLayout rootView, View blockWithLeftSign, View blockWithRightSign, View dividerHorizontalUnderline, ImageView iconSingLeft, ImageView iconSingRight, TextView textSignLeft, TextView textSignRight, TextView titleSignLeft, TextView titleSignRight) {
        this.rootView = rootView;
        this.blockWithLeftSign = blockWithLeftSign;
        this.blockWithRightSign = blockWithRightSign;
        this.dividerHorizontalUnderline = dividerHorizontalUnderline;
        this.iconSingLeft = iconSingLeft;
        this.iconSingRight = iconSingRight;
        this.textSignLeft = textSignLeft;
        this.textSignRight = textSignRight;
        this.titleSignLeft = titleSignLeft;
        this.titleSignRight = titleSignRight;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DrivingSchoolSignInfoItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DrivingSchoolSignInfoItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.driving_school_sign_info_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DrivingSchoolSignInfoItemBinding bind(View rootView) {
        int i = R.id.block_with_left_sign;
        View findViewById = rootView.findViewById(R.id.block_with_left_sign);
        if (findViewById != null) {
            i = R.id.block_with_right_sign;
            View findViewById2 = rootView.findViewById(R.id.block_with_right_sign);
            if (findViewById2 != null) {
                i = R.id.divider_horizontal_underline;
                View findViewById3 = rootView.findViewById(R.id.divider_horizontal_underline);
                if (findViewById3 != null) {
                    i = R.id.icon_sing_left;
                    ImageView imageView = (ImageView) rootView.findViewById(R.id.icon_sing_left);
                    if (imageView != null) {
                        i = R.id.icon_sing_right;
                        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.icon_sing_right);
                        if (imageView2 != null) {
                            i = R.id.text_sign_left;
                            TextView textView = (TextView) rootView.findViewById(R.id.text_sign_left);
                            if (textView != null) {
                                i = R.id.text_sign_right;
                                TextView textView2 = (TextView) rootView.findViewById(R.id.text_sign_right);
                                if (textView2 != null) {
                                    i = R.id.title_sign_left;
                                    TextView textView3 = (TextView) rootView.findViewById(R.id.title_sign_left);
                                    if (textView3 != null) {
                                        i = R.id.title_sign_right;
                                        TextView textView4 = (TextView) rootView.findViewById(R.id.title_sign_right);
                                        if (textView4 != null) {
                                            return new DrivingSchoolSignInfoItemBinding((ConstraintLayout) rootView, findViewById, findViewById2, findViewById3, imageView, imageView2, textView, textView2, textView3, textView4);
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
