package com.sec.edgar.cik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sec.edgar.cik.CIKParser;

public class CIKList {
    public static final String[] mSp500 = {"NVDA"};
    private CIKDatabase mCikDb = null; 

    public CIKList() {
        // load the sqlite-JDBC driver using the current class loader
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn;
        try {
        	conn = DriverManager.getConnection(
                    CIKDatabase.DATABASE_LOCATION,
                    CIKDatabase.USER_NAME,
                    CIKDatabase.PASSWORD
                );
        	mCikDb = new CIKDatabase(conn);
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }

    /**
     * Load from database.
     * If cannot find in database it is not included in HashMap result.
     * @param tickers
     * @return
     */
    private HashMap<String, Integer> loadCikFromDb(ArrayList<String> tickers) {
        HashMap<String, Integer> cikLoaded = new HashMap<String, Integer>();
        if (mCikDb == null) return cikLoaded;

        for (int i = 0; i < tickers.size(); i++) {
            int q = mCikDb.queryCik(tickers.get(i));
            if (q < 0) continue;
            else {
                cikLoaded.put(tickers.get(i), q);
            }
        }

        return cikLoaded;
    }

    private int makeRequest(String ticker) {
        String response;
        try {
            String request = String.format(CIKParser.REQUEST_FORMAT, ticker);
            System.out.println("request: " + request);
            response = CIKParser.executeGet(request);
        } catch (Exception e) {
            return -3;
        }
        
        CIKParser parser = new CIKParser(response);
        return parser.parsePageForCik();
    }
    
    /**
     * Load from server.
     * If cannot find, then do not save to database.
     * Return result of successful saves.
     * @param tickers
     * @return
     */
    public HashMap<String, Integer> requestAndUpdate(ArrayList<String> tickers) {
        HashMap<String, Integer> cikRequested = new HashMap<String, Integer>();
        for (int i = 0; i < tickers.size(); i++) {
            int result = makeRequest(tickers.get(i));
            if (result > 0) {
                cikRequested.put(tickers.get(i), result);
            } else {
                System.err.println("Error requesting the CIK: " + result);
            }
        }

        // Save to database
        if (mCikDb != null) {
            mCikDb.insertIntoCikTable(cikRequested);
        }

        // Values from server
        return cikRequested;
    }
}
