package com.loto.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.loto.recyclerview.databinding.ItemIdolBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 下午1:56
 * @Company LotoGram
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<Idol> idols;

    public RecyclerViewAdapter(ArrayList<Idol> idols) {
        this.idols = idols;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemIdolBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_idol, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        Idol idol = idols.get(position);
        holder.binding.setIdol(idol);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return idols.size();
    }

    protected static class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemIdolBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public MyViewHolder(@NotNull ItemIdolBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ItemIdolBinding getBinding() {
            return binding;
        }
    }
}
