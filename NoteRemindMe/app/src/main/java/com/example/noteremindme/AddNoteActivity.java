package com.example.noteremindme;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class AddNoteActivity extends AppCompatActivity {
    private EditText etTitle, etDescription, etContent;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        etContent = findViewById(R.id.etContent);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
    }

    private void saveNote() {
        String title = etTitle.getText().toString().trim();
        String description = etDescription.getText().toString().trim();
        String content = etContent.getText().toString().trim();

        if (TextUtils.isEmpty(title)) {
            Toast.makeText(this, "Please enter title", Toast.LENGTH_SHORT).show();
            return;
        }

        // Insert to Room DB on background thread
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Note note = new Note();
                note.setTitle(title);
                note.setDescription(description);
                note.setContent(content);
                note.setSummary(""); // optional, for future AI summary

                long id = AppDatabase.getInstance(getApplicationContext()).noteDao().insert(note);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(AddNoteActivity.this, "Note saved", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });
    }
}
