package com.loto.workmanager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addTask(View view) {
        //出发条件
        Constraints constraints = new Constraints.Builder()
                //在待机情况下执行
                //.setRequiresDeviceIdle(true)
                //NetworkType.NOT_REQUIRED：对网络没有要求
                //NetworkType.CONNECTED：网络连接是执行
                //NetworkType.UNMETERED：不计费的网络，比如wifi下执行
                //NetworkType.NOT_ROAMING：非漫游网络状态
                //NetworkType.METERED：计费网络下执行，比如3g、4g、5g
                //CONNECTED不代表网络回复了就立马执行
                .setRequiredNetworkType(NetworkType.CONNECTED)
                //要求不在低电量的情况下
                .setRequiresBatteryNotLow(true)
                //在充电情况下执行
                .setRequiresCharging(true)
                //在手机存储充足的情况下执行
                .setRequiresStorageNotLow(true)
                .build();

        Data data = new Data.Builder()
                .putString("name", "邬友亮")
                .putInt("age", 24)
                .build();

        //配制任务
        //1、一次性执行的任务
        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(MyWork.class)
                //设置出发条件
                .setConstraints(constraints)
                //设置延迟执行
                .setInitialDelay(5, TimeUnit.SECONDS)
                //指数退避策略:任务失败
                .setBackoffCriteria(BackoffPolicy.LINEAR, Duration.ofSeconds(2))
                //设置Tag标签
                .addTag("MyWork1")
                //参数传递
                .setInputData(data)
                .build();

        //2、周期性执行的任务(周期不能少于15分钟)
        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(MyWork.class, 15, TimeUnit.MINUTES)
                .build();

        //任务提交给WorkManager
        WorkManager workManager = WorkManager.getInstance(this);
        workManager.enqueue(oneTimeWorkRequest);

        //观察任务状态
        workManager.getWorkInfoByIdLiveData(oneTimeWorkRequest.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                Log.d(TAG, "onChanged: " + workInfo.toString());

                if (workInfo.getState() == WorkInfo.State.SUCCEEDED) {
                    Data result = workInfo.getOutputData();
                    Log.d(TAG, "result: " + result.getString("info"));
                }
            }
        });

//        //取消任务
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                workManager.cancelWorkById(request.getId());
//            }
//        }, 2000);
    }
}