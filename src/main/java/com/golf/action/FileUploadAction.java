package com.golf.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.golf.Config;
import com.golf.entity.Image;
import com.golf.entity.UploadFile;
import com.golf.service.ImageService;
import com.golf.tools.ImageTools;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	private static final long serialVersionUID = 2801256589554299998L;

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private File m_upload;

	@Override
	public String execute() throws Exception {
		try {
			String relativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(m_uploadFile.getFilename(), Image.OTHER);
			String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;

			m_uploadFile.setPath(relativePath);
			m_uploadFile.setStorePath(storePath);
			m_imageService.insert(m_upload, m_uploadFile, Image.OTHER);
		} catch (Exception e) {
			addActionError(e.getMessage());
			return ERROR;
		}
		addActionMessage("Upload Success!");
		return SUCCESS;
	}

	public void setUpload(File file) {
		m_upload = file;
	}

	public void setUploadFileName(String filename) {
		m_uploadFile.setFilename(filename);
	}

	public void setUploadContentType(String contentType) {
		m_uploadFile.setContentType(contentType);
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

}