package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class RegFingerprintBinding implements ViewBinding {
    public final ImageView autoImg;
    public final Switch autoSwitch;
    public final LinearLayout autoText;
    public final LinearLayout back;
    public final Button buttSkip;
    public final ImageView fingerImg;
    private final FrameLayout rootView;

    private RegFingerprintBinding(FrameLayout rootView, ImageView autoImg, Switch autoSwitch, LinearLayout autoText, LinearLayout back, Button buttSkip, ImageView fingerImg) {
        this.rootView = rootView;
        this.autoImg = autoImg;
        this.autoSwitch = autoSwitch;
        this.autoText = autoText;
        this.back = back;
        this.buttSkip = buttSkip;
        this.fingerImg = fingerImg;
    }

    @Override
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static RegFingerprintBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RegFingerprintBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reg_fingerprint, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegFingerprintBinding bind(View rootView) {
        int i = R.id.auto_img;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.auto_img);
        if (imageView != null) {
            i = R.id.auto_switch;
            Switch r5 = (Switch) rootView.findViewById(R.id.auto_switch);
            if (r5 != null) {
                i = R.id.auto_text;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.auto_text);
                if (linearLayout != null) {
                    i = R.id.back;
                    LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.back);
                    if (linearLayout2 != null) {
                        i = R.id.butt_skip;
                        Button button = (Button) rootView.findViewById(R.id.butt_skip);
                        if (button != null) {
                            i = R.id.finger_img;
                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.finger_img);
                            if (imageView2 != null) {
                                return new RegFingerprintBinding((FrameLayout) rootView, imageView, r5, linearLayout, linearLayout2, button, imageView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
