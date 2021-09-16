package com.helloworld.sections.designmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.helloworld.R;
import com.helloworld.sections.designmodel.builder.Director;
import com.helloworld.sections.designmodel.builder.ProductBuilder;
import com.helloworld.sections.designmodel.delegate.DynamicPurchasing;
import com.helloworld.sections.designmodel.delegate.IShop;
import com.helloworld.sections.designmodel.delegate.Me;
import com.helloworld.sections.designmodel.delegate.Purchasing;
import com.helloworld.sections.designmodel.facemode.ZhangWuji;
import com.helloworld.sections.designmodel.factory.GDComputerFactory;
import com.helloworld.sections.designmodel.factory.HpComputer;
import com.helloworld.sections.designmodel.makeup.HongQiGong;
import com.helloworld.sections.designmodel.makeup.OuYangfeng;
import com.helloworld.sections.designmodel.makeup.YangGuo;
import com.helloworld.sections.designmodel.observer.SubscriptionSubject;
import com.helloworld.sections.designmodel.observer.WeiXinUser;
import com.helloworld.sections.designmodel.sample.ZhangSanfeng;
import com.helloworld.sections.designmodel.shareone.GoodFactory;
import com.helloworld.sections.designmodel.shareone.Goods;
import com.helloworld.sections.designmodel.strategy.CommonRivalStrategy;
import com.helloworld.sections.designmodel.strategy.StrategyContext;
import com.helloworld.sections.designmodel.strategy.WeakRivalStrategy;

import java.lang.reflect.Proxy;

public class DesignModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_model);
    }


    public void createSingleton(View view) {

        int view_id = view.getId();
        switch (view_id) {
            case R.id.singleton:
                break;
            case R.id.singletonII:
                break;
            default:
        }
    }

    public void createFactory(View view) {
        int view_id = view.getId();
        switch (view_id) {
            case R.id.factory_simple:
                break;
            case R.id.factory_nomal:
                GDComputerFactory factory = new GDComputerFactory();
                HpComputer computer = factory.createComputer(HpComputer.class);
                computer.start();

                break;
            default:
        }
    }

    public void createBuilder(View view) {

        ProductBuilder builder = new ProductBuilder();
        Director director = new Director(builder);
        director.createProduct("core i7", "4G");

    }

    public void delegateAction(View view) {
        int view_id = view.getId();
        switch (view_id) {
            case R.id.static_delegate:
                Me me1 = new Me();
                Purchasing purchasing1 = new Purchasing(me1);
                purchasing1.buy();
                break;
            case R.id.dynamic_delegate:
                IShop me = new Me();
                DynamicPurchasing purchasing = new DynamicPurchasing(me);
                ClassLoader classLoader = me.getClass().getClassLoader();
                IShop object = (IShop) Proxy.newProxyInstance(classLoader, new Class[]{IShop.class}, purchasing);
                object.buy();
                break;
            default:
        }
    }

    public void makeupAction(View view) {

        YangGuo yangGuo = new YangGuo();

        HongQiGong hongQiGong = new HongQiGong(yangGuo);
        hongQiGong.attackMagic();

        OuYangfeng ouYangfeng = new OuYangfeng(yangGuo);
        ouYangfeng.attackMagic();

    }

    public void facemodeAction(View view) {

        ZhangWuji zhangWuji = new ZhangWuji();
        zhangWuji.taiji();
        zhangWuji.QianKun();

    }

    public void shareAction(View view) {
        Goods goods = GoodFactory.getGoods("iPhone12");
        goods.showGoodPrice("32G");
        Goods goods1 = GoodFactory.getGoods("iPhone12");
        goods1.showGoodPrice("128G");

    }

    public void strategyAction(View view) {
        StrategyContext context;
        context= new StrategyContext(new WeakRivalStrategy());
        context.fighting();

        context = new StrategyContext(new CommonRivalStrategy());
        context.fighting();



    }


    public void sampleAction(View view) {
        ZhangSanfeng zhangSanfeng = new ZhangSanfeng();
        zhangSanfeng.fighting();

    }

    public void observerAction(View view) {

        SubscriptionSubject subject = new SubscriptionSubject();

        WeiXinUser weiXinUser = new WeiXinUser("打的费");
        WeiXinUser weiXinUser2 = new WeiXinUser("复工后的");

        subject.attach(weiXinUser);
        subject.attach(weiXinUser2);
        subject.notify("更新消息");

    }
}