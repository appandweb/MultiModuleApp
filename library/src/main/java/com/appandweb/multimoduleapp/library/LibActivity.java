package com.appandweb.multimoduleapp.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.List;

public class LibActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lib);

        boolean hasBeenInitialized = false;
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setApplicationId(BuildConfig.LibraryFirebaseId)
                .setApiKey(BuildConfig.LibraryFirebaseApiKey)
                .setDatabaseUrl(BuildConfig.LibraryFirebaseDatabaseUrl)
                .build();
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps(this);
        for (FirebaseApp app : firebaseApps) {
            if (app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                hasBeenInitialized = true;
            }
        }
        if (!hasBeenInitialized) {
            FirebaseApp.initializeApp(this, options);
        }
        String token2 = FirebaseInstanceId.getInstance().getToken();
        Toast.makeText(this, token2, Toast.LENGTH_LONG).show();
    }
}
