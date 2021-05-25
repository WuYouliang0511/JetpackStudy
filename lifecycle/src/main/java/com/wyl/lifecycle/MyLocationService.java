package com.wyl.lifecycle;


import android.util.Log;

import androidx.lifecycle.LifecycleService;

public class MyLocationService extends LifecycleService {

    public MyLocationService() {
        Log.d("MyLocationService", "MyLocationService: ");
        MyLocationObserver observer = new MyLocationObserver(this);
        getLifecycle().addObserver(observer);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
