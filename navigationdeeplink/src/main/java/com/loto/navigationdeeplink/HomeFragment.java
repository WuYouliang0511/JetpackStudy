package com.loto.navigationdeeplink;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/7 上午11:17
 * @Company LotoGram
 */

public class HomeFragment extends Fragment {

    private int id;

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
            sendNotification();
        });
    }

    private void sendNotification() {
        //通知渠道
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(getActivity().getPackageName(), "mychannel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("my NotificationChannel");
            NotificationManager manager = getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        Notification notification = new NotificationCompat.Builder(getActivity(), getActivity().getPackageName())
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Deep Link")
                .setContentText("点击我试试")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(getPendingIntent())
                .setAutoCancel(true)
                .build();

        NotificationManagerCompat compat = NotificationManagerCompat.from(getActivity());
        compat.notify(id++, notification);
    }

    private PendingIntent getPendingIntent() {
        return Navigation.findNavController(getActivity(), R.id.button)
                .createDeepLink()
                .setGraph(R.navigation.navigation)
                .setDestination(R.id.detailFragment)
                .createPendingIntent();
    }


}
