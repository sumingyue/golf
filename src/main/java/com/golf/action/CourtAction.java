package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.golf.Config;
import com.golf.entity.Court;
import com.golf.entity.Image;
import com.golf.entity.UploadFile;
import com.golf.service.CourtService;
import com.golf.service.ImageService;
import com.golf.tools.ImageTools;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class CourtAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(CourtAction.class);

	private List<Court> m_courts;

	private int m_courtId;

	private CourtService m_courtService;

	private Court m_court = new Court();

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private File m_upload;

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String courtAddSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertCourtMapImage();
				m_court.setMapImageId(imageId);
			}
			int id = m_courtService.insertCourt(m_court);
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

	public String courtDelete() {
		try {
			int count = m_courtService.deleteCourt(m_courtId);
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

	public String courtList() {
		try {
			//m_pagedTool.setTotalNumber(m_courtService.queryAllCourts().size());
			//m_courts = m_courtService.queryPagedCourts(m_pagedTool);
			m_courts=m_courtService.queryAllCourts();
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String courtUpdate() {
		try {
			m_court = m_courtService.findCourt(m_courtId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String courtUpdateSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertCourtMapImage();
				m_court.setMapImageId(imageId);
			} else {
				m_court.setMapImageId(m_courtService.findCourt(m_court.getId()).getMapImageId());
			}
			int count = m_courtService.updateCourt(m_court);
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

	public Court getCourt() {
		return m_court;
	}

	public List<Court> getCourts() {
		return m_courts;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	private int insertCourtMapImage() {
		String fileName = m_uploadFile.getFilename();
		String relativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_normal", Image.COURT);
		String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;

		String compressRelativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_small", Image.COURT);
		String compressStorePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + compressRelativePath;

		String originalPath = ImageTools.getOriginalPath(fileName, Image.COURT);
		m_uploadFile.setOriginalPath(originalPath);

		m_uploadFile.setPath(relativePath);
		m_uploadFile.setStorePath(storePath);

		m_uploadFile.setCompressedPath(compressRelativePath);
		m_uploadFile.setCompressedStorePath(compressStorePath);

		return m_imageService.insert(m_upload, m_uploadFile, Image.COURT, Image.COURT_MAP_WIDTH, Image.COURT_MAP_HEIGHT, false,0,0);

	}

	public void setCourt(Court court) {
		m_court = court;
	}

	public void setCourtId(int courtId) {
		m_courtId = courtId;
	}

	public void setCourtService(CourtService courtService) {
		m_courtService = courtService;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
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