package com.helloworld.BaseActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;


import com.helloworld.Handler.MyAcitivityManager;
import com.helloworld.R;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Log.e(TAG, "onCreate:");

        MyAcitivityManager.pushActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyAcitivityManager.popActivity(this);
    }
}