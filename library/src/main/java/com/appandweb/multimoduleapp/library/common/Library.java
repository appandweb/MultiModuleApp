package com.appandweb.multimoduleapp.library.common;

import android.content.Context;
import com.appandweb.multimoduleapp.library.common.fcm.GetFCMToken;
import com.appandweb.multimoduleapp.library.common.fcm.GetFcmTokenImpl;

import java.lang.ref.WeakReference;

public class Library {
    static GetFCMToken getFCMToken = new GetFcmTokenImpl();
    static WeakReference<Context> contextRef;
    static WeakReference<View> viewRef = new WeakReference(new NullView());

    public static void initialize(Context context) {
        contextRef = new WeakReference<>(context.getApplicationContext());

        getFCMToken.getFcmToken();
    }

    public static void onNotificationReceived(AbsPushMessage pushMessage) {
        viewRef.get().showNotification(createNotificationFromData(pushMessage));
    }

    private static MMNotification createNotificationFromData(AbsPushMessage pushMessage) {
        MMNotification notification = new MMNotification();
        notification.setTitle(pushMessage.getData("title"));
        notification.setText(pushMessage.getData("text"));
        return notification;
    }

    static void setDependencies(GetFCMToken getFCMToken, View view) {
        Library.getFCMToken = getFCMToken;
        Library.viewRef = new WeakReference(view != null ? view : new NullView());
    }

    private static class NullView implements View {
        @Override
        public void showNotification(MMNotification notification) {
            /* Empty */
        }
    }

    interface View {
        void showNotification(MMNotification notification);
    }
}
