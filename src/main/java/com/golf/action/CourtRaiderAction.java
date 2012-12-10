package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.golf.Config;
import com.golf.entity.Court;
import com.golf.entity.CourtRaider;
import com.golf.entity.Image;
import com.golf.entity.UploadFile;
import com.golf.service.CourtRaiderService;
import com.golf.service.CourtService;
import com.golf.service.ImageService;
import com.golf.tools.ImageTools;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class CourtRaiderAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(CourtRaiderAction.class);

	private List<CourtRaider> m_courtRaiders;

	private int m_courtRaiderId;

	private int m_courtId;

	private CourtService m_courtService;

	private List<Court> m_courts;

	private CourtRaiderService m_courtRaiderService;

	private CourtRaider m_courtRaider = new CourtRaider();

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private File m_upload;

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	private int insertImage() {
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

		return m_imageService.insert(m_upload, m_uploadFile, Image.COURT, Image.COURT_RAIDER_WIDTH,
		      Image.COURT_RAIDER_HEIGHT, false, 0, 0);
	}

	public String courtRaiderList() {
		try {
			m_courts = m_courtService.queryAllCourts();
			m_pagedTool.setTotalNumber(m_courtRaiderService.queryAllCourtRaiders(m_courtId).size());
			m_courtRaiders = m_courtRaiderService.queryPagedCourtRaiders(m_pagedTool, m_courtId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String courtRaiderAdd() {
		m_courts = m_courtService.queryAllCourts();
		return SUCCESS;
	}

	public String courtRaiderAddSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage();
				m_courtRaider.setImageId(imageId);
			}
			int id = m_courtRaiderService.insertCourtRaider(m_courtRaider);
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

	public String courtRaiderUpdate() {
		try {
			m_courts = m_courtService.queryAllCourts();
			m_courtRaider = m_courtRaiderService.findCourtRaider(m_courtRaiderId);
			if (m_courtRaider != null) {
				m_courtRaider.setImage(m_imageService.findImage(m_courtRaider.getImageId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String courtRaiderUpdateSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage();
				m_courtRaider.setImageId(imageId);
			} else {
				m_courtRaider.setImageId(m_courtRaiderService.findCourtRaider(m_courtRaider.getId()).getImageId());
			}
			int count = m_courtRaiderService.updateCourtRaider(m_courtRaider);
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

	public String courtRaiderDelete() {
		try {
			int count = m_courtRaiderService.deleteCourtRaider(m_courtRaiderId);
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

	public CourtRaider getCourtRaider() {
		return m_courtRaider;
	}

	public void setCourtRaider(CourtRaider courtRaider) {
		m_courtRaider = courtRaider;
	}

	public void setCourtRaiderService(CourtRaiderService courtRaiderService) {
		m_courtRaiderService = courtRaiderService;
	}

	public List<CourtRaider> getCourtRaiders() {
		return m_courtRaiders;
	}

	public void setCourtRaiderId(int courtRaiderId) {
		m_courtRaiderId = courtRaiderId;
	}

	public int getCourtId() {
		return m_courtId;
	}

	public void setCourtId(int courtId) {
		m_courtId = courtId;
	}

	public void setCourtService(CourtService courtService) {
		m_courtService = courtService;
	}

	public List<Court> getCourts() {
		return m_courts;
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

	public void setIndex(int index) {
		m_pagedTool.setPageIndex(index);
	}

}