package com.sec.edgar.cik;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import com.sec.edgar.cik.CIKDatabase;
import com.sec.edgar.cik.MockObjects.TestConn;

/**
 * Unit test for simple App.
 */
public class CikTest 
    extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CikTest(String testName) {
        super(testName);
    }

    /**
     * Rigourous Test :-)
     */
    public void testCik()
    {
        assertTrue( true );
    }

    /**
     * Test creation of database
     */
   public void testDatabaseCreate() {
        Connection conn = new TestConn();
        // Table creation
        CIKDatabase cikDb = new CIKDatabase(conn);

        // Insert into table values
        Map<String, Integer> values = new HashMap<String, Integer>(3);
        values.put("NVDA", 9834);
        values.put("AMD", 29384);
        values.put("AAPL", -1);

        cikDb.insertIntoCikTable(values);
    }

     /**
     * Test insert into database
     */
   public void testDatabaseInsert() {
       Connection conn = new TestConn();
       // Table creation
       CIKDatabase cikDb = new CIKDatabase(conn);

       // Insert into table values
       Map<String, Integer> values = new HashMap<String, Integer>(3);
       values.put("NVDA", 9834);
       values.put("AMD", 29384);
       values.put("AAPL", -1);
       
       cikDb.insertIntoCikTable(values);
    }

    /**
     * Test query of database
     */
    public void testDatabaseQuery() {
        Connection conn = new TestConn();
        // Table creation
        CIKDatabase cikDb = new CIKDatabase(conn);
        
        int cik = cikDb.queryCik("NVDA");
        System.out.println("cik: " + cik);
        assertTrue(cik > 0);

    }
}
