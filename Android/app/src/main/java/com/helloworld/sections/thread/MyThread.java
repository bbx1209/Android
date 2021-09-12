package com.helloworld.sections.thread;

import android.util.Log;

import androidx.annotation.NonNull;

public class MyThread extends  Thread {

    private static final String TAG = "====Mythread =====";

    @Override
    public void run() {
//        super.run();

        for (int i = 0; i < 10; i++) {
            Log.d(TAG, "run: " + i + this.toString());
        }
    }

    @NonNull
    @Override
    public String toString() {
        String string = super.toString();
        return string + this.getId();
    }
}
