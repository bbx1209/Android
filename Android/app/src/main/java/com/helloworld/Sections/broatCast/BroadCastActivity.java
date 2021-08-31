package com.helloworld.Sections.broatCast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.helloworld.R;


public class BroadCastActivity extends AppCompatActivity {

    private DynamicReceiver dynamicReceiver;
    private  NetworkReveiver networkReceiver;
    private  LocalReceiver localReceiver;

    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);


        dynamicReceiver = new DynamicReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BroadCastReceiverKey.RECEIVER_DYNAMIC);
        registerReceiver(dynamicReceiver, intentFilter);


        IntentFilter netFilter = new IntentFilter();
        netFilter.addAction(BroadCastReceiverKey.NETWORKCHANGR);
        networkReceiver = new NetworkReveiver();
        registerReceiver(networkReceiver, netFilter);

        localBroadcastManager =   LocalBroadcastManager.getInstance(this);
         localReceiver = new LocalReceiver();
        IntentFilter localFilter = new IntentFilter();
        localFilter.addAction(BroadCastReceiverKey.LOCALRCEIVER);
        localBroadcastManager.registerReceiver(localReceiver, localFilter);

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

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(dynamicReceiver);
        unregisterReceiver(networkReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    public void sendLocalReciver(View view) {
        Intent intent = new Intent();
        intent.setAction(BroadCastReceiverKey.LOCALRCEIVER);
        localBroadcastManager.sendBroadcast(intent);
    }

    class NetworkReveiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo netInfo = manager.getNetworkInfo(0);
            if (netInfo != null && netInfo.isAvailable()) {

                Toast.makeText(context, "net work is availabel",Toast.LENGTH_SHORT).show();
            } else
            {
                Toast.makeText(context, "net work is unavailabel",Toast.LENGTH_SHORT).show();
            }
        }
    }

}

