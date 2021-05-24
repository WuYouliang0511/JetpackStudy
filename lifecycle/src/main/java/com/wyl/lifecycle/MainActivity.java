package com.wyl.lifecycle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyChronometer chronometer = findViewById(R.id.chronometer);
        getLifecycle().addObserver(chronometer);
    }
}