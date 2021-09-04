package com.helloworld.sections.audio_video;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import com.helloworld.R;

import java.io.File;
import java.io.IOException;


public class AudioVideoActivity extends AppCompatActivity {

    private static final String TAG = "AudioVideoActivity";
    private MediaPlayer mediaPlayer = new MediaPlayer();

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_video);

        videoView = findViewById(R.id.videoView);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        } else {
            initMediaPlayer();
        }
    }

    //MARK: ------  音频 -------

    //播放
    public void audioPlay(View view) {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    //暂停
    public void audioPause(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    //停止播放
    public void audioStopplay(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            try {
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    //MARK: ------  视频 -------

    //播放
    public void videoPlay(View view) {

    }

    //暂停
    public void videoPause(View view) {
    }

    //重新播放
    public void videoReplay(View view) {
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initMediaPlayer();
                } else {
                    Toast.makeText(this, "您拒绝了权限访问", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
        }
    }

    private void initMediaPlayer() {

        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "童话镇铃声.mp3");
            String filePath = file.getPath();
            Log.d(TAG, "initMediaPlayer: " + filePath);
            //指定音频文件路径
            mediaPlayer.setDataSource(filePath);
            //让 player 进入准备状态
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //销毁播放器
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}