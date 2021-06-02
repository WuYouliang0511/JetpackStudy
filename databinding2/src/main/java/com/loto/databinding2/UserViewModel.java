package com.loto.databinding2;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 上午11:11
 * @Company LotoGram
 */

public class UserViewModel extends BaseObservable {

    private User user;

    public UserViewModel() {
        this.user = new User("邬友亮");
    }

    @Bindable
    public String getName() {
        Log.d("UserViewModel", "getName: ");
        return user.name;
    }

    public void setName(String userName) {
        user.name = userName;
        notifyPropertyChanged(BR.name);
    }
}
