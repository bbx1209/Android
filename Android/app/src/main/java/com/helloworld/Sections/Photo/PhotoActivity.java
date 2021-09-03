package com.helloworld.Sections.Photo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.helloworld.R;

public class PhotoActivity extends AppCompatActivity {

    private ImageView cameraImageView;
    private ImageView albumImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        cameraImageView = findViewById(R.id.cameraImageView);
        albumImageView = findViewById(R.id.albumImageView);


    }
    //拍照
    public void takeAPhoto(View view) {

    }
    //相册
    public void fetchFromAlbum(View view) {

    }
}