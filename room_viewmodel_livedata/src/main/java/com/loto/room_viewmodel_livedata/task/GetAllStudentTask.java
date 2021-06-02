package com.loto.room_viewmodel_livedata.task;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.loto.room_viewmodel_livedata.Student;
import com.loto.room_viewmodel_livedata.StudentDao;

import java.util.List;

public class GetAllStudentTask extends AsyncTask<Void, Void, Void> {

    private final StudentDao studentDao;

    public GetAllStudentTask(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        LiveData<List<Student>> students = studentDao.getAll();

        publishProgress(voids);
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

    }
}