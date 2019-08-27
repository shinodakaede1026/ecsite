package com.internousdev.ecsite_t.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite_t.dao.UserListDAO;
import com.internousdev.ecsite_t.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private UserListDAO dao=new UserListDAO();
	private ArrayList<UserListDTO> userList=new ArrayList<UserListDTO>();

	public String execute() throws SQLException{
		userList=dao.getUserInfo();

		String result=SUCCESS;
		return result;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public ArrayList<UserListDTO> getUserList(){
		return this.userList;
	}

}
