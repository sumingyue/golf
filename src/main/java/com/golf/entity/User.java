package com.golf.entity;

import java.util.Date;

public class User {

	private String m_userName;

	private String m_password;

	private Date m_creationDate;

	public String getUserName() {
		return m_userName;
	}

	public void setUserName(String userName) {
		m_userName = userName;
	}

	public String getPassword() {
		return m_password;
	}

	public void setPassword(String password) {
		m_password = password;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

}
