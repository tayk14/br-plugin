package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;
import com.rockstargames.gtacr.common.UIContainer;

public final class DrivingSchoolMainDialogBinding implements ViewBinding {
    public final View drivingSchoolClose;
    public final UIContainer drivingSchoolMainContainer;
    private final ConstraintLayout rootView;

    private DrivingSchoolMainDialogBinding(ConstraintLayout rootView, View drivingSchoolClose, UIContainer drivingSchoolMainContainer) {
        this.rootView = rootView;
        this.drivingSchoolClose = drivingSchoolClose;
        this.drivingSchoolMainContainer = drivingSchoolMainContainer;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DrivingSchoolMainDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DrivingSchoolMainDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.driving_school_main_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DrivingSchoolMainDialogBinding bind(View rootView) {
        int i = R.id.driving_school_close;
        View findViewById = rootView.findViewById(R.id.driving_school_close);
        if (findViewById != null) {
            i = R.id.driving_school_main_container;
            UIContainer uIContainer = (UIContainer) rootView.findViewById(R.id.driving_school_main_container);
            if (uIContainer != null) {
                return new DrivingSchoolMainDialogBinding((ConstraintLayout) rootView, findViewById, uIContainer);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
