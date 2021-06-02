package com.loto.room_viewmodel_livedata;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.loto.room_viewmodel_livedata.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private StudentDao studentDao;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        ArrayList<Student> students = new ArrayList<>();
        adapter = new StudentAdapter(students);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        binding.recyclerView.setLayoutManager(manager);

        MyDataBase myDataBase = MyDataBase.getInstance(this);
        studentDao = myDataBase.getStudentDao();
    }

    public void insert(View view) {
        Student student0 = new Student("邬友亮0", 20);
        Student student1 = new Student("邬友亮1", 21);
        //new InsertStudentTask(studentDao).execute(student0, student1);
    }

    public void get(View view) {
        //new GetAllStudentTask(studentDao).execute();
    }


}