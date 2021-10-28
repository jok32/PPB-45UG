package com.example.tugas5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String database_player = "db_player";
    private static final String id = "id";
    private static final String nm_player = "nm_player";
    private static final String tabel_player = "tabel_player";
    private static final String club = "club";

    public DatabaseHelper(@Nullable Context context) {
        super(context, database_player, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String nama_tabel = "create table " + tabel_player + "(" + id + " integer primary key autoincrement, " + nm_player + " text, " + club + " text)";
        sqLiteDatabase.execSQL(nama_tabel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addData(String nameplayer, String nameclub) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(nm_player, nameplayer);
        contentValues.put(club, nameclub);

        long hasil = db.insert(tabel_player, null, contentValues);
        return hasil != -1;
    }

    public Cursor viewAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "select * from " + tabel_player;
        Cursor cursor = db.rawQuery(sql, null);

        return cursor;
    }

    public Integer deleteData(String idnum) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tabel_player, "id = ?", new String[]{idnum});

    }
}