package com.internousdev.ecsite_t.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite_t.dto.ItemDetailsDTO;
import com.internousdev.ecsite_t.util.DBConnector;

public class ItemDetailsDAO {
	DBConnector db =new DBConnector();
	Connection con=db.getConnection();

	public ArrayList<ItemDetailsDTO>getItemDate(String id) throws SQLException{
		ArrayList<ItemDetailsDTO>itemListDTO=new ArrayList<ItemDetailsDTO>();
		String sql="SELECT * FROM item_info_transaction WHERE id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();

			while (rs.next()){
				ItemDetailsDTO dto=new ItemDetailsDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));
				itemListDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}return itemListDTO;
	}
	}