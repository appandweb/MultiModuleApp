package com.appandweb.multimoduleapp.library.model;

public interface AbsPushMessage {
    boolean hasData();

    boolean contains(String key);

    String getData(String key);
}
