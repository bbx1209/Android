package com.helloworld.BaseModel;

public class ActivityModel {

    public  String activityName;
    public  String mainTitle;
    public  Params params;


    public ActivityModel(String activityName, String mainTitle) {
        this.activityName = activityName;
        this.mainTitle = mainTitle;
    }

    public ActivityModel(String activityName, String mainTitle, Params params) {
        this.activityName = activityName;
        this.mainTitle = mainTitle;
        this.params = params;
    }


    public String getActivityName() {
        return activityName;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public Params getParams() {
        return params;
    }
}
