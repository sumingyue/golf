package com.golf.entity;

import java.util.Date;

public class SpecialNews {

	private int m_id;

	private String m_title;

	private String m_content;

	private int m_viewNumber;

	private int m_priority;

	private Date m_creationDate;

	private Date m_modifyDate;

	public String getContent() {
		return m_content;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public int getId() {
		return m_id;
	}

	public Date getModifyDate() {
		return m_modifyDate;
	}

	public int getPriority() {
		return m_priority;
	}

	public String getTitle() {
		return m_title;
	}

	public int getViewNumber() {
		return m_viewNumber;
	}

	public void setContent(String content) {
		m_content = content;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setModifyDate(Date modifyDate) {
		m_modifyDate = modifyDate;
	}

	public void setPriority(int priority) {
		m_priority = priority;
	}

	public void setTitle(String title) {
		m_title = title;
	}

	public void setViewNumber(int viewNumber) {
		m_viewNumber = viewNumber;
	}

}
