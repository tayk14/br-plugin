package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FractionsQuestsLayoutBinding implements ViewBinding {
    public final ImageView award1Item;
    public final TextView award1Value;
    public final ImageView award2Item;
    public final TextView award2Value;
    public final ImageView award3Item;
    public final TextView award3Value;
    public final View bodyRightBlock;
    public final Button buttonStartQuest;
    public final View leftTitleDiver;
    public final TextView questsTitle;
    public final RecyclerView recyclerViewTasksList;
    private final ConstraintLayout rootView;
    public final View titleLeftBlock;
    public final TextView titleQuestsAward;
    public final TextView titleQuestsDescription;
    public final TextView titleQuestsGoal;
    public final TextView valueGoalsDescription;
    public final TextView valueQuestsDescription;

    private FractionsQuestsLayoutBinding(ConstraintLayout rootView, ImageView award1Item, TextView award1Value, ImageView award2Item, TextView award2Value, ImageView award3Item, TextView award3Value, View bodyRightBlock, Button buttonStartQuest, View leftTitleDiver, TextView questsTitle, RecyclerView recyclerViewTasksList, View titleLeftBlock, TextView titleQuestsAward, TextView titleQuestsDescription, TextView titleQuestsGoal, TextView valueGoalsDescription, TextView valueQuestsDescription) {
        this.rootView = rootView;
        this.award1Item = award1Item;
        this.award1Value = award1Value;
        this.award2Item = award2Item;
        this.award2Value = award2Value;
        this.award3Item = award3Item;
        this.award3Value = award3Value;
        this.bodyRightBlock = bodyRightBlock;
        this.buttonStartQuest = buttonStartQuest;
        this.leftTitleDiver = leftTitleDiver;
        this.questsTitle = questsTitle;
        this.recyclerViewTasksList = recyclerViewTasksList;
        this.titleLeftBlock = titleLeftBlock;
        this.titleQuestsAward = titleQuestsAward;
        this.titleQuestsDescription = titleQuestsDescription;
        this.titleQuestsGoal = titleQuestsGoal;
        this.valueGoalsDescription = valueGoalsDescription;
        this.valueQuestsDescription = valueQuestsDescription;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsQuestsLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsQuestsLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_quests_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsQuestsLayoutBinding bind(View rootView) {
        int i = R.id.award_1_item;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.award_1_item);
        if (imageView != null) {
            i = R.id.award_1_value;
            TextView textView = (TextView) rootView.findViewById(R.id.award_1_value);
            if (textView != null) {
                i = R.id.award_2_item;
                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.award_2_item);
                if (imageView2 != null) {
                    i = R.id.award_2_value;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.award_2_value);
                    if (textView2 != null) {
                        i = R.id.award_3_item;
                        ImageView imageView3 = (ImageView) rootView.findViewById(R.id.award_3_item);
                        if (imageView3 != null) {
                            i = R.id.award_3_value;
                            TextView textView3 = (TextView) rootView.findViewById(R.id.award_3_value);
                            if (textView3 != null) {
                                i = R.id.body_right_block;
                                View findViewById = rootView.findViewById(R.id.body_right_block);
                                if (findViewById != null) {
                                    i = R.id.button_start_quest;
                                    Button button = (Button) rootView.findViewById(R.id.button_start_quest);
                                    if (button != null) {
                                        i = R.id.left_title_diver;
                                        View findViewById2 = rootView.findViewById(R.id.left_title_diver);
                                        if (findViewById2 != null) {
                                            i = R.id.quests_title;
                                            TextView textView4 = (TextView) rootView.findViewById(R.id.quests_title);
                                            if (textView4 != null) {
                                                i = R.id.recycler_view_tasks_list;
                                                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_tasks_list);
                                                if (recyclerView != null) {
                                                    i = R.id.title_left_block;
                                                    View findViewById3 = rootView.findViewById(R.id.title_left_block);
                                                    if (findViewById3 != null) {
                                                        i = R.id.title_quests_award;
                                                        TextView textView5 = (TextView) rootView.findViewById(R.id.title_quests_award);
                                                        if (textView5 != null) {
                                                            i = R.id.title_quests_description;
                                                            TextView textView6 = (TextView) rootView.findViewById(R.id.title_quests_description);
                                                            if (textView6 != null) {
                                                                i = R.id.title_quests_goal;
                                                                TextView textView7 = (TextView) rootView.findViewById(R.id.title_quests_goal);
                                                                if (textView7 != null) {
                                                                    i = R.id.value_goals_description;
                                                                    TextView textView8 = (TextView) rootView.findViewById(R.id.value_goals_description);
                                                                    if (textView8 != null) {
                                                                        i = R.id.value_quests_description;
                                                                        TextView textView9 = (TextView) rootView.findViewById(R.id.value_quests_description);
                                                                        if (textView9 != null) {
                                                                            return new FractionsQuestsLayoutBinding((ConstraintLayout) rootView, imageView, textView, imageView2, textView2, imageView3, textView3, findViewById, button, findViewById2, textView4, recyclerView, findViewById3, textView5, textView6, textView7, textView8, textView9);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
