package com.helloworld.sections.designmodel.builder;

public class Director {
Builder mBuilder = null;

    public Director(Builder mBuilder) {
        this.mBuilder = mBuilder;
    }
    public  Product createProduct(String cpu, String ram) {
        mBuilder.buileCpu(cpu);
        mBuilder.buileRam(ram);
        return mBuilder.create();
    }
}
