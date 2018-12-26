package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ReviewListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ReviewListDAO {

	public List<ReviewListDTO> getReviewList(String id) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		List<ReviewListDTO> reviewListDTOList = new ArrayList<ReviewListDTO>();
		String sql ="select * from review_info_transaction where review_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ReviewListDTO dto = new ReviewListDTO();
				dto.setReviewId(rs.getString("review_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setRating(rs.getString("rating"));
				dto.setComment(rs.getString("comment"));
				dto.setInsert_date(rs.getString("insert_date"));
				reviewListDTOList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return reviewListDTOList;
	}
	public List<Double> getReviewRatingList(String id) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		List<Double> reviewRatingList = new ArrayList<Double>();
		String sql ="select rating from review_info_transaction where review_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				reviewRatingList.add(rs.getDouble("rating"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return reviewRatingList;
	}
}
