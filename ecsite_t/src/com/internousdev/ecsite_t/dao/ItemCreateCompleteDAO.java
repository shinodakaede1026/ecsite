package com.internousdev.ecsite_t.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite_t.util.DBConnector;
import com.internousdev.ecsite_t.util.DateUtil;

public class ItemCreateCompleteDAO{
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	private DateUtil date=new DateUtil();
	private String sql="INSERT INTO item_info_transaction(item_name,item_price,item_stock,insert_date)VALUES(?,?,?,?)";

	public void createItem(String itemName, int itemPrice,int itemStock)throws SQLException{
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.setInt(2, itemPrice);
			ps.setInt(3, itemStock);
			ps.setString(4, date.getDate());
				ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
}
}