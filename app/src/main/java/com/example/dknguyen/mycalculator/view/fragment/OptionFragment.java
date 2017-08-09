package com.example.dknguyen.mycalculator.view.fragment;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RemoteViews;

import com.example.dknguyen.mycalculator.R;
import com.example.dknguyen.mycalculator.base.BaseFragment;

/**
 * Created by dknguyen on 7/13/2017.
 */

public class OptionFragment extends BaseFragment {

    private NotificationManager mNotificationManager;

    private void buildNotification() {
//        RemoteViews contentView = new RemoteViews(getActivity().getPackageName(), R.layout.custom_head_up_notification);
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext());
//                .setCustomHeadsUpContentView(contentView)
        builder.setSmallIcon(R.mipmap.ic_launcher) //ok
                .setContentTitle("Idex Application")
                .setContentText("Loading...");

        if (Build.VERSION.SDK_INT >= 21) builder.setVibrate(new long[]{Notification.DEFAULT_VIBRATE}).setPriority(Notification.PRIORITY_HIGH);
        mNotificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, builder.build());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("NGUYENDK", "OptionFragment onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("NGUYENDK", "OptionFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d("NGUYENDK", "OptionFragment onCreateView");
        return inflater.inflate(R.layout.fragment_option, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnNotification = (Button) view.findViewById(R.id.btn_Notification);
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildNotification();
            }
        });
        Log.d("NGUYENDK", "OptionFragment onViewCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("NGUYENDK", "OptionFragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("NGUYENDK", "OptionFragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("NGUYENDK", "OptionFragment onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("NGUYENDK", "OptionFragment onDestroy");
    }
}
