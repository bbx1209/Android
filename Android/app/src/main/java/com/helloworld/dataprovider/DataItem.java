package com.helloworld.dataprovider;

import java.util.Date;

public class DataItem {

    private String title;
    private String subTitle;
    private String description;
    private String imageUrl;
    private boolean isSelected;
    private int price;
    private Date date;

    public DataItem(String title) {
        this.title = title;
    }
    public DataItem() {

    }

    public DataItem(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

}
