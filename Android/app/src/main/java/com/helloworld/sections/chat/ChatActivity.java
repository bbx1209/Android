package com.helloworld.sections.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.util.StringUtil;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.helloworld.Handler.DimenUtils;
import com.helloworld.R;
import com.helloworld.sections.chat.dbhelper.MsgDBHelper;
import com.helloworld.sections.chat.dbhelper.MsgDBHelperListner;
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


public class ChatActivity extends AppCompatActivity implements MoreItemListener, TextWatcher, TextView.OnEditorActionListener, View.OnKeyListener, MsgDBHelperListner {

    private static final String TAG = "ChatActivity";

    private RecyclerView recyclerView;
    private LinearLayout inputbarlayout;
    private boolean inputbarIsUnFold = false;
    private LinearLayout moreitemLayout;
    private RecyclerView moreitemView;
    private EditText mInputText;

    private MsgDBHelper mMsgDBHelper;

    private final List<MoreItem> mItemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //???????????????
        initMoreitems();
        //??????view
        recyclerView = findViewById(R.id.chatRecuclerView);

        List<MsgModel> msgModels = queryData();

        ChatRecyclerViewAdapter chatRecyclerViewAdapter = new ChatRecyclerViewAdapter(this, msgModels);
        recyclerView.setAdapter(chatRecyclerViewAdapter);
        //???????????????
        inputbarlayout = findViewById(R.id.inputBarFrame);
        //?????????????????????
        moreitemLayout = findViewById(R.id.moreItemView_layout);

        //???????????????view
        moreitemView = findViewById(R.id.moreItemView);
        MoreItemAdapter moreItemAdapter = new MoreItemAdapter(this, mItemsList);
        moreitemView.setAdapter(moreItemAdapter);
        GridLayoutManager itemLayoutManager = new GridLayoutManager(this, 2);
        itemLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        moreitemView.setLayoutManager(itemLayoutManager);

        //????????? edit view
        mInputText = findViewById(R.id.inputEditTextView);
        mInputText.addTextChangedListener(this);
        //????????????
        mInputText.setOnKeyListener(this);
        mInputText.setOnEditorActionListener(this);

        // ???????????????
        mMsgDBHelper = new MsgDBHelper(this, this);
        mMsgDBHelper.queryMsgHistory();

    }

    private void initMoreitems() {
        MoreItem camera = new MoreItem("??????", R.drawable.item_camera, MoreItemType.MOREITEMTYPE_CAMERA, this);
        MoreItem album = new MoreItem("??????", R.drawable.item_album, MoreItemType.MOREITEMTYPE_ALBUM, this);
        MoreItem video = new MoreItem("?????????", R.drawable.item_video, MoreItemType.MOREITEMTYPE_VIDEO, this);
        mItemsList.add(camera);
        mItemsList.add(album);
        mItemsList.add(video);
    }

    List<MsgModel> queryData() {

        return new ArrayList<>();
    }

    //????????????
    public void sendMsg(View view) {
        String inputText = mInputText.getText().toString();
        if (inputText != null && !inputText.equals("")) {

            MsgModel msgModel = new MsgModel(inputText, MsgType.MSGTYPE_TEXT, SendType.SENDTYPE_SEND);
            mMsgDBHelper.insertMsgModel(msgModel);
            //?????? ?????????
            mInputText.setText(null);
        }
    }

    // ?????? + ???
    public void moreItemsClick(View view) {
        inputbarIsUnFold = !inputbarIsUnFold;

        int margin_bottom = 0;

        if (inputbarIsUnFold) {
            //????????????
            margin_bottom = DimenUtils.dp2px(this, 250);
            moreitemLayout.setVisibility(ViewGroup.VISIBLE);
        } else {
            moreitemLayout.setVisibility(ViewGroup.GONE);
        }
        // input bar ????????????
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) inputbarlayout.getLayoutParams();
        layoutParams.bottomMargin = margin_bottom;
        inputbarlayout.setLayoutParams(layoutParams);

    }


    //MARK: more item onclick
    @Override
    public void onClickMoreItem(MoreItem moreItem) {
        switch (moreItem.type) {
            case MoreItemType.MOREITEMTYPE_CAMERA:
                break;
            case MoreItemType.MOREITEMTYPE_ALBUM:
                break;
            case MoreItemType.MOREITEMTYPE_VIDEO:
                break;
            default:
        }
    }

    //MARK: ---- text whatch  ---------

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d(TAG, "beforeTextChanged: " + "s???" + s);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d(TAG, "onTextChanged: "+ "s???" + s);
    }

    @Override

    public void afterTextChanged(Editable s) {
        Log.d(TAG, "afterTextChanged: "+ "s???" + s);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
            sendMsg(null);
            return true;
        }
        return false;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    //????????????????????????
    @Override
    public void getMsgHistory(List<MsgModel> msgs) {
        Log.d(TAG, "getMsgHistory: ");
    }
}