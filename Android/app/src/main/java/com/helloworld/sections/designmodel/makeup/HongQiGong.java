package com.helloworld.sections.designmodel.makeup;

import android.widget.Toast;

import com.helloworld.myApplication.MyApplication;

public class HongQiGong extends Master{
    public HongQiGong(SwordMan mSwordman) {
        super(mSwordman);
    }

    public  void teachAttack() {
        Toast.makeText(MyApplication.getContext(),"洪七公教会杨过打狗棒法！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void attackMagic() {
        super.attackMagic();
        teachAttack();
    }
}
