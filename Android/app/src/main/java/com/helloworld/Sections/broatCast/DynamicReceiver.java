package com.helloworld.Sections.broatCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class DynamicReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("DynamicReceiver", "onReceive: 我是动态注册观察者 ");
    Toast.makeText(context, "我是动态注册观察者", Toast.LENGTH_SHORT).show();
    }
}
