package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	private DateUtil dateUtil=new DateUtil();

	public int buyItemInfo(String item_transaction_id,String user_master_id,String total_price,String total_count,String pay)
			throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		int count = 0;
		try{
			String sql="insert into user_buy_item_transaction (item_transaction_id,total_price,total_count,user_master_id,pay,insert_date) values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,item_transaction_id);
			ps.setString(2,total_price);
			ps.setString(3,total_count );
			ps.setString(4,user_master_id);
			ps.setString(5,pay);
			ps.setString(6,dateUtil.getDate());
			count = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return count;
	}

	public void updateItemStock(String item_stock,String id) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		try{
			String sql="update item_info_transaction set item_stock=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,item_stock);
			ps.setString(2,id);
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
}
