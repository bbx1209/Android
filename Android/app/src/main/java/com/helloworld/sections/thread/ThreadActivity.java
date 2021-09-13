package com.helloworld.sections.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.helloworld.R;
import com.helloworld.sections.thread.MyThread;
import com.helloworld.sections.thread.MyRunable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    public void onClickCallable(View view) {
        MyCallAble myCallAble = new MyCallAble();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future submit = executorService.submit(myCallAble);

        String retValue = null;
        try {
            retValue = (String) submit.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onClickCallable: " + retValue + Thread.currentThread().toString());

    }
    //开启一个一步线程   ->begin->end->run
    public void startAnewThread(View view) {

        Log.d(TAG, "startAnewThread: " + "begin" + Thread.currentThread().toString());

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "onClickCallable: " + "run" + Thread.currentThread().toString());
            }
        }).start();
        Log.d(TAG, "onClickCallable: " + "end" + Thread.currentThread().toString());
    }
}