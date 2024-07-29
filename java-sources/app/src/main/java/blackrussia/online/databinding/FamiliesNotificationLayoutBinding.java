package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesNotificationLayoutBinding implements ViewBinding {
    public final ImageView addNewNotification;
    public final EditText editTextNotification;
    public final RecyclerView familyNotifications;
    private final ConstraintLayout rootView;
    public final View titleNotification;

    private FamiliesNotificationLayoutBinding(ConstraintLayout rootView, ImageView addNewNotification, EditText editTextNotification, RecyclerView familyNotifications, View titleNotification) {
        this.rootView = rootView;
        this.addNewNotification = addNewNotification;
        this.editTextNotification = editTextNotification;
        this.familyNotifications = familyNotifications;
        this.titleNotification = titleNotification;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesNotificationLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesNotificationLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_notification_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesNotificationLayoutBinding bind(View rootView) {
        int i = R.id.add_new_notification;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.add_new_notification);
        if (imageView != null) {
            i = R.id.edit_text_notification;
            EditText editText = (EditText) rootView.findViewById(R.id.edit_text_notification);
            if (editText != null) {
                i = R.id.family_notifications;
                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.family_notifications);
                if (recyclerView != null) {
                    i = R.id.title_notification;
                    View findViewById = rootView.findViewById(R.id.title_notification);
                    if (findViewById != null) {
                        return new FamiliesNotificationLayoutBinding((ConstraintLayout) rootView, imageView, editText, recyclerView, findViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
