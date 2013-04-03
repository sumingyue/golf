package com.golf.entity;

import java.util.Date;

public class LearnClub {
	private int m_id;

	private int m_imageId;

	private Image m_image;

	private String m_name;

	private String m_address;

	private String m_phone;

	private String m_introduction;

	private Date m_creationDate;

	public String getAddress() {
		return m_address;
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

	public int getImageId() {
		return m_imageId;
	}

	public String getIntroduction() {
		return m_introduction;
	}

	public String getName() {
		return m_name;
	}

	public String getPhone() {
		return m_phone;
	}

	public void setAddress(String address) {
		m_address = address;
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

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public void setIntroduction(String introduction) {
		m_introduction = introduction;
	}

	public void setName(String name) {
		m_name = name;
	}

	public void setPhone(String phone) {
		m_phone = phone;
	}

}
