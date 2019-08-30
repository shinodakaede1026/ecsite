package com.internousdev.ecsite_t.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite_t.dto.BuyItemDTO;
import com.internousdev.ecsite_t.util.DBConnector;

public class BuyItemDAO {
	public BuyItemDTO getBuyItemInfo(){
		DBConnector dbConnector;
		dbConnector=new DBConnector();
		Connection connection= dbConnector.getConnection();
		ResultSet resultSet =null;

		BuyItemDTO buyItemDTO=new BuyItemDTO();

		String sql ="SELECT id,item_name,item_price,item_stock FROM item_info_transaction WHERE id=1";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				buyItemDTO.setItemId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				buyItemDTO.setItemStock(resultSet.getString("item_stock"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;
	}
}
