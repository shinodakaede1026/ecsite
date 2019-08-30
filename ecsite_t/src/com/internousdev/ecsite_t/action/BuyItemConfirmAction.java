package com.internousdev.ecsite_t.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite_t.dao.BuyItemCompleteDAO;
import com.internousdev.ecsite_t.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {
	DBConnector dbConnector = new DBConnector();
	Connection connection = dbConnector.getConnection();
	private Map<String, Object> session;
	public String execute() throws SQLException {
		BuyItemCompleteDAO dao = new BuyItemCompleteDAO();
		dao.buyItemInfo(
			session.get("id").toString(),
			session.get("login_user_id").toString(),
			session.get("total_price").toString(),
			session.get("count").toString(),
			session.get("pay").toString());
		//jspから引きたい個数を持ってくる
		dao.update(session.get("count").toString());
		String result=SUCCESS;
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}