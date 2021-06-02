package com.loto.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 下午3:30
 * @Company LotoGram
 */

@Dao
public interface StudentDao {

    @Insert
    void insertStudent(Student... student);

    @Delete
    void deleteStudent(Student... student);

    @Update
    void updateStudent(Student... student);

    @Query("SELECT * FROM student")
    List<Student> getAllStudent();

    @Query("SELECT * FROM student WHERE id = :id")
    List<Student> getStudentById(int id);
}
