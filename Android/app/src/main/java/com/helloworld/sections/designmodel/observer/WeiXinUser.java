package com.helloworld.sections.designmodel.observer;

import android.util.Log;

public class WeiXinUser implements Observer {

    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        Log.d("WeiXinUser", "update: "+name + ": "+ msg);
    }
}
