package com.sec.edgar.cik;

import java.sql.Connection;

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
        CIKDatabase cikDb = new CIKDatabase(conn);
        
    }
}
