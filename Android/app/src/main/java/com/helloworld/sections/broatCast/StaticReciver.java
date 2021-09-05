package com.helloworld.sections.broatCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class StaticReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("StaticReciver", "onReceive: 我是静态注册观察者 ");
        Toast.makeText(context,"我是静态注册观察者", Toast.LENGTH_SHORT).show();
    }
}
