package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.CustomEditTextWithBackPressEvent;

public final class WindowDialogBinding implements ViewBinding {
    public final Button dwButtonCancel;
    public final Button dwButtonOk;
    public final TextView dwCaption;
    public final View dwDivider;
    public final CustomEditTextWithBackPressEvent dwEdittext;
    public final LinearLayout dwHeader;
    public final TextView dwInfo;
    public final TextView dwListButton;
    public final LinearLayout dwRoot;
    public final LinearLayout dwRootButtons;
    public final NestedScrollView dwScrollInfo;
    public final LinearLayout dwScrollLayout;
    public final LinearLayout dwScrollRoot;
    public final ScrollView dwScrollview;
    private final LinearLayout rootView;

    private WindowDialogBinding(LinearLayout rootView, Button dwButtonCancel, Button dwButtonOk, TextView dwCaption, View dwDivider, CustomEditTextWithBackPressEvent dwEdittext, LinearLayout dwHeader, TextView dwInfo, TextView dwListButton, LinearLayout dwRoot, LinearLayout dwRootButtons, NestedScrollView dwScrollInfo, LinearLayout dwScrollLayout, LinearLayout dwScrollRoot, ScrollView dwScrollview) {
        this.rootView = rootView;
        this.dwButtonCancel = dwButtonCancel;
        this.dwButtonOk = dwButtonOk;
        this.dwCaption = dwCaption;
        this.dwDivider = dwDivider;
        this.dwEdittext = dwEdittext;
        this.dwHeader = dwHeader;
        this.dwInfo = dwInfo;
        this.dwListButton = dwListButton;
        this.dwRoot = dwRoot;
        this.dwRootButtons = dwRootButtons;
        this.dwScrollInfo = dwScrollInfo;
        this.dwScrollLayout = dwScrollLayout;
        this.dwScrollRoot = dwScrollRoot;
        this.dwScrollview = dwScrollview;
    }

    @Override
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WindowDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WindowDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.window_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WindowDialogBinding bind(View rootView) {
        int i = R.id.dw_button_cancel;
        Button button = (Button) rootView.findViewById(R.id.dw_button_cancel);
        if (button != null) {
            i = R.id.dw_button_ok;
            Button button2 = (Button) rootView.findViewById(R.id.dw_button_ok);
            if (button2 != null) {
                i = R.id.dw_caption;
                TextView textView = (TextView) rootView.findViewById(R.id.dw_caption);
                if (textView != null) {
                    i = R.id.dw_divider;
                    View findViewById = rootView.findViewById(R.id.dw_divider);
                    if (findViewById != null) {
                        i = R.id.dw_edittext;
                        CustomEditTextWithBackPressEvent customEditTextWithBackPressEvent = (CustomEditTextWithBackPressEvent) rootView.findViewById(R.id.dw_edittext);
                        if (customEditTextWithBackPressEvent != null) {
                            i = R.id.dw_header;
                            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.dw_header);
                            if (linearLayout != null) {
                                i = R.id.dw_info;
                                TextView textView2 = (TextView) rootView.findViewById(R.id.dw_info);
                                if (textView2 != null) {
                                    i = R.id.dw_list_button;
                                    TextView textView3 = (TextView) rootView.findViewById(R.id.dw_list_button);
                                    if (textView3 != null) {
                                        LinearLayout linearLayout2 = (LinearLayout) rootView;
                                        i = R.id.dw_root_buttons;
                                        LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.dw_root_buttons);
                                        if (linearLayout3 != null) {
                                            i = R.id.dw_scroll_info;
                                            NestedScrollView nestedScrollView = (NestedScrollView) rootView.findViewById(R.id.dw_scroll_info);
                                            if (nestedScrollView != null) {
                                                i = R.id.dw_scroll_layout;
                                                LinearLayout linearLayout4 = (LinearLayout) rootView.findViewById(R.id.dw_scroll_layout);
                                                if (linearLayout4 != null) {
                                                    i = R.id.dw_scroll_root;
                                                    LinearLayout linearLayout5 = (LinearLayout) rootView.findViewById(R.id.dw_scroll_root);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.dw_scrollview;
                                                        ScrollView scrollView = (ScrollView) rootView.findViewById(R.id.dw_scrollview);
                                                        if (scrollView != null) {
                                                            return new WindowDialogBinding(linearLayout2, button, button2, textView, findViewById, customEditTextWithBackPressEvent, linearLayout, textView2, textView3, linearLayout2, linearLayout3, nestedScrollView, linearLayout4, linearLayout5, scrollView);
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
