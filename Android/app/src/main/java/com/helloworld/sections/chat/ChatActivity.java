package com.helloworld.sections.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.helloworld.R;
import com.helloworld.sections.chat.model.MsgModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayout inputbarlayout;
    private boolean inputbarIsUnFold = false;
    private LinearLayout moreitemLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        recyclerView = findViewById(R.id.chatRecuclerView);

        List<MsgModel> msgModels = queryData();

        ChatRecyclerViewAdapter chatRecyclerViewAdapter = new ChatRecyclerViewAdapter(this, msgModels);
        recyclerView.setAdapter(chatRecyclerViewAdapter);

        inputbarlayout = findViewById(R.id.inputBarFrame);

        moreitemLayout = findViewById(R.id.moreItemView);
    }

    List<MsgModel> queryData() {

        return new ArrayList<>();
    }

    public void sendMsg(View view) {


    }

    // 点击 + 号
    public void moreItemsClick(View view) {
        inputbarIsUnFold = !inputbarIsUnFold;

        int margin_bottom = 0;

        if (inputbarIsUnFold) {
            //展开状态
            margin_bottom = 250;



        } else {
            //闭合状态
            margin_bottom = 0;
        }
        // input bar 的父布局
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) inputbarlayout.getLayoutParams();
        layoutParams.bottomMargin = margin_bottom;
        inputbarlayout.setLayoutParams(layoutParams);


    }
}