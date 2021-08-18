package com.helloworld.Handler;

import com.helloworld.BaseModel.ActivityModel;

import java.util.ArrayList;
import java.util.List;

public class HomeDataHandler {

    public List<ActivityModel> homeList() {
        List<ActivityModel> list = new ArrayList<>();

        ActivityModel model1 = new ActivityModel("Notifaction", "通知", null);
        list.add(model1);

        return list;
    }


}
