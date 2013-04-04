package com.golf.action;

import java.io.File;

import com.golf.entity.ImageType;
import com.golf.entity.UploadFile;
import com.golf.service.ImageService;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	private static final long serialVersionUID = 2801256589554299998L;

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private File m_upload;

	@Override
	public String execute() throws Exception {
		try {
			m_imageService.insert(m_upload, m_uploadFile, ImageType.NEWS);
		} catch (Exception e) {
			addActionError(e.getMessage());
			return ERROR;
		}
		addActionMessage("Upload Success!");
		return SUCCESS;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setUpload(File file) {
		m_upload = file;
	}

	public void setUploadContentType(String contentType) {
		m_uploadFile.setContentType(contentType);
	}

	public void setUploadFileName(String filename) {
		m_uploadFile.setFilename(filename);
	}

}