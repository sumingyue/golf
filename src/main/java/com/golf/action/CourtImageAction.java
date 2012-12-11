package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.golf.Config;
import com.golf.entity.Court;
import com.golf.entity.CourtImage;
import com.golf.entity.Image;
import com.golf.entity.UploadFile;
import com.golf.service.CourtImageService;
import com.golf.service.CourtService;
import com.golf.service.ImageService;
import com.golf.tools.ImageTools;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class CourtImageAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(CourtImageAction.class);

	private List<CourtImage> m_courtImages;

	private int m_courtImageId;

	private CourtService m_courtService;

	private List<Court> m_courts;

	private int m_courtId;

	private CourtImageService m_courtImageService;

	private CourtImage m_courtImage = new CourtImage();

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

		return m_imageService.insert(m_upload, m_uploadFile, Image.COURT, Image.COURT_WIDTH, Image.COURT_HEIGHT, true,
		      Image.COURT_SMALL_WIDTH, Image.COURT_SMALL_HEIGHT);
	}

	public String courtImageList() {
		try {
			//m_courts = m_courtService.queryAllCourts();
			//m_pagedTool.setTotalNumber(m_courtImageService.queryAllCourtImages(m_courtId).size());
			//m_courtImages = m_courtImageService.queryPagedCourtImages(m_pagedTool, m_courtId);
			m_courtImages = m_courtImageService.queryAllCourtImages(0);
			for (CourtImage temp : m_courtImages) {
				temp.setImage(m_imageService.findImage(temp.getImageId()));
				temp.setCourt(m_courtService.findCourt(temp.getCourtId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String courtImageAdd() {
		m_courts = m_courtService.queryAllCourts();
		return SUCCESS;
	}

	public String courtImageAddSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage();
				m_courtImage.setImageId(imageId);
			}
			int id = m_courtImageService.insertCourtImage(m_courtImage);
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

	public String courtImageUpdate() {
		m_courts = m_courtService.queryAllCourts();
		try {
			m_courtImage = m_courtImageService.findCourtImage(m_courtImageId);
			m_courtImage.setImage(m_imageService.findImage(m_courtImage.getImageId()));
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String courtImageUpdateSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage();
				m_courtImage.setImageId(imageId);
			} else {
				m_courtImage.setImageId(m_courtImageService.findCourtImage(m_courtImage.getId()).getImageId());
			}
			int count = m_courtImageService.updateCourtImage(m_courtImage);
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

	public String courtImageDelete() {
		try {
			int count = m_courtImageService.deleteCourtImage(m_courtImageId);
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

	public CourtImage getCourtImage() {
		return m_courtImage;
	}

	public void setCourtImage(CourtImage courtImage) {
		m_courtImage = courtImage;
	}

	public void setCourtImageService(CourtImageService courtImageService) {
		m_courtImageService = courtImageService;
	}

	public List<CourtImage> getCourtImages() {
		return m_courtImages;
	}

	public void setCourtImageId(int courtImageId) {
		m_courtImageId = courtImageId;
	}

	public List<Court> getCourts() {
		return m_courts;
	}

	public void setCourtService(CourtService courtService) {
		m_courtService = courtService;
	}

	public int getCourtId() {
		return m_courtId;
	}

	public void setCourtId(int courtId) {
		m_courtId = courtId;
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