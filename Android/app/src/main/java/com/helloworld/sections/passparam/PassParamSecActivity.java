package com.helloworld.sections.passparam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.helloworld.R;

public class PassParamSecActivity extends AppCompatActivity {

    public static final int Activity_Request_code = 1101;

    public static final String Param_1 = "Param_1";
    public static final String Param_2 = "Param_2";
    private String param1;
    private int param2;

    public  static  PassParamSecActivity newInstance(com.helloworld.sections.passparam.PassParam passParam, String param1, int param2) {
        PassParamSecActivity passParamSecActivity = new PassParamSecActivity();
        passParamSecActivity.param1 = param1;
        passParamSecActivity.param2 = param2;
        return passParamSecActivity;
    }

    public  static  Intent newPPSActivityIntent(Context context, String param1 , int param2) {
        Intent intent = new Intent(context, PassParamSecActivity.class);
        intent.putExtra(Param_1, param1);
        intent.putExtra(Param_2, param2);
        return intent;
    }



    public PassParamSecActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_param_sec);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        Log.e("second", "onCreate"+ key );

        this.param1 = intent.getStringExtra(Param_1);
        this.param2 = intent.getIntExtra(Param_2, 0);
        Log.d("PassParamSecActivity", "onCreate: " + "param 1 : " + this.param1 + "param2 :" + this.param2);
    }

    public void passValueBack(View view) {

        Intent intent = new Intent();
        intent.putExtra("key", "second");
        setResult(1, intent);
        finish();

    }
}