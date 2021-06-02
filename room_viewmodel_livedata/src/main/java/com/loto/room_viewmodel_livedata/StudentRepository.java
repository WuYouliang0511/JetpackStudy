package com.loto.room_viewmodel_livedata;

import android.content.Context;

import com.loto.room_viewmodel_livedata.task.InsertStudentTask;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 下午5:39
 * @Company LotoGram
 */

public class StudentRepository {

    private StudentDao studentDao;

    public StudentRepository(Context context) {
        MyDataBase dataBase = MyDataBase.getInstance(context);
        this.studentDao = dataBase.getStudentDao();
    }

    public void insert(Student... student) {
        InsertStudentTask task = new InsertStudentTask(studentDao);
        task.execute(student);
    }

//    @Delete
//    void delete(Student... student);
//
//    @Query("DELETE FROM student")
//    void deleteAll(Student... student);
//
//    @Update
//    void update(Student... student);
//
//    @Query("SELECT * FROM student")
//    List<Student> getAll();
//
//    @Query("SELECT * FROM student WHERE id = :id")
//    List<Student> getById(int id);
}
