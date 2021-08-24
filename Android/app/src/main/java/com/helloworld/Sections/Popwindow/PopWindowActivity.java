package com.helloworld.Sections.Popwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.helloworld.R;


public class PopWindowActivity extends AppCompatActivity {

    private static final String TAG = "bbx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_window);
    }

    public void showPopWindow(View view) {

        View contentView = getLayoutInflater().inflate(R.layout.pop_content_viiew, null);

        Button button1 = contentView.findViewById(R.id.but1);
        Button button2 = contentView.findViewById(R.id.but2);


        PopupWindow popupWindow = new PopupWindow(contentView, 450, 500, true);

        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.image));


        popupWindow.showAsDropDown(view);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick:第一个按钮");
                popupWindow.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick:第二个按钮");
                popupWindow.dismiss();
            }
        });


    }
}