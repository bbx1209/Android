package com.helloworld.sections.designmodel.factory;

public abstract class AbstractFactory {
    public  abstract<T extends  Computer> T createComputer(Class<T> clz);
}
