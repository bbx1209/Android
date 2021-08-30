package com.helloworld.Sections.chat;

public class MsgModel {
    public  String msgContent;
    public  MsgType msgType;


    public MsgModel(String msgContent, MsgType msgType) {
        this.msgContent = msgContent;
        this.msgType = msgType;
    }
}
