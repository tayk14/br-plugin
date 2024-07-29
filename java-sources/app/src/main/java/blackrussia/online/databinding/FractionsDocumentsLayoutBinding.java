package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FractionsDocumentsLayoutBinding implements ViewBinding {
    public final View bodyRightBlock;
    public final Button buttonAcquaintedWithDocument;
    public final View leftTitleDiver;
    public final RecyclerView recyclerViewTasksList;
    private final ConstraintLayout rootView;
    public final TextView textViewDocumentDescription;
    public final TextView textViewDocumentTitle;
    public final TextView textViewSectionsOfTheCharter;
    public final View titleLeftBlock;

    private FractionsDocumentsLayoutBinding(ConstraintLayout rootView, View bodyRightBlock, Button buttonAcquaintedWithDocument, View leftTitleDiver, RecyclerView recyclerViewTasksList, TextView textViewDocumentDescription, TextView textViewDocumentTitle, TextView textViewSectionsOfTheCharter, View titleLeftBlock) {
        this.rootView = rootView;
        this.bodyRightBlock = bodyRightBlock;
        this.buttonAcquaintedWithDocument = buttonAcquaintedWithDocument;
        this.leftTitleDiver = leftTitleDiver;
        this.recyclerViewTasksList = recyclerViewTasksList;
        this.textViewDocumentDescription = textViewDocumentDescription;
        this.textViewDocumentTitle = textViewDocumentTitle;
        this.textViewSectionsOfTheCharter = textViewSectionsOfTheCharter;
        this.titleLeftBlock = titleLeftBlock;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FractionsDocumentsLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FractionsDocumentsLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fractions_documents_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FractionsDocumentsLayoutBinding bind(View rootView) {
        int i = R.id.body_right_block;
        View findViewById = rootView.findViewById(R.id.body_right_block);
        if (findViewById != null) {
            i = R.id.button_acquainted_with_document;
            Button button = (Button) rootView.findViewById(R.id.button_acquainted_with_document);
            if (button != null) {
                i = R.id.left_title_diver;
                View findViewById2 = rootView.findViewById(R.id.left_title_diver);
                if (findViewById2 != null) {
                    i = R.id.recycler_view_tasks_list;
                    RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_tasks_list);
                    if (recyclerView != null) {
                        i = R.id.text_view_document_description;
                        TextView textView = (TextView) rootView.findViewById(R.id.text_view_document_description);
                        if (textView != null) {
                            i = R.id.text_view_document_title;
                            TextView textView2 = (TextView) rootView.findViewById(R.id.text_view_document_title);
                            if (textView2 != null) {
                                i = R.id.text_view_sections_of_the_charter;
                                TextView textView3 = (TextView) rootView.findViewById(R.id.text_view_sections_of_the_charter);
                                if (textView3 != null) {
                                    i = R.id.title_left_block;
                                    View findViewById3 = rootView.findViewById(R.id.title_left_block);
                                    if (findViewById3 != null) {
                                        return new FractionsDocumentsLayoutBinding((ConstraintLayout) rootView, findViewById, button, findViewById2, recyclerView, textView, textView2, textView3, findViewById3);
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
