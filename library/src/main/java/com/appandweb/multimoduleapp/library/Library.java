package com.appandweb.multimoduleapp.library;

import android.content.Context;
import com.appandweb.multimoduleapp.library.fcm.GetFCMToken;
import com.appandweb.multimoduleapp.library.fcm.GetFcmTokenImpl;
import com.appandweb.multimoduleapp.library.model.AbsPushMessage;
import com.appandweb.multimoduleapp.library.model.MMNotification;

public class Library {
    static GetFCMToken getFCMToken;
    static View view;

    private Library() {
        view = new AndroidView();
        getFCMToken = new GetFcmTokenImpl();
    }

    public static void initialize(Context context) {
        String token = getFCMToken.getFcmToken();
        token.toString();
    }

    public static void onNotificationReceived(AbsPushMessage pushMessage) {
        view.showNotification(createNotificationFromData(pushMessage));
    }

    private static MMNotification createNotificationFromData(AbsPushMessage pushMessage) {
        MMNotification notification = new MMNotification();
        notification.setTitle(pushMessage.getData("title"));
        notification.setText(pushMessage.getData("text"));
        return notification;
    }

    public static void setDependencies(GetFCMToken getFCMToken, View view) {
        Library.getFCMToken = getFCMToken;
        Library.view = view;
    }

    public interface View {
        void showNotification(MMNotification notification);
    }
}
