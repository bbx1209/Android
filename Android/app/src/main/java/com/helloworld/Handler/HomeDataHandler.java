package com.helloworld.Handler;

import com.helloworld.BaseModel.ActivityModel;
import com.helloworld.BaseModel.Params;
import com.helloworld.Sections.Animation.AnimationActivity;
import com.helloworld.Sections.Dialog.DialogActivity;
import com.helloworld.Sections.OKHttp.OKHttpActivity;
import com.helloworld.Sections.Photo.PhotoActivity;
import com.helloworld.Sections.ViewPager.ViewPager2Activity;
import com.helloworld.Sections.audio_video.AudioVideoActivity;
import com.helloworld.Sections.broatCast.BroadCastActivity;
import com.helloworld.Sections.chat.ChatActivity;
import com.helloworld.Sections.database.DataBaseActivity;
import com.helloworld.Sections.fragment.MyFragmentActivity;
import com.helloworld.Sections.NoficaitonActiviry.Notifaction;
import com.helloworld.Sections.ListView.ListViewActivity;
import com.helloworld.Sections.PassParam.PassParam;
import com.helloworld.Sections.Popwindow.PopWindowActivity;
import com.helloworld.Sections.UIElementActivity.UIElementActivity;
import com.helloworld.Sections.ViewPager.ViewPagerActivity;
import com.helloworld.Sections.glide.GlideActivity;
import com.helloworld.Sections.thread.ThreadActivity;
import com.helloworld.Sections.weChat.WeChatActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeDataHandler {

    final List<ActivityModel> list = new ArrayList<>();

    public List<ActivityModel> homeList() {

        addItemToList(DataBaseActivity.class, "数据存储", null);
        addItemToList(PhotoActivity.class, "拍照与相片", null);
        addItemToList(AudioVideoActivity.class, "音视频", null);
        addItemToList(ThreadActivity.class, "多线程", null);

        addItemToList(ChatActivity.class, "聊天页面", null);

        addItemToList(Notifaction.class, "通知", null);

        addItemToList(ListViewActivity.class, "列表页", null);

        addItemToList(PassParam.class, "页面传值", null);

        addItemToList(UIElementActivity.class, "UI元素", null);

        addItemToList(PopWindowActivity.class, "PopWindow", null);

        addItemToList(DialogActivity.class, "dialog", null);
        addItemToList(ViewPagerActivity.class, "view pager", null);
        addItemToList(ViewPager2Activity.class, "view pager 2", null);
        addItemToList(AnimationActivity.class, "动画", null);
        addItemToList(MyFragmentActivity.class, "Fragment", null);
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
