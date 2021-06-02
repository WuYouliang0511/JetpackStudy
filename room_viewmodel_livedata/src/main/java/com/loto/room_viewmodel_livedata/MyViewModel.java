package com.loto.room_viewmodel_livedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 下午5:41
 * @Company LotoGram
 */
public class MyViewModel extends AndroidViewModel {

    private StudentRepository repository;


    public MyViewModel(@NonNull Application application) {
        super(application);
        this.repository = new StudentRepository(application);
    }

    public void insertStudent(Student... students) {
        repository.insertStudent(students);
    }
}
