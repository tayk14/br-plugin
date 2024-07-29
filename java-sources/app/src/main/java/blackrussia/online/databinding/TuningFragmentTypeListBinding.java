package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class TuningFragmentTypeListBinding implements ViewBinding {
    public final Button buttonViewCarType;
    public final RecyclerView recvTypeTuningList;
    private final RelativeLayout rootView;
    public final RelativeLayout typeViewMain;

    private TuningFragmentTypeListBinding(RelativeLayout rootView, Button buttonViewCarType, RecyclerView recvTypeTuningList, RelativeLayout typeViewMain) {
        this.rootView = rootView;
        this.buttonViewCarType = buttonViewCarType;
        this.recvTypeTuningList = recvTypeTuningList;
        this.typeViewMain = typeViewMain;
    }

    @Override
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TuningFragmentTypeListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TuningFragmentTypeListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.tuning_fragment_type_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static TuningFragmentTypeListBinding bind(View rootView) {
        int i = R.id.button_view_car_type;
        Button button = (Button) rootView.findViewById(R.id.button_view_car_type);
        if (button != null) {
            i = R.id.recv_type_tuning_list;
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recv_type_tuning_list);
            if (recyclerView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) rootView;
                return new TuningFragmentTypeListBinding(relativeLayout, button, recyclerView, relativeLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
