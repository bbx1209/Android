package com.helloworld.sections.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.helloworld.interfaces.ParamInterface;
import com.helloworld.R;


public class MyFragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG ="FragmentActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


        Button replaceBut = findViewById(R.id.replaceBut);
        replaceBut.setOnClickListener(this);

        Button removeBut = findViewById(R.id.removeBut);
        removeBut.setOnClickListener(this);

        // activity 调 fragment 的方法

//        FragmentManager supportFragmentManager = getSupportFragmentManager();
//        supportFragmentManager.findFragmentById(R.id.)

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.replaceBut:
                Log.e(TAG, "onClick: replace" );
                replaceFregment(new Fragment_blank(new ParamInterface() {
                    @Override
                    public void sentParamToActivity(String msg) {
                        Log.e(TAG, "sentParamToActivity: "+ msg );
                    }

                    @Override
                    public String getParamFromActivity() {
                        return "返回的参数";
                    }
                }));
                break;
            case R.id.removeBut:
                Log.e(TAG, "onClick: remove" );

                Bundle bundle = new Bundle();
                bundle.putString("msg", "this is a param");
                bundle.putString("key", "this is a param");
                Fragment_red fragment_red = new Fragment_red();

                fragment_red.setArguments(bundle);

                replaceFregment(fragment_red);
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

    public  void fragmentCallActivity() {
        Toast.makeText(this, "fragment call activity ", Toast.LENGTH_LONG).show();
    }

}