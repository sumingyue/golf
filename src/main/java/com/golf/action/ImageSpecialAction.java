package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.golf.Config;
import com.golf.entity.ImageSpecial;
import com.golf.entity.Image;
import com.golf.entity.UploadFile;
import com.golf.service.ImageSpecialService;
import com.golf.service.ImageService;
import com.golf.tools.ImageTools;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class ImageSpecialAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(ImageSpecialAction.class);

	private List<ImageSpecial> m_imageSpecials;

	private int m_imageSpecialId;

	private ImageSpecialService m_imageSpecialService;

	private ImageSpecial m_imageSpecial = new ImageSpecial();

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private File m_upload;

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String imageSpecialList() {
		try {
			m_pagedTool.setTotalNumber(m_imageSpecialService.queryAllImageSpecials().size());
			m_imageSpecials = m_imageSpecialService.queryPagedImageSpecials(m_pagedTool);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String imageSpecialAddSubmit() {
		try {
			if (m_upload != null) {
				String relativePath = Config.IMAGE_PATH
				      + ImageTools.getImageStorePath(m_uploadFile.getFilename(), Image.COURT);
				String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;

				m_uploadFile.setPath(relativePath);
				m_uploadFile.setStorePath(storePath);

				int imageId = m_imageService.insert(m_upload, m_uploadFile, Image.COURT);
				m_imageSpecial.setImageId(imageId);
			}
			int id = m_imageSpecialService.insertImageSpecial(m_imageSpecial);
			if (id > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}

		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String imageSpecialUpdate() {
		try {
			m_imageSpecial = m_imageSpecialService.findImageSpecial(m_imageSpecialId);
			m_imageSpecial.setImage(m_imageService.findImage(m_imageSpecial.getImageId()));
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String imageSpecialUpdateSubmit() {
		try {
			if (m_upload != null) {
				String relativePath = Config.IMAGE_PATH
				      + ImageTools.getImageStorePath(m_uploadFile.getFilename(), Image.COURT);
				String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;

				m_uploadFile.setPath(relativePath);
				m_uploadFile.setStorePath(storePath);

				int imageId = m_imageService.insert(m_upload, m_uploadFile, Image.COURT);
				m_imageSpecial.setImageId(imageId);
			} else {
				m_imageSpecial.setImageId(m_imageSpecialService.findImageSpecial(m_imageSpecial.getId()).getImageId());
			}
			int count = m_imageSpecialService.updateImageSpecial(m_imageSpecial);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String imageSpecialDelete() {
		try {
			int count = m_imageSpecialService.deleteImageSpecial(m_imageSpecialId);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public ImageSpecial getImageSpecial() {
		return m_imageSpecial;
	}

	public void setImageSpecial(ImageSpecial imageSpecial) {
		m_imageSpecial = imageSpecial;
	}

	public void setImageSpecialService(ImageSpecialService imageSpecialService) {
		m_imageSpecialService = imageSpecialService;
	}

	public List<ImageSpecial> getImageSpecials() {
		return m_imageSpecials;
	}

	public void setImageSpecialId(int imageSpecialId) {
		m_imageSpecialId = imageSpecialId;
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
	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setIndex(int index){
		m_pagedTool.setPageIndex(index);
	}

}