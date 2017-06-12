package com.john.stockmarketsimulator;

/**
 * Created by giann on 12-Jun-17.
 */

public class Stock {
    protected String name;
    protected float price;

    public void setPrice(float price){
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public float getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }
}
