package com.helloworld.Sections.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.helloworld.R;


public class Fragment_red extends Fragment {

    private static final String TAG = "red fragment";
    private View root;

    public Fragment_red() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (root == null) {
            root = inflater.inflate(R.layout.fragment_red, container, false);
        }

        Bundle bundle = getArguments();
        
        String msg = bundle.getString("msg");
        String key = bundle.getString("key");
        Log.e(TAG, "onCreateView:"+ msg + "\n" + key );

        return root;
    }
}