package com.helloworld.sections.Photo;

public class MediaBean {

    public  static final  int Image = 1;
    public  static final  int Video = 2;

    public  int type;
    public  String path;
    public  int size;
    public  String displayName;

    public MediaBean(int type, String path, int size, String displayName) {
        this.type = type;
        this.path = path;
        this.size = size;
        this.displayName = displayName;
    }


}
