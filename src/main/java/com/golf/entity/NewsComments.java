package com.golf.entity;

import java.util.Date;

public class NewsComments {
	private int m_id;

	private int m_newsId;

	private String m_userName;

	private String m_content;

	private Date m_creationDate;

	public int getId() {
		return m_id;
	}

	public void setId(int id) {
		m_id = id;
	}

	public int getNewsId() {
		return m_newsId;
	}

	public void setNewsId(int newsId) {
		m_newsId = newsId;
	}

	public String getUserName() {
		return m_userName;
	}

	public void setUserName(String userName) {
		m_userName = userName;
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
