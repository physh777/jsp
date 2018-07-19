package com.test.jsp.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Test {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jsp";
		String id = "root";
		String pwd = "r1r2r3";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement("select * from user_info");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
