package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class TuningFragmentInfoBinding implements ViewBinding {
    public final Button backToSubmenuInfo;
    public final View bgFragmentInfoText;
    public final TextView bodyInfoText;
    public final ImageView buttonBackDetailsInfoText;
    public final View helpViewText;
    public final LinearLayout menuBlockInfo;
    private final RelativeLayout rootView;
    public final TextView titleInfoText;
    public final Button tuningViewBox;
    public final View underlineTitleText;
    public final RelativeLayout viewDetailsInfo;

    private TuningFragmentInfoBinding(RelativeLayout rootView, Button backToSubmenuInfo, View bgFragmentInfoText, TextView bodyInfoText, ImageView buttonBackDetailsInfoText, View helpViewText, LinearLayout menuBlockInfo, TextView titleInfoText, Button tuningViewBox, View underlineTitleText, RelativeLayout viewDetailsInfo) {
        this.rootView = rootView;
        this.backToSubmenuInfo = backToSubmenuInfo;
        this.bgFragmentInfoText = bgFragmentInfoText;
        this.bodyInfoText = bodyInfoText;
        this.buttonBackDetailsInfoText = buttonBackDetailsInfoText;
        this.helpViewText = helpViewText;
        this.menuBlockInfo = menuBlockInfo;
        this.titleInfoText = titleInfoText;
        this.tuningViewBox = tuningViewBox;
        this.underlineTitleText = underlineTitleText;
        this.viewDetailsInfo = viewDetailsInfo;
    }

    @Override
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TuningFragmentInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TuningFragmentInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.tuning_fragment_info, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static TuningFragmentInfoBinding bind(View rootView) {
        int i = R.id.back_to_submenu_info;
        Button button = (Button) rootView.findViewById(R.id.back_to_submenu_info);
        if (button != null) {
            i = R.id.bg_fragment_info_text;
            View findViewById = rootView.findViewById(R.id.bg_fragment_info_text);
            if (findViewById != null) {
                i = R.id.body_info_text;
                TextView textView = (TextView) rootView.findViewById(R.id.body_info_text);
                if (textView != null) {
                    i = R.id.button_back_details_info_text;
                    ImageView imageView = (ImageView) rootView.findViewById(R.id.button_back_details_info_text);
                    if (imageView != null) {
                        i = R.id.help_view_text;
                        View findViewById2 = rootView.findViewById(R.id.help_view_text);
                        if (findViewById2 != null) {
                            i = R.id.menu_block_info;
                            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.menu_block_info);
                            if (linearLayout != null) {
                                i = R.id.title_info_text;
                                TextView textView2 = (TextView) rootView.findViewById(R.id.title_info_text);
                                if (textView2 != null) {
                                    i = R.id.tuning_view_box;
                                    Button button2 = (Button) rootView.findViewById(R.id.tuning_view_box);
                                    if (button2 != null) {
                                        i = R.id.underline_title_text;
                                        View findViewById3 = rootView.findViewById(R.id.underline_title_text);
                                        if (findViewById3 != null) {
                                            RelativeLayout relativeLayout = (RelativeLayout) rootView;
                                            return new TuningFragmentInfoBinding(relativeLayout, button, findViewById, textView, imageView, findViewById2, linearLayout, textView2, button2, findViewById3, relativeLayout);
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
