package com.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text_one);
//        textView.setText("在代码中替换");


    }

    public void clickOnButton(View view) {

        Log.e(TAG,"clickOnButton: 点击了按钮");
    }

    public void jumpAction(View view) {


    }
}