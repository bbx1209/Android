package com.helloworld.Sections.ViewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.helloworld.R;

import java.util.ArrayList;
import java.util.List;


public class ViewPager2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);

        ViewPager2 viewpager = findViewById(R.id.viewpager2);
        MyAdapter myAdapter = new MyAdapter(data());
        viewpager.setAdapter(myAdapter);
    }

    List<String> data() {
        List<String> list = new ArrayList<>();
        list.add("asdfadf");
        list.add("fasdfasd");
        list.add("asdteyjfadf");
        list.add("as更好地给大家dfadf");
        list.add("规划大公鸡积分规划局");
        list.add("风格和要教育厅");
        return  list;
    }
}