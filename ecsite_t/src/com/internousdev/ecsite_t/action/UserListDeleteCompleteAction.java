package com.internousdev.ecsite_t.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite_t.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private UserListDeleteCompleteDAO dao=new UserListDeleteCompleteDAO();
	private String message;
	public String execute() throws SQLException{

		int res=dao.userListDelete();

		if(res>0){
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
		String result=SUCCESS;
		return result;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}

}
