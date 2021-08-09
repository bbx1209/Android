package com.helloworld;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity" ;

    public   static  final  String paramKey = "paramKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text_one);
//        textView.setText("在代码中替换");


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK){
            String result = data.getStringExtra("content");
            Log.e(TAG, "onActivityResult: " + result );
        }
    }

    public void clickOnButton(View view) {

        Log.e(TAG, "clickOnButton: 点击了按钮");

        Intent intent = new Intent(this, MainActivity2.class);

        startActivityForResult(intent, 200);

        startActivity(intent);
    }

    public void jumpAction(View view) {

    startActivity(new Intent(this , ListViewActivity.class));
    }

    public void toNotifaction(View view) {

        Intent intent = new Intent(this, Notifaction.class);

        intent.putExtra(paramKey, "这是传过去的字符串");
        startActivity(intent);
    }

    public void toOkHttp(View view) {


    }
}