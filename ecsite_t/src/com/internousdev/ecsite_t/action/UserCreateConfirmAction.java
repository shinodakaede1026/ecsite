package com.internousdev.ecsite_t.action;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite_t.dao.LoginDAO;
import com.internousdev.ecsite_t.dto.LoginDTO;
import com.internousdev.ecsite_t.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction  extends ActionSupport implements SessionAware{

		private String loginUserId;
		private String loginPassword;
		private String userName;
		public Map<String,Object>session;
		LoginDAO dao=new LoginDAO();
		LoginDTO dto=new LoginDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		private String errorMessage;
		public String execute() throws SQLException{
			String result=SUCCESS;

			if(!(loginUserId.equals(""))
				&&!(loginPassword.equals(""))
				&&!(userName.equals(""))){
			}else{
					setErrorMessage("未入力の項目があります。");
					result=ERROR;
			}
				String sql = "SELECT login_id, count(login_id) FROM login_user_transaction WHERE login_id=?";
	        try {
		            PreparedStatement ps = con.prepareStatement(sql);
		            ps.setString(1, loginUserId);
		            ResultSet rs = ps.executeQuery();
		            int intUserCount=0;
		    		while (rs.next()){
		    			intUserCount = rs.getInt("count(login_id)");
		    		}
					if(intUserCount > 0) {
		            	setErrorMessage("既に登録されているIDです。");
		            	result=ERROR;
		            }
         	}catch(Exception e) {
                e.printStackTrace();
            }finally {
                con.close();
            }
	        return result;
		}
		public String getLoginUserId(){
			return loginUserId;
		}
		public void setLoginUserId(String loginUserId){
			this.loginUserId=loginUserId;
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
		@Override
		public void setSession(Map<String,Object>session){
			this.session=session;
		}
		public String getErrorMessage(){
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage){
			this.errorMessage=errorMessage;
		}
	}