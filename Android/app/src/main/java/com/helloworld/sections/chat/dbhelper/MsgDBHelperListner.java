package com.helloworld.sections.chat.dbhelper;

import com.helloworld.sections.chat.model.MsgModel;

import java.util.List;

public interface MsgDBHelperListner {

    public  void getMsgHistory(List<MsgModel> msgs);
}
