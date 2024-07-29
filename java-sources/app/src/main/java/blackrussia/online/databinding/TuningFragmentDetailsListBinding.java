package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class TuningFragmentDetailsListBinding implements ViewBinding {
    public final Button backToSubmenuDetail;
    public final ImageView buttonInfoBrake;
    public final Button buttonResetDetail;
    public final Button buttonViewCarDetailsList;
    public final View helpViewAboveListInDetailList;
    public final View helpViewInDetailList;
    public final LinearLayout menuBlockDetail;
    public final RecyclerView recvDetailsList;
    private final RelativeLayout rootView;
    public final TextView titleDetailsList;
    public final TextView titlePriceBlockDetails;
    public final Button tuningPriceDetail;

    private TuningFragmentDetailsListBinding(RelativeLayout rootView, Button backToSubmenuDetail, ImageView buttonInfoBrake, Button buttonResetDetail, Button buttonViewCarDetailsList, View helpViewAboveListInDetailList, View helpViewInDetailList, LinearLayout menuBlockDetail, RecyclerView recvDetailsList, TextView titleDetailsList, TextView titlePriceBlockDetails, Button tuningPriceDetail) {
        this.rootView = rootView;
        this.backToSubmenuDetail = backToSubmenuDetail;
        this.buttonInfoBrake = buttonInfoBrake;
        this.buttonResetDetail = buttonResetDetail;
        this.buttonViewCarDetailsList = buttonViewCarDetailsList;
        this.helpViewAboveListInDetailList = helpViewAboveListInDetailList;
        this.helpViewInDetailList = helpViewInDetailList;
        this.menuBlockDetail = menuBlockDetail;
        this.recvDetailsList = recvDetailsList;
        this.titleDetailsList = titleDetailsList;
        this.titlePriceBlockDetails = titlePriceBlockDetails;
        this.tuningPriceDetail = tuningPriceDetail;
    }

    @Override
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TuningFragmentDetailsListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TuningFragmentDetailsListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.tuning_fragment_details_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static TuningFragmentDetailsListBinding bind(View rootView) {
        int i = R.id.back_to_submenu_detail;
        Button button = (Button) rootView.findViewById(R.id.back_to_submenu_detail);
        if (button != null) {
            i = R.id.button_info_brake;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.button_info_brake);
            if (imageView != null) {
                i = R.id.button_reset_detail;
                Button button2 = (Button) rootView.findViewById(R.id.button_reset_detail);
                if (button2 != null) {
                    i = R.id.button_view_car_details_list;
                    Button button3 = (Button) rootView.findViewById(R.id.button_view_car_details_list);
                    if (button3 != null) {
                        i = R.id.help_view_above_list_in_detail_list;
                        View findViewById = rootView.findViewById(R.id.help_view_above_list_in_detail_list);
                        if (findViewById != null) {
                            i = R.id.help_view_in_detail_list;
                            View findViewById2 = rootView.findViewById(R.id.help_view_in_detail_list);
                            if (findViewById2 != null) {
                                i = R.id.menu_block_detail;
                                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.menu_block_detail);
                                if (linearLayout != null) {
                                    i = R.id.recv_details_list;
                                    RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recv_details_list);
                                    if (recyclerView != null) {
                                        i = R.id.title_details_list;
                                        TextView textView = (TextView) rootView.findViewById(R.id.title_details_list);
                                        if (textView != null) {
                                            i = R.id.title_price_block_details;
                                            TextView textView2 = (TextView) rootView.findViewById(R.id.title_price_block_details);
                                            if (textView2 != null) {
                                                i = R.id.tuning_price_detail;
                                                Button button4 = (Button) rootView.findViewById(R.id.tuning_price_detail);
                                                if (button4 != null) {
                                                    return new TuningFragmentDetailsListBinding((RelativeLayout) rootView, button, imageView, button2, button3, findViewById, findViewById2, linearLayout, recyclerView, textView, textView2, button4);
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
