package com.golf.entity;

import java.util.Date;

public class TravelHotel {

	private int m_id;

	private String m_province;

	private String m_city;

	private String m_name;

	private String m_des;

	private Date m_creationDate;

	public String getCity() {
		return m_city;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public String getDes() {
		return m_des;
	}

	public int getId() {
		return m_id;
	}

	public String getName() {
		return m_name;
	}

	public String getProvince() {
		return m_province;
	}

	public void setCity(String city) {
		m_city = city;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public void setDes(String des) {
		m_des = des;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setName(String name) {
		m_name = name;
	}

	public void setProvince(String province) {
		m_province = province;
	}

}
