package com.appandweb.multimoduleapp.library;

import android.content.Context;
import android.content.Intent;
import com.appandweb.multimoduleapp.library.fcm.GetFCMToken;

public class Library {
    static GetFCMToken getFCMToken;

    public static void initialize(Context context) {
        getFCMToken.getFcmToken();
    }

    public static void onNotificationReceived(Intent data) {

    }

    public static void setDependencies(GetFCMToken getFCMToken) {
        Library.getFCMToken = getFCMToken;
    }
}
