package com.helloworld.Sections.PassParam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.helloworld.R;

public class PassParamSecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_param_sec);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        Log.e("second", "onCreate"+ key );
    }

    public void passValueBack(View view) {

        onBackPressed();

    }
}