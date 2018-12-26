package com.hr.test.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.BaseResultSetHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class Test01 {

	public static void main(String[] args) {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource
				.setUrl("jdbc:mysql://localhost:3306/exam?useUnicode=true&amp;characterEncoding=UTF8&amp;useSSL=true");
		basicDataSource.setUsername("exam");
		basicDataSource.setPassword("123456");
		QueryRunner run = new QueryRunner(basicDataSource);

		try {
			// 返回结果集的第一行第一列数据
			System.out.println(run.query("select count(*) from users", new ScalarHandler<Long>()));
			System.out.println(run.query("select * from users", new MapHandler()));
			System.out.println(Arrays.asList(run.query("select * from users", new ArrayHandler())));
			System.out.println(run.query("select * from users", new BeanHandler<>(User.class)));
			System.out.println(run.query("select * from users", new KeyedHandler<Long>()));
			for (Map<String, Object> o : run.query("select * from users", new MapListHandler()))
				System.out.println(o);
			for (Object[] o : run.query("select * from users", new ArrayListHandler())) {
				System.out.println(Arrays.toString(o));
			}
			for (String str : run.query("select * from users", new ColumnListHandler<String>(2))) {
				System.out.println(str);
			}
			for (User user : run.query("select * from users", new BeanListHandler<>(User.class))) {
				System.out.println(user);
			}
			System.out.println(run.query("select * from users", new BeanMapHandler<>(User.class)));
			for (String str : run.query("select * from users", new AbstractListHandler<String>() {
				@Override
				protected String handleRow(ResultSet rs) throws SQLException {
					return rs.getString(1) + ":" + rs.getString(2) + ":" + rs.getString(3);
				}
			})) {
				System.out.println(str);
			}
			for (String str : run.query("select * from users", new BaseResultSetHandler<List<String>>() {

				@Override
				protected List<String> handle() throws SQLException {
					List<String> strList = new ArrayList<String>();
					while(next())
						strList.add(getString(1) + " - " + getString(2) + " - " + getString(3));
					return strList;
				}
			})) {
				System.out.println(str);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			basicDataSource.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
