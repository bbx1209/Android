package com.helloworld.recoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;

import com.helloworld.R;

import java.io.File;

public class RecoderActivity extends AppCompatActivity {

    private TextureView textureView;
    private MediaRecorder mediaRecorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoder);

        textureView = findViewById(R.id.textureView);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new  String[]{Manifest.permission.RECORD_AUDIO}, 1);
        }
    }

    public void playAndStopAction(View view) {

        Button but = (Button) view;
        String text = but.getText().toString();
        if (TextUtils.equals(text, "录制")) {
            //录制
            but.setText("停止");
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "");
            String path = file.getPath();



        } else {
            //停止

            but.setText("录制");
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    playAndStopAction(findViewById(R.id.recordBut));
                }
                break;
            default:
        }
    }
}