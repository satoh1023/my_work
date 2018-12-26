package com.internousdev.ecsite.action;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ReviewListDAO;
import com.internousdev.ecsite.dto.ReviewListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewListAction extends ActionSupport implements SessionAware{

	private List<ReviewListDTO> reviewListDTOList = new ArrayList<ReviewListDTO>();
	private List<Double> reviewRatingList = new ArrayList<Double>();
	private String id;
	private String itemName;
	private double ratingAverage;
	public Map<String,Object> session;

	public String execute() throws SQLException{

		ReviewListDAO reviewListDAO = new ReviewListDAO();
		reviewListDTOList = reviewListDAO.getReviewList(id);
		reviewRatingList = reviewListDAO.getReviewRatingList(id);

		String result = ERROR;
		double x = 0.0;

		if(!(reviewRatingList.isEmpty())){
			for(double i:reviewRatingList){
				x += i;
			}
			double ratingAverage =x/reviewRatingList.size();
			BigDecimal bd = new BigDecimal(ratingAverage);
		      bd = bd.setScale(1, RoundingMode.HALF_UP);
			session.put("ratingAverage",bd);
			result = SUCCESS;
		}else{
			ratingAverage =99.9;
			session.put("ratingAverage",ratingAverage);
			result = SUCCESS;
		}
		return result;
	}

	public List<ReviewListDTO> getReviewListDTOList() {
		return reviewListDTOList;
	}
	public void setReviewListDTOList(List<ReviewListDTO> reviewListDTOList) {
		this.reviewListDTOList = reviewListDTOList;
	}
	public List<Double> getReviewRatingList() {
		return reviewRatingList;
	}
	public void setReviewRatingList(List<Double> reviewRatingList) {
		this.reviewRatingList = reviewRatingList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getRatingAverage() {
		return ratingAverage;
	}

	public void setRatingAverage(double ratingAverage) {
		this.ratingAverage = ratingAverage;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}
