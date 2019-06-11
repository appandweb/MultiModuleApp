package com.appandweb.multimoduleapp.library.common;

public interface AbsPushMessage {
    boolean hasData();

    boolean contains(String key);

    String getData(String key);
}
