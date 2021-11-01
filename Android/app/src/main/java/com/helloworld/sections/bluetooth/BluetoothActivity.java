package com.helloworld.sections.bluetooth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.helloworld.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {

    private static final String TAG = "Bluetooth activity";
    private BluetoothAdapter mDefaultAdapter;
    private List<String> mArrayAdapter = new ArrayList();
    // 创建一个接受 ACTION_FOUND 的 BroadcastReceiver
    private final BroadcastReceiver mReceiver = new BroadcastReceiver(){

        public void onReceive(Context context, Intent intent){
            String action = intent.getAction();
            // 当 Discovery 发现了一个设备
            if(BluetoothDevice.ACTION_FOUND.equals(action)){
                // 从 Intent 中获取发现的 BluetoothDevice
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // 将名字和地址放入要显示的适配器中
                mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                Log.e(TAG, "BroadcastReceiver: "+ device.getName());
            }
        }
    };

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

        // 注册这个 BroadcastReceiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver,filter);


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
        Set<BluetoothDevice> pairedDevices = mDefaultAdapter.getBondedDevices();

        if(pairedDevices.size() > 0){
            for(BluetoothDevice device:pairedDevices){
                // 把名字和地址取出来添加到适配器中
                if (device != null) {
                    mArrayAdapter.add(device.getName()+"\n"+ device.getAddress());
                    Log.e(TAG, "findDevice: "+ device.getName());
                }
            }
        }


        mDefaultAdapter.startDiscovery();

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
        mDefaultAdapter.cancelDiscovery();
    }
}