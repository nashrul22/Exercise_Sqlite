package com.example.exercise_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class BDHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String KTK_TABLE_NAME = "kontak";
    public static final String KTK_COLUMN_NAME = "nama";
    public static final String KTK_COLUMN_PHONE = "phone";
    public static final String KTK_COLUMN_EMAIL = "email";
    public  static final String KTK_COLUMN_ALAMAT = "alamat";
    private HashMap hp;

    public BDHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table kontak " +
                        "(phone text, email text, alamat text)"
        );

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS kontak");
        onCreate(db);
    }
    public boolean insertContact (String nama, String phone, String email, String alamat){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nama",nama);
        contentValues.put("phone",phone);
        contentValues.put("email", email);
        contentValues.put("alamat", alamat);

        db.insert("kontak", null, contentValues);
        return true;
    }
    public Cursor getData(String nama){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "select * from kontak where nama="+nama+"", null);
        return res ;
    }
    public int numberOfRowa(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, KTK_TABLE_NAME);
        return numRows;
    }

    public ArrayList<String> getAllCotacts(){
        ArrayList<String> array_list = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "select * from kontak", null);
        res.moveToFirst();

        while (res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(KTK_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}
