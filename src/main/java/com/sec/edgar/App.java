package com.sec.edgar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sec.edgar.cik.CIKList;
import com.sec.edgar.cik.CIKFileReader;


/**
 * Hello world!
 *
 */
public class App {
    private CIKList mCikList;

    public App() {
        mCikList = new CIKList();
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        App app = new App();
        app.run();
    }

    public void run() {
        // Load S&P 500 symbols from file
        ArrayList<String> tickers = CIKFileReader.getTickerArray("data/constituents.csv");

        HashMap<String, Integer> cikDb = mCikList.loadCikFromDb(tickers);
        for (int i = tickers.size() - 1; i >= 0; i--) {
            if (cikDb.containsKey(tickers.get(i))) tickers.remove(i);
        }
        HashMap<String, Integer> cikMap = mCikList.requestAndUpdate(tickers);
        for (Map.Entry<String, Integer> entry : cikMap.entrySet()) {
            // Can we do put entry??
            cikDb.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Number of saved keys: " + cikDb.size());
    }
}
