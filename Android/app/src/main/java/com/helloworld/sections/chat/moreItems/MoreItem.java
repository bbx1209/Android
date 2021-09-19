package com.helloworld.sections.chat.moreItems;

public class MoreItem {

    public  String title;
    public  int imageDrable;
    public  MoreItemListener listener;

    public MoreItem(String title, int imageDrable, MoreItemListener listener) {
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
}
