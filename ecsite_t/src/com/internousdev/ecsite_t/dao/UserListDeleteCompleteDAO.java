package com.internousdev.ecsite_t.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite_t.util.DBConnector;

public class UserListDeleteCompleteDAO {
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

	public int userListDelete() throws SQLException{
		String sql="DELETE FROM login_user_transaction WHERE admin_flg=0";
		PreparedStatement ps;
		int result=0;
		try{
			ps=con.prepareStatement(sql);
			result=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

}
