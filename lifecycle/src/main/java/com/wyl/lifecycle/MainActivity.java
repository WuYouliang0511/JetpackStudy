package com.wyl.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyChronometer chronometer = findViewById(R.id.chronometer);
        getLifecycle().addObserver(chronometer);
    }

    public void startGPS(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MyLocationService.class);
        startService(intent);
    }

    public void stopGPS(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MyLocationService.class);
        stopService(intent);
    }
}