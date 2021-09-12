package com.helloworld.sections.thread;

import android.util.Log;

import java.util.concurrent.Callable;

public class MyCallAble implements Callable {

    private static final String TAG = "====MyCallAble=====";

    @Override
    public String call() throws Exception {

        Log.d(TAG, "call: " + Thread.currentThread().toString());
        return " MyCalable return value";
    }
}
