package com.helloworld.Sections.service;

import androidx.appcompat.app.AppCompatActivity;

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

    }

    //关闭服务
    public void stopService(View view) {

    }

    //绑定服务
    public void bindService(View view) {

    }

    // 解绑
    public void unbindService(View view) {

    }
}