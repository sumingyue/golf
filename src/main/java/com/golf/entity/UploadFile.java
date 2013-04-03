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

	private String m_compressedPath;
	
	private String m_originalPath;

	/**
	 * 文件存在服务器上的路径。
	 */
	private String m_storePath;

	private String m_compressedStorePath;

	/**
	 * 上传文件时所需的，是文件类型的表示。
	 */
	private String m_contentType;

	public String getCompressedPath() {
		return m_compressedPath;
	}

	public String getCompressedStorePath() {
		return m_compressedStorePath;
	}

	public String getContentType() {
		return m_contentType;
	}

	public String getFilename() {
		return m_filename;
	}

	public Integer getId() {
		return m_id;
	}

	public String getOriginalPath() {
		return m_originalPath;
	}

	public String getPath() {
		return m_path;
	}

	public String getStorePath() {
		return m_storePath;
	}

	public void setCompressedPath(String compressedPath) {
		m_compressedPath = compressedPath;
	}

	public void setCompressedStorePath(String compressedStorPath) {
		m_compressedStorePath = compressedStorPath;
	}

	public void setContentType(String contentType) {
		this.m_contentType = contentType;
	}

	public void setFilename(String filename) {
		this.m_filename = filename;
	}

	public void setId(Integer id) {
		this.m_id = id;
	}

	public void setOriginalPath(String originalStore) {
		m_originalPath = originalStore;
	}

	public void setPath(String path) {
		m_path = path;
	}

	public void setStorePath(String storePath) {
		this.m_storePath = storePath;
	}
	

}
