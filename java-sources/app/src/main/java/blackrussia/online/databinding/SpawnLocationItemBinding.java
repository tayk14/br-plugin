package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class SpawnLocationItemBinding implements ViewBinding {
    public final ImageView imageViewPlace;
    public final ImageView ivLock;
    private final CardView rootView;
    public final TextView textViewPlaceName;
    public final View viewSelection;
    public final View viewSelectionUnavailable;

    private SpawnLocationItemBinding(CardView rootView, ImageView imageViewPlace, ImageView ivLock, TextView textViewPlaceName, View viewSelection, View viewSelectionUnavailable) {
        this.rootView = rootView;
        this.imageViewPlace = imageViewPlace;
        this.ivLock = ivLock;
        this.textViewPlaceName = textViewPlaceName;
        this.viewSelection = viewSelection;
        this.viewSelectionUnavailable = viewSelectionUnavailable;
    }

    @Override
    public CardView getRoot() {
        return this.rootView;
    }

    public static SpawnLocationItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SpawnLocationItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.spawn_location_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SpawnLocationItemBinding bind(View rootView) {
        int i = R.id.image_view_place;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.image_view_place);
        if (imageView != null) {
            i = R.id.iv_lock;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.iv_lock);
            if (imageView2 != null) {
                i = R.id.text_view_place_name;
                TextView textView = (TextView) rootView.findViewById(R.id.text_view_place_name);
                if (textView != null) {
                    i = R.id.view_selection;
                    View findViewById = rootView.findViewById(R.id.view_selection);
                    if (findViewById != null) {
                        i = R.id.view_selection_unavailable;
                        View findViewById2 = rootView.findViewById(R.id.view_selection_unavailable);
                        if (findViewById2 != null) {
                            return new SpawnLocationItemBinding((CardView) rootView, imageView, imageView2, textView, findViewById, findViewById2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
