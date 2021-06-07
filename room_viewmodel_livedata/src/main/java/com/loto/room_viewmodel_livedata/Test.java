package com.loto.room_viewmodel_livedata;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/3 上午10:34
 * @Company LotoGram
 */

public class Test {

    public static void main(String[] args) {
        Student student = new Student("邬友亮", 23);

        ff(student);


        System.out.println(student.getAge());

    }

    public static void ff(Student student) {

        student.setAge(100);
    }
}
