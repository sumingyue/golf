package com.golf.entity;

import java.util.Date;


public class ImageSpecial {

	private int m_id;

	private String m_name;

	private String m_content;

	private int m_imageId;

	private Image m_image;

	private Date m_creationDate;

	public int getId() {
		return m_id;
	}

	public void setId(int id) {
		m_id = id;
	}

	public String getName() {
		return m_name;
	}

	public void setName(String name) {
		m_name = name;
	}

	public String getContent() {
		return m_content;
	}

	public void setContent(String content) {
		m_content = content;
	}

	public int getImageId() {
		return m_imageId;
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public Image getImage() {
		return m_image;
	}

	public void setImage(Image image) {
		m_image = image;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

}
