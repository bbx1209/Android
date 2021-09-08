package com.helloworld.Sections.downloads;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.helloworld.Sections.downloads.DownloadListener;
import com.helloworld.Sections.downloads.DownloadTask;
import com.helloworld.sections.downloads.DownloadActivity;

import java.io.File;


public class DownloadService extends Service {

    private DownloadTask downloadTask;
    private String downloadUrl;

    private DownloadListener listener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {
            getNotificationManager().notify(1, getNotification("Downloading ... ", progress));
        }


        @Override
        public void onSuccess() {
        downloadTask= null;
        stopForeground(true);
        getNotificationManager().notify(1, getNotification("Download success", -1));
            Toast.makeText(DownloadService.this, "Download Success", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailed() {
            downloadTask = null;
            stopForeground(true);
            getNotificationManager().notify(1, getNotification("Download Faild", -1));
            Toast.makeText(DownloadService.this, "Download Faild", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onPause() {
            downloadTask = null;
            Toast.makeText(DownloadService.this, "Download Paused", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            downloadTask = null;
            stopForeground(true);
            Toast.makeText(DownloadService.this, "Download Canceld", Toast.LENGTH_SHORT).show();

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private DownloadBinder mBinder = new DownloadBinder();

    public class DownloadBinder extends Binder {

        public  void startDownload(String url) {
            if (downloadTask == null) {
                downloadUrl = url;
                downloadTask = new DownloadTask(listener);
                downloadTask.execute(downloadUrl);
                startForeground(1, getNotification("Downloading ...", 0));
                Toast.makeText(DownloadService.this, "Downloading ...", Toast.LENGTH_SHORT).show();

            }
        }
        public  void  pauseDownload(){
            if (downloadTask != null) {
                downloadTask.pauseDownload();
            }
        }
        public void cancelDownload() {
            if (downloadTask != null){
                downloadTask.cancelDownload();
            }
            if (downloadUrl != null) {
                //取消下载是需要将文件删除,并通知关闭
                String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
                String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
                File file = new File(directory + fileName);
                if (file.exists()) {
                    file.delete();
                }
                getNotificationManager().cancel(1);
                stopForeground(true);
                Toast.makeText(DownloadService.this, "Canceld", Toast.LENGTH_SHORT).show();


            }
        }


    }

    private Notification getNotification(String title, int progress) {

        Intent intent = new Intent(this, DownloadActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(android.R.mipmap.sym_def_app_icon);
        builder.setContentIntent(pendingIntent);
        builder.setContentTitle(title);
        if (progress >= 0) {
            builder.setContentText(progress +  "%");
            builder.setProgress(100, progress, false);
        }

        return builder.build();
    }
    private NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
}
