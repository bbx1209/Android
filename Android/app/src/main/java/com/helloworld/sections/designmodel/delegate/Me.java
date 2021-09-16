package com.helloworld.sections.designmodel.delegate;

import android.widget.Toast;

import com.helloworld.myApplication.MyApplication;

public class Me implements IShop{
    @Override
    public void buy() {
        Toast.makeText(MyApplication.getContext(), "我买东西", Toast.LENGTH_SHORT).show();
    }
}
