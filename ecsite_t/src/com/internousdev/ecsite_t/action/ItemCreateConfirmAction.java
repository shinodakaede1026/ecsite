package com.internousdev.ecsite_t.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{

	private String itemName;
	private int itemPrice;
	private int itemStock;
	public Map<String,Object>session;
	private String errorMessage;

	public String execute(){
		String result=SUCCESS;

		if(!(itemName.equals(""))){
			session.put("itemName", itemName);
		}if((itemPrice >-1) && (itemStock >-1)){
			session.put("itemPrice", itemPrice);
			session.put("itemStock", itemStock);
		}else{
			setErrorrMessage("未入力の項目があります。");
			result=ERROR;
		}
		return result;
	}
	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	public int getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(int itemPrice){
		this.itemPrice=itemPrice;
	}
	public int getItemStock(){
		return itemStock;
	}
	public void setItemStock(int itemStock){
		this.itemStock=itemStock;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public String getErrorMesssage(){
		return errorMessage;
	}
	public void setErrorrMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}

}
