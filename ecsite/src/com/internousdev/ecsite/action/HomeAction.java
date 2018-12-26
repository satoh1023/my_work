package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private List<ItemListDTO> itemListDTOList = new ArrayList<ItemListDTO>();

	public String execute() throws SQLException{
		String result="login";
		if(session.containsKey("loginUser")){
			ItemListDAO itemListDAO = new ItemListDAO();
			itemListDTOList = itemListDAO.getItemList();
			session.put("itemListDTOList", itemListDTOList);

			result=SUCCESS;
		}
		return result;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public List<ItemListDTO> getItemListDTOList(){
		return itemListDTOList;
	}
	public void setItemListDTOList(List<ItemListDTO> itemListDTOList){
		this.itemListDTOList=itemListDTOList;
	}
}
