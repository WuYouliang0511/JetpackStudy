package com.loto.recyclerview;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 下午1:55
 * @Company LotoGram
 */

public class Idol {

    private String name;
    private int age;
    private String image;

    public Idol(String name, int age, String image) {
        this.name = name;
        this.age = age;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @BindingAdapter("image")
    public static void setImage(ImageView image, String url) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(image);
        } else {
            image.setBackgroundColor(Color.BLACK);
        }
    }
}
