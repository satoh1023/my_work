package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {

	public  int ItemListDelete(String id) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		PreparedStatement ps;
		String sql="delete from item_info_transaction where id = ?";

		int result=0;
		try{
			ps=con.prepareStatement(sql);
			ps.setString(1,id);
			result=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
	public  int ItemListAllDelete() throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		PreparedStatement ps;
		String sql="delete from item_info_transaction";

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
