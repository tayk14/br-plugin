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

public final class RegPersonBinding implements ViewBinding {
    public final ImageView arrowLeft;
    public final ImageView arrowRight;
    public final TextView hintPerson;
    public final ImageView perosnImg;
    public final ImageView personCloseH;
    public final Button playButt;
    private final ConstraintLayout rootView;

    private RegPersonBinding(ConstraintLayout rootView, ImageView arrowLeft, ImageView arrowRight, TextView hintPerson, ImageView perosnImg, ImageView personCloseH, Button playButt) {
        this.rootView = rootView;
        this.arrowLeft = arrowLeft;
        this.arrowRight = arrowRight;
        this.hintPerson = hintPerson;
        this.perosnImg = perosnImg;
        this.personCloseH = personCloseH;
        this.playButt = playButt;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RegPersonBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RegPersonBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reg_person, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegPersonBinding bind(View rootView) {
        int i = R.id.arrow_left;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.arrow_left);
        if (imageView != null) {
            i = R.id.arrow_right;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.arrow_right);
            if (imageView2 != null) {
                i = R.id.hint_person;
                TextView textView = (TextView) rootView.findViewById(R.id.hint_person);
                if (textView != null) {
                    i = R.id.perosn_img;
                    ImageView imageView3 = (ImageView) rootView.findViewById(R.id.perosn_img);
                    if (imageView3 != null) {
                        i = R.id.person_close_h;
                        ImageView imageView4 = (ImageView) rootView.findViewById(R.id.person_close_h);
                        if (imageView4 != null) {
                            i = R.id.play_butt;
                            Button button = (Button) rootView.findViewById(R.id.play_butt);
                            if (button != null) {
                                return new RegPersonBinding((ConstraintLayout) rootView, imageView, imageView2, textView, imageView3, imageView4, button);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
