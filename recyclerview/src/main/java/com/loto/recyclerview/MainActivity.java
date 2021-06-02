package com.loto.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.loto.recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        ArrayList<Idol> idols = new ArrayList<>();

        idols.add(new Idol("aaa",12,"https://i1.hdslb.com/bfs/face/358d6e0c91672681c53a4e35016bb8ba031e732c.jpg@96w_96h_1c.jpg"));
        idols.add(new Idol("aaa",12,"https://i1.hdslb.com/bfs/face/358d6e0c91672681c53a4e35016bb8ba031e732c.jpg@96w_96h_1c.jpg"));


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(idols);

        binding.aaa.setAdapter(adapter);

    }
}