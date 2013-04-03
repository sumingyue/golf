package com.golf.entity;

import java.util.Date;

public class CourtComments {

	private int m_id;

	private int m_courtId;

	private Court m_court;
	
	private String m_userName;

	private String m_content;

	private Date m_creationDate;

	public String getContent() {
		return m_content;
	}

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

	public String getUserName() {
		return m_userName;
	}

	public void setContent(String content) {
		m_content = content;
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

	public void setUserName(String userName) {
		m_userName = userName;
	}
	
}
