package com.helloworld.sections.weChat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.helloworld.R;


public class WechatFragment extends Fragment {

    private static final String ARG_TITLe = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private View root;


    public static WechatFragment newInstance(String param1) {
        WechatFragment fragment = new WechatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLe, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_TITLe);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_wechat, container, false);
        }

         iniSubView();
        return  root;
    }

    private void iniSubView() {
        TextView textview = root.findViewById(R.id.textView);
        textview.setText(mParam1);
    }
}