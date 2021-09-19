package com.helloworld.sections.chat.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.helloworld.sections.chat.dbhelper.TableName;

import java.util.Date;
import java.util.UUID;

@Entity(tableName = TableName.TRABLENAME_MESSAGE)
public class MsgModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    public String msgId;
    public String msgContent;
    public int msgType;
    public int sendType;
    public int sendState;
    public Date msgDate;

    public MsgModel(String msgContent, int msgType, int sendType) {
        this.msgContent = msgContent;
        this.msgType = msgType;
        this.sendType = sendType;
        this.msgId = UUID.randomUUID().toString();
        this.msgDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public int getSendType() {
        return sendType;
    }

    public void setSendType(int sendType) {
        this.sendType = sendType;
    }

    public int getSendState() {
        return sendState;
    }

    public void setSendState(int sendState) {
        this.sendState = sendState;
    }


    public String getMsgId() {
        return msgId;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(Date msgDate) {
        this.msgDate = msgDate;
    }
}
