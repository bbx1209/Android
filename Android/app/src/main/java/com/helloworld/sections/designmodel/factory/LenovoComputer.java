package com.helloworld.sections.designmodel.factory;

import android.widget.Toast;

import com.helloworld.myApplication.MyApplication;

public class LenovoComputer extends  Computer{
    @Override
    public void start() {
        Toast.makeText(MyApplication.getContext(),"Lenovo", Toast.LENGTH_SHORT).show();
    }
}
