package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	public String deleteFlg;
	private String message;
	private ArrayList<MyPageDTO> myPageList=new ArrayList<MyPageDTO>();
	private String insert_date;
	private String itemId;

	public String execute() throws SQLException{
		MyPageDAO myPageDAO=new MyPageDAO();

		if(!session.containsKey("loginUser")){
			return ERROR;
		}
		if(deleteFlg==null){

			String user_master_id=session.get("login_user_id").toString();
			myPageList=myPageDAO.getMyPageUserInfo( user_master_id);

		}else if(deleteFlg.equals("1")){
			delete();
		}
		String result=SUCCESS;
		return result;
	}
	public void delete() throws SQLException{
		MyPageDAO myPageDAO=new MyPageDAO();
		session.put("itemId", itemId);
		session.put("insert_date", insert_date);

		String item_transaction_id=session.get("itemId").toString();
		String user_master_id=session.get("login_user_id").toString();
		String insert_date=session.get("insert_date").toString();

		int res=myPageDAO.buyItemHistoryDelete(item_transaction_id,user_master_id,insert_date);

		if(res>0){
			myPageList=null;
			message = ("商品情報を正しく削除しました。");
		}else if(res==0){
			message = ("商品情報の削除に失敗しました。");
		}
	}
	public String getDeleteFlg() {
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public ArrayList<MyPageDTO> getMyPageList(){
		return this.myPageList;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message=message;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

}
