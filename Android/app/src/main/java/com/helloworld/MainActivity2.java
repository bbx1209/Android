package com.helloworld;

import android.content.Intent;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.e(TAG, "onCreate: 进入新的页面了");

        View imageView = findViewById(R.id.imageView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageView.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, imageView.getWidth(), imageView.getHeight(), 50);
                }
            });
            imageView.setClipToOutline(true);
        }


    }

    public void jumpToNewActitvity(View view) {
//        Intent intent = new Intent();
//        intent.putExtra("content", "second activity's param");
//        setResult(Activity.RESULT_OK, intent);

        onBackPressed();
//        finish();
    }

    public void loginAction(View view) {

        EditText textView = findViewById(R.id.textView);

        Log.e(TAG, textView.getText().toString());

    }

    public void loginActionII(View view) {

        Button button = findViewById(R.id.secondBut);

        button.setText("第二个button");


    }
}