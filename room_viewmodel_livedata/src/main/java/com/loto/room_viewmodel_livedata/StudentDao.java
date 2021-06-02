package com.loto.room_viewmodel_livedata;

import androidx.lifecycle.LiveData;
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
    void insert(Student... student);

    @Delete
    void delete(Student... student);

    @Query("DELETE FROM student")
    void deleteAll(Student... student);

    @Update
    void update(Student... student);

    @Query("SELECT * FROM student")
    LiveData<List<Student>> getAll();

    @Query("SELECT * FROM student WHERE id = :id")
    LiveData<List<Student>> getById(int id);
}
