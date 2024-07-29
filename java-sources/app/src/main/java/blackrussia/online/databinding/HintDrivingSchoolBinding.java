package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class HintDrivingSchoolBinding implements ViewBinding {
    public final RecyclerView hintAdditionalQuests;
    public final View hintAdditionalQuestsBlockView;
    public final ImageView hintInstructor;
    public final RecyclerView hintMainQuests;
    public final TextView hintTextAdditionalTitle;
    public final TextView hintTextIfWithoutAdditionalQuests;
    public final TextView hintTextInstructor;
    public final TextView hintTextMainTitle;
    public final View hintUnderline;
    private final ConstraintLayout rootView;

    private HintDrivingSchoolBinding(ConstraintLayout rootView, RecyclerView hintAdditionalQuests, View hintAdditionalQuestsBlockView, ImageView hintInstructor, RecyclerView hintMainQuests, TextView hintTextAdditionalTitle, TextView hintTextIfWithoutAdditionalQuests, TextView hintTextInstructor, TextView hintTextMainTitle, View hintUnderline) {
        this.rootView = rootView;
        this.hintAdditionalQuests = hintAdditionalQuests;
        this.hintAdditionalQuestsBlockView = hintAdditionalQuestsBlockView;
        this.hintInstructor = hintInstructor;
        this.hintMainQuests = hintMainQuests;
        this.hintTextAdditionalTitle = hintTextAdditionalTitle;
        this.hintTextIfWithoutAdditionalQuests = hintTextIfWithoutAdditionalQuests;
        this.hintTextInstructor = hintTextInstructor;
        this.hintTextMainTitle = hintTextMainTitle;
        this.hintUnderline = hintUnderline;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HintDrivingSchoolBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HintDrivingSchoolBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hint_driving_school, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HintDrivingSchoolBinding bind(View rootView) {
        int i = R.id.hint_additional_quests;
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.hint_additional_quests);
        if (recyclerView != null) {
            i = R.id.hint_additional_quests_block_view;
            View findViewById = rootView.findViewById(R.id.hint_additional_quests_block_view);
            if (findViewById != null) {
                i = R.id.hint_instructor;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.hint_instructor);
                if (imageView != null) {
                    i = R.id.hint_main_quests;
                    RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.hint_main_quests);
                    if (recyclerView2 != null) {
                        i = R.id.hint_text_additional_title;
                        TextView textView = (TextView) rootView.findViewById(R.id.hint_text_additional_title);
                        if (textView != null) {
                            i = R.id.hint_text_if_without_additional_quests;
                            TextView textView2 = (TextView) rootView.findViewById(R.id.hint_text_if_without_additional_quests);
                            if (textView2 != null) {
                                i = R.id.hint_text_instructor;
                                TextView textView3 = (TextView) rootView.findViewById(R.id.hint_text_instructor);
                                if (textView3 != null) {
                                    i = R.id.hint_text_main_title;
                                    TextView textView4 = (TextView) rootView.findViewById(R.id.hint_text_main_title);
                                    if (textView4 != null) {
                                        i = R.id.hint_underline;
                                        View findViewById2 = rootView.findViewById(R.id.hint_underline);
                                        if (findViewById2 != null) {
                                            return new HintDrivingSchoolBinding((ConstraintLayout) rootView, recyclerView, findViewById, imageView, recyclerView2, textView, textView2, textView3, textView4, findViewById2);
                                        }
                                    }
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
