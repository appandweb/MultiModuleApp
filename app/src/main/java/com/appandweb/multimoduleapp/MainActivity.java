package com.appandweb.multimoduleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.appandweb.multimoduleapp.library.LibActivity;
import com.appandweb.multimoduleapp.library.Library;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btnNavigate = findViewById(R.id.btnNavigate);
        Button btnReceiveNotification = findViewById(R.id.btnNotification);

        btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToScreen2();
            }
        });

        btnReceiveNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();

                Library.onNotificationReceived(data);
            }
        });
    }

    private void navigateToScreen2() {
        Intent intent = new Intent(this, LibActivity.class);
        startActivity(intent);
    }
}
