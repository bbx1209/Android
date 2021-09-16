package com.helloworld.sections.designmodel.makeup;

public abstract class Master extends  SwordMan{

    private  SwordMan mSwordman;

    public Master(SwordMan mSwordman) {
        this.mSwordman = mSwordman;
    }

    @Override
    public void attackMagic() {
        mSwordman.attackMagic();
    }
}
