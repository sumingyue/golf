package com.golf.entity;

import java.util.Date;

public class Image {

	public static final int NEWS = 1;

	public static final int ADWORDS = 2;

	public static final int PRODUCT = 3;

	public static final int TEAM = 4;

	public static final int COURT = 5;

	public static final int OTHER = 6;

	private int m_id;

	private int m_type;

	private String m_name;

	private String m_path;

	private String m_storePath;

	private String m_netPath;

	private Date m_creationDate;

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

	public String getName() {
		return m_name;
	}

	public void setName(String name) {
		m_name = name;
	}

	public String getStorePath() {
		return m_storePath;
	}

	public void setStorePath(String storePath) {
		m_storePath = storePath;
	}

	public String getNetPath() {
		return m_netPath;
	}

	public void setNetPath(String netPath) {
		m_netPath = netPath;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public String getPath() {
		return m_path;
	}

	public void setPath(String path) {
		m_path = path;
	}

}
