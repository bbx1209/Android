package com.helloworld.Sections.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.helloworld.R;


public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG ="FragmentActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


        Button replaceBut = findViewById(R.id.replaceBut);
        replaceBut.setOnClickListener(this);

        Button removeBut = findViewById(R.id.removeBut);
        removeBut.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.replaceBut:
                Log.e(TAG, "onClick: replace" );
                replaceFregment(new Fragment_blank());
                break;
            case R.id.removeBut:
                Log.e(TAG, "onClick: remove" );
                replaceFregment(new Fragment_red());
                break;
            default:
                break;
        }
    }

    void replaceFregment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLaout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}