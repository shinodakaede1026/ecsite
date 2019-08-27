package com.internousdev.ecsite_t.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite_t.dao.ItemDetailsDAO;
import com.internousdev.ecsite_t.dto.ItemDetailsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailsAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ItemDetailsDAO dao=new ItemDetailsDAO();
	private ArrayList<ItemDetailsDTO> itemListD=new ArrayList<ItemDetailsDTO>();
	private int nId = 0;

	public String execute() throws SQLException{
		System.out.println(nId);

//		String item_transaction_id=session.get("id").toString();

		//↓二行は同じ意味
//		itemListD=dao.getItemDate(String.valueOf(nId));
		itemListD=dao.getItemDate(""+nId);

		String result=SUCCESS;
		return result;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public ArrayList<ItemDetailsDTO> getItemList(){
		return this.itemListD;
	}
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	public ArrayList<ItemDetailsDTO> getItemListD() {
		return itemListD;
	}

}
