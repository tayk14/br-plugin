package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.UIContainer;

public final class EntertainmentSystemMainBinding implements ViewBinding {
    public final Button buttonBack;
    public final Button buttonClose;
    public final Button buttonInfo;
    public final Button buttonTop;
    public final UIContainer myContainer;
    private final ConstraintLayout rootView;
    public final TextView title;

    private EntertainmentSystemMainBinding(ConstraintLayout rootView, Button buttonBack, Button buttonClose, Button buttonInfo, Button buttonTop, UIContainer myContainer, TextView title) {
        this.rootView = rootView;
        this.buttonBack = buttonBack;
        this.buttonClose = buttonClose;
        this.buttonInfo = buttonInfo;
        this.buttonTop = buttonTop;
        this.myContainer = myContainer;
        this.title = title;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EntertainmentSystemMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EntertainmentSystemMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.entertainment_system_main, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EntertainmentSystemMainBinding bind(View rootView) {
        int i = R.id.button_back;
        Button button = (Button) rootView.findViewById(R.id.button_back);
        if (button != null) {
            i = R.id.button_close;
            Button button2 = (Button) rootView.findViewById(R.id.button_close);
            if (button2 != null) {
                i = R.id.button_info;
                Button button3 = (Button) rootView.findViewById(R.id.button_info);
                if (button3 != null) {
                    i = R.id.button_top;
                    Button button4 = (Button) rootView.findViewById(R.id.button_top);
                    if (button4 != null) {
                        i = R.id.my_container;
                        UIContainer uIContainer = (UIContainer) rootView.findViewById(R.id.my_container);
                        if (uIContainer != null) {
                            i = R.id.title;
                            TextView textView = (TextView) rootView.findViewById(R.id.title);
                            if (textView != null) {
                                return new EntertainmentSystemMainBinding((ConstraintLayout) rootView, button, button2, button3, button4, uIContainer, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
