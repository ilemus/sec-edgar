package com.sec.edgar;

import java.util.ArrayList;
import java.util.HashMap;

import com.sec.edgar.cik.CIKList;


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
        // Request from server and update database, or load from database
        HashMap<String, Integer> sp500 = mCikList.loadSP500CIK();
        System.out.println("Number of saved keys: " + sp500.size());
    }
}
