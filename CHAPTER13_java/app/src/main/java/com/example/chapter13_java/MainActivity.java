package com.example.chapter13_java;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

public class MainActivity extends AppCompatActivity {
    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getExtras() != null) {
                TextView tvMsg = findViewById(R.id.tvMsg);
                tvMsg.setText(intent.getExtras().getString("msg"));
            }
        }
    };

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

        findViewById(R.id.btnMusic).setOnClickListener(v -> register("music"));
        findViewById(R.id.btnNew).setOnClickListener(v -> register("new"));
        findViewById(R.id.btnSport).setOnClickListener(v -> register("sport"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    private void register(String channel) {
        IntentFilter intentFilter = new IntentFilter(channel);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(receiver, intentFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(receiver, intentFilter);
        }

        Intent i = new Intent(this, MyService.class);
        startService(i.putExtra("channel", channel));
    }

    private void enableEdgeToEdge() {

    }
}