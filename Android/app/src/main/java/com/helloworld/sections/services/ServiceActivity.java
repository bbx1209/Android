package com.helloworld.sections.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.helloworld.R;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }


    //开启服务
    public void startService(View view) {

        Intent service = new Intent(this, DownService.class);
        startService(service);

    }

    //关闭服务
    public void stopService(View view) {
        Intent service = new Intent(this, DownService.class);
        stopService(service);

    }

    //绑定服务
    public void bindService(View view) {

    }

    // 解绑
    public void unbindService(View view) {

    }

    // intent service   start
    public void startIntentService(View view) {

    }

    // intent service   stop
    public void stopIntentService(View view) {


    }
}