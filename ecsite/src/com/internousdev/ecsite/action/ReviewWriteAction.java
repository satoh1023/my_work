package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ReviewWriteAction extends ActionSupport implements SessionAware{

	private String reviewId;
	private String reviewItemName;
	public Map<String,Object> session;

	public String execute() throws SQLException{

		session.put("reviewId", reviewId);
		session.put("reviewItemName", reviewItemName);
		String result=SUCCESS;
		return result;
	}

	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getReviewItemName() {
		return reviewItemName;
	}
	public void setReviewItemName(String reviewItemName) {
		this.reviewItemName = reviewItemName;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}
