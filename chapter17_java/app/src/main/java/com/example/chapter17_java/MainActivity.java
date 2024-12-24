package com.example.chapter17_java;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBarsInsets.left, systemBarsInsets.top, systemBarsInsets.right, systemBarsInsets.bottom);
            return insets;
        });

        btnQuery = findViewById(R.id.btnQuery);
        btnQuery.setOnClickListener(view -> {
            btnQuery.setEnabled(false);
            setRequest();
        });
    }

    private void setRequest() {
        String url = "https://api.italkutalk.com/api/air";
        Request request = new Request.Builder()
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body() != null ? response.body().string() : "";
                MyObject myObject = new Gson().fromJson(json, MyObject.class);
                showDialog(myObject);
            }

            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() -> {
                    btnQuery.setEnabled(true);
                    Toast.makeText(MainActivity.this, "查詢失敗: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });
    }

    private void showDialog(MyObject myObject) {
        List<String> items = new ArrayList<>();
        for (MyObject.Result.Record data : myObject.result.records) {
            items.add("地區：" + data.SiteName + ", 狀態：" + data.Status);
        }
        runOnUiThread(() -> {
            btnQuery.setEnabled(true);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("臺北市空氣品質")
                    .setItems(items.toArray(new String[0]), null)
                    .show();
        });
    }

    public static class MyObject {
        public Result result;

        public static class Result {
            public List<Record> records;

            public static class Record {
                public String SiteName;
                public String Status;
            }
        }
    }
}
