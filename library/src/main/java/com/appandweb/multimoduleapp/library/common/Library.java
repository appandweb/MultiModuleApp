package com.appandweb.multimoduleapp.library.common;

import android.content.Context;
import com.appandweb.multimoduleapp.library.common.fcm.GetFCMToken;
import com.appandweb.multimoduleapp.library.common.fcm.GetFcmTokenImpl;
import com.appandweb.multimoduleapp.library.common.permission.CheckPermission;
import com.appandweb.multimoduleapp.library.common.permission.CheckPermissionImpl;

import java.lang.ref.WeakReference;

public class Library {
    static WeakReference<Context> contextRef;
    static GetFCMToken getFCMToken = new GetFcmTokenImpl();
    static View nullView = new NullView();
    static CheckPermission checkPermission = new CheckPermissionImpl(contextRef);
    static WeakReference<View> viewRef = new WeakReference(nullView);

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

    static void setDependencies(GetFCMToken getFCMToken, CheckPermission checkPermission, View view) {
        Library.getFCMToken = getFCMToken;
        Library.checkPermission = checkPermission;
        Library.viewRef = new WeakReference(view != null ? view : new NullView());
    }

    /**
     * https://en.wikipedia.org/wiki/Null_object_pattern
     */
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
