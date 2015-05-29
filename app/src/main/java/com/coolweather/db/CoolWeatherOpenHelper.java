package com.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by byn on 2015/5/28.
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

    /**
     *  Province�������
     */
    public static final String CREATE_PROVINCE = "Create table Province ("
            + "id integer primary key autoincrement. "
            + "province_name text, "
            + "province_code text)";
    /**
     *  City���������
     */
    public static final String CREATE_CITY = "Create table City ("
            + "id integer primary key autoincrement. "
            + "city_name text, "
            + "city_code text, "
            + "province_id integer)";
    /**
     * Country���������
     */
    public static final String CREATE_COUNTY = "create table County ("
            + "id integer primary key autoincrement, "
            + "county_name text, "
            + "county_code text, "
            + "city_id integer)";
    public CoolWeatherOpenHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version)
    {
        super(context,name,factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL (CREATE_PROVINCE);
        db.execSQL (CREATE_CITY);
        db.execSQL (CREATE_COUNTY);
    }
    @Override
    public  void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {

    }
}