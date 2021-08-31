package com.helloworld.Sections.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.helloworld.Interfaces.ParamInterface;
import com.helloworld.R;


public class Fragment_blank extends Fragment {

    private static final String TAG = "Fragment";
    private  View root;

   private ParamInterface paramInterface;


    public Fragment_blank(ParamInterface paramInterface) {
        this.paramInterface = paramInterface;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String param = paramInterface.getParamFromActivity();

        Log.e(TAG, "onCreate: " + param );

        // fragment 调activity 的方法
        MyFragmentActivity activity = (MyFragmentActivity)getActivity();

        activity.fragmentCallActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root == null) {
            root =  inflater.inflate(R.layout.fragment_blank, container, false);
        }

        Button button = root.findViewById(R.id.but);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paramInterface.sentParamToActivity("msg from framgment");

            }
        });

        return  root;
    }
}