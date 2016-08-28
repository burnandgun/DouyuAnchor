package com.example.administrator.douyuanchor.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.douyuanchor.db.AnchorOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/25.
 */
public class AnchorDB {
    public static final String DB_NAME = "anchor";

    public static final int VERSION = 1;

    private static AnchorDB anchorDB;

    private SQLiteDatabase db;

    private AnchorDB(Context context){
        AnchorOpenHelper dbHelper = new AnchorOpenHelper(context,DB_NAME,null,VERSION);
        db = dbHelper.getWritableDatabase();
    }

    public synchronized static AnchorDB getInstance(Context context){
        if(anchorDB == null){
            anchorDB = new AnchorDB(context);
        }
        return anchorDB;
    }

    //将anchor实例存储到数据库中
    public void saveAnchor(Anchor anchor){
        if(anchor != null){
            ContentValues values = new ContentValues();
            values.put("room_id",anchor.getRoomId());
            values.put("anchor_name",anchor.getAnchorName());
            values.put("room_status",anchor.getRoomStatus());
            values.put("start_time",anchor.getStartTime());
            db.insert("Anchor",null,values);
        }
    }

    //从数据库中读取anchor信息
    public List<Anchor> loadAnchor(){
        List<Anchor> list = new ArrayList<Anchor>();
        Cursor cursor = db.query("Anchor",null,null,null,null,null,null);
        if(cursor.moveToNext()){
            Anchor anchor = new Anchor();
            anchor.setRoomId(cursor.getInt(cursor.getColumnIndex("room_id")));
            anchor.setAnchorName(cursor.getString(cursor.getColumnIndex("anchor_name")));
            anchor.setRoomStatus(cursor.getInt(cursor.getColumnIndex("room_status")));
            anchor.setStartTime(cursor.getString(cursor.getColumnIndex("start_time")));
            list.add(anchor);
        }
        return list;
    }
}
