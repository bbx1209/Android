package com.helloworld.Sections.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.helloworld.R;

public class DataBaseActivity extends AppCompatActivity {

    private EditText fileEditText;
    private EditText spEditText;
    private EditText dbEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        fileEditText = findViewById(R.id.fileText);
        spEditText = findViewById(R.id.SPText);
        dbEditText = findViewById(R.id.DBText);


    }


    // 写入文件
    public void writeInfile(View view) {
    }

    //从文件中读取数据
    public void readFromfile(View view) {
    }

    // 写入SP
    public void writeInSP(View view) {

    }

    // 从SP中读取数据
    public void readFromSP(View view) {
    }

    // 写入数据库
    public void writeInDB(View view) {
    }

    // 从数据库中读取数据
    public void readFromDB(View view) {
    }

    //从数据库中删除
    public void deleteFromDB(View view) {
    }
}