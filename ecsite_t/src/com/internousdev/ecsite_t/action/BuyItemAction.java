//package com.internousdev.ecsite_t.action;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Map;
//
//import org.apache.struts2.interceptor.SessionAware;
//
//import com.internousdev.ecsite_t.dao.BuyItemDAO;
//import com.internousdev.ecsite_t.dto.BuyItemDTO;
//import com.opensymphony.xwork2.ActionSupport;
//
//public class BuyItemAction extends ActionSupport implements SessionAware{
//	public Map<String,Object>session;
//	private int count;
//	private String pay;
//	private String message;
//	ArrayList<BuyItemDTO> stockDTO =new ArrayList<BuyItemDTO>();
//	public String execute(){
//		BuyItemDAO dao=new BuyItemDAO();
//		session.put("count", count);
//		int intCount=Integer.parseInt(session.get("count").toString());
//		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
//		session.put("total_price", intCount * intPrice);
//		String payment;
//		if(pay.equals("1")){
//			payment="現金払い";
//			session.put("pay", payment);
//		}else{
//			payment="クレジットカード";
//			session.put("pay", payment);
//		}
//		private BuyItemDAO stockDAO=new BuyItemDAO();
//		private ArrayList<BuyItemDTO>stockItem=new ArrayList<BuyItemDTO>();
//
//		int item_stock;
//		stockItem=stockDAO.getIstock(item_stock);
//
//	if (count>item_stock) {
//		return ERROR;
//	}
//		String result=SUCCESS;
//		return result;
//	}
//		private BuyItemDAO stockDAO=new BuyItemDAO();
//		private ArrayList<BuyItemDTO>stockItem=new ArrayList<BuyItemDTO>();
//
//		int item_stock;
//		stockItem=stockDAO.getIstock(item_stock);
//
//	if (count>item_stock) {
//		return ERROR;
//	}
//
//	public void setCount(int count){
//		this.count=count;
//	}
//	public void setPay(String pay){
//		this.pay=pay;
//	}
//	@Override
//	public void setSession(Map<String,Object>session){
//		this.session=session;
//	}
//	public String getMessage() {
//		return message;
//	}
//	public void setMessage(String message) {
//		this.message = message;
//	}
//}
////////////////////////////////////////////////////////////////////////////////////
//package com.internousdev.ecsite_t.action;
//
//import java.util.Map;
//
//import org.apache.struts2.interceptor.SessionAware;
//
//import com.opensymphony.xwork2.ActionSupport;
//
//public class BuyItemAction extends ActionSupport implements SessionAware{
//	public Map<String,Object>session;
//	private int count;
//	private String pay;
//	public String execute(){
//		String result=SUCCESS;
//		session.put("count", count);
//		int intCount=Integer.parseInt(session.get("count").toString());
//		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
//		session.put("total_price", intCount * intPrice);
//		String payment;
//		if(pay.equals("1")){
//			payment="現金払い";
//			session.put("pay", payment);
//		}else{
//			payment="クレジットカード";
//			session.put("pay", payment);
//		}
//		return result;
//	}
//	public void setCount(int count){
//		this.count=count;
//	}
//	public void setPay(String pay){
//		this.pay=pay;
//	}
//	@Override
//	public void setSession(Map<String,Object>session){
//		this.session=session;
//	}
//}
package com.internousdev.ecsite_t.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite_t.dao.BuyItemDAO;
import com.internousdev.ecsite_t.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private int count;
	private String pay;
	private String message;
	public String execute(){
		session.put("count", count);
		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		BuyItemDTO dto=new BuyItemDTO();
		session.put("total_price", intCount * intPrice);
		String payment;
		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay", payment);
		}else{
			payment="クレジットカード";
			session.put("pay", payment);
		}
		BuyItemDAO dao=new BuyItemDAO();
		dto = dao.getBuyItemInfo();
		int stock = Integer.parseInt(dto.getItemStock());
		if (count>stock) {
			setMessage("在庫がありません。");
			return ERROR;
		}
		String result=SUCCESS;
		return result;
	}
	public void setCount(int count){
		this.count=count;
	}
	public void setPay(String pay){
		this.pay=pay;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}

