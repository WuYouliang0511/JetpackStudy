package com.loto.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/8 下午4:17
 * @Company LotoGram
 */
public class BWork extends Worker {

    private String TAG = "BWork";

    public BWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d(TAG, "doWork: BWork");
        return Result.success();
    }
}