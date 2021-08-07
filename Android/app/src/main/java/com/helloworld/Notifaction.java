package com.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Notifaction extends AppCompatActivity {

    private NotificationManager manager;
    private  Notification notifaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifaction);

        Intent intent = getIntent();

        String value = intent.getStringExtra(MainActivity.paramKey);
        Log.e("Notifiction", "onCreate: "+ value);

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

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void sendNotifaction(View view) {

        manager.notify(1, notifaction);
    }

    public void cancelNotifaction(View view) {

        manager.cancel(1);
    }







}
