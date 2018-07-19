package com.test.jsp.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	private static Connection con;
	
	public static Connection getCon() {
		if(DBCon.con==null) {
			String path="/dbconfig.properties";
			Properties prop = new Properties();
			InputStream is = DBCon.class.getResourceAsStream(path);
			try {
				prop.load(is);
				Class.forName(prop.getProperty("driver"));
				DBCon.con = DriverManager.getConnection(prop.getProperty("url"),
						prop.getProperty("id"), prop.getProperty("pwd"));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("접속 완료");
		return DBCon.con;
	}
	
	public static void close() {
		if(DBCon.con!=null) {
			try {
				DBCon.con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DBCon.con = null;
	}
	
	public static void main(String[] args) {
		DBCon.getCon();
	}
}
