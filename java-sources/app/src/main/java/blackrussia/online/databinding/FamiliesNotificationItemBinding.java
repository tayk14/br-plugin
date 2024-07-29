package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesNotificationItemBinding implements ViewBinding {
    public final TextView notificationsAuthor;
    public final TextView notificationsValue;
    private final ConstraintLayout rootView;

    private FamiliesNotificationItemBinding(ConstraintLayout rootView, TextView notificationsAuthor, TextView notificationsValue) {
        this.rootView = rootView;
        this.notificationsAuthor = notificationsAuthor;
        this.notificationsValue = notificationsValue;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesNotificationItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesNotificationItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_notification_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesNotificationItemBinding bind(View rootView) {
        int i = R.id.notifications_author;
        TextView textView = (TextView) rootView.findViewById(R.id.notifications_author);
        if (textView != null) {
            i = R.id.notifications_value;
            TextView textView2 = (TextView) rootView.findViewById(R.id.notifications_value);
            if (textView2 != null) {
                return new FamiliesNotificationItemBinding((ConstraintLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
