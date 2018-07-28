package com.sec.edgar.cik;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Map.Entry;

// Database tables will be primary key _id, string ticker, int value
public class CIKDatabase {
    private static final String DATABASE_NAME = "TickerMeta.db";
    // TODO: Put somewhere else than current directory
    public static final String DATABASE_LOCATION = "jdbc:sqlite:" + DATABASE_NAME;
    private static final String CREATE_TABLE_STATEMENT =
            "CREATE TABLE IF NOT EXISTS cik_values ("
            + "_id integer PRIMARY KEY, "
            + "ticker char(8), "
            + "cik integer"
            + ");";

    // Keep connection so we do not have to keep opening a connection
    private Connection mConnection = null;

    // Has no input initially
    public CIKDatabase(Connection conn) {
        mConnection = conn;
        // Create table if not exist
        createCikTable(CREATE_TABLE_STATEMENT);
    }

    /**
     * If connection fails or SQL Exception print error log.
     * Create table.
     * @param url
     * @param tableDefineSql
     */
    private void createCikTable(String tableDefineSql) {
        Statement stmt;

        try {
            stmt = mConnection.createStatement();
            stmt.execute(tableDefineSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Input key value map
     * @param ticker
     * @param cik
     */
    public void insertIntoCikTable(Map<String, Integer> collection) {
        // Nothing to insert, so skip
        if (collection.size() == 0) return;

        String sql = "INSERT INTO cik_values(ticker, cik) VALUES(?, ?)";
        PreparedStatement pstmt;

        try {
            pstmt = mConnection.prepareStatement(sql);
            int batchCount = 0;
            for (Entry<String, Integer> entry: collection.entrySet()) {
                // ticker
                pstmt.setString(1, entry.getKey());
                // cik
                pstmt.setInt(2, entry.getValue());
                
                pstmt.addBatch();
                batchCount++;
                
                // Since there is a limit to the size of the batches (or save all)
                if (batchCount % 1000 == 0 || batchCount == collection.size()) {
                    pstmt.executeBatch();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get CIK from database given ticker name (Ex. NVDA returns 0001045810)
     * @param ticker
     * @return
     */
    public int queryCik(String ticker) {
        String sql = "SELECT cik FROM cik_values WHERE ticker=" + ticker;
        Statement stmt;
        ResultSet rs;

        try {
            stmt = mConnection.createStatement();
            rs = stmt.executeQuery(sql);
            if (!rs.next())
                return -1;
            
            return rs.getInt("cik");
        } catch (SQLException e) {
            e.printStackTrace();
            return -2;
        }
    }
}
