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
	
	private Image m_image;

	private Date m_date;

	public Date getDate() {
		return m_date;
	}

	public int getHeight() {
		return m_height;
	}

	public int getId() {
		return m_id;
	}

	public Image getImage() {
		return m_image;
	}

	public int getImageId() {
		return m_imageId;
	}

	public String getName() {
		return m_name;
	}

	public String getPosition() {
		return m_position;
	}

	public String getUrl() {
		return m_url;
	}

	public int getWidth() {
		return m_width;
	}

	public void setDate(Date date) {
		m_date = date;
	}

	public void setHeight(int height) {
		m_height = height;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setImage(Image image) {
		m_image = image;
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public void setName(String name) {
		m_name = name;
	}

	public void setPosition(String postion) {
		m_position = postion;
	}

	public void setUrl(String url) {
		m_url = url;
	}

	public void setWidth(int width) {
		m_width = width;
	}

}
