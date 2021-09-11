package com.helloworld.Sections.materialdesign;

public class CardModel {

    private  String name;
    private  int imageId;

    public CardModel(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
