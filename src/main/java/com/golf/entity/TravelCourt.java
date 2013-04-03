package com.golf.entity;

import java.util.Date;

public class TravelCourt {

	private int m_id;

	private int m_travelId;

	private int m_courtId;

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

	public int getCourtId() {
		return m_courtId;
	}

	public void setCourtId(int courtId) {
		m_courtId = courtId;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

}
