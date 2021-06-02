package com.loto.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 下午3:24
 * @Company LotoGram
 */

@Entity(tableName = "student")
public class Student {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    private int id;

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    private String name;

    @ColumnInfo(name = "age", typeAffinity = ColumnInfo.INTEGER)
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //@Ignore 该构造方法会被room忽略，但不影响java中的使用
    @Ignore
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Ignore
    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
