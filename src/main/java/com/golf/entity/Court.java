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

	public String getIntroduction() {
		return m_introduction;
	}

	public void setIntroduction(String introduction) {
		m_introduction = introduction;
	}

	public String getCustomIntro() {
		return m_customIntro;
	}

	public void setCustomIntro(String customIntro) {
		m_customIntro = customIntro;
	}

	public String getAwards() {
		return m_awards;
	}

	public void setAwards(String awards) {
		m_awards = awards;
	}

	public int getMapImageId() {
		return m_mapImageId;
	}

	public void setMapImageId(int mapImageId) {
		m_mapImageId = mapImageId;
	}

	public String getMapIntroduction() {
		return m_mapIntroduction;
	}

	public void setMapIntroduction(String mapIntroduction) {
		m_mapIntroduction = mapIntroduction;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public Image getMapImage() {
		return m_mapImage;
	}

	public void setMapImage(Image mapImage) {
		m_mapImage = mapImage;
	}

	public String getAddress() {
		return m_address;
	}

	public void setAddress(String address) {
		m_address = address;
	}

	public String getPhone() {
		return m_phone;
	}

	public void setPhone(String phone) {
		m_phone = phone;
	}

}
