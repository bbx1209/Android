package com.helloworld.sections.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.util.StringUtil;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.helloworld.Handler.DimenUtils;
import com.helloworld.R;
import com.helloworld.sections.chat.dbhelper.MsgDBHelper;
import com.helloworld.sections.chat.model.MsgModel;
import com.helloworld.sections.chat.model.MsgType;
import com.helloworld.sections.chat.model.SendType;
import com.helloworld.sections.chat.moreItems.MoreItem;
import com.helloworld.sections.chat.moreItems.MoreItemAdapter;
import com.helloworld.sections.chat.moreItems.MoreItemListener;
import com.helloworld.sections.chat.moreItems.MoreItemType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ChatActivity extends AppCompatActivity implements MoreItemListener {

    private RecyclerView recyclerView;
    private LinearLayout inputbarlayout;
    private boolean inputbarIsUnFold = false;
    private LinearLayout moreitemLayout;
    private  RecyclerView moreitemView;
    private EditText mInputText;

    private MsgDBHelper mMsgDBHelper;

    private List<MoreItem> mItemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //初始化数据
        initMoreitems();

        recyclerView = findViewById(R.id.chatRecuclerView);

        List<MsgModel> msgModels = queryData();

        ChatRecyclerViewAdapter chatRecyclerViewAdapter = new ChatRecyclerViewAdapter(this, msgModels);
        recyclerView.setAdapter(chatRecyclerViewAdapter);

        inputbarlayout = findViewById(R.id.inputBarFrame);

        moreitemLayout = findViewById(R.id.moreItemView_layout);


        moreitemView = findViewById(R.id.moreItemView);
        MoreItemAdapter moreItemAdapter = new MoreItemAdapter(this, mItemsList);
        moreitemView.setAdapter(moreItemAdapter);
        GridLayoutManager itemLayoutManager = new GridLayoutManager(this, 2);
        itemLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        moreitemView.setLayoutManager(itemLayoutManager);


        mInputText = findViewById(R.id.inputEditTextView);

        mMsgDBHelper = new MsgDBHelper(this);




    }

    private void initMoreitems() {
        MoreItem camera = new MoreItem("拍照", R.drawable.item_camera, MoreItemType.MOREITEMTYPE_CAMERA, this);
        MoreItem album = new MoreItem("相册", R.drawable.item_album, MoreItemType.MOREITEMTYPE_ALBUM, this);
        MoreItem video = new MoreItem("小视频", R.drawable.item_video, MoreItemType.MOREITEMTYPE_VIDEO, this);
        mItemsList.add(camera);
        mItemsList.add(album);
        mItemsList.add(video);
    }

    List<MsgModel> queryData() {

        return new ArrayList<>();
    }

    //发送消息
    public void sendMsg(View view) {
        String inputText = mInputText.getText().toString();
        if (inputText != null && !inputText.equals("")) {

            MsgModel msgModel = new MsgModel(inputText, MsgType.MSGTYPE_TEXT, SendType.SENDTYPE_SEND);
            mMsgDBHelper.insertMsgModel(msgModel);
            //清空 输入框
            mInputText.setText(null);
        }
    }

    // 点击 + 号
    public void moreItemsClick(View view) {
        inputbarIsUnFold = !inputbarIsUnFold;

        int margin_bottom = 0;

        if (inputbarIsUnFold) {
            //展开状态
            margin_bottom = DimenUtils.dp2px(this, 250);
            moreitemLayout.setVisibility(ViewGroup.VISIBLE);

        } else {
            //闭合状态
            margin_bottom = 0;
            moreitemLayout.setVisibility(ViewGroup.GONE);
        }
        // input bar 的父布局
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) inputbarlayout.getLayoutParams();
        layoutParams.bottomMargin = margin_bottom;
        inputbarlayout.setLayoutParams(layoutParams);

    }


//MARK: more item onclick
    @Override
    public void onClickMoreItem(MoreItem moreItem) {
        switch (moreItem.type) {
            case  MoreItemType.MOREITEMTYPE_CAMERA:
                break;
            case  MoreItemType.MOREITEMTYPE_ALBUM:
                break;
            case  MoreItemType.MOREITEMTYPE_VIDEO:
                break;
            default:
        }
    }
}