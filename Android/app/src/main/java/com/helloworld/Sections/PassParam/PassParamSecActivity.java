package com.helloworld.Sections.PassParam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.helloworld.R;

public class PassParamSecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_param_sec);
    }

    public void passValueBack(View view) {

        onBackPressed();

    }
}