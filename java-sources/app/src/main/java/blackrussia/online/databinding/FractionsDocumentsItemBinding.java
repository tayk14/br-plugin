package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FractionsDocumentsItemBinding implements ViewBinding {
    public final ImageView imageViewChecked;
    public final TextView questTitle;
    private final ConstraintLayout rootView;

    private FractionsDocumentsItemBinding(ConstraintLayout rootView, ImageView imageViewChecked, TextView questTitle) {
        this.rootView = rootView;
        this.imageViewChecked = imageViewChecked;
        this.questTitle = questTitle;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsDocumentsItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsDocumentsItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_documents_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsDocumentsItemBinding bind(View rootView) {
        int i = R.id.image_view_checked;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.image_view_checked);
        if (imageView != null) {
            i = R.id.quest_title;
            TextView textView = (TextView) rootView.findViewById(R.id.quest_title);
            if (textView != null) {
                return new FractionsDocumentsItemBinding((ConstraintLayout) rootView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
