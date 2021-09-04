package com.helloworld.Sections.OKHttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.helloworld.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpActivity extends AppCompatActivity {

    private OkHttpClient httpClinet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        httpClinet = new OkHttpClient();


    }

    public void getSync(View view) {

        new Thread() {
            @Override
            public void run() {
                Request request = new Request.Builder().url("https://httpbin.org/get?a=1&b=2").build();

                Call call = httpClinet.newCall(request);


                try {
                    Response execute = call.execute();
                    Log.e("get request", "getSync: " + execute.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    public void getASync(View view) {
        Request request = new Request.Builder().url("https://httpbin.org/get?a=1&b=2").build();

        Call call = httpClinet.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Log.e("getASync", "getASync: " + response.body().string());
                }
            }
        });


    }

    public void postSync(View view) {
        new Thread() {
            @Override
            public void run() {
                FormBody body = new FormBody.Builder().add("a", "1").add("b", "2").build();
                Request request = new Request.Builder().url("https://httpbin.org/post").post(body).build();

                Call call = httpClinet.newCall(request);

                try {
                    Response execute = call.execute();
                    Log.e("postSync request", "postSync: " + execute.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }

    public void postASync(View view) {
        FormBody body = new FormBody.Builder().add("name", "1").add("age", "2").build();
        Request request = new Request.Builder().url("https://httpbin.org/post").post(body).build();

        Call call = httpClinet.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {

                    String result = response.body().string();
                    //解析json
                    JSONObject body = JSON.parseObject(result);
                    String formString = body.getString("form");
                    Person person = JSONObject.parseObject(formString, Person.class);

                    Log.e("postASync", " " + person.name +"\n"+ person.age);
                }
            }
        });


    }
}