package com.loto.workmanager;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addTask(View view) {
        //任务链，任务组合：
        //A、B----\
        //         ----E----
        //C、D----/
        OneTimeWorkRequest requestA = new OneTimeWorkRequest.Builder(AWork.class).build();
        OneTimeWorkRequest requestB = new OneTimeWorkRequest.Builder(BWork.class).build();
        OneTimeWorkRequest requestC = new OneTimeWorkRequest.Builder(CWork.class).build();
        OneTimeWorkRequest requestD = new OneTimeWorkRequest.Builder(DWork.class).build();
        OneTimeWorkRequest requestE = new OneTimeWorkRequest.Builder(EWork.class).build();

        WorkContinuation workContinuation1 = WorkManager.getInstance(this)
                .beginWith(requestA)
                .then(requestB);

        WorkContinuation workContinuation2 = WorkManager.getInstance(this)
                .beginWith(requestC)
                .then(requestD);

        List<WorkContinuation> list = new ArrayList<>();
        list.add(workContinuation1);
        list.add(workContinuation2);

        WorkContinuation.combine(list)
                .then(requestE)
                .enqueue();
    }
}