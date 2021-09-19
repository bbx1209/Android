package com.helloworld.sections.chat.dbhelper;

import android.content.Context;
import android.os.AsyncTask;

import com.helloworld.sections.chat.model.MsgModel;

public class MsgDBHelper {

    private MsgModelDao mDao;
    private Context mContext;

    public MsgDBHelper(Context mContext) {
        MsgModelDatabase modelDatabase = MsgModelDatabase.getInstance();
        this.mDao = modelDatabase.getMsgModelDao();
        this.mContext = mContext;
    }

    public void insertMsgModel(MsgModel msgModel) {
        new InsertAsyncTask(mDao).execute(msgModel);
    }






    public abstract  class  DatabaseAsyncTask extends AsyncTask<MsgModel ,Void, Void> {
        public   MsgModelDao mDao;
    }

    private  class  InsertAsyncTask extends  DatabaseAsyncTask {

        public InsertAsyncTask(MsgModelDao dao) {
            this.mDao = dao;
        }

        @Override
        protected Void doInBackground(MsgModel... msgModels) {
            mDao.insertMsgs(msgModels);
            return null;
        }
    }



}
