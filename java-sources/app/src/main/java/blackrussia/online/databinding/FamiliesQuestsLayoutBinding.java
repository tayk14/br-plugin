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

public final class FamiliesQuestsLayoutBinding implements ViewBinding {
    public final View bodyRightBlock;
    public final Button buttonStartQuest;
    public final View leftTitleDiver;
    public final View present1Bg;
    public final ImageView present1Item;
    public final TextView present1Value;
    public final View present2Bg;
    public final ImageView present2Item;
    public final TextView present2Value;
    public final View present3Bg;
    public final ImageView present3Item;
    public final TextView present3Value;
    public final RecyclerView questionsList;
    public final TextView questsTitle;
    private final ConstraintLayout rootView;
    public final View titleLeftBlock;
    public final TextView titleQuestsDescription;
    public final TextView titleQuestsPresent;
    public final TextView valueQuestsDescription;

    private FamiliesQuestsLayoutBinding(ConstraintLayout rootView, View bodyRightBlock, Button buttonStartQuest, View leftTitleDiver, View present1Bg, ImageView present1Item, TextView present1Value, View present2Bg, ImageView present2Item, TextView present2Value, View present3Bg, ImageView present3Item, TextView present3Value, RecyclerView questionsList, TextView questsTitle, View titleLeftBlock, TextView titleQuestsDescription, TextView titleQuestsPresent, TextView valueQuestsDescription) {
        this.rootView = rootView;
        this.bodyRightBlock = bodyRightBlock;
        this.buttonStartQuest = buttonStartQuest;
        this.leftTitleDiver = leftTitleDiver;
        this.present1Bg = present1Bg;
        this.present1Item = present1Item;
        this.present1Value = present1Value;
        this.present2Bg = present2Bg;
        this.present2Item = present2Item;
        this.present2Value = present2Value;
        this.present3Bg = present3Bg;
        this.present3Item = present3Item;
        this.present3Value = present3Value;
        this.questionsList = questionsList;
        this.questsTitle = questsTitle;
        this.titleLeftBlock = titleLeftBlock;
        this.titleQuestsDescription = titleQuestsDescription;
        this.titleQuestsPresent = titleQuestsPresent;
        this.valueQuestsDescription = valueQuestsDescription;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesQuestsLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesQuestsLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_quests_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesQuestsLayoutBinding bind(View rootView) {
        int i = R.id.body_right_block;
        View findViewById = rootView.findViewById(R.id.body_right_block);
        if (findViewById != null) {
            i = R.id.button_start_quest;
            Button button = (Button) rootView.findViewById(R.id.button_start_quest);
            if (button != null) {
                i = R.id.left_title_diver;
                View findViewById2 = rootView.findViewById(R.id.left_title_diver);
                if (findViewById2 != null) {
                    i = R.id.present_1_bg;
                    View findViewById3 = rootView.findViewById(R.id.present_1_bg);
                    if (findViewById3 != null) {
                        i = R.id.present_1_item;
                        ImageView imageView = (ImageView) rootView.findViewById(R.id.present_1_item);
                        if (imageView != null) {
                            i = R.id.present_1_value;
                            TextView textView = (TextView) rootView.findViewById(R.id.present_1_value);
                            if (textView != null) {
                                i = R.id.present_2_bg;
                                View findViewById4 = rootView.findViewById(R.id.present_2_bg);
                                if (findViewById4 != null) {
                                    i = R.id.present_2_item;
                                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.present_2_item);
                                    if (imageView2 != null) {
                                        i = R.id.present_2_value;
                                        TextView textView2 = (TextView) rootView.findViewById(R.id.present_2_value);
                                        if (textView2 != null) {
                                            i = R.id.present_3_bg;
                                            View findViewById5 = rootView.findViewById(R.id.present_3_bg);
                                            if (findViewById5 != null) {
                                                i = R.id.present_3_item;
                                                ImageView imageView3 = (ImageView) rootView.findViewById(R.id.present_3_item);
                                                if (imageView3 != null) {
                                                    i = R.id.present_3_value;
                                                    TextView textView3 = (TextView) rootView.findViewById(R.id.present_3_value);
                                                    if (textView3 != null) {
                                                        i = R.id.questions_list;
                                                        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.questions_list);
                                                        if (recyclerView != null) {
                                                            i = R.id.quests_title;
                                                            TextView textView4 = (TextView) rootView.findViewById(R.id.quests_title);
                                                            if (textView4 != null) {
                                                                i = R.id.title_left_block;
                                                                View findViewById6 = rootView.findViewById(R.id.title_left_block);
                                                                if (findViewById6 != null) {
                                                                    i = R.id.title_quests_description;
                                                                    TextView textView5 = (TextView) rootView.findViewById(R.id.title_quests_description);
                                                                    if (textView5 != null) {
                                                                        i = R.id.title_quests_present;
                                                                        TextView textView6 = (TextView) rootView.findViewById(R.id.title_quests_present);
                                                                        if (textView6 != null) {
                                                                            i = R.id.value_quests_description;
                                                                            TextView textView7 = (TextView) rootView.findViewById(R.id.value_quests_description);
                                                                            if (textView7 != null) {
                                                                                return new FamiliesQuestsLayoutBinding((ConstraintLayout) rootView, findViewById, button, findViewById2, findViewById3, imageView, textView, findViewById4, imageView2, textView2, findViewById5, imageView3, textView3, recyclerView, textView4, findViewById6, textView5, textView6, textView7);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
