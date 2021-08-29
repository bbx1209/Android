package com.helloworld.Sections.weChat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.helloworld.R;

import java.util.ArrayList;
import java.util.List;


public class WeChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_chat);


        ViewPager2 viewpager = findViewById(R.id.viewpager);

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(WechatFragment.newInstance("聊天"));
        fragments.add(WechatFragment.newInstance("通讯录"));
        fragments.add(WechatFragment.newInstance("发现"));
        fragments.add(WechatFragment.newInstance("我的"));

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), getLifecycle(), fragments);

        viewpager.setAdapter(myFragmentAdapter);
    }
}