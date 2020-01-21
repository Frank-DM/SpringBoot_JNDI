package com.frank.db.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DBUtils {

	private static InitialContext context;

	@Value(value="${JNDI.Sybase.CLAIMS}")
	public  String SYBASE_CLAIMS = "jdbc/Sybase_claims";
	@Value(value="${JNDI.Sybase.DB_IWS_REF}")
	public  String SYBASE_DB_IWS_REF = "jdbc/Sybase_iws_ref";
	
	static final Logger log = LoggerFactory.getLogger("ServiceLog");

	private DBUtils() {
		super();
	}


	public Connection getConnection(String jndiName) throws Exception {
		DataSource ds = getDataSource(jndiName);
		if(ds==null) {
			throw new RuntimeException("Can't get valid datasource, jndiName:"+jndiName);
		}
		return ds.getConnection();
	}

	public synchronized DataSource getDataSource(String  jndiName) {
		DataSource ds = null;
		try {
			if (context == null)
				context = new InitialContext();
			ds = (DataSource) context.lookup(jndiName);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public List<Map<String, Object>> excuteSQL(String jndiName,String sql)  throws Exception {
		
		Connection conn = getConnection(jndiName);
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.executeQuery();
		ResultSet rs = stmt.getResultSet();
		
		List<Map<String, Object>> rsList = new ArrayList<Map<String, Object>>();
		if(rs ==null) {
			return null;
		}

		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();

		while (rs.next()) {
			Map<String,Object> rowData = new HashMap<String,Object>();
			for (int i = 1; i <= columnCount; i++) {
				rowData.put(metaData.getColumnName(i), rs.getObject(i));
			}
			rsList.add(rowData);
 
		}
		
		stmt.close();
		conn.close();
		return rsList;
	}
	
 public List<Object> excuteSQL2(String jndiName,String sql)  throws Exception {
		
	    List<Object> rsList=new ArrayList<>();
	    Connection conn = getConnection(jndiName);
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.executeQuery();
		ResultSet rs = stmt.getResultSet();
		if(rs ==null) {
			return null;
		}
		
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		while (rs.next()) {
			Map<String,Object> rowData = new HashMap<String,Object>();
			for (int i = 1; i <= columnCount; i++) {
				rsList.add(rs.getObject(i));
			}
		}
		stmt.close();
		conn.close();
		return rsList;
	}
	
	public void excuteSP(String jndiName,String sql)  throws Exception {
		Connection conn = getConnection(jndiName);
		CallableStatement call = conn.prepareCall(sql);
		call.execute();
		call.close();
		conn.close();
	}

	
}