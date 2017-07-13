package com.john.stockmarketsimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Market test = new Market();
        test.saveStocks(this);
        Stock[] st = test.getStockArray(this);
        Log.i("start", "started");
        Log.i("wut", Integer.toString(st.length));
        for(int i = 0; i < st.length; i++){
            Log.i("wut", Integer.toString(i));
            Log.i("stockinfo", st[i].getStockInfo());
        }

    }
}
