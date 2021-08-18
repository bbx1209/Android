package com.helloworld.BaseModel;

public class ActivityModel {

    public  Class aclass;
    public  String mainTitle;
    public  Params params;

    public ActivityModel(Class aclass, String mainTitle, Params params) {
        this.aclass = aclass;
        this.mainTitle = mainTitle;
        this.params = params;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public Params getParams() {
        return params;
    }
}
