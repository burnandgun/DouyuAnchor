package com.example.administrator.douyuanchor.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/8/25.
 */
public class AnchorOpenHelper extends SQLiteOpenHelper {

    //建表
    public static final String CREATE_ANCHOR = "create table Anchor("
            + "id integer primary key autoincrement ,"
            + "room_id integer ,"
            + "anchor_name text ,"
            + "room_status integer ,"
            + "start_time text )";

    public  AnchorOpenHelper (Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_ANCHOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
