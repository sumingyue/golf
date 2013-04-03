package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.golf.Config;
import com.golf.entity.TravelHotel;
import com.golf.entity.TravelHotelImage;
import com.golf.entity.Image;
import com.golf.entity.UploadFile;
import com.golf.service.TravelHotelImageService;
import com.golf.service.TravelHotelService;
import com.golf.service.ImageService;
import com.golf.tools.ImageTools;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class TravelHotelImageAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;
	
	private static final String LIST="travelHotelImageList.do";
	
	private Logger m_logger = Logger.getLogger(TravelHotelImageAction.class);

	private List<TravelHotelImage> m_travelHotelImages;

	private int m_travelHotelImageId;

	private TravelHotelService m_travelHotelService;

	private List<TravelHotel> m_travelHotels;

	private int m_travelHotelId;

	private TravelHotelImageService m_travelHotelImageService;

	private TravelHotelImage m_travelHotelImage = new TravelHotelImage();

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private UploadFile[] m_uploadFiles = new UploadFile[5];

	private File m_upload;

	private File[] m_uploads = new File[5];

	private String[] m_des = new String[5];

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String getActionList(){
		return LIST;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public int getTravelHotelId() {
		return m_travelHotelId;
	}

	public TravelHotelImage getTravelHotelImage() {
		return m_travelHotelImage;
	}

	public List<TravelHotelImage> getTravelHotelImages() {
		return m_travelHotelImages;
	}

	public List<TravelHotel> getTravelHotels() {
		return m_travelHotels;
	}

	private int insertImage(File upload,UploadFile uploadFile) {
		String fileName = uploadFile.getFilename();
		String relativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_normal", Image.COURT);
		String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;

		String compressRelativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_small", Image.COURT);
		String compressStorePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + compressRelativePath;

		String originalPath = ImageTools.getOriginalPath(fileName, Image.COURT);
		uploadFile.setOriginalPath(originalPath);

		uploadFile.setPath(relativePath);
		uploadFile.setStorePath(storePath);

		uploadFile.setCompressedPath(compressRelativePath);
		uploadFile.setCompressedStorePath(compressStorePath);

		return m_imageService.insert(upload, uploadFile, Image.COURT, Image.COURT_WIDTH, Image.COURT_HEIGHT, true,
		      Image.COURT_SMALL_WIDTH, Image.COURT_SMALL_HEIGHT);
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

	public void setTravelHotelId(int travelHotelId) {
		m_travelHotelId = travelHotelId;
	}

	public void setTravelHotelImage(TravelHotelImage travelHotelImage) {
		m_travelHotelImage = travelHotelImage;
	}

	public void setTravelHotelImageId(int travelHotelImageId) {
		m_travelHotelImageId = travelHotelImageId;
	}

	public void setTravelHotelImageService(TravelHotelImageService travelHotelImageService) {
		m_travelHotelImageService = travelHotelImageService;
	}

	public void setTravelHotelService(TravelHotelService travelHotelService) {
		m_travelHotelService = travelHotelService;
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

	public String travelHotelImageAdd() {
		m_travelHotels = m_travelHotelService.queryAllTravelHotels();
		return SUCCESS;
	}

	public String travelHotelImageAddSubmit() {
		int size = m_uploads.length;

		String result = SUCCESS;

		for (int i = 0; i < size; i++) {
			try {
				TravelHotelImage temp = new TravelHotelImage();
				File file = m_uploads[i];

				if (file != null) {
					String des = "";
					if (m_des.length < i) {
						des = "";
					} else {
						des = m_des[i];
					}
					int imageId = insertImage(file,m_uploadFiles[i]);

					temp.setTravelHotelId(m_travelHotelImage.getTravelHotelId());
					temp.setImageDes(des);
					temp.setImageId(imageId);
					
					int id = m_travelHotelImageService.insertTravelHotelImage(temp);
					
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

	public String travelHotelImageDelete() {
		try {
			int count = m_travelHotelImageService.deleteTravelHotelImage(m_travelHotelImageId);
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

	public String travelHotelImageList() {
		try {
			m_travelHotelImages = m_travelHotelImageService.queryAllTravelHotelImages(0);
			for (TravelHotelImage temp : m_travelHotelImages) {
				temp.setImage(m_imageService.findImage(temp.getImageId()));
				temp.setTravelHotel(m_travelHotelService.findTravelHotel(temp.getTravelHotelId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String travelHotelImageUpdate() {
		m_travelHotels = m_travelHotelService.queryAllTravelHotels();
		try {
			m_travelHotelImage = m_travelHotelImageService.findTravelHotelImage(m_travelHotelImageId);
			m_travelHotelImage.setImage(m_imageService.findImage(m_travelHotelImage.getImageId()));
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String travelHotelImageUpdateSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage(m_upload,m_uploadFile);
				m_travelHotelImage.setImageId(imageId);
			} else {
				m_travelHotelImage.setImageId(m_travelHotelImageService.findTravelHotelImage(m_travelHotelImage.getId()).getImageId());
			}
			int count = m_travelHotelImageService.updateTravelHotelImage(m_travelHotelImage);
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

}