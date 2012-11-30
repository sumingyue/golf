package com.golf.entity;

import java.util.Date;

public class Category {

	private Date m_creationDate;

	private int m_id;

	private String m_name;

	public Date getCreationDate() {
		return m_creationDate;
	}

	public int getId() {
		return m_id;
	}

	public String getName() {
		return m_name;
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
