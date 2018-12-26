package com.app12306.db.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
	private int id = -1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@NotBlank(message = "账号为空")
	@Size(min = 2, max = 5, message = "账号长度必须在{min}和{max}之间")
	private String account;

	@NotBlank(message = "密码为空")
	@Size(min = 1, max = 15, message = "密码长度必须在{min}和{max}之间")
	private String passwd;

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", passwd=" + passwd + "]";
	}

}
