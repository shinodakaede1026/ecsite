package com.internousdev.ecsite_t.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite_t.dao.BuyItemDAO;
import com.internousdev.ecsite_t.dao.LoginDAO;
import com.internousdev.ecsite_t.dto.BuyItemDTO;
import com.internousdev.ecsite_t.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String result;
	private Map<String, Object> session;

	public String execute() throws SQLException{
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		BuyItemDAO buyItemDAO = new BuyItemDAO();

		result = ERROR;
		//結果を返す
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

		session.put("loginUser", loginDTO);

		if (((LoginDTO) session.get("loginUser")).getLoginFlg()) {

			session.put("login_user_id", loginDTO.getLoginId());
			session.put("admin_Flg",loginDTO.getAdminFlg());

			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("id", buyItemDTO.getItemId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			if(loginDTO.getAdminFlg().equals("1")){
				result="admin";
				return result;
			}else{
				result = SUCCESS;
			}
			return result;
		}
		return result;
		}
	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
