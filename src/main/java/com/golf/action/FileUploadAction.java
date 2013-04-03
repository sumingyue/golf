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
			String fileName = m_uploadFile.getFilename();
			String relativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_normal", Image.NEWS);
			String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;

			String compressRelativePath = Config.IMAGE_PATH
			      + ImageTools.getImageStorePath(fileName, "_small", Image.NEWS);
			String compressStorePath = ServletActionContext.getServletContext().getRealPath("/") + "/"
			      + compressRelativePath;

			String originalPath = ImageTools.getOriginalPath(fileName, Image.NEWS);
			m_uploadFile.setOriginalPath(originalPath);

			m_uploadFile.setPath(relativePath);
			m_uploadFile.setStorePath(storePath);

			m_uploadFile.setCompressedPath(compressRelativePath);
			m_uploadFile.setCompressedStorePath(compressStorePath);

			m_imageService.insert(m_upload, m_uploadFile, Image.NEWS, Image.NEWS_WIDTH, Image.NEWS_HEIGHT, true,
			      Image.NEWS_SMALL_WIDTH, Image.NEWS_SMALL_HEIGHT);
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