package com.helloworld.sections.designmodel;

import android.util.Log;

// 单例模式

public class Singleton {
    //懒汉模式

    //MARK: ?? 安卓类加载机制是什么
    private static Singleton instance = new Singleton();

    private Singleton() {
        Log.d("====", "Singleton:  加载就创建");
    }

    public static Singleton getInstance() {
        Log.d("====", "getInstance:  加载就创建");
        return instance;
    }
}

// 线程不安全
  class  SingletonII {
    private  static SingletonII instance;

    private SingletonII() {

    }
    public static SingletonII getInstance(){
        if (instance == null){
            instance = new SingletonII();
        }
        return instance;
    }
}

//线程安全但是 有不必要的同步开销
class  SingletonIII {
    private static SingletonIII instance;

    private SingletonIII() {

    }

    public  static synchronized   SingletonIII getInstance(){
        if (instance == null) {
            instance = new SingletonIII();
        }
        return instance;
    }
}

//双重检查, DCL 可能会失效

class SingletonIV {
    private  static volatile SingletonIV instance;
    private  SingletonIV() {

    }

    public static  SingletonIV getInstance() {
        if (instance == null) {
            synchronized (SingletonIV.class) {
                if (instance == null) {
                    instance = new SingletonIV();
                }
            }
        }
        return instance;
    }
}

// 静态内部类单例, 推荐使用

class SingletonV {
    private  SingletonV(){

    }
    public static  SingletonV getInstance(){
        return SingletonHolder.sInstance;
    }

    private  static  class SingletonHolder {
        private  static  final SingletonV sInstance = new SingletonV();
    }
}




