package com.internousdev.ecsite_t.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite_t.util.DBConnector;

public class ItemCreateCompleteDAO{
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	private String sql="INSERT INTO item_info_transaction(item_name,item_price,item_stock)VALUES(?,?,?)";

	public void createItem(String itemName, int itemPrice,int itemStock)throws SQLException{
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.setInt(2, itemPrice);
			ps.setInt(3, itemStock);
				ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
}
}