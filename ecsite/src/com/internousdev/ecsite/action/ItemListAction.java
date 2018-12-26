package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport{

	private List<ItemListDTO> itemListDTOList = new ArrayList<ItemListDTO>();

	public String execute() throws SQLException{

		ItemListDAO itemListDAO = new ItemListDAO();
		itemListDTOList = itemListDAO.getItemList();
		String result = SUCCESS;
	return result;
}


	public List<ItemListDTO> getItemListDTOList(){
		return itemListDTOList;
	}
	public void setItemListDTOList(List<ItemListDTO> itemListDTOList){
		this.itemListDTOList=itemListDTOList;
	}
}
