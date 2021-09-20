package com.helloworld.sections.chat.model;

public interface SendState {
    //发送中
    public static final int SENDSTATE_SENDING = 0;
    //发送成功
    public static final int SENDSTATE_SUCCESS = 1;
    //发送失败
    public static final int SENDSTATE_FAILED = 2;
}
