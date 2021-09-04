package com.helloworld.Handler;

import com.helloworld.basemodel.ActivityModel;
import com.helloworld.basemodel.Params;
import com.helloworld.sections.Animation.AnimationActivity;
import com.helloworld.sections.Dialog.DialogActivity;
import com.helloworld.sections.OKHttp.OKHttpActivity;
import com.helloworld.sections.Photo.PhotoActivity;
import com.helloworld.sections.ViewPager.ViewPager2Activity;
import com.helloworld.sections.audio_video.AudioVideoActivity;
import com.helloworld.sections.broatCast.BroadCastActivity;
import com.helloworld.sections.chat.ChatActivity;
import com.helloworld.sections.database.DataBaseActivity;
import com.helloworld.sections.database.room.RoomActivity;
import com.helloworld.sections.fragment.MyFragmentActivity;
import com.helloworld.sections.NoficaitonActiviry.Notifaction;
import com.helloworld.sections.ListView.ListViewActivity;
import com.helloworld.sections.passparam.PassParam;
import com.helloworld.sections.popwindow.PopWindowActivity;
import com.helloworld.sections.uiElementActivity.UIElementActivity;
import com.helloworld.sections.ViewPager.ViewPagerActivity;
import com.helloworld.sections.glide.GlideActivity;
import com.helloworld.sections.service.ServiceActivity;
import com.helloworld.sections.thread.ThreadActivity;
import com.helloworld.sections.weChat.WeChatActivity;
import com.helloworld.sections.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeDataHandler {

    final List<ActivityModel> list = new ArrayList<>();

    public List<ActivityModel> homeList() {

        addItemToList(RoomActivity.class, "Room存储", null);
        addItemToList(DataBaseActivity.class, "数据存储", null);
        addItemToList(PhotoActivity.class, "拍照与相片", null);
        addItemToList(AudioVideoActivity.class, "音视频", null);
        addItemToList(ThreadActivity.class, "多线程", null);
        addItemToList(ServiceActivity.class, "服务Service", null);
        addItemToList(WebViewActivity.class, "webView", null);

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
