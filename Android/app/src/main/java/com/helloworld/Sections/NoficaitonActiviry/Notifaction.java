package com.helloworld.Sections.NoficaitonActiviry;

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

import com.helloworld.MainActivity;
import com.helloworld.R;


/*

 activity 声明周期

 1。 进入页面先调用 ， onCreate
 2. 调 onStart
 3. 调 onResume  渲染界面
 4， 如果进入后台，app 没有被杀死， 会调 onPause, 和 onStop
 5, 再次唤醒后台app 会调 onRestart , onStart, 和 onResume
 6, 返回上个页面跟 4一样，只不过最后会调 onDestroy 销毁页面，回收内存

 */

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
        Log.e("Notification", "onStart:" );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Notification", "onRestart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Notification", "onResume: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Notification", "onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Notification", "onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Notification", "onDestroy: " );
    }

    public void sendNotifaction(View view) {

        manager.notify(1, notifaction);
    }

    public void cancelNotifaction(View view) {

        manager.cancel(1);
    }







}
