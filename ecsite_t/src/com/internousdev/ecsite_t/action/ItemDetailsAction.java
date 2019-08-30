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
	private String nId = "";

	public String execute() throws SQLException{
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
	public String getnId() {
		return nId;
	}
	public void setnId(String nId) {
		this.nId = nId;
	}
	public ArrayList<ItemDetailsDTO> getItemListD() {
		return itemListD;
	}
}
