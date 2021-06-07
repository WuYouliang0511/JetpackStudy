package com.loto.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/7 上午11:17
 * @Company LotoGram
 */

public class DetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getView() == null) return;
        Button button = getView().findViewById(R.id.button);

        HomeFragmentArgs bundle = HomeFragmentArgs.fromBundle(getArguments());
        Toast.makeText(getContext(), bundle.getAge() + bundle.getUserName(), Toast.LENGTH_LONG).show();


        button.setOnClickListener(v -> {
            NavController navigation = Navigation.findNavController(v);
            navigation.navigate(R.id.action_detailFragment_to_homeFragment);
        });
    }
}
