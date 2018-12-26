package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{

	private List<UserListDTO> userListDTOList = new ArrayList<UserListDTO>();
	private Map<String, Object> session;

	public String execute() throws SQLException {
		UserListDAO userListDAO = new UserListDAO();
		userListDTOList = userListDAO.getUserList();
		String result = SUCCESS;
		return result;
	}

	public List<UserListDTO> getUserListDTOList() {
		return userListDTOList;
	}
	public void setUserInfoDTOList(List<UserListDTO> userListDTOList) {
		this.userListDTOList = userListDTOList;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
}
