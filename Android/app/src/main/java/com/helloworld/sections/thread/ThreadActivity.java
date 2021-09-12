package com.helloworld.sections.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.helloworld.R;
import com.helloworld.sections.thread.MyThread;
import com.helloworld.sections.thread.MyRunable;

public class ThreadActivity extends AppCompatActivity {

    private static final String TAG = "=== ThreadActivity ===";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

    }

    public void onClickMyThread(View view) {

        Log.d(TAG, "onClickMyThread:" + Thread.currentThread().toString() + Thread.currentThread().getId());

        for (int i = 0; i < 4; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
        }
    }

    public void onClickMyRunable(View view) {

        Log.d(TAG, "onClickMyThread:" + Thread.currentThread().toString() + Thread.currentThread().getId());

        MyRunable myRunable = new MyRunable();

        Thread thread = new Thread(myRunable);

        thread.start();

    }
}