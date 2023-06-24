package com.example.androidbroject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelber extends SQLiteOpenHelper {
Context c ;

public static final String DATABASE_NAME = "clients";
    public  static final int DATABASE_VERSION = 1;

    public DbHelber(Context c){

        super(c , DATABASE_NAME, null, DATABASE_VERSION);
        this.c = c;


    }
    @Override
    public void onCreate(SQLiteDatabase dp) {
      String sql= "create table clients("
                  + "id integer primary key autoincrement,"
                  + "name varchar (50),"
                  + "phone varchar(11),"
                  + "email varchar (20))";


dp.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
