package blackrussia.online;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import blackrussia.online.activities.MainActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FirebaseMessaging";

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getData().size() > 0) {
            Log.d("FirebaseMessaging", "Message Notification Body: " + remoteMessage.getData());
            sendNotification(remoteMessage);
        }
    }

    private void sendNotification(RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.addFlags(67108864);
        if (data.containsKey(GetKeys.GET_PLAYERS_ID)) {
            intent.putExtra(GetKeys.GET_PLAYERS_ID, data.get(GetKeys.GET_PLAYERS_ID));
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(getApplicationContext());
            Bundle bundle = new Bundle();
            bundle.putString("get", data.get(GetKeys.GET_PLAYERS_ID));
            firebaseAnalytics.logEvent("push", bundle);
        }
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(this, "channelId").setSmallIcon(R.drawable.logo_splash).setContentTitle(data.get("title")).setContentText(data.get("text")).setAutoCancel(true).setSound(Settings.System.DEFAULT_NOTIFICATION_URI).setContentIntent(PendingIntent.getActivity(this, 0, intent, BasicMeasure.EXACTLY));
        if (data.containsKey(GetKeys.GET_PLAYERS_ID)) {
            contentIntent.setDeleteIntent(createOnDismissedIntent(getApplicationContext(), data.get(GetKeys.GET_PLAYERS_ID)));
        }
        String str = data.get("image");
        if (str != null) {
            if (str.isEmpty()) {
                contentIntent.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.logo_splash));
            } else {
                contentIntent.setLargeIcon(getBitmapFromURL(str));
            }
        } else {
            contentIntent.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.logo_splash));
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("channelId", "channelId", 4);
            AudioAttributes build = new AudioAttributes.Builder().setUsage(5).setContentType(1).build();
            notificationChannel.setDescription("Новое сообщение");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
            notificationChannel.enableVibration(true);
            notificationChannel.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, build);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        if (Preferences.getBoolean(App.getInstance(), Preferences.NOTIFICATION, true)) {
            notificationManager.notify(0, contentIntent.build());
        }
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(src).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private PendingIntent createOnDismissedIntent(Context context, String id) {
        Intent intent = new Intent(context, (Class<?>) NotificationDismissedReceiver.class);
        intent.putExtra(GetKeys.GET_PLAYERS_ID, id);
        return PendingIntent.getBroadcast(context.getApplicationContext(), 0, intent, 0);
    }
}
