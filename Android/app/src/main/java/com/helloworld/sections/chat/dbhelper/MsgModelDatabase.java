package com.helloworld.sections.chat.dbhelper;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.helloworld.myApplication.MyApplication;
import com.helloworld.sections.chat.model.MsgModel;

import com.helloworld.sections.chat.dbhelper.MsgModelDao;
import com.helloworld.sections.database.room.Book_roomDatabase;

@Database(entities = {MsgModel.class}, version = 1, exportSchema = false)
public abstract class MsgModelDatabase extends RoomDatabase {

    public abstract  MsgModelDao getMsgModelDao();

    public static  MsgModelDatabase instance = null;
    public  static  synchronized  MsgModelDatabase getInstance() {
        if (instance == null) {
            instance = Room.databaseBuilder
                    (MyApplication.getContext().getApplicationContext(), MsgModelDatabase.class, TableName.TRABLENAME_MESSAGE)
                    .build();
        }
        return instance;
    }

}
