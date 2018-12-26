package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ReviewWriteConfirmAction extends ActionSupport implements SessionAware{

	private String rating;
	private String comment;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute(){
		String result = SUCCESS;

		if(rating.matches("[1-4][.][\\d]") || rating.matches("[5][.][0]")){
			session.put("rating",rating);
			session.put("comment", comment);
		}else{
			errorMessage = ("入力が正しくありません。");
			result = ERROR;
		}

		return result;
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
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


}
