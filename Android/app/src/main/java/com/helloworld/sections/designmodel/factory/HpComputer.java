package com.helloworld.sections.designmodel.factory;

import android.widget.Toast;

import com.helloworld.myApplication.MyApplication;

public class HpComputer extends Computer{
    @Override
    public void start() {
        Toast.makeText(MyApplication.getContext(),"HP", Toast.LENGTH_SHORT).show();
    }
}
