package com.appandweb.multimoduleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.appandweb.multimoduleapp.library.common.LibActivity;
import com.appandweb.multimoduleapp.library.common.Library;
import com.appandweb.multimoduleapp.library.features.products.ProductsActivity;
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

        Button btnNavigateLib = findViewById(R.id.btnNavigateLib);
        Button btnNavigateProducts = findViewById(R.id.btnNavigateProducts);
        Button btnReceiveNotification = findViewById(R.id.btnNotification);
        Button btnToken = findViewById(R.id.btnToken);
        final TextView tvToken = findViewById(R.id.tvToken);

        btnNavigateLib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToScreen2();
            }
        });
        btnNavigateProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToScreen3();
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
                tvToken.setText(token);
            }
        });
    }

    private void navigateToScreen2() {
        Intent intent = new Intent(this, LibActivity.class);
        startActivity(intent);
    }

    private void navigateToScreen3() {
        Intent intent = new Intent(this, ProductsActivity.class);
        startActivity(intent);
    }
}
