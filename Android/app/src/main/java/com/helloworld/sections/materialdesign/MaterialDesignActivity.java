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

import com.google.android.material.navigation.NavigationView;
import com.helloworld.R;

public class MaterialDesignActivity extends AppCompatActivity {

        private DrawerLayout drawerLayout;
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
        return  true;
    }
}