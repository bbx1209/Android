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

    }

    public void startLoad(View view) {
        if (downloadBinder == null) {
            return;
        }
        String url = "https://raw.githubusercontent.com/guolindev/eclipse/master/eclipse-int-win64.exe";
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
            default:
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}