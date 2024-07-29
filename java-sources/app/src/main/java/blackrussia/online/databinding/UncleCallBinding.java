package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class UncleCallBinding implements ViewBinding {
    public final ImageView hintCall;
    public final ImageView imageView13;
    private final ConstraintLayout rootView;
    public final TextView textView21;

    private UncleCallBinding(ConstraintLayout rootView, ImageView hintCall, ImageView imageView13, TextView textView21) {
        this.rootView = rootView;
        this.hintCall = hintCall;
        this.imageView13 = imageView13;
        this.textView21 = textView21;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static UncleCallBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static UncleCallBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.uncle_call, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static UncleCallBinding bind(View rootView) {
        int i = R.id.hint_call;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.hint_call);
        if (imageView != null) {
            i = R.id.imageView13;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.imageView13);
            if (imageView2 != null) {
                i = R.id.textView21;
                TextView textView = (TextView) rootView.findViewById(R.id.textView21);
                if (textView != null) {
                    return new UncleCallBinding((ConstraintLayout) rootView, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
