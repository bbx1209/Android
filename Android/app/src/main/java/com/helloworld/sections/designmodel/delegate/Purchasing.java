package com.helloworld.sections.designmodel.delegate;

public class Purchasing implements IShop{
    private final IShop mIshop;

    public Purchasing(IShop mIshop) {
        this.mIshop = mIshop;
    }

    @Override
    public void buy() {
        mIshop.buy();
    }
}
