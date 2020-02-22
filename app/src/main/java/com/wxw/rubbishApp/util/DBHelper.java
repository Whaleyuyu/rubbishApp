package com.wxw.rubbishApp.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{
    // 数据库名称常量
    private static final String DATABASE_NAME = "rubbish.db";
    // 数据库版本常量
    private static final int DATABASE_VERSION = 2;
    // 表名称常量
    public static final String RUBBISHES_TABLE_NAME = "RubbishTbl";
    public static final String VERSION_TABLE_NAME = "VersionTbl";
    // 构造方法
    public DBHelper(Context context) {
        // 创建数据库
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    // 创建时调用
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + RUBBISHES_TABLE_NAME + " ("
                + Rubbish._ID + " INTEGER PRIMARY KEY,"
                + Rubbish.NAME + " TEXT,"
                + Rubbish.TYPE + " TEXT"
                + ");");
        Log.i("hi","恭喜，创建成功！");

        db.execSQL("CREATE TABLE " + VERSION_TABLE_NAME + " ("
                + Version._ID + " INTEGER PRIMARY KEY,"
                + Version.TYPE + " INTEGER,"
                + Version.VERSIONS + " REAL"
                + ");");
    }

    // 版本更新时调用
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 删除表
        db.execSQL("DROP TABLE IF EXISTS RubbishTbl");
        db.execSQL("DROP TABLE IF EXISTS VersionTbl");
        onCreate(db);
    }

}
