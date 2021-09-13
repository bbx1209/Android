package com.helloworld.sections.passparam;

import java.io.Serializable;

public class SerializableModel implements Serializable {

    private String name;

    private int age;

    private boolean isDriver;

    public SerializableModel(String name, int age, boolean isDriver) {
        this.name = name;
        this.age = age;
        this.isDriver = isDriver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDriver() {
        return isDriver;
    }

    public void setDriver(boolean driver) {
        isDriver = driver;
    }
}



