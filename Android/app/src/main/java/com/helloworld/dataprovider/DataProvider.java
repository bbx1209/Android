package com.helloworld.dataprovider;

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
            new DataItem("猫粮", R.drawable.maoliang),
            new DataItem("毛条", R.drawable.maotiao),
            new DataItem("小鱼", R.drawable.maoxiaoyugan),
            new DataItem("猫抓板", R.drawable.maozhuaban),
    };

    private static List<DataItem> mList = new ArrayList<>();


    public static List<DataItem> getDataItems() {

        return mList;
    }

    private static void initCardModels() {
        mList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(dataItems.length);
            mList.add(dataItems[index]);
        }
    }

}








