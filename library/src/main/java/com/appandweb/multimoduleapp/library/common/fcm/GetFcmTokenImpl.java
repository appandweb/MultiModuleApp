package com.appandweb.multimoduleapp.library.common.fcm;

import com.google.firebase.iid.FirebaseInstanceId;

public class GetFcmTokenImpl implements GetFCMToken {
    @Override
    public String getFcmToken() {
        return FirebaseInstanceId.getInstance().getToken();
    }
}
