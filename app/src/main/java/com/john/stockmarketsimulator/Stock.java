package com.john.stockmarketsimulator;

import java.util.Random;

/**
 * Created by giann on 12-Jun-17.
 */

public class Stock {
    protected String name;
    protected float price;

    public Stock(String name, float price){
        this.name = name;
        this.price = price;
    }

    public Stock(String name){
        Random r = new Random();
        this.name = name;
        this.price = r.nextFloat() * (r.nextInt(300) + 1);
    }

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
