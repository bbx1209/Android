package com.helloworld.sections.designmodel.strategy;

import android.util.Log;

public class CommonRivalStrategy implements  FightingStrategy{
    @Override
    public void finghting() {
        Log.d("strategy", "CommonRivalStrategy: ");
    }
}
