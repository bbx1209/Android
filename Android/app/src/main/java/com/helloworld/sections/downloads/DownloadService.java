package com.helloworld.Sections.downloads;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.helloworld.Sections.downloads.DownloadListener;
import com.helloworld.Sections.downloads.DownloadTask;
import com.helloworld.sections.downloads.DownloadActivity;


public class DownloadService  extends Service {

    private DownloadTask downloadTask;
    private  String downloadUrl;

    private DownloadListener listener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {
//            getNotificationManager()
        }


        @Override
        public void onSuccess() {

        }

        @Override
        public void onFailed() {

        }

        @Override
        public void onPause() {

        }

        @Override
        public void onCancel() {

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private  DownloadBinder  mBinder = new DownloadBinder();

    class  DownloadBinder extends Binder {



    }

    private Notification getNotificationManager(String title, int progress) {

        Intent intent = new Intent(this, DownloadActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        return builder.build();
    }
}
