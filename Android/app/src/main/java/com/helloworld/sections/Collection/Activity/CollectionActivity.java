package com.helloworld.sections.Collection.Activity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.helloworld.BaseActivity.BaseActivity;
import com.helloworld.R;
import com.helloworld.dataprovider.DataItem;
import com.helloworld.dataprovider.DataProvider;
import com.helloworld.sections.Collection.Activity.Model.CollectionAdapter;
import com.helloworld.sections.Collection.Activity.Model.CollectionItemDivider;

import java.util.List;

public class CollectionActivity extends BaseActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection);

        mRecyclerView = findViewById(R.id.myRecyclerView);

        List<DataItem> dataItems = DataProvider.getDataItems();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        CollectionAdapter adapter = new CollectionAdapter(dataItems, this);

        mRecyclerView.setAdapter(adapter);

        CollectionItemDivider itemDivider = new CollectionItemDivider(this, CollectionItemDivider.VERTICAL_LIST);
        mRecyclerView.addItemDecoration(itemDivider);


    }
}
