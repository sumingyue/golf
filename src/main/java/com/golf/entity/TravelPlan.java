package com.golf.entity;

import java.util.Date;

public class TravelPlan {

	private int m_id;

	private int m_travelId;

	private Travel m_travel;

	private String m_name;

	private String m_content;

	private String m_des;

	private Date m_creationDate;

	public int getId() {
		return m_id;
	}

	public void setId(int id) {
		m_id = id;
	}

	public int getTravelId() {
		return m_travelId;
	}

	public void setTravelId(int travelId) {
		m_travelId = travelId;
	}

	public Travel getTravel() {
		return m_travel;
	}

	public void setTravel(Travel travel) {
		m_travel = travel;
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

	public String getDes() {
		return m_des;
	}

	public void setDes(String des) {
		m_des = des;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

}
