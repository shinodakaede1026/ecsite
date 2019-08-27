package com.internousdev.ecsite_t.dto;

public class BuyItemDTO {
	private int itemId;
	private String itemName;
	private String itemPrice;
	private String itemStock;

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice=itemPrice;
	}
	public int getItemId(){
		return itemId;
	}
	public void setItemId(int itemId){
		this.itemId=itemId;
	}
	public String getItemStock(){
		return itemStock;
	}
	public void setItemStock(String itemStock){
	this.itemStock=itemStock;
	}

}
