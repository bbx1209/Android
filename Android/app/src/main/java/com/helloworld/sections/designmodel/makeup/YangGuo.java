package com.helloworld.sections.designmodel.makeup;

import android.widget.Toast;

import com.helloworld.myApplication.MyApplication;

public class YangGuo extends SwordMan{
    @Override
    public void attackMagic() {
        Toast.makeText(MyApplication.getContext(), "全真剑法", Toast.LENGTH_SHORT).show();
    }
}
