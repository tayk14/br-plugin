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

public final class RegInviteBinding implements ViewBinding {
    public final Button butContinue;
    public final Button butSkip;
    public final CustomEditTextWithBackPressEvent inviteNick;
    private final LinearLayout rootView;
    public final TextView textInvite;
    public final View view9;

    private RegInviteBinding(LinearLayout rootView, Button butContinue, Button butSkip, CustomEditTextWithBackPressEvent inviteNick, TextView textInvite, View view9) {
        this.rootView = rootView;
        this.butContinue = butContinue;
        this.butSkip = butSkip;
        this.inviteNick = inviteNick;
        this.textInvite = textInvite;
        this.view9 = view9;
    }

    @Override
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RegInviteBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RegInviteBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reg_invite, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegInviteBinding bind(View rootView) {
        int i = R.id.but_continue;
        Button button = (Button) rootView.findViewById(R.id.but_continue);
        if (button != null) {
            i = R.id.but_skip;
            Button button2 = (Button) rootView.findViewById(R.id.but_skip);
            if (button2 != null) {
                i = R.id.invite_nick;
                CustomEditTextWithBackPressEvent customEditTextWithBackPressEvent = (CustomEditTextWithBackPressEvent) rootView.findViewById(R.id.invite_nick);
                if (customEditTextWithBackPressEvent != null) {
                    i = R.id.text_invite;
                    TextView textView = (TextView) rootView.findViewById(R.id.text_invite);
                    if (textView != null) {
                        i = R.id.view9;
                        View findViewById = rootView.findViewById(R.id.view9);
                        if (findViewById != null) {
                            return new RegInviteBinding((LinearLayout) rootView, button, button2, customEditTextWithBackPressEvent, textView, findViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
