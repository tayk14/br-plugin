package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FractionMainMenuLayoutBinding implements ViewBinding {
    public final CardView cardViewFractionTasks;
    public final ImageButton imageButtonFractionsTasks;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView textViewFractionTasks;
    public final TextView textViewProgressInOrganisation;

    private FractionMainMenuLayoutBinding(ConstraintLayout rootView, CardView cardViewFractionTasks, ImageButton imageButtonFractionsTasks, RecyclerView recyclerView, TextView textViewFractionTasks, TextView textViewProgressInOrganisation) {
        this.rootView = rootView;
        this.cardViewFractionTasks = cardViewFractionTasks;
        this.imageButtonFractionsTasks = imageButtonFractionsTasks;
        this.recyclerView = recyclerView;
        this.textViewFractionTasks = textViewFractionTasks;
        this.textViewProgressInOrganisation = textViewProgressInOrganisation;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionMainMenuLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionMainMenuLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fraction_main_menu_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionMainMenuLayoutBinding bind(View rootView) {
        int i = R.id.card_view_fraction_tasks;
        CardView cardView = (CardView) rootView.findViewById(R.id.card_view_fraction_tasks);
        if (cardView != null) {
            i = R.id.image_button_fractions_tasks;
            ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.image_button_fractions_tasks);
            if (imageButton != null) {
                i = R.id.recyclerView;
                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
                if (recyclerView != null) {
                    i = R.id.text_view_fraction_tasks;
                    TextView textView = (TextView) rootView.findViewById(R.id.text_view_fraction_tasks);
                    if (textView != null) {
                        i = R.id.text_view_progress_in_organisation;
                        TextView textView2 = (TextView) rootView.findViewById(R.id.text_view_progress_in_organisation);
                        if (textView2 != null) {
                            return new FractionMainMenuLayoutBinding((ConstraintLayout) rootView, cardView, imageButton, recyclerView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
