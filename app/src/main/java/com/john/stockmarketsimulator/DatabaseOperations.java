package com.john.stockmarketsimulator;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by giann on 13-Jun-17.
 */

public class DatabaseOperations extends AsyncTask<String, Void, Void>{

    Context ctx;


    public DatabaseOperations(Context ctx){
        this.ctx = ctx;
    }

    //Async task that adds values to the database
    @Override
    protected Void doInBackground(String... vals) {
        DatabaseHelper helper = new DatabaseHelper(ctx);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        for(int i = 0; i < vals.length; i += 2){
            String name = vals[i];
            float price = Float.parseFloat(vals[i + 1]);
            if(!helper.checkExists(name, db)){
                values.put(MarketContract.MarketEntry.STOCK_COLUMN_NAME, name);
                values.put(MarketContract.MarketEntry.STOCK_COLUMN_PRICE, price);
                db.insert(MarketContract.MarketEntry.STOCK_TABLE_NAME, null, values);
            }else{
                helper.updateDb(name, price, db);
            }
        }
        helper.close();
        db.close();

        return null;
    }
}
