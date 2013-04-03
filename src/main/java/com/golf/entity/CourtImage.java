package com.golf.entity;

import java.util.Date;

public class CourtImage {
	private int m_id;

	private int m_imageId;

	private Image m_image;
	
	private Court m_court;

	private int m_courtId;

	private String m_imageDes;

	private Date m_creationDate;

	public Court getCourt() {
		return m_court;
	}

	public int getCourtId() {
		return m_courtId;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public int getId() {
		return m_id;
	}

	public Image getImage() {
		return m_image;
	}

	public String getImageDes() {
		return m_imageDes;
	}

	public int getImageId() {
		return m_imageId;
	}

	public void setCourt(Court court) {
		m_court = court;
	}

	public void setCourtId(int courtId) {
		m_courtId = courtId;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setImage(Image image) {
		m_image = image;
	}

	public void setImageDes(String imageDes) {
		m_imageDes = imageDes;
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}
	
}
