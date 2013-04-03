package com.golf.entity;

import java.util.Date;

public class TravelLog {
	private int m_id;

	private int m_travelId;

	private Travel m_travel;

	private int m_type;

	private String m_title;

	private String m_content;

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

	public int getType() {
		return m_type;
	}

	public void setType(int type) {
		m_type = type;
	}

	public String getTitle() {
		return m_title;
	}

	public void setTitle(String title) {
		m_title = title;
	}

	public String getContent() {
		return m_content;
	}

	public void setContent(String content) {
		m_content = content;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

}
