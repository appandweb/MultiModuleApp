package com.appandweb.multimoduleapp.library.common;

import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;
import java.util.Map;

public class PushMessage implements AbsPushMessage {
    RemoteMessage remoteMessage;
    Map<String, String> data;

    public PushMessage(RemoteMessage remoteMessage) {
        this.remoteMessage = remoteMessage;
        this.data = new HashMap<>();

        if (hasData()) {
            for (String key : remoteMessage.getData().keySet()) {
                data.put(key, remoteMessage.getData().get(key));
            }
        }
    }

    @Override
    public boolean hasData() {
        return remoteMessage != null && remoteMessage.getData() != null && remoteMessage.getData().size() > 0;
    }

    @Override
    public boolean contains(String key) {
        return remoteMessage.getData().containsKey(key);
    }

    @Override
    public String getData(String key) {
        return data.get(key);
    }
}
