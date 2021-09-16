package com.helloworld.sections.designmodel.sample;

public abstract class AbstractAwordman {

    public  final void  fighting() {

        neigong();
        meridian();
        if (hasWeapons()) {
            weapons();
        }
        moves();
        hook();
    }

    protected void hook() {

    }

    protected abstract void moves();

    protected abstract void weapons();

    protected  boolean hasWeapons() {
        return true;
    }

    protected void meridian() {

    }

    protected abstract void neigong();


}
