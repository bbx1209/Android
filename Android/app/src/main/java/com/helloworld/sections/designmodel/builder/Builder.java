package com.helloworld.sections.designmodel.builder;

public abstract class Builder {
    public abstract void buileCpu(String cpu);
    public abstract void buileRam(String ram);
    public abstract Product create();
}
