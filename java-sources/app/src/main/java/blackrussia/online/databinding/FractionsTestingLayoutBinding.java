package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.tuyenmonkey.mkloader.MKLoader;

public final class FractionsTestingLayoutBinding implements ViewBinding {
    public final View bottomBody;
    public final View leftTitleDiver;
    public final MKLoader loader;
    public final RecyclerView recyclerViewTesting;
    private final ConstraintLayout rootView;
    public final TextView textViewQuestionTitle;
    public final TextView textViewTestingTitle;
    public final View topTitleBlock;

    private FractionsTestingLayoutBinding(ConstraintLayout rootView, View bottomBody, View leftTitleDiver, MKLoader loader, RecyclerView recyclerViewTesting, TextView textViewQuestionTitle, TextView textViewTestingTitle, View topTitleBlock) {
        this.rootView = rootView;
        this.bottomBody = bottomBody;
        this.leftTitleDiver = leftTitleDiver;
        this.loader = loader;
        this.recyclerViewTesting = recyclerViewTesting;
        this.textViewQuestionTitle = textViewQuestionTitle;
        this.textViewTestingTitle = textViewTestingTitle;
        this.topTitleBlock = topTitleBlock;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsTestingLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsTestingLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_testing_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsTestingLayoutBinding bind(View rootView) {
        int i = R.id.bottom_body;
        View findViewById = rootView.findViewById(R.id.bottom_body);
        if (findViewById != null) {
            i = R.id.left_title_diver;
            View findViewById2 = rootView.findViewById(R.id.left_title_diver);
            if (findViewById2 != null) {
                i = R.id.loader;
                MKLoader mKLoader = (MKLoader) rootView.findViewById(R.id.loader);
                if (mKLoader != null) {
                    i = R.id.recycler_view_testing;
                    RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_testing);
                    if (recyclerView != null) {
                        i = R.id.text_view_question_title;
                        TextView textView = (TextView) rootView.findViewById(R.id.text_view_question_title);
                        if (textView != null) {
                            i = R.id.text_view_testing_title;
                            TextView textView2 = (TextView) rootView.findViewById(R.id.text_view_testing_title);
                            if (textView2 != null) {
                                i = R.id.top_title_block;
                                View findViewById3 = rootView.findViewById(R.id.top_title_block);
                                if (findViewById3 != null) {
                                    return new FractionsTestingLayoutBinding((ConstraintLayout) rootView, findViewById, findViewById2, mKLoader, recyclerView, textView, textView2, findViewById3);
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
