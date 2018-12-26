package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String result;
	private Map<String,Object> session;
	private List<ItemListDTO> itemListDTOList = new ArrayList<ItemListDTO>();

	public String execute()throws SQLException{
		LoginDAO loginDAO=new LoginDAO();
		LoginDTO loginDTO=new LoginDTO();

		result =ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser",loginDTO);

		if((((LoginDTO) session.get("loginUser")).getAdminFlg() != null)
				&& (((LoginDTO) session.get("loginUser")).getAdminFlg().equals("1"))) {
			result = "admin";
			session.put("admin", result);
		}else if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result=SUCCESS;

			ItemListDAO itemListDAO = new ItemListDAO();
			itemListDTOList = itemListDAO.getItemList();
			session.put("login_user_id", loginDTO.getLoginId());
			session.put("userName", loginDTO.getUserName());
			session.put("itemListDTOList", itemListDTOList);

			return result;
		}
		return result;
	}
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public List<ItemListDTO> getItemListDTOList(){
		return itemListDTOList;
	}
	public void setItemListDTOList(List<ItemListDTO> itemListDTOList){
		this.itemListDTOList=itemListDTOList;
	}
}
