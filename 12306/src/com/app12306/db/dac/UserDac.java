package com.app12306.db.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.app12306.db.DB;
import com.app12306.db.model.User;

public class UserDac extends Dac {
	private static UserDac instance = null;

	private UserDac() {
	}

	public static UserDac getInstance() {
		if (instance == null)
			instance = new UserDac();
		return instance;
	}

	public List<User> allUsers() {
		List<User> userList = null;
		try {
			userList = DB.getInstance().qr().query(getSql("allUsers"), new BeanListHandler<>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	public User getUser(int id) {
		User user= null;
		try {
			user = DB.getInstance().qr().query(getSql("getUser"), new BeanHandler<>(User.class),new Object[] {id});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getInstance().qr().getDataSource().getConnection();
			stmt = conn.prepareStatement(getSql("addUser"), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getAccount());
			stmt.setString(2, user.getPasswd());
			if (stmt.executeUpdate() == 1) {
				rs = stmt.getGeneratedKeys();
				if (rs.next())
					user.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	public boolean chgUser(User user) {
		try {
			return 1 == DB.getInstance().qr().update(getSql("chgUser"), user.getAccount(), user.getPasswd(),user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delUser(int id) {
		try {
			return 1 == DB.getInstance().qr().update(getSql("delUser"), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User login(String account,String passwd) {
		User user = null;
		try {
			user = DB.getInstance().qr().query(getSql("login"),new BeanHandler<>(User.class), new Object[] {account, passwd});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public boolean accountExist(String account) {
		int ret=0;
		try {
			ret= DB.getInstance().qr().query(getSql("accountExist"), new ScalarHandler<Integer>(),new Object[] {account});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret ==1;
	}

	public boolean accountExist(int id,String account) {
		int ret=0;
		try {
			ret= DB.getInstance().qr().query(getSql("accountExist2"), new ScalarHandler<Integer>(),new Object[] {id,account});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret ==1;
	}
}
