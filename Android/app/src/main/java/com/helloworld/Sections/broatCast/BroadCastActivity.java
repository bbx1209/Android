package com.helloworld.Sections.broatCast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import com.helloworld.R;


public class BroadCastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);


        DynamicReceiver dynamicReceiver = new DynamicReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BroadCastReceiverKey.RECEIVER_DYNAMIC);
        registerReceiver(dynamicReceiver, intentFilter);


    }

    //发送静态广播
    public void sendStaticReciver(View view) {
                          Intent intent = new Intent();
//        intent.setAction("RECEIVER_STATIC");
        intent.setComponent(new ComponentName(BroadCastActivity.this, StaticReciver.class));
        sendBroadcast(intent);
    }

    public void sendDynamicReciver(View view) {
        Intent intent = new Intent();
        intent.setAction(BroadCastReceiverKey.RECEIVER_DYNAMIC);
        sendBroadcast(intent);

    }
}