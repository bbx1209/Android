package com.helloworld.sections.chat;

public class MsgModel {
    public  static  final  int RECEIVE = 0;
    public  static  final  int SEND = 1;

    public  String msgContent;
    public  MsgType msgType;
    public  int sendType;

    public MsgModel(String msgContent, MsgType msgType, int sendType) {
        this.msgContent = msgContent;
        this.msgType = msgType;
        this.sendType = sendType;
    }
}
