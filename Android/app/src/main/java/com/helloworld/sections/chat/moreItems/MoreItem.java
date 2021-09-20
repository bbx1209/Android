package com.helloworld.sections.chat.moreItems;

import android.graphics.drawable.Drawable;

public class MoreItem {

    public  String title;
    public Drawable imageDrable;
    public  MoreItemListener listener;

    public MoreItem(String title, Drawable imageDrable, MoreItemListener listener) {
        this.title = title;
        this.imageDrable = imageDrable;
        this.listener = listener;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getImageDrable() {
        return imageDrable;
    }

    public void setImageDrable(Drawable imageDrable) {
        this.imageDrable = imageDrable;
    }

    public MoreItemListener getListener() {
        return listener;
    }

    public void setListener(MoreItemListener listener) {
        this.listener = listener;
    }
}
