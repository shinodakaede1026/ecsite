package com.internousdev.ecsite_t.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite_t.dao.UserDetailsDAO;
import com.internousdev.ecsite_t.dto.UserDetailsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailsAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private UserDetailsDAO dao=new UserDetailsDAO();
	private ArrayList<UserDetailsDTO> UserListD=new ArrayList<UserDetailsDTO>();
	private String nId="";

	public String execute() throws SQLException{
		UserListD=dao.getUserDate(String.valueOf(nId));

		String result=SUCCESS;
		return result;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public ArrayList<UserDetailsDTO> getUserDate(){
		return this.UserListD;
	}
	public String getnId() {
		return nId;
	}
	public void setnId(String nId) {
		this.nId = nId;
	}
	public ArrayList<UserDetailsDTO> getUserListD(){
		return UserListD;
	}
}
