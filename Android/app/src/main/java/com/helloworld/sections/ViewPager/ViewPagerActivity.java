package com.helloworld.sections.ViewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.helloworld.R;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);


        List<View> list = new ArrayList<>();

        LayoutInflater layoutInflater = getLayoutInflater();
        View view1 = layoutInflater.inflate(R.layout.viewpage_view1, null);
        View view2 = layoutInflater.inflate(R.layout.viewpage_view2, null);
        View view3 = layoutInflater.inflate(R.layout.viewpage_view3, null);
        list.add(view1);
        list.add(view2);
        list.add(view3);


        ViewPager pager = findViewById(R.id.viewPager);

        PagerAdaptor pagerAdaptor = new PagerAdaptor(list);
        pager.setAdapter(pagerAdaptor);


    }
}