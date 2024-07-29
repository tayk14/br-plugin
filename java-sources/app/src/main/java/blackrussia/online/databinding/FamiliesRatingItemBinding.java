package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesRatingItemBinding implements ViewBinding {
    public final ImageView familyIcon;
    public final TextView familyNick;
    public final TextView familyRep;
    public final ImageView leftIcon;
    public final ImageView rightIcon;
    private final ConstraintLayout rootView;
    public final View topBg;
    public final TextView topPosition;
    public final TextView valueCaptured;

    private FamiliesRatingItemBinding(ConstraintLayout rootView, ImageView familyIcon, TextView familyNick, TextView familyRep, ImageView leftIcon, ImageView rightIcon, View topBg, TextView topPosition, TextView valueCaptured) {
        this.rootView = rootView;
        this.familyIcon = familyIcon;
        this.familyNick = familyNick;
        this.familyRep = familyRep;
        this.leftIcon = leftIcon;
        this.rightIcon = rightIcon;
        this.topBg = topBg;
        this.topPosition = topPosition;
        this.valueCaptured = valueCaptured;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesRatingItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesRatingItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_rating_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesRatingItemBinding bind(View rootView) {
        int i = R.id.family_icon;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.family_icon);
        if (imageView != null) {
            i = R.id.family_nick;
            TextView textView = (TextView) rootView.findViewById(R.id.family_nick);
            if (textView != null) {
                i = R.id.family_rep;
                TextView textView2 = (TextView) rootView.findViewById(R.id.family_rep);
                if (textView2 != null) {
                    i = R.id.left_icon;
                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.left_icon);
                    if (imageView2 != null) {
                        i = R.id.right_icon;
                        ImageView imageView3 = (ImageView) rootView.findViewById(R.id.right_icon);
                        if (imageView3 != null) {
                            i = R.id.top_bg;
                            View findViewById = rootView.findViewById(R.id.top_bg);
                            if (findViewById != null) {
                                i = R.id.top_position;
                                TextView textView3 = (TextView) rootView.findViewById(R.id.top_position);
                                if (textView3 != null) {
                                    i = R.id.value_captured;
                                    TextView textView4 = (TextView) rootView.findViewById(R.id.value_captured);
                                    if (textView4 != null) {
                                        return new FamiliesRatingItemBinding((ConstraintLayout) rootView, imageView, textView, textView2, imageView2, imageView3, findViewById, textView3, textView4);
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
