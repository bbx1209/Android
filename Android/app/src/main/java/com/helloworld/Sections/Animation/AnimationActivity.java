package com.helloworld.Sections.Animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.helloworld.R;


public class AnimationActivity extends AppCompatActivity {

    private   AnimationDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        ImageView imageView = findViewById(R.id.animation_list);
        imageView.setImageResource(R.drawable.walk_animate);
        drawable = (AnimationDrawable) imageView.getDrawable();

    }

    public void stopAnimationList(View view) {


        drawable.stop();
    }

    public void startAnimationList(View view) {
        drawable.start();
    }

    public void startAlpha(View view) {
    }

    public void startRodate(View view) {
    }

    public void startTranslate(View view) {
    }

    public void startScale(View view) {
    }
}