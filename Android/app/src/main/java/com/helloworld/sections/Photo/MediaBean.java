package com.helloworld.sections.Photo;

public class MediaBean {

    public  static final  int Image = 1;
    public  static final  int Video = 2;

    public  int type;
    public  String path;
    public  long size;
    public  String displayName;
    public  String thumbPath;
    public  int duration;

    public MediaBean(int type, String path, long size, String displayName) {
        this.type = type;
        this.path = path;
        this.size = size;
        this.displayName = displayName;
    }

    public MediaBean(int type, String path, String thumbPath, int duration,long size,String displayName) {
        this.type = type;
        this.path = path;
        this.displayName = displayName;
        this.thumbPath = thumbPath;
        this.duration = duration;
        this.size = size;
    }
}
