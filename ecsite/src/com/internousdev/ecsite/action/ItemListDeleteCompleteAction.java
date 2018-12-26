package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport implements SessionAware{

	public String deleteFlg;
	public Map<String,Object> session;
	private String message;

	public String execute() throws SQLException{
		ItemListDeleteCompleteDAO itemListDeleteCompleteDAO=new ItemListDeleteCompleteDAO();

		String result = ERROR;
		int res=itemListDeleteCompleteDAO.ItemListDelete(session.get("dd").toString());

		if(res>0){
			message = ( "商品情報を削除しました。");
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
	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}
