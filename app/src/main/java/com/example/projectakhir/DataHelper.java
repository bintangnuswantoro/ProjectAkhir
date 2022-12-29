package com.example.projectakhir;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "projectakhir.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("PRAGMA foreign_key=ON");
        db.execSQL("create table penyewa (" +
                "nama text, " +
                "alamat text," +
                "no_hp text," +
                "primary key(nama)" +
                ");" +
                "");
        db.execSQL("create table buku(" +
                "merk text," +
                "harga int," +
                "primary key(merk)" +
                ");" +
                "");
        db.execSQL("create table sewa(" +
                "merk text," +
                "nama text," +
                "promo int," +
                "lama int," +
                "total double," +
                "foreign key(merk) references buku (merk), " +
                "foreign key(nama) references penyewa (nama) " +
                ");" +
                "");

        db.execSQL("insert into buku values (" +
                "'Manga'," +
                "40000" +
                ");" +
                "");
        db.execSQL("insert into buku values (" +
                "'Novel'," +
                "80000" +
                ");" +
                "");
        db.execSQL("insert into buku values (" +
                "'Pemrograman'," +
                "100000" +
                ");" +
                "");
        db.execSQL("insert into buku values (" +
                "'Antologi'," +
                "80000" +
                ");" +
                "");
        db.execSQL("insert into buku values (" +
                "'Biografi'," +
                "50000" +
                ");" +
                "");
        db.execSQL("insert into buku values (" +
                "'Dongeng'," +
                "50000" +
                ");" +
                "");
        db.execSQL("insert into buku values (" +
                "'Ensiklopedia'," +
                "40000" +
                ");" +
                "");
        db.execSQL("insert into buku values (" +
                "'History'," +
                "50000" +
                ");" +
                "");
        db.execSQL("insert into buku values (" +
                "'Komik'," +
                "60000" +
                ");" +
                "");
    }

    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<String>();
        String selectQuery = "select * from buku";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                categories.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return categories;
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
