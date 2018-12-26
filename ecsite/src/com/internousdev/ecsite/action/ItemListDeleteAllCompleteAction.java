package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteAllCompleteAction extends ActionSupport{

	public String deleteFlg;
	public Map<String,Object> session;
	private String result;
	private String message;

	public String execute() throws SQLException{
		ItemListDeleteCompleteDAO itemListDeleteCompleteDAO=new ItemListDeleteCompleteDAO();

		int res=itemListDeleteCompleteDAO.ItemListAllDelete();

		if(res>0){
			message = ( "商品情報を全て削除しました。");
		}else if(res==0){
			message = ("商品情報の削除に失敗しました");
		}

		result = SUCCESS;
		return result;
	}
	public String getDeleteFlg(){
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message=message;
	}
}
