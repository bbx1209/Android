package com.helloworld.Sections.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

import com.helloworld.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DataBaseActivity extends AppCompatActivity {

    private EditText fileEditText;
    private EditText spEditText;
    private EditText dbEditText;
    private MyDBhelper dBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        fileEditText = findViewById(R.id.fileText);
        spEditText = findViewById(R.id.SPText);
        dbEditText = findViewById(R.id.DBText);

        dBhelper = new MyDBhelper(this, "BookStore.db", null, 1);


    }


    // 写入文件
    public void writeInfile(View view) {

        String data = "this is the data to store";
        FileOutputStream out = null;
        BufferedWriter writer = null;

        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    //从文件中读取数据
    public void readFromfile(View view) {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();

        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           if (reader != null){
               try {
                   reader.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }

        String result = content.toString();
        fileEditText.setText(result);
    }

    // 写入SP
    // sp 存储与读取需要用相同的获取  SharedPreferences 的方式，否则 读取不出来
    public void writeInSP(View view) {

        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        SharedPreferences.Editor editor = defaultSharedPreferences.edit();

        editor.putString("name", "Tom");
        editor.putInt("age", 10);
        editor.putBoolean("married", false);
        editor.apply();

    }

    // 从SP中读取数据
    public void readFromSP(View view) {

        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences defaultSharedPreferences = getSharedPreferences("data", MODE_PRIVATE);

        String name = defaultSharedPreferences.getString("name", "");
        spEditText.setText(name);


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

    //创建表
    public void createTable(View view) {
        dBhelper.getWritableDatabase();

    }
}