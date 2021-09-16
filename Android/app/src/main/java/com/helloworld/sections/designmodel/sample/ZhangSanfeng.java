package com.helloworld.sections.designmodel.sample;

import android.util.Log;

public class ZhangSanfeng extends AbstractAwordman{
    @Override
    protected void moves() {
        Log.d("ZhangSanfeng", "moves: ");
    }

    @Override
    protected void weapons() {
        Log.d("ZhangSanfeng", "weapons: ");
    }

    @Override
    protected void neigong() {
        Log.d("ZhangSanfeng", "neigong: ");
    }

    @Override
    protected void hook() {
        Log.d("ZhangSanfeng", "hook: ");
    }
}
