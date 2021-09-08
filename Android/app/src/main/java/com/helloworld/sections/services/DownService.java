package com.helloworld.sections.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.helloworld.myApplication.MyApplication;

import java.io.FileDescriptor;

public class DownService extends Service {
    public DownService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return  new IBinder() {
            @Nullable
            @Override
            public String getInterfaceDescriptor() throws RemoteException {
                return null;
            }

            @Override
            public boolean pingBinder() {
                return false;
            }

            @Override
            public boolean isBinderAlive() {
                return false;
            }

            @Nullable
            @Override
            public IInterface queryLocalInterface(@NonNull String descriptor) {
                return null;
            }

            @Override
            public void dump(@NonNull FileDescriptor fd, @Nullable String[] args) throws RemoteException {

            }

            @Override
            public void dumpAsync(@NonNull FileDescriptor fd, @Nullable String[] args) throws RemoteException {

            }

            @Override
            public boolean transact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
                return false;
            }

            @Override
            public void linkToDeath(@NonNull DeathRecipient recipient, int flags) throws RemoteException {

            }

            @Override
            public boolean unlinkToDeath(@NonNull DeathRecipient recipient, int flags) {
                return false;
            }
        };
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("DownService", "onBind: 服务开启");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Toast.makeText(MyApplication.getContext(), "服务开启", Toast.LENGTH_SHORT).show();
        Log.d("DownService", "onBind: 服务关闭");
    }
}