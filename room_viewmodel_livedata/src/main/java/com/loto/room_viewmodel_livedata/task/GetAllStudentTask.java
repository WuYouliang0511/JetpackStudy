package com.loto.room_viewmodel_livedata.task;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.loto.room_viewmodel_livedata.Student;
import com.loto.room_viewmodel_livedata.StudentDao;

import java.util.List;

public class GetAllStudentTask extends AsyncTask<Void, Void, LiveData<List<Student>>> {

    private final StudentDao studentDao;
    private LiveData<List<Student>> result;

    public GetAllStudentTask(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    //预操作在execute()前自动调用，用于界面的初始化操作
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    //执行任务，非UI线程，不能更改UI组建的信息
    @Override
    protected LiveData<List<Student>> doInBackground(Void... voids) {
        result = studentDao.getAll();
        publishProgress(voids);
        return null;
    }

    //在主线程，显示任务进度，调用publishProgress()时会自动调用
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    //接受线程执行的结果，将执行的结果显示到UI组件上
    //线程结束时自动调用
    @Override
    protected void onPostExecute(LiveData<List<Student>> listLiveData) {
        super.onPostExecute(listLiveData);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected void onCancelled(LiveData<List<Student>> listLiveData) {
        super.onCancelled(listLiveData);
    }
}