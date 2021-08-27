package com.helloworld.Sections.Fragment;

import androidx.appcompat.app.AppCompatActivity;

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
                break;
            case R.id.removeBut:
                Log.e(TAG, "onClick: remove" );
                break;
            default:
                break;
        }
    }

//    public void replaceAction(View view) {
//    }
//
//    public void removeAction(View view) {
//    }
}