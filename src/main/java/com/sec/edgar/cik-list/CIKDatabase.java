package com.sec.edgar.cik-list;

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
// Singleton design since there is only one database...
public class CIKDatabase {
    private static final String DATABASE_NAME = "TickerMeta.db";
    // TODO: Put somewhere else than current directory
    private static final String DATABASE_LOCATION = "jdbc:sqlite:" + DATABASE_NAME;
    private static final String CREATE_TABLE_STATEMENT =
            "CREATE TABLE IF NOT EXISTS cik_values ("
            + "_id integer PRIMARY KEY, "
            + "ticker char(8), "
            + "cik integer"
            + ");";
    
    // Keep connection so we do not have to keep opening a connection
    private Connection mConnection = null;
    private static CIKDatabase mSelf = null;
    
    // Has no input initially
    private CIKDatabase() {
        // Create database if not exist
        createTickerMetaDatabase(DATABASE_LOCATION);
        // Create table if not exist
        createCikTable(DATABASE_LOCATION, CREATE_TABLE_STATEMENT);
    }
    
    public static CIKDatabase getCikDatabase() {
        if (mSelf == null)
            mSelf = new CIKDatabase();
        
        return mSelf;
    }
    
    private Connection connect(String url) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return conn;
    }
    
    /**
     * If connection cannot be established print error log.
     * If SQL Exception print error log.
     * Create Database and print driver name.
     * @param url
     */
    private void createTickerMetaDatabase(String url) {
        try (Connection conn = this.getConnection(url)) {
            if (conn == null) {
                System.err.println("Failed to initialize database: " + url);
                return;
            }
            
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("The driver name is: " + meta.getDriverName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * If connection fails or SQL Exception print error log.
     * Create table.
     * @param url
     * @param tableDefineSql
     */
    private void createCikTable(String url, String tableDefineSql) {
        try (Connection conn = this.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(tableDefineSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection(String url) {
        if (mConnection == null)
            mConnection = connect(url);
        
        return mConnection;
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
        
        try (Connection conn = this.getConnection(DATABASE_LOCATION);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
        
        try (Connection conn = this.getConnection(DATABASE_LOCATION);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            if (!rs.next())
                return -1;
            
            return rs.getString("cik");
        } catch (SQLException e) {
            e.printStackTrace();
            return -2;
        }
    }
}
