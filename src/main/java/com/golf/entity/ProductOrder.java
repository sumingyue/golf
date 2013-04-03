package com.golf.entity;

import java.util.Date;

public class ProductOrder {

	private int m_id;

	private int m_productId;
	
	private Product m_product;

	private int m_orderNumber;

	private String m_userName;

	private String m_userPhone;

	private String m_userAddress;
	
	private int m_status;
	
	private String m_note;

	private Date m_date;

	public Date getDate() {
		return m_date;
	}

	public int getId() {
		return m_id;
	}

	public String getNote() {
		return m_note;
	}

	public int getOrderNumber() {
		return m_orderNumber;
	}

	public Product getProduct() {
		return m_product;
	}

	public int getProductId() {
		return m_productId;
	}

	public int getStatus() {
		return m_status;
	}

	public String getUserAddress() {
		return m_userAddress;
	}

	public String getUserName() {
		return m_userName;
	}

	public String getUserPhone() {
		return m_userPhone;
	}

	public void setDate(Date date) {
		m_date = date;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setNote(String note) {
		m_note = note;
	}

	public void setOrderNumber(int orderNumber) {
		m_orderNumber = orderNumber;
	}

	public void setProduct(Product product) {
		m_product = product;
	}

	public void setProductId(int productId) {
		m_productId = productId;
	}

	public void setStatus(int status) {
		m_status = status;
	}

	public void setUserAddress(String userAddress) {
		m_userAddress = userAddress;
	}

	public void setUserName(String userName) {
		m_userName = userName;
	}

	public void setUserPhone(String userPhone) {
		m_userPhone = userPhone;
	}

}
