package com.john.stockmarketsimulator;

import android.content.Context;

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

    public void saveStocks(Context ctx){
        DatabaseOperations op = new DatabaseOperations(ctx);
        String[] params = new String[stocks.size() * 2];
        int stock = 0;
        for(int i = 0; i < params.length; i += 2){
            params[i] = stocks.get(stock).getName();
            params[i + 1] = Float.toString(stocks.get(stock).getPrice());
            stock++;
        }
        op.execute(params);
    }

    public void loadFromDatabase(Context ctx){
        //Currently empty
    }
}
