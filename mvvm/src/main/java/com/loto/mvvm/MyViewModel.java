package com.loto.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/1 下午3:47
 * @Company LotoGram
 */

public class MyViewModel extends ViewModel {

    public int number;

    public MutableLiveData<Integer> aaa;

    private MutableLiveData<Integer> currentSecond;

    public MutableLiveData<Integer> getCurrentSecond() {
        if (currentSecond == null) {
            currentSecond = new MutableLiveData<>();
            currentSecond.setValue(0);
        }
        return currentSecond;
    }


    private MutableLiveData<Integer> progress;

    public MutableLiveData<Integer> getProgress() {
        if (progress == null) {
            progress = new MutableLiveData<>();
            progress.setValue(0);
        }
        return progress;
    }

    public MutableLiveData<Integer> getAaa() {
        if (aaa == null) {
            aaa = new MutableLiveData<>();
            aaa.setValue(0);
        }
        return aaa;
    }
}