package com.helloworld.Sections.broatCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LocalReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "本地通知接受者",Toast.LENGTH_SHORT).show();
    }
}
