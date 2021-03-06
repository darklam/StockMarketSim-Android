package com.john.stockmarketsimulator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by john on 13/6/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "StockMarket.db";
    public static final String SQL_CREATE_MAIN_TABLE =
            "CREATE TABLE " + MarketContract.MarketEntry.STOCK_TABLE_NAME + " ("
            + MarketContract.MarketEntry.STOCK_COLUMN_NAME + " TEXT,"
            + MarketContract.MarketEntry.STOCK_COLUMN_PRICE + " REAL)";
    public static final String SQL_DELETE_MAIN_ENTRIES = "DROP TABLE IF EXISTS " + MarketContract.MarketEntry.STOCK_TABLE_NAME;

    public DatabaseHelper(Context ctx){
        super(ctx, MarketContract.MarketEntry.STOCK_TABLE_NAME, null, DATABASE_VERSION);
    }

    public boolean checkExists(String entry, SQLiteDatabase db){
        String command = "select * from " + MarketContract.MarketEntry.STOCK_TABLE_NAME + " where "
                + MarketContract.MarketEntry.STOCK_COLUMN_NAME + "=?";
        Cursor cur = db.rawQuery(command, new String[]{entry});
        if(cur.getCount() <= 0){
            cur.close();
            return false;
        }
        cur.close();
        return true;
    }

    public Stock[] getDatabase(SQLiteDatabase db){ //Not finished yet
        Stock[] res = null;
        String command = "select * from " + MarketContract.MarketEntry.STOCK_TABLE_NAME;
        Cursor cur = db.rawQuery(command, null);
        res = new Stock[cur.getCount()];
        int count = 0;
        while(cur.moveToNext()){
            int indexName = cur.getColumnIndexOrThrow(MarketContract.MarketEntry.STOCK_COLUMN_NAME);
            int indexPrice = cur.getColumnIndexOrThrow(MarketContract.MarketEntry.STOCK_COLUMN_PRICE);
            res[count] = new Stock(cur.getString(indexName), cur.getFloat(indexPrice));
        }
        cur.close();
        return res;
    }

    public void updateDb(String entry, float newValue, SQLiteDatabase db){
        String command = "update " + MarketContract.MarketEntry.STOCK_TABLE_NAME + " set "
                + MarketContract.MarketEntry.STOCK_COLUMN_PRICE + "=" + Float.toString(newValue)
                + " where " + MarketContract.MarketEntry.STOCK_COLUMN_NAME + "=" + entry;
        db.execSQL(command);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_MAIN_TABLE);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_MAIN_ENTRIES);
        onCreate(db);
    }
}
