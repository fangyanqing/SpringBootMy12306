package com.neuedu.catshop.entity;

public class Admin {
	private Integer adminId;
	private String adminName;
	private String password;
	private String pic;
	
	
	
	public Admin() {
		super();
	}
	public Admin(Integer adminId, String adminName, String password, String pic) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
		this.pic = pic;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", password=" + password + ", pic=" + pic
				+ ", getAdminId()=" + getAdminId() + ", getAdminName()=" + getAdminName() + ", getPassword()="
				+ getPassword() + ", getPic()=" + getPic() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
