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

public final class RegistrationSexBinding implements ViewBinding {
    public final Button butt;
    public final ImageView femaleButt;
    public final ImageView logo;
    public final ImageView maleButt;
    private final ConstraintLayout rootView;
    public final TextView textView24;

    private RegistrationSexBinding(ConstraintLayout rootView, Button butt, ImageView femaleButt, ImageView logo, ImageView maleButt, TextView textView24) {
        this.rootView = rootView;
        this.butt = butt;
        this.femaleButt = femaleButt;
        this.logo = logo;
        this.maleButt = maleButt;
        this.textView24 = textView24;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RegistrationSexBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RegistrationSexBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.registration_sex, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegistrationSexBinding bind(View rootView) {
        int i = R.id.butt;
        Button button = (Button) rootView.findViewById(R.id.butt);
        if (button != null) {
            i = R.id.female_butt;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.female_butt);
            if (imageView != null) {
                i = R.id.logo;
                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.logo);
                if (imageView2 != null) {
                    i = R.id.male_butt;
                    ImageView imageView3 = (ImageView) rootView.findViewById(R.id.male_butt);
                    if (imageView3 != null) {
                        i = R.id.textView24;
                        TextView textView = (TextView) rootView.findViewById(R.id.textView24);
                        if (textView != null) {
                            return new RegistrationSexBinding((ConstraintLayout) rootView, button, imageView, imageView2, imageView3, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
