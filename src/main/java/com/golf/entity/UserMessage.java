package com.golf.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserMessage {

	private int m_id;

	private String m_content;

	private String m_reply;

	private Date m_creationDate;

	public String getContent() {
		return m_content;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public String getCreationDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if (m_creationDate != null) {
			return sdf.format(m_creationDate);
		}
		return "";
	}

	public int getId() {
		return m_id;
	}

	public String getReply() {
		return m_reply;
	}

	public String getShortContent() {
		if (m_content != null && m_content.length() > 20) {
			return m_content.substring(0, 15) + "...";
		}
		return m_content;
	}

	public String getShortReply() {
		if (m_reply != null && m_reply.length() > 20) {
			return m_reply.substring(0, 15) + "...";
		}
		return m_reply;
	}

	public int getStatus() {
		if (m_reply != null && m_reply.length() > 0) {
			return 1;
		}
		return 0;
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

	public void setReply(String reply) {
		m_reply = reply;
	}
}
