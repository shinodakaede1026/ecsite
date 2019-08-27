package com.internousdev.ecsite_t.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite_t.dao.MyPageDAO;
import com.internousdev.ecsite_t.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private MyPageDAO myPageDAO=new MyPageDAO();
	private ArrayList<MyPageDTO>myPageList=new ArrayList<MyPageDTO>();
	public String deleteFlg;
	private String message;
	//全体↓
	public String execute() throws SQLException{
		if(!session.containsKey("login_user_id")){
			return ERROR;
			}
		//削除の命令が来ない時
		if(deleteFlg==null){
		//購入履歴情報の制限(ユーザーが買ったノートの履歴)
			String item_transaction_id=session.get("id").toString();
			String user_master_id=session.get("login_user_id").toString();
			//DAOでsql文を使ってdatabaseから持ってくる。
			myPageList=myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);
		//削除の命令が来た時
		}else if(deleteFlg.equals("1")){
			delete();
		}
		String result=SUCCESS;
		return result;
	}
	public void delete()throws SQLException{

		String item_transaction_id=session.get("id").toString();
		String user_master_id=session.get("login_user_id").toString();

		//購入履歴情報の削除の制限(ユーザーが買ったノートの履歴だけを削除)
		int res=myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);

		if(res>0){
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}
	public String getDeleteFlg(){
		return deleteFlg;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public ArrayList<MyPageDTO> getMyPageList(){
		return this.myPageList;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message=message;
	}
}
