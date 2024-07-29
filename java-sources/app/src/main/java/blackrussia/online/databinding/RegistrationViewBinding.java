package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.UIContainer;

public final class RegistrationViewBinding implements ViewBinding {
    public final ImageView brlogo;
    public final View healthBar;
    public final UIContainer regContainer;
    public final TextView regHeader;
    public final TextView regInfo;
    public final TextView regNickname;
    public final ImageView regPerson;
    private final LinearLayout rootView;
    public final View view8;

    private RegistrationViewBinding(LinearLayout rootView, ImageView brlogo, View healthBar, UIContainer regContainer, TextView regHeader, TextView regInfo, TextView regNickname, ImageView regPerson, View view8) {
        this.rootView = rootView;
        this.brlogo = brlogo;
        this.healthBar = healthBar;
        this.regContainer = regContainer;
        this.regHeader = regHeader;
        this.regInfo = regInfo;
        this.regNickname = regNickname;
        this.regPerson = regPerson;
        this.view8 = view8;
    }

    @Override
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RegistrationViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RegistrationViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.registration_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegistrationViewBinding bind(View rootView) {
        int i = R.id.brlogo;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.brlogo);
        if (imageView != null) {
            i = R.id.health_bar;
            View findViewById = rootView.findViewById(R.id.health_bar);
            if (findViewById != null) {
                i = R.id.reg_container;
                UIContainer uIContainer = (UIContainer) rootView.findViewById(R.id.reg_container);
                if (uIContainer != null) {
                    i = R.id.reg_header;
                    TextView textView = (TextView) rootView.findViewById(R.id.reg_header);
                    if (textView != null) {
                        i = R.id.reg_info;
                        TextView textView2 = (TextView) rootView.findViewById(R.id.reg_info);
                        if (textView2 != null) {
                            i = R.id.reg_nickname;
                            TextView textView3 = (TextView) rootView.findViewById(R.id.reg_nickname);
                            if (textView3 != null) {
                                i = R.id.reg_person;
                                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.reg_person);
                                if (imageView2 != null) {
                                    i = R.id.view8;
                                    View findViewById2 = rootView.findViewById(R.id.view8);
                                    if (findViewById2 != null) {
                                        return new RegistrationViewBinding((LinearLayout) rootView, imageView, findViewById, uIContainer, textView, textView2, textView3, imageView2, findViewById2);
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
