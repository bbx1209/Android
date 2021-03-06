package com.helloworld.sections.passparam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.helloworld.R;

import com.helloworld.sections.passparam.PassParamSecActivity;

public class PassParam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_param);
    }

    public void ClickPushToNextActvity(View view) {

//        Intent intent = new Intent(this, PassParamSecActivity.class);
//        intent.putExtra("key", "vaule");
////        startActivity(intent);
//        //回传参数必须要用这个方法
//        startActivityForResult(intent, 1);


        Intent intent = PassParamSecActivity.newPPSActivityIntent(PassParam.this, "向下传值", 1000);
        startActivityForResult(intent, PassParamSecActivity.Activity_Request_code);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            String result = data.getStringExtra("key");
            Log.e("first activity", "onActivityResult"+ result );
        }
    }
}