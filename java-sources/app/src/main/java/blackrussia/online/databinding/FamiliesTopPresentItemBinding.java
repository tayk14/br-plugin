package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesTopPresentItemBinding implements ViewBinding {
    public final TextView presentTitle;
    public final TextView presentValue;
    private final LinearLayout rootView;

    private FamiliesTopPresentItemBinding(LinearLayout rootView, TextView presentTitle, TextView presentValue) {
        this.rootView = rootView;
        this.presentTitle = presentTitle;
        this.presentValue = presentValue;
    }

    @Override
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesTopPresentItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesTopPresentItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_top_present_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesTopPresentItemBinding bind(View rootView) {
        int i = R.id.present_title;
        TextView textView = (TextView) rootView.findViewById(R.id.present_title);
        if (textView != null) {
            i = R.id.present_value;
            TextView textView2 = (TextView) rootView.findViewById(R.id.present_value);
            if (textView2 != null) {
                return new FamiliesTopPresentItemBinding((LinearLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
