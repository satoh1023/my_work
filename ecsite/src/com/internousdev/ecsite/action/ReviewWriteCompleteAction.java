package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ReviewWriteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewWriteCompleteAction extends ActionSupport implements SessionAware{

	private String reviewId;
	private String rating;
	private String comment;
	private String userName;
	private Map<String,Object> session;

	public String execute() throws SQLException{

		String result = ERROR;
		ReviewWriteCompleteDAO reviewWriteCompleteDAO = new ReviewWriteCompleteDAO();
		int count = reviewWriteCompleteDAO.createReview(session.get("reviewId").toString(),
				session.get("userName").toString(),
				session.get("rating").toString(),
				session.get("comment").toString());
		if(count > 0){
			result=SUCCESS;
		}
			return result;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
