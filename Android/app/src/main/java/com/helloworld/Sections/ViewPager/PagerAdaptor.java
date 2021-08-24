package com.helloworld.Sections.ViewPager;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class PagerAdaptor extends PagerAdapter {

    private List<View> listView;

    public PagerAdaptor(List<View> listView) {
        this.listView = listView;
    }

    @Override
    public int getCount() {
        return listView.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(listView.get(position), 0);
        return  listView.get(position);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView(listView.get(position));
    }
}
