package com.helloworld.BaseActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;


import com.helloworld.Handler.MyAcitivityManager;
import com.helloworld.R;

import java.io.File;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Log.e(TAG, "onCreate:");

        MyAcitivityManager.pushActivity(this);

        getPathByEnviroment();
        getPathByContext();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyAcitivityManager.popActivity(this);
    }

    protected void exitAPP() {
        MyAcitivityManager.finishAll();
    }


    private void getPathByEnviroment() {
        String dataPath = Environment.getDataDirectory().getPath();
        String downloadCachePath = Environment.getDownloadCacheDirectory().getPath();
        String storagePath = Environment.getExternalStorageDirectory().getPath();
        String storagePublicPath = Environment.getExternalStoragePublicDirectory("image").getPath();
        String rootPath = Environment.getRootDirectory().getPath();

        String dcim = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            String cocuments = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getPath();
            Log.d(TAG, "++++++getPathByEnviroment:dcim :" + cocuments);
        }
        String music = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getPath();
        String podcasts = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS).getPath();

        String ringtones = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getPath();

        String alarms = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS).getPath();

        String notifications = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS).getPath();

        String picture = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();
        String movies = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getPath();

        String downloads = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            String screenshot = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_SCREENSHOTS).getPath();
            String audiobooks = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_AUDIOBOOKS).getPath();
            Log.d(TAG, "++++++getPathByEnviroment:dcim :" + screenshot);
            Log.d(TAG, "++++++getPathByEnviroment:dcim :" + audiobooks);

        }

        Log.d(TAG, "++++++getPathByEnviroment:dcim :" + music);

        Log.d(TAG, "++++++getPathByEnviroment:dcim :" + podcasts);

        Log.d(TAG, "++++++getPathByEnviroment:dcim :" + ringtones);

        Log.d(TAG, "++++++getPathByEnviroment:dcim :" + alarms);
        Log.d(TAG, "++++++getPathByEnviroment:dcim :" + notifications);

        Log.d(TAG, "++++++getPathByEnviroment:dcim :" + picture);

        Log.d(TAG, "++++++getPathByEnviroment:dcim :" + movies);

        Log.d(TAG, "++++++getPathByEnviroment:dcim :" + downloads);


        Log.d(TAG, "++++++getPathByEnviroment:dataPath:" + dataPath);
        Log.d(TAG, "++++++getPathByEnviroment:  downloadCachePath:" + downloadCachePath);
        Log.d(TAG, "++++++getPathByEnviroment:storagePath :" + storagePath);
        Log.d(TAG, "++++++getPathByEnviroment: storagePublicPath:" + storagePublicPath);
        Log.d(TAG, "++++++getPathByEnviroment:rootPath :" + rootPath);
        Log.d(TAG, "++++++getPathByEnviroment:dcim :" + dcim);




        File imageFile = new File(dcim, "image1");
        if (!imageFile.exists()) {
            imageFile.mkdir();
        }
        String image = new File(dcim, "image1").getPath();
        Log.d(TAG, "++++++getPathByEnviroment:image :" + image);

    }

    private void getPathByContext() {

        String filesPath = getFilesDir().getPath();

        String cacheDir = getCacheDir().getPath();

        Log.d(TAG, "++++++getFilesDir :" + filesPath);
        Log.d(TAG, "++++++getCacheDir :" + cacheDir);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            String dataPath = getDataDir().getPath();
            Log.d(TAG, "++++++getDataDir :" + dataPath);
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            String nobackupFilesPath = getNoBackupFilesDir().getPath();
            Log.d(TAG, "++++++getNoBackupFilesDir :" + nobackupFilesPath);
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            String codeCachePath = getCodeCacheDir().getPath();
            Log.d(TAG, "++++++getCodeCacheDir :" + codeCachePath);
        }


        String obPath = getObbDir().getPath();
        Log.d(TAG, "++++++getObbDir :" + obPath);

        String externalCachePath = getExternalCacheDir().getPath();
        Log.d(TAG, "++++++getExternalCacheDir :" + externalCachePath);

        String externalFileTypePath = getExternalFilesDir("image").getPath();
        Log.d(TAG, "++++++getExternalFilesDir :" + externalFileTypePath);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            File[] mediaFiles = getExternalMediaDirs();
            for (File file : mediaFiles) {
                String path = file.getPath();
                Log.d(TAG, "++++++getExternalMediaDirs :" + path);
            }
        }


    }
}