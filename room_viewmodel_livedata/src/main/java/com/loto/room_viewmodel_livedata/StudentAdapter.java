package com.loto.room_viewmodel_livedata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.loto.room_viewmodel_livedata.databinding.ItemStudentBinding;

import java.util.List;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 下午4:49
 * @Company LotoGram
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemStudentBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_student, parent, false);

        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = students.get(position);
        holder.binding.setStudent(student);
        holder.binding.executePendingBindings();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    protected static class StudentViewHolder extends RecyclerView.ViewHolder {

        private ItemStudentBinding binding;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public StudentViewHolder(ItemStudentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
