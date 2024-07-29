package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class DrivingSchoolQuestionsItemBinding implements ViewBinding {
    public final View questionsBg;
    public final TextView questionsText;
    private final ConstraintLayout rootView;

    private DrivingSchoolQuestionsItemBinding(ConstraintLayout rootView, View questionsBg, TextView questionsText) {
        this.rootView = rootView;
        this.questionsBg = questionsBg;
        this.questionsText = questionsText;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DrivingSchoolQuestionsItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DrivingSchoolQuestionsItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.driving_school_questions_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DrivingSchoolQuestionsItemBinding bind(View rootView) {
        int i = R.id.questions_bg;
        View findViewById = rootView.findViewById(R.id.questions_bg);
        if (findViewById != null) {
            i = R.id.questions_text;
            TextView textView = (TextView) rootView.findViewById(R.id.questions_text);
            if (textView != null) {
                return new DrivingSchoolQuestionsItemBinding((ConstraintLayout) rootView, findViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
