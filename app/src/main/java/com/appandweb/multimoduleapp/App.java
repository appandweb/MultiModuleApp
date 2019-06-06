package com.appandweb.multimoduleapp;

import android.app.Application;
import com.appandweb.multimoduleapp.library.Library;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Library.initialize(getApplicationContext());
    }
}
