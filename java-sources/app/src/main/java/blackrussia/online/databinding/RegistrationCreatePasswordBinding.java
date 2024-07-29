package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.CustomEditTextWithBackPressEvent;

public final class RegistrationCreatePasswordBinding implements ViewBinding {
    public final LinearLayout backButt;
    public final CustomEditTextWithBackPressEvent edit1;
    public final CustomEditTextWithBackPressEvent edit2;
    public final CustomEditTextWithBackPressEvent edit3;
    public final TextView headerText;
    public final Button regButt;
    public final TextView restoreText;
    private final LinearLayout rootView;

    private RegistrationCreatePasswordBinding(LinearLayout rootView, LinearLayout backButt, CustomEditTextWithBackPressEvent edit1, CustomEditTextWithBackPressEvent edit2, CustomEditTextWithBackPressEvent edit3, TextView headerText, Button regButt, TextView restoreText) {
        this.rootView = rootView;
        this.backButt = backButt;
        this.edit1 = edit1;
        this.edit2 = edit2;
        this.edit3 = edit3;
        this.headerText = headerText;
        this.regButt = regButt;
        this.restoreText = restoreText;
    }

    @Override
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RegistrationCreatePasswordBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RegistrationCreatePasswordBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.registration_create_password, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegistrationCreatePasswordBinding bind(View rootView) {
        int i = R.id.back_butt;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.back_butt);
        if (linearLayout != null) {
            i = R.id.edit1;
            CustomEditTextWithBackPressEvent customEditTextWithBackPressEvent = (CustomEditTextWithBackPressEvent) rootView.findViewById(R.id.edit1);
            if (customEditTextWithBackPressEvent != null) {
                i = R.id.edit2;
                CustomEditTextWithBackPressEvent customEditTextWithBackPressEvent2 = (CustomEditTextWithBackPressEvent) rootView.findViewById(R.id.edit2);
                if (customEditTextWithBackPressEvent2 != null) {
                    i = R.id.edit3;
                    CustomEditTextWithBackPressEvent customEditTextWithBackPressEvent3 = (CustomEditTextWithBackPressEvent) rootView.findViewById(R.id.edit3);
                    if (customEditTextWithBackPressEvent3 != null) {
                        i = R.id.header_text;
                        TextView textView = (TextView) rootView.findViewById(R.id.header_text);
                        if (textView != null) {
                            i = R.id.reg_butt;
                            Button button = (Button) rootView.findViewById(R.id.reg_butt);
                            if (button != null) {
                                i = R.id.restore_text;
                                TextView textView2 = (TextView) rootView.findViewById(R.id.restore_text);
                                if (textView2 != null) {
                                    return new RegistrationCreatePasswordBinding((LinearLayout) rootView, linearLayout, customEditTextWithBackPressEvent, customEditTextWithBackPressEvent2, customEditTextWithBackPressEvent3, textView, button, textView2);
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
