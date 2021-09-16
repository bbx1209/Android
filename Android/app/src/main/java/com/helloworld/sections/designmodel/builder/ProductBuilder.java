package com.helloworld.sections.designmodel.builder;

public class ProductBuilder extends Builder {

    private Product mProduct = new Product();

    @Override
    public void buileCpu(String cpu) {
        mProduct.setmCpu(cpu);

    }

    @Override
    public void buileRam(String ram) {
        mProduct.setmRam(ram);
    }

    @Override
    public Product create() {
        return mProduct;
    }
}
