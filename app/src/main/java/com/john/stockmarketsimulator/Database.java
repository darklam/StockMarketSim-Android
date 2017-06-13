package com.john.stockmarketsimulator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by john on 13/6/2017.
 */

public class Database extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "StockMarket.db";
    public static final String SQL_CREATE_MAIN_TABLE =
            "CREATE TABLE " + MarketContract.MarketEntry.STOCK_TABLE_NAME + " ("
            + MarketContract.MarketEntry.STOCK_COLUMN_NAME + " TEXT,"
            + MarketContract.MarketEntry.STOCK_COLUMN_PRICE + " REAL)";
    public static final String SQL_DELETE_MAIN_ENTRIES = "DROP TABLE IF EXISTS " + MarketContract.MarketEntry.STOCK_TABLE_NAME;

    public Database(Context ctx){
        super(ctx, MarketContract.MarketEntry.STOCK_TABLE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_MAIN_TABLE);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_MAIN_ENTRIES);
        onCreate(db);
    }
}
