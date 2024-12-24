package com.example.chapter16_1_java;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    private SQLiteDatabase dbrw;

    @Override
    public boolean onCreate() {
        if (getContext() == null) return false;
        dbrw = new MyDBHelper(getContext()).getWritableDatabase();
        return true;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (values == null) return null;
        long rowId = dbrw.insert("myTable", null, values);
        return Uri.parse("content://com.example.lab16/" + rowId);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (selection == null || values == null) return 0;
        return dbrw.update("myTable", values, "book='" + selection + "'", null);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if (selection == null) return 0;
        return dbrw.delete("myTable", "book='" + selection + "'", null);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String queryString = (selection == null) ? null : "book='" + selection + "'";
        return dbrw.query("myTable", null, queryString, null, null, null, null);
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }
}
