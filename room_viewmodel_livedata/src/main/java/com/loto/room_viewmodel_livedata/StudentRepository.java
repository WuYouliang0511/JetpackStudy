package com.loto.room_viewmodel_livedata;

import android.content.Context;

import com.loto.room_viewmodel_livedata.task.InsertStudentTask;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 下午5:39
 * @Company LotoGram
 */

public class StudentRepository {

    private final StudentDao studentDao;

    public StudentRepository(Context context) {
        MyDataBase dataBase = MyDataBase.getInstance(context);
        this.studentDao = dataBase.getStudentDao();
    }

    public void insert(Student... student) {
        InsertStudentTask task = new InsertStudentTask(studentDao);
        task.execute(student);
    }

    public void delete(Student... students) {

    }

    public void deleteAll() {

    }

    public void update(Student... students) {

    }

    public void getAll() {

    }

    public void getById(int id) {

    }
}
