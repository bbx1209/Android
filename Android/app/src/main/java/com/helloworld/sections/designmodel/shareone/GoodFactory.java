package com.helloworld.sections.designmodel.shareone;

import java.util.HashMap;
import java.util.Map;

public class GoodFactory {
    private static Map<String, Goods> pool = new HashMap<String, Goods>();
    public static Goods getGoods(String name) {
        if (pool.containsKey(name)) {
            return pool.get(name);
        } else {
            Goods goods = new Goods(name);
            pool.put(name,goods);
            return goods;
        }
    }
}
