package com.loto.room_viewmodel_livedata;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.loto.room_viewmodel_livedata.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private StudentDao studentDao;
    private StudentAdapter adapter;

    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);


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
        viewModel.insertStudent(student0, student1);
    }

    public void get(View view) {
        //new GetAllStudentTask(studentDao).execute();
    }


}