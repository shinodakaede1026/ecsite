package com.internousdev.ecsite_t.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemComfirmDAO extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private BuyItemCompleteDAO comdao=new BuyItemCompleteDAO();
	public String execute() throws SQLException {
		comdao.buyItemInfo(
				session.get("id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString(),
				session.get("pay").toString());

		String result=SUCCESS;
		return result;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}

}
