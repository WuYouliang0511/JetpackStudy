package com.loto.mvvm;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.loto.mvvm.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";

    private MyViewModel myViewModel;
    private ActivityMainBinding binding;
    private int a;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("MainActivity", "onNewIntent");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("MainActivity", "onConfigurationChanged: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "onCreate:");
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //LiveData想要实现双向绑定功能，必须要加
        binding.setLifecycleOwner(this);

        myViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        binding.text.setText(String.valueOf(myViewModel.number));
        binding.setViewModel(myViewModel);
        myViewModel.getCurrentSecond().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.text.setText(String.valueOf(integer));
            }
        });
//        start();

        Fragment1 fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);


        if (fragment1.myViewModel.equals(fragment2.myViewModel)) {
            Log.d(TAG, "fragment1.myViewModel == fragment2.myViewModel");
        }
    }

    private void start() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myViewModel.getCurrentSecond().postValue(myViewModel.getCurrentSecond().getValue() + 1);
            }
        }, 1000, 1000);
    }


    public void add(View view) {
        binding.text.setText(String.valueOf(++myViewModel.number));
        myViewModel.getAaa().setValue(myViewModel.getAaa().getValue() + 1);
    }
}