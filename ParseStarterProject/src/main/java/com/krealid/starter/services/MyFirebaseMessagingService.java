package com.krealid.starter.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.krealid.starter.MainActivity;
import com.krealid.starter.R;

/**
 * Created by Maxime on 24/11/2016.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        NotificationManager nm = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(),0,notificationIntent,0);

        //set
        builder.setContentIntent(contentIntent);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setSmallIcon(R.drawable.newlogosaintrieul);
        } else {
            builder.setSmallIcon(R.drawable.ic_launcher);
        }

        builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.ic_launcher));

        builder.setContentText(remoteMessage.getNotification().getBody());
        builder.setContentTitle(getApplicationContext().getString(R.string.app_name));
        builder.setAutoCancel(true);
        builder.setDefaults(Notification.DEFAULT_ALL);

        Notification notification = builder.build();
        nm.notify((int)System.currentTimeMillis(),notification);
    }
}
