package com.helloworld.Sections.audio_video;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.helloworld.R;


public class AudioVideoActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_video);

        videoView = findViewById(R.id.videoView);
    }

    //MARK: ------  音频 -------

    //播放
    public void audioPlay(View view) {

    }

    //暂停
    public void audioPause(View view) {
    }

    //重新播放
    public void audioReplay(View view) {

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
}