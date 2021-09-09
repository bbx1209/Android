package com.helloworld.Sections.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.helloworld.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MaterialDesignActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    private CardModel[] cardModels = {
            new CardModel("card", R.drawable.image),
            new CardModel("card", R.drawable.image),
            new CardModel("card", R.drawable.image),
            new CardModel("card", R.drawable.image),
            new CardModel("card", R.drawable.image),
    };
    private List<CardModel> modelList = new ArrayList<>();
    private  CardViewAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu);
        }

        NavigationView navi = (NavigationView) findViewById(R.id.navi_view);
        navi.setCheckedItem(R.id.call);
        navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //取消上一个选中
                MenuItem checkedItem = navi.getCheckedItem();
                checkedItem.setChecked(false);
                switch (item.getItemId()) {
                    case R.id.call:
                        Toast.makeText(MaterialDesignActivity.this, "call", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.friends:
                        Toast.makeText(MaterialDesignActivity.this, "friends", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mail:
                        Toast.makeText(MaterialDesignActivity.this, "mail", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.task:
                        Toast.makeText(MaterialDesignActivity.this, "task", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                }


                //关闭drawer
                drawerLayout.closeDrawers();
                return true;// boolean 标记item 是不是显示选中状态
            }
        });

        initCardModels();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new CardViewAdapter(this, modelList);
        recyclerView.setAdapter(adapter);

        //下拉刷新
        swipeRefreshLayout = findViewById(R.id.refresh_layout);
//        swipeRefreshLayout.setColorSchemeColors(R.color.purple_200);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshCardModel();
            }
        });

    }

    private void refreshCardModel() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initCardModels();
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initCardModels() {
        modelList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(cardModels.length);
            modelList.add(cardModels[index]);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        extracted(menu);
        return true;
    }

    private void extracted(Menu menu) {
        getMenuInflater().inflate(R.menu.toobar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Toast.makeText(this, "click back up", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "click delete ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, " click setting", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }

    public void clickOnFloatingBut(View view) {

        //snackbar
        Snackbar.make(view, "data delete", Snackbar.LENGTH_SHORT)
                .setAction("undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MaterialDesignActivity.this, "data restored", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
        ;
    }
}