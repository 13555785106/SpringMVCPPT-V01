package com.hr.test.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class Test01 {

	public static void main(String[] args) {
		BasicDataSource basicDataSource = null;
		try {
			basicDataSource = new BasicDataSource();
			basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
			basicDataSource.setUrl(
					"jdbc:mysql://localhost:3306/exam?useUnicode=true&amp;characterEncoding=UTF8&amp;useSSL=true");
			basicDataSource.setUsername("exam");
			basicDataSource.setPassword("123456");
			Connection conn = basicDataSource.getConnection();
			System.out.println(conn);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				basicDataSource.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
