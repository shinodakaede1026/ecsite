package com.internousdev.ecsite_t.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite_t.dto.UserListDTO;
import com.internousdev.ecsite_t.util.DBConnector;

public class UserListDAO {
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

public ArrayList<UserListDTO>getUserInfo() throws SQLException{
	ArrayList<UserListDTO>userListDTO=new ArrayList<UserListDTO>();
	String sql="SELECT * FROM login_user_transaction";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();

		while(rs.next()){
			UserListDTO dto=new UserListDTO();
			dto.setId(rs.getString("id"));
			dto.setLoginId(rs.getString("login_id"));
			dto.setLoginPassword(rs.getString("login_pass"));
			dto.setUserName(rs.getString("user_name"));
			userListDTO.add(dto);
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		con.close();
	}
	return userListDTO;
}

public ArrayList<UserListDTO> getUserInfo(String string) {
	// TODO 自動生成されたメソッド・スタブ
	return null;
}

}
