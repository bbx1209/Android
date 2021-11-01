package com.helloworld.sections.bluetooth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.helloworld.R;

public class BluetoothActivity extends AppCompatActivity {

    private static final String TAG = "Bluetooth activity";
    private BluetoothAdapter mDefaultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        mDefaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mDefaultAdapter != null) {
            Log.e(TAG, "onCreate: " + "bluetooth avaible");
        }
        BluetoothStateListener stateListener = new BluetoothStateListener();
        IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(stateListener, intentFilter);

    }

    //开启蓝牙
    public void openBT(View view) {

        if (!mDefaultAdapter.isEnabled()) {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, 100);

        } else {
            //蓝牙已经开启
        }

    }

    //搜索设备
    public void findDevice(View view) {

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100:
                Log.e(TAG, "onRequestPermissionsResult: "+ "蓝牙开启" );
                break;
            default:
                break;
        }
    }
}