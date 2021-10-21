package com.example.tugas4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "anime.db";
    public static final String TABLE_NAME = "anime_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "JUDUL";
    public static final String COL_3 = "GENRE";
    public static final String COL_4 = "TOKOH_UTAMA";
    public static final String COL_5 = "ASAL";
    public static final String COL_6 = "TAHUN";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table anime_table(ID INTEGER PRIMARY KEY AUTOINCREMENT,JUDUL TEXT, GENRE TEXT, TOKOH_UTAMA TEXT, ASAL TEXT, TAHUN TEXT)");


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String judul, String genre,String tokoh_utama, String asal, String tahun){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, judul);
        contentValues.put(COL_3, genre);
        contentValues.put(COL_4, tokoh_utama);
        contentValues.put(COL_5, asal);
        contentValues.put(COL_6, tahun);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public boolean updateData(String id,String judul, String genre,String tokoh_utama, String asal, String tahun) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,judul);
        contentValues.put(COL_3,genre);
        contentValues.put(COL_4,tokoh_utama);
        contentValues.put(COL_5,asal);
        contentValues.put(COL_6,tahun);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}
