package com.helloworld.sections.designmodel.delegate;

import android.widget.Toast;

import com.helloworld.myApplication.MyApplication;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicPurchasing implements InvocationHandler {

    private Object mObject;

    public DynamicPurchasing(Object mObject) {
        this.mObject = mObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(mObject, args);
        if (method.getName().equals("buy")){
            Toast.makeText(MyApplication.getContext(),"动态代理买东西", Toast.LENGTH_SHORT).show();
        }

        return result;
    }
}
