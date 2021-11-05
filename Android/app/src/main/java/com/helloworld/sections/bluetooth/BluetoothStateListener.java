package com.helloworld.sections.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BluetoothStateListener extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1);
        String msg = "";
        switch (state) {
            case BluetoothAdapter.STATE_TURNING_ON:
                msg = "turning on";
                break;
            case BluetoothAdapter.STATE_ON:
                msg = "is on";
                break;
            case BluetoothAdapter.STATE_TURNING_OFF:
                msg = "turning off";
                break;
            case BluetoothAdapter.STATE_OFF:
                msg = "is off";
                break;
        }
        Log.e("BluetoothStateListener", "onReceive: "+ msg);

    }
}
