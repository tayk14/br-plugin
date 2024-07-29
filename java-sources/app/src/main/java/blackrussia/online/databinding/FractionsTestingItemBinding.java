package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FractionsTestingItemBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView textViewAnswer;

    private FractionsTestingItemBinding(ConstraintLayout rootView, TextView textViewAnswer) {
        this.rootView = rootView;
        this.textViewAnswer = textViewAnswer;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsTestingItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsTestingItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_testing_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsTestingItemBinding bind(View rootView) {
        TextView textView = (TextView) rootView.findViewById(R.id.text_view_answer);
        if (textView != null) {
            return new FractionsTestingItemBinding((ConstraintLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.text_view_answer)));
    }
}
