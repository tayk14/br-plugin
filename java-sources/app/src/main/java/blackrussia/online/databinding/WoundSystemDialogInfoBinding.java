package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class WoundSystemDialogInfoBinding implements ViewBinding {
    public final View borderWsDialog;
    public final View closeWsDialog;
    public final ImageView iconDoctor;
    public final ImageView iconFriends;
    public final View lineWs;
    private final ConstraintLayout rootView;
    public final TextView textDoctor;
    public final TextView textFriends;
    public final TextView textInfoWsDialog;
    public final TextView textSubinfoDialog;
    public final TextView titleWsDialog;
    public final View wsBg;
    public final View wsRadialBgDialog;

    private WoundSystemDialogInfoBinding(ConstraintLayout rootView, View borderWsDialog, View closeWsDialog, ImageView iconDoctor, ImageView iconFriends, View lineWs, TextView textDoctor, TextView textFriends, TextView textInfoWsDialog, TextView textSubinfoDialog, TextView titleWsDialog, View wsBg, View wsRadialBgDialog) {
        this.rootView = rootView;
        this.borderWsDialog = borderWsDialog;
        this.closeWsDialog = closeWsDialog;
        this.iconDoctor = iconDoctor;
        this.iconFriends = iconFriends;
        this.lineWs = lineWs;
        this.textDoctor = textDoctor;
        this.textFriends = textFriends;
        this.textInfoWsDialog = textInfoWsDialog;
        this.textSubinfoDialog = textSubinfoDialog;
        this.titleWsDialog = titleWsDialog;
        this.wsBg = wsBg;
        this.wsRadialBgDialog = wsRadialBgDialog;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WoundSystemDialogInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WoundSystemDialogInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.wound_system_dialog_info, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WoundSystemDialogInfoBinding bind(View rootView) {
        int i = R.id.border_ws_dialog;
        View findViewById = rootView.findViewById(R.id.border_ws_dialog);
        if (findViewById != null) {
            i = R.id.close_ws_dialog;
            View findViewById2 = rootView.findViewById(R.id.close_ws_dialog);
            if (findViewById2 != null) {
                i = R.id.icon_doctor;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.icon_doctor);
                if (imageView != null) {
                    i = R.id.icon_friends;
                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.icon_friends);
                    if (imageView2 != null) {
                        i = R.id.line_ws;
                        View findViewById3 = rootView.findViewById(R.id.line_ws);
                        if (findViewById3 != null) {
                            i = R.id.text_doctor;
                            TextView textView = (TextView) rootView.findViewById(R.id.text_doctor);
                            if (textView != null) {
                                i = R.id.text_friends;
                                TextView textView2 = (TextView) rootView.findViewById(R.id.text_friends);
                                if (textView2 != null) {
                                    i = R.id.text_info_ws_dialog;
                                    TextView textView3 = (TextView) rootView.findViewById(R.id.text_info_ws_dialog);
                                    if (textView3 != null) {
                                        i = R.id.text_subinfo_dialog;
                                        TextView textView4 = (TextView) rootView.findViewById(R.id.text_subinfo_dialog);
                                        if (textView4 != null) {
                                            i = R.id.title_ws_dialog;
                                            TextView textView5 = (TextView) rootView.findViewById(R.id.title_ws_dialog);
                                            if (textView5 != null) {
                                                i = R.id.ws_bg;
                                                View findViewById4 = rootView.findViewById(R.id.ws_bg);
                                                if (findViewById4 != null) {
                                                    i = R.id.ws_radial_bg_dialog;
                                                    View findViewById5 = rootView.findViewById(R.id.ws_radial_bg_dialog);
                                                    if (findViewById5 != null) {
                                                        return new WoundSystemDialogInfoBinding((ConstraintLayout) rootView, findViewById, findViewById2, imageView, imageView2, findViewById3, textView, textView2, textView3, textView4, textView5, findViewById4, findViewById5);
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
