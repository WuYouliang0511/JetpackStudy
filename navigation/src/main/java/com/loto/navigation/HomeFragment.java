package com.loto.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getView() == null) return;
        Button button = getView().findViewById(R.id.button);

        button.setOnClickListener(v -> {

            Bundle bundle = new HomeFragmentArgs.Builder()
                    .setAge(23)
                    .setUserName("邬友亮")
                    .build()
                    .toBundle();

            NavController navigation = Navigation.findNavController(v);
            navigation.navigate(R.id.action_homeFragment_to_detailFragment, bundle);

//            getActivity().setTitle("aaaaa");
        });
    }


}
