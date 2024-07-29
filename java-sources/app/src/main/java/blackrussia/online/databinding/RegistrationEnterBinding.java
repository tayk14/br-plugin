package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class RegistrationEnterBinding implements ViewBinding {
    public final Button enter;
    public final Button googleEnter;
    public final LinearLayout regLl;
    private final LinearLayout rootView;
    public final TextView textHeader;
    public final TextView textView20;
    public final Button vkEnter;

    private RegistrationEnterBinding(LinearLayout rootView, Button enter, Button googleEnter, LinearLayout regLl, TextView textHeader, TextView textView20, Button vkEnter) {
        this.rootView = rootView;
        this.enter = enter;
        this.googleEnter = googleEnter;
        this.regLl = regLl;
        this.textHeader = textHeader;
        this.textView20 = textView20;
        this.vkEnter = vkEnter;
    }

    @Override
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RegistrationEnterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RegistrationEnterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.registration_enter, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegistrationEnterBinding bind(View rootView) {
        int i = R.id.enter;
        Button button = (Button) rootView.findViewById(R.id.enter);
        if (button != null) {
            i = R.id.google_enter;
            Button button2 = (Button) rootView.findViewById(R.id.google_enter);
            if (button2 != null) {
                LinearLayout linearLayout = (LinearLayout) rootView;
                i = R.id.text_header;
                TextView textView = (TextView) rootView.findViewById(R.id.text_header);
                if (textView != null) {
                    i = R.id.textView20;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.textView20);
                    if (textView2 != null) {
                        i = R.id.vk_enter;
                        Button button3 = (Button) rootView.findViewById(R.id.vk_enter);
                        if (button3 != null) {
                            return new RegistrationEnterBinding(linearLayout, button, button2, linearLayout, textView, textView2, button3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
