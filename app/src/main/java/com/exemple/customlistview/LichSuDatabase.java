package com.exemple.customlistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LichSuDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "anh_vietz.sqlite";

    public LichSuDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql ="CREATE TABLE IF NOT EXISTS lich_su1(id INTEGER PRIMARY KEY AUTOINCREMENT,anh TEXT , viet TEXT )";
    db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void themLichSu(anhviet av)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",av.getId());
        values.put("anh",av.getA());
        values.put("viet",av.getV());
        db.insert("lich_su1",null,values);
        db.close();
    }
}
