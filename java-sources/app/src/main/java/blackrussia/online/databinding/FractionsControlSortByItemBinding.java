package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FractionsControlSortByItemBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView textViewTitle;

    private FractionsControlSortByItemBinding(FrameLayout rootView, TextView textViewTitle) {
        this.rootView = rootView;
        this.textViewTitle = textViewTitle;
    }

    @Override
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FractionsControlSortByItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsControlSortByItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_control_sort_by_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsControlSortByItemBinding bind(View rootView) {
        TextView textView = (TextView) rootView.findViewById(R.id.text_view_title);
        if (textView != null) {
            return new FractionsControlSortByItemBinding((FrameLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.text_view_title)));
    }
}
