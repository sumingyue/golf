package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.Court;
import com.golf.entity.CourtImage;
import com.golf.entity.ImageType;
import com.golf.entity.UploadFile;
import com.golf.service.CourtImageService;
import com.golf.service.CourtService;
import com.golf.service.ImageService;
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

	private UploadFile[] m_uploadFiles = new UploadFile[5];

	private File m_upload;

	private File[] m_uploads = new File[5];

	private String[] m_des = new String[5];

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String courtImageAdd() {
		m_courts = m_courtService.queryAllCourts();
		return SUCCESS;
	}

	public String courtImageAddSubmit() {
		int size = m_uploads.length;

		String result = SUCCESS;

		for (int i = 0; i < size; i++) {
			try {
				CourtImage temp = new CourtImage();
				File file = m_uploads[i];

				if (file != null) {
					String des = "";
					if (m_des.length < i) {
						des = "";
					} else {
						des = m_des[i];
					}
					int imageId = insertImage(file,m_uploadFiles[i]);

					temp.setCourtId(m_courtImage.getCourtId());
					temp.setImageDes(des);
					temp.setImageId(imageId);
					
					int id = m_courtImageService.insertCourtImage(temp);
					
					if (id <= 0) {
						result = ERROR;
					}
				}
			} catch (Exception e) {
				m_logger.error(e);
				result = ERROR;
			}
		}
		return result;
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

	public String courtImageList() {
		try {
			// m_courts = m_courtService.queryAllCourts();
			// m_pagedTool.setTotalNumber(m_courtImageService.queryAllCourtImages(m_courtId).size());
			// m_courtImages = m_courtImageService.queryPagedCourtImages(m_pagedTool, m_courtId);
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
				int imageId = insertImage(m_upload,m_uploadFile);
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

	public int getCourtId() {
		return m_courtId;
	}

	public CourtImage getCourtImage() {
		return m_courtImage;
	}

	public List<CourtImage> getCourtImages() {
		return m_courtImages;
	}

	public List<Court> getCourts() {
		return m_courts;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	private int insertImage(File upload,UploadFile uploadFile) {
		return m_imageService.insert(upload, uploadFile, ImageType.COURT);
	}

	public void setCourtId(int courtId) {
		m_courtId = courtId;
	}

	public void setCourtImage(CourtImage courtImage) {
		m_courtImage = courtImage;
	}

	public void setCourtImageId(int courtImageId) {
		m_courtImageId = courtImageId;
	}

	public void setCourtImageService(CourtImageService courtImageService) {
		m_courtImageService = courtImageService;
	}

	public void setCourtService(CourtService courtService) {
		m_courtService = courtService;
	}

	public void setDes(String[] des) {
		m_des = des;
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

	public void setUploads(File[] uploads) {
		m_uploads = uploads;
	}

	public void setUploadsContentType(String contentType) {
		String[] contentTypes = contentType.split(",");
		for(int i=0;i<contentTypes.length;i++){
			UploadFile upload = m_uploadFiles[i];
			if(upload==null){
				upload =new UploadFile();
				m_uploadFiles[i]= upload;
			}
			m_uploadFiles[i].setContentType(contentTypes[i]);
		}
	}

	public void setUploadsFileName(String filename) {
		String[] fileNames = filename.split(",");
		for(int i=0;i<fileNames.length;i++){
			UploadFile upload = m_uploadFiles[i];
			if(upload==null){
				upload =new UploadFile();
				m_uploadFiles[i]= upload;
			}
			m_uploadFiles[i].setFilename(fileNames[i]);
		}
	}

}