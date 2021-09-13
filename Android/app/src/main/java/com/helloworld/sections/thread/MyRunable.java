package com.helloworld.sections.thread;

import android.util.Log;

public class MyRunable implements Runnable {

    private static final String TAG = "====MyRunable =====";

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Log.d(TAG, "run: " + i + Thread.currentThread().toString());
        }
    }
}
