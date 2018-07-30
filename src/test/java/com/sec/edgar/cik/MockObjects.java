package com.sec.edgar.cik;


import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import junit.framework.Assert;

public class MockObjects {
    public static class TestStatement implements Statement {

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public ResultSet executeQuery(String sql) throws SQLException {
            Assert.assertTrue("CREATE TABLE IF NOT EXISTS cik_values (_id integer PRIMARY KEY, ticker char(8), cik integer);".equals(sql));
            return null;
        }

        @Override
        public int executeUpdate(String sql) throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void close() throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public int getMaxFieldSize() throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void setMaxFieldSize(int max) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public int getMaxRows() throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void setMaxRows(int max) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void setEscapeProcessing(boolean enable) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public int getQueryTimeout() throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void setQueryTimeout(int seconds) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void cancel() throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void clearWarnings() throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void setCursorName(String name) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public boolean execute(String sql) throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public ResultSet getResultSet() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int getUpdateCount() throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public boolean getMoreResults() throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void setFetchDirection(int direction) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public int getFetchDirection() throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void setFetchSize(int rows) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public int getFetchSize() throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int getResultSetConcurrency() throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int getResultSetType() throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void addBatch(String sql) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void clearBatch() throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public int[] executeBatch() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Connection getConnection() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean getMoreResults(int current) throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public ResultSet getGeneratedKeys() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int executeUpdate(String sql, String[] columnNames) throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean execute(String sql, int[] columnIndexes) throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean execute(String sql, String[] columnNames) throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public int getResultSetHoldability() throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public boolean isClosed() throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void setPoolable(boolean poolable) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public boolean isPoolable() throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        public void closeOnCompletion() throws SQLException {
            // TODO Auto-generated method stub
            
        }

        public boolean isCloseOnCompletion() throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }
    }
    
    public static class TestPreparedStatement extends TestStatement implements PreparedStatement {
		@Override
		public void addBatch() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void clearParameters() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean execute() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public ResultSet executeQuery() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int executeUpdate() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ResultSetMetaData getMetaData() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ParameterMetaData getParameterMetaData() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setArray(int arg0, Array arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setAsciiStream(int arg0, InputStream arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setBinaryStream(int arg0, InputStream arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setBlob(int arg0, Blob arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setBlob(int arg0, InputStream arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setBoolean(int arg0, boolean arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setByte(int arg0, byte arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setBytes(int arg0, byte[] arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setCharacterStream(int arg0, Reader arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setClob(int arg0, Clob arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setClob(int arg0, Reader arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setClob(int arg0, Reader arg1, long arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setDate(int arg0, Date arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setDouble(int arg0, double arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setFloat(int arg0, float arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setInt(int arg0, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setLong(int arg0, long arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setNCharacterStream(int arg0, Reader arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setNClob(int arg0, NClob arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setNClob(int arg0, Reader arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setNString(int arg0, String arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setNull(int arg0, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setNull(int arg0, int arg1, String arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setObject(int arg0, Object arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setObject(int arg0, Object arg1, int arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setObject(int arg0, Object arg1, int arg2, int arg3) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setRef(int arg0, Ref arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setRowId(int arg0, RowId arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setSQLXML(int arg0, SQLXML arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setShort(int arg0, short arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setString(int arg0, String arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setTime(int arg0, Time arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setTimestamp(int arg0, Timestamp arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setURL(int arg0, URL arg1) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setUnicodeStream(int arg0, InputStream arg1, int arg2) throws SQLException {
			// TODO Auto-generated method stub
			
		}
    	
    }

    // Mock Connection
    public static class TestConn implements Connection {
        @Override
        public Statement createStatement() {
            return new TestStatement();
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public PreparedStatement prepareStatement(String sql) throws SQLException {
            Assert.assertEquals(sql, "INSERT INTO cik_values(ticker, cik) VALUES(?, ?)");
            return new TestPreparedStatement();
        }

        @Override
        public CallableStatement prepareCall(String sql) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String nativeSQL(String sql) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void setAutoCommit(boolean autoCommit) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public boolean getAutoCommit() throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void commit() throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void rollback() throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void close() throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public boolean isClosed() throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public DatabaseMetaData getMetaData() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void setReadOnly(boolean readOnly) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public boolean isReadOnly() throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void setCatalog(String catalog) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public String getCatalog() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void setTransactionIsolation(int level) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public int getTransactionIsolation() throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void clearWarnings() throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
                throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void setHoldability(int holdability) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public int getHoldability() throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Savepoint setSavepoint(String name) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void rollback(Savepoint savepoint) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
                throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
                int resultSetHoldability) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
                int resultSetHoldability) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Clob createClob() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Blob createBlob() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public NClob createNClob() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public SQLXML createSQLXML() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean isValid(int timeout) throws SQLException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void setClientInfo(String name, String value) throws SQLClientInfoException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void setClientInfo(Properties properties) throws SQLClientInfoException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public String getClientInfo(String name) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Properties getClientInfo() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        public void setSchema(String schema) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        public String getSchema() throws SQLException {
            // TODO Auto-generated method stub
            return null;
        }

        public void abort(Executor executor) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
            // TODO Auto-generated method stub
            
        }

        public int getNetworkTimeout() throws SQLException {
            // TODO Auto-generated method stub
            return 0;
        }
    }
}
