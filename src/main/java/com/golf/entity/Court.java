package com.golf.entity;

import java.util.Date;

public class Court {

	private int m_id;

	private String m_name;

	private String m_address;

	private String m_phone;

	private String m_introduction;

	private String m_customIntro;

	private String m_awards;

	private int m_mapImageId;

	private Image m_mapImage;

	private String m_mapIntroduction;

	private Date m_creationDate;

	public String getAddress() {
		return m_address;
	}

	public String getAwards() {
		return m_awards;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public String getCustomIntro() {
		return m_customIntro;
	}

	public int getId() {
		return m_id;
	}

	public String getIntroduction() {
		return m_introduction;
	}

	public Image getMapImage() {
		return m_mapImage;
	}

	public int getMapImageId() {
		return m_mapImageId;
	}

	public String getMapIntroduction() {
		return m_mapIntroduction;
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

	public void setAwards(String awards) {
		m_awards = awards;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public void setCustomIntro(String customIntro) {
		m_customIntro = customIntro;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setIntroduction(String introduction) {
		m_introduction = introduction;
	}

	public void setMapImage(Image mapImage) {
		m_mapImage = mapImage;
	}

	public void setMapImageId(int mapImageId) {
		m_mapImageId = mapImageId;
	}

	public void setMapIntroduction(String mapIntroduction) {
		m_mapIntroduction = mapIntroduction;
	}

	public void setName(String name) {
		m_name = name;
	}

	public void setPhone(String phone) {
		m_phone = phone;
	}

}
