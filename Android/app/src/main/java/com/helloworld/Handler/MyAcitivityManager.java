package com.helloworld.Handler;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class MyAcitivityManager {

    private static List<Activity> activityList = new ArrayList();

    public static void pushActivity(Activity activity) {
        if (activity != null) {
            activityList.add(activity);
        }
    }

    public static void popActivity(Activity activity) {

        if (activity != null) {
            activityList.remove(activity);
        }

    }

    public static void finishAll() {

        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
    }

}
