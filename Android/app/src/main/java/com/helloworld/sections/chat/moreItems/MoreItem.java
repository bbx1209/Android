package com.helloworld.sections.chat.moreItems;

import android.graphics.drawable.Drawable;

import com.helloworld.sections.chat.ChatActivity;

public class MoreItem {

    public String title;
    public int imageDrable;
    public MoreItemListener listener;
    public int type;

    public MoreItem(String title, int imageDrable, int type,MoreItemListener listener) {
        this.title = title;
        this.imageDrable = imageDrable;
        this.listener = listener;
        this.type = type;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageDrable() {
        return imageDrable;
    }

    public void setImageDrable(int imageDrable) {
        this.imageDrable = imageDrable;
    }

    public MoreItemListener getListener() {
        return listener;
    }

    public void setListener(MoreItemListener listener) {
        this.listener = listener;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
