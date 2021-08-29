package com.helloworld.Sections.weChat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.helloworld.R;

import java.util.ArrayList;
import java.util.List;


public class WeChatActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llchat, llcontact, llfaxian, llwo;
    private ImageView ivchat, ivcontact, ivfaxian, ivwo, current;
    private  ViewPager2 viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_chat);

        initSubViews();


         viewpager = findViewById(R.id.viewpager);

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(WechatFragment.newInstance("聊天"));
        fragments.add(WechatFragment.newInstance("通讯录"));
        fragments.add(WechatFragment.newInstance("发现"));
        fragments.add(WechatFragment.newInstance("我的"));

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), getLifecycle(), fragments);

        viewpager.setAdapter(myFragmentAdapter);

        viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTap(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeTap(int position) {
        current.setSelected(false);
        switch (position) {
            case R.id.chat_item_layout:
                viewpager.setCurrentItem(0);
            case 0:
                ivchat.setSelected(true);
                current = ivchat;
                break;
            case R.id.contact_item_layout:
                viewpager.setCurrentItem(1);
            case 1:
                ivcontact.setSelected(true);
                current = ivcontact;
                break;
            case R.id.faxian_item_layout:
                viewpager.setCurrentItem(2);
            case 2:
                ivfaxian.setSelected(true);
                current = ivfaxian;
                break;
            case R.id.wo_item_layout:
                viewpager.setCurrentItem(3);
            case 3:
                ivwo.setSelected(true);
                current = ivwo;
                break;

        }
    }


    private void initSubViews() {

        llchat = findViewById(R.id.chat_item_layout);
        llchat.setOnClickListener(this);
        llcontact = findViewById(R.id.contact_item_layout);
        llcontact.setOnClickListener(this);
        llfaxian = findViewById(R.id.faxian_item_layout);
        llfaxian.setOnClickListener(this);
        llwo = findViewById(R.id.wo_item_layout);
        llwo.setOnClickListener(this);

        ivchat = findViewById(R.id.chat_iv);
        ivcontact = findViewById(R.id.contact_iv);
        ivfaxian = findViewById(R.id.faxian_iv);
        ivwo = findViewById(R.id.wo_iv);

        ivchat.setSelected(true);
        current = ivchat;

    }

    @Override
    public void onClick(View v) {
        changeTap(v.getId());
    }
}