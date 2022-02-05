package com.cloudweather.android.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * ...
 *
 * @author Chen Xuelong
 * @email 1670430730@qq.com
 * @date 2022/2/5
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_PROVINCE = "create table Province("+"id integer primary key autoincrement,"+"provinceName text,"+"provinceCode integer)";

    public static final String CREATE_CITY = "create table City("+"id integer primary key autoincrement,"+"cityName text,"+"cityCode integer,"+"provinceId integer)";

    public static final String CREATE_COUNTY = "create table County("+"id integer primary key autoincrement,"+"countyName text,"+"countyCode integer,"+"weatherId integer,"+" cityId integer)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, "cloud_weather",null,1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CITY);
        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_COUNTY);
        //弹出一个Toast提示创建成功
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists Province");
        db.execSQL("drop table if exists City");
        db.execSQL("drop table if exists County");
        onCreate(db);
    }
}
