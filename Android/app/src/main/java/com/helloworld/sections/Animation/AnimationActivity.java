package com.helloworld.sections.Animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.helloworld.R;


public class AnimationActivity extends AppCompatActivity {

    private   AnimationDrawable drawable;
    private   ImageView _imageView;
    private  boolean animating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        ImageView imageView = findViewById(R.id.animation_list);
        imageView.setImageResource(R.drawable.walk_animate);
        drawable = (AnimationDrawable) imageView.getDrawable();



        _imageView = findViewById(R.id.alpha_image);

        // 属性动画
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                Log.e("AnimationActivity", "onAnimationUpdate: "+ value );
            }
        });
//        valueAnimator.start();

        //属性动画
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(_imageView, "alpha", 0.2f, 1.0f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.start();



    }

    public void stopAnimationList(View view) {
        drawable.stop();
    }

    public void startAnimationList(View view) {
        drawable.start();
    }

    public void startAlpha(View view) {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        startAnimation(animation);

    }

    public void startRodate(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        startAnimation(animation);
    }


    public void startTranslate(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        startAnimation(animation);
    }

    public void startScale(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        startAnimation(animation);

    }

    public void startAnimation(Animation aAnimation) {
        Animation oldAnimaiton = _imageView.getAnimation();
        if (oldAnimaiton == null) {
            _imageView.startAnimation(aAnimation);
        } else {
            _imageView.clearAnimation();
            _imageView.startAnimation(aAnimation);
        }

    }

}