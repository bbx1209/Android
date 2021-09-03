package com.helloworld.Sections.webview;

import static com.helloworld.R.id.webView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.helloworld.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

         webview = findViewById(webView);

         webview.getSettings().setJavaScriptEnabled(true);
         webview.setWebViewClient(new WebViewClient());
         webview.loadUrl("https://baidu.com");


    }
}