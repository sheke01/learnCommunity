package com.example.sheke.communitylearing;

import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.*;
import cz.msebera.android.httpclient.Header;

public class GetActivity extends AppCompatActivity {

    ListView listview;
    Response responseObj;
    CustomAdapter adapter;
    String url = "https://api.github.com/search/users?q=location%3Alagos&language%3Ajava";
    Gson gson;
    AsyncHttpClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        Intent shake = getIntent();

        listview = (ListView)findViewById(R.id.dem);
        client = new AsyncHttpClient();
        client.get(GetActivity.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] responseBody) {
                String responsestr = new String(responseBody);
                gson = new Gson();
                responseObj = gson.fromJson(responsestr, Response.class);
                adapter = new CustomAdapter(GetActivity.this, responseObj.getItems());
                listview.setAdapter(adapter);

            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] responseBody, Throwable throwable) {

            }
        });

    }
}
