package com.helloworld.Handler;

import com.helloworld.BaseModel.ActivityModel;
import com.helloworld.BaseModel.Params;
import com.helloworld.Sections.Animation.AnimationActivity;
import com.helloworld.Sections.Dialog.DialogActivity;
import com.helloworld.Sections.OKHttp.OKHttpActivity;
import com.helloworld.Sections.ViewPager.ViewPager2Activity;
import com.helloworld.Sections.broatCast.BroadCastActivity;
import com.helloworld.Sections.chat.ChatActivity;
import com.helloworld.Sections.fragment.FragmentActivity;
import com.helloworld.Sections.NoficaitonActiviry.Notifaction;
import com.helloworld.Sections.ListView.ListViewActivity;
import com.helloworld.Sections.PassParam.PassParam;
import com.helloworld.Sections.Popwindow.PopWindowActivity;
import com.helloworld.Sections.UIElementActivity.UIElementActivity;
import com.helloworld.Sections.ViewPager.ViewPagerActivity;
import com.helloworld.Sections.glide.GlideActivity;
import com.helloworld.Sections.weChat.WeChatActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeDataHandler {

    final List<ActivityModel> list = new ArrayList<>();

    public List<ActivityModel> homeList() {

        addItemToList(ChatActivity.class, "聊天页面", null);
        ActivityModel model1 = new ActivityModel(Notifaction.class, "通知", null);
        list.add(model1);
        ActivityModel model2 = new ActivityModel(ListViewActivity.class, "列表页", null);
        list.add(model2);
        ActivityModel model3 = new ActivityModel(PassParam.class, "页面传值", null);
        list.add(model3);
        ActivityModel model4 = new ActivityModel(UIElementActivity.class, "UI元素", null);
        list.add(model4);
        ActivityModel model5 = new ActivityModel(PopWindowActivity.class, "PopWindow", null);
        list.add(model5);
        addItemToList(DialogActivity.class, "dialog", null);
        addItemToList(ViewPagerActivity.class, "view pager", null);
        addItemToList(ViewPager2Activity.class, "view pager 2", null);
        addItemToList(AnimationActivity.class, "动画", null);
        addItemToList(FragmentActivity.class, "Fragment", null);
        addItemToList(WeChatActivity.class, "微信", null);
        addItemToList(BroadCastActivity.class, "广播", null);
        addItemToList(OKHttpActivity.class, "okHttp", null);
        addItemToList(GlideActivity.class, "glide usage", null);

        return list;
    }

     void  addItemToList(Class aclass , String title, Params param) {
         ActivityModel model = new ActivityModel(aclass, title ,param);
         list.add(model);
     }


}
