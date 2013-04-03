package com.golf.entity;

import java.util.Date;

import com.golf.Config;

public class TeamNews {
	private int m_id;

	private int m_teamId;

	private Team m_team;

	private int m_type;

	private String m_title;

	private String m_content;

	private Date m_creationDate;

	public String getContent() {
		return m_content;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public int getId() {
		return m_id;
	}

	public String getShortTitle() {
		if (m_title != null && m_title.length() > Config.DEFAULT_MAX_TITLE_LENGTH) {
			return m_title.substring(0, Config.DEFAULT_MAX_TITLE_LENGTH);
		}
		return m_title;
	}

	public Team getTeam() {
		return m_team;
	}

	public int getTeamId() {
		return m_teamId;
	}

	public String getTitle() {
		return m_title;
	}

	public int getType() {
		return m_type;
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

	public void setTeam(Team team) {
		m_team = team;
	}

	public void setTeamId(int teamId) {
		m_teamId = teamId;
	}

	public void setTitle(String title) {
		m_title = title;
	}

	public void setType(int type) {
		m_type = type;
	}

}
