package com.golf.entity;

import java.util.Date;

public class Adwords {
	private int m_id;

	private String m_position;

	private String m_name;

	private int m_width;

	private int m_height;

	private String m_url;

	private int m_imageId;

	private Date m_date;

	public int getId() {
		return m_id;
	}

	public void setId(int id) {
		m_id = id;
	}

	public String getPosition() {
		return m_position;
	}

	public void setPosition(String postion) {
		m_position = postion;
	}

	public String getName() {
		return m_name;
	}

	public void setName(String name) {
		m_name = name;
	}

	public int getWidth() {
		return m_width;
	}

	public void setWidth(int width) {
		m_width = width;
	}

	public int getHeight() {
		return m_height;
	}

	public void setHeight(int height) {
		m_height = height;
	}

	public String getUrl() {
		return m_url;
	}

	public void setUrl(String url) {
		m_url = url;
	}

	public int getImageId() {
		return m_imageId;
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public Date getDate() {
		return m_date;
	}

	public void setDate(Date date) {
		m_date = date;
	}

}
