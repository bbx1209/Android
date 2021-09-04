package com.helloworld.sections.Home.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.helloworld.BaseActivity.BaseActivity;

import com.helloworld.basemodel.ActivityModel;
import com.helloworld.Handler.HomeDataHandler;
import com.helloworld.R;
import com.helloworld.sections.Home.Model.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements HomeAdapter.HomeAdapterListener {

    private HomeDataHandler homeDataHandler;
    private List<ActivityModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        homeDataHandler = new HomeDataHandler();
        list = homeDataHandler.homeList();


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        HomeAdapter homeAdapter = new HomeAdapter(list, this);
        recyclerView.setAdapter(homeAdapter);


    }


    @Override
    public void clickListener(View view, ActivityModel model) {

        Intent intent = new Intent(this, model.aclass);
//        intent.setClassName(null, activityName);
//        intent.setClassName(view.getContext(), activityName);
        startActivity(intent);
    }
}
