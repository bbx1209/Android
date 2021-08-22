package com.helloworld.Handler;

import com.helloworld.BaseModel.ActivityModel;
import com.helloworld.Sections.NoficaitonActiviry.Notifaction;
import com.helloworld.Sections.ListView.ListViewActivity;
import com.helloworld.Sections.PassParam.PassParam;
import com.helloworld.Sections.UIElementActivity.UIElementActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeDataHandler {

    public List<ActivityModel> homeList() {
        List<ActivityModel> list = new ArrayList<>();

        ActivityModel model1 = new ActivityModel(Notifaction.class, "通知", null);
        list.add(model1);
        ActivityModel model2 = new ActivityModel(ListViewActivity.class, "列表页", null);
        list.add(model2);
        ActivityModel model3 = new ActivityModel(PassParam.class, "页面传值", null);
        list.add(model3);
        ActivityModel model4 = new ActivityModel(UIElementActivity.class, "UI元素", null);
        list.add(model4);

        return list;
    }


}
