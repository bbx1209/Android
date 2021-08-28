package com.helloworld.Sections.ViewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.helloworld.R;


public class ViewPager2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);

        ViewPager2 viewpager = findViewById(R.id.viewpager2);
    }
}