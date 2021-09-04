package com.helloworld.sections.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
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
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        fileEditText = findViewById(R.id.fileText);
        spEditText = findViewById(R.id.SPText);
        dbEditText = findViewById(R.id.DBText);

        dBhelper = new MyDBhelper(this, "BookStore.db", null, 1);
        db = dBhelper.getWritableDatabase();

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
            if (reader != null) {
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
    //MARK:-----  SQLITE ----

    //创建表
    public void createTable(View view) {
        dBhelper.getWritableDatabase();

    }

    // 写入数据库
    public void writeInDB(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "鲸鱼池塘");
        contentValues.put("author", "蔡智恒");
        contentValues.put("pages", 450);
        contentValues.put("price", 25.6);
        db.insert("Book", null, contentValues);
    }


    //更新数据
    public void updateData(View view) {
        ContentValues values = new ContentValues();
        values.put("price", 50.1);
        db.update("Book", values, "name = ?", new  String[]{"鲸鱼池塘"});
    }

    // 从数据库中读取数据
    public void readFromDB(View view) {
        Cursor cursor = db.query("Book", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                double price =  cursor.getDouble(cursor.getColumnIndex("price"));
                dbEditText.setText(name);
                Log.d("====== DATA BASE =====", "readFromDB" + name + price);

            }while (cursor.moveToNext());
        } else {
            dbEditText.setText(null);
        }

        cursor.close();

    }

    //从数据库中删除
    public void deleteFromDB(View view) {
        db.delete("Book",null, null);
    }




}