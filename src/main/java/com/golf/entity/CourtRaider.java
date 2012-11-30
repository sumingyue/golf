package com.golf.entity;

import java.util.Date;

public class CourtRaider {

	private int m_id;

	private int m_courtId;

	private String m_name;

	private int m_imageId;

	private Image m_image;
	
	private String m_indexName;

	private String m_des;

	private Date m_creationDate;

	
	public String getIndexName() {
		return m_indexName;
	}

	public void setIndexName(String indexName) {
		m_indexName = indexName;
	}

	public int getId() {
		return m_id;
	}

	public void setId(int id) {
		m_id = id;
	}

	public int getCourtId() {
		return m_courtId;
	}

	public void setCourtId(int courtId) {
		m_courtId = courtId;
	}

	public String getName() {
		return m_name;
	}

	public void setName(String name) {
		m_name = name;
	}

	public int getImageId() {
		return m_imageId;
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public String getDes() {
		return m_des;
	}

	public void setDes(String des) {
		m_des = des;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public Image getImage() {
		return m_image;
	}

	public void setImage(Image image) {
		m_image = image;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

}
