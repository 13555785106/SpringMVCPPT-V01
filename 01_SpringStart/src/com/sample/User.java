package com.sample;

public class User {
	private String id;
	private String account;
	private String passwd;
	private Address address;
	public User() {
	}

	public User(String id, String account, String passwd) {
		setId(id);
		setAccount(account);
		setPasswd(passwd);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", passwd=" + passwd + ", address=" + address + "]";
	}

	
	

}
