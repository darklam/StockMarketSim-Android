package com.john.stockmarketsimulator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by giann on 12-Jun-17.
 */

public class Market {

    protected List<Stock> stocks;

    public Market(){
        //TODO have initial stock info in SQLite database
        stocks = new ArrayList<>();
        stocks.add(new Stock("Microsoft"));
        stocks.add(new Stock("Apple"));
        stocks.add(new Stock("Intel"));
        stocks.add(new Stock("AMD"));
    }

    public int getStockCount(){
        return stocks.size();
    }

    public String getName(int index){
        return stocks.get(index).getName();
    }

    public float getPrice(int index){
        return stocks.get(index).getPrice();
    }

//    public void saveStocks(Context ctx){
//        DatabaseOperations op = new DatabaseOperations(ctx);
//        String[] params = new String[stocks.size() * 2];
//        int stock = 0;
//        for(int i = 0; i < params.length; i += 2){
//            params[i] = stocks.get(stock).getName();
//            params[i + 1] = Float.toString(stocks.get(stock).getPrice());
//            stock++;
//        }
//        op.execute(params);
//    }

    public void saveStocks(Context ctx){
        DatabaseHelper h = new DatabaseHelper(ctx);
        SQLiteDatabase db = h.getWritableDatabase();
        ContentValues values = new ContentValues();
        for(int i = 0; i < stocks.size(); i++){
            values.put(MarketContract.MarketEntry.STOCK_COLUMN_NAME, stocks.get(i).getName());
            values.put(MarketContract.MarketEntry.STOCK_COLUMN_PRICE, stocks.get(i).getPrice());
            db.insert(MarketContract.MarketEntry.STOCK_TABLE_NAME, null, values);
            values.clear();
        }
    }

    public void deleteEntries(Context ctx){
        DatabaseHelper h = new DatabaseHelper(ctx);
        SQLiteDatabase db = h.getWritableDatabase();
        h.deleteDatabase(db);
    }

    public Stock[] getStockArray(Context ctx){
        DatabaseHelper h = new DatabaseHelper(ctx);
        SQLiteDatabase db = h.getReadableDatabase();
        return h.getDatabase(db);
    }

    public void loadFromDatabase(Context ctx){
        //Currently empty
    }
}
