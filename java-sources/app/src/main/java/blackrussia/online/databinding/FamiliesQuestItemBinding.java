package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesQuestItemBinding implements ViewBinding {
    public final View present1Bg;
    public final ImageView present1Item;
    public final View present2Bg;
    public final ImageView present2Item;
    public final View present3Bg;
    public final ImageView present3Item;
    public final TextView questionsTitle;
    private final ConstraintLayout rootView;

    private FamiliesQuestItemBinding(ConstraintLayout rootView, View present1Bg, ImageView present1Item, View present2Bg, ImageView present2Item, View present3Bg, ImageView present3Item, TextView questionsTitle) {
        this.rootView = rootView;
        this.present1Bg = present1Bg;
        this.present1Item = present1Item;
        this.present2Bg = present2Bg;
        this.present2Item = present2Item;
        this.present3Bg = present3Bg;
        this.present3Item = present3Item;
        this.questionsTitle = questionsTitle;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesQuestItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesQuestItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_quest_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesQuestItemBinding bind(View rootView) {
        int i = R.id.present_1_bg;
        View findViewById = rootView.findViewById(R.id.present_1_bg);
        if (findViewById != null) {
            i = R.id.present_1_item;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.present_1_item);
            if (imageView != null) {
                i = R.id.present_2_bg;
                View findViewById2 = rootView.findViewById(R.id.present_2_bg);
                if (findViewById2 != null) {
                    i = R.id.present_2_item;
                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.present_2_item);
                    if (imageView2 != null) {
                        i = R.id.present_3_bg;
                        View findViewById3 = rootView.findViewById(R.id.present_3_bg);
                        if (findViewById3 != null) {
                            i = R.id.present_3_item;
                            ImageView imageView3 = (ImageView) rootView.findViewById(R.id.present_3_item);
                            if (imageView3 != null) {
                                i = R.id.questions_title;
                                TextView textView = (TextView) rootView.findViewById(R.id.questions_title);
                                if (textView != null) {
                                    return new FamiliesQuestItemBinding((ConstraintLayout) rootView, findViewById, imageView, findViewById2, imageView2, findViewById3, imageView3, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
