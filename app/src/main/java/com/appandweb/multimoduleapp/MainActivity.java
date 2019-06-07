package com.appandweb.multimoduleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.appandweb.multimoduleapp.library.LibActivity;
import com.appandweb.multimoduleapp.library.Library;
import com.appandweb.multimoduleapp.mock.FakePushMessage;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btnNavigate = findViewById(R.id.btnNavigate);
        Button btnReceiveNotification = findViewById(R.id.btnNotification);
        Button btnToken = findViewById(R.id.btnToken);

        btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToScreen2();
            }
        });

        btnReceiveNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Library.onNotificationReceived(new FakePushMessage());
            }
        });

        btnToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean hasBeenInitialized = false;
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setApplicationId(BuildConfig.AppFirebaseId)
                        .setApiKey(BuildConfig.AppFirebaseApiKey)
                        .setDatabaseUrl(BuildConfig.AppFirebaseDatabaseUrl)
                        .build();
                List<FirebaseApp> firebaseApps = FirebaseApp.getApps(getApplicationContext());
                for (FirebaseApp app : firebaseApps) {
                    if (app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                        hasBeenInitialized = true;
                    }
                }
                if (!hasBeenInitialized) {
                    FirebaseApp.initializeApp(getApplicationContext(), options);
                }

                String token = FirebaseInstanceId.getInstance().getToken();
                Toast.makeText(MainActivity.this, token, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void navigateToScreen2() {
        Intent intent = new Intent(this, LibActivity.class);
        startActivity(intent);
    }
}
