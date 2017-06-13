package com.john.stockmarketsimulator;

import android.content.Context;

import java.util.ArrayList;
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

    public void saveStocks(Context ctx){
        DatabaseOperations op = new DatabaseOperations(ctx);
        for(int i = 0; i < stocks.size(); i++){
            op.execute("add_stock", stocks.get(i).getName(), Float.toString(stocks.get(i).getPrice()));
        }
    }

    public void loadFromDatabase(Context ctx){
        DatabaseOperations op = new DatabaseOperations(ctx);

    }
}
