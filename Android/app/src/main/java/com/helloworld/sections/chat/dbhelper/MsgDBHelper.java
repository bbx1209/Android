package com.helloworld.sections.chat.dbhelper;

import android.content.Context;

public class MsgDBHelper {

    private MsgModelDao mDao;
    private Context mContext;

    public MsgDBHelper(Context mContext) {
        MsgModelDatabase modelDatabase = MsgModelDatabase.getInstance();
        this.mDao = modelDatabase.getMsgModelDao();
        this.mContext = mContext;
    }
}
