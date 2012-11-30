package com.golf.entity;

import java.util.Date;

public class SmallCategory {
	private Category m_category;

	private int m_categoryId;

	private Date m_creationDate;

	private int m_id;

	private String m_name;

	public Category getCategory() {
		return m_category;
	}

	public int getCategoryId() {
		return m_categoryId;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public int getId() {
		return m_id;
	}

	public String getName() {
		return m_name;
	}

	public void setCategory(Category category) {
		m_category = category;
	}

	public void setCategoryId(int categoryId) {
		m_categoryId = categoryId;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setName(String name) {
		m_name = name;
	}

}
