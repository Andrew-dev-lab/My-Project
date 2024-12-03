package com.example.chapter13_java;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    private String channel = "";
    private Thread thread;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getExtras() != null) {
            channel = intent.getExtras().getString("channel", "");
        }

        sendBroadcastMessage(getInitialMessage(channel));

        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }

        thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                sendBroadcastMessage(getDelayedMessage(channel));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void sendBroadcastMessage(String msg) {
        Intent broadcastIntent = new Intent(channel);
        broadcastIntent.putExtra("msg", msg);
        sendBroadcast(broadcastIntent);
    }

    private String getInitialMessage(String channel) {
        switch (channel) {
            case "music":
                return "歡迎來到音樂頻道";
            case "new":
                return "歡迎來到新聞頻道";
            case "sport":
                return "歡迎來到體育頻道";
            default:
                return "頻道錯誤";
        }
    }

    private String getDelayedMessage(String channel) {
        switch (channel) {
            case "music":
                return "即將播放本月TOP10音樂";
            case "new":
                return "即將為您提供獨家新聞";
            case "sport":
                return "即將播報本週NBA賽事";
            default:
                return "頻道錯誤";
        }
    }
}