package com.helloworld.sections.downloads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.helloworld.R;
import com.helloworld.Sections.downloads.DownloadService;
import com.helloworld.Sections.downloads.DownloadService.DownloadBinder;

public class DownloadActivity extends AppCompatActivity {

    private DownloadService.DownloadBinder downloadBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (DownloadBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);
        bindService(intent, connection, BIND_AUTO_CREATE);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.FOREGROUND_SERVICE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.FOREGROUND_SERVICE}, 2);
        }

    }

    public void startLoad(View view) {
        if (downloadBinder == null) {
            return;
        }
        String url = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic27.nipic.com%2F20130316%2F3710458_103248082000_2.jpg";
        downloadBinder.startDownload(url);

    }

    public void pauseLoad(View view) {
        if (downloadBinder == null) {
            return;
        }
        downloadBinder.pauseDownload();

    }

    public void cancelLoad(View view) {
        if (downloadBinder == null) {
            return;
        }
        downloadBinder.cancelDownload();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                break;
            case 2:
                break;
            default:
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}