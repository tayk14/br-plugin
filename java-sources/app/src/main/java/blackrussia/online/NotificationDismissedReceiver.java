package blackrussia.online;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.rockstargames.gtacr.gui.inventory.GetKeys;

/* loaded from: classes.dex */
public class NotificationDismissedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(GetKeys.GET_PLAYERS_ID);
        if (stringExtra != null) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(App.getInstance());
            Bundle bundle = new Bundle();
            bundle.putString("dismiss", stringExtra);
            firebaseAnalytics.logEvent("push", bundle);
        }
    }
}
