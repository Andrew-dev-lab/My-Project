package com.example.noteremindme;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    long insert(Note note);

    @Query("SELECT * FROM Note ORDER BY id DESC")
    List<Note> getAllNotes();
}