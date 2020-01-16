package com.thekbj.comm;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	private static DBConnection instance=new DBConnection();
	
	public static DBConnection getinstance() {
		return instance;
	}
	private DBConnection() {}
	
	public Connection getConnection() throws SQLException, NamingException{
		Context initctx=new InitialContext();
		DataSource ds=(DataSource)initctx.lookup("java:comp/env/jdbc/thekbj");
		Connection conn=ds.getConnection();
		return conn;
	}
}
