package com.helloworld.sections.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.helloworld.R;

public class ContentProviderActivity extends AppCompatActivity {

    private static final String TAG = "ContentProviderActivity";
    private  String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

    }

    public void inserABook(View view) {
        Uri uri = Uri.parse("content://" + MyContentProvider.AUTHORITY + "/Book");

        ContentValues vaule = new ContentValues();
        vaule.put("name", "红龙");
        vaule.put("author", "马丁");
        Uri resultUri = getContentResolver().insert(uri, vaule);
        newId = resultUri.getPathSegments().get(1);

    }

    public void updateBook(View view) {

    }

    public void deleteBook(View view) {

    }

    public void queryBook(View view) {

        Uri uri = Uri.parse("content://" + MyContentProvider.AUTHORITY + "/Book");

        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Log.d(TAG, "queryBook:" + name);
            }
        }
    }
}