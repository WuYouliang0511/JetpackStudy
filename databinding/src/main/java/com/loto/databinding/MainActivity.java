package com.loto.databinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.loto.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("二级页面的绑定");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        Idol idol = new Idol("https://i1.hdslb.com/bfs/face/358d6e0c91672681c53a4e35016bb8ba031e732c.jpg@96w_96h_1c.jpg", "wuyoul ", 5);

        binding.setIdol(idol);
    }
}