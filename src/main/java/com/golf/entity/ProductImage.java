package com.golf.entity;

import java.util.Date;

public class ProductImage {

	private int m_id;
	
	private int m_productId;

	private int m_imageId;

	private Date m_creationDate;

	public int getProductId() {
		return m_productId;
	}

	public void setProductId(int productId) {
		m_productId = productId;
	}

	public int getImageId() {
		return m_imageId;
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public int getId() {
		return m_id;
	}

	public void setId(int id) {
		m_id = id;
	}

}
