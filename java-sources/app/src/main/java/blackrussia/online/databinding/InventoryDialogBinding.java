package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.UIContainer;

public final class InventoryDialogBinding implements ViewBinding {
    public final View bottomBlack;
    public final TextView helpText1;
    public final TextView helpText2;
    public final TextView helpText3;
    public final UIContainer invContainer;
    public final ImageButton invMainButtonExit;
    public final RecyclerView invMainButtons;
    public final View invMainButtonsBlock;
    public final View leftBlack;
    public final View rightBlack;
    private final ConstraintLayout rootView;
    public final View topBlack;
    public final View window;

    private InventoryDialogBinding(ConstraintLayout rootView, View bottomBlack, TextView helpText1, TextView helpText2, TextView helpText3, UIContainer invContainer, ImageButton invMainButtonExit, RecyclerView invMainButtons, View invMainButtonsBlock, View leftBlack, View rightBlack, View topBlack, View window) {
        this.rootView = rootView;
        this.bottomBlack = bottomBlack;
        this.helpText1 = helpText1;
        this.helpText2 = helpText2;
        this.helpText3 = helpText3;
        this.invContainer = invContainer;
        this.invMainButtonExit = invMainButtonExit;
        this.invMainButtons = invMainButtons;
        this.invMainButtonsBlock = invMainButtonsBlock;
        this.leftBlack = leftBlack;
        this.rightBlack = rightBlack;
        this.topBlack = topBlack;
        this.window = window;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InventoryDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryDialogBinding bind(View rootView) {
        int i = R.id.bottom_black;
        View findViewById = rootView.findViewById(R.id.bottom_black);
        if (findViewById != null) {
            i = R.id.help_text_1;
            TextView textView = (TextView) rootView.findViewById(R.id.help_text_1);
            if (textView != null) {
                i = R.id.help_text_2;
                TextView textView2 = (TextView) rootView.findViewById(R.id.help_text_2);
                if (textView2 != null) {
                    i = R.id.help_text_3;
                    TextView textView3 = (TextView) rootView.findViewById(R.id.help_text_3);
                    if (textView3 != null) {
                        i = R.id.inv_container;
                        UIContainer uIContainer = (UIContainer) rootView.findViewById(R.id.inv_container);
                        if (uIContainer != null) {
                            i = R.id.inv_main_button_exit;
                            ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.inv_main_button_exit);
                            if (imageButton != null) {
                                i = R.id.inv_main_buttons;
                                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.inv_main_buttons);
                                if (recyclerView != null) {
                                    i = R.id.inv_main_buttons_block;
                                    View findViewById2 = rootView.findViewById(R.id.inv_main_buttons_block);
                                    if (findViewById2 != null) {
                                        i = R.id.left_black;
                                        View findViewById3 = rootView.findViewById(R.id.left_black);
                                        if (findViewById3 != null) {
                                            i = R.id.right_black;
                                            View findViewById4 = rootView.findViewById(R.id.right_black);
                                            if (findViewById4 != null) {
                                                i = R.id.top_black;
                                                View findViewById5 = rootView.findViewById(R.id.top_black);
                                                if (findViewById5 != null) {
                                                    i = R.id.window;
                                                    View findViewById6 = rootView.findViewById(R.id.window);
                                                    if (findViewById6 != null) {
                                                        return new InventoryDialogBinding((ConstraintLayout) rootView, findViewById, textView, textView2, textView3, uIContainer, imageButton, recyclerView, findViewById2, findViewById3, findViewById4, findViewById5, findViewById6);
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
