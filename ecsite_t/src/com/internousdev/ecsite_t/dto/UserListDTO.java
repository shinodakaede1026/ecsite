package com.internousdev.ecsite_t.dto;

public class UserListDTO {
	public String id;
	public String loginId;
	public String loginPassword;
	public String userName;

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId=loginId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
}
