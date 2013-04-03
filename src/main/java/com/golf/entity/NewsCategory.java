package com.golf.entity;

import java.util.Date;

public class NewsCategory {

	private int m_newId;

	private int m_categoryId;

	private int m_smallCategoryId;

	private Date m_creationDate;

	public int getCategoryId() {
		return m_categoryId;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public int getNewId() {
		return m_newId;
	}

	public int getSmallCategoryId() {
		return m_smallCategoryId;
	}

	public void setCategoryId(int categoryId) {
		m_categoryId = categoryId;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public void setNewId(int newId) {
		m_newId = newId;
	}

	public void setSmallCategoryId(int smallCategoryId) {
		m_smallCategoryId = smallCategoryId;
	}

}
