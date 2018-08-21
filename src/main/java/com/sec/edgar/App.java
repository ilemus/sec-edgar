package com.sec.edgar;

import com.sec.edgar.cik.CIKList;
import java.util.ArrayList;
import java.util.HashMap;

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
        HashMap<String, Integer> cikMap = mCikList.requestAndUpdate(tickers);

        System.out.println("Printing keys...");
        for (String key: cikMap.keySet()) {
            System.out.println(key + ": " + cikMap.get(key));
        }
    }
}
