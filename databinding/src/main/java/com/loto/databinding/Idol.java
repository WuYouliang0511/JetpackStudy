package com.loto.databinding;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 上午10:14
 * @Company LotoGram
 */

public class Idol {

    private String touxiang;
    private String name;
    private int start;

    public Idol(String touxiang, String name, int start) {
        this.touxiang = touxiang;
        this.name = name;
        this.start = start;
    }

    public String getTouxiang() {
        return touxiang;
    }

    public void setTouxiang(String touxiang) {
        this.touxiang = touxiang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
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
