package com.golf.entity;

import java.util.Date;

public class Image {

	private int m_id;

	private int m_type;

	private String m_name;

	private String m_path;

	private String m_smallPath;

	private String m_originalPath;

	private String m_netPath;

	private Date m_creationDate;

	public Date getCreationDate() {
		return m_creationDate;
	}

	public int getId() {
		return m_id;
	}

	public String getName() {
		return m_name;
	}

	public String getNetPath() {
		return m_netPath;
	}

	public String getOriginalPath() {
		return m_originalPath;
	}

	public String getPath() {
		return m_path;
	}

	public String getSmallPath() {
		return m_smallPath;
	}

	public int getType() {
		return m_type;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setName(String name) {
		m_name = name;
	}

	public void setNetPath(String netPath) {
		m_netPath = netPath;
	}

	public void setOriginalPath(String originalPath) {
		m_originalPath = originalPath;
	}

	public void setPath(String path) {
		m_path = path;
	}

	public void setSmallPath(String compressPath) {
		m_smallPath = compressPath;
	}

	public void setType(int type) {
		m_type = type;
	}

}
