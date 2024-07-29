package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class RegScannerBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView textView18;

    private RegScannerBinding(ConstraintLayout rootView, TextView textView18) {
        this.rootView = rootView;
        this.textView18 = textView18;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RegScannerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RegScannerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reg_scanner, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegScannerBinding bind(View rootView) {
        TextView textView = (TextView) rootView.findViewById(R.id.textView18);
        if (textView != null) {
            return new RegScannerBinding((ConstraintLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.textView18)));
    }
}
