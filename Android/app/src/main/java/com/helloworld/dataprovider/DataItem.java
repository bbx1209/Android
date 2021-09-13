package com.helloworld.dataprovider;

import java.util.Date;

public class DataItem {

    private String title;
    private String subTitle;
    private String description;
    private String imageUrl;
    private int localImage;
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

    public DataItem(String title, int localImage) {
        this.title = title;
        this.localImage = localImage;
    }

    public int getLocalImage() {
        return localImage;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public int getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setLocalImage(int localImage) {
        this.localImage = localImage;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
