package com.internousdev.ecsite_t.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite_t.util.DBConnector;

public class ItemListDeleteCompleteDAO {
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

	public int itemListDelete() throws SQLException{
		String sql="DELETE FROM item_info_transaction";
		PreparedStatement ps;
		int result=0;
		try{
			ps=con.prepareStatement(sql);
			result=ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

}
