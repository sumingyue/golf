package com.golf.entity;

import java.io.Serializable;

public class UploadFile implements Serializable {

	private static final long serialVersionUID = -1555299968770401677L;
	private Integer m_id;
	/**
	 * 上传时的文件名。
	 */
	private String m_filename;
	/**
	 * 文件存在服务器上相对路径。
	 */
	private String m_path;
	/**
	 * 文件存在服务器上的路径。
	 */
	private String m_storePath;
	/**
	 * 上传文件时所需的，是文件类型的表示。
	 */
	private String m_contentType;

	public Integer getId() {
		return m_id;
	}

	public void setId(Integer id) {
		this.m_id = id;
	}

	public String getFilename() {
		return m_filename;
	}

	public void setFilename(String filename) {
		this.m_filename = filename;
	}

	public String getStorePath() {
		return m_storePath;
	}

	public void setStorePath(String storePath) {
		this.m_storePath = storePath;
	}

	public String getContentType() {
		return m_contentType;
	}

	public void setContentType(String contentType) {
		this.m_contentType = contentType;
	}

	public String getPath() {
		return m_path;
	}

	public void setPath(String path) {
		m_path = path;
	}

}
