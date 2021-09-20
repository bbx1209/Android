package com.helloworld.sections.chat.dbhelper;

import android.view.View;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.helloworld.sections.chat.model.MsgModel;

import java.util.List;

@Dao
public interface MsgModelDao {
    @Insert
    void insertMsgs(MsgModel... models);

    @Update
    void updateMsgs(MsgModel... models);
    @Delete
    int deleteMsgs(MsgModel ... models);
    @Query("delete from message")
    void deleteAllMsgs();
    @Query("select * from message")
    List<MsgModel> queryAllMsgmodels();

}
