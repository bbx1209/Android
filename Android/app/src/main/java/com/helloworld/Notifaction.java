package com.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class Notifaction extends AppCompatActivity {

    private NotificationManager manager;
    private  Notification notifaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifaction);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channelid", "name", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);

        }

        notifaction = new NotificationCompat.Builder(this, "channelid")
                .setContentTitle("这是标题")
                .setContentText("通知的内容")
                .setSmallIcon(R.drawable.image)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true).build();

    }

    public void sendNotifaction(View view) {

        manager.notify(1, notifaction);
    }

    public void cancelNotifaction(View view) {

        manager.cancel(1);
    }
}
