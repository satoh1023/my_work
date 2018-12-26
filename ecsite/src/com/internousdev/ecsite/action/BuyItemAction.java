package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private int id;
	private String itemName;
	private int itemPrice;
	private int count;
	private String pay;
	private int itemStock;
	private String stockErrorMessage;

	public String execute(){
		String result=SUCCESS;
		session.put("id",id);
		session.put("itemName", itemName);
		session.put("itemPrice", itemPrice);
		session.put("count", count);

		int intStock=itemStock - count;
		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("itemPrice").toString());

		if(intStock < 0){
			stockErrorMessage = "在庫がありません";
			return ERROR;
		}else{
			stockErrorMessage = null;
		}
		session.put("itemStock",intStock);
		session.put("total_price",intCount * intPrice);
		String payment;
		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay", payment);
		}else{
			payment="クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count=count;
	}
	public String getPay(){
		return pay;
	}
	public void setPay(String pay){
		this.pay=pay;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public int getItemStock() {
		return itemStock;
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}
	public String getStockErrorMessage() {
		return stockErrorMessage;
	}
	public void setStockErrorMessage(String stockErrorMessage) {
		this.stockErrorMessage = stockErrorMessage;
	}
}
