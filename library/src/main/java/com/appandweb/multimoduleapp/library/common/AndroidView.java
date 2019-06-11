package com.appandweb.multimoduleapp.library.common;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import com.appandweb.multimoduleapp.library.BuildConfig;

import java.lang.ref.WeakReference;

class AndroidView implements Library.View {
    private static final String GROUP_NOTIFICATIONS = "notifications";
    private static final int NOTIFICATION_ID = 1234;

    WeakReference<Context> contextRef;

    public AndroidView(WeakReference<Context> contextRef) {
        this.contextRef = contextRef;
    }

    @Override
    public void showNotification(MMNotification notification) {
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(contextRef.get());

        int iconResId = android.R.drawable.ic_menu_zoom;
        Bitmap bmp = BitmapFactory.decodeResource(contextRef.get().getResources(), iconResId);
        NotificationCompat.WearableExtender wearableExtender =
                new NotificationCompat.WearableExtender()
                        .setBackground(bmp);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(contextRef.get())
                        .setSmallIcon(iconResId)
                        .setContentTitle(notification.getTitle())
                        .setContentText(notification.getText())
                        .setAutoCancel(true)
                        .setGroup(GROUP_NOTIFICATIONS)
                        .setGroupSummary(true)
                        .setSound(alarmSound)
                        .extend(wearableExtender)
                        .setVibrate(getVibrationPattern())
                        .setLights(Color.RED, 3000, 3000);

        Intent notIntent = new Intent(contextRef.get().getApplicationContext(), LibActivity.class);
        notIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent contIntent = PendingIntent.getActivity(
                contextRef.get(), 0, notIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        mBuilder.setContentIntent(contIntent);
        Notification androidNotification = mBuilder.build();

        notificationManager.notify(BuildConfig.APPLICATION_ID, NOTIFICATION_ID, androidNotification);
    }

    private long[] getVibrationPattern() {
        long[] pattern = new long[]{0, 1000};

        return pattern;
    }
}
