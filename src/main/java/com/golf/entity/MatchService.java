package com.golf.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MatchService {

	private int m_id;

	private int m_number;

	private Date m_date;

	private String m_userName;

	private String m_userPhone;

	private String m_content;
	
	private int m_status;

	private Date m_creationDate;

	private SimpleDateFormat m_sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public int getId() {
		return m_id;
	}

	public void setId(int id) {
		m_id = id;
	}

	public int getNumber() {
		return m_number;
	}

	public void setNumber(int number) {
		m_number = number;
	}

	public String getDateStr(){
		return m_sdf.format(m_date);
	}
	
	public Date getDate() {
		return m_date;
	}

	public void setDate(Date date) {
		m_date = date;
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

	public String getContent() {
		return m_content;
	}

	public void setContent(String content) {
		m_content = content;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}
	
	public int getStatus() {
		return m_status;
	}

	public void setStatus(int status) {
		m_status = status;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

}
