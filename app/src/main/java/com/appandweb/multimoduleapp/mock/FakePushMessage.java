package com.appandweb.multimoduleapp.mock;

import com.appandweb.multimoduleapp.library.model.AbsPushMessage;

public class FakePushMessage implements AbsPushMessage {
    @Override
    public boolean hasData() {
        return true;
    }

    @Override
    public boolean contains(String key) {
        return true;
    }

    @Override
    public String getData(String key) {
        return "thisIsAFakePushMessage";
    }
}
