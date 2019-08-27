package com.internousdev.ecsite_t.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite_t.dao.ItemListDAO;
import com.internousdev.ecsite_t.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private ItemListDAO dao=new ItemListDAO();
	private ArrayList<ItemListDTO> itemList=new ArrayList<ItemListDTO>();

	@Override
	public String execute() throws SQLException{
		itemList=dao.getItemInfo();

		String result=SUCCESS;
		return result;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public ArrayList<ItemListDTO> getItemList(){
		return this.itemList;
	}

}
