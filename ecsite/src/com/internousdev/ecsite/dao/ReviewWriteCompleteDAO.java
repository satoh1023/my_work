package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ReviewWriteCompleteDAO {

	private DateUtil dateUtil=new DateUtil();
	private String sql="insert into review_info_transaction(review_id,user_name,rating,comment,insert_date) values(?,?,?,?,?)";

	public int createReview(String reviewId,String userName,String rating,String comment)
			throws SQLException{
				DBConnector db=new DBConnector();
				Connection con=db.getConnection();
				int count = 0;
				try{
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, reviewId);
					ps.setString(2, userName);
					ps.setString(3, rating);
					ps.setString(4, comment);
					ps.setString(5, dateUtil.getDate());
					count = ps.executeUpdate();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					con.close();
				}
				return count;
	}
}
