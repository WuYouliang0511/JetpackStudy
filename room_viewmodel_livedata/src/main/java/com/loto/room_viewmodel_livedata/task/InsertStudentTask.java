package com.loto.room_viewmodel_livedata.task;

import android.os.AsyncTask;

import com.loto.room_viewmodel_livedata.Student;
import com.loto.room_viewmodel_livedata.StudentDao;

public class InsertStudentTask extends AsyncTask<Student, Void, Void> {

    private final StudentDao studentDao;

    public InsertStudentTask(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    protected Void doInBackground(Student... students) {
        studentDao.insert(students);
        return null;
    }
}