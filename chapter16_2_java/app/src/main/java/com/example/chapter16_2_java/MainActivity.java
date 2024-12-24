package com.example.chapter16_2_java;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> items = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private final Uri uri = Uri.parse("content://com.example.lab16");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableEdgeToEdge();
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBarsInsets.left, systemBarsInsets.top, systemBarsInsets.right, systemBarsInsets.bottom);
            return insets;
        });

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        ((ListView) findViewById(R.id.listView)).setAdapter(adapter);
        setListener();
    }

    private void setListener() {
        EditText edBook = findViewById(R.id.edBook);
        EditText edPrice = findViewById(R.id.edPrice);

        findViewById(R.id.btnInsert).setOnClickListener(v -> {
            String name = edBook.getText().toString();
            String price = edPrice.getText().toString();
            if (name.isEmpty() || price.isEmpty()) {
                showToast("欄位請勿留空");
            } else {
                ContentValues values = new ContentValues();
                values.put("book", name);
                values.put("price", price);
                Uri contentUri = getContentResolver().insert(uri, values);
                if (contentUri != null) {
                    showToast("新增:" + name + ",價格:" + price);
                    cleanEditText();
                } else {
                    showToast("新增失敗");
                }
            }
        });

        findViewById(R.id.btnUpdate).setOnClickListener(v -> {
            String name = edBook.getText().toString();
            String price = edPrice.getText().toString();
            if (name.isEmpty() || price.isEmpty()) {
                showToast("欄位請勿留空");
            } else {
                ContentValues values = new ContentValues();
                values.put("price", price);
                int count = getContentResolver().update(uri, values, name, null);
                if (count > 0) {
                    showToast("更新:" + name + ",價格:" + price);
                    cleanEditText();
                } else {
                    showToast("更新失敗");
                }
            }
        });

        findViewById(R.id.btnDelete).setOnClickListener(v -> {
            String name = edBook.getText().toString();
            if (name.isEmpty()) {
                showToast("書名請勿留空");
            } else {
                int count = getContentResolver().delete(uri, name, null);
                if (count > 0) {
                    showToast("刪除:" + name);
                    cleanEditText();
                } else {
                    showToast("刪除失敗");
                }
            }
        });

        findViewById(R.id.btnQuery).setOnClickListener(v -> {
            String name = edBook.getText().toString();
            String selection = name.isEmpty() ? null : name;
            try (android.database.Cursor c = getContentResolver().query(uri, null, selection, null, null)) {
                if (c == null) return;
                c.moveToFirst();
                items.clear();
                showToast("共有" + c.getCount() + "筆資料");
                for (int i = 0; i < c.getCount(); i++) {
                    items.add("書名:" + c.getString(0) + "\t\t\t\t價格:" + c.getInt(1));
                    c.moveToNext();
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    private void cleanEditText() {
        ((EditText) findViewById(R.id.edBook)).setText("");
        ((EditText) findViewById(R.id.edPrice)).setText("");
    }

    private void enableEdgeToEdge() {

    }
}