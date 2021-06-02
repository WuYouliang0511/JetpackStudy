package com.loto.databinding2;

import android.util.Log;

import androidx.databinding.ObservableField;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 上午11:44
 * @Company LotoGram
 */

public class UserViewModel2 {

    private ObservableField<User> userObservableField;

    public UserViewModel2() {
        User user = new User("邬友亮2");
        userObservableField = new ObservableField<>();
        userObservableField.set(user);
    }

    public String getUserName() {
        return userObservableField.get().name;
    }

    public void setUserName(String userName) {
        Log.d("UserViewModel2", "setUserName:" + userName);
        userObservableField.get().name = userName;
    }
}