package com.helloworld.sections.recoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;

import com.helloworld.R;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class RecoderActivity extends AppCompatActivity {

    private TextureView textureView;
    private MediaRecorder mediaRecorder;
    private  Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoder);


        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "/test");
        String directory = file.getPath();
        Log.d("+++++++ RecoderActivity", "playAndStopAction:" + directory);

        textureView = findViewById(R.id.textureView);
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new  String[]{Manifest.permission.RECORD_AUDIO,Manifest.permission.CAMERA}, 1);
//        }

    }

    @SuppressLint("WrongConstant")
    public void playAndStopAction(View view) {

        Button but = (Button) view;
        String text = but.getText().toString();
        if (TextUtils.equals(text, "录制")) {
            //录制
            but.setText("停止");


            camera = Camera.open();
            camera.setDisplayOrientation(90);
            camera.unlock();

            mediaRecorder = new MediaRecorder();
            mediaRecorder.setCamera(camera);
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
            mediaRecorder.setOrientationHint(90);

            long time = new Date().getTime();
            String fileName = time+ ".mp4";
            String path = new File(getExternalFilesDir(""), fileName).getAbsolutePath();
            Log.d("RecoderActivity", "playAndStopAction======" + path);
            mediaRecorder.setOutputFile(path);
            mediaRecorder.setVideoSize(640, 480);
            mediaRecorder.setPreviewDisplay(new Surface(textureView.getSurfaceTexture()));
            try {
                mediaRecorder.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaRecorder.start();

        } else {
            //停止

            but.setText("录制");

            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
            camera.stopPreview();
            camera.release();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    playAndStopAction(findViewById(R.id.recordBut));
                }
                break;
            case 2:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    playAndStopAction(findViewById(R.id.recordBut));
                }
                break;
            default:
        }
    }
}