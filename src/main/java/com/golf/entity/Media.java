package com.golf.entity;

import java.util.Date;

public class Media {

	private int m_id;

	private String m_type;

	private String m_name;

	private String m_url;

	private Date m_date;

	public Date getDate() {
		return m_date;
	}

	public int getId() {
		return m_id;
	}

	public String getName() {
		return m_name;
	}

	public String getType() {
		return m_type;
	}

	public String getUrl() {
		return m_url;
	}

	public void setDate(Date date) {
		m_date = date;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setName(String name) {
		m_name = name;
	}

	public void setType(String type) {
		m_type = type;
	}

	public void setUrl(String url) {
		m_url = url;
	}

}
