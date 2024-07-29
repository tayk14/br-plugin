package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class WoundSystemMainLayoutBinding implements ViewBinding {
    public final Button buttonNeedHelp;
    public final Button buttonNeedHospital;
    public final TextView playersNickAndId;
    private final ConstraintLayout rootView;
    public final TextView textInfoNeedHelp;
    public final TextView textInfoNeedHospital1;
    public final TextView textInfoNeedHospital2;
    public final TextView textInfoNeedHospital3;
    public final TextView titleDamage;
    public final View viewSmile;

    private WoundSystemMainLayoutBinding(ConstraintLayout rootView, Button buttonNeedHelp, Button buttonNeedHospital, TextView playersNickAndId, TextView textInfoNeedHelp, TextView textInfoNeedHospital1, TextView textInfoNeedHospital2, TextView textInfoNeedHospital3, TextView titleDamage, View viewSmile) {
        this.rootView = rootView;
        this.buttonNeedHelp = buttonNeedHelp;
        this.buttonNeedHospital = buttonNeedHospital;
        this.playersNickAndId = playersNickAndId;
        this.textInfoNeedHelp = textInfoNeedHelp;
        this.textInfoNeedHospital1 = textInfoNeedHospital1;
        this.textInfoNeedHospital2 = textInfoNeedHospital2;
        this.textInfoNeedHospital3 = textInfoNeedHospital3;
        this.titleDamage = titleDamage;
        this.viewSmile = viewSmile;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WoundSystemMainLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WoundSystemMainLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.wound_system_main_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WoundSystemMainLayoutBinding bind(View rootView) {
        int i = R.id.button_need_help;
        Button button = (Button) rootView.findViewById(R.id.button_need_help);
        if (button != null) {
            i = R.id.button_need_hospital;
            Button button2 = (Button) rootView.findViewById(R.id.button_need_hospital);
            if (button2 != null) {
                i = R.id.players_nick_and_id;
                TextView textView = (TextView) rootView.findViewById(R.id.players_nick_and_id);
                if (textView != null) {
                    i = R.id.text_info_need_help;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.text_info_need_help);
                    if (textView2 != null) {
                        i = R.id.text_info_need_hospital_1;
                        TextView textView3 = (TextView) rootView.findViewById(R.id.text_info_need_hospital_1);
                        if (textView3 != null) {
                            i = R.id.text_info_need_hospital_2;
                            TextView textView4 = (TextView) rootView.findViewById(R.id.text_info_need_hospital_2);
                            if (textView4 != null) {
                                i = R.id.text_info_need_hospital_3;
                                TextView textView5 = (TextView) rootView.findViewById(R.id.text_info_need_hospital_3);
                                if (textView5 != null) {
                                    i = R.id.title_damage;
                                    TextView textView6 = (TextView) rootView.findViewById(R.id.title_damage);
                                    if (textView6 != null) {
                                        i = R.id.view_smile;
                                        View findViewById = rootView.findViewById(R.id.view_smile);
                                        if (findViewById != null) {
                                            return new WoundSystemMainLayoutBinding((ConstraintLayout) rootView, button, button2, textView, textView2, textView3, textView4, textView5, textView6, findViewById);
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
