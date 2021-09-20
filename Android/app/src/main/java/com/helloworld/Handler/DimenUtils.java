package com.helloworld.Handler;

import android.content.Context;

import java.lang.reflect.Method;

public class DimenUtils {

    /**
     * dp 转 px
     */

    public static int dp2px(Context context, float dpValue) {
        if (context == null) {
            return (int) dpValue;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) Math.ceil(dpValue * scale);
//        return (int)(dpValue * scale + 0.5f);
    }


    //px 转 dp
    public static int px2dp(Context context, float pxValue) {
        if (context == null) {
            return (int) pxValue;
        }

        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) Math.ceil(pxValue / scale);
//        return (int) (pxValue / scale + 0.5f);
    }


    //sp 转 px
    public static int sp2ps(Context context, float spValue) {
        if (context == null) {
            return (int) spValue;
        }

        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) Math.ceil(spValue * fontScale);

//        return (int) (spValue * fontScale + 0.5f);
    }

    // px 转 sp
    public static int px2sp(Context context, float pxValue) {
        if (context == null) {
            return (int) pxValue;

        }
        final float fontSc = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) Math.ceil(pxValue / fontSc);
//        return (int) (pxValue / fontSc + 0.5);
    }

}
