package com.helloworld.sections.designmodel.observer;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject {

    private List<Observer> users = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        users.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        users.remove(observer);
    }

    @Override
    public void notify(String msg) {
        for (Observer observer : users) {
            observer.update(msg);
        }
    }
}
