package com.internousdev.ecsite_t.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite_t.util.DBConnector;
import com.internousdev.ecsite_t.util.DateUtil;

public class UserCreateCompleteDAO {
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	private DateUtil date=new DateUtil();
	private String sql="INSERT INTO login_user_transaction(login_id,login_pass,user_name,admin_flg,insert_date)VALUES(?,?,?,'0',?)";

	public void createUser(String loginUserId,String loginUserPassword,String userName)throws
	SQLException{
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginUserPassword);
			ps.setString(3, userName);
			ps.setString(4, date.getDate());

			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

}
