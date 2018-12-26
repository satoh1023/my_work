package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {

	private DateUtil dateUtil=new DateUtil();

	public int createItem(String itemName,String itemPrice,String itemStock)
			throws SQLException{
				DBConnector db=new DBConnector();
				Connection con=db.getConnection();
				int count = 0;
				try{
					String sql="insert into item_info_transaction(item_name,item_price,item_stock,insert_date) values(?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, itemName);
					ps.setString(2, itemPrice);
					ps.setString(3, itemStock);
					ps.setString(4, dateUtil.getDate());
					count = ps.executeUpdate();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					con.close();
				}
				return count;
			}
}
