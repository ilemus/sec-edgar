package com.sec.edgar;

import com.sec.edgar.cik.CIKList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        ArrayList<String> tickers = new ArrayList<String>();
        tickers.add(CIKList.mSp500[0]);
        HashMap<String, Integer> cikDb = mCikList.loadCikFromDb(tickers);
        for (int i = tickers.size(); i >= 0; i--) {
            if (cikDb.containsKey(tickers.get(i))) tickers.remove(i);
        }
        HashMap<String, Integer> cikMap = mCikList.requestAndUpdate(tickers);
        for (Map.Entry<String, Integer> entry : cikMap.entrySet()) {
            // Can we do put entry??
            cikDb.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Printing keys...");
        for (Map.Entry<String, Integer> entry : cikDb.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
