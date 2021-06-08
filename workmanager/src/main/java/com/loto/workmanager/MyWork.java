package com.loto.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/8 下午3:11
 * @Company LotoGram
 */

public class MyWork extends Worker {

    private static final String TAG = "MyWork";

    public MyWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        //获取传进来的参数
        String name = getInputData().getString("name");
        int age = getInputData().getInt("age", 0);

        Log.d(TAG, "InputData name: " + name);
        Log.d(TAG, "InputData age: " + age);

        //执行完之后，返回数据
        Data data = new Data.Builder()
                .putString("info", "name: " + name + "    age: " + age)
                .build();
        return Result.success(data);
    }
}
