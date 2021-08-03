package com.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;

public class Notifaction extends AppCompatActivity {

    private  NotificationManager  manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifaction);

         manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

//        Notification noti = new NotificationCompat().Builder

    }

    public void sendNotifaction(View view) {
    }

    public void cancelNotifaction(View view) {


    }
}