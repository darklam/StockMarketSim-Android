package com.john.stockmarketsimulator;

/**
 * Created by giann on 13-Jun-17.
 */

public class MarketContract {
    //The entries for the database
    private MarketContract(){}

    public static class MarketEntry{
        public static final String STOCK_COLUMN_NAME = "stock";
        public static final String STOCK_COLUMN_PRICE = "price";
        public static final String STOCK_TABLE_NAME = "MAIN_TABLE";
    }

}
