package com.helloworld.Sections.PassParam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.helloworld.R;


public class PassParam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_param);
    }

    public void ClickPushToNextActvity(View view) {

        Intent intent = new Intent(this, PassParamSecActivity.class);
        intent.putExtra("key", "vaule");
        startActivity(intent);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}