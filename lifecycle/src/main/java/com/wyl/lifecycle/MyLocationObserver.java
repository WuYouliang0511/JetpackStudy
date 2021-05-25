package com.wyl.lifecycle;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLocationObserver implements LifecycleObserver {

    private final static String TAG = "MyLocationObserver";

    private Context context;
    private LocationManager manager;
    private MyLocationListener locationListener;

    private final String[] permissions = new String[]{


    };

    public MyLocationObserver(Context context) {
        this.context = context;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void startGetLocation() {
        Log.d(TAG, "startGetLocation");
        manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new MyLocationListener();
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 1, locationListener);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void stopGetLocation() {
        Log.d(TAG, "stopGetLocation");
        manager.removeUpdates(locationListener);
    }

    private static class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(@NonNull Location location) {
            Log.d(TAG, "onLocationChanged: ");
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }
    }
}
