package com.helloworld.sections.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.helloworld.R;

public class CardDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int imageId = intent.getIntExtra("imageId", 0);

        Toolbar toolBar = (Toolbar)findViewById(R.id.tool_bar);

        CollapsingToolbarLayout layout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar_layout);
        ImageView imageView = findViewById(R.id.detail_iamge_view);
        TextView textView = findViewById(R.id.detail_textView);
        setSupportActionBar(toolBar);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        layout.setTitle(name);
        Glide.with(this).load(imageId).into(imageView);
        String string = generateCardContent(name);
        textView.setText(string);


    }

    private String  generateCardContent(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <500 ; i++) {
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }

    public void clickOnFloatingBut(View view) {





    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}