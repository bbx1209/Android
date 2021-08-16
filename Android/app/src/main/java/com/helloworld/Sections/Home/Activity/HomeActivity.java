package com.helloworld.Sections.Home.Activity;

import android.os.Bundle;
import android.util.Log;

import com.helloworld.BaseActivity.BaseActivity;

import com.helloworld.R;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Log.e("Home activity", "onCreate:"+"+++++++++++++++++++++++++++" );
    }
}
