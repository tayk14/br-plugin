package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class HintItemBinding implements ViewBinding {
    public final ProgressBar hintProgressQuest;
    public final TextView hintStatusQuest;
    public final TextView hintTitleAdditionalQuestItem;
    private final ConstraintLayout rootView;

    private HintItemBinding(ConstraintLayout rootView, ProgressBar hintProgressQuest, TextView hintStatusQuest, TextView hintTitleAdditionalQuestItem) {
        this.rootView = rootView;
        this.hintProgressQuest = hintProgressQuest;
        this.hintStatusQuest = hintStatusQuest;
        this.hintTitleAdditionalQuestItem = hintTitleAdditionalQuestItem;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HintItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HintItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hint_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HintItemBinding bind(View rootView) {
        int i = R.id.hint_progress_quest;
        ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.hint_progress_quest);
        if (progressBar != null) {
            i = R.id.hint_status_quest;
            TextView textView = (TextView) rootView.findViewById(R.id.hint_status_quest);
            if (textView != null) {
                i = R.id.hint_title_additional_quest_item;
                TextView textView2 = (TextView) rootView.findViewById(R.id.hint_title_additional_quest_item);
                if (textView2 != null) {
                    return new HintItemBinding((ConstraintLayout) rootView, progressBar, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
