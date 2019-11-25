package com.neuedu.catshop.entity;

public class User {
	private Integer userId;
	private String nickName;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private String address;
	private String pic;
	
	
	public User() {
		super();
	}
	
	public User(Integer userId) {
		super();
		this.userId = userId;
	}

	public User(Integer userId, String nickName, String userName, String password, String email, String phone,
			String address, String pic) {
		super();
		this.userId = userId;
		this.nickName = nickName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.pic = pic;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
}
