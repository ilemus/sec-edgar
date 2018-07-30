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
     * Test creation of database and inserts
     */
    public void testDatabase() {
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
}
