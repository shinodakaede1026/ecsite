package com.internousdev.ecsite_t.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite_t.dto.UserDetailsDTO;
import com.internousdev.ecsite_t.util.DBConnector;

public class UserDetailsDAO {
	DBConnector db =new DBConnector();
	Connection con=db.getConnection();

	public ArrayList<UserDetailsDTO>getUserDate(String id)throws SQLException{
		ArrayList<UserDetailsDTO>userListDTO=new ArrayList<UserDetailsDTO>();
		String sql="SELECT * FROM login_user_transaction WHERE id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();

			while (rs.next()){
				UserDetailsDTO dto=new UserDetailsDTO();
				dto.setId(rs.getString("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setAdminFlg(rs.getString("admin_flg"));
				userListDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}return userListDTO;
	}
}
