package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FractionsQuestsItemBinding implements ViewBinding {
    public final ImageView ivAward1;
    public final ImageView ivAward2;
    public final TextView questTitle;
    private final ConstraintLayout rootView;

    private FractionsQuestsItemBinding(ConstraintLayout rootView, ImageView ivAward1, ImageView ivAward2, TextView questTitle) {
        this.rootView = rootView;
        this.ivAward1 = ivAward1;
        this.ivAward2 = ivAward2;
        this.questTitle = questTitle;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsQuestsItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsQuestsItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_quests_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsQuestsItemBinding bind(View rootView) {
        int i = R.id.iv_award_1;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_award_1);
        if (imageView != null) {
            i = R.id.iv_award_2;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.iv_award_2);
            if (imageView2 != null) {
                i = R.id.quest_title;
                TextView textView = (TextView) rootView.findViewById(R.id.quest_title);
                if (textView != null) {
                    return new FractionsQuestsItemBinding((ConstraintLayout) rootView, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
