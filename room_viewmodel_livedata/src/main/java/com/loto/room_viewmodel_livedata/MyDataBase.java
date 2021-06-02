package com.loto.room_viewmodel_livedata;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 下午4:26
 * @Company LotoGram
 */

@Database(entities = Student.class, version = 1, exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {

    private static volatile MyDataBase instance;

    public static MyDataBase getInstance(Context context) {
        if (instance == null) {
            synchronized (MyDataBase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            MyDataBase.class,
                            "dataBaseName")
                            //.allowMainThreadQueries()//允许在主线程进行数据库的增删改查，不建议这么做(耗时操作造成ANR)
                            .build();
                }
            }
        }
        return instance;
    }

    public abstract StudentDao getStudentDao();
}
