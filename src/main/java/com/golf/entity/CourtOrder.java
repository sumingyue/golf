package com.golf.entity;

import java.util.Date;

public class CourtOrder {

	private int m_id;

	private int m_type;

	private String courtName;

	private String m_date;

	private int m_number;

	private String m_userName;

	private String m_userPhone;

	private String m_note;

	private Date m_creationDate;
	
	private int m_status;
	
	public int getStatus() {
		return m_status;
	}

	public void setStatus(int status) {
		m_status = status;
	}

	public int getId() {
		return m_id;
	}

	public void setId(int id) {
		m_id = id;
	}

	public int getType() {
		return m_type;
	}

	public void setType(int type) {
		m_type = type;
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public String getDate() {
		return m_date;
	}

	public void setDate(String date) {
		m_date = date;
	}

	public int getNumber() {
		return m_number;
	}

	public void setNumber(int number) {
		m_number = number;
	}

	public String getUserName() {
		return m_userName;
	}

	public void setUserName(String userName) {
		m_userName = userName;
	}

	public String getUserPhone() {
		return m_userPhone;
	}

	public void setUserPhone(String userPhone) {
		m_userPhone = userPhone;
	}

	public String getNote() {
		return m_note;
	}

	public void setNote(String note) {
		m_note = note;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

}
