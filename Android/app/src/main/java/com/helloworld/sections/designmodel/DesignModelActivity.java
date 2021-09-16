package com.helloworld.sections.designmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.helloworld.R;
import com.helloworld.sections.designmodel.factory.GDComputerFactory;
import com.helloworld.sections.designmodel.factory.HpComputer;

public class DesignModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_model);
    }


    public void createSingleton(View view) {

        int view_id = view.getId();
        switch (view_id) {
            case R.id.singleton:
                break;
            case R.id.singletonII:
                break;
            default:
        }
    }

    public void createFactory(View view) {
        int view_id = view.getId();
        switch (view_id) {
            case R.id.factory_simple:
                break;
            case R.id.factory_nomal:
                GDComputerFactory factory = new GDComputerFactory();
                HpComputer computer = factory.createComputer(HpComputer.class);
                computer.start();;

                break;
            default:
        }
    }

}