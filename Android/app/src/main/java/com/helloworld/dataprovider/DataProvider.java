package com.helloworld.dataprovider;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.helloworld.R;
import com.helloworld.dataprovider.DataItem;

public class DataProvider {

    private static DataItem[] dataItems = {
            new DataItem("小猫", R.drawable.mao),
            new DataItem("猫草", R.drawable.maocao),
            new DataItem("逗猫棒", R.drawable.maodoumaobang),
            new DataItem("猫粮 阿斯蒂芬静安里肯定是法地方号但是爱的很舒服嘎接口了和大家还得改安徽打过去饿哦让我候偶然换个群饿哦入会费Oahu哈的说法胡的说法以好地方GIA"
                    , R.drawable.maoliang),
            new DataItem("毛条", R.drawable.maotiao),
            new DataItem("小鱼", R.drawable.maoxiaoyugan),
            new DataItem("猫抓板", R.drawable.maozhuaban),
    };

    private static List<DataItem> mList = new ArrayList<>();

    public static List<DataItem> getDataItems() {
        initCardModels();
        return mList;
    }

    private static void initCardModels() {
        mList.clear();
        StringBuilder stringBuilder;
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(dataItems.length);
            DataItem item = dataItems[index];

            mList.add(item);
        }
    }

}








