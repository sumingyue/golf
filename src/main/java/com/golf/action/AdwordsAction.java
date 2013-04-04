package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.Adwords;
import com.golf.entity.ImageType;
import com.golf.entity.UploadFile;
import com.golf.service.AdwordsService;
import com.golf.service.ImageService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class AdwordsAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(AdwordsAction.class);

	private List<Adwords> m_adwordss;

	private int m_adwordsId;

	private AdwordsService m_adwordsService;

	private ImageService m_imageService;

	private Adwords m_adwords = new Adwords();

	private UploadFile m_uploadFile = new UploadFile();

	private File m_upload;

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String adwordsAddSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage(m_adwords);
				m_adwords.setImageId(imageId);
			}
			int id = m_adwordsService.insertAdwords(m_adwords);
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

	public String adwordsDelete() {
		try {
			int count = m_adwordsService.deleteAdwords(m_adwordsId);
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

	public String adwordsList() {
		try {
			// m_pagedTool.setTotalNumber(m_adwordsService.queryAllAdwordss().size());
			// m_adwordss = m_adwordsService.queryPagedAdwordss(m_pagedTool);
			m_adwordss = m_adwordsService.queryAllAdwordss();
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String adwordsUpdate() {
		try {
			m_adwords = m_adwordsService.findAdwords(m_adwordsId);
			m_adwords.setImage(m_imageService.findImage(m_adwords.getImageId()));
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String adwordsUpdateSubmit() {
		try {
			Adwords last = m_adwordsService.findAdwords(m_adwords.getId());

			if (m_upload != null) {
				int imageId = insertImage(m_adwords);
				m_adwords.setImageId(imageId);
			} else {
				m_adwords.setImageId(last.getImageId());
			}
			int count = m_adwordsService.updateAdwords(m_adwords);
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

	public Adwords getAdwords() {
		return m_adwords;
	}

	public List<Adwords> getAdwordss() {
		return m_adwordss;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	private int insertImage(Adwords adwords) {
		return m_imageService.insert(m_upload, m_uploadFile, ImageType.ADWORDS);
	}

	public void setAdwords(Adwords adwords) {
		m_adwords = adwords;
	}

	public void setAdwordsId(int adwordsId) {
		m_adwordsId = adwordsId;
	}

	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setIndex(int index) {
		m_pagedTool.setPageIndex(index);
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
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