package com.example.chapter8_java;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBarsInsets.left, systemBarsInsets.top, systemBarsInsets.right, systemBarsInsets.bottom);
            return insets;
        });

        EditText edName = findViewById(R.id.edName);
        EditText edPhone = findViewById(R.id.edPhone);
        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            if (edName.getText().toString().isEmpty()) {
                showToast("請輸入姓名");
            } else if (edPhone.getText().toString().isEmpty()) {
                showToast("請輸入電話");
            } else {
                Bundle b = new Bundle();
                b.putString("name", edName.getText().toString());
                b.putString("phone", edPhone.getText().toString());
                setResult(Activity.RESULT_OK, new Intent().putExtras(b));
                finish();
            }
        });
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}