package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.CustomEditTextWithBackPressEvent;

public final class RegLoginBinding implements ViewBinding {
    public final ImageView autoImg;
    public final Switch autoSwitch;
    public final LinearLayout autoText;
    public final LinearLayout backBut;
    public final LinearLayout fingerprintBut;
    public final CustomEditTextWithBackPressEvent passwordEnter;
    public final TextView passwordText;
    public final Button playBut;
    private final LinearLayout rootView;

    private RegLoginBinding(LinearLayout rootView, ImageView autoImg, Switch autoSwitch, LinearLayout autoText, LinearLayout backBut, LinearLayout fingerprintBut, CustomEditTextWithBackPressEvent passwordEnter, TextView passwordText, Button playBut) {
        this.rootView = rootView;
        this.autoImg = autoImg;
        this.autoSwitch = autoSwitch;
        this.autoText = autoText;
        this.backBut = backBut;
        this.fingerprintBut = fingerprintBut;
        this.passwordEnter = passwordEnter;
        this.passwordText = passwordText;
        this.playBut = playBut;
    }

    @Override
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RegLoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RegLoginBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reg_login, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegLoginBinding bind(View rootView) {
        int i = R.id.auto_img;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.auto_img);
        if (imageView != null) {
            i = R.id.auto_switch;
            Switch r5 = (Switch) rootView.findViewById(R.id.auto_switch);
            if (r5 != null) {
                i = R.id.auto_text;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.auto_text);
                if (linearLayout != null) {
                    i = R.id.back_but;
                    LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.back_but);
                    if (linearLayout2 != null) {
                        i = R.id.fingerprint_but;
                        LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.fingerprint_but);
                        if (linearLayout3 != null) {
                            i = R.id.password_enter;
                            CustomEditTextWithBackPressEvent customEditTextWithBackPressEvent = (CustomEditTextWithBackPressEvent) rootView.findViewById(R.id.password_enter);
                            if (customEditTextWithBackPressEvent != null) {
                                i = R.id.password_text;
                                TextView textView = (TextView) rootView.findViewById(R.id.password_text);
                                if (textView != null) {
                                    i = R.id.play_but;
                                    Button button = (Button) rootView.findViewById(R.id.play_but);
                                    if (button != null) {
                                        return new RegLoginBinding((LinearLayout) rootView, imageView, r5, linearLayout, linearLayout2, linearLayout3, customEditTextWithBackPressEvent, textView, button);
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
