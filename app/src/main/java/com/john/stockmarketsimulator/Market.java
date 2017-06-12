package com.john.stockmarketsimulator;

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

    }
}
