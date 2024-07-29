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

public final class DrivingSchoolQuestionsLayoutBinding implements ViewBinding {
    public final RecyclerView answersList;
    public final View correctAnswersBg;
    public final ImageView iconClock;
    public final ImageView iconCorrectAnswer;
    public final ImageView questionsIconBg;
    public final ImageView questionsIconRes;
    private final ConstraintLayout rootView;
    public final TextView thisQuestionValue;
    public final TextView thisQuestionsText;
    public final View timerBg;
    public final TextView valueCorrectAnswers;
    public final TextView valueTimer;

    private DrivingSchoolQuestionsLayoutBinding(ConstraintLayout rootView, RecyclerView answersList, View correctAnswersBg, ImageView iconClock, ImageView iconCorrectAnswer, ImageView questionsIconBg, ImageView questionsIconRes, TextView thisQuestionValue, TextView thisQuestionsText, View timerBg, TextView valueCorrectAnswers, TextView valueTimer) {
        this.rootView = rootView;
        this.answersList = answersList;
        this.correctAnswersBg = correctAnswersBg;
        this.iconClock = iconClock;
        this.iconCorrectAnswer = iconCorrectAnswer;
        this.questionsIconBg = questionsIconBg;
        this.questionsIconRes = questionsIconRes;
        this.thisQuestionValue = thisQuestionValue;
        this.thisQuestionsText = thisQuestionsText;
        this.timerBg = timerBg;
        this.valueCorrectAnswers = valueCorrectAnswers;
        this.valueTimer = valueTimer;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DrivingSchoolQuestionsLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DrivingSchoolQuestionsLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.driving_school_questions_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DrivingSchoolQuestionsLayoutBinding bind(View rootView) {
        int i = R.id.answers_list;
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.answers_list);
        if (recyclerView != null) {
            i = R.id.correct_answers_bg;
            View findViewById = rootView.findViewById(R.id.correct_answers_bg);
            if (findViewById != null) {
                i = R.id.icon_clock;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.icon_clock);
                if (imageView != null) {
                    i = R.id.icon_correct_answer;
                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.icon_correct_answer);
                    if (imageView2 != null) {
                        i = R.id.questions_icon_bg;
                        ImageView imageView3 = (ImageView) rootView.findViewById(R.id.questions_icon_bg);
                        if (imageView3 != null) {
                            i = R.id.questions_icon_res;
                            ImageView imageView4 = (ImageView) rootView.findViewById(R.id.questions_icon_res);
                            if (imageView4 != null) {
                                i = R.id.this_question_value;
                                TextView textView = (TextView) rootView.findViewById(R.id.this_question_value);
                                if (textView != null) {
                                    i = R.id.this_questions_text;
                                    TextView textView2 = (TextView) rootView.findViewById(R.id.this_questions_text);
                                    if (textView2 != null) {
                                        i = R.id.timer_bg;
                                        View findViewById2 = rootView.findViewById(R.id.timer_bg);
                                        if (findViewById2 != null) {
                                            i = R.id.value_correct_answers;
                                            TextView textView3 = (TextView) rootView.findViewById(R.id.value_correct_answers);
                                            if (textView3 != null) {
                                                i = R.id.value_timer;
                                                TextView textView4 = (TextView) rootView.findViewById(R.id.value_timer);
                                                if (textView4 != null) {
                                                    return new DrivingSchoolQuestionsLayoutBinding((ConstraintLayout) rootView, recyclerView, findViewById, imageView, imageView2, imageView3, imageView4, textView, textView2, findViewById2, textView3, textView4);
                                                }
                                            }
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
