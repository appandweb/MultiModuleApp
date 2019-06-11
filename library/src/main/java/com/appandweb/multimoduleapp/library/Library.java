package com.appandweb.multimoduleapp.library;

import android.content.Context;
import com.appandweb.multimoduleapp.library.fcm.GetFCMToken;
import com.appandweb.multimoduleapp.library.fcm.GetFcmTokenImpl;
import com.appandweb.multimoduleapp.library.model.AbsPushMessage;
import com.appandweb.multimoduleapp.library.model.MMNotification;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.lang.ref.WeakReference;
import java.util.List;

public class Library {
    static GetFCMToken getFCMToken = new GetFcmTokenImpl();
    static WeakReference<Context> contextRef;
    static WeakReference<View> viewRef;
    static FirebaseApp firebaseApp;

    public static void initialize(Context context) {
        contextRef = new WeakReference<>(context);

        boolean hasBeenInitialized = false;
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setApplicationId(BuildConfig.LibraryFirebaseId)
                .setApiKey(BuildConfig.LibraryFirebaseApiKey)
                .setDatabaseUrl(BuildConfig.LibraryFirebaseDatabaseUrl)
                .build();
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps(context);
        for (FirebaseApp app : firebaseApps) {
            if (app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                firebaseApp = app;
                hasBeenInitialized = true;
            }
        }
        if (!hasBeenInitialized) {
            FirebaseApp.initializeApp(context.getApplicationContext(), options);
        }
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

    public static void setDependencies(GetFCMToken getFCMToken, View view) {
        Library.getFCMToken = getFCMToken;
        Library.viewRef = new WeakReference(view);
    }

    public interface View {
        void showNotification(MMNotification notification);
    }
}
