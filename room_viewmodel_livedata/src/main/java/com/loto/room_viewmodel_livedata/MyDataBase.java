package com.loto.room_viewmodel_livedata;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 下午4:26
 * @Company LotoGram
 */

//exportSchema = true 默认为true  配置信息见gradle  javaCompileOptions
@Database(entities = Student.class, version = 2, exportSchema = true)
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
                            //将数据库从版本1升级到版本2的策略
                            //如果从1升级到3，则会优先应用1-3的升级策略
                            //如果没有，则1-2，2-3升级
                            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                            //数据库升级异常处理
                            //如数据库降级
                            //如从1升级到4，但是没有1-4的策略
                            //如果添加该方法，异常时数据库表重建，同时数据丢失
                            .fallbackToDestructiveMigration()
                            //允许在主线程进行数据库的增删改查
                            //不建议这么做(耗时操作造成ANR)
                            //.allowMainThreadQueries()
                            //从asset文件预加载数据
                            .createFromAsset("prestudent.db")
                            .build();
                }
            }
        }
        return instance;
    }

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE student ADD COLUMN sex INTEGER NOT NULL DEFAULT 1");
        }
    };

    private static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE student ADD COLUMN sex INTEGER NOT NULL DEFAULT 1");
        }
    };

    public abstract StudentDao getStudentDao();
}