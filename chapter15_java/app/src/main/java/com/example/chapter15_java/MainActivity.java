package com.example.chapter15_java;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    private SQLiteDatabase dbrw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBarsInsets.left, systemBarsInsets.top, systemBarsInsets.right, systemBarsInsets.bottom);
            return insets;
        });

        dbrw = new MyDBHelper(this).getWritableDatabase();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        ((ListView) findViewById(R.id.listView)).setAdapter(adapter);
        setListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbrw.close();
    }

    private void setListener() {
        EditText edBook = findViewById(R.id.edBook);
        EditText edPrice = findViewById(R.id.edPrice);

        findViewById(R.id.btnInsert).setOnClickListener(v -> {
            if (edBook.length() < 1 || edPrice.length() < 1) {
                showToast("欄位請勿留空");
            } else {
                try {
                    dbrw.execSQL("INSERT INTO myTable(book, price) VALUES(?,?)",
                            new Object[]{edBook.getText().toString(), edPrice.getText().toString()});
                    showToast("新增:" + edBook.getText() + ",價格:" + edPrice.getText());
                    cleanEditText();
                } catch (Exception e) {
                    showToast("新增失敗:" + e.toString());
                }
            }
        });

        findViewById(R.id.btnUpdate).setOnClickListener(v -> {
            if (edBook.length() < 1 || edPrice.length() < 1) {
                showToast("欄位請勿留空");
            } else {
                try {
                    dbrw.execSQL("UPDATE myTable SET price = ? WHERE book LIKE ?",
                            new Object[]{edPrice.getText().toString(), edBook.getText().toString()});
                    showToast("更新:" + edBook.getText() + ",價格:" + edPrice.getText());
                    cleanEditText();
                } catch (Exception e) {
                    showToast("更新失敗:" + e.toString());
                }
            }
        });

        findViewById(R.id.btnDelete).setOnClickListener(v -> {
            if (edBook.length() < 1) {
                showToast("書名請勿留空");
            } else {
                try {
                    dbrw.execSQL("DELETE FROM myTable WHERE book LIKE ?",
                            new Object[]{edBook.getText().toString()});
                    showToast("刪除:" + edBook.getText());
                    cleanEditText();
                } catch (Exception e) {
                    showToast("刪除失敗:" + e.toString());
                }
            }
        });

        findViewById(R.id.btnQuery).setOnClickListener(v -> {
            String queryString = edBook.length() < 1 ?
                    "SELECT * FROM myTable" :
                    "SELECT * FROM myTable WHERE book LIKE '" + edBook.getText() + "'";

            Cursor c = dbrw.rawQuery(queryString, null);
            c.moveToFirst();
            items.clear();
            showToast("共有" + c.getCount() + "筆資料");
            for (int i = 0; i < c.getCount(); i++) {
                items.add("書名:" + c.getString(0) + "\t\t\t\t價格:" + c.getInt(1));
                c.moveToNext();
            }
            adapter.notifyDataSetChanged();
            c.close();
        });
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    private void cleanEditText() {
        ((EditText) findViewById(R.id.edBook)).setText("");
        ((EditText) findViewById(R.id.edPrice)).setText("");
    }
}