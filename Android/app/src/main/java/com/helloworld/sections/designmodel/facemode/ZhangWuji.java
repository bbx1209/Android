package com.helloworld.sections.designmodel.facemode;

import android.app.PendingIntent;
import android.view.View;

import androidx.room.PrimaryKey;

public class ZhangWuji {
    private Jingmai jingmai;
    private Zhaoshi zhaoshi;
    private Neigong neigong;

    public ZhangWuji() {
        jingmai = new Jingmai();
        neigong = new Neigong();
        zhaoshi = new Zhaoshi();
    }

    public void  QianKun() {
        jingmai.jingmai();;
        neigong.jiuyang();
    }

    public void taiji() {
        jingmai.jingmai();
        zhaoshi.TaiJiQuan();
    }

}
