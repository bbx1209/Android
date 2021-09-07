package com.helloworld.sections.download;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;


public class DownloadService  extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private  DownloadBinder  mBinder = new DownloadBinder();

    class  DownloadBinder extends Binder {



    }
}
