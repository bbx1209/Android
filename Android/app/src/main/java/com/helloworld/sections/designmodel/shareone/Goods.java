package com.helloworld.sections.designmodel.shareone;

import android.widget.Toast;

import com.helloworld.myApplication.MyApplication;

public class Goods implements IGoods {
    private String name;
    private String version;

    public Goods(String name) {
        this.name = name;
    }

    @Override
    public void showGoodPrice(String name) {
        if (version.equals("32G")) {
            Toast.makeText(MyApplication.getContext(), "5199人民币", Toast.LENGTH_SHORT).show();
        } else if (version.equals("128G")) {
            Toast.makeText(MyApplication.getContext(), "5999人民币", Toast.LENGTH_SHORT).show();
        }
    }
}
