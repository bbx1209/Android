package com.helloworld.sections.designmodel.makeup;

import android.widget.Toast;

import com.helloworld.myApplication.MyApplication;

public class OuYangfeng extends Master{
    public OuYangfeng(SwordMan mSwordman) {
        super(mSwordman);
    }
    public  void teachAttack() {
        Toast.makeText(MyApplication.getContext(),"欧阳锋教会杨过蛤蟆功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void attackMagic() {
        super.attackMagic();
        teachAttack();
    }
}
