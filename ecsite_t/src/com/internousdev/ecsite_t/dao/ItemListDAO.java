package com.internousdev.ecsite_t.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite_t.dto.ItemListDTO;
import com.internousdev.ecsite_t.util.DBConnector;

public class ItemListDAO {
	DBConnector db =new DBConnector();
	Connection con=db.getConnection();

public ArrayList<ItemListDTO>getItemInfo() throws SQLException{
	ArrayList<ItemListDTO>itemListDTO=new ArrayList<ItemListDTO>();
	String sql="SELECT * FROM item_info_transaction";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();

		while (rs.next()){
			ItemListDTO dto=new ItemListDTO();
			dto.setId(rs.getString("id"));
			dto.setItemName(rs.getString("item_name"));
			dto.setItemPrice(rs.getString("item_price"));
			dto.setItemStock(rs.getString("item_stock"));
			dto.setInsert_date(rs.getString("insert_date"));
			itemListDTO.add(dto);
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		con.close();
	}return itemListDTO;
}
}
