package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class HintBottomBinding implements ViewBinding {
    public final TextView headerHint;
    private final RelativeLayout rootView;
    public final TextView textHint;

    private HintBottomBinding(RelativeLayout rootView, TextView headerHint, TextView textHint) {
        this.rootView = rootView;
        this.headerHint = headerHint;
        this.textHint = textHint;
    }

    @Override
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static HintBottomBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HintBottomBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hint_bottom, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HintBottomBinding bind(View rootView) {
        int i = R.id.header_hint;
        TextView textView = (TextView) rootView.findViewById(R.id.header_hint);
        if (textView != null) {
            i = R.id.text_hint;
            TextView textView2 = (TextView) rootView.findViewById(R.id.text_hint);
            if (textView2 != null) {
                return new HintBottomBinding((RelativeLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
