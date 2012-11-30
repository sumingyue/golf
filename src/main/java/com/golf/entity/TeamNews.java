package com.golf.entity;

import java.util.Date;

public class TeamNews {
	private int m_id;

	private int m_teamId;

	private Team m_team;
	
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

	public int getTeamId() {
		return m_teamId;
	}

	public void setTeamId(int teamId) {
		m_teamId = teamId;
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

	public Team getTeam() {
		return m_team;
	}

	public void setTeam(Team team) {
		m_team = team;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

}
