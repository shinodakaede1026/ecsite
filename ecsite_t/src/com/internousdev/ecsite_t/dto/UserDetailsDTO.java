package com.internousdev.ecsite_t.dto;

public class UserDetailsDTO {
	public String id;
	public String loginId;
	public String loginPass;
	public String userName;
	public String adminFlg;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAdminFlg() {
		return adminFlg;
	}
	public void setAdminFlg(String adminFlg) {
		this.adminFlg = adminFlg;
	}
}
